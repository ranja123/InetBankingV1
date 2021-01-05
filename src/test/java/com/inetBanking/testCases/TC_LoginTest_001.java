package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("User Name Entered");
		lp.setPassword(password);
		logger.info("Password Entered");
		
		lp.clickSubmit();
		
		if (driver.getTitle().equals("GTPL Bank Manager HomePage")){
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		} else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
	}

}
