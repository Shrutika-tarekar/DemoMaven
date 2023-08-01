package com.the.utilies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyUtils {

	public static String readProperty(String key) throws Exception {
		
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
}
