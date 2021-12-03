package com.inetBanking.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking.testCases.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="uid")
	WebElement txtusername;
	@FindBy(name="password")
	WebElement txtpassword;
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	@FindBy(xpath="//img[@alt='Guru99 Demo Sites']")
	WebElement guru99Logo;
	@FindBy(xpath="//a[text()='Log out']")
	WebElement linkLogout;
	
	
	public boolean validateGuru99Logo()
	{
		return guru99Logo.isDisplayed();
	}
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String un,String pwd)
	{
		txtusername.sendKeys(un);
		txtpassword.sendKeys(pwd);
		btnLogin.click();
		return new HomePage();
	}
	
	public void clickOnLogoutLink()
	{
		linkLogout.click();
	}
	
	

}
