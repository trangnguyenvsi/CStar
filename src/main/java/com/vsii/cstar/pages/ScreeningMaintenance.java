package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScreeningMaintenance {
	// Define WebElement
	/**
	 * Below Elements is in Address/Contact Info information block
	 */
	// Site Address Information
	@FindBy(id = "ctl00_body_litPrimaryAddress_top")
	private WebElement label_SiteAddress;

	@FindBy(id = "ctl00_body_ctlSitePhone_lblPhoneNumber")
	private WebElement label_SitePhoneNo;

	@FindBy(id = "ctl00_body_ctlSiteFax_lblPhoneNumber")
	private WebElement label_SiteFaxNo;

	@FindBy(id = "ctl00_body_lblPrimaryContactNameVal")
	private WebElement label_SiteContact;

	@FindBy(id = "ctl00_body_ctlPhonePrimaryContact_lblPhoneNumber")
	private WebElement label_SiteContactPhoneNo;

	@FindBy(id = "ctl00_body_lblPrimaryContactEmailVal")
	private WebElement label_SiteContactEmail;
	/**
	 * Below Elements is in Event Information information block
	 */
	@FindBy(id = "ctl00_body_lblEventRepresentativeVal")
	private WebElement label_Representative;

	@FindBy(id = "ctl00_body_lblEventDriveTypeVal")
	private WebElement label_DriveType;

	@FindBy(id = "ctl00_body_lblEventDriveTimeVal")
	private WebElement label_DriveTime;

	@FindBy(id = "ctl00_body_lblEventPriveLevelVal")
	private WebElement label_PriceLevel;

	@FindBy(id = "ctl00_body_lblMarketingInfoPlanVal")
	private WebElement label_MarketingPlan;

	/**
	 * Below Elements is in Other Information block
	 */
	@FindBy(id = "ctl00_body_lblInfoScheduleVal")
	private WebElement label_ScheduleCode;

	@FindBy(id = "ctl00_body_lnkScreeningAppointment")
	private WebElement link_Appointments;

	/**
	 * Elements in Products & Pricing Tab
	 */
	//Tab location
	@FindBy(id="__tab_ctl00_body_tabScreeningInfo_tabPnlProductPricing")
	WebElement tab_ProductsPricing;
	
	//Dropdown ProductSet
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlProductPricing_ddlProductSet")
	WebElement ddl_ProductSet;
	
	// Beans

	public WebElement getTab_ProductsPricing() {
		return tab_ProductsPricing;
	}

	public void setTab_ProductsPricing(WebElement tab_ProductsPricing) {
		this.tab_ProductsPricing = tab_ProductsPricing;
	}

	public WebElement getDdl_ProductSet() {
		return ddl_ProductSet;
	}

	public void setDdl_ProductSet(WebElement ddl_ProductSet) {
		this.ddl_ProductSet = ddl_ProductSet;
	}

	public WebElement getLabel_SiteAddress() {
		return label_SiteAddress;
	}

	public void setLabel_SiteAddress(WebElement label_SiteAddress) {
		this.label_SiteAddress = label_SiteAddress;
	}

	public WebElement getLabel_SitePhoneNo() {
		return label_SitePhoneNo;
	}

	public void setLabel_SitePhoneNo(WebElement label_SitePhoneNo) {
		this.label_SitePhoneNo = label_SitePhoneNo;
	}

	public WebElement getLabel_SiteFaxNo() {
		return label_SiteFaxNo;
	}

	public void setLabel_SiteFaxNo(WebElement label_SiteFaxNo) {
		this.label_SiteFaxNo = label_SiteFaxNo;
	}

	public WebElement getLabel_SiteContact() {
		return label_SiteContact;
	}

	public void setLabel_SiteContact(WebElement label_SiteContact) {
		this.label_SiteContact = label_SiteContact;
	}

	public WebElement getLabel_SiteContactPhoneNo() {
		return label_SiteContactPhoneNo;
	}

	public void setLabel_SiteContactPhoneNo(WebElement label_SiteContactPhoneNo) {
		this.label_SiteContactPhoneNo = label_SiteContactPhoneNo;
	}

	public WebElement getLabel_SiteContactEmail() {
		return label_SiteContactEmail;
	}

	public void setLabel_SiteContactEmail(WebElement label_SiteContactEmail) {
		this.label_SiteContactEmail = label_SiteContactEmail;
	}

	public WebElement getLabel_Representative() {
		return label_Representative;
	}

	public void setLabel_Representative(WebElement label_Representative) {
		this.label_Representative = label_Representative;
	}

	public WebElement getLabel_DriveType() {
		return label_DriveType;
	}

	public void setLabel_DriveType(WebElement label_DriveType) {
		this.label_DriveType = label_DriveType;
	}

	public WebElement getLabel_DriveTime() {
		return label_DriveTime;
	}

	public void setLabel_DriveTime(WebElement label_DriveTime) {
		this.label_DriveTime = label_DriveTime;
	}

	public WebElement getLabel_PriceLevel() {
		return label_PriceLevel;
	}

	public void setLabel_PriceLevel(WebElement label_PriceLevel) {
		this.label_PriceLevel = label_PriceLevel;
	}

	public WebElement getLabel_MarketingPlan() {
		return label_MarketingPlan;
	}

	public void setLabel_MarketingPlan(WebElement label_MarketingPlan) {
		this.label_MarketingPlan = label_MarketingPlan;
	}

	public WebElement getLabel_ScheduleCode() {
		return label_ScheduleCode;
	}

	public void setLabel_ScheduleCode(WebElement label_ScheduleCode) {
		this.label_ScheduleCode = label_ScheduleCode;
	}

	public WebElement getLink_Appointments() {
		return link_Appointments;
	}

	public void setLink_Appointments(WebElement link_Appointments) {
		this.link_Appointments = link_Appointments;
	}

}
