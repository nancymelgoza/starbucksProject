package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StarbucksGift extends BasePage{
	
	public StarbucksGift(WebDriver driver) {
		
		super(driver);	
	
	}
	@FindBy(id = "signIn")
	private WebElement btnSign;

	@FindBy(id="username")
	private WebElement txtuser;

	@FindBy(id="password")
	private WebElement txtpassword;

	@FindBy(className = "sb-frap")
	private WebElement sign;

	@FindBy(xpath="//*[@id=\"js-content\"]/div/div[2]/header/nav/ul/li[3]/a")
	private WebElement gift;

	@FindBy(xpath="//*[@id=\"carousel1\"]/div[2]/div[2]/button/div/div/div[2]/img")
	private WebElement giftselected;

	@FindBy(id="recipientName")
	private WebElement recipientName;

	@FindBy(id="recipientEmail")
	private WebElement recipientEmail;

	@FindBy(id="amount")
	private WebElement amount;

	@FindBy(id="message")
	private WebElement message;

	public StarbucksGift sesion(String user, String pass) {
		
		try {
		getWait().until(ExpectedConditions.visibilityOf(btnSign));
		btnSign.click();
		
		getWait().until(ExpectedConditions.visibilityOf(txtuser));
		txtuser.sendKeys(user);
		
		getWait().until(ExpectedConditions.visibilityOf(txtpassword));
		txtpassword.sendKeys(pass);
		
		getWait().until(ExpectedConditions.visibilityOf(sign));
		sign.click();

		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return this;
	}
	
	public WebElement getBtnSign() {
		return btnSign;
	}

	public void setBtnSign(WebElement btnSign) {
		this.btnSign = btnSign;
	}

	public WebElement getTxtuser() {
		return txtuser;
	}

	public void setTxtuser(WebElement txtuser) {
		this.txtuser = txtuser;
	}

	public WebElement getTxtpassword() {
		return txtpassword;
	}

	public void setTxtpassword(WebElement txtpassword) {
		this.txtpassword = txtpassword;
	}

	public WebElement getSign() {
		return sign;
	}

	public void setSign(WebElement sign) {
		this.sign = sign;
	}

	public WebElement getGift() {
		return gift;
	}

	public void setGift(WebElement gift) {
		this.gift = gift;
	}

	public WebElement getGiftselected() {
		return giftselected;
	}

	public void setGiftselected(WebElement giftselected) {
		this.giftselected = giftselected;
	}

	public WebElement getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(WebElement recipientName) {
		this.recipientName = recipientName;
	}

	public WebElement getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(WebElement recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

	public WebElement getAmount() {
		return amount;
	}

	public void setAmount(WebElement amount) {
		this.amount = amount;
	}

	public WebElement getMessage() {
		return message;
	}

	public void setMessage(WebElement message) {
		this.message = message;
	}

	
}
