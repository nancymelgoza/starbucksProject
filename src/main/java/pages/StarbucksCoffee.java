package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StarbucksCoffee extends BasePage{

	public StarbucksCoffee(WebDriver driver) {
		super(driver);

	}
	
	 @FindBy(xpath ="//button[@class ='finder-question light flavor-question question-a col-xs-12 col-sm-4 col-md-4 col-lg-4 text-center']")
	 private WebElement buton1;


	 @FindBy(xpath ="//h4[contains(.,'Lighthearted and sunny')]")
	 private WebElement verifybuton1;
	 
	 @FindBy(how = How.CSS, using = "#question2 > button:nth-child(1)")
	 private WebElement buton2;
	 
	 @FindBy(xpath ="//h4[contains(.,'A group of friends')]")
	 private WebElement verifybuton2;
	 
	 @FindBy(how = How.CSS, using = "#light-questions > button:nth-child(2)")
	 private WebElement buton3;
	 
	 @FindBy(how = How.CSS, using = ".light-questions > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > h4:nth-child(1)")
	 private WebElement verifybuton3;
	 
	 @FindBy(how = How.CSS, using = "#question4 > button:nth-child(1)")
	 private WebElement buton4;
	 
	 @FindBy(how = How.CSS, using = "div.col-md-12:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > h4:nth-child(1)")
	 private WebElement verifybuton4;

	 @FindBy(id="find-my-coffee")
	 private WebElement btnFindCoffee;
	 
	 public StarbucksCoffee clicksbuttons() {
		 
		getWait().until(ExpectedConditions.visibilityOf(buton1));
		buton1.click();
		getWait().until(ExpectedConditions.visibilityOf(verifybuton1));
		
		getWait().until(ExpectedConditions.visibilityOf(buton2));
		buton2.click();
		getWait().until(ExpectedConditions.visibilityOf(verifybuton2));
		
		getWait().until(ExpectedConditions.visibilityOf(buton3));
		buton3.click();
		getWait().until(ExpectedConditions.visibilityOf(verifybuton3));
		
		getWait().until(ExpectedConditions.visibilityOf(buton4));
		buton4.click();
		getWait().until(ExpectedConditions.visibilityOf(verifybuton4));
		
		 return this;
	 }
		public String getNameButton(Integer id) {
			
			ArrayList<String> elementlist = new ArrayList<String>();

			elementlist.add(getButon1().getText());
			elementlist.add(getButon2().getText());
			elementlist.add(getButon3().getText());
			elementlist.add(getButon4().getText());
			
			return elementlist.get(id);

		}
	 
	public String geturl() {
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}

	public WebElement getBtnFindCoffee() {
		return btnFindCoffee;
	}

	public void setBtnFindCoffee(WebElement btnFindCoffee) {
		this.btnFindCoffee = btnFindCoffee;
	}
	 
	public WebElement getVerifybuton4() {
		return verifybuton4;
	}

	public void setVerifybuton4(WebElement verifybuton4) {
		this.verifybuton4 = verifybuton4;
	}

	public WebElement getVerifybuton3() {
		return verifybuton3;
	}

	public void setVerifybuton3(WebElement verifybuton3) {
		this.verifybuton3 = verifybuton3;
	}

	public WebElement getVerifybuton2() {
		return verifybuton2;
	}

	public void setVerifybuton2(WebElement verifybuton2) {
		this.verifybuton2 = verifybuton2;
	}

	public WebElement getVerifybuton1() {
		return verifybuton1;
	}

	public void setVerifybuton1(WebElement verifybuton1) {
		this.verifybuton1 = verifybuton1;
	}

	public WebElement getButon1() {
		return buton1;
	}

	public void setButon1(WebElement buton1) {
		this.buton1 = buton1;
	}

	public WebElement getButon2() {
		return buton2;
	}

	public void setButon2(WebElement buton2) {
		this.buton2 = buton2;
	}

	public WebElement getButon3() {
		return buton3;
	}

	public void setButon3(WebElement buton3) {
		this.buton3 = buton3;
	}

	public WebElement getButon4() {
		return buton4;
	}

	public void setButon4(WebElement buton4) {
		this.buton4 = buton4;
	}

}
