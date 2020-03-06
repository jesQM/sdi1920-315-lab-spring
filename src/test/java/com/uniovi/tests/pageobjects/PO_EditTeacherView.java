package com.uniovi.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_EditTeacherView {
	
	public static void fillForm(WebDriver driver, String dnip, String namep, String surnamep, String categoryp) {
		WebElement dni = driver.findElement(By.name("dni"));
		dni.click();
		dni.clear();
		dni.sendKeys(dnip);

		WebElement password = driver.findElement(By.name("name"));
		password.click();
		password.clear();
		password.sendKeys(namep);

		WebElement sur = driver.findElement(By.name("surname"));
		sur.click();
		sur.clear();
		sur.sendKeys(surnamep);
		
		WebElement category = driver.findElement(By.name("category"));
		category.click();
		category.clear();
		category.sendKeys(categoryp);
		
		// Pulsar el boton de Alta.
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}
}
