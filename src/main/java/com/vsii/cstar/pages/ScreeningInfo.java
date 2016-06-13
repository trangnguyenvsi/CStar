package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScreeningInfo {
	// Define Web Elements
	// Dropdown Representative
	@FindBy(id = "ctl00_body_ctlRepresentatives")
	private WebElement dropdown_Representative;

	//Dropdown Marketing Plan
	@FindBy(id = "ctl00_body_ddlMarketingPlan")
	private WebElement dropdown_MarketingPlan;
	
	//Dropdown ACO Type
	@FindBy(id="ctl00_body_ctlACOType")
	private WebElement ddl_ACOType;

	//Dropdown Drive Type
	@FindBy(id = "ctl00_body_ddlDriveType")
	private WebElement dropdown_DriveType;

	//Site hours open time
	@FindBy(id="ctl00_body_timePickerFrom_radTimePicker_dateInput")
	private WebElement txt_SiteHoursOpenTime;
	
	//Site hours close time
	@FindBy(id="ctl00_body_timePickerTo_radTimePicker_dateInput")
	private WebElement txt_SiteHoursCloseTime;
	
	//Textbox From of Site Hours label
	@FindBy(id = "ctl00_body_timePickerFrom_radTimePicker_dateInput")
	private WebElement txt_SiteStartTime;

	//Textbox To of Site Hours label
	@FindBy(id = "ctl00_body_timePickerTo_radTimePicker_dateInput")
	private WebElement txt_SiteEndTime;

	//Dropdown Product Sets
	@FindBy(id = "ctl00_body_ddlProductSet")
	private WebElement dropdown_ProductSet;

	//Dropdown Price Level
	@FindBy(id = "ctl00_body_ddlPriceLevel")
	private WebElement dropdown_PriceLevel;

	//Dropdown Schedule Code
	@FindBy(id = "ctl00_body_ddlScheduleCode")
	private WebElement dropdown_ScheduleCode;
	
	//Value HIPAA 
	@FindBy(id="ctl00_body_lblHipaaFormVal")
	private WebElement val_HIPAA;

	//Button Save & Continue to Screening
	@FindBy(id = "ctl00_body_btnSaveScreening")
	private WebElement btn_SaveNContinueToScreening;

	/**
	 * Bean Shell
	 */
	
	
	
	public WebElement getVal_HIPAA() {
		return val_HIPAA;
	}

	public WebElement getTxt_SiteHoursOpenTime() {
		return txt_SiteHoursOpenTime;
	}

	public void setTxt_SiteHoursOpenTime(WebElement txt_SiteHoursOpenTime) {
		this.txt_SiteHoursOpenTime = txt_SiteHoursOpenTime;
	}

	public WebElement getTxt_SiteHoursCloseTime() {
		return txt_SiteHoursCloseTime;
	}

	public void setTxt_SiteHoursCloseTime(WebElement txt_SiteHoursCloseTime) {
		this.txt_SiteHoursCloseTime = txt_SiteHoursCloseTime;
	}

	public WebElement getDdl_ACOType() {
		return ddl_ACOType;
	}

	public void setDdl_ACOType(WebElement ddl_ACOType) {
		this.ddl_ACOType = ddl_ACOType;
	}

	public void setVal_HIPAA(WebElement val_HIPAA) {
		this.val_HIPAA = val_HIPAA;
	}

	public WebElement getDropdown_Representative() {
		return dropdown_Representative;
	}

	public void setDropdown_Representative(WebElement dropdown_Representative) {
		this.dropdown_Representative = dropdown_Representative;
	}

	public WebElement getDropdown_MarketingPlan() {
		return dropdown_MarketingPlan;
	}

	public void setDropdown_MarketingPlan(WebElement dropdown_MarketingPlan) {
		this.dropdown_MarketingPlan = dropdown_MarketingPlan;
	}

	public WebElement getDropdown_DriveType() {
		return dropdown_DriveType;
	}

	public void setDropdown_DriveType(WebElement dropdown_DriveType) {
		this.dropdown_DriveType = dropdown_DriveType;
	}

	public WebElement getTxt_SiteStartTime() {
		return txt_SiteStartTime;
	}

	public void setTxt_SiteStartTime(WebElement txt_SiteStartTime) {
		this.txt_SiteStartTime = txt_SiteStartTime;
	}

	public WebElement getTxt_SiteEndTime() {
		return txt_SiteEndTime;
	}

	public void setTxt_SiteEndTime(WebElement txt_SiteEndTime) {
		this.txt_SiteEndTime = txt_SiteEndTime;
	}

	public WebElement getDropdown_ProductSet() {
		return dropdown_ProductSet;
	}

	public void setDropdown_ProductSet(WebElement dropdown_ProductSet) {
		this.dropdown_ProductSet = dropdown_ProductSet;
	}

	public WebElement getDropdown_PriceLevel() {
		return dropdown_PriceLevel;
	}

	public void setDropdown_PriceLevel(WebElement dropdown_PriceLevel) {
		this.dropdown_PriceLevel = dropdown_PriceLevel;
	}

	public WebElement getDropdown_ScheduleCode() {
		return dropdown_ScheduleCode;
	}

	public void setDropdown_ScheduleCode(WebElement dropdown_ScheduleCode) {
		this.dropdown_ScheduleCode = dropdown_ScheduleCode;
	}

	public WebElement getBtn_SaveNContinueToScreening() {
		return btn_SaveNContinueToScreening;
	}

	public void setBtn_SaveNContinueToScreening(WebElement btn_SaveNContinueToScreening) {
		this.btn_SaveNContinueToScreening = btn_SaveNContinueToScreening;
	}

}
