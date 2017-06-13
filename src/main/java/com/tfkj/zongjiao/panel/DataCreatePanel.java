package com.tfkj.zongjiao.panel;

import com.tfkj.zongjiao.frame.MainFrame;
import com.tfkj.zongjiao.entity.RelgPer;
import com.tfkj.zongjiao.service.RelgPerService;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wangqingxiang on 2017/5/18.
 */
public class DataCreatePanel extends Container implements ActionListener {
    JButton button1 = new JButton("少数民族代表人士信息采集表");
    JButton button2 = new JButton("宗教界代表人士信息采集表");
    JButton button3 = new JButton("宗教教职人员信息采集表");
    JButton button4 = new JButton("民族宗教干部队伍信息采集表");
    JButton button5 = new JButton("民族宗教工作信息员采集表");
    protected RelgPer relgPer;

    public void setRelgPer(RelgPer relgPer) {
        this.relgPer = relgPer;
    }

    public RelgPer getRelgPer() {
        return relgPer;
    }

    MainFrame mainFrame;
    public DataCreatePanel(MainFrame mainFrame){
        //下面设定标签等的出现位置和高宽
        this.mainFrame=mainFrame;

        button1.setBounds(100,30,300,40);
        button2.setBounds(100, 80, 300, 40);
        button3.setBounds(100, 130, 300, 40);
        button4.setBounds(100, 180, 300, 40);
        button5.setBounds(100, 230, 300, 40);



        button1.addActionListener(this);//添加事件处理
        button2.addActionListener(this);//添加事件处理
        button3.addActionListener(this);//添加事件处理
        button4.addActionListener(this);//添加事件处理
        button5.addActionListener(this);//添加事件处理


        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //先将relgPer清空
        relgPer=new RelgPer();
        //打开新窗口
        double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
//        mainFrame.setVisible(false);

        //model =true  模态窗口，窗口不关闭，线程阻塞
        JDialog dialog  = new JDialog(mainFrame,true);
        dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        dialog.setLocation(new Point((int) (lx / 2) - 400, (int) (ly / 2) - 300));//设定窗口出现位置
        dialog.setSize(950, 650);//设定窗口大小

        //配置打开窗口
		JPanel panel;
		if (e.getSource().equals(button1)) {// 判断触发方法的按钮是哪个
			relgPer.setIdentityCode("1");
			panel = new DataEditPanel1(dialog, relgPer, false);
	        dialog.setTitle("少数民族代表人士信息采集表");
		} else if (e.getSource().equals(button2)) {
			relgPer.setIdentityCode("2");
			panel = new DataEditPanel2(dialog, relgPer, false);
	        dialog.setTitle("宗教界代表人士信息采集表");
		} else if (e.getSource().equals(button3)) {
			relgPer.setIdentityCode("3");
			panel = new DataEditPanel2(dialog, relgPer, false);
	        dialog.setTitle("宗教教职人员信息采集表");
		} else if (e.getSource().equals(button4)) {
			relgPer.setIdentityCode("4");
			panel = new DataEditPanel1(dialog, relgPer, false);
	        dialog.setTitle("民族宗教干部队伍信息采集表");
		} else {
			relgPer.setIdentityCode("5");
			panel = new DataEditPanel1(dialog, relgPer, false);
	        dialog.setTitle("民族宗教工作信息员采集表");
		}


        dialog.add(panel);
        dialog.setLocationRelativeTo(mainFrame);
        dialog.setVisible(true);  //显示对话框，窗口阻塞，不往下执行，只有等到对话框关闭了才往下执行。
        dialog.requestFocus();
        if (!mainFrame.isVisible()) {
            //主窗口重新打开，获取焦点
            mainFrame.setVisible(true);
            mainFrame.requestFocus();
        }
        //窗口关闭后，执行任务
        //赋值到对象，执行保存
        if (StringUtils.isNotEmpty(relgPer.getName())) {
            RelgPerService relgPerService=(RelgPerService)mainFrame.getCtx().getBean("relgPerService");
            relgPerService.save(relgPer);
        }

    }
}
