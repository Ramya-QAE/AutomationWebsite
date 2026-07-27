package com.commonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.driver.BaseTest;

public class CommonUtilities {

	private static  Properties prop;
 	private static FileInputStream fis; 
 	private static String page;
	
	 static  
	{
		try {
			prop = new Properties();
			fis = new FileInputStream("C:\\Users\\Ramya\\eclipse-workspace\\AutomationWebsite\\src\\test\\resources\\UserData.properties");
			
			prop.load(fis);
			fis.close();
			
		    
		    
			
		}
		catch (IOException i)
		{
			System.out.println("Caught exception ");
		}
		
	}
	
	public static String getPage() 
	{
		if(page == null && prop !=null)
		{
			 page = prop.getProperty("formURL");
		}
		return page;
	}
	
	public static void captureScreen(String Method)
	{
		try {
		TakesScreenshot screen = ((TakesScreenshot) BaseTest.getDriver()); 
		
		File src = screen.getScreenshotAs(OutputType.FILE); 
		String screenshotDir = System.getProperty("user.dir") + File.separator + "target" + File.separator + "Screenshots";
	    File dest = new File(screenshotDir + File.separator + Method + ".png");
	    FileUtils.copyFile(src, dest);
//		File dest = new File( "C:\\Users\\Ramya\\eclipse-workspace\\AutomationWebsite\\target\\Screenshots\\"+Method + ".png");
//		
//		FileUtils.copyFile(src, dest); 
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
