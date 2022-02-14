package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.FiltrationPage;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.BrowserAction;

public class FiltrationTest {

	public WebDriver driver;
	HomePage homePageObj;
    BrowserAction Actions;
    FiltrationPage FiltrationPageObj;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    Actions = new BrowserAction(driver);
        homePageObj= new HomePage(driver);
		Actions.maximizeWindow(driver);
		FiltrationPageObj = new FiltrationPage(driver);
		homePageObj.navigateToHomePage();
	}

	@Test
	public void testfilterByDep() {
		FiltrationPageObj.closetoasters();
		FiltrationPageObj.clickOnTodayDealLink();
		FiltrationPageObj.selectDepartment();
		Assert.assertTrue(FiltrationPageObj.verifyFilterResult());

	}
	
	
	@AfterClass

	public void teardown() {

		Actions.tearDown();
	}

}
