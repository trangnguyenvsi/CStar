package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteList {
 //Define web elements.
	
	//Page header
	@FindBy(id="ctl00_heading_lblHeading")
	private WebElement val_PageHeader;
	
	//Page span text
	@FindBy(id="ctl00_plcMain_lblZipEntryInstr")
	private WebElement val_ZipEntryQuestion;
	
	//Textbox Zipcode
	@FindBy(id="ctl00_plcMain_ctlZipCodeSearch_txtZip")
	private WebElement txt_Zip;
	
	//Button Verify Zip Code
	@FindBy(id="ctl00_plcMain_ctlZipCodeSearch_ibVerifyZip")
	private WebElement btn_VerifyZip;
	
	//Label error zip code
	@FindBy(id="ctl00_plcMain_ctlZipCodeSearch_lblCityError")
	private WebElement lbl_CityError;
	
	//Textbox City zip code
	@FindBy(id="ctl00_plcMain_ctlZipCodeSearch_ddlCity")
	private WebElement ddl_City; 
	
	//Button Search
	@FindBy(id="ctl00_plcMain_btnEnter")
	private WebElement btn_Search;
	
	//Loading Image
	@FindBy(id="ctl00_imgLoading")
	private WebElement img_Loading;
	
	//Buton New Site
	@FindBy(id="ctl00_plcMain_btnNewSite")
	private WebElement btn_NewSite;
	
	//Button Return to Team Calendar
	@FindBy(id="ctl00_plcMain_btnReturnToTeamCalendar")
	private WebElement btn_ReturnToTeamCalendar;
	
	/**
	 * Bean shell
	 */
	
	
	public WebElement getDdl_City() {
		return ddl_City;
	}

	public WebElement getBtn_ReturnToTeamCalendar() {
		return btn_ReturnToTeamCalendar;
	}

	public void setBtn_ReturnToTeamCalendar(WebElement btn_ReturnToTeamCalendar) {
		this.btn_ReturnToTeamCalendar = btn_ReturnToTeamCalendar;
	}

	public void setDdl_City(WebElement ddl_City) {
		this.ddl_City = ddl_City;
	}

	public WebElement getLbl_CityError() {
		return lbl_CityError;
	}

	public void setLbl_CityError(WebElement lbl_CityError) {
		this.lbl_CityError = lbl_CityError;
	}

	public WebElement getVal_PageHeader() {
		return val_PageHeader;
	}

	public void setVal_PageHeader(WebElement val_PageHeader) {
		this.val_PageHeader = val_PageHeader;
	}

	public WebElement getVal_ZipEntryQuestion() {
		return val_ZipEntryQuestion;
	}

	public void setVal_ZipEntryQuestion(WebElement val_ZipEntryQuestion) {
		this.val_ZipEntryQuestion = val_ZipEntryQuestion;
	}

	public WebElement getBtn_NewSite() {
		return btn_NewSite;
	}

	public void setBtn_NewSite(WebElement btn_NewSite) {
		this.btn_NewSite = btn_NewSite;
	}

	public WebElement getImg_Loading() {
		return img_Loading;
	}

	public void setImg_Loading(WebElement img_Loading) {
		this.img_Loading = img_Loading;
	}

	public WebElement getTxt_Zip() {
		return txt_Zip;
	}

	public void setTxt_Zip(WebElement txt_Zip) {
		this.txt_Zip = txt_Zip;
	}

	public WebElement getBtn_VerifyZip() {
		return btn_VerifyZip;
	}

	public void setBtn_VerifyZip(WebElement btn_VerifyZip) {
		this.btn_VerifyZip = btn_VerifyZip;
	}

	public WebElement getBtn_Search() {
		return btn_Search;
	}

	public void setBtn_Search(WebElement btn_Search) {
		this.btn_Search = btn_Search;
	}
}
