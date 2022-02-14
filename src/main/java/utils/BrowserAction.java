package utils;

import org.openqa.selenium.WebDriver;

public class BrowserAction {
	public WebDriver driver;
	
	public BrowserAction(WebDriver driver) {
		this.driver = driver;
	}
	

	//navigateToURl
	public static void navigateToURl(WebDriver driver, String URL){
		
		driver.get(URL);
	
	}
	
	//Maximize window
	
	public void maximizeWindow(WebDriver driver) {
		    driver.manage().window().maximize();
		    
	}
	 
	// Close Browser  // close browser
    public void tearDown() {
		
		// Quit for closing the browser and ending session // Close for only close the browser
			driver.quit();
	}
	

}
