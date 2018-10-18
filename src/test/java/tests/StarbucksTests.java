package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.logging.Logger;
import pages.StarbucksCoffee;
import pages.StarbucksHomePage;

public class StarbucksTests extends BaseTests {

	private static final Logger LOGGER = Logger.getLogger(StarbucksTests.class.getName());
//TC1 MENU 
	/*
	 * TC Menu: The options should be : COFFEE, TEA, MENU, COFFEHOUSE, SOCIAL
	 * IMPACT, STARBUCKS REWARDS, BLOG, GIFT CARDS.
	 */

	@DataProvider(name = "NavData")
	public Object[][] homePageValidation() {
		StarbucksHomePage homepage = new StarbucksHomePage(myDriver.getDriver());
		return new Object[][] { { homepage.getCoffee().getText(), "COFFEE" }, { homepage.getTea().getText(), "TEA" },
				{ homepage.getMenu().getText(), "MENU" }, { homepage.getCoffeehouse().getText(), "COFFEEHOUSE" },
				{ homepage.getSocialimpact().getText(), "SOCIAL IMPACT" },
				{ homepage.getStarbucksrewards().getText(), "STARBUCKS REWARDS" },
				{ homepage.getBlog().getText(), "BLOG" }, { homepage.getGiftcards().getText(), "GIFT CARDS" } };
	}

	@Test(priority = 1, dataProvider = "NavData")
	public void testStarbucksHomePage(String tabSend, String tabExpect) throws InterruptedException {

		LOGGER.info("Actual: " + tabSend);
		Assert.assertEquals(tabSend, tabExpect);

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

		StarbucksCoffee homepage = new StarbucksCoffee(myDriver.getDriver());
		return new Object[][] {

				{ homepage.getButon1(), homepage.getVerifybuton1(), homepage.getButon2(), homepage.getVerifybuton2(),
						homepage.getButon3(), homepage.getVerifybuton3(), homepage.getButon4(),
						homepage.getVerifybuton4(), homepage.getBtnFindCoffee() }

		};
	}

	@Test(priority = 2, dataProvider = "options")
	public void testStarbucksCoffeePage(WebElement btn1, WebElement r1, WebElement btn2, WebElement r2, WebElement btn3,
			WebElement r3, WebElement btn4, WebElement r4, WebElement btnFindCoffee) throws InterruptedException {

		StarbucksHomePage starbucksHomePage = new StarbucksHomePage(myDriver.getDriver());
		StarbucksCoffee homepage = starbucksHomePage.clickCoffee();

		homepage.clicksbuttons(btn1, btn2, btn3, btn4, btnFindCoffee);
		
		LOGGER.info("Actual: " + r1.getText());
		LOGGER.info("Actual: " + r2.getText());
		LOGGER.info("Actual: " + r3.getText());
		LOGGER.info("Actual: " + r4.getText());
		LOGGER.info("the url actual is: " + homepage.geturl());
		
		Assert.assertEquals(r1.getText(), "Lighthearted and sunny");
		Assert.assertEquals(r2.getText(), "A group of friends");
		Assert.assertEquals(r3.getText(), "Cocoa");
		Assert.assertEquals(r4.getText(), "I like things simple");
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
