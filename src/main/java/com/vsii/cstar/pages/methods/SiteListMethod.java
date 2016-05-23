package com.vsii.cstar.pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vsii.cstar.pages.SiteList;

public class SiteListMethod {
	WebDriver driver;
	public SiteList objSiteList = new SiteList();

	public SiteListMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objSiteList);
	}
	
	public void enterZipCode(String zipCode){
		objSiteList.getTxt_Zip().sendKeys(zipCode);
	}
	
	public void clickBtnVerifyZip(){
		objSiteList.getBtn_VerifyZip().click();
	}
	
	public void clickBtnSearch(){
		objSiteList.getBtn_Search().click();
	}
	
	public void waitToElementLoaded(){
		String id = objSiteList.getImg_Loading().getAttribute("id");
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
	}
	
	public void clickFirstSiteInList(){
		driver.findElement(By.xpath("//table[@id='ctl00_plcMain_grdScreening']/tbody/tr[2]/td[2]")).click();
	}
	
	public void searchSiteByZipCode(String zipCode){
		this.enterZipCode(zipCode);
		this.clickBtnVerifyZip();
		this.waitToElementLoaded();
		this.clickBtnSearch();
		this.waitToElementLoaded();
	}
	
}
