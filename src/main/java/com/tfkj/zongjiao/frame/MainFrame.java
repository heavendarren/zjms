package com.tfkj.zongjiao.frame;

import com.tfkj.zongjiao.panel.MainPanel;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;


/**
 * Created by wangqingxiang on 2017/5/18.
 */
public class MainFrame extends JFrame{
    ApplicationContext ctx;
    MainPanel mainPanel;
    public MainFrame(ApplicationContext ctx){
        this.ctx=ctx;
        this.setTitle("天津市民族宗教人员信息管理系统");
        double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setLocation(new Point((int) (lx / 2) - 300, (int) (ly / 2) - 200));//设定窗口出现位置
        this.setSize(600, 400);//设定窗口大小
//        this.setContentPane(tabPane);//设置布局
        mainPanel=new MainPanel(this);
        this.setContentPane(mainPanel);//设置布局
        this.setVisible(true);//窗口可见
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//使能关闭窗口，结束程序
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }
    static Logger logger = Logger.getLogger(MainFrame.class.getName());

    public ApplicationContext getCtx() {
        return ctx;
    }
}
