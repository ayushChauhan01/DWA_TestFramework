package com.DWA.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver d){
		PageFactory.initElements(d, this);
	}
	
	@FindBy(name="USERNAME")
	WebElement idField;
	
	@FindBy(name="PASSWORD")
	WebElement passwordField;
	
	@FindBy(xpath="//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/center[1]/div[1]/div[2]/form[1]/div[3]/button[1]")
	WebElement loginButton;
	
	@FindBy(linkText="Forgot Your Password?")
	WebElement forgotPwdField;
	
	public void enterUserId(String requiredId) {
		idField.clear();
		idField.sendKeys(requiredId);
	}
	
	public void enterPassword(String reqPwd) {
		passwordField.clear();
		passwordField.sendKeys(reqPwd);
	}
	
	public void loginClick() {
		loginButton.click();
	}
	
	public void forgotClick() {
		forgotPwdField.click();
	}
}
