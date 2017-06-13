package com.tfkj.zongjiao.panel;

import com.tfkj.zongjiao.frame.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wangqingxiang on 2017/5/18.
 */
public class MainPanel extends JTabbedPane implements ActionListener {


    MainFrame mainFrame;
    public MainPanel(MainFrame mainFrame){
        this.mainFrame=mainFrame;

        DataEditPanel dataEditPanel=new DataEditPanel(this);
        DataCreatePanel dataCreatePanel=new DataCreatePanel(mainFrame);
        DataQueryPanel dataQueryPanel =new DataQueryPanel(mainFrame);
        ExportPanel exportPanel=new ExportPanel(mainFrame);
        ImportPanel importPanel=new ImportPanel(mainFrame);
        this.add("信息录入",dataCreatePanel);//添加布局2
        this.add("信息查询",dataQueryPanel);//添加布局2
//        this.add("信息编辑",dataEditPanel);//添加布局2
        this.add("信息导入",importPanel);//添加布局2
        this.add("信息导出",exportPanel);//添加布局2


    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

