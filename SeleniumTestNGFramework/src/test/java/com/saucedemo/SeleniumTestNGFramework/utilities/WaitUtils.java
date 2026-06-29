package com.saucedemo.SeleniumTestNGFramework.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WaitUtils {

	private final static int timeOut = 20;

	private WaitUtils() {
	}

	public static WebDriverWait getWait(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	}

	public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element) {
		return getWait(driver).until(ExpectedConditions.visibilityOf(element));
	}
	
	public static Boolean waitForInVisibilityOfElement(WebDriver driver, WebElement element) {
		return getWait(driver).until(ExpectedConditions.invisibilityOf(element));
	}
	
	
}
