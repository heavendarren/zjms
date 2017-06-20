package com.tfkj.zongjiao.frame;


import com.tfkj.zongjiao.App;
import com.tfkj.zongjiao.entity.Item;
import com.tfkj.zongjiao.util.FileUtils;
import com.tfkj.zongjiao.util.PropertiesHelper;
import org.apache.derby.iapi.services.io.FileUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by wangqingxiang on 2017/5/22.
 */
public class ConfigDialog extends JDialog implements ActionListener {
    JLabel label1 = new JLabel("请选择文件路径");
    JLabel label4 = new JLabel("请选择所属单位");
    JLabel label5 = new JLabel("数据库地址");
    JTextField text1 = new JTextField();

    JTextField text4 = new JTextField();
    JTextField text5 = new JTextField();

    JFileChooser jfc1 = new JFileChooser();//文件选择器


    JButton button1 = new JButton("...");


    JComboBox<Item> region = new JComboBox<Item>();

    java.util.List<Item> regionList;

    JPanel panel = new JPanel();
    JButton button5 = new JButton("保存");
    boolean finished = false;


    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public ConfigDialog() {
        this.setLayout(null);
        //下面设定标签等的出现位置和高宽
        this.setBackground(Color.white);

        this.setModal(true);

        label1.setBounds(10, 40, 100, 30);
        text1.setBounds(120, 40, 200, 30);
        button1.setBounds(330, 40, 30, 30);
        this.add(label1);
        this.add(text1);
        this.add(button1);


        label4.setBounds(10, 80, 100, 30);
        region.setBounds(120, 80, 200, 30);

        loadRegion();
        this.add(label4);
        this.add(region);
//


        String path2 = MainFrame.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        path2 = path2.substring(1, path2.lastIndexOf("/"));
        path2 = new File(path2).getAbsolutePath().replace("\\.", "");
        text5.setEnabled(false);
        this.add(label5);
        this.add(text5);

        jfc1.setCurrentDirectory(new File("c:\\"));//文件选择器的初始目录定为d盘

        this.add(jfc1);


        button1.addActionListener(this);//添加事件处理

        button5.addActionListener(this);//添加事件处理

        button5.setBounds(135, 185, 100, 30);
        this.add(button5);


        double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.setLocation(new Point((int) (lx / 2) - 200, (int) (ly / 2) - 150));//设定窗口出现位置
        this.setSize(400, 300);//设定窗口大小
        this.setVisible(true);  //显示对话框，窗口阻塞，不往下执行，只有等到对话框关闭了才往下执行。
        this.requestFocus();


    }


    private void loadRegion(){
        Properties regionPro = new Properties();
        try{

            InputStream in=ClassLoader.getSystemResourceAsStream("region.properties");
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            regionPro.load(isr);
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        String s = (String) regionPro.get("regionList");

        String[] list = s.split(",");
        regionList = new ArrayList<Item>();
        for (int i=0; i<list.length;i++) {
            String[] r = list[i].split(":");
            Item item = new Item(r[0], r[1]);
            regionList.add(item);
            region.addItem(item);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(button1)) {
            jfc1.setFileSelectionMode(1);//设定只能选择到文件夹
            int state = jfc1.showOpenDialog(null);//此句是打开文件选择器界面的触发语句
            if (state == 1) {
                return;//撤销则返回
            } else {
                File f = jfc1.getSelectedFile();//f为选择到的目录
                text1.setText(f.getAbsolutePath());
            }


        } else if (e.getSource().equals(button5)) {//判断触发方法的按钮是哪个

            //检查参数
            //修改配置文件
            Properties pro = new Properties();
            pro.setProperty("imagedir", text1.getText() + "/img");
            pro.setProperty("outdir", text1.getText() + "/out");
            pro.setProperty("backupdir", text1.getText() + "/back");
            pro.setProperty("areacode", ((Item)region.getSelectedItem()).getKey());
            pro.setProperty("derbyhome", text1.getText() + "/db");

            PropertiesHelper.store(pro);
            finished = true;


            //复制db到指定的文件夹
            String dbhome = text1.getText();
            try {
                String path= App.class.getProtectionDomain().getCodeSource().getLocation().getFile();

                path = path.substring(1,path.lastIndexOf("/"))+"/db/zongjiao";

                FileUtils.copyDirectoryCover(path, dbhome+"/db/zongjiao",true);
            }catch (Exception f){
                f.printStackTrace();
            }
//            FileUtils.copyDirectory("E:\\workspace\\TFGroup_Assets\\1.Develop\\Code\\zjms\\target\\classes\\db",dbhome);
            //关闭弹框
            this.setVisible(false);
        }


    }
}
