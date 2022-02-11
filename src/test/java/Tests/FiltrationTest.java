package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.FiltrationPage;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FiltrationTest {

	public WebDriver driver;
	HomePage homePageObj;
	FiltrationPage FiltrationPageObj;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		homePageObj = new HomePage(driver);
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
	
	
	  @AfterMethod
		public void AfterMethod() {
			driver.quit();
		}

}
