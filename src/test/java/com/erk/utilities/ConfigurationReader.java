package com.erk.utilities;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class ConfigurationReader {

	private static Properties configFile;
	static {
	
	try {
		String path="configuration.properties";
		FileInputStream fileinput= new FileInputStream(path);
		
		configFile = new Properties();
		configFile.load(fileinput);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

	public static String getProperty(String keyName) {
		return configFile.getProperty(keyName);
	}
	
	
	
	
	
	
	
	
	
	
	
}
