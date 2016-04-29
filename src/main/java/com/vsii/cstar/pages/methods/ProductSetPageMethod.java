package com.vsii.cstar.pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.vsii.cstar.pages.ProductSetPage;

public class ProductSetPageMethod {
	WebDriver driver;
	public ProductSetPage objProductSet = new ProductSetPage();

	public ProductSetPageMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objProductSet);
	}
	
	public void viewDetailProductSet(String productSetName){
		String xpath_ProductSet="//a[contains(text(),'" +productSetName+ "')]";
		driver.findElement(By.xpath(xpath_ProductSet)).click();
	}
}
