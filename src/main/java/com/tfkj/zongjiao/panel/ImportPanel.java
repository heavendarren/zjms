package com.tfkj.zongjiao.panel;

import com.tfkj.zongjiao.frame.MainFrame;
import com.tfkj.zongjiao.service.RelgPerService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by wangqingxiang on 2017/5/18.
 */
public class ImportPanel extends Container implements ActionListener {

    JLabel label1 = new JLabel("选择文件");
    JTextField text1 = new JTextField();
    JButton button1 = new JButton("...");
    JButton button3 = new JButton("全量导入");
    JButton button2 = new JButton("增量导入");

    JFileChooser jfc = new JFileChooser();//文件选择器
    MainFrame mainFrame;

    public ImportPanel(MainFrame mainFrame){
        this.mainFrame=mainFrame;
        jfc.setCurrentDirectory(new File("c:\\"));//文件选择器的初始目录定为d盘
        label1.setBounds(10,60,100,30);
        text1.setBounds(110,60,200,30);
        button1.setBounds(320,60,50,30);
        button3.setBounds(110, 110, 100, 50);
        button2.setBounds(230, 110, 100, 50);
        button1.addActionListener(this);//添加事件处理
        button2.addActionListener(this);//添加事件处理
        button3.addActionListener(this);//添加事件处理

        this.add(label1);
        this.add(text1);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(jfc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(button1)) {//判断触发方法的按钮是哪个
            jfc.setFileSelectionMode(0);//设定只能选择到文件夹
            int state = jfc.showOpenDialog(null);//此句是打开文件选择器界面的触发语句
            if (state == 1) {
                return;//撤销则返回
            } else {
                File f = jfc.getSelectedFile();//f为选择到的目录
                text1.setText(f.getAbsolutePath());
            }
        }

        if (e.getSource().equals(button3)) {
            String filepath=text1.getText();

            if(filepath==null||filepath.length()==0){
                JOptionPane.showMessageDialog(null,"请选择文件");
                return;
            }

            //判断文件格式
            String path=text1.getText();
            if(!path.contains(".xml")){
                JOptionPane.showMessageDialog(null,"请选择正确的文件格式");
                return;
            }

            int r=JOptionPane.showConfirmDialog(null,"所有数据都会被覆盖，确认吗？","警告",0);
            if(r!=0){
                return ;
            }
            //调用service执行导入程序

            RelgPerService relgPerService=(RelgPerService)mainFrame.getCtx().getBean("relgPerService");
            boolean result=relgPerService.importData(jfc.getSelectedFile());

            //执行完毕，弹出窗口，告诉客户执行完成
            if(result){
                JOptionPane.showMessageDialog(null,"导入成功");
            }else{
                JOptionPane.showMessageDialog(null,"导入失败，请检查数据");
            }



        }
        
        if (e.getSource().equals(button2)) {
            String filepath=text1.getText();

            if(filepath==null||filepath.length()==0){
                JOptionPane.showMessageDialog(null,"请选择文件");
                return;
            }

            //判断文件格式
            String path=text1.getText();
            if(!path.contains(".xml")){
                JOptionPane.showMessageDialog(null,"请选择正确的文件格式");
                return;
            }

//            int r=JOptionPane.showConfirmDialog(null,"所有数据都会被覆盖，确认吗？","警告",0);
//            if(r!=0){
//                return ;
//            }
            //调用service执行导入程序

            RelgPerService relgPerService=(RelgPerService)mainFrame.getCtx().getBean("relgPerService");
            String result=relgPerService.importDataInc(jfc.getSelectedFile());

            //执行完毕，弹出窗口，告诉客户执行完成
            if(result.equals("OK")){
                JOptionPane.showMessageDialog(null,"导入成功");
            }else{
                JOptionPane.showMessageDialog(null,"导入失败，请检查数据，失败信息"+result);
            }



        }

    }
}
