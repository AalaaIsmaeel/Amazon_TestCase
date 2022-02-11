package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BrowserAction;

public class HomePage {
	
private WebDriver driver;
private String URL= "https://www.amazon.com/";

public HomePage(WebDriver driver) {
	this.driver=driver;
	
}
By changeCurrencyIcon= By.xpath("//span[@class=\"icp-nav-link-inner\"]");


public CurrencyPage navigateTochangeCurrency() {
	
	driver.findElement(changeCurrencyIcon).click();
	return new CurrencyPage(driver);
}


public void navigateToHomePage() {
	 
	 BrowserAction.navigateToURl(driver, URL);
	 
}
}
