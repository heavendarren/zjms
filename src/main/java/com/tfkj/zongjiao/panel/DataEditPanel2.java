package com.tfkj.zongjiao.panel;

import com.tfkj.zongjiao.entity.Item;
import com.tfkj.zongjiao.entity.RelgPer;
import com.tfkj.zongjiao.service.RelgPerService;
import com.tfkj.zongjiao.util.ExportWordHelper;
import com.tfkj.zongjiao.util.PropertiesHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangqingxiang on 2017/5/18.
 */
public class DataEditPanel2 extends JPanel implements ActionListener {
	
	JLabel identityCode = new JLabel();
	
	Image image;
	JLabel l_image = new JLabel();
	
    JLabel l_name = new JLabel("姓名");
    JRadioButton l_relgNameCode_1 = new JRadioButton("圣名", true);
    JRadioButton l_relgNameCode_2 = new JRadioButton("法名");
    JRadioButton l_relgNameCode_3 = new JRadioButton("经名");

    JLabel l_sex = new JLabel("性别");
    JLabel l_birth = new JLabel("出生年月日");

    JLabel l_photo = new JLabel("照片");
    JLabel l_nation = new JLabel("民族");
    JLabel l_nativePlace = new JLabel("籍贯");
    JLabel l_birthplace = new JLabel("出生地");
    JLabel l_domicilePlace = new JLabel("户籍所在地");
    JLabel l_religion = new JLabel("宗教信仰");
    JLabel l_relgIdentity = new JLabel("宗教身份");
    JLabel l_startingRelgTime = new JLabel("成为教职人员时间");
    JLabel l_reglPlace = new JLabel("所在宗教场所");
    JLabel l_relgPosition = new JLabel("教内职务");
    JLabel l_health = new JLabel("身体状况");
    JLabel l_education = new JLabel("全日制教育：学历");
    JLabel l_school = new JLabel("毕业院校系及专业");
    JLabel l_reglEducation = new JLabel("宗教教育：学历");
    JLabel l_reglSchool = new JLabel("毕业院校系及专业");
    JLabel l_idCardNo = new JLabel("身份证号");
    JLabel l_contact = new JLabel("联系方式(地址电话)");
    JLabel l_socialPosition = new JLabel("社会职务");
    JLabel l_resume = new JLabel("工作简历");
    JLabel l_winningRecord = new JLabel("获奖情况");
    JLabel l_results = new JLabel("主要业绩简述");

    JTextField name1 = new JTextField();
    JTextField relgName = new JTextField();
    JComboBox<Item> sex = new JComboBox<Item>();  
    JTextField birth = new JTextField();
	DatePickerButton birthButton=new DatePickerButton(birth);
    JTextField photo = new JTextField();
    JComboBox<Item> nation = new JComboBox<Item>();
    JComboBox<Item> nativePlaceP;
    JComboBox<Item> nativePlaceC;
    JComboBox<Item> nativePlaceA;
    JComboBox<Item> birthplaceP;
    JComboBox<Item> birthplaceC;
    JComboBox<Item> birthplaceA;
    JComboBox<Item> domicilePlaceP;
    JComboBox<Item> domicilePlaceC;
    JComboBox<Item> domicilePlaceA;

    JComboBox<Item> religion = new JComboBox<Item>();  
    JTextField relgIdentity = new JTextField();
    JTextField startingRelgTime = new JTextField();
	DatePickerButton startingRelgTimeButton=new DatePickerButton(startingRelgTime);
    JTextField reglPlace = new JTextField();
    JTextField relgPosition = new JTextField();
    JTextField health = new JTextField();
    JComboBox<Item> education = new JComboBox<Item>();
    JTextField school = new JTextField();
    JComboBox<Item> reglEducation = new JComboBox<Item>();
    JTextField reglSchool = new JTextField();
    JTextField idCardNo = new JTextField();
    JTextField contact = new JTextField();
    JTextField socialPosition = new JTextField();
    JTextArea resume = new JTextArea();
    JTextArea winningRecord = new JTextArea();
    JTextArea results = new JTextArea();


    JButton button1 = new JButton("保存");

    JButton button2 = new JButton("选择照片");
    JFileChooser jfc = new JFileChooser();//文件选择器
    
    JButton button3 = new JButton("导出word文档");


	JButton button4 = new JButton("复制");

    public Dialog dialog;
    public RelgPer relgPer;
    public String copyFlag="0";

    public DataEditPanel2(Dialog dialog,RelgPer relgPer, boolean isView){

        this.relgPer=relgPer;
        this.dialog=dialog;
        this.setLayout(null);
        //下面设定标签等的出现位置和高宽
        this.setBackground(Color.white);
        identityCode.setText(relgPer.getIdentityCode());

        l_name.setBounds(10,20,115,20);
        name1.setBounds(135,20,200,20);
        this.add(l_name);
        this.add(name1);
        
		l_sex.setBounds(365,20,114,20);
		sex.setBounds(490,20,200,20);
		Item empty = new Item("", "");
		sex.addItem(empty);
		Item sex_1 = new Item("1", "男");
		sex.addItem(sex_1);
		Item sex_2 = new Item("2", "女");
		sex.addItem(sex_2);
		this.add(l_sex);
		this.add(sex);
		
        l_photo.setBounds(740,20,120,20);
        l_image.setBounds(740,45,120,160);
        l_image.setBorder(BorderFactory.createLineBorder(Color.gray,1));
        this.add(l_photo);
        this.add(l_image);
		
		l_birth.setBounds(10, 45, 115, 20);
		birth.setBounds(135, 45, 200, 20);
		birthButton.setBounds(340,45,20,20);
        this.add(l_birth);
        this.add(birthButton);
        this.add(birth);

        l_nation.setBounds(365,45,115,20);
        nation.setBounds(490,45,200,20);
        String[] nations = {"汉族","蒙古族","回族","藏族","维吾尔族","苗族","彝族","壮族","布依族","朝鲜族","满族","侗族","瑶族","白族","土家族",  
                "哈尼族","哈萨克族","傣族","黎族","傈僳族","佤族","畲族","高山族","拉祜族","水族","东乡族","纳西族","景颇族","柯尔克孜族",  
                "土族","达斡尔族","仫佬族","羌族","布朗族","撒拉族","毛南族","仡佬族","锡伯族","阿昌族","普米族","塔吉克族","怒族", "乌孜别克族",  
               "俄罗斯族","鄂温克族","德昂族","保安族","裕固族","京族","塔塔尔族","独龙族","鄂伦春族","赫哲族","门巴族","珞巴族","基诺族"};  
        nation.addItem(empty); 
        List<Item> nationList = new ArrayList<Item>();
        for (int i=0;i<nations.length;i++) {
        	Item nai = new Item(String.format("%02d", i+1), nations[i]);
        	nationList.add(nai);
        	nation.addItem(nai);
        }
        this.add(l_nation);
        this.add(nation);

        l_relgNameCode_1.setBounds(10,70,60,20);
        l_relgNameCode_2.setBounds(70,70,60,20);
        l_relgNameCode_3.setBounds(130,70,60,20);
        relgName.setBounds(200,70,490,20);
        ButtonGroup group = new ButtonGroup();
        group.add(l_relgNameCode_1);
        group.add(l_relgNameCode_2);
        group.add(l_relgNameCode_3);
        this.add(l_relgNameCode_1);
        this.add(l_relgNameCode_2);
        this.add(l_relgNameCode_3);
        this.add(relgName);

        JComboboxOfChina box = new JComboboxOfChina(relgPer.getNativePlaceP(),relgPer.getNativePlaceC(),relgPer.getNativePlaceA());
        nativePlaceP = box.getCombobox_privince();
        nativePlaceC = box.getCombobox_city();
        nativePlaceA = box.getCombobox_area();

        l_nativePlace.setBounds(10, 95, 115, 20);
        nativePlaceP.setBounds(135, 95, 180, 20);
        nativePlaceC.setBounds(325, 95, 180, 20);
        nativePlaceA.setBounds(515, 95, 180, 20);
        this.add(l_nativePlace);
        this.add(nativePlaceP);
        this.add(nativePlaceC);
        this.add(nativePlaceA);

        JComboboxOfChina box2 = new JComboboxOfChina(relgPer.getBirthplaceP(),relgPer.getBirthplaceC(),relgPer.getBirthplaceA());
        birthplaceP = box2.getCombobox_privince();
        birthplaceC = box2.getCombobox_city();
        birthplaceA = box2.getCombobox_area();

        l_birthplace.setBounds(10, 120, 115, 20);
        birthplaceP.setBounds(135, 120, 180, 20);
        birthplaceC.setBounds(325, 120, 180, 20);
        birthplaceA.setBounds(515, 120, 180, 20);
        this.add(l_birthplace);
        this.add(birthplaceP);
        this.add(birthplaceC);
        this.add(birthplaceA);
        
        JComboboxOfChina box3 = new JComboboxOfChina(relgPer.getDomicilePlaceP(),relgPer.getDomicilePlaceC(),relgPer.getDomicilePlaceA());
        domicilePlaceP = box3.getCombobox_privince();
        domicilePlaceC = box3.getCombobox_city();
        domicilePlaceA = box3.getCombobox_area();

        l_domicilePlace.setBounds(10, 145, 115, 20);
        domicilePlaceP.setBounds(135, 145, 180, 20);
        domicilePlaceC.setBounds(325, 145, 180, 20);
        domicilePlaceA.setBounds(515, 145, 180, 20);
        this.add(l_domicilePlace);
        this.add(domicilePlaceP);
        this.add(domicilePlaceC);
        this.add(domicilePlaceA);
        
        l_religion.setBounds(10,170,115,20);
        religion.setBounds(135,170,200,20);
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
        
        l_relgIdentity.setBounds(365, 170, 115, 20);
        relgIdentity.setBounds(490, 170, 200, 20);

        this.add(l_relgIdentity);
        this.add(relgIdentity);

        l_startingRelgTime.setBounds(10, 195, 115, 20);
        startingRelgTime.setBounds(135, 195, 200, 20);
		startingRelgTimeButton.setBounds(340,195,20,20);
        this.add(l_startingRelgTime);
        this.add(startingRelgTime);
        this.add(startingRelgTimeButton);
        
        l_reglPlace.setBounds(365, 195, 115, 20);
        reglPlace.setBounds(490, 195, 200, 20);
        this.add(l_reglPlace);
        this.add(reglPlace);   
        
        l_relgPosition.setBounds(10, 220, 115, 20);
        relgPosition.setBounds(135, 220, 200, 20);
        this.add(l_relgPosition);
        this.add(relgPosition);           
    
        l_health.setBounds(365, 220, 115, 20);
        health.setBounds(490, 220, 200, 20);
        this.add(l_health);
        this.add(health);  
        
        l_education.setBounds(10,245,115,20);
        education.setBounds(135,245,200,20);
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
        
        l_school.setBounds(365, 245, 115, 20);
        school.setBounds(490, 245, 200, 20);
        this.add(l_school);
        this.add(school);  
        
        l_reglEducation.setBounds(10,270,115,20);
        reglEducation.setBounds(135,270,200,20);
        reglEducation.addItem(empty);
		reglEducation.addItem(education_0);
//		reglEducation.addItem(education_1);
//		reglEducation.addItem(education_2);
		reglEducation.addItem(education_9);
		reglEducation.addItem(education_3);
		reglEducation.addItem(education_7);
		reglEducation.addItem(education_4);
		reglEducation.addItem(education_5);
		reglEducation.addItem(education_8);
        this.add(l_reglEducation);
        this.add(reglEducation);
        
        l_reglSchool.setBounds(365, 270, 115, 20);
        reglSchool.setBounds(490, 270, 200, 20);
        this.add(l_reglSchool);
        this.add(reglSchool);  

        l_idCardNo.setBounds(10, 295, 115, 20);
        idCardNo.setBounds(135, 295, 200, 20);
        this.add(l_idCardNo);
        this.add(idCardNo);        
        
        l_contact.setBounds(365, 295, 115, 20);
        contact.setBounds(490, 295, 200, 20);
        this.add(l_contact);
        this.add(contact);         
        
        l_socialPosition.setBounds(10, 320, 115, 20);
        socialPosition.setBounds(135, 320, 200, 20);
        this.add(l_socialPosition);
        this.add(socialPosition);        
        
        l_resume.setBounds(10, 345, 115, 60);
        resume.setBounds(135, 345, 600, 60);
        resume.setBorder(BorderFactory.createLineBorder(Color.gray,1));
        this.add(l_resume);
        this.add(resume); 
        
        l_winningRecord.setBounds(10, 410, 115, 60);
        winningRecord.setBounds(135, 410, 600, 60);
        winningRecord.setBorder(BorderFactory.createLineBorder(Color.gray,1));
        this.add(l_winningRecord);
        this.add(winningRecord);  

        l_results.setBounds(10, 475, 115, 60);
        results.setBounds(135, 475, 600, 60);
        results.setBorder(BorderFactory.createLineBorder(Color.gray,1));
        this.add(l_results);
        this.add(results);
        
        button1.addActionListener(this);//添加事件处理
        button1.setBounds(600,550,150,30);    
        button2.addActionListener(this);//添加事件处理
        jfc.setCurrentDirectory(new File("c:\\"));
        this.add(jfc);
        button2.setBounds(750,220,100,20);
        
        button3.addActionListener(this);//添加事件处理
        button3.setBounds(400,550,150,30);


		button4.addActionListener(this);//添加事件处理
		button4.setBounds(600,550,150,30);

		if (!isView) {
            this.add(button1);
            this.add(button2);
        } else {
        	this.add(button3);
			this.add(button4);
        } 

        if (relgPer != null && StringUtils.isNotEmpty(relgPer.getId())) {
        	
        	name1.setText(relgPer.getName());

        	if (sex_1.getKey().equals(relgPer.getSex())) {
        		sex.setSelectedItem(sex_1);
        	} else if (sex_2.getKey().equals(relgPer.getSex())) {
        		sex.setSelectedItem(sex_2);
        	}

        	birth.setText(relgPer.getBirth());
        	
            for (Item ni:nationList) {
            	if (ni.getKey().equals(relgPer.getNation())) {
            		nation.setSelectedItem(ni);
            	}
            } 	
        	
        	if ("1".equals(relgPer.getRelgNameCode())) {
            	l_relgNameCode_1.setSelected(true);
            	l_relgNameCode_2.setSelected(false);
            	l_relgNameCode_3.setSelected(false);
        	} else if ("2".equals(relgPer.getRelgNameCode())) {
            	l_relgNameCode_1.setSelected(false);
            	l_relgNameCode_2.setSelected(true);
            	l_relgNameCode_3.setSelected(false);
        	} else if ("3".equals(relgPer.getRelgNameCode())) {
            	l_relgNameCode_1.setSelected(false);
            	l_relgNameCode_2.setSelected(false);
            	l_relgNameCode_3.setSelected(true);
            }

        	relgName.setText(relgPer.getRelgName());
        	
        	if (religion_1.getKey().equals(relgPer.getReligion())) {
        		religion.setSelectedItem(religion_1);
        	} else if (religion_2.getKey().equals(relgPer.getReligion())) {
        		religion.setSelectedItem(religion_2);
        	} else if (religion_3.getKey().equals(relgPer.getReligion())) {
        		religion.setSelectedItem(religion_3);
        	} else if (religion_4.getKey().equals(relgPer.getReligion())) {
        		religion.setSelectedItem(religion_4);
        	} else if (religion_5.getKey().equals(relgPer.getReligion())) {
        		religion.setSelectedItem(religion_5);
        	}
        	
        	relgIdentity.setText(relgPer.getRelgIdentity());

        	startingRelgTime.setText(relgPer.getStartingRelgTime());

        	reglPlace.setText(relgPer.getReglPlace());
        	
        	relgPosition.setText(relgPer.getRelgPosition());
        	
        	health.setText(relgPer.getHealth());
        	
        	if (education_0.getKey().equals(relgPer.getEducation())) {
        		education.setSelectedItem(education_0);
        	} else if (education_1.getKey().equals(relgPer.getEducation())) {
        		education.setSelectedItem(education_1);
        	} else if (education_2.getKey().equals(relgPer.getEducation())) {
        		education.setSelectedItem(education_2);
        	} else if (education_3.getKey().equals(relgPer.getEducation())) {
        		education.setSelectedItem(education_3);
        	} else if (education_4.getKey().equals(relgPer.getEducation())) {
        		education.setSelectedItem(education_4);
        	} else if (education_5.getKey().equals(relgPer.getEducation())) {
        		education.setSelectedItem(education_5);
        	} else if (education_7.getKey().equals(relgPer.getEducation())) {
        		education.setSelectedItem(education_7);
        	} else if (education_8.getKey().equals(relgPer.getEducation())) {
        		education.setSelectedItem(education_8);
        	} else if (education_9.getKey().equals(relgPer.getEducation())) {
        		education.setSelectedItem(education_9);
        	}
        	
        	school.setText(relgPer.getSchool());
        	
        	if (education_0.getKey().equals(relgPer.getReglEducation())) {
        		reglEducation.setSelectedItem(education_0);
        	} else if (education_1.getKey().equals(relgPer.getReglEducation())) {
        		reglEducation.setSelectedItem(education_1);
        	} else if (education_2.getKey().equals(relgPer.getReglEducation())) {
        		reglEducation.setSelectedItem(education_2);
        	} else if (education_3.getKey().equals(relgPer.getReglEducation())) {
        		reglEducation.setSelectedItem(education_3);
        	} else if (education_4.getKey().equals(relgPer.getReglEducation())) {
        		reglEducation.setSelectedItem(education_4);
        	} else if (education_5.getKey().equals(relgPer.getReglEducation())) {
        		reglEducation.setSelectedItem(education_5);
        	} else if (education_7.getKey().equals(relgPer.getReglEducation())) {
        		reglEducation.setSelectedItem(education_7);
        	} else if (education_8.getKey().equals(relgPer.getReglEducation())) {
        		reglEducation.setSelectedItem(education_8);
        	} else if (education_9.getKey().equals(relgPer.getReglEducation())) {
        		reglEducation.setSelectedItem(education_9);
        	}
        	
        	reglSchool.setText(relgPer.getReglSchool());
        	
        	idCardNo.setText(relgPer.getIdCardNo());
        	
        	contact.setText(relgPer.getContact());

        	socialPosition.setText(relgPer.getSocialPosition());
        	
        	resume.setText(relgPer.getResume());
        	
        	winningRecord.setText(relgPer.getWinningRecord());

        	results.setText(relgPer.getResults());	
        	
        	if (StringUtils.isNotEmpty(relgPer.getPhoto())) {
            	photo.setText(relgPer.getPhoto());
                image = getToolkit().getImage(relgPer.getPhoto());
                image = image.getScaledInstance(120,160,image.SCALE_SMOOTH);
                l_image.setIcon(new ImageIcon(image)); 
        	}
        }
        
    }

	public JLabel getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(JLabel identityCode) {
		this.identityCode = identityCode;
	}

	public JRadioButton getL_relgNameCode_1() {
		return l_relgNameCode_1;
	}

	public void setL_relgNameCode_1(JRadioButton l_relgNameCode_1) {
		this.l_relgNameCode_1 = l_relgNameCode_1;
	}

	public JRadioButton getL_relgNameCode_2() {
		return l_relgNameCode_2;
	}

	public void setL_relgNameCode_2(JRadioButton l_relgNameCode_2) {
		this.l_relgNameCode_2 = l_relgNameCode_2;
	}

	public JRadioButton getL_relgNameCode_3() {
		return l_relgNameCode_3;
	}

	public void setL_relgNameCode_3(JRadioButton l_relgNameCode_3) {
		this.l_relgNameCode_3 = l_relgNameCode_3;
	}

	public JTextField getName1() {
		return name1;
	}

	public void setName1(JTextField name1) {
		this.name1 = name1;
	}

	public JTextField getRelgName() {
		return relgName;
	}

	public void setRelgName(JTextField relgName) {
		this.relgName = relgName;
	}

	public JComboBox<Item> getSex() {
		return sex;
	}

	public void setSex(JComboBox<Item> sex) {
		this.sex = sex;
	}

	public JTextField getBirth() {
		return birth;
	}

	public void setBirth(JTextField birth) {
		this.birth = birth;
	}

	public JTextField getPhoto() {
		return photo;
	}

	public void setPhoto(JTextField photo) {
		this.photo = photo;
	}

	public JComboBox<Item> getNation() {
		return nation;
	}

	public void setNation(JComboBox<Item> nation) {
		this.nation = nation;
	}

	public JComboBox<Item> getNativePlaceP() {
		return nativePlaceP;
	}

	public void setNativePlaceP(JComboBox<Item> nativePlaceP) {
		this.nativePlaceP = nativePlaceP;
	}

	public JComboBox<Item> getNativePlaceC() {
		return nativePlaceC;
	}

	public void setNativePlaceC(JComboBox<Item> nativePlaceC) {
		this.nativePlaceC = nativePlaceC;
	}

	public JComboBox<Item> getNativePlaceA() {
		return nativePlaceA;
	}

	public void setNativePlaceA(JComboBox<Item> nativePlaceA) {
		this.nativePlaceA = nativePlaceA;
	}

	public JComboBox<Item> getBirthplaceP() {
		return birthplaceP;
	}

	public void setBirthplaceP(JComboBox<Item> birthplaceP) {
		this.birthplaceP = birthplaceP;
	}

	public JComboBox<Item> getBirthplaceC() {
		return birthplaceC;
	}

	public void setBirthplaceC(JComboBox<Item> birthplaceC) {
		this.birthplaceC = birthplaceC;
	}

	public JComboBox<Item> getBirthplaceA() {
		return birthplaceA;
	}

	public void setBirthplaceA(JComboBox<Item> birthplaceA) {
		this.birthplaceA = birthplaceA;
	}

	public JComboBox<Item> getDomicilePlaceP() {
		return domicilePlaceP;
	}

	public void setDomicilePlaceP(JComboBox<Item> domicilePlaceP) {
		this.domicilePlaceP = domicilePlaceP;
	}

	public JComboBox<Item> getDomicilePlaceC() {
		return domicilePlaceC;
	}

	public void setDomicilePlaceC(JComboBox<Item> domicilePlaceC) {
		this.domicilePlaceC = domicilePlaceC;
	}

	public JComboBox<Item> getDomicilePlaceA() {
		return domicilePlaceA;
	}

	public void setDomicilePlaceA(JComboBox<Item> domicilePlaceA) {
		this.domicilePlaceA = domicilePlaceA;
	}

	public JComboBox<Item> getReligion() {
		return religion;
	}

	public void setReligion(JComboBox<Item> religion) {
		this.religion = religion;
	}

	public JTextField getRelgIdentity() {
		return relgIdentity;
	}

	public void setRelgIdentity(JTextField relgIdentity) {
		this.relgIdentity = relgIdentity;
	}

	public JTextField getStartingRelgTime() {
		return startingRelgTime;
	}

	public void setStartingRelgTime(JTextField startingRelgTime) {
		this.startingRelgTime = startingRelgTime;
	}

	public JTextField getReglPlace() {
		return reglPlace;
	}

	public void setReglPlace(JTextField reglPlace) {
		this.reglPlace = reglPlace;
	}

	public JTextField getRelgPosition() {
		return relgPosition;
	}

	public void setRelgPosition(JTextField relgPosition) {
		this.relgPosition = relgPosition;
	}

	public JTextField getHealth() {
		return health;
	}

	public void setHealth(JTextField health) {
		this.health = health;
	}

	public JComboBox<Item> getEducation() {
		return education;
	}

	public void setEducation(JComboBox<Item> education) {
		this.education = education;
	}

	public JTextField getSchool() {
		return school;
	}

	public void setSchool(JTextField school) {
		this.school = school;
	}

	public JComboBox<Item> getReglEducation() {
		return reglEducation;
	}

	public void setReglEducation(JComboBox<Item> reglEducation) {
		this.reglEducation = reglEducation;
	}

	public JTextField getReglSchool() {
		return reglSchool;
	}

	public void setReglSchool(JTextField reglSchool) {
		this.reglSchool = reglSchool;
	}

	public JTextField getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(JTextField idCardNo) {
		this.idCardNo = idCardNo;
	}

	public JTextField getContact() {
		return contact;
	}

	public void setContact(JTextField contact) {
		this.contact = contact;
	}

	public JTextField getSocialPosition() {
		return socialPosition;
	}

	public void setSocialPosition(JTextField socialPosition) {
		this.socialPosition = socialPosition;
	}

	public JTextArea getResume() {
		return resume;
	}

	public void setResume(JTextArea resume) {
		this.resume = resume;
	}

	public JTextArea getWinningRecord() {
		return winningRecord;
	}

	public void setWinningRecord(JTextArea winningRecord) {
		this.winningRecord = winningRecord;
	}

	public JTextArea getResults() {
		return results;
	}

	public void setResults(JTextArea results) {
		this.results = results;
	}

	@Override
    public void actionPerformed(ActionEvent e) {
    	
    	if (e.getSource().equals(button2)) {
    		
            jfc.setFileSelectionMode(0);//设定只能选择到文件夹
            int state = jfc.showOpenDialog(null);//此句是打开文件选择器界面的触发语句
            if (state == 1) {
                return;//撤销则返回
            } else {
                File f = jfc.getSelectedFile();//f为选择到的目录  
                photo.setText(f.getAbsolutePath());
                image = getToolkit().getImage(f.getAbsolutePath());
                image = image.getScaledInstance(120,160,image.SCALE_SMOOTH);
                l_image.setIcon(new ImageIcon(image));   
            }
    	}
    	
    	if (e.getSource().equals(button3)) {
			ExportWordHelper ew = new ExportWordHelper();
			String r = ew.createWord2(this);
			if (r!=null) {
				String filePath= PropertiesHelper.load().getProperty("outdir");
				JOptionPane.showMessageDialog(null,"导出成功。\r\n文件路径：" + filePath + "\r\n文件名：" + r);
			} else {
				JOptionPane.showMessageDialog(null,"导出失败，请联系管理员查看日志");
			}
		}
		if (e.getSource().equals(button4)) {

			relgPer.setNotClose("1");
			dialog.setVisible(false);
		}
        if (e.getSource().equals(button1)) {//判断触发方法的按钮是哪个

            boolean ckflg = true;

            if(StringUtils.isEmpty(name1.getText())){
            	ckflg = false;
                JOptionPane.showMessageDialog(null,"请填写姓名");
            }else{
                relgPer.setName(name1.getText());
            }
            
            if (ckflg) {
                String sexValue = ((Item)sex.getSelectedItem()).getKey();
                if(StringUtils.isEmpty(sexValue)){
                	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选择性别");
                }else{
                    relgPer.setSex(sexValue);
                }
            }

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            if (ckflg) {
                if(StringUtils.isEmpty(birth.getText())){
                    ckflg = false;
                    JOptionPane.showMessageDialog(null,"请填写出生年月日");
                }else{
                	if (birth.getText().length() != 10) {
                        ckflg = false;
    					JOptionPane.showMessageDialog(null,"出生年月日格式错误");
                	} else {
                        try {
                            sdf.parse(birth.getText());
        				} catch (ParseException e1) {
                            ckflg = false;
        					JOptionPane.showMessageDialog(null,"出生年月日格式错误");
        				}
                        relgPer.setBirth(birth.getText());
                	}

                }
            }

            if (ckflg) {
                String nationValue = ((Item)nation.getSelectedItem()).getKey();
                if(StringUtils.isEmpty(nationValue)){
                	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选择民族");
                }else{
                    relgPer.setNation(nationValue);
                }
            }

            if (ckflg) {
                if (l_relgNameCode_1.isSelected()) {
                	relgPer.setRelgNameCode("1");
                } else if (l_relgNameCode_2.isSelected()) {
                	relgPer.setRelgNameCode("2");
                } else if (l_relgNameCode_3.isSelected()) {
                	relgPer.setRelgNameCode("3");
                } else {
                	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选择宗教姓名");
                }
            }

            if (ckflg) {
                if(StringUtils.isEmpty(relgName.getText())){
                	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请填写宗教姓名");
                }else{
                    relgPer.setRelgName(relgName.getText());
                }
            }

            if (ckflg) {
                String nativePlacePValue = ((Item)nativePlaceP.getSelectedItem()).getKey();
                if(StringUtils.isEmpty(nativePlacePValue)){
                	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选择籍贯（省）");
                }else{
                    relgPer.setNativePlaceP(nativePlacePValue);
                }
            }

            if (ckflg) {
                String nativePlaceCValue = ((Item)nativePlaceC.getSelectedItem()).getKey();
                if(StringUtils.isEmpty(nativePlaceCValue)){
                	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选择籍贯（市）");
                }else{
                    relgPer.setNativePlaceC(nativePlaceCValue);
                }
            }

            if (ckflg) {
                String nativePlaceAValue = ((Item)nativePlaceA.getSelectedItem()).getKey();
                if(StringUtils.isEmpty(nativePlaceAValue)){
                	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选择籍贯（县）");
                }else{
                    relgPer.setNativePlaceA(nativePlaceAValue);
                }
            }

            if (ckflg) {
                String birthplacePValue = ((Item)birthplaceP.getSelectedItem()).getKey();
                if(StringUtils.isEmpty(birthplacePValue)){
                	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选择出生地（省）");
                }else{
                    relgPer.setBirthplaceP(birthplacePValue);
                }
            }

            if (ckflg) {
                String birthplaceCValue = ((Item)birthplaceC.getSelectedItem()).getKey();
                if(StringUtils.isEmpty(birthplaceCValue)){
                	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选出择生地（市）");
                }else{
                    relgPer.setBirthplaceC(birthplaceCValue);
                }
            }

            if (ckflg) {
                String birthplaceAValue = ((Item)birthplaceA.getSelectedItem()).getKey();
                if(StringUtils.isEmpty(birthplaceAValue)){
                	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选出择生地（县）");
                }else{
                    relgPer.setBirthplaceA(birthplaceAValue);
                }
            }

            if (ckflg) {
                String domicilePlacePValue = ((Item)domicilePlaceP.getSelectedItem()).getKey();
                if(StringUtils.isEmpty(domicilePlacePValue)){
                	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选择户籍所在地（省）");
                }else{
                    relgPer.setDomicilePlaceP(domicilePlacePValue);
                }
            }

            if (ckflg) {
                String domicilePlaceCValue = ((Item)domicilePlaceC.getSelectedItem()).getKey();
                if(StringUtils.isEmpty(domicilePlaceCValue)){
                   	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选择户籍所在地（市）");
                }else{
                    relgPer.setDomicilePlaceC(domicilePlaceCValue);
                }

            }

            if (ckflg) {
                String domicilePlaceAValue = ((Item)domicilePlaceA.getSelectedItem()).getKey();
                if(StringUtils.isEmpty(domicilePlaceAValue)){
                   	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选择户籍所在地（县）");
                }else{
                    relgPer.setDomicilePlaceA(domicilePlaceAValue);
                }
            }

            if (ckflg) {
                String religionValue = ((Item)religion.getSelectedItem()).getKey();
                if(StringUtils.isEmpty(religionValue)){
                   	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选择宗教信仰");
                }else{
                    relgPer.setReligion(religionValue);
                }
            }

            if (ckflg) {
                if(StringUtils.isEmpty(relgIdentity.getText())){
                   	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请填写宗教身份");
                }else{
                    relgPer.setRelgIdentity(relgIdentity.getText());
                }
            }
            
            if (ckflg) {
                if(StringUtils.isEmpty(startingRelgTime.getText())){
                    ckflg = false;
                    JOptionPane.showMessageDialog(null,"请填写成为教职人员时间");
                }else{
                	if (startingRelgTime.getText().length() != 10) {
                        ckflg = false;
    					JOptionPane.showMessageDialog(null,"成为教职人员时间格式错误");
                	} else {
                        try {
                            sdf.parse(startingRelgTime.getText());
        				} catch (ParseException e1) {
                            ckflg = false;
        					JOptionPane.showMessageDialog(null,"成为教职人员时间格式错误");
        				}
                        relgPer.setStartingRelgTime(startingRelgTime.getText());
                	}

                }
            }
            

            if (ckflg) {  
                if(StringUtils.isEmpty(reglPlace.getText())){
                   	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请填写所在宗教场所");
                }else{
                    relgPer.setReglPlace(reglPlace.getText());
                }
            }

            if (ckflg) {  
                if(StringUtils.isEmpty(relgPosition.getText())){
                   	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请填写教内职务");
                }else{
                    relgPer.setRelgPosition(relgPosition.getText());
                }
            }

            if (ckflg) { 
                if(StringUtils.isEmpty(health.getText())){
                   	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请填写身体状况");
                }else{
                    relgPer.setHealth(health.getText());
                }
            }

            if (ckflg) { 
                String educationValue = ((Item)education.getSelectedItem()).getKey();
                if(StringUtils.isEmpty(educationValue)){
                   	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选择全日制教育：学历");
                }else{
                    relgPer.setEducation(educationValue);
                }
            }

            if (ckflg) {
                if(StringUtils.isEmpty(school.getText())){
                   	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请填写全日制教育：毕业院校系及专业");
                }else{
                    relgPer.setSchool(school.getText());
                }
            }

            if (ckflg) {   
                String reglEducationValue = ((Item)reglEducation.getSelectedItem()).getKey();
                if(StringUtils.isEmpty(reglEducationValue)){
                   	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选择宗教教育：学历");
                }else{
                    relgPer.setReglEducation(reglEducationValue);
                }
            }

            if (ckflg) { 
                if(StringUtils.isEmpty(reglSchool.getText())){
                   	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请填写宗教教育：毕业院校系及专业");
                }else{
                    relgPer.setReglSchool(reglSchool.getText());
                }
            }


            if (ckflg) { 
                if(StringUtils.isEmpty(idCardNo.getText())){
                   	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请填写身份证号");
                }else{
                	if (idCardNo.getText().length() != 18) {
                       	ckflg = false;
                        JOptionPane.showMessageDialog(null,"身份证号填写错误");
                	}
                    relgPer.setIdCardNo(idCardNo.getText());
                }
            }

            if (ckflg) { 
                if(StringUtils.isEmpty(contact.getText())){
                   	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请填写联系方式（地址电话）");
                }else{
                    relgPer.setContact(contact.getText());
                }
            }

            if (ckflg) { 
                if(StringUtils.isEmpty(socialPosition.getText())){
                   	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请填写社会职务");
                }else{
                    relgPer.setSocialPosition(socialPosition.getText());
                }
            }

            if (ckflg) { 
                if(StringUtils.isEmpty(resume.getText())){
                   	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请填写工作简历");
                }else{
                    relgPer.setResume(resume.getText());
                }
            }

            if (ckflg) { 
                if(StringUtils.isEmpty(winningRecord.getText())){
                  	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请填写获奖情况");
                }else{
                    relgPer.setWinningRecord(winningRecord.getText());
                }
            }

            if (ckflg) { 
                if(StringUtils.isEmpty(results.getText())){
                  	ckflg = false;
                    JOptionPane.showMessageDialog(null,"请填写主要业绩简述");
                }else{
                    relgPer.setResults(results.getText());
                }
            }
            
            if (ckflg) {
                if(StringUtils.isEmpty(photo.getText())){
                    ckflg = false;
                    JOptionPane.showMessageDialog(null,"请选择照片");
                }else{
                	if(!photo.getText().contains(".jpg")){
                        ckflg = false;
                        JOptionPane.showMessageDialog(null,"照片只能为.jpg格式");
                	} else {
                		if (!photo.getText().equals(relgPer.getPhoto())) {
                    		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-context.xml");
                    		RelgPerService relgPerService = (RelgPerService)ctx.getBean(RelgPerService.class); 		
                    		String path = relgPerService.savePhoto(new File(photo.getText()));
                            relgPer.setPhoto(path);
                		}
                	}
                }
            }

            if (ckflg) {   
            	relgPer.setNotClose("1");
                dialog.setVisible(false);
            }
        }
    }


}
