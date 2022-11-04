package com.DWA.testcases;

import java.sql.Date;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.DWA.base.BaseClass;
import com.DWA.pageObjects.LoginPage;
import com.DWA.utilities.ReadConfig;

public class TC_01_LoginTest extends BaseClass {
	@Test
	public void loginWithValidCredentials() {
		LoginPage lg = new LoginPage(driver);
		lg.enterUserId(ReadConfig.property.getProperty("userId"));
		logger.info("UserID entered successfully.");
		lg.enterPassword(ReadConfig.property.getProperty("userPassword"));
		logger.info("UserPassword entered successfully.");
		lg.loginClick();
		logger.info("LoggedIn successfully.");

		// SoftAssert softAssert = new SoftAssert();

		// assertionOne
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://democonsole.dwacommerce.com/catalog/control/main";
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test
	public void loginWithInvalidPassword() {
		LoginPage lg = new LoginPage(driver);
		lg.enterUserId(ReadConfig.property.getProperty("userId"));
		logger.info("UserID entered successfully.");
		lg.enterPassword(ReadConfig.property.getProperty("userPassword"+"9879"));
		logger.info("UserPassword entered successfully.");
		lg.loginClick();
		logger.info("LoggedIn successfully.");

		// SoftAssert softAssert = new SoftAssert();

		// assertionOne
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://democonsole.dwacommerce.com/catalog/control/main";
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	@Test
	public void loginWithInvalidUserId() {
		LoginPage lg = new LoginPage(driver);
		lg.enterUserId(ReadConfig.property.getProperty("userId" +"hjkkhkj"));
		logger.info("UserID entered successfully.");
		lg.enterPassword(ReadConfig.property.getProperty("userPassword"));
		logger.info("UserPassword entered successfully.");
		lg.loginClick();
		logger.info("LoggedIn successfully.");

		// SoftAssert softAssert = new SoftAssert();

		// assertionOne
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://democonsole.dwacommerce.com/catalog/control/main";
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	public void loginWithoutCredentials() {

	}

	public String generateTimeStamp() {
		Date date = new Date(0);
		return date.toString().replace(' ', '_').replace(':', '_');
	}

}
