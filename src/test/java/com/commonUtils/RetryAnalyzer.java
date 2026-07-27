package com.commonUtils;

import org.testng.IReporter;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int count =0 ; 
	int maxtry = 2; 
	
	@Override
	public boolean retry(ITestResult result) {
		
		if (count<maxtry)
		{
			count++; 
			System.out.println("Retrying test "+result.getName() ); 
			CommonUtilities.captureScreen(result.getMethod().getMethodName());
			return true;
		}
		
		CommonUtilities.captureScreen(result.getMethod().getMethodName());
		return false;
		
	}
	
	

}
