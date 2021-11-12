package seleniumTest;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.DemoSelPage;

public class TC02_SecondTest {

	private static WebDriver driver;
	private DemoSelPage demoPage;
	
	public static void main(String[] args) throws InterruptedException {

		
		System.out.println("Second test");
		// Set of params
		String sDrv = "webdriver.chrome.driver";
		String sDrvPath = "\\configs\\drivers\\chromedriver.95.0.4638.69.exe";
		String sUrl = "https://www.demoblaze.com/";
		String sExpetedMessage = "Thank you for your purchase!";
		String sObtainedMessage = "";
		try {
			String localDir = System.getProperty("user.dir");
			System.setProperty(sDrv, localDir + sDrvPath);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(sUrl);
			try {
				DemoSelPage demoPage = new DemoSelPage(driver);
				demoPage.select_MobilePhone();
				demoPage.add_ToCart();
				demoPage.enter_OrderPlace_Data();
				sObtainedMessage = demoPage.get_OrderMessage();
			} catch (Exception e) {
				System.out.println("Login fail. "+e.getMessage());
			} finally {
				if (sObtainedMessage != "") {
					Assert.assertEquals(sExpetedMessage, sObtainedMessage);
				}
			}
		} catch (Exception e) {
			System.out.println("Login fail. "+e.getMessage());
		} finally {
			driver.close();
		}
				
	}
	
}
