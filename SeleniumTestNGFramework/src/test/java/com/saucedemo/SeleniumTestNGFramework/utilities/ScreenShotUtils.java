package com.saucedemo.SeleniumTestNGFramework.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class ScreenShotUtils {

	private ScreenShotUtils() {
		// to prevent object creation
	}

	public static String generateFilePath(String testName) {
		String filePath = System.getProperty("user.dir") + File.separator + "Screenshots";

		File directory = new File(filePath);

		if (!directory.exists()) {
			directory.mkdir();
		}

		return filePath + File.separator + testName + "_" + LocalTime.now() + ".png";
	}

	public static String saveScreenshot(File sourceFile, String testName) {
		String screenshotPath = generateFilePath(testName);

		try {
			FileUtils.copyFile(sourceFile, new File(screenshotPath));
		} catch (IOException e) {
			throw new RuntimeException("Faild to save screenshot" + testName, e);
		}

		return screenshotPath;

	}

	// to get full page screenshot
	public static String getFullScreenshot(WebDriver driver, String testName) {

		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		return saveScreenshot(screenShot, testName);

	}

	// to get webelement screen shot and here WebElement will provide
	// getScreenshotAs() so we dont need webdriver
	public static String getWebElementScreenShot(WebElement element, String testName) {

		File screenShot = element.getScreenshotAs(OutputType.FILE);

		return saveScreenshot(screenShot, testName);
	}
	// "For a full-page screenshot, I need WebDriver because Selenium captures the
	// browser window through the driver. For an element screenshot, WebElement
	// already provides getScreenshotAs(), so the driver is unnecessary. I avoid
	// passing unused parameters to keep the API clean and follow good design
	// principles."

	public static String getSectionScreenshot(WebDriver driver, WebElement section, String testName)
			throws IOException {

		File fullScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		BufferedImage fullImage = ImageIO.read(fullScreenshot);
		Point location = section.getLocation();
		Dimension size = section.getSize();

		BufferedImage croppedImage = fullImage.getSubimage(location.getX(), location.getY(), size.getHeight(),
				size.getWidth());

		File croppedFile = File.createTempFile("cropped_", ".png");
		ImageIO.write(croppedImage, "png", croppedFile);

		return saveScreenshot(croppedFile, testName);

	}

}
