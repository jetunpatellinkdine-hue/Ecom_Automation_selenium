package com.saucedemo.SeleniumTestNGFramework.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.SeleniumTestNGFramework.base.BaseTest;
import com.saucedemo.SeleniumTestNGFramework.pages.LoginPage;
import com.saucedemo.SeleniumTestNGFramework.utilities.ConfigReader;

public class LoginTest extends BaseTest {
	private LoginPage loginpage;

	@BeforeMethod
	public void initpage() {
		loginpage = new LoginPage(driver);
	}


	// verify login with valid username and password
	@Test
	public void verifyLogin() {
		loginpage.login(ConfigReader.getUsername(), ConfigReader.getPassword());
	}

	// verify login with invalid username and valid password
	@Test
	public void verifyLoginWithInvalidUsername() {
		loginpage.login("standard_user123", "secret_sauce");
	}

	// verify login with valid username and invalid password
	@Test
	public void verifyLoginWithInvalidpassword() {
		loginpage.login("standard_user", "Admin@123");
	}

	// verify login with invalid username and invalid password
	@Test
	public void verifyLoginWithInvalidUsernameAndPassword() {
		loginpage.login("standard_user123", "Admin@123");
	}

	// verify login with blank username with passsword
	@Test
	public void verifyLoginWithBlankUsername() {
		loginpage.login("", "secret_sauce");
	}

	// verify login with blank password with username
	@Test
	public void verifyLoginWithBlankPassword() {
		loginpage.login("standard_user", "");
	}

	// verify login with blank password and blank username
	@Test
	public void verifyLoginWithBlankUsernameAndPassword() {
		loginpage.login("", "");
	}

}
