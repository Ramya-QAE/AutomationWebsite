package com.testStep.scenarios;

import org.testng.annotations.BeforeTest;

import com.commonUtils.CommonUtilities;
import com.driver.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;



public class Hooks {
	@Before
	public void baseSetup()
	{
		BaseTest.setDriver(); 
	}

	@After
	public void tearDownScenario()
	{
	
	//	BaseTest.exit();
	}
}
