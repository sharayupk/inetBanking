package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddNewCustPage;
import com.inetBanking.pageObjects.HomePage;
import com.inetBanking.pageObjects.LoginPage;

public class AddNewCustPageTest extends BaseClass{
	
	LoginPage loginPage;
    HomePage homePage;
    AddNewCustPage addNewCust;
    
	public AddNewCustPageTest()
	{
		super();
	}
	
	@Test(priority=1)
	public void addNewCuctomerTest() throws InterruptedException, IOException 
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		logger.info("Login Done Successfully");
		
		addNewCust=homePage.clickOnNewCustomerLink();
		logger.info("Clicked on New Customer Link on Home page");
		
		addNewCust.addNewCuctomer("Jay", "23-12-2000", "Pimpri", "Pune", "Maharashtra", "453432", "7896575678", 
				"jay1@gmail.com", "jay@12");
		
		/*Code for generating random email
		String email=randomString+"@gmail.com";
		addNewCust.txtEmail(email);*/
		
		Thread.sleep(1000);
		
		logger.info("New Customer Added Successfully");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "addNewCuctomerTest");
			Assert.assertTrue(false);
		}
				
	}
	
	
}
