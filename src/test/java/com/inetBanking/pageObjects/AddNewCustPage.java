package com.inetBanking.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking.testCases.BaseClass;

public class AddNewCustPage extends BaseClass{
	
	public AddNewCustPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="name")
	WebElement txtName;
	@FindBy(name="dob")
	WebElement txtDob;
	@FindBy(name="addr")
	WebElement txtAddr;
	@FindBy(name="city")
	WebElement txtCity;
	@FindBy(name="state")
	WebElement txtstate;
	@FindBy(name="pinno")
	WebElement txtPinno;
	@FindBy(name="telephoneno")
	WebElement txtPhone;
	@FindBy(name="emailid")
	WebElement txtEmail;
	@FindBy(name="password")
	WebElement txtPassword;
	@FindBy(name="sub")
	WebElement submitBtn;
	
	public void addNewCuctomer(String name,String dob,String addr,String city,String state,
			String pin,String phone,String email,String pass)
	{
		txtName.sendKeys(name);
		txtDob.sendKeys(dob);
		txtAddr.sendKeys(addr);
		txtCity.sendKeys(city);
		txtstate.sendKeys(state);
		txtPinno.sendKeys(pin);
		txtPhone.sendKeys(phone);
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(pass);
		submitBtn.click();
	}

}
