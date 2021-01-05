package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		logger.info("Clicking Add customer..");
		logger.info("URL--- " + driver.getCurrentUrl());
		//driver.findElement(By.partialLinkText("New Customer")).click();
		driver.get("http://demo.guru99.com/V1/html/addcustomerpage.php");
		//addcust.clickAddNewCustomer();
		Thread.sleep(3000);
		
		logger.info("entering customer details");
		addcust.custName("Ranjan");
		addcust.custgender("male");
		addcust.custdob("1986", "05", "19");
		Thread.sleep(3000);
		addcust.custaddress("India");
		addcust.custcity("Bangalore");
		addcust.custstate("KA");
		addcust.custpinno("500001");
		addcust.custtelephoneno("91145678");
		String email = randomString() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		
		addcust.custsubmit();
		Thread.sleep(3000);
		
		logger.info ("Validing Customer details");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}

	}

}
