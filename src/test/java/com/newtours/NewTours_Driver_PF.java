/* Script Name: NewTours_Driver.java
 * Author:	Rana Pratap
 * Data: Jan 2018 Version 1.0 */
package com.newtours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class NewTours_Driver_PF{
	public WebDriver driver;
	String strBrowser = "IE";
	@BeforeTest
	public void setUp() {
		driver = Utility.SetBrowser(strBrowser);
		driver.get("http://newtours.demoaut.com/");
	}
	@DataProvider(name = "dp") //Test data
	public static Object[][] credentials(){
		return new Object[][] {new Object[] { "test1", "test1" }};
	}
	@Test (dataProvider="dp")
	public void TS05_LoginPF(String sUsername, String sPassword){
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.EnterUserName(sUsername);
		loginPage.EnterPassword(sPassword);
		loginPage.ClickLoginButton();
	}
	@AfterTest //Verify errors and close driver
	public void tearDown(){
		driver.quit();
	}
}
