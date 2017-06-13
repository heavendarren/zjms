package com.tfkj.zongjiao.panel;

import com.tfkj.zongjiao.frame.MainFrame;
import com.tfkj.zongjiao.entity.Item;
import com.tfkj.zongjiao.entity.RelgPer;
import com.tfkj.zongjiao.service.RelgPerService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by wangqingxiang on 2017/5/18.
 */
public class DataQueryPanel extends Container implements ActionListener {
    JLabel l_name = new JLabel("姓名");
    JLabel l_sex = new JLabel("性别");

    JLabel l_nation = new JLabel("民族");
    JLabel l_religion = new JLabel("宗教信仰");
    JLabel l_education = new JLabel("学历");
    JLabel l_identityCode = new JLabel("身份");
    JLabel l_proEducation = new JLabel("在职学历");
    JLabel l_reglPlace = new JLabel("宗教场所");
    JLabel l_socialPosition = new JLabel("社会职务");
    JLabel l_region = new JLabel("填报单位");


    JTextField name = new JTextField();
    JComboBox<Item> sex = new JComboBox<Item>();

    JComboBox<Item> nation = new JComboBox<Item>();
    JComboBox<Item> religion = new JComboBox<Item>();
    JComboBox<Item> education = new JComboBox<Item>();
    JComboBox<Item> identityCode = new JComboBox<Item>();
    
    JComboBox<Item> proEducation = new JComboBox<Item>();
    JTextField reglPlace = new JTextField();
    JTextField socialPosition = new JTextField();
    JComboBox<Item> region = new JComboBox<Item>();


    JButton button1 = new JButton("查询");
    MainFrame mainFrame;
    List<Item> regionList;
    List<Item> nationList;
    public DataQueryPanel(MainFrame mainFrame){
        this.mainFrame=mainFrame;
        //下面设定标签等的出现位置和高宽
    	l_name.setBounds(10,10,60,20);
    	name.setBounds(80,10,120,20);
    	this.add(l_name);
    	this.add(name);
    	
		l_sex.setBounds(210,10,60,20);
		sex.setBounds(270,10,120,20);
		Item empty = new Item("", "");
		sex.addItem(empty);
		Item sex_1 = new Item("1", "男");
		sex.addItem(sex_1);
		Item sex_2 = new Item("2", "女");
		sex.addItem(sex_2);
		this.add(l_sex);
		this.add(sex);

        l_nation.setBounds(10,35,60,20);
        nation.setBounds(80,35,120,20);
        String[] nations = {"汉族","蒙古族","回族","藏族","维吾尔族","苗族","彝族","壮族","布依族","朝鲜族","满族","侗族","瑶族","白族","土家族",  
                "哈尼族","哈萨克族","傣族","黎族","傈僳族","佤族","畲族","高山族","拉祜族","水族","东乡族","纳西族","景颇族","柯尔克孜族",  
                "土族","达斡尔族","仫佬族","羌族","布朗族","撒拉族","毛南族","仡佬族","锡伯族","阿昌族","普米族","塔吉克族","怒族", "乌孜别克族",  
               "俄罗斯族","鄂温克族","德昂族","保安族","裕固族","京族","塔塔尔族","独龙族","鄂伦春族","赫哲族","门巴族","珞巴族","基诺族"};  
        nation.addItem(empty); 
        nationList = new ArrayList<Item>();
        for (int i=0;i<nations.length;i++) {
        	Item nai = new Item(String.format("%02d", i+1), nations[i]);
        	nationList.add(nai);
        	nation.addItem(nai);
        }
        this.add(l_nation);
        this.add(nation);
        
        l_religion.setBounds(210,35,60,20);
        religion.setBounds(270,35,120,20);
        religion.addItem(empty);
		Item religion_3 = new Item("03", "佛教");
		religion.addItem(religion_3);
		Item religion_4 = new Item("04", "道教");
		religion.addItem(religion_4);
		Item religion_2 = new Item("02", "伊斯兰教");
		religion.addItem(religion_2);
		Item religion_5 = new Item("05", "天主教");
		religion.addItem(religion_5);
		Item religion_1 = new Item("01", "基督教");
		religion.addItem(religion_1);
        this.add(l_religion);
        this.add(religion);
        
        l_education.setBounds(10,60,60,20);
        education.setBounds(80,60,120,20);
        education.addItem(empty);
		Item education_0 = new Item("00", "无");
		education.addItem(education_0);
		Item education_1 = new Item("01", "小学");
//		education.addItem(education_1);
		Item education_2 = new Item("02", "初中");
//		education.addItem(education_2);
		Item education_9 = new Item("09", "中技");
		education.addItem(education_9);
		Item education_3 = new Item("03", "高中");
		education.addItem(education_3);
		Item education_7 = new Item("07", "专科");
		education.addItem(education_7);
		Item education_4 = new Item("04", "本科");
		education.addItem(education_4);
		Item education_5 = new Item("05", "硕士研究生");
		education.addItem(education_5);
		Item education_8 = new Item("08", "博士研究生");
		education.addItem(education_8);
        this.add(l_education);
        this.add(education);
        

        l_identityCode.setBounds(210,60,60,20);
        identityCode.setBounds(270,60,120,20);
        identityCode.addItem(empty);
		Item identityCode_1 = new Item("1", "少数民族代表人士");
		identityCode.addItem(identityCode_1);
		Item identityCode_2 = new Item("2", "宗教界代表人士");
		identityCode.addItem(identityCode_2);
		Item identityCode_3 = new Item("3", "宗教教职人员");
		identityCode.addItem(identityCode_3);
		Item identityCode_4 = new Item("4", "民族宗教干部");
		identityCode.addItem(identityCode_4);
		Item identityCode_5 = new Item("5", "民族宗教信息员");
		identityCode.addItem(identityCode_5);
        this.add(l_identityCode);
        this.add(identityCode);
        
        l_proEducation.setBounds(10,85,60,20);
        proEducation.setBounds(80,85,120,20);
        proEducation.addItem(empty);
        proEducation.addItem(education_0);
//		proEducation.addItem(education_1);
//		proEducation.addItem(education_2);
        proEducation.addItem(education_9);
        proEducation.addItem(education_3);
        proEducation.addItem(education_7);
        proEducation.addItem(education_4);
        proEducation.addItem(education_5);
        proEducation.addItem(education_8);
        this.add(l_proEducation);
        this.add(proEducation);

        l_reglPlace.setBounds(210,85,60,20);
        reglPlace.setBounds(270,85,120,20);
    	this.add(l_reglPlace);
    	this.add(reglPlace);
        
    	l_socialPosition.setBounds(10,110,60,20);
    	socialPosition.setBounds(80,110,120,20);
    	this.add(l_socialPosition);
    	this.add(socialPosition);        
        
        l_region.setBounds(210,110,60,20);
        region.setBounds(270,110,120,20);
        region.addItem(empty);
        
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
        
        this.add(l_region);
        this.add(region);
        
        button1.addActionListener(this);//添加事件处理

        button1.setBounds(410, 10, 60, 45);
        this.add(button1);

    }
	RelgPer condition = new RelgPer();

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	condition.setName(name.getText());
    	condition.setSex(((Item)sex.getSelectedItem()).getKey());
    	condition.setNation(((Item)nation.getSelectedItem()).getKey());
    	condition.setReligion(((Item)religion.getSelectedItem()).getKey());
    	condition.setEducation(((Item)education.getSelectedItem()).getKey());
    	condition.setIdentityCode(((Item)identityCode.getSelectedItem()).getKey());
    	
    	condition.setProEducation(((Item)proEducation.getSelectedItem()).getKey());
    	condition.setReglPlace(reglPlace.getText());
    	condition.setSocialPosition(socialPosition.getText());
    	condition.setRegion(((Item)region.getSelectedItem()).getKey());

    	if (condition.getPageNo()==null) {
        	condition.setPageNo(1);
    	}
    	condition.setSrow((condition.getPageNo() - 1) * 30);
    	
    	int cnt = 0;
    	List<RelgPer> result = null;
        RelgPerService relgPerService=(RelgPerService)mainFrame.getCtx().getBean("relgPerService");
        if (e.getSource().equals(button1)) {
        	cnt = relgPerService.getDataCount(condition);
            result = relgPerService.findList(condition);
        }


        //打开新窗口
        double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
//        mainFrame.setVisible(false);

        //model =true  模态窗口，窗口不关闭，线程阻塞
        JDialog dialog  = new JDialog(mainFrame,true);
        dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        dialog.setLocation(new Point((int) (lx / 2) - 400, (int) (ly / 2) - 300));//设定窗口出现位置
        dialog.setSize(950, 650);//设定窗口大小
        dialog.setTitle("查询结果");

        ListPanel panel = new ListPanel(result,dialog,cnt,condition.getPageNo(),regionList,nationList);

        dialog.add(panel);
        dialog.setLocationRelativeTo(mainFrame);
        dialog.setVisible(true);  //显示对话框，窗口阻塞，不往下执行，只有等到对话框关闭了才往下执行。
        dialog.requestFocus();


        String btn = panel.getBtn();


        if ("1".equals(btn)) {
            String id = panel.getId();
        	RelgPer data = relgPerService.get(id);
            //model =true  模态窗口，窗口不关闭，线程阻塞
            JDialog dialogView = new JDialog(mainFrame,true);
            dialogView.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
            dialogView.setLocation(new Point((int) (lx / 2) - 400, (int) (ly / 2) - 300));//设定窗口出现位置
            dialogView.setSize(950, 650);//设定窗口大小
            dialogView.setTitle("信息查看");
            JPanel viewPanel;
        	if ("1".equals(data.getIdentityCode()) || "4".equals(data.getIdentityCode()) || "5".equals(data.getIdentityCode())) {
        		viewPanel = new DataEditPanel1(dialogView, data, true);
        	} else {
        		viewPanel = new DataEditPanel2(dialogView, data, true);
        	}
       	 	dialogView.add(viewPanel);
       	 	dialogView.setLocationRelativeTo(mainFrame);
       	 	dialogView.setVisible(true);  //显示对话框，窗口阻塞，不往下执行，只有等到对话框关闭了才往下执行。
       	 	dialogView.requestFocus();

            if ("1".equals(data.getNotClose())) {
                //获取对象，保存位新的身份
                String  identityCode=data.getIdentityCode();
                if(identityCode.equals("2")){
                    data.setIdentityCode("3");
                }else{
                    data.setIdentityCode("2");
                }
                data.setId("");
                if(relgPerService.identifyExist(data)){
                    JOptionPane.showMessageDialog(null,"数据重复，系统中已存在"+data.getName()+"的数据"+"\n");
                }else{
                    relgPerService.save(data);
                }

            }
            button1.doClick();



        } else if ("2".equals(btn)) {
            String id = panel.getId();
        	RelgPer data = relgPerService.get(id);
            //model =true  模态窗口，窗口不关闭，线程阻塞
            JDialog dialogEdit  = new JDialog(mainFrame,true);
            dialogEdit.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
            dialogEdit.setLocation(new Point((int) (lx / 2) - 400, (int) (ly / 2) - 300));//设定窗口出现位置
            dialogEdit.setSize(950, 650);//设定窗口大小
            dialogEdit.setTitle("信息修改");
            JPanel editPanel;
        	if ("1".equals(data.getIdentityCode()) || "4".equals(data.getIdentityCode()) || "5".equals(data.getIdentityCode())) {
        		editPanel = new DataEditPanel1(dialogEdit, data, false);
        	} else {
        		editPanel = new DataEditPanel2(dialogEdit, data, false);
        	}

       	 	dialogEdit.add(editPanel);
       	 	dialogEdit.setLocationRelativeTo(mainFrame);
       	 	dialogEdit.setVisible(true);  //显示对话框，窗口阻塞，不往下执行，只有等到对话框关闭了才往下执行。
       	 	dialogEdit.requestFocus();
       	 	if ("1".equals(data.getNotClose())) {
                relgPerService.save(data);
       	 	}
            button1.doClick();
        } else if ("3".equals(btn)) {
            String id = panel.getId();
        	RelgPer data = relgPerService.get(id);
        	relgPerService.delete(data);
        	button1.doClick();
        } else if ("4".equals(btn)) {
        	condition.setPageNo(condition.getPageNo()-1);
        	button1.doClick();
        } else if ("5".equals(btn)) {
        	condition.setPageNo(condition.getPageNo()+1);
        	button1.doClick();
        } else {
        	condition = new RelgPer();
        }

        if (!mainFrame.isVisible()) {
            //主窗口重新打开，获取焦点
            mainFrame.setVisible(true);
            mainFrame.requestFocus();
        }
    }
}
