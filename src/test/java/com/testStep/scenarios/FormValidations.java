package com.testStep.scenarios;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertListContains;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commonUtils.CommonUtilities;
import com.driver.BaseTest;
import com.pages.eachPage.FormPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class FormValidations {
	private WebDriver driver;
	private FormPage fp ;
	CommonUtilities cu ; 
	
	//WebDriverWait w ; 
	
	@Given("the user in form validation page")
	public void the_user_in_form_validation_page() {
	    
		fp = new FormPage(BaseTest.getDriver());
		BaseTest.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	
		
	}
	@When("enter values in all the form input fields")
	public void enter_values_in_all_the_form_input_fields() {
	  

		fp.enterFormDetails("ramya" , "reng" , "ramya@reng.com" , "29" , "https://www.abc.com" ,"Thanks for the website", 3 );
//assertTrue(fp.getEnteredTextFirstName());
	}
	@Then("user should be able to input successfully")
	public void user_should_be_able_to_input_successfully() {
	   
	assertTrue(fp.getEnteredTextFirstName());
	}
	@Then("Click submit button , form should be submitted successfully")
	public void click_submit_button_form_should_be_submitted_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	
		BaseTest.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
		fp.clickSubmit();
		assertTrue(fp.getSuccessMsg().contains("Form submitted successfully!"));
		System.out.println(fp.getSuccessMsg());
		//CommonUtilities.captureScreen();
		
	}

}
