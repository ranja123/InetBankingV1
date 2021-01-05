package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;

//import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig(); 
	public String baseUrl = readConfig.getApplicationUrl();
	public String userName = readConfig.getUserName();
	public String password = readConfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
			
		} else if (br.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + readConfig.getChromePath());
			driver = new FirefoxDriver();			
		}


		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		//Log4j
		
		logger = Logger.getLogger("E-Banking");
		PropertyConfigurator.configure("log4j.properties");
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public String randomString() {
		String genStr = RandomStringUtils.randomAlphabetic(8);
		return (genStr);
	}
	
	public String randomNum() {
		String genStr = RandomStringUtils.randomNumeric(4);
		return (genStr);
	}

}
