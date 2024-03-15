package com.flipkart.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.flipkart.config.BrowserType;
import com.flipkart.config.ConfigFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private Driver() {
	}

	private static WebDriver driver = null;

	public static WebDriver initDriver() {
		if (ConfigFactory.getConfig().browser() == BrowserType.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

}
