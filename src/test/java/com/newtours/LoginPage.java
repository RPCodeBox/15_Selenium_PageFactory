package com.newtours;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	// Define User name Field
	@FindBy(how = How.NAME, using = "userName")
	private WebElement usernameField;

	// Define Password Field
	@FindBy(how = How.NAME, using = "password")
	private WebElement passwordField;

	// Define Login Button
	@FindBy(how = How.NAME, using = "login")
	private WebElement loginButton;
	
	// Define Sign-off Button
	@FindBy(how = How.LINK_TEXT, using = "SIGN-OFF")
	private WebElement signoffLink;

	// Define User name Enter Method
	public void EnterUserName(String usernametext) {
		usernameField.sendKeys(usernametext);
	}
	// Define Password Enter Method
	public void EnterPassword(String passwordtext) {
		passwordField.sendKeys(passwordtext);
	}
	// Define Login Button Click Method
	public void ClickLoginButton() {
		loginButton.click();
	}
}
