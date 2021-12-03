package com.inetBanking.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.HomePage;
import com.inetBanking.pageObjects.LoginPage;

public class LoginPageTest extends BaseClass{
    
	
    LoginPage loginPage;
    HomePage homePage;
    
	public LoginPageTest() throws IOException {
		super();
		
	}
	
	@Test(priority=1)
	public void validateGuru99LogoTest() 
	{   
		loginPage=new LoginPage();
		boolean result=loginPage.validateGuru99Logo();
		Assert.assertTrue(result);
		logger.info("Validating Login Page Logo");
	}
	
	@Test(priority=2)
	public void validateTitleTest() 
	{
		loginPage=new LoginPage();
		String actTitle=loginPage.validateTitle();
		Assert.assertEquals(actTitle,"Guru99 Bank Home Page");
		logger.info("Validating Login Page Title");
	}
	
	@Test(priority=3)
	public void loginTest() 
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		logger.info("Login Done Successfully");
		
	}

}
