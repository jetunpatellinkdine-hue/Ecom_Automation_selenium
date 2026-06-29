package com.saucedemo.SeleniumTestNGFramework.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.saucedemo.SeleniumTestNGFramework.utilities.ConfigReader;
import com.saucedemo.SeleniumTestNGFramework.utilities.DriverFactory;

public class BaseTest {
	protected WebDriver driver;

	// to get browser connection
	@BeforeMethod
	public void setup() {
		driver = DriverFactory.getDriver(ConfigReader.getProperty("browser"));

		driver.get(ConfigReader.getUrl());
	}

	// to close to browser
	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
