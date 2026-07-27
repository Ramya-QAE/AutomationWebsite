package com.commonUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener  {

	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		CommonUtilities.captureScreen(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

	
		CommonUtilities.captureScreen(result.getMethod().getMethodName());
		
	}


	
	
	

}
