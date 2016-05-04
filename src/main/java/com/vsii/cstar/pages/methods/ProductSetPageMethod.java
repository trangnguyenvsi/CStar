package com.vsii.cstar.pages.methods;

import java.util.Arrays;

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

	public void searchProductSet(String productSetName) {
		objProductSet.getTxt_Search().sendKeys(productSetName);
		objProductSet.getBtn_Search().click();
	}

	public void viewDetailProductSet(String productSetName) {
		String xpath_ProductSet = "//a[contains(text(),'" + productSetName + "')]";
		driver.findElement(By.xpath(xpath_ProductSet)).click();
	}

	public String[] getProductsOfOpenedProductSet() {
		int NumOfProduct = driver.findElements(By.xpath("//table[@id='ctl00_plcMain_gvCurrentProductSet']/tbody/tr"))
				.size();
		
		// Declare array Product - prepare to get all product/packet name to
		// this Array
		String[] product = new String[NumOfProduct - 1];

		for (int i = 2; i <= NumOfProduct; i++) {
			String xpath_product = "//table[@id='ctl00_plcMain_gvCurrentProductSet']/tbody/tr[" + i + "]/td[4]";
			product[i - 2] = driver.findElement(By.xpath(xpath_product)).getText();
		}
		
		Arrays.sort(product);
		return product;
	}
}
