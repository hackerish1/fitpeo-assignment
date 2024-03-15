package com.flipkart.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.flipkart.driver.Driver;
import com.flipkart.pages.FlipkartCartPage;
import com.flipkart.pages.FlipkartHomePage;
import com.flipkart.pages.FlipkartLoginOrSignUpPage;
import com.flipkart.pages.FlipkartProductCheckoutPage;
import com.flipkart.pages.FlipkartProductsPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ProductCheckoutTest extends BaseAutomationTest {

	private String productText = null;
	private WebDriver driver = null;
	private FlipkartCartPage flipkartCartPage = null;
	private FlipkartHomePage flipkartHomePage = null;
	private FlipkartLoginOrSignUpPage flipkartLoginOrSignUpPage = null;
	private FlipkartProductCheckoutPage flipkartProductCheckoutPage = null;
	private FlipkartProductsPage flipkartProductsPage = null;

	private static final Logger logger = Logger.getLogger(ProductCheckoutTest.class);

	@BeforeClass
	public void init() {
		logger.info("Starting of setup method");

		this.driver = Driver.initDriver();
		this.driver.get("https://www.flipkart.com/");

		// InIt Object pages
		this.flipkartCartPage = new FlipkartCartPage(this.driver);
		this.flipkartHomePage = new FlipkartHomePage(this.driver);
		this.flipkartLoginOrSignUpPage = new FlipkartLoginOrSignUpPage(this.driver);
		this.flipkartProductCheckoutPage = new FlipkartProductCheckoutPage(this.driver);
		this.flipkartProductsPage = new FlipkartProductsPage(this.driver);

		logger.info("Ending of setup method");
	}

	@Test(priority = 1, description = "Test to verify Home page")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test to verify Home page")
	public void testHomePage() {
		logger.info("Starting of testHomePage method");

		String title = driver.getTitle();
		Assert.assertEquals(title, super.getExpectedAssertionProperties("home.title"));

		String searchBoxPlaceHolder = this.flipkartHomePage
				.getSearchBoxPlaceHolderText(super.getTestDataProperties("search.attribute"));
		Assert.assertEquals(searchBoxPlaceHolder, super.getExpectedAssertionProperties("home.searchbox.placeholder"));

		boolean isloginLinkDisplayed = this.flipkartHomePage.isLoginLinkDisplayed();
		boolean iscartLinkDisplayed = this.flipkartHomePage.isCartLinkDisplayed();
		boolean isBecomeASellerLinkDisplayed = this.flipkartHomePage.isBecomeASellerLinkDisplayed();

		Assert.assertTrue(isloginLinkDisplayed);
		Assert.assertTrue(iscartLinkDisplayed);
		Assert.assertTrue(isBecomeASellerLinkDisplayed);

		logger.info("Ending of testHomePage method");
	}

	@Test(priority = 2, description = "Test to search and add products to cart")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test to search and add products to cart")
	public void testSearchAndAddToCart() {
		logger.info("Starting of testSearchAndAddToCart method");

		this.flipkartHomePage.searchProducts(super.getTestDataProperties("search.product"));

		this.flipkartProductsPage.clickProductLink();
		super.switchToChildWindow(this.driver);
		productText = this.flipkartProductsPage.getProductText();
		this.flipkartProductsPage.clickOnAddToCartButton();

		logger.info("Ending of testSearchAndAddToCart method");
	}

	@Test(priority = 3, description = "Test to add product to cart and proceed to checkout")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test to add product to cart and proceed to checkout")
	public void testProceedToCheckout() {
		logger.info("Starting of testProceedToCheckout method");

		this.flipkartProductsPage.clickCartLink();

		String cartText = this.flipkartCartPage.getCartProductText();
		Assert.assertTrue(productText.contains(cartText));

		this.flipkartCartPage.clickOnPlaceOrderButton();

		logger.info("Ending of testProceedToCheckout method");
	}

	@Test(priority = 4, description = "Test Authenticate user and verify if user logged in successfully")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Authenticate user and verify if user logged in successfully")
	public void testUserAuthentication() {
		logger.info("Starting of testUserAuthentication method");

		String loginOrSingupText = this.flipkartLoginOrSignUpPage.getLoginOrSignUpText();
		Assert.assertEquals(loginOrSingupText, super.getExpectedAssertionProperties("authentication.loginorsignup"));

		this.flipkartLoginOrSignUpPage.setMobileNumber(super.getTestDataProperties("authentication.mobile.number"));
		this.flipkartLoginOrSignUpPage.clickOnContinueButton();

		Assert.assertTrue(this.flipkartLoginOrSignUpPage.isVerificationCodeSentMessageDisplayed(
				super.getExpectedAssertionProperties("authentication.verification.sent.message")), "user login unsuccessfull");
		this.flipkartLoginOrSignUpPage.setOTP(super.getTestDataProperties("authentication.otp"));

		this.flipkartLoginOrSignUpPage.clickOnLoginButton();

		logger.info("Ending of testUserAuthentication method");
	}

	@Test(priority = 5, dependsOnMethods = {
			"testUserAuthentication" }, description = "Test to add new addess information")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test to add new addess information")
	public void testShippingInformation() {
		logger.info("Starting of testShippingInformation method");

		this.flipkartProductCheckoutPage.clickOnAddNewAddressButton();
		this.flipkartProductCheckoutPage.setName(super.getTestDataProperties("add.address.name"));
		this.flipkartProductCheckoutPage.setMobileNumber(super.getTestDataProperties("add.address.mobile.number"));
		this.flipkartProductCheckoutPage.setPinCode(super.getTestDataProperties("add.address.pincode"));
		this.flipkartProductCheckoutPage.setLocality(super.getTestDataProperties("add.address.locality"));
		this.flipkartProductCheckoutPage.setAddress(super.getTestDataProperties("add.address.address"));
		this.flipkartProductCheckoutPage.setCity(super.getTestDataProperties("add.address.city"));
		this.flipkartProductCheckoutPage.setState(super.getTestDataProperties("add.address.state"));
		this.flipkartProductCheckoutPage.clickOnWorkAddressTypeRadioButton();
		this.flipkartProductCheckoutPage.clickOnAcceptAndContinueButton();

		logger.info("Ending of testShippingInformation method");
	}

	@Test(priority = 6, dependsOnMethods = { "testShippingInformation" }, description = "Test to reivew the order")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test to reivew the order")
	public void reviewOrder() {
		logger.info("Starting of reviewOrder method");

		String orderSummaryProductText = this.flipkartProductCheckoutPage.getOrderSummaryProductText();
		Assert.assertTrue(productText.contains(orderSummaryProductText));

		logger.info("Ending of reviewOrder method");
	}

	@Test(priority = 7, dependsOnMethods = { "reviewOrder" }, description = "Test to add the payment details")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test to add the payment details")
	public void testPaymentInformation() {
		logger.info("Starting of testPaymentInformation method");

		this.flipkartProductCheckoutPage.clickOnUPI();
		this.flipkartProductCheckoutPage.clickOnUPIId();
		this.flipkartProductCheckoutPage.setUPIID(super.getTestDataProperties("payment.info.upiid"));
		boolean isUPIVerified = this.flipkartProductCheckoutPage.isVerifiedIDDisplayed();

		Assert.assertTrue(isUPIVerified);

		logger.info("Ending of testPaymentInformation method");
	}

	@AfterClass
	public void tearDown() {
		logger.info("Starting of tearDown method");

		Driver.quitDriver();

		logger.info("Ending of tearDown method");
	}

}
