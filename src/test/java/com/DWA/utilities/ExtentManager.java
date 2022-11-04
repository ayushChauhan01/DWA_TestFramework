package com.DWA.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ExtentReports configureReport() {
		
		//extent report objects initialization
		htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//adding system info/environment info to report
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "DWA_Test");
		extent.setSystemInfo("Tester", "Ayush");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	
		//configuration to change esthetics of the report
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		return extent;
				
	}
	
	public static void endReport() {
		extent.flush();
	}
}
