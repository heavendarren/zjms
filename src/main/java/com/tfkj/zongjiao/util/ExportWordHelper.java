package com.tfkj.zongjiao.util;

import com.tfkj.zongjiao.panel.DataEditPanel1;
import com.tfkj.zongjiao.panel.DataEditPanel2;
import com.tfkj.zongjiao.service.RelgPerService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 根据模板导出word的工具
 * 本代码参考http://blog.csdn.net/zhanwentao2/article/details/7255432
 * Created by wangqingxiang on 2017/6/1.
 */
public class ExportWordHelper {

        private Configuration configuration = null;

        public ExportWordHelper(){
            configuration = new Configuration();
            configuration.setDefaultEncoding("UTF-8");
        }

        public static void main(String[] args) {
//            ExportWordHelper test = new ExportWordHelper();
//            test.createWord();
        }

        public String createWord1(DataEditPanel1 panel){
            try {
            	Map<String,Object> dataMap = getData1(panel);
            	//路径现在是相对路径
            	configuration.setClassForTemplateLoading(this.getClass(), "/ftl");
                //FTL文件所存在的位置
            	Template t=null;
            	t = configuration.getTemplate("tmp1.ftl"); //文件名
            	String fileName = dataMap.get("title").toString() + "_"+ panel.getName1().getText() + "_" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmss") + ".doc";
            	RelgPerService rs = new RelgPerService();
            	String filePath= rs.load().getProperty("outdir") + "/";
            	File outFile = new File(filePath+fileName);
            	Writer out = null;
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
                t.process(dataMap, out);
                out.close();
    			return fileName;
            } catch (Exception e) {
                e.printStackTrace();
    			return null;
            }

        }

        private Map<String,Object> getData1(DataEditPanel1 panel) {
            Map<String,Object> dataMap=new HashMap<String,Object>();

            String title = "";
        	if ("1".equals(panel.getIdentityCode().getText())) {
        		title = "天津市少数民族代表人士信息采集表";
        	} else if ("4".equals(panel.getIdentityCode().getText())) {
        		title = "天津市民族宗教干部队伍信息采集表";
        	} else if ("5".equals(panel.getIdentityCode().getText())) {
        		title = "天津市民族宗教工作信息员采集表";
        	}
            dataMap.put("title", title);
            dataMap.put("name", panel.getName1().getText());
            dataMap.put("sex", panel.getSex().getSelectedItem());
            dataMap.put("birth", panel.getBirth().getText());
            dataMap.put("nation", panel.getNation().getSelectedItem());
            dataMap.put("nativePlace", panel.getNativePlaceP().getSelectedItem().toString() + panel.getNativePlaceC().getSelectedItem() + panel.getNativePlaceA().getSelectedItem());
            dataMap.put("birthplace", panel.getBirthplaceP().getSelectedItem().toString()+panel.getBirthplaceC().getSelectedItem()+panel.getBirthplaceA().getSelectedItem());
            dataMap.put("politicsStatus", panel.getPoliticsStatus().getSelectedItem());
            dataMap.put("partyTime", panel.getPartyTime().getText());
            dataMap.put("startingWorkTime", panel.getStartingWorkTime().getText());
            dataMap.put("workUnitPosition", panel.getWorkUnitPosition().getText());
            dataMap.put("health", panel.getHealth().getText());
            dataMap.put("education", panel.getEducation().getSelectedItem());
            dataMap.put("school", panel.getSchool().getText());
            dataMap.put("proEducation", panel.getProEducation().getSelectedItem());
            dataMap.put("proSchool", panel.getProSchool().getText());
            dataMap.put("contact", panel.getContact().getText());
            dataMap.put("socialPosition", panel.getSocialPosition().getText());
            dataMap.put("resume", panel.getResume().getText());
            dataMap.put("winningRecord", panel.getWinningRecord().getText());
            dataMap.put("results", panel.getResults().getText());
            
            dataMap.put("photo", ImageBase64.GetImageStr(panel.getPhoto().getText()));

            
			return dataMap;

        }
        
        public String createWord2(DataEditPanel2 panel){
            try {
            	Map<String,Object> dataMap = getData2(panel);
            	//路径现在是相对路径
            	configuration.setClassForTemplateLoading(this.getClass(), "/ftl");
            	//FTL文件所存在的位置
            	Template t=null;
            	t = configuration.getTemplate("tmp2.ftl"); //文件名
            	String fileName = dataMap.get("title").toString() + "_"+ panel.getName1().getText() + "_" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmss") + ".doc";
            	RelgPerService rs = new RelgPerService();
            	String filePath= rs.load().getProperty("outdir") + "/";
            	File outFile = new File(filePath+fileName);
            	Writer out = null;
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
                t.process(dataMap, out);
                out.close();
    			return fileName;
            } catch (Exception e) {
                e.printStackTrace();
    			return null;
            }

        }

        private Map<String,Object> getData2(DataEditPanel2 panel) {
            Map<String,Object> dataMap=new HashMap<String,Object>();

            String title = "";
        	if ("2".equals(panel.getIdentityCode().getText())) {
        		title = "天津市宗教界代表人士信息采集表";
        	} else if ("3".equals(panel.getIdentityCode().getText())) {
        		title = "天津市宗教教职人员信息采集表";
        	}
            dataMap.put("title", title);
            dataMap.put("name", panel.getName1().getText());
            dataMap.put("relgName", panel.getRelgName().getText());
            dataMap.put("sex", panel.getSex().getSelectedItem());
            dataMap.put("birth", panel.getBirth().getText());
            dataMap.put("nation", panel.getNation().getSelectedItem());
            dataMap.put("nativePlace", panel.getNativePlaceP().getSelectedItem().toString() + panel.getNativePlaceC().getSelectedItem() + panel.getNativePlaceA().getSelectedItem());
            dataMap.put("birthplace", panel.getBirthplaceP().getSelectedItem().toString()+panel.getBirthplaceC().getSelectedItem()+panel.getBirthplaceA().getSelectedItem());
            dataMap.put("domicilePlace", panel.getDomicilePlaceP().getSelectedItem().toString()+panel.getDomicilePlaceC().getSelectedItem()+panel.getDomicilePlaceA().getSelectedItem());
            dataMap.put("religion", panel.getReligion().getSelectedItem());
            dataMap.put("relgIdentity", panel.getRelgIdentity().getText());
            dataMap.put("startingRelgTime", panel.getStartingRelgTime().getText());
            dataMap.put("reglPlace", panel.getReglPlace().getText());
            dataMap.put("relgPosition", panel.getRelgPosition().getText());
            dataMap.put("health", panel.getHealth().getText());
            dataMap.put("education", panel.getEducation().getSelectedItem());
            dataMap.put("school", panel.getSchool().getText());
            dataMap.put("reglEducation", panel.getReglEducation().getSelectedItem());
            dataMap.put("reglSchool", panel.getReglSchool().getText());
            dataMap.put("idCardNo", panel.getIdCardNo().getText());         
            dataMap.put("contact", panel.getContact().getText());
            dataMap.put("socialPosition", panel.getSocialPosition().getText());
            dataMap.put("resume", panel.getResume().getText());
            dataMap.put("winningRecord", panel.getWinningRecord().getText());
            dataMap.put("results", panel.getResults().getText());
            
            dataMap.put("photo", ImageBase64.GetImageStr(panel.getPhoto().getText()));
    
			return dataMap;

        }
    }
