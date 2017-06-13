package com.tfkj.zongjiao.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wangqingxiang on 2017/5/18.
 */
public class DataEditPanel extends Container implements ActionListener {

    JButton button1 = new JButton("天津市少数民族代表人士信息采集表");
    JButton button2 = new JButton("天津市宗教界代表人士信息采集表");
    JButton button3 = new JButton("天津市宗教教职人员信息采集表");
    JButton button4 = new JButton("天津市民族宗教干部队伍信息采集表");
    JButton button5 = new JButton("天津市民族宗教工作信息员采集表");
    public DataEditPanel(MainPanel mainPanel){
        //下面设定标签等的出现位置和高宽

        button1.setBounds(320,10,50,20);
        button2.setBounds(320, 40, 50, 20);
        button3.setBounds(400, 10, 70, 50);
        button3.setBounds(600, 10, 70, 50);

        button1.addActionListener(this);//添加事件处理
        button2.addActionListener(this);//添加事件处理
        button3.addActionListener(this);//添加事件处理
        button4.addActionListener(this);//添加事件处理


        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
