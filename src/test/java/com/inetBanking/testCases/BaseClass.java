package com.inetBanking.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.inetBanking.utilities.Utility;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	
	public BaseClass() 
	{
		FileInputStream fis;
		try {
			fis = new FileInputStream("./Configuration/config.properties");
			prop =new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@BeforeMethod
	public void initialization()
	{
		logger=Logger.getLogger("inetBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath"));
			driver=new ChromeDriver();
			logger.info("Launching Chrome Browser");
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette",prop.getProperty("firefoxpath"));
			driver=new FirefoxDriver();
			logger.info("Launching Firefox Browser");
		}
		
		driver.get(prop.getProperty("url"));
		logger.info("Launching URL of the Application");
		
		driver.manage().window().maximize();
		logger.info("Maximizing Browser");
		
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedNum=RandomStringUtils.randomNumeric(8);
		return generatedNum;
	}

}
