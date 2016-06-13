package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamCalendarPage {
	// Define Elements

	// Header of page
	@FindBy(id = "ctl00_heading_lblHeading")
	private WebElement val_PageHeader;

	// Header Month year information
	@FindBy(xpath="//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td/table/tbody/tr/td[2]")
	private WebElement lbl_MonthYearInfo;
	
	// Dropdown Month
	@FindBy(id = "ctl00_plcMain_ddlMonth")
	private WebElement dropdown_Month;

	// Dropdown year
	@FindBy(id = "ctl00_plcMain_ddlYear")
	private WebElement dropdown_Year;

	// Dropdown Team
	@FindBy(id = "ctl00_plcMain_ddlTeamList")
	private WebElement dropdown_Team;

	// Checkbox Showall
	@FindBy(id = "ctl00_plcMain_chkShowAll")
	private WebElement checkbox_Showall;

	// Radio button Calendar
	@FindBy(id = "ctl00_plcMain_radioBtnViewOption_0")
	private WebElement radio_Calendar;

	// Radio button Grid
	@FindBy(id = "ctl00_plcMain_radioBtnViewOption_1")
	private WebElement radio_Grid;

	// Loading image
	@FindBy(id = "ctl00_imgLoading")
	private WebElement img_Loading;

	// Option: Add Screening
	@FindBy(id = "ctl00_plcMain_grdControlTypes_ctl02_lnkBtnControlTypes")
	private WebElement option_AddScreening;

	// Option: Reserved
	@FindBy(id = "ctl00_plcMain_grdControlTypes_ctl03_lnkBtnControlTypes")
	private WebElement option_Reserved;
	
	//Dropdown Territory
	@FindBy(id="ctl00_plcMain_ddlTerritory")
	private WebElement ddl_Territory;
	
	//Button Save territory
	@FindBy(id="ctl00_plcMain_btnSave")
	private WebElement btn_SaveReservedDate;
	
	//Button Cancel reserved date
	@FindBy(id="ctl00_plcMain_btnCancel")
	private WebElement btn_CancelReservedDate;

	// Option: View Screening
	@FindBy(id = "ctl00_plcMain_grdControlTypes_ctl04_lnkBtnControlTypes")
	private WebElement option_ViewScreening;

	// Option: Site Change
	@FindBy(id = "ctl00_plcMain_grdControlTypes_ctl05_lnkBtnControlTypes")
	private WebElement option_SiteChange;

	// Option: Travel
	@FindBy(id = "ctl00_plcMain_grdControlTypes_ctl06_lnkBtnControlTypes")
	private WebElement option_Travel;

	// NOTE: Option Undo Reserved Date is not selected in this Screen

	/**
	 * Bean shell
	 */

	
	
	public WebElement getDropdown_Month() {
		return dropdown_Month;
	}

	public WebElement getLbl_MonthYearInfo() {
		return lbl_MonthYearInfo;
	}

	public void setLbl_MonthYearInfo(WebElement lbl_MonthYearInfo) {
		this.lbl_MonthYearInfo = lbl_MonthYearInfo;
	}

	public WebElement getDdl_Territory() {
		return ddl_Territory;
	}

	public void setDdl_Territory(WebElement ddl_Territory) {
		this.ddl_Territory = ddl_Territory;
	}

	public WebElement getBtn_SaveReservedDate() {
		return btn_SaveReservedDate;
	}

	public void setBtn_SaveReservedDate(WebElement btn_SaveReservedDate) {
		this.btn_SaveReservedDate = btn_SaveReservedDate;
	}

	public WebElement getBtn_CancelReservedDate() {
		return btn_CancelReservedDate;
	}

	public void setBtn_CancelReservedDate(WebElement btn_CancelReservedDate) {
		this.btn_CancelReservedDate = btn_CancelReservedDate;
	}

	public WebElement getVal_PageHeader() {
		return val_PageHeader;
	}

	public void setVal_PageHeader(WebElement val_PageHeader) {
		this.val_PageHeader = val_PageHeader;
	}

	public WebElement getImg_Loading() {
		return img_Loading;
	}

	public void setImg_Loading(WebElement img_Loading) {
		this.img_Loading = img_Loading;
	}

	public void setDropdown_Month(WebElement dropdown_Month) {
		this.dropdown_Month = dropdown_Month;
	}

	public WebElement getDropdown_Team() {
		return dropdown_Team;
	}

	public void setDropdown_Team(WebElement dropdown_Team) {
		this.dropdown_Team = dropdown_Team;
	}

	public WebElement getCheckbox_Showall() {
		return checkbox_Showall;
	}

	public void setCheckbox_Showall(WebElement checkbox_Showall) {
		this.checkbox_Showall = checkbox_Showall;
	}

	public WebElement getRadio_Calendar() {
		return radio_Calendar;
	}

	public void setRadio_Calendar(WebElement radio_Calendar) {
		this.radio_Calendar = radio_Calendar;
	}

	public WebElement getRadio_Grid() {
		return radio_Grid;
	}

	public void setRadio_Grid(WebElement radio_Grid) {
		this.radio_Grid = radio_Grid;
	}

	public WebElement getOption_AddScreening() {
		return option_AddScreening;
	}

	public void setOption_AddScreening(WebElement option_AddScreening) {
		this.option_AddScreening = option_AddScreening;
	}

	public WebElement getOption_Reserved() {
		return option_Reserved;
	}

	public void setOption_Reserved(WebElement option_Reserved) {
		this.option_Reserved = option_Reserved;
	}

	public WebElement getOption_ViewScreening() {
		return option_ViewScreening;
	}

	public void setOption_ViewScreening(WebElement option_ViewScreening) {
		this.option_ViewScreening = option_ViewScreening;
	}

	public WebElement getOption_SiteChange() {
		return option_SiteChange;
	}

	public void setOption_SiteChange(WebElement option_SiteChange) {
		this.option_SiteChange = option_SiteChange;
	}

	public WebElement getOption_Travel() {
		return option_Travel;
	}

	public void setOption_Travel(WebElement option_Travel) {
		this.option_Travel = option_Travel;
	}

	public WebElement getDropdown_Year() {
		return dropdown_Year;
	}

	public void setDropdown_Year(WebElement dropdown_Year) {
		this.dropdown_Year = dropdown_Year;
	}

}
