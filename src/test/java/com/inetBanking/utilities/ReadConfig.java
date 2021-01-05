package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.inetBanking.testCases.BaseClass;

public class ReadConfig {
	
	Properties prop;
	Logger logger;
	
	public ReadConfig() {
		File src = new File ("./configuration/config.properties");
		
		try{
			FileInputStream fis = new FileInputStream (src);
			prop = new Properties();
			prop.load(fis);
		} catch	(Exception e) {
			BaseClass.logger.info("Exception is : "+ e.getMessage());
		}
		
	}
		
		
	public String getApplicationUrl() {
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() {
		String uname = prop.getProperty("username");
		return uname;
	}
	
	public String getPassword() {
		String pwd = prop.getProperty("password");
		return pwd;
	}
	
	public String getFirefoxPath() {
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}


	public String getChromePath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}
}
