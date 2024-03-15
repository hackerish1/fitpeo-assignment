package com.flipkart.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartCartPage extends BaseAutomationPage {
	
	private static final Logger logger = Logger.getLogger(FlipkartCartPage.class);
	
	@FindBy(xpath="//a[@class='_2Kn22P gBNbID']")
	private WebElement cartProductText;
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
	private WebElement placeOrderButton;
	
	
	public FlipkartCartPage(WebDriver driver) {
		super(driver);
		
		logger.info("Starting of FlipkartCartPage");
		
		PageFactory.initElements(driver, this);
		
		logger.info("Ending of FlipkartCartPage");
	}
	
	public String getCartProductText() {
		logger.info("Starting of getCartProductText method");

		super.explicitlyWait(cartProductText, 5);
		
		logger.info("Ending of getCartProductText method");
		
		return this.cartProductText.getText();
	}
	
	public void clickOnPlaceOrderButton() {
		logger.info("Starting of clickOnPlaceOrderButton method");

		super.javaScriptExecutorClick(placeOrderButton);
		
		logger.info("Ending of clickOnPlaceOrderButton method");
	}
}
