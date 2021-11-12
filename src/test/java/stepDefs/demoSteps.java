package stepDefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DemoBDDPage;

public class demoSteps {
	
	WebDriver driver;
	DemoBDDPage demoPage;

	String sDrv = "webdriver.chrome.driver";
	String sDrvPath = "\\configs\\drivers\\chromedriver.95.0.4638.69.exe";
	String sUrl = "https://www.demoblaze.com/";
	
	@Given("accedo al Store del sitio de demoblaze")
	public void accedo_al_store_del_sitio_de_demoblaze() {
		String localDir = System.getProperty("user.dir");
		System.setProperty(sDrv, localDir + sDrvPath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(sUrl);
	}

	@Given("ingreso a la categoria Phones del home page")
	public void ingreso_a_la_categoria_phones_del_home_page() {
	    DemoBDDPage demoPage = new DemoBDDPage(driver);
	    demoPage.clic_PhoneOptions();
	}

	@Given("selecciono el primer telefono de la lista")
	public void selecciono_el_primer_telefono_de_la_lista() {
		DemoBDDPage demoPage = new DemoBDDPage(driver);
		demoPage.select_FirstPhone();
	}

	@When("lo agrego al carro de compra")
	public void lo_agrego_al_carro_de_compra() throws InterruptedException {
		DemoBDDPage demoPage = new DemoBDDPage(driver);
		demoPage.clic_AddToCart();
	}

	@When("accedo al carro de compra")
	public void accedo_al_carro_de_compra() {
		DemoBDDPage demoPage = new DemoBDDPage(driver);
		demoPage.goTo_Cart();
	}

	@Then("se agrego el producto a la grilla")
	public void se_agrego_el_producto_a_la_grilla() {
		DemoBDDPage demoPage = new DemoBDDPage(driver);
		demoPage.goTo_PlaceOrder();
	}
	
	@When("completo los datos requeridos de la compra")
	public void completo_los_datos_requeridos_de_la_compra() {
		DemoBDDPage demoPage = new DemoBDDPage(driver);
		demoPage.enter_Name("USER ONE");
		demoPage.enter_Country("ARG");
		demoPage.enter_City("CABA");
		demoPage.enter_CardNumber("1234678912346789");
		demoPage.enter_Month("11");
		demoPage.enter_Year("26");
		demoPage.complete_PurchaseOrder();		
	}

	@Then("se confirma el proceso de compra")
	public void se_confirma_el_proceso_de_compra() {
		DemoBDDPage demoPage = new DemoBDDPage(driver);
		String sExpetedMessage = "Thank you for your purchase!";
		String sObtainedMessage = demoPage.get_ConfirmOrder();
		Assert.assertEquals(sExpetedMessage, sObtainedMessage);
		driver.close();
	}
	
	//////
	@When("selecciono realizar pedido")
	public void selecciono_realizar_pedido() {
		DemoBDDPage demoPage = new DemoBDDPage(driver);
		demoPage.goTo_PlaceOrder();
	}

	@When("completo {string}, {string}, {string}, {string}, {string} y {string} del formulario")
	public void completo_y_del_formulario(String name, String country, String city, String card, String month, String year) {
		DemoBDDPage demoPage = new DemoBDDPage(driver);
		demoPage.enter_Name(name);
		demoPage.enter_Country(country);
		demoPage.enter_City(city);
		demoPage.enter_CardNumber(card);
		demoPage.enter_Month(month);
		demoPage.enter_Year(year);
	}

	@When("hago clic en comprar")
	public void hago_clic_en_comprar() {
		DemoBDDPage demoPage = new DemoBDDPage(driver);
		demoPage.complete_PurchaseOrder();	
	}

	@Then("obtengo la confirmacion de la compra")
	public void obtengo_la_confirmacion_de_la_compra() {
		DemoBDDPage demoPage = new DemoBDDPage(driver);
		String sExpetedMessage = "Thank you for your purchase!";
		String sObtainedMessage = demoPage.get_ConfirmOrder();
		Assert.assertEquals(sExpetedMessage, sObtainedMessage);
		driver.close();
	}
	
}
