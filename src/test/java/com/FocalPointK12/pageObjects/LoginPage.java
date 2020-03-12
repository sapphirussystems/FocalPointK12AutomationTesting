package com.FocalPointK12.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="UserName")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(name="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath ="//input[@type = 'submit' and @value = 'Sign In']")
	@CacheLookup
	WebElement Signin;
	
	@FindBy(css ="#header > div > div:nth-child(2) > div.top-nav > ul.nav-right.pull-right.list-unstyled.ng-scope > li:nth-child(3) > md-menu > button > img")
	@CacheLookup
	WebElement Clickingprofile;
	
	@FindBy(css ="#menu_container_4 > md-menu-content > md-menu-item:nth-child(3) > a > span")
	@CacheLookup
	WebElement logout;
	
	
	
	public void setUserName(String Uname) 
	{
		txtUsername.sendKeys(Uname);
	}
	
	public void setPassword(String Pwd) 
	{
		txtPassword.sendKeys(Pwd);
	}

	public void clickSubmit() 
	{
		Signin.click();
	}
	
	public void Profileclick() 
	{
		Clickingprofile.click();
	}
	
	public void logoutclick() 
	{
		logout.click();
	}
	
	
}
