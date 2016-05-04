package com.vsii.cstar.pages.methods;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vsii.cstar.pages.ScreeningMaintenance;

public class ScreeningMaintainanceMethods {
	WebDriver driver;
	public ScreeningMaintenance objScreeningMaintainance = new ScreeningMaintenance();
	
	public ScreeningMaintainanceMethods(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, objScreeningMaintainance);
	}
	
	public void clickAppointmentsLinkText(){
		objScreeningMaintainance.getLink_Appointments().click();
	}
	
	public void selectProductsPricingTab(){
		objScreeningMaintainance.getTab_ProductsPricing().click();
	}
	
	public void selectDdlProductSet(String productSetname){
		Select selecto = new Select(objScreeningMaintainance.getDdl_ProductSet());
		selecto.selectByVisibleText(productSetname);
	}
	
	public String[] getProductsOfChosenProductSet() {
		int NumOfProduct2 = driver.findElements(By.xpath("//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr")).size()-1;
		
		// Declare array Product - prepare to get all product/packet name to
		// this Array
		String[] product2 = new String[NumOfProduct2];
		
		//Test arrayList
		
		for (int i = 2; i <= NumOfProduct2+1; i++) {
			String xpath_product = "//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr["+i+"]/td";
			product2[i-2]=driver.findElement(By.xpath(xpath_product)).getText();
		}
		
		Arrays.sort(product2);
		return product2;
	}
}
