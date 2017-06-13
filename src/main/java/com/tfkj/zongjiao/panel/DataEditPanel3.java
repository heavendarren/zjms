package com.tfkj.zongjiao.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wangqingxiang on 2017/5/18.
 */
public class DataEditPanel3 extends Container implements ActionListener {
    JLabel label1 = new JLabel("姓名");
    JLabel label2 = new JLabel("性别");
    JLabel label3 = new JLabel("出生年月");
    JLabel label4 = new JLabel("民族");
    JLabel label5 = new JLabel("籍贯");
    JLabel label6 = new JLabel("出生年月");
    JLabel label7 = new JLabel("出生地");
    JLabel label8 = new JLabel("政治面貌");
    JLabel label9 = new JLabel("入党时间");
    JLabel label10 = new JLabel("参加工作时间");
    JLabel label11 = new JLabel("工作单位及职务");
    JLabel label12 = new JLabel("健康状况");
    JLabel label13 = new JLabel("学历学位");
    JLabel label14 = new JLabel("全日制教育");
    JLabel label15 = new JLabel("在职教育");
    JLabel label16 = new JLabel("毕业院校及专业");
    JLabel label17 = new JLabel("毕业院校及专业");
    JLabel label18 = new JLabel("联系方式");
    JLabel label19 = new JLabel("社会职务");
    JLabel label20 = new JLabel("工作简历");
    JLabel label21 = new JLabel("获奖情况");
    JLabel label22 = new JLabel("主要业绩简述");

    JTextField text1 = new JTextField();
    JTextField text2 = new JTextField();
    JButton button1 = new JButton("保存");
    public DataEditPanel3(){
        //下面设定标签等的出现位置和高宽
        this.setBackground(Color.white);
        label1.setBounds(10,10,100,20);
        label2.setBounds(10, 40, 100, 20);
        text1.setBounds(110,10,200,20);
        text2.setBounds(110, 40, 200, 20);

        button1.addActionListener(this);//添加事件处理



        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(label7);
        this.add(label8);
        this.add(label9);
        this.add(label10);
        this.add(label11);
        this.add(label12);
        this.add(label13);
        this.add(label14);
        this.add(label15);
        this.add(label16);
        this.add(label17);
        this.add(label18);
        this.add(label19);
        this.add(label20);
        this.add(label21);
        this.add(label22);

        this.add(text1);
        this.add(text2);
        this.add(button1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
