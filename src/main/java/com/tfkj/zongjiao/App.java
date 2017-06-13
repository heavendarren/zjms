package com.tfkj.zongjiao;

import com.tfkj.zongjiao.frame.ConfigDialog;
import com.tfkj.zongjiao.frame.MainFrame;
import com.tfkj.zongjiao.util.PropertiesHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {



        Properties prop=PropertiesHelper.load();
         if(prop==null){
             //检查配置文件
            ConfigDialog configDialog=new ConfigDialog();
            if(!configDialog.isFinished()){
                System.exit(0);
            }
        }else{
             //检查数据库
             String dbhome= prop.getProperty("derbyhome");
             File file=new File(dbhome+"/zongjiao");

             if(!file.exists()){
                 JOptionPane.showMessageDialog(null,"数据库不存在，请联系管理员");
                 System.exit(0);
             }
         }
        //启动系统
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-context.xml");
        MainFrame mainFrame=new MainFrame(ctx);
        mainFrame.requestFocus();
    }
}
