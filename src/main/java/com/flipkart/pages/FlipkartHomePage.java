package com.flipkart.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage extends BaseAutomationPage{
	
	private static final Logger logger = Logger.getLogger(FlipkartHomePage.class);
	
	@FindBy(xpath = "//input[@name='q']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//a[@title='Login']/span")
	private WebElement loginLink;
	
	@FindBy(xpath = "//a[@title='Cart']")
	private WebElement cartLink;
	
	@FindBy(xpath = "//a[@title='Become a Seller']")
	private WebElement becomeASellerLink;
	
	public FlipkartHomePage(WebDriver driver) {
		super(driver);
		
		logger.info("Starting of FlipkartHomePage");
		
		PageFactory.initElements(driver, this);
		
		logger.info("Starting of FlipkartHomePage");
	}
	
	public void searchProducts(String searchText) {
		logger.info("Starting of searchProducts method");

		this.searchBox.sendKeys(searchText);
		this.searchBox.sendKeys(Keys.ENTER);
		
		logger.info("Ending of searchProducts method");
	}
	
	public boolean isLoginLinkDisplayed() {
		logger.info("Starting of isLoginLinkDisplayed method");

		logger.info("Ending of isLoginLinkDisplayed method");
		return this.loginLink.isDisplayed();
		
	}
	
	public boolean isCartLinkDisplayed() {
		logger.info("Starting of isCartLinkDisplayed method");
		logger.info("Ending of isCartLinkDisplayed method");
		
		return this.cartLink.isDisplayed();
	}
	
	public boolean isBecomeASellerLinkDisplayed() {
		logger.info("Starting of isBecomeASellerLinkDisplayed method");
		logger.info("Ending of isBecomeASellerLinkDisplayed method");

		return this.becomeASellerLink.isDisplayed();
	}
	
	public String getSearchBoxPlaceHolderText(String attributeKey) {
		logger.info("Starting of getSearchBoxPlaceHolderText method");
		logger.info("Starting of getSearchBoxPlaceHolderText method");

		return this.searchBox.getAttribute(attributeKey);
	}
	
	
	
	
	
	
}
