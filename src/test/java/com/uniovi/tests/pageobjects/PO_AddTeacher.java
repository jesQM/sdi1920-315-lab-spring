package com.uniovi.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_AddTeacher extends PO_View {
	public static void fillForm(WebDriver driver, String dnip, String nombrep, String apellidosp, String categoriap) {
		WebElement dni = driver.findElement(By.name("DNI"));
		dni.click();
		dni.clear();
		dni.sendKeys(dnip);

		WebElement password = driver.findElement(By.name("Nombre"));
		password.click();
		password.clear();
		password.sendKeys(nombrep);
		
		WebElement apellidos = driver.findElement(By.name("Apellidos"));
		apellidos.click();
		apellidos.clear();
		apellidos.sendKeys(apellidosp);
		
		WebElement categoria = driver.findElement(By.name("Categoria"));
		categoria.click();
		categoria.clear();
		categoria.sendKeys(categoriap);

		// Pulsar el boton de Alta.
		By boton = By.xpath("/html/body/form/input[5]");
		driver.findElement(boton).click();
	}
}
