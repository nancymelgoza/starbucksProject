package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {
	
private WebDriver driver;
	

	public MyDriver(String browser) {

		switch (browser) {
//		case "remoteFirefox":
//			try {
//				driver = new RemoteWebDriver(new URL)
//			}
		case "firefox":
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\nancy.melgoza\\Documents\\firefx\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			break;
		default: 
			break;
		}
	}
	
	public WebDriver getDriver() {

		return this.driver;
	}
	
//	@AfterSuite
//    public void closeDriver(){
//        driver.quit();
//    }
}
