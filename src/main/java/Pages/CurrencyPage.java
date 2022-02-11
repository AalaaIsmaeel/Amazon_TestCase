package Pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurrencyPage {
	private WebDriver driver;

	//Constractor
	public CurrencyPage(WebDriver driver) {
		this.driver = driver;
		
		}
	// By changeCurrencyIcon= By.xpath("//span[@class=\"icp-nav-link-inner\"]");
	 By currencyDropDown= By.xpath("//p//span[@class=\"a-dropdown-container\"]");
	 By currencySelectedOption= By.xpath("//li//a[text()=\"AED - Arab Emirates Dirham\"]");
	 By saveChanges= By.xpath("//input[@class=\"a-button-input\"]");
	 By searchBox= By.id("twotabsearchtextbox");
	 By SearchBtn= By.id("nav-search-submit-button");
	 By pricesList= By.xpath("//span[@class=\"a-price-symbol\"]");
	 
	 
	 public void changeCurrency() {
	// driver.findElement(changeCurrencyIcon).click();
	 driver.findElement(currencyDropDown).click();
	 driver.findElement(currencySelectedOption).click();
	 WebDriverWait wait = new WebDriverWait(driver, 15);
	    wait.until(ExpectedConditions.elementToBeClickable(saveChanges)).click();


	 
	 }
	 
	 public void searchForItems() {
		 String searchValue= "iphone";
		 driver.findElement(searchBox).sendKeys(searchValue);
		 driver.findElement(SearchBtn).click();	 
	 }
	 

	 
	 public List<String> retunListOfPrices() {
		List<String> returnedResult = new ArrayList<>();
		List<WebElement> prices = driver.findElements(pricesList);
		for(int i=0; i<prices.size();i++) {	
			String listValues= prices.get(i).getText();	
		if(listValues!="") {
			returnedResult.add(listValues);
		}
		}
	return returnedResult;
	 }
		
		
		public boolean checkCurrency() {
			String ExpectedCurrency= "AED";
			boolean status= true;
			List<String> currency= retunListOfPrices();
		for(int i=0; i<currency.size();i++) {	
			String listValues= currency.get(i);
		if(listValues.equals(ExpectedCurrency)) {
			status=true;
			
		}
		else {
			status= false;				
			
		}
}
		return status;

	 }
	 

}