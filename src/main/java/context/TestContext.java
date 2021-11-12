package context;

import managers.PageObjectMng;
import managers.WebDriverMng;

public class TestContext {

	private WebDriverMng driverMng;
	private PageObjectMng poMng;
	public SceContext sceContext;
	
	public TestContext() {
		driverMng = new WebDriverMng();
		poMng = new PageObjectMng(driverMng.getDriver());
		sceContext = new SceContext();
	}
	
	public WebDriverMng getDriverMng() {
		return driverMng;
	}
	
	public PageObjectMng getPageObjectMng() {
		return poMng;
	}
	
	public SceContext getSceContext() {
		return sceContext;
	}
	
}
