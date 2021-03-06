package com.AutomationPractice;

import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Automation_Practice {
	public WebDriver driver;
	
	@Test
	public void TS01_ValidLogin() {
		assertTrue(Practice_POM.UserLogin(driver, "testuser1@gmail.com", "testuser1"));
	}

	@Parameters("Browser")
	@BeforeTest // Setup browser
	public void setUp(@Optional("Chrome") String Browser) {
		driver = Utility.SetBrowser(Browser);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		//driver.close();
	}
}

