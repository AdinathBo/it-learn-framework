package com.itlearn.pages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.itlearn.utility.BrowserFactory;
import com.itlearn.utility.ConfigDataProvider;

public class BaseTest {
	public WebDriver driver;
	public ConfigDataProvider config = new ConfigDataProvider();

	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	public void captureScreenShot(WebDriver driver,String testName) throws IOException 
	{
		// Step 1 :Convert webdriver object to TakeScreenshot interface
		TakesScreenshot screenshot= ((TakesScreenshot)driver);
		
		// Step 2 :call getScreenshotAs method to capture image file
		
		File src= screenshot.getScreenshotAs(OutputType.FILE);
		File srcpath=new File("."+"//Screenshots//"+ testName + ".png");
		System.out.println("This is screenshot section");
		
		// Step 3 : copy image file to destination
		FileUtils.copyFile(src, srcpath);
		
	}
}
