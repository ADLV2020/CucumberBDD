package context;

import managers.PageObjectMng;
import managers.WebDriverMng;

public class TestContext {

	private WebDriverMng driverMng;
	private PageObjectMng pageObjMng;
	public SceContext scnContext;
	
	public TestContext() {
		driverMng = new WebDriverMng();
		pageObjMng = new PageObjectMng(driverMng.getDriver());
		scnContext = new SceContext();
	}
	
	public WebDriverMng getDriverMng() {
		return driverMng;
	}
	
	public PageObjectMng getPageObjectMng() {
		return pageObjMng;
	}
	
	public SceContext getSceContext() {
		return scnContext;
	}
	
}
