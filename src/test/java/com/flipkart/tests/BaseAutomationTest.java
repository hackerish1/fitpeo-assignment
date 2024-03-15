package com.flipkart.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class BaseAutomationTest {
	
	private static final Logger logger = Logger.getLogger(BaseAutomationTest.class);
	private static Properties testDataProperties = null;

	private static Properties expectedAssertionProperties = null;
	
	@BeforeSuite
	protected void setupData() {
		testDataProperties = new Properties();
		expectedAssertionProperties = new Properties();

		try(InputStream testDatafs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/testdata.properties");
				InputStream expectedAssertionfs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/expectedassertions.properties")) {
			
			testDataProperties.load(testDatafs);
			expectedAssertionProperties.load(expectedAssertionfs);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected static String getTestDataProperties(Object key) {
		return testDataProperties.get(key).toString();
	}


	protected static String getExpectedAssertionProperties(Object key) {
		return expectedAssertionProperties.get(key).toString();
	}
	
	
	protected void switchToChildWindow(WebDriver driver) {
		logger.info("Starting of switchToChildWindow method");

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		
		logger.info("Ending of switchToChildWindow method");
	}

}
