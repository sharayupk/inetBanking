package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddNewCustPage;
import com.inetBanking.pageObjects.HomePage;
import com.inetBanking.pageObjects.LoginPage;

public class HomePageTest extends BaseClass{
	
	LoginPage loginPage;
    HomePage homePage;
    AddNewCustPage addNewCust;
    
	public HomePageTest()
	{
		super();
	}
	
	@Test(priority=1)
	public void validateManagerIDTest()
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		String actText=homePage.validateManagerID();
		Assert.assertEquals(actText,"Manger Id : mngr26593");
		
		logger.info("Validating if Manager ID is present on Home Page");
	}
	
	@Test(priority=2)
	public void clickOnAddNewCustLinkTest()
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		addNewCust=homePage.clickOnNewCustomerLink();
		
		logger.info("Clicking on New Customer Link on Home Page");
	}

}
