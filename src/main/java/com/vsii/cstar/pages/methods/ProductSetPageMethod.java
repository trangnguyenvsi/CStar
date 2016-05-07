package com.vsii.cstar.pages.methods;

import java.util.ArrayList;
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

	/**
	 * 
	 * @return: Products code
	 */
	public String[] getProductsOfOpenedProductSet() {
		int NumOfItems = driver.findElements(By.xpath("//table[@id='ctl00_plcMain_gvCurrentProductSet']/tbody/tr"))
				.size();

		// Declare array Product - prepare to get all product/packet name to
		// this Array
		ArrayList<String> product = new ArrayList<>();
		// String[] product = new String[NumOfItems - 1];

		for (int i = 2; i <= NumOfItems; i++) {
			String xpath_type = "//table[@id='ctl00_plcMain_gvCurrentProductSet']/tbody/tr[" + i + "]/td[2]";
			String xpath_product = "//table[@id='ctl00_plcMain_gvCurrentProductSet']/tbody/tr[" + i + "]/td[3]";
			if (driver.findElement(By.xpath(xpath_type)).getText().equals("Product")) {
				product.add(driver.findElement(By.xpath(xpath_product)).getText());
			}
		}

		String[] product2 = new String[product.size()];
		product2 = product.toArray(product2);
		Arrays.sort(product2);
		return product2;
	}

	//Get package code in opened product set
	public String[] getPackagesOfOpenedProductSet() {
		int NumOfItems = driver.findElements(By.xpath("//table[@id='ctl00_plcMain_gvCurrentProductSet']/tbody/tr"))
				.size();

		// Declare array package - prepare to get all product/packet name to
		// this Array
		ArrayList<String> packet = new ArrayList<>();

		for (int i = 2; i <= NumOfItems; i++) {
			String xpath_type = "//table[@id='ctl00_plcMain_gvCurrentProductSet']/tbody/tr[" + i + "]/td[2]";
			String xpath_product = "//table[@id='ctl00_plcMain_gvCurrentProductSet']/tbody/tr[" + i + "]/td[3]";
			if (driver.findElement(By.xpath(xpath_type)).getText().equals("Package")) {
				packet.add(driver.findElement(By.xpath(xpath_product)).getText());
			}
		}

		String[] packet2 = new String[packet.size()];
		packet2 = packet.toArray(packet2);
		Arrays.sort(packet2);
		return packet2;
	}
}
