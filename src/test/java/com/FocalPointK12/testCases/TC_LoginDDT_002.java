package com.FocalPointK12.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FocalPointK12.pageObjects.LoginPage;
import com.FocalPointK12.pageObjects.LoginProvider;
import com.FocalPointK12.utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		LoginProvider lpv=new LoginProvider(driver);
		lpv.clickProvider();
		logger.info("Clicked the required provider FocalPointK12");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Entered UserName");
		lp.setPassword(pwd);
		logger.info("Entered Password");
		lp.clickSubmit();
		logger.info("Clicked sign-in button");
		Thread.sleep(10000);
		lp.Profileclick();
		logger.info("Clicked on profile");
		lp.logoutclick();
		logger.info("Clicked logout");
		Thread.sleep(10000);
		if(driver.getTitle().equals("FocalpointK12 | Username / Password Sign In")) 
		{
			Assert.assertTrue(true);
			logger.info("LoginDDTTest Passed");
		}
		else 
		{
			captureScreen(driver,"LoginDDT");
			Assert.assertTrue(false);
			logger.info("LoginDDTTest Failed");			 
		}
				
	}
	
		
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/FocalPointK12/testData/LoginTestData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}
