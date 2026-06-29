package com.saucedemo.SeleniumTestNGFramework.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigReader {

	private static final Properties property = new Properties();

	private ConfigReader() {

	}

	static {

		String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";

		FileInputStream inputFile;

		try {
			inputFile = new FileInputStream(path);

			property.load(inputFile);

			inputFile.close();
		} catch (IOException e) {
			throw new RuntimeException(" Failed to load file");
		}
	}

	public static String getProperty(String key) {
		return property.getProperty(key);
	}

	public static String getUrl() {
		return getProperty("url");
	}

	public static String getUsername() {
		return getProperty("username");
	}

	public static String getPassword() {
		return getProperty("password");
	}

}
