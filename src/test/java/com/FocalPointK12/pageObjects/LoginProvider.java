package com.FocalPointK12.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginProvider 
{
	
	WebDriver ldriver;
	
	public LoginProvider(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//img[contains(@src,'/IDServer/images/logo2.png')]")
	@CacheLookup
	WebElement Provider;
	
	public void clickProvider() 
	{
		Provider.click();
	}
			
}
