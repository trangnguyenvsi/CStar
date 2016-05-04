package com.vsii.cstar.pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.vsii.cstar.pages.ProductPage;

public class ProductPageMethod {
	WebDriver driver;
	public ProductPage objProductPage=new ProductPage();
	
	public ProductPageMethod(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, objProductPage);
	}
	
	public void searchProduct(String productName){
		objProductPage.getTxt_Search().sendKeys(productName);
		objProductPage.getBtn_Search().click();
	}
	
	public void selectSearchedProduct(String productName){
		String xpath_Product="//a[contains(text(),'"+productName+"')]";
		driver.findElement(By.xpath(xpath_Product)).click();
	}
}
