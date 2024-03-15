package com.flipkart.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartLoginOrSignUpPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(FlipkartLoginOrSignUpPage.class);

	@FindBy(xpath = "//span[@class='_1aULyb']")
	private WebElement loginOrSignUpText;

	@FindBy(xpath = "//input[@class='_2IX_2- _17N0em']")
	private WebElement mobileNumberTextBox;

	@FindBy(xpath = "//button[@class='_2KpZ6l _20xBvF _3AWRsL']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@class='_2IX_2- _3mctLh _17N0em']")
	private WebElement otpTextBox;

	@FindBy(xpath = "//div[@class='_1P2-0f']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='_2sKwjB']")
	private WebElement verificationCodeSentMessage;

	public FlipkartLoginOrSignUpPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of FlipkartLoginOrSignUpPage");

		PageFactory.initElements(driver, this);

		logger.info("Ending of FlipkartLoginOrSignUpPage");
	}

	public String getLoginOrSignUpText() {
		logger.info("Starting of getLoginOrSignUpText method");
		logger.info("Ending of getLoginOrSignUpText method");

		return this.loginOrSignUpText.getText();

	}

	public void setMobileNumber(String mobileNumber) {
		logger.info("Starting of setMobileNumber method");

		this.mobileNumberTextBox.sendKeys(mobileNumber);

		logger.info("Ending of setMobileNumber method");
	}

	public void clickOnContinueButton() {
		logger.info("Starting of clickOnContinueButton method");

		this.continueButton.click();

		logger.info("Ending of clickOnContinueButton method");
	}

	public void setOTP(String otp) {
		logger.info("Starting of setOTP method");

		this.otpTextBox.sendKeys(otp);

		logger.info("Ending of setOTP method");
	}

	public void clickOnLoginButton() {
		logger.info("Starting of clickOnLoginButton method");

		this.loginButton.click();

		logger.info("Ending of clickOnLoginButton method");
	}

	public boolean isVerificationCodeSentMessageDisplayed(String message) {
		logger.info("Starting of isVerificationCodeSentMessageDisplayed method");

		super.explicitlyWait(verificationCodeSentMessage, 5);

		logger.info("Ending of isVerificationCodeSentMessageDisplayed method");

		return verificationCodeSentMessage.getText().contains(message);
	}

}
