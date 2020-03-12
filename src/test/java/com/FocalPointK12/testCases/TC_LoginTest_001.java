package com.FocalPointK12.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.FocalPointK12.pageObjects.LoginPage;
import com.FocalPointK12.pageObjects.LoginProvider;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void logintest() throws InterruptedException, IOException 
	{
				
		LoginProvider lpv=new LoginProvider(driver);
		lpv.clickProvider();
		logger.info("Clicked the required provider FocalPointK12");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered UserName");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		logger.info("Clicked sign-in button");
		Thread.sleep(10000);
		if(driver.getTitle().equals("Personalized Learning Platform | Courses")) 
		{
			Assert.assertTrue(true);
			logger.info("LoginTest Passed");
		}
		else 
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("LoginTest Failed");			 
		}
	}
}
