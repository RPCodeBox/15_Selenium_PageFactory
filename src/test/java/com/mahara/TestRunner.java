package com.mahara;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import static org.testng.AssertJUnit.assertTrue;

public class TestRunner {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://demo.mahara.org");
		driver.manage().window().maximize();
	}

	@Test
	public void LoginTest() {
		// Initialize Login Page
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		// Enter user name
		loginPage.EnterUserName("student1");
		// Enter Password
		loginPage.EnterPassword("Testing1");
		// Click Login Button
		loginPage.ClickLoginButton();
	}

	@Test
	public void DashboardTest() throws InterruptedException {
		Thread.sleep(5000);
		// Initialize Dashboard Page
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		// Wait for settings link
		dashboardPage.WaitForSettingLinkToDisplay(driver);
		// Click on Settings
		dashboardPage.ClickSettings();
	}

	@Test
	public void UserSettingsTest() throws InterruptedException {
		Thread.sleep(5000);
		// Initialize User Settings Page
		SettingsPage settingsPage = PageFactory.initElements(driver, SettingsPage.class);
		// Enter Maximum Tags in Cloud Number
		settingsPage.EnterMaximumTagsInCloud("40");
		// Click Save
		settingsPage.ClickSave();
		// Verify Preference Saved Message
		assertTrue(settingsPage.VerifyPreferenceSavedMessage());
		// Click Logout link
		settingsPage.ClickLogout();
	}

	@AfterClass
	public void afterClass() {
		// Close the browser
		driver.close();
		driver.quit();
	}
}
