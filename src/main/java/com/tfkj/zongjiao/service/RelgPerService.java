/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.zongjiao.service;


import com.tfkj.zongjiao.dao.RelgPerDao;
import com.tfkj.zongjiao.entity.RelgPer;
import com.tfkj.zongjiao.entity.RelgPerExport;
import com.tfkj.zongjiao.util.FileUtils;
import com.tfkj.zongjiao.util.ImageBase64;
import com.tfkj.zongjiao.util.JaxbMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 民族宗教信息Service
 * @author lizhi
 * @version 2017-05-11
 */

public class RelgPerService  {

	private RelgPerDao relgPerDao;

	public RelgPerDao getRelgPerDao() {
		return relgPerDao;
	}

	public void setRelgPerDao(RelgPerDao relgPerDao) {
		this.relgPerDao = relgPerDao;
	}

	public RelgPer get(String id) {
		return relgPerDao.get(id);
	}
	
	public List<RelgPer> findList(RelgPer relgPer) {
		return relgPerDao.findList(relgPer);
	}
	
	public Properties load(){
    	String path  = "C:/Users/"+ System.getProperty("user.name");

//		String path = MainFrame.class.getProtectionDomain().getCodeSource().getLocation().getFile();
//    	path=path.substring(1,path.lastIndexOf("/"));
		Properties pro = new Properties();
        try{
         FileInputStream in=new FileInputStream( path+"/config.properties");
            pro.load(in);
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return pro;
	}
	@Transactional(readOnly = false)
	public void save(RelgPer relgPer) {
		String area = load().getProperty("areacode");




		relgPer.setUpdateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		relgPer.setUpdateBy(area);
		if (StringUtils.isBlank(relgPer.getId())) {

			relgPer.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			relgPer.setCreateBy(area);
			relgPer.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			relgPer.setDelFlag("0");
			relgPer.setRegion(area);
			relgPer.setCommitFlag("1");

			relgPer.setEnterTrml("0");
			relgPerDao.insert(relgPer);
		} else {
			relgPerDao.update(relgPer);
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(RelgPer relgPer) {
		relgPerDao.delete(relgPer);
	}
	
	public String getExportData() {
		String area =load().getProperty("areacode");
		return relgPerDao.getExportData(area);
	}

	/**
	 * 导出数据
	 * @param
	 * @return
	 */
	public String exportData(String filePath, String fileName) {
		try {
			String area = null;
			if (StringUtils.isBlank(fileName)) {
				area = load().getProperty("areacode");
				filePath= load().getProperty("outdir") + "/";
				fileName =area + "_" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmss")+".xml";
			}
            List<RelgPer> data = relgPerDao.export(area);
            for (RelgPer rp:data) {
            	if (StringUtils.isNotBlank(rp.getPhoto())) {
                    String img = rp.getPhoto();
                    File file = new File(img);
                    if (file.exists()) {
                        String photoString = ImageBase64.GetImageStr(img);
                        rp.setImgString(photoString);
                    }
            	}
            }
			RelgPerExport exportData=new RelgPerExport();
			exportData.setRelgPerList(data);
			String xmlvalue=JaxbMapper.toXml(exportData, "utf-8");

            if (FileUtils.createDirectory(filePath)) {
                FileOutputStream write = new FileOutputStream(filePath+fileName);
                write.write(xmlvalue.getBytes());
                write.close();
        		return fileName;
            } else {
        		return "err";
            }
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 导入数据全量
	 * @param
	 * @return
	 */
	@Transactional(readOnly = false)
	public boolean  importData(File file) {

		Properties pro=load();

		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
			BufferedReader read = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = read.readLine()) != null) {
				buffer.append(line);
			}

			RelgPerExport importData = JaxbMapper.fromXml(buffer.toString(),
					RelgPerExport.class);
			List<RelgPer> list = importData.getRelgPerList();
			String now=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String nowStr = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
			String backFilePath=pro.getProperty("backupdir") + "/";
			String backFileName =  "BAK_" + nowStr + ".xml";
			if(this.exportData(backFilePath,backFileName) == null){
				return false;
			}
			relgPerDao.deleteAll();
			String imagedir=pro.getProperty("imagedir") + "/";
			FileUtils.delFile(imagedir);


			for (RelgPer relgPer : list){
				String photoPath = relgPer.getPhoto();				
				if (StringUtils.isNotBlank(photoPath)){
		            String[] n = photoPath.split("/");
		            String fileName = n[n.length-1];
		            FileUtils.createDirectory(imagedir);
					ImageBase64.GenerateImage(relgPer.getImgString(),imagedir+fileName);
					relgPer.setPhoto(imagedir + fileName);
				}
				String area = pro.getProperty("areacode");
				relgPer.setCreateBy(area);
				relgPer.setUpdateBy(area);
				relgPer.setCreateDate(now);
				relgPer.setUpdateDate(now);				
				relgPerDao.insert(relgPer);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	/**
	 * 导入数据增量
	 * @param
	 * @return
	 */
	@Transactional(readOnly = false)
	public String  importDataInc (File file) {

		Properties pro=load();
		StringBuffer msg=new StringBuffer("");

		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
			BufferedReader read = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = read.readLine()) != null) {
				buffer.append(line);
			}

			RelgPerExport importData = JaxbMapper.fromXml(buffer.toString(),
					RelgPerExport.class);
			List<RelgPer> list = importData.getRelgPerList();
			Date now = new Date();
			String nowStr = DateFormatUtils.format(now, "yyyyMMddHHmmss");
			String backFilePath=pro.getProperty("backupdir") + "/";
			String backFileName =  "BAK_" + nowStr + ".xml";
			if(this.exportData(backFilePath,backFileName) == null){
				return "备份失败";
			}
			String imagedir=pro.getProperty("imagedir") + "/";

			for (RelgPer relgPer : list){


				//同id的数据删掉
				RelgPer rp = relgPerDao.get(relgPer.getId());
				if (rp!=null) {
					FileUtils.delFile(rp.getPhoto());
					relgPerDao.realDelete(rp);
				}
				//检查是否重复
				if(identifyExist(relgPer)){
					msg.append("数据重复，系统中已存在"+relgPer.getName()+"的数据"+"\n");
					continue;
				}



				String photoPath = relgPer.getPhoto();				
				if (StringUtils.isNotBlank(photoPath)){
		            String[] n = photoPath.split("/");
		            String fileName = n[n.length-1];
		            FileUtils.createDirectory(imagedir);
					ImageBase64.GenerateImage(relgPer.getImgString(),imagedir+fileName);
					relgPer.setPhoto(imagedir + fileName);
				}
				String area = pro.getProperty("areacode");
				relgPer.setCreateBy(area);
				relgPer.setUpdateBy(area);
				relgPer.setCreateDate(nowStr);
				relgPer.setUpdateDate(nowStr);
				relgPerDao.insert(relgPer);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

		return "OK";
	}
	public boolean identifyExist(RelgPer relgPer){
		RelgPer relgTemp=new RelgPer();
		relgTemp.setIdentityCode(relgPer.getIdentityCode());
		relgTemp.setIdCardNo(relgPer.getIdCardNo());
		List<RelgPer> relgPers=relgPerDao.findList(relgPer);
		if(relgPers!=null&&relgPers.size()>0){
			return true;
		}
		return false;
	}
	
	public List<Map<String, String>> getProvinceList() {
		return relgPerDao.getProvinceList();
	}
	
	public List<Map<String, String>> getCityList(String father) {
		return relgPerDao.getCityList(father);
	}
	
	public List<Map<String, String>> getAreaList(String father) {
		return relgPerDao.getAreaList(father);
	}
	
	public String savePhoto(File file) {
		try {
			if (file != null) {
				String pathName = file.getCanonicalPath();
				if (StringUtils.isNotBlank(pathName)) {
					String imagedir =load().getProperty("imagedir") + "/";
					FileUtils.createDirectory(imagedir);
					String savePath = imagedir + UUID.randomUUID().toString().replaceAll("-", "") + ".jpg";
					FileUtils.copyFileCover(pathName, savePath, true);
					return savePath;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public int getDataCount(RelgPer relgPer) {
		return relgPerDao.getDataCount(relgPer);
	}
	
}