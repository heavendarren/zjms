package com.tfkj.zongjiao.panel;

import com.tfkj.zongjiao.entity.Item;
import com.tfkj.zongjiao.util.CityUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JComboboxOfChina {  
    private JComboBox combobox_privince;  
    private JComboBox combobox_city;  
    private JComboBox combobox_area;  
    private DefaultComboBoxModel model1 = new DefaultComboBoxModel();  
    private DefaultComboBoxModel model2 = new DefaultComboBoxModel();  
    private DefaultComboBoxModel model3 = new DefaultComboBoxModel();  
      
    public JComboboxOfChina(String privince, String city, String area) {
    	if (privince==null) {
    		privince = "";
    	}
    	if (city==null) {
    		city = "";
    	}
    	if (area==null) {
    		area = "";
    	}
    	
        //设置一级数据
        List<Item> pList = CityUtils.getProvinceItemList();
        for(Item str : pList) {  
            model1.addElement(str);
            if (str.getKey().equals(privince)) {
            	model1.setSelectedItem(str);
            }
        }
        combobox_privince = new JComboBox(model1);  
    	
        //设置二级数据  
        List<Item> cList = CityUtils.getCityItemList(privince);
        for(Item str : cList) {  
            model2.addElement(str);
            if (str.getKey().equals(city)) {
            	model2.setSelectedItem(str);
            }
        }
        combobox_city = new JComboBox(model2);
    	
        //设置三级数据  
        List<Item> aList = CityUtils.getArraItemList(city);
        for(Item str : aList) {  
            model3.addElement(str);
            if (str.getKey().equals(area)) {
            	model3.setSelectedItem(str);
            }
        }
        combobox_area = new JComboBox(model3);  
    	
    	
    	ActionListener cityListener =	new ActionListener() {  
            public void actionPerformed(ActionEvent evt) {
                JComboBox source = (JComboBox) evt.getSource();  
                String city = ((Item)source.getSelectedItem()).getKey();  
                List<Item> districts = CityUtils.getArraItemList(city);
                model3.removeAllElements();  
                for (Item str : districts) {  
                    model3.addElement(str);  
                }  
            }  
        };
        combobox_privince.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent evt) {  
                JComboBox source = (JComboBox) evt.getSource();  
                //根据获取的省份找到它下面的级别的市  
                String provinces = ((Item)source.getSelectedItem()).getKey();  
                List<Item> cities = CityUtils.getCityItemList(provinces); 
                combobox_city.removeActionListener(cityListener);
                model2.removeAllElements();                
                for (Item str : cities) {  
                    model2.addElement(str);  
                }
                combobox_city.addActionListener(cityListener);
                model3.removeAllElements();  
                model3.addElement(new Item("", "县"));
            }  
        });  
  

    }  
  
    public JComboBox getCombobox_privince() { 
        return combobox_privince;  
    }  
  
    public JComboBox getCombobox_city() {  
        return combobox_city;  
    }  
  
    public JComboBox getCombobox_area() {  
        return combobox_area;  
    }  
}  