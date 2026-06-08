package com.saucedemo.SeleniumTestNGFramework.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.saucedemo.SeleniumTestNGFramework.utilities.DriverFactory;

public class BaseTest {
	protected WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = DriverFactory.getDriver("chrome");

		driver.get("https://www.saucedemo.com/");
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
