package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

//import com.beust.jcommander.Parameters;

import driver.MyDriver;
import pages.StarbucksHomePage;

public class BaseTests {
	
	MyDriver myDriver;
	private StarbucksHomePage homepage;
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
		homepage = new StarbucksHomePage(myDriver.getDriver());
	}

//	@AfterSuite(alwaysRun=true)
//	public void AfterSuite(String browser) {
////		myDriver = new MyDriver(browser);
////		myDriver.getDriver().quit();;
////		homepage = new StarbucksHomePage(myDriver.getDriver());
//		homepage.dispose();
//	}
}
