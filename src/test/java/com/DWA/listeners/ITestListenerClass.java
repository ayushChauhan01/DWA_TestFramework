package com.DWA.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.DWA.base.BaseClass;

public class ITestListenerClass extends BaseClass implements ITestListener{


	@Override
	public void onTestFailure(ITestResult result) {
 
		System.out.println(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName());
		captureScreenshot(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName()+".jpg");
	}

/*	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}
*/
}
