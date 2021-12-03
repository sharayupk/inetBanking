package com.inetBanking.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking.testCases.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement newCustomerLink;
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
	WebElement managerID;
	
	public String validateManagerID()
	{
		return managerID.getText();
	}
	
	public AddNewCustPage clickOnNewCustomerLink()
	{
		newCustomerLink.click();
		return new AddNewCustPage();
	}

}
