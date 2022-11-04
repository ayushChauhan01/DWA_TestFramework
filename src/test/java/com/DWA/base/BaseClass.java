package com.DWA.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.DWA.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends ReadConfig {

	public static WebDriver driver;
	public static Logger logger;

	@BeforeMethod
	public void setUp() {

		ReadConfig.InitializeConfigFile();

		String browser = ReadConfig.property.getProperty("browserType");
		String url = ReadConfig.property.getProperty("appUrl");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.edgedriver();
			driver = new SafariDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

		logger = LogManager.getLogger("DWA_Test");
		logger.info("webiste launced");
	}
	/*
	 * @AfterMethod public void screenshotCapture(ITestResult result) {
	 * if(result.getStatus() == ITestResult.FAILURE) {
	 * captureScreenshot(result.getTestContext().getName()+ "_"
	 * +result.getMethod().getMethodName()+".jpg"); } }
	 */

	@AfterMethod
	public void tearDown() {
		logger.info("< Successfully exited >");
		driver.close();
		driver.quit();
	}

	public String takeScreenshot(String testName) {

		File sourceScreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationScreenshotFile = new File(
				System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png");
		try {
			FileUtils.copyFile(sourceScreenshotFile, destinationScreenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return destinationScreenshotFile.getAbsolutePath();

	}

}
