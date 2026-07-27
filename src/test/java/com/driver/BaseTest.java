package com.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.commonUtils.CommonUtilities;

import org.openqa.selenium.firefox.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class BaseTest {

	private static ThreadLocal<WebDriver> driver1 = new ThreadLocal<>(); 
//	private  WebDriver driver = new ChromeDriver(); 
	private static CommonUtilities cu ; 
	

	public static  WebDriver setDriver()
	{ 
		if( driver1.get() == null)
		{
			//driver.set( new ChromeDriver()); 
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(CommonUtilities.getPage());
			
			driver1.set(driver);
		}
		
		return getDriver();
		
	}
	public static WebDriver getDriver()
	{
		return driver1.get();
	}

	
	public static void exit()
	{
		driver1.get().quit(); 
		driver1.remove();
		
	}
	
	
}
