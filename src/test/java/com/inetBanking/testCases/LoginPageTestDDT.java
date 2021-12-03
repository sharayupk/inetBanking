package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class LoginPageTestDDT extends BaseClass{
	
	@Test(dataProvider="loginTest")
	public void loginTest(String uname,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage();
		lp.login(uname,pwd);
		
		Thread.sleep(3000);
		
		logger.info("Login Done Successfully");
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickOnLogoutLink();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //Close logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
	}

	@DataProvider(name="loginTest")
	String [][] getData() throws IOException
	{
		String excelPath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetBanking\\testData\\LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(excelPath, "Sheet1");
		int cellnum=XLUtils.getCellCount(excelPath, "Sheet1",1);
		
		String loginData[][]=new String[rownum][cellnum];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<cellnum;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(excelPath, "Sheet1",i,j);
			}
		}
		
		return loginData;
	}
}
