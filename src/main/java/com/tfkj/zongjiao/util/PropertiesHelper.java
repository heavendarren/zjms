package com.tfkj.zongjiao.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by wangqingxiang on 2017/5/22.
 */
public class PropertiesHelper {
    public static Properties load(){
        Properties pro = new Properties();
        try{
//            String filename=MainFrame.class.getResource("/").getPath().substring(1)+"config.properties";
        	String path  = "C:/Users/"+ System.getProperty("user.name");

            String filename  = path + "/config.properties";
            File file=new File(filename);
            if(!file.exists()){
                return null;
            }
            FileInputStream in = new FileInputStream(filename);
            pro.load(in);
            in.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return pro;
    }
    public static void store(Properties pro){
        try {
//            String filename=MainFrame.class.getResource("/").getPath().substring(1)+"config.properties";;
        	String path  = "C:/Users/"+ System.getProperty("user.name");

            String filename  = path + "/config.properties";
            File file=new File(filename);
            file.delete();

            FileOutputStream oFile = new FileOutputStream(filename, true);//true表示追加打开

            pro.store(oFile, "");
            oFile.close();
        } catch (Exception p) {
            p.printStackTrace();
        }
    }
}
