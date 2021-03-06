package com.AutomationPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

public class Utility implements Keys {
	public static WebDriver driver;

	public static WebDriver SetBrowser(String strBrowser) {
		System.setProperty(ChromeDriverKey, ChromeDriverPath);
		System.setProperty(FireFoxDriverKey, FireFoxDriverPath);
		System.setProperty(IEDriverKey, IEDriverPath);
		System.setProperty(EdgeDriverKey, EdgeDriverPath);
		if (strBrowser.equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver();
		} else if (strBrowser.equalsIgnoreCase("FIREFOX")) {
			driver = new FirefoxDriver();
		} else if (strBrowser.equalsIgnoreCase("IE")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver();
		} else if (strBrowser.equalsIgnoreCase("EDGE")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}

	public static void SelectDropDown(String ddObject, String Value) {
		Select Object = new Select(driver.findElement(By.name(ddObject)));
		Object.selectByVisibleText(Value);
	}

	public static void SelectRadioButton(String RDObject) {
		WebElement radio1 = driver.findElement(By.xpath(RDObject));
		radio1.click();
	}

	public void highLightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
	}
}
