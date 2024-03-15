package com.flipkart.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartProductsPage extends BaseAutomationPage{
	
	private static final Logger logger = Logger.getLogger(FlipkartProductsPage.class);

	@FindBy(xpath = "(//div[@class='_4rR01T'])[1]")
	private WebElement productlink;

	@FindBy(xpath = "//span[@class='B_NuCI']")
	private WebElement productText;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addToCartButton;

	@FindBy(xpath = "//a[@class='_3SkBxJ']")
	private WebElement cartLink;

	public FlipkartProductsPage(WebDriver driver) {
		super(driver);
		
		logger.info("Starting of FlipkartProductsPage");
		
		PageFactory.initElements(driver, this);
		
		logger.info("Ending of FlipkartProductsPage");
	}


	public void clickProductLink() {
		logger.info("Starting of clickProductLink method");

		this.productlink.click();

		logger.info("Ending of clickProductLink method");
	}

	public String getProductText() {
		logger.info("Starting of getProductText method");
		logger.info("Ending of getProductText method");

		return this.productText.getText();

	}

	public void clickOnAddToCartButton() {
		logger.info("Starting of clickOnAddToCartButton method");

		super.explicitlyWait(addToCartButton, 5);
		this.addToCartButton.click();

		logger.info("Ending of clickOnAddToCartButton method");
	}

	public void clickCartLink() {
		logger.info("Starting of clickCartLink method");

		this.cartLink.click();
		
		logger.info("Ending of clickCartLink method");
	}

}
