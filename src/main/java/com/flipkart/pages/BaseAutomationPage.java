package com.flipkart.pages;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseAutomationPage {
	
	private WebDriver driver = null;
	
	private static final Logger logger = Logger.getLogger(BaseAutomationPage.class);


	protected BaseAutomationPage(WebDriver driver) {
		logger.info("Starting of BaseAutomationPage");
		
		this.driver = driver;
		
		logger.info("Ending of BaseAutomationPage");
	}
	
	protected void javaScriptExecutorClick(WebElement element) {
		logger.info("Starting of javaScriptExecutorClick method");

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

		logger.info("Starting of javaScriptExecutorClick method");
	}
	
	protected void explicitlyWait(WebElement element, long timeOutInSeconds) {
		logger.info("Starting of explicitlyWait method");

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(d -> element.isDisplayed());
		
		logger.info("Ending of explicitlyWait method");
	}
	
	protected void selectByValue(WebElement element, String value) {
		logger.info("Starting of selectByValue method");

		Select select = new Select(element);
		select.selectByValue(value);
		
		logger.info("Ending of selectByValue method");
	}
	
}
