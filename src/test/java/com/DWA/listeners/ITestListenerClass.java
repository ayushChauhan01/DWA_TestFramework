package com.DWA.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.DWA.base.BaseClass;
import com.DWA.utilities.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ITestListenerClass extends BaseClass implements ITestListener {

	// Actions action = new Actions();
	ExtentReports report = ExtentManager.configureReport();
	ExtentTest etest;

	@Override
	public void onTestStart(ITestResult result) {
		// onTestStart adding the test to the report object created above
		// also result.getName gives the name the test method being run
		String testName = result.getName();
		etest = report.createTest(testName);
		etest.log(Status.INFO, testName + " : Execution Started.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		etest.log(Status.PASS, testName + " : Executed Successfully.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
/*
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
*/
		etest.addScreenCaptureFromPath(takeScreenshot(testName), testName);
		etest.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		etest.log(Status.SKIP, testName+": Skipped!");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
