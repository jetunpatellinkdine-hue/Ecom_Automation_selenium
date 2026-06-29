package com.saucedemo.SeleniumTestNGFramework.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentManager {

	private static ExtentReports extent;

	private ExtentManager() {

	}

	public static String getFilePath() {
		String reportPath = System.getProperty("user.dir") + File.separator + "Reports";

		return reportPath + File.separator + "ExtentReport"
				+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	}

	public static ExtentReports getExtentReport() {
		if (extent == null) {
			String filePath = getFilePath();

			ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filePath);

			extentSparkReporter.config().setDocumentTitle("Test Execution Report");
			extentSparkReporter.config().setTheme(Theme.STANDARD);
			extentSparkReporter.config().setReportName("selenium Test Report");
			extentSparkReporter.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");

			extent = new ExtentReports();
			extent.attachReporter(extentSparkReporter);

			extent.setSystemInfo("Project", "SauceDemo");
			extent.setSystemInfo("Qa", "Jetun");
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("AutomationEnvironment", "Selenium TestNg");
			extent.setSystemInfo("Browser", ConfigReader.getProperty("browser"));

			ExtentTest extentTest;

		}
		
		return extent;
	}

}
