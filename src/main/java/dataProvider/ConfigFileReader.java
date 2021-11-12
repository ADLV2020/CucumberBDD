package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.BrowserType;
import enums.EnvironmentType;

public class ConfigFileReader {


	private Properties properties;
	private final String propertyFilePath = ".\\configs\\Configs.properties";
	
	public ConfigFileReader () {
		BufferedReader reader;
		try {
			reader = new BufferedReader( new FileReader ( propertyFilePath ) );
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException s) {
				s.printStackTrace();
			}
		} catch (FileNotFoundException n) {
			n.printStackTrace();
			throw new RuntimeException("Err. File not foun at " + propertyFilePath);
		}
	}
	
	public String getDriverPath () {
		String driverPath = properties.getProperty("DriverPath");
		if ( driverPath  != null ) return driverPath;
		else throw new RuntimeException("Err. Path for driver is empty.");
	}
	
	public String getDriverType () {
		String driverType = properties.getProperty("DriverType");
		if ( driverType  != null ) return driverType;
		else throw new RuntimeException("Err. Type for driver is empty.");
	}
	
	public String getURLdemo () {
		String URLdemo = properties.getProperty("URLdemo");
		if ( URLdemo  != null ) return URLdemo;
		else throw new RuntimeException("Err. URLdemo is empty or not defined.");
	}
	
	public long getWaitTime () {
		String waitTime = properties.getProperty("WaitTime");
		if ( waitTime  != null ) {
			try {
				return Long.parseLong(waitTime);
			} catch (NumberFormatException m) {
				throw new RuntimeException("Err. Not able to parse value.");
			}
		}
		else throw new RuntimeException("Err. Time for wait is not defined.");
	}
	
	public BrowserType getBrowser() {
		String browserType = properties.getProperty("BrowserType");
		if ( browserType != null ) {
			if ( browserType.equalsIgnoreCase("chrome") ) return BrowserType.CHROME;
			else if ( browserType.equalsIgnoreCase("firefox") ) return BrowserType.FIREFOX;
			else if ( browserType.equalsIgnoreCase("iexplorer") ) return BrowserType.INTERNETEXPLORER;
			else return BrowserType.CHROME;
		} else throw new RuntimeException("Err. Browser type is not defined. Verify. ");
	}
	
	public EnvironmentType getEnvironment() {
		String environment = properties.getProperty("Environment");
		if ( environment != null ) {
			if ( environment.equalsIgnoreCase("local") ) return EnvironmentType.LOCAL;
			else if ( environment.equalsIgnoreCase("remote") ) return EnvironmentType.REMOTE;
			else if ( environment.equalsIgnoreCase("headless") ) return EnvironmentType.HEADLESS;
			else return EnvironmentType.LOCAL;
		} else throw new RuntimeException("Err. Environment type is not defined. Verify. ");
	}
	
	public Boolean getBowserSize() {
		String browserSize = properties.getProperty("BrowserSize");
		if ( browserSize != null ) {
			if (browserSize.equalsIgnoreCase("false") ) return Boolean.valueOf(false);
			else return Boolean.valueOf(true);
		} else throw new RuntimeException("Err. Bowser Size is not defined. Verify. ");
	}
	
}
