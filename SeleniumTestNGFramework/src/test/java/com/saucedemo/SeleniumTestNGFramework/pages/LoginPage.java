package com.saucedemo.SeleniumTestNGFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	WebElement txtusername;

	@FindBy(id = "password")
	WebElement txtpassword;

	@FindBy(id = "login-button")
	WebElement loginbtn;

	public void enterusername(String username) {
		txtusername.sendKeys(username);
	}

	public void enterpassword(String password) {
		txtpassword.sendKeys(password);
	}

	public void clickbtn() {
		loginbtn.click();
	}

	public void login(String username, String password) {
		enterusername(username);
		enterpassword(password);
		clickbtn();
	}
}
