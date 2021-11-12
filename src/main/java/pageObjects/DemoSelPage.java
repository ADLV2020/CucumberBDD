package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoSelPage {

	// Constructor
	WebDriver driver;	
	public DemoSelPage(WebDriver driver) {
		this.driver=driver;
	}
	
	// Locators of elements
	By btnPhone = By.xpath("//div[@class='list-group']/a[@id='itemc'][2]");
	By btnFirstPhone = By.xpath("//div[@id='tbodyid']/div[1]/div/a");
	By btnAddCart = By.className("btn-success");
	By btnCart = By.id("cartur");
	By btnPlaceOrder = By.className("btn-success");
	By tbxName = By.id("name");
	By tbxCountry = By.id("country");
	By tbxCity = By.id("city");
	By tbxCard = By.id("card");
	By tbxMOnth = By.id("month");
	By tbxYear = By.id("year");
	By btnPurchase = By.xpath("//button[@onclick='purchaseOrder()']");
	By tbxMessage = By.xpath("//div[contains(@class,'sweet-alert')]/h2");
	By btnOkOrder = By.className("confirm");
	
	// Method over elements
	public void select_MobilePhone() {
		driver.findElement(btnPhone).click();
		driver.findElement(btnFirstPhone).click();
	}
	public void add_ToCart() throws InterruptedException {
		driver.findElement(btnAddCart).click();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		alert.accept(); 
	}
	public void enter_OrderPlace_Data() {
		driver.findElement(btnCart).click();
		driver.findElement(btnPlaceOrder).click();
		driver.findElement(tbxName).sendKeys("USER ABC");
		driver.findElement(tbxCountry).sendKeys("ARG");
		driver.findElement(tbxCity).sendKeys("CABA");
		driver.findElement(tbxCard).sendKeys("1234987612349876");
		driver.findElement(tbxMOnth).sendKeys("11");
		driver.findElement(tbxYear).sendKeys("26");
		driver.findElement(btnPurchase).click();
	}
	public String get_OrderMessage() {
		String getMessage = driver.findElement(tbxMessage).getText();
		driver.findElement(btnOkOrder).click();
		return getMessage;
	}

}
