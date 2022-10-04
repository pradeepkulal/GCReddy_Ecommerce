package com.GCReddy_v1.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	
	public ReadConfig()   {
		File src= new File("C:\\Users\\USER\\eclipse-workspace\\GCReddy_v1\\Configuration\\config.properties");
		try {
			FileInputStream file=new FileInputStream(src);
			prop=new Properties();
			prop.load(file);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	public String getURL() {
		return prop.getProperty("URL");
	}
	public String getFireFoxPath() {
		return prop.getProperty("FireFoxPath");
	}
	public String getCromePath() {
		return prop.getProperty("ChromePath");
	}
	public String getEdgePath() {
		return prop.getProperty("EdgePath");
	}
	public String getUsername() {
		return prop.getProperty("username");
	}
	public String getPassword() {
		return prop.getProperty("password");
	}
}
