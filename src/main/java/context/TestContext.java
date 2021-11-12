package context;

import managers.PageObjectMng;
import managers.WebDriverMng;

public class TestContext {

	private WebDriverMng driverMng;
	private PageObjectMng pageObjMng;
	public ScnContext scnContext;
	
	public TestContext() {
		driverMng = new WebDriverMng();
		pageObjMng = new PageObjectMng(driverMng.getDriver());
		scnContext = new ScnContext();
	}
	
	public WebDriverMng getDriverMng() {
		return driverMng;
	}
	
	public PageObjectMng getPageObjectMng() {
		return pageObjMng;
	}
	
	public ScnContext getSceContext() {
		return scnContext;
	}
	
}
