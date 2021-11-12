package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.BrowserType;
import enums.EnvironmentType;

public class WebDriverMng {

	private WebDriver driver;
	private static BrowserType browserType;
	private static EnvironmentType environmentType;
	private static String driverType;
	private static String driverPath;
	private static Boolean browserSize;
	private static int waitTime;
	
	public WebDriverMng() {
		browserType = FileReaderMng.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderMng.getInstance().getConfigReader().getEnvironment();
		driverType = FileReaderMng.getInstance().getConfigReader().getDriverType();
		driverPath = FileReaderMng.getInstance().getConfigReader().getDriverPath();
		browserSize = FileReaderMng.getInstance().getConfigReader().getBowserSize();
		waitTime = (int) FileReaderMng.getInstance().getConfigReader().getWaitTime();
	}
	
	public WebDriver getDriver() {
		if (driver == null) {
			driver = createDriver();
		}
		return driver;
	}
	
	private WebDriver createDriver() {
		switch (environmentType) {
			case LOCAL:
				driver = createLocalDriver();
				break;
			case REMOTE:
				driver = createRemoteDriver();
				break;
			case HEADLESS:
				driver = createHeadlessDriver();
				break;
		}
		return driver;
	}
	
	private WebDriver createLocalDriver() {
		switch (browserType) {
			case INTERNETEXPLORER:
				driver = new InternetExplorerDriver();
				break;
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				System.setProperty(driverType, driverPath);
				driver = new ChromeDriver();
				break;
		}
		if (browserSize) driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		return driver;
	}
	
	private WebDriver createRemoteDriver() {
		throw new RuntimeException("Err. Remote driver isn't implemented yet.");
	}
	
	private WebDriver createHeadlessDriver() {
		throw new RuntimeException("Err. Headless driver isn't implemented yet.");
	}
	
	public void closeDriver() {
		driver.close();
		driver.quit();
	}
	
}
