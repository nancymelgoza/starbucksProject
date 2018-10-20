package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StarbucksHomePage extends BasePage {

	Actions mouseOver;

	public StarbucksHomePage(WebDriver pDriver) {
		super(pDriver);
		pDriver.get("http://starbucks.com/");

	}

	@FindBy(how = How.ID, using = "nav")
	private WebElement nav;

	@FindBy(id = "nav_coffee")
	private WebElement coffee;

	@FindBy(id = "nav_menudrinkstea")
	private WebElement tea;

	@FindBy(id = "nav_menu")
	private WebElement menu;

	@FindBy(id = "nav_coffeehouse")
	private WebElement coffeehouse;

	@FindBy(id = "nav_responsibility")
	private WebElement socialimpact;

	@FindBy(id = "nav_starbucks_rewards")
	private WebElement starbucksrewards;

	@FindBy(id = "nav_blog")
	private WebElement blog;

	@FindBy(id = "nav_gift_cards")
	private WebElement giftcards;

	@FindBy(partialLinkText = "Find Your Perfect Coffee")
	private WebElement findperfectcoffee;
	// ----elements give your perfect coffee

	// ---gift elements with sesion---

	@FindBy(id = "signIn")
	private WebElement btnSign;

	@FindBy(id = "username")
	private WebElement txtuser;

	@FindBy(id = "password")
	private WebElement txtpassword;

	@FindBy(className = "sb-frap")
	private WebElement sign;

	@FindBy(how= How.CSS, using ="li.inline-block:nth-child(3) > a:nth-child(1)")
	private WebElement gift;

	@FindBy(how = How.CSS, using ="#carousel1 > div:nth-child(3) > div:nth-child(2) > a:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > img:nth-child(1)")
	private WebElement giftselected;

	@FindBy(id = "recipientName")
	private WebElement recipientName;

	@FindBy(id = "recipientEmail")
	private WebElement recipientEmail;

	@FindBy(how = How.CSS, using = ".select__icon")
	private WebElement arrow;

	@FindBy(id = "amount")
	private WebElement amount;

	
	@FindBy(id = "message")
	private WebElement message;
	
	@FindBy(xpath = "//button[contains(.,'Checkout')]")
	private WebElement checkout;
	
	@FindBy(how = How.CSS, using = "#paymentMethod > option:nth-child(2)")
	private WebElement paymentMethod;
	
	@FindBy(xpath = "//button[contains(.,'Send gift')]")
	private WebElement sendAGift;

	@FindBy(xpath = "//button[contains(.,'Continue')]")
	private WebElement continueButton;

	
	public StarbucksCoffee clickCoffee() {
		try {
			getWait().until(ExpectedConditions.visibilityOf(nav));
			mouseOver = new Actions(getDriver());
			mouseOver.moveToElement(coffee).perform();

			getWait().until(ExpectedConditions.visibilityOf(findperfectcoffee));
			findperfectcoffee.click();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return new StarbucksCoffee(getDriver());
	}

	public StarbucksHomePage sesion(String user, String pass) {

		try {
			getWait().until(ExpectedConditions.visibilityOf(btnSign));
			btnSign.click();

			getWait().until(ExpectedConditions.visibilityOf(txtuser));
			txtuser.sendKeys(user);
			getWait().until(ExpectedConditions.visibilityOf(txtpassword));

			txtpassword.sendKeys(pass);
			getWait().until(ExpectedConditions.visibilityOf(sign));
			sign.click();

		} catch (Exception ex) {
			ex.getMessage();
		}
		return this;
	}

	public StarbucksHomePage sendGift() {

		try {

			getWait().until(ExpectedConditions.visibilityOf(gift));
			gift.click();

			getWait().until(ExpectedConditions.visibilityOf(giftselected));
			giftselected.click();

			getWait().until(ExpectedConditions.visibilityOf(recipientName));
			recipientName.sendKeys("Nancy Melgoza");

			getWait().until(ExpectedConditions.visibilityOf(recipientEmail));
			recipientEmail.sendKeys("nanmelfu94@gmail.com");
			
			getWait().until(ExpectedConditions.visibilityOf(checkout));
			checkout.click();
			getWait().until(ExpectedConditions.visibilityOf(sendAGift));

		} catch (Exception ex) {
			ex.getMessage();
		}
		return this;
	}

	public StarbucksHomePage paymentMethod() {

		try {
			getWait().until(ExpectedConditions.visibilityOf(paymentMethod));
			paymentMethod.click();
			getWait().until(ExpectedConditions.visibilityOf(continueButton));

		} catch (Exception ex) {
			ex.getMessage();
		}
		return this;
	}
	
	public String getElement(Integer id) {
		
		ArrayList<String> elementlist = new ArrayList<String>();

		elementlist.add(getCoffee().getText());
		elementlist.add(getTea().getText());
		elementlist.add(getMenu().getText());
		elementlist.add(getCoffeehouse().getText());
		elementlist.add(getSocialimpact().getText());
		elementlist.add(getStarbucksrewards().getText());
		elementlist.add(getBlog().getText());
		elementlist.add(getGiftcards().getText());
		
		return elementlist.get(id);

	}


	public WebElement getContinueButton() {
		return continueButton;
	}

	public void setContinueButton(WebElement continueButton) {
		this.continueButton = continueButton;
	}

	public WebElement getSendAGift() {
		return sendAGift;
	}

	public void setSendAGift(WebElement sendAGift) {
		this.sendAGift = sendAGift;
	}

	public WebElement getNav() {
		return nav;
	}

	public void setNav(WebElement nav) {
		this.nav = nav;
	}

	public WebElement getCoffee() {
		return coffee;
	}

	public void setCoffee(WebElement coffee) {
		this.coffee = coffee;
	}

	public WebElement getTea() {
		return tea;
	}

	public void setTea(WebElement tea) {
		this.tea = tea;
	}

	public WebElement getMenu() {
		return menu;
	}

	public void setMenu(WebElement menu) {
		this.menu = menu;
	}

	public WebElement getCoffeehouse() {
		return coffeehouse;
	}

	public void setCoffeehouse(WebElement coffeehouse) {
		this.coffeehouse = coffeehouse;
	}

	public WebElement getSocialimpact() {
		return socialimpact;
	}

	public void setSocialimpact(WebElement socialimpact) {
		this.socialimpact = socialimpact;
	}

	public WebElement getStarbucksrewards() {
		return starbucksrewards;
	}

	public void setStarbucksrewards(WebElement starbucksrewards) {
		this.starbucksrewards = starbucksrewards;
	}

	public WebElement getBlog() {
		return blog;
	}

	public void setBlog(WebElement blog) {
		this.blog = blog;
	}

	public WebElement getGiftcards() {
		return giftcards;
	}

	public void setGiftcards(WebElement giftcards) {
		this.giftcards = giftcards;
	}

}
