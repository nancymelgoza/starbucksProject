package tests;

import org.openqa.selenium.WebElement;
import org.slf4j.impl.Log4jLoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import pages.StarbucksCoffee;
import pages.StarbucksHomePage;

public class StarbucksTests extends BaseTests {

	static final org.slf4j.Logger LOGGER = new Log4jLoggerFactory().getLogger(StarbucksTests.class.getName());
	
//TC1 MENU 
	/*
	 * TC Menu: The options should be : COFFEE, TEA, MENU, COFFEHOUSE, SOCIAL
	 * IMPACT, STARBUCKS REWARDS, BLOG, GIFT CARDS.
	 */

	@DataProvider(name = "NavData")
	public Object[][] homePageValidation() {
		
		return new Object[][] { {"COFFEE", 0}, {"TEA", 1},
				{"MENU",2}, {"COFFEEHOUSE", 3},
				{"SOCIAL IMPACT", 4},
				{"STARBUCKS REWARDS",5},
				{"BLOG", 6}, {"GIFT CARDS", 7}};
	}

	@Test(priority = 1, dataProvider = "NavData")
	public void testStarbucksHomePage(String tabExpect, Integer id) throws InterruptedException {
		
		StarbucksHomePage homepage = new StarbucksHomePage(myDriver.getDriver());

		LOGGER.info("Actual: " + homepage.getElement(id) + " expected " + tabExpect);
		Assert.assertEquals(homepage.getElement(id), tabExpect);

	}

//TC2 
	/*
	 * TC Coffee: Display Coffee Menu Select "Find Your Perfect Coffee" Select the
	 * first options of all the questions. Verify the selected option Coffee option
	 * should be appear Click the button "Find my coffee". Verify that the new url
	 * is: https://athome.starbucks.com/coffee-finder/
	 */

	@DataProvider(name="options")
	public Object[][] coffeeValidation() {

		return new Object[][] {

				{ "Lighthearted and sunny","A group of friends", "Cocoa", "I like things simple"}

		};
	}

	@Test(priority = 2, dataProvider = "options")
	public void testStarbucksCoffeePage(String valbtn1,String valbtn2, String valbtn3, String valbtn4) throws InterruptedException {

		StarbucksHomePage starbucksHomePage = new StarbucksHomePage(myDriver.getDriver());
		StarbucksCoffee homepage = starbucksHomePage.clickCoffee();

		homepage.clicksbuttons();
		
		LOGGER.info("Actual: " + homepage.getVerifybuton1().getText());
		LOGGER.info("Actual: " + homepage.getVerifybuton2().getText());
		LOGGER.info("Actual: " + homepage.getVerifybuton3().getText());
		LOGGER.info("Actual: " + homepage.getVerifybuton4().getText());
		LOGGER.info("the url actual is: " + homepage.geturl());


		Assert.assertEquals(homepage.getVerifybuton1().getText(), valbtn1);
		Assert.assertEquals(homepage.getVerifybuton2().getText(), valbtn2);
		Assert.assertEquals(homepage.getVerifybuton3().getText(), valbtn3);
		Assert.assertEquals(homepage.getVerifybuton4().getText(), valbtn4);
		homepage.getBtnFindCoffee().click();
		Assert.assertEquals(homepage.geturl(), "https://athome.starbucks.com/coffee-finder/");

	}

//TC3 
	/*
	 * TC Gift Cards:
	 * 
	 * Setup: Login with the credentials: tae.globant.training@gmail.com
	 * GlobantTAE_1 Select "Gift" Select any card Fill all the fields Click
	 * "Checkout" button Verify that the button says "Send Gift" Select Payment
	 * Verify that the button says "Continue"
	 */

	@DataProvider(name = "Authentication")

	public static Object[][] credentials() {

		return new Object[][] { { "tae.globant.training@gmail.com", "GlobantTAE_1" } };

	}

	@Test(priority = 3, dataProvider = "Authentication")

	public void GiftCardsSesion(String user, String pass) {

		StarbucksHomePage starbucksHomePage = new StarbucksHomePage(myDriver.getDriver());

		starbucksHomePage.sesion(user, pass);
		starbucksHomePage.sendGift();
		Assert.assertEquals(starbucksHomePage.getSendAGift().getText(), "Send gift");
		starbucksHomePage.paymentMethod();
		Assert.assertEquals(starbucksHomePage.getContinueButton().getText(), "Continue");
	}

}
