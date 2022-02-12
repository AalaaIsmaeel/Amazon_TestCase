package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FiltrationPage {
	public WebDriver driver;

	// Constractor
	public FiltrationPage(WebDriver driver) {
		this.driver = driver;

	}

	By productsList = By.xpath("//div[@data-testid=\"grid-deals-container\"]");
	By shoppingToaster = By.xpath("//div[@id=\"nav-flyout-aee-xop\"]");
	By closeShoppingToaster = By.xpath("//span[@id=\"aee-xop-dismiss\"]//span");
	By changeDeliveryAddressToaster = By.xpath("//div[@class=\"glow-toaster-content\"]");
	By closeDeliveryToaster = By.xpath("//input[@data-action-type=\"DISMISS\"]");
	By todaysDealLink = By.xpath("//div[@id=\"nav-xshop\"]//a[1]");
	By departmentSelection = By.xpath("//div//span[text()=\"Software\"]");
	By firstItemInList = By.xpath(
			"//div[contains(@class,\"DealGridItem-module__withoutActionButton_2OI8DAanWNRCagYDL2iIqN\")][1]//div[contains(@data-testid,\"deal-card\")]//a[2]");
	By breadCrumblink = By.xpath("(//a[contains(text(),\"Software\")])[1]");

	public void closetoasters() {

		boolean isDeliveryAddressExist = driver.findElements(closeDeliveryToaster).size() != 0;
		boolean isShoppingToasterExist = driver.findElements(shoppingToaster).size() != 0;
		String deliveryToasterCssStyle = isDeliveryAddressExist	? driver.findElement(closeDeliveryToaster).getCssValue("display"): "";
		String shoppingToasterCssStyle = isShoppingToasterExist	? driver.findElement(shoppingToaster).getCssValue("display"): "";
//		System.out.println("delivery address toaster" + driver.findElements(changeDeliveryAddressToaster).size());
//		System.out.println("shopping toaster" + driver.findElements(shoppingToaster).size());
		if (isDeliveryAddressExist && deliveryToasterCssStyle != "none") {
			
			WebElement CloseDelivery = driver.findElement(closeDeliveryToaster);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", CloseDelivery);
//			WebDriverWait wait = new WebDriverWait(driver, 30);
//			wait.until(ExpectedConditions.elementToBeClickable(closeDeliveryToaster)).click();

		}
		if (isShoppingToasterExist && shoppingToasterCssStyle != "none") {
			WebElement CloseShopping=driver.findElement(closeShoppingToaster);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", CloseShopping);
			//executor.executeScript("arguments[0].click();", closeShoppingToaster);
//			WebDriverWait wait = new WebDriverWait(driver, 30);
//			wait.until(ExpectedConditions.elementToBeClickable(closeShoppingToaster)).click();
		}

	}

	public void clickOnTodayDealLink() {
		driver.findElement(todaysDealLink).click();
	}

	public void selectDepartment() {
		driver.findElement(departmentSelection).click();
	}

	public boolean verifyFilterResult() {
		String expectedValue = "Software";
		WebDriverWait w1 = new WebDriverWait(driver, 15);
		w1.until(ExpectedConditions.presenceOfElementLocated(firstItemInList));
		driver.findElement(firstItemInList).click();
		WebDriverWait w = new WebDriverWait(driver, 15);
		w.until(ExpectedConditions.presenceOfElementLocated(breadCrumblink));
		String actualText = driver.findElement(breadCrumblink).getText();
		//System.out.println(actualText);
		if (actualText.equals(expectedValue)) {
			return true;
		} else {
			return false;
		}

	}

}
