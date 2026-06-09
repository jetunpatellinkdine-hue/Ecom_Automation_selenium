package com.saucedemo.SeleniumTestNGFramework.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.SeleniumTestNGFramework.base.BaseTest;
import com.saucedemo.SeleniumTestNGFramework.pages.LoginPage;

public class LoginTest extends BaseTest {
	private LoginPage loginpage;

	@BeforeMethod
	public void initpage() {
		loginpage = new LoginPage(driver);
	}

	@Test
	public void verifyLogin() {
		loginpage.login("standard_user", "secret_sauce");
	}

	// verify invalid username and valid password
	@Test
	public void verifyLoginWithInvalidUsername() {
		loginpage.login("standard_user123", "secret_sauce");
	}

	// verify valid username and invalid password
	@Test
	public void verifyLoginWithInvalidpassword() {
		loginpage.login("standard_user", "Admin@123");
	}

	// verify invalid username and invalid password
	@Test
	public void verifyLoginWithInvalidUsernameAndPassword() {
		loginpage.login("standard_user123", "Admin@123");
	}

	// verify blank username with passsword
	@Test
	public void verifyLoginWithBlankUsername() {
		loginpage.login("", "secret_sauce");
	}

	// verify blank password with username
	@Test
	public void verifyLoginWithBlankPassword() {
		loginpage.login("standard_user", "");
	}

	// verify blank password and blank username
	@Test
	public void verifyLoginWithBlankUsernameAndPassword() {
		loginpage.login("", "");
	}

}
