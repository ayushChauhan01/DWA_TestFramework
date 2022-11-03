package com.DWA.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DWA.base.BaseClass;
import com.DWA.pageObjects.LoginPage;
import com.DWA.utilities.ReadConfig;

public class TC_01_LoginTest extends BaseClass{
	@Test(testName = "DWA_website_loginTest")
	public void login() {
		LoginPage lg = new LoginPage(driver);
		lg.enterUserId(ReadConfig.property.getProperty("userId"));
		logger.info("UserID entered successfully.");
		lg.enterPassword(ReadConfig.property.getProperty("userPassword"));
		logger.info("UserPassword entered successfully.");
		lg.loginClick();
		logger.info("LoggedIn successfully.");
		
		SoftAssert softAssert = new SoftAssert();
		
		//assertionOne
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://democonsole.dwacommerce.com/catalog/control/main";
		AssertJUnit.assertEquals(actualUrl, expectedUrl, "Url is mismatched");
		}
	
}
