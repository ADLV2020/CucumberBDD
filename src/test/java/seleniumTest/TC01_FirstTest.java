package seleniumTest;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_FirstTest {
	
	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		
		System.out.println("First test");
		
		String sDrv = "webdriver.chrome.driver";
		String sDrvPath = "\\configs\\drivers\\chromedriver.95.0.4638.69.exe";
		String sUrl = "https://www.demoblaze.com/";
		Integer iWait = 10;
		
		System.out.println("STEP 01: Set params & open web. \n");
		String localDir = System.getProperty("user.dir");
		System.setProperty(sDrv, localDir + sDrvPath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(iWait, TimeUnit.SECONDS);
		driver.get(sUrl);
		
		System.out.println("STEP 02: Select first product. \n");
		String sXpathPhoneButton = "//div[@class='list-group']/a[@id='itemc'][2]";
		WebElement btnPhone = driver.findElement(By.xpath(sXpathPhoneButton));
		btnPhone.click();
		
		String sXpathFirstPhone = "//div[@id='tbodyid']/div[1]/div/a";
		WebElement btnFirstPhone = driver.findElement(By.xpath(sXpathFirstPhone));
		btnFirstPhone.click();
		
		System.out.println("STEP 03: Add product to cart. \n");
		String sClassAddCartButton = "btn-success";
		WebElement btnAddCart = driver.findElement(By.className(sClassAddCartButton));
		btnAddCart.click(); 
		
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		alert.accept(); 

		String sIdCartButton = "cartur";
		WebElement btnCart = driver.findElement(By.id(sIdCartButton));
		btnCart.click(); 
		
		System.out.println("STEP 04: Enter data of place order. \n");
		String sClassOrderButton = "btn-success";
		WebElement btnPlaceOrder = driver.findElement(By.className(sClassOrderButton));
		btnPlaceOrder.click(); 
		
		String sIdNameText = "name";
		WebElement tbxName = driver.findElement(By.id(sIdNameText));
		tbxName.sendKeys("Usuario Uno");
		
		String sIdCountryText = "country";
		WebElement tbxCountry = driver.findElement(By.id(sIdCountryText));
		tbxCountry.sendKeys("ARGENTINA");
		
		String sIdCityText = "city";
		WebElement tbxCity = driver.findElement(By.id(sIdCityText));
		tbxCity.sendKeys("CABA");
		
		String sIdCardText = "card";
		WebElement tbxCard = driver.findElement(By.id(sIdCardText));
		tbxCard.sendKeys("1234987612349876");
		
		String sIdMonthText = "month";
		WebElement tbxMOnth = driver.findElement(By.id(sIdMonthText));
		tbxMOnth.sendKeys("11");
		
		String sIdYearText = "year";
		WebElement tbxYear = driver.findElement(By.id(sIdYearText));
		tbxYear.sendKeys("26"); 

		String sXpathPurchaseButton = "//button[@onclick='purchaseOrder()']";
		WebElement btnPurchase = driver.findElement(By.xpath(sXpathPurchaseButton));
		btnPurchase.click();
		
		System.out.println("STEP 05: Obtained purchase result. \n");
		String sXpathThankPurchase = "//div[contains(@class,'sweet-alert')]/h2";
		String sExpetedMessage = "Thank you for your purchase!";
		WebElement tbxMessage = driver.findElement(By.xpath(sXpathThankPurchase));
		String sObtainedMessage = tbxMessage.getText();
		
		String sClassOkButton = "confirm";
		WebElement btnOkOrder = driver.findElement(By.className(sClassOkButton));
		btnOkOrder.click();
		
		driver.close();

		Assert.assertEquals(sExpetedMessage, sObtainedMessage);
		
	}

}
