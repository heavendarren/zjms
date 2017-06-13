package com.tfkj.zongjiao.panel;

import com.tfkj.zongjiao.frame.MainFrame;
import com.tfkj.zongjiao.service.RelgPerService;
import com.tfkj.zongjiao.util.PropertiesHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wangqingxiang on 2017/5/18.
 */
public class ExportPanel extends Container implements ActionListener {

    JLabel label1 = new JLabel("");
    JButton button3 = new JButton("导出");
    JLabel label2 = new JLabel("");
    JButton button1 = new JButton("刷新");

    
    MainFrame mainFrame;



    ExportPanel(MainFrame mainFrame){
        this.mainFrame=mainFrame;
        label1.setBounds(10,60,150,50);
        button3.setBounds(380, 20, 70, 50);
        button3.addActionListener(this);//添加事件处理
        button1.setBounds(290, 20, 70, 50);
        button1.addActionListener(this);//添加事件处理
        
        

        this.add(label1);
        this.add(button1);
        this.add(button3);
        
        label2.setBounds(100,20,200,50);
        label2.setFont(new Font("Dialog",   1,   15));
        RelgPerService relgPerService=(RelgPerService)mainFrame.getCtx().getBean("relgPerService");
        String dataCount = relgPerService.getExportData();
        label2.setText("共"+ dataCount+"条数据将被导出。");
        
        this.add(label2);
 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource().equals(button1)) {
            RelgPerService relgPerService=(RelgPerService)mainFrame.getCtx().getBean("relgPerService");
            String dataCount = relgPerService.getExportData();
            label2.setText("共"+ dataCount+"条数据将被导出。");
            this.add(label2);

        }

        if (e.getSource().equals(button3)) {


            //调用service执行导出程序

            RelgPerService relgPerService=(RelgPerService)mainFrame.getCtx().getBean("relgPerService");
            String result=relgPerService.exportData("","");

            //执行完毕，弹出窗口，告诉客户执行完成
            if(result == null){
                JOptionPane.showMessageDialog(null,"导出失败，请联系管理员查看日志");
            }else if ("err".equals(result)) {
                JOptionPane.showMessageDialog(null,"导出失败，导出文件路径设置错误");
            } else {
				String filePath= PropertiesHelper.load().getProperty("outdir");
                JOptionPane.showMessageDialog(null,"导出成功。\r\n文件路径：" + filePath + "\r\n文件名：" + result);
            }



        }

    }
}
