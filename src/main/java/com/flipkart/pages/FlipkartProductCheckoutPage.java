package com.flipkart.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartProductCheckoutPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(FlipkartProductCheckoutPage.class);

	@FindBy(xpath = "//div[@class='_1P2-0f']")
	private WebElement addNewAddressButton;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement nameTextBox;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement mobileNumberTextBox;

	@FindBy(xpath = "//input[@name='pincode']")
	private WebElement pinCodeTextBox;

	@FindBy(xpath = "//input[@name='addressLine2']")
	private WebElement localityTextBox;

	@FindBy(xpath = "//textarea[@name='addressLine1']")
	private WebElement addressTextBox;

	@FindBy(xpath = "//input[@name='city']")
	private WebElement cityTextBox;

	@FindBy(xpath = "//select[@name='state']")
	private WebElement stateDropDown;

	@FindBy(xpath = "//input[@id='WORK']")
	private WebElement workAddressTypeRadioButton;

	@FindBy(xpath = "//div[@class='_2Kn22P']")
	private WebElement orderSummaryProductText;

	@FindBy(xpath = "//input[@class='_253qQJ']")
	private WebElement quantityInputBox;

	@FindBy(xpath = "//button[@class='_2KpZ6l _1seccl _3AWRsL']")
	private WebElement continueButton;

	@FindBy(xpath = "//button[@class='_2KpZ6l _1uR9yB _3dESVI']")
	private WebElement acceptAndContinueButton;

	@FindBy(xpath = "//input[@id='UPI']")
	private WebElement upiRadioButton;

	@FindBy(xpath = "//input[@id='UPI_COLLECT']")
	private WebElement upiIdRadioButton;

	@FindBy(xpath = "//input[@name='upi-id']")
	private WebElement upiIdTextBox;

	@FindBy(xpath = "//div[@class='_2-Y9bv']")
	private WebElement verifyButton;

	@FindBy(xpath = "//div[@class='_3hovM5']")
	private WebElement verifiedText;

	@FindBy(xpath = "//button[@class='_2KpZ6l TSm6c4 _3AWRsL']")
	private WebElement payButton;

	public FlipkartProductCheckoutPage(WebDriver driver) {
		super(driver);

		logger.info("Starting of FlipkartProductCheckoutPage");
		PageFactory.initElements(driver, this);

		logger.info("Ending of FlipkartProductCheckoutPage");
	}

	public void clickOnAddNewAddressButton() {
		logger.info("Starting of clickOnAddNewAddressButton method");

		super.explicitlyWait(this.addNewAddressButton, 5);
		this.addNewAddressButton.click();

		logger.info("Ending of clickOnAddNewAddressButton method");
	}

	public void setName(String name) {
		logger.info("Starting of setName method");

		super.explicitlyWait(this.nameTextBox, 5);
		this.nameTextBox.sendKeys(name);

		logger.info("Starting of setName method");
	}

	public void setMobileNumber(String mobileNumber) {
		logger.info("Starting of setMobileNumber method");

		this.mobileNumberTextBox.sendKeys(mobileNumber);

		logger.info("Ending of setMobileNumber method");
	}

	public void setPinCode(String pinCode) {
		logger.info("Starting of setPinCode method");

		this.pinCodeTextBox.sendKeys(pinCode);

		logger.info("Ending of setPinCode method");
	}

	public void setLocality(String locality) {
		logger.info("Starting of setLocality method");

		this.setLocality(locality);

		logger.info("Ending of setLocality method");
	}

	public void setAddress(String address) {
		logger.info("Starting of setAddress method");

		this.setAddress(address);

		logger.info("Ending of setAddress method");
	}

	public void setCity(String city) {
		logger.info("Starting of setAddress method");

		this.setCity(city);

		logger.info("Ending of setCity method");
	}

	public void setState(String state) {
		logger.info("Starting of setState method");

		super.selectByValue(stateDropDown, state);

		logger.info("Ending of setState method");
	}

	public void clickOnWorkAddressTypeRadioButton() {
		logger.info("Starting of clickOnWorkAddressTypeRadioButton method");

		this.workAddressTypeRadioButton.click();

		logger.info("Ending of clickOnWorkAddressTypeRadioButton method");
	}

	public String getOrderSummaryProductText() {
		logger.info("Starting of getOrderSummaryProductText method");
		logger.info("Ending of getOrderSummaryProductText method");

		return this.orderSummaryProductText.getText();

	}

	public String getQuantity() {
		logger.info("Starting of getQuantity method");
		logger.info("Ending of getQuantity method");

		return this.quantityInputBox.getAttribute("value");
	}

	public void clickOnAcceptAndContinueButton() {
		logger.info("Starting of clickOnAcceptAndContinueButton method");

		super.explicitlyWait(acceptAndContinueButton, 5);
		this.acceptAndContinueButton.click();

		logger.info("Ending of clickOnAcceptAndContinueButton method");
	}

	public void clickOnUPI() {
		logger.info("Starting of clickOnUPI method");

		this.upiRadioButton.click();

		logger.info("Ending of clickOnUPI method");
	}

	public void clickOnUPIId() {
		logger.info("Starting of clickOnUPIId method");

		this.upiIdRadioButton.click();

		logger.info("Ending of clickOnUPIId method");
	}

	public void setUPIID(String UPIID) {
		logger.info("Starting of setUPIID method");

		this.upiIdTextBox.sendKeys(UPIID);

		logger.info("Ending of setUPIID method");
	}

	public void clickOnVerify() {
		logger.info("Starting of clickOnVerify method");

		this.verifyButton.click();

		logger.info("Ending of clickOnVerify method");
	}

	public boolean isVerifiedIDDisplayed() {
		logger.info("Starting of isVerifiedIDDisplayed method");

		explicitlyWait(verifiedText, 5);

		logger.info("Ending of isVerifiedIDDisplayed method");

		return this.verifiedText.isDisplayed();
	}
}
