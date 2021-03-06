package com.mahara;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	// Define Settings Link
	@FindBy(how = How.XPATH, using = "//div[@id='right-nav']//a[contains(text(),'Settings')]")
	private WebElement settingLink;

	// Define Click Settings Method
	public void ClickSettings() {
		settingLink.click();
	}

	// Define Wait
	public void WaitForSettingLinkToDisplay(WebDriver webDriver) {
		WebDriverWait wait = new WebDriverWait(webDriver, 60, 1000);
		wait.until(ExpectedConditions.visibilityOf(settingLink));
	}
}
