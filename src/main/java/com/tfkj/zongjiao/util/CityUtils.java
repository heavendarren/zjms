/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.zongjiao.util;

import com.tfkj.zongjiao.dao.RelgPerDao;
import com.tfkj.zongjiao.entity.Item;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 省市县三级下拉工具类
 * @author ThinkGem
 * @version 2013-5-29
 */
public class CityUtils {
	
	static ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-context.xml");
	private static RelgPerDao relgPerDao = (RelgPerDao)ctx.getBean(RelgPerDao.class);
	
	
	public static List<Item> getProvinceItemList() {
		List<Map<String, String>> list = getProvinceList();
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(new Item("", "省"));
		for (Map<String, String> map : list) {
			Item item = new Item(map.get("CKEY"), map.get("VALUE"));
			itemList.add(item);
		}
		return itemList;
		
	}
	
	public static List<Item> getCityItemList(String father) {
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(new Item("", "市"));
		if (StringUtils.isBlank(father)) {
			return itemList;
		}
		
		List<Map<String, String>> list = getCityList(father);
		
		for (Map<String, String> map : list) {
			Item item = new Item(map.get("CKEY"), map.get("VALUE"));
			itemList.add(item);
		}
		return itemList;
		
	}
	
	public static List<Item> getArraItemList(String father) {
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(new Item("", "县"));
		if (StringUtils.isBlank(father)) {
			return itemList;
		}
		List<Map<String, String>> list = getAreaList(father);
		for (Map<String, String> map : list) {
			Item item = new Item(map.get("CKEY"), map.get("VALUE"));
			itemList.add(item);
		}
		return itemList;
		
	}

	
	public static List<Map<String, String>> getProvinceList() {
		return relgPerDao.getProvinceList();
	}
	
	public static List<Map<String, String>> getCityList(String father) {
		return relgPerDao.getCityList(father);
	}
	
	public static List<Map<String, String>> getAreaList(String father) {
		return relgPerDao.getAreaList(father);
	}
}
