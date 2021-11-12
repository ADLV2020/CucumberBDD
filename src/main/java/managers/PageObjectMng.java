package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.ProductPurchasePage;
import pageObjects.ProductStorePage;

public class PageObjectMng {
	
	private WebDriver driver;
	
	public PageObjectMng(WebDriver driver) {
		this.driver=driver;
	}
	
	// PageObjects
	ProductStorePage storePage;
	ProductPurchasePage purchasePage;
	// PageObject Creation Method
	public ProductStorePage getProductStorePage() {
		return (storePage == null) ? storePage = new ProductStorePage(driver) : storePage;
	}
	public ProductPurchasePage getProductPurchasePage() {
		return (purchasePage == null) ? purchasePage = new ProductPurchasePage(driver) : purchasePage;
	}

}
