package com.wh.www.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigMapper {
	
	static Properties pro = new Properties();
	//1.���������ļ�
	static {
		init();
	}
	public static void init() {
		try {
			pro.load(ConfigMapper.class.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//2.�ṩ��ȡ�ļ��ķ���
	public static String get(String key) {
		return pro.getProperty(key);
	}
	
	public static void main(String[] args) {
		System.out.println(ConfigMapper.get("user"));
	}
}

