package Tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import Pages.CurrencyPage;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.BrowserAction;

public class CurrencyTest {

	// Variables
	public WebDriver driver;
	
	HomePage homePageObj;
	CurrencyPage CurrencyPageObj;
    BrowserAction Actions;


	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	    Actions = new BrowserAction(driver);
        homePageObj= new HomePage(driver);
		Actions.maximizeWindow(driver);
	    CurrencyPageObj = new CurrencyPage(driver);
	    homePageObj.navigateToHomePage();
	}

	@Test
	public void verifyCurrencyChanged() {
		homePageObj.navigateTochangeCurrency();
		CurrencyPageObj.changeCurrency();
		CurrencyPageObj.searchForItems();
		Assert.assertTrue(CurrencyPageObj.checkCurrency());

	}
	@AfterClass

	public void teardown() {

		Actions.tearDown();
	}
	

}
