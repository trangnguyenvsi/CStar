package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamCalendarPage {
 //Define Elements
	//Dropdown Month & year
	@FindBy(id="ctl00_plcMain_ddlMonth")
	private WebElement dropdown_MonthYear;
	
	//Dropdown Team
	@FindBy(id="ctl00_plcMain_ddlTeamList")
	private WebElement dropdown_Team;
	
	//Checkbox Showall
	@FindBy(id="ctl00_plcMain_chkShowAll")
	private WebElement checkbox_Showall;
	
	//Radio button Calendar
	@FindBy(id="ctl00_plcMain_radioBtnViewOption_0")
	private WebElement radio_Calendar;
	
	//Radio button Grid
	@FindBy(id="ctl00_plcMain_radioBtnViewOption_1")
	private WebElement radio_Grid;
	
	//Option: Add Screening
	@FindBy(id="ctl00_plcMain_grdControlTypes_ctl02_lnkBtnControlTypes")
	private WebElement option_AddScreening;
	
	//Option: Reserved
	@FindBy(id="ctl00_plcMain_grdControlTypes_ctl03_lnkBtnControlTypes")
	private WebElement option_Reserved;
	
	//Option: View Screening
	@FindBy(id="ctl00_plcMain_grdControlTypes_ctl04_lnkBtnControlTypes")
	private WebElement option_ViewScreening;
	
	//Option: Site Change
	@FindBy(id="ctl00_plcMain_grdControlTypes_ctl05_lnkBtnControlTypes")
	private WebElement option_SiteChange;
	
	//Option: Travel
	@FindBy(id="ctl00_plcMain_grdControlTypes_ctl06_lnkBtnControlTypes")
	private WebElement option_Travel;
	//NOTE: Option Undo Reserved Date is not selected in this Screen
	
	public WebElement getDropdown_MonthYear() {
		return dropdown_MonthYear;
	}

	public void setDropdown_MonthYear(WebElement dropdown_MonthYear) {
		this.dropdown_MonthYear = dropdown_MonthYear;
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
	

}
