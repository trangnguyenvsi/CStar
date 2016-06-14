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

	// Get page header
	public String getPageHeader() {
		return objSiteList.getVal_PageHeader().getText();
	}

	// Get page question text
	public String getPageDefaultQuestion() {
		return objSiteList.getVal_ZipEntryQuestion().getText();
	}

	// Clear text from textbox Zipcode
	public void clearZipCode() {
		objSiteList.getTxt_Zip().clear();
	}

	// Enter zip code to corresponding textbox
	public void enterZipCode(String zipCode) {
		objSiteList.getTxt_Zip().sendKeys(zipCode);
	}

	// Click icon verify zipcode
	public void clickBtnVerifyZip() {
		objSiteList.getBtn_VerifyZip().click();
	}

	// Check if error text appeared or not
	public boolean isZipCodeWrong() {
		boolean isWrong = false;
		if (objSiteList.getLbl_CityError().isDisplayed() == true) {
			isWrong = true;
		}
		return isWrong;
	}

	// Check if zip code correct or not
	public boolean isZipCodeCorrect() {
		boolean isCorrect;
		try {
			driver.findElement(By.xpath("//select[@id='ctl00_plcMain_ctlZipCodeSearch_ddlCity']/option")).getText();
			isCorrect = true;
		} catch (Exception e) {
			isCorrect= false;
		}
		return isCorrect;
	}

	// Check if loading image displayed or not
	public boolean isLoadingIMGDisplayed() {
		boolean isLoading = false;
		if (driver.findElements(By.id("ctl00_imgLoading")).size() != 0) {
			isLoading = true;
		}
		return isLoading;
	}

	public void clickBtnSearch() {
		objSiteList.getBtn_Search().click();
	}

	// Click buton New site
	public void clickBtnNewSite() {
		objSiteList.getBtn_NewSite().click();
	}
	
	//Click button Return to Team Calendar
	public void clickReturnTeamCalendar(){
		objSiteList.getBtn_ReturnToTeamCalendar().click();
	}

	public void waitToElementLoaded() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_imgLoading")));
	}

	public void clickFirstSiteInList() {
		driver.findElement(By.xpath("//table[@id='ctl00_plcMain_grdScreening']/tbody/tr[2]/td[2]")).click();
	}

	public void searchSiteByZipCode(String zipCode) {
		this.enterZipCode(zipCode);
		this.clickBtnVerifyZip();
		this.waitToElementLoaded();
		this.clickBtnSearch();
		this.waitToElementLoaded();
	}

}
