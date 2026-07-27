package com.pages.eachPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.BaseTest;

 public class FormPage  {
	private WebDriver driver;
	WebDriverWait w ; 
	
	
	By firstName = By.name("firstName"); 
	By lastName = By.id("v-lastname"); 
	By email1 = By.id("v-email"); 
	By age1 = By.id("v-age");
	By websiteURL =  By.id("v-url");
	By message = By.id("v-message");
	By priority = By.id("v-priority");
	By submitbtn = By.id("form-submit-btn");
	By resetbtn = By.id("form-reset-btn");
	By getSuccessResult = By.id("form-result");
	
	
	public FormPage (WebDriver driver)
	{
		this.driver= driver;
	}

	public void enterFirstName(String fname)
	{
		driver.findElement(firstName).sendKeys(fname);
	}
	public boolean getEnteredTextFirstName()
	{
		String classAttribute = driver.findElement(firstName).getAttribute("class");
		return classAttribute.contains("is-valid");
	}
	public void enterLasttName(String lname)
	{
		driver.findElement(lastName).sendKeys(lname);
	}
	public void enterEmail(String email)
	{
		driver.findElement(email1).sendKeys(email);
	}
	
	public void enterAge(String age)
	{
		driver.findElement(age1).sendKeys(age);
	}
	
	public void enterWebsiteUrl(String webUrl)
	{
		driver.findElement(websiteURL).sendKeys(webUrl);
	}public void enterMessage(String msg)
	{
		driver.findElement(message).sendKeys(msg);
	}public void selectPriority(int p)
	
	{
		Select s = new Select(driver.findElement(priority));
		s.selectByIndex(p);
	}
	
	
	public void enterFormDetails(String fname , String lname, String email , String age , String WebsiteU , String message , int priority )
	{
		enterFirstName(fname);
		enterLasttName(lname);
		enterEmail(email);
		enterWebsiteUrl(WebsiteU);
		enterMessage(message);
		selectPriority(priority);
		
	}
	public void clickSubmit()
	{
		try {
			driver.findElement(submitbtn).submit();
			w = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(100));
			w.until(ExpectedConditions.elementToBeClickable(submitbtn));
			
			//driver.findElement(submitbtn).sendKeys(Keys.ENTER);
			
		
//			Actions ac = new Actions(driver);
//			ac.moveToElement(driver.findElement(submitbtn)).click().build();
//			ac.perform();
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0].click()",driver.findElement(submitbtn) );
			}
			catch (ElementClickInterceptedException elementclick)
			{
			w = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(100));
			w.until(ExpectedConditions.elementToBeClickable(driver.findElement(submitbtn)));
			}
		
	}
	
	public String getSuccessMsg()
	{
		String successMsg = driver.findElement(getSuccessResult).getText();
		return successMsg;
		 
	}
	
	
}
