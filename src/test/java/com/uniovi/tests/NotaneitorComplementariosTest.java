package com.uniovi.tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.PO_AddTeacher;
import com.uniovi.tests.pageobjects.PO_EditTeacherView;
import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_LoginView;
import com.uniovi.tests.pageobjects.PO_NavView;
import com.uniovi.tests.pageobjects.PO_View;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotaneitorComplementariosTest {
	
	static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	static String Geckdriver024 = "D:\\MiUsuario\\Escritorio\\EclipseStuff\\tercero\\SDI\\Labs\\PL-SDI-Sesión5-material\\geckodriver024win64.exe";
	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	// Antes de cada prueba se navega al URL home de la aplicaciónn
	@Before
	public void setUp() {
		driver.navigate().to(URL);
	}

	// Después de cada prueba se borran las cookies del navegador
	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	// Antes de la primera prueba
	@BeforeClass
	static public void begin() {
	}

	// Al finalizar la última prueba
	@AfterClass
	static public void end() {
		// Cerramos el navegador al finalizar las pruebas
		driver.quit();
	}
	
	
	@Test
	public void Comp4_CambiarDatosProfe() {
		// Login as admin when clicking teacher
		PO_HomeView.clickOption(driver, "teacher", "class", "btn btn-primary");
		PO_LoginView.fillForm(driver, "99999988F", "123456");
		
		// Add a teacher
		PO_NavView.clickOption(driver, "add", "text", "Add");
		PO_AddTeacher.fillForm(driver, "12345678A", "Nombre", "Apellido", "Categoria");
		

		PO_NavView.clickOption(driver, "list", "text", "Teachers");
		// Details of teacher
		List<WebElement> e = PO_View.checkElement(driver, "free", "/html/body/div/div/table/tbody/tr/td/a");
		e.get(0).click();
		
		PO_NavView.clickOption(driver, "list", "text", "Teachers");
		// Edit of teacher
		e = PO_View.checkElement(driver, "free", "/html/body/div/div/table/tbody/tr/td/a");
		e.get(1).click();
		PO_EditTeacherView.fillForm(driver, " ", " ", " ", " ");
		PO_NavView.clickOption(driver, "list", "text", "Teachers");
		
		List<WebElement> f = PO_View.checkElement(driver, "free", "/html/body/div/div/table/tbody/tr[1]/td");
		assertTrue(f.get(0).getText().equals("12345678A")); // Fields are blank
		assertTrue(f.get(1).getText().equals("")); // Fields are blank
		assertTrue(f.get(2).getText().equals(""));
		
		// Delete of teacher
		e = PO_View.checkElement(driver, "free", "/html/body/div/div/table/tbody/tr/td/a");
		e.get(2).click();
	}
}
