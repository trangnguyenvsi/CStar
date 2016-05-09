package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScreeningMaintenance {
	// Define WebElement
	/**
	 * Below Elements is in Address/Contact Info information block
	 */
	// Site Address Information
	//Screening name
	@FindBy(id="ctl00_body_lblSiteNmVal")
	private WebElement lbl_ScreeningName;
	
	//Screening status
	@FindBy(id="ctl00_body_lblStatusVal")
	private WebElement lbl_ScreeningStatus;
	
	//Site address
	@FindBy(id = "ctl00_body_litPrimaryAddress_top")
	private WebElement label_SiteAddress;

	//site phone no
	@FindBy(id = "ctl00_body_ctlSitePhone_lblPhoneNumber")
	private WebElement label_SitePhoneNo;

	//Site fax no
	@FindBy(id = "ctl00_body_ctlSiteFax_lblPhoneNumber")
	private WebElement label_SiteFaxNo;

	//Site contact - contact person
	@FindBy(id = "ctl00_body_lblPrimaryContactNameVal")
	private WebElement label_SiteContact;

	//Site contact - phone no
	@FindBy(id = "ctl00_body_ctlPhonePrimaryContact_lblPhoneNumber")
	private WebElement label_SiteContactPhoneNo;

	//Site contact - email
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

	//Label schedule time
	@FindBy(id="ctl00_body_lblEventScheduleVal")
	private WebElement lbl_ScheduleTime;
	
	//Label time zone
	@FindBy(id="ctl00_body_lblEventScheduleTimeZone")
	private WebElement lbl_TimeZone;
	
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
	private WebElement tab_ProductsPricing;
	
	//Dropdown ProductSet
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlProductPricing_ddlProductSet")
	private WebElement ddl_ProductSet;
	
	/**
	 * Site info tab
	 */
	//Tab location
	@FindBy(id="__tab_ctl00_body_tabScreeningInfo_tabPnlSiteInfo")
	private WebElement tab_SiteInfo;
	
	//Texbox Note for UltraSound Team
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlSiteInfo_txtUltrasoundNotes")
	private WebElement txt_NoteUltraSound;
	
	//Texbox Note for Call center
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlSiteInfo_txtCallCenterNotes")
	private WebElement txt_NoteCallCenter;
	
	//Checkbox Site Requirements 
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl02_chkActive")
	private WebElement chk_01;
	
	//Checkbox Site Requirements 
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl03_chkActive")
	private WebElement chk_02;
	
	//Checkbox Site Requirements 
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl04_chkActive")
	private WebElement chk_03;
	
	//Checkbox Site Requirements 
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl05_chkActive")
	private WebElement chk_04;
	
	//Checkbox Site Requirements 
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl06_chkActive")
	private WebElement chk_05;
	
	//Checkbox Site Requirements 
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl07_chkActive")
	private WebElement chk_06;
	
	//Checkbox Site Requirements 
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl08_chkActive")
	private WebElement chk_07;
	
	//Checkbox Site Requirements 
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl09_chkActive")
	private WebElement chk_08;
	
	//Checkbox Site Requirements 
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl10_chkActive")
	private WebElement chk_09;
	
	//Checkbox Site Requirements 
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl11_chkActive")
	private WebElement chk_10;
	
	//Button Save & Continue
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlSiteInfo_btnSiteInfoSaveContinue")
	private WebElement btn_SaveContinueSiteInfo;
	
	/**
	 * Accounting tab
	 */
	//Tab Accounting location
	@FindBy(id="__tab_ctl00_body_tabScreeningInfo_tabPnlAccounting")
	private WebElement tab_Accounting;
	
	//Link Add a check request
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_lnkAddCheck")
	private WebElement lnk_AddCheckRequest;
	
	//Dropdown Purpose
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_ctlCheckPurpose")
	private WebElement chk_Purpose;
	
	//Dropdown Payable to
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_txtPayableTo")
	private WebElement chk_PayTo;
	
	//Textbox Amount
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_ctlAmount_radInputBox")
	private WebElement txt_Amount;
	
	//Textbox VAT
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_ctlVatAmount_radInputBox")
	private WebElement txt_VAT;
	
	//Textbox date
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_chkDateNeeded_dateInput")
	private WebElement txt_DateNeeded;
	
	
	
	public WebElement getLbl_ScheduleTime() {
		return lbl_ScheduleTime;
	}

	public void setLbl_ScheduleTime(WebElement lbl_ScheduleTime) {
		this.lbl_ScheduleTime = lbl_ScheduleTime;
	}

	public WebElement getLbl_TimeZone() {
		return lbl_TimeZone;
	}

	public void setLbl_TimeZone(WebElement lbl_TimeZone) {
		this.lbl_TimeZone = lbl_TimeZone;
	}

	public WebElement getLbl_ScreeningStatus() {
		return lbl_ScreeningStatus;
	}

	public void setLbl_ScreeningStatus(WebElement lbl_ScreeningStatus) {
		this.lbl_ScreeningStatus = lbl_ScreeningStatus;
	}

	public WebElement getLbl_ScreeningName() {
		return lbl_ScreeningName;
	}

	public void setLbl_ScreeningName(WebElement lbl_ScreeningName) {
		this.lbl_ScreeningName = lbl_ScreeningName;
	}

	public WebElement getTab_Accounting() {
		return tab_Accounting;
	}

	public void setTab_Accounting(WebElement tab_Accounting) {
		this.tab_Accounting = tab_Accounting;
	}

	public WebElement getLnk_AddCheckRequest() {
		return lnk_AddCheckRequest;
	}

	public void setLnk_AddCheckRequest(WebElement lnk_AddCheckRequest) {
		this.lnk_AddCheckRequest = lnk_AddCheckRequest;
	}

	public WebElement getChk_Purpose() {
		return chk_Purpose;
	}

	public void setChk_Purpose(WebElement chk_Purpose) {
		this.chk_Purpose = chk_Purpose;
	}

	public WebElement getChk_PayTo() {
		return chk_PayTo;
	}

	public void setChk_PayTo(WebElement chk_PayTo) {
		this.chk_PayTo = chk_PayTo;
	}

	public WebElement getTxt_Amount() {
		return txt_Amount;
	}

	public void setTxt_Amount(WebElement txt_Amount) {
		this.txt_Amount = txt_Amount;
	}

	public WebElement getTxt_VAT() {
		return txt_VAT;
	}

	public void setTxt_VAT(WebElement txt_VAT) {
		this.txt_VAT = txt_VAT;
	}

	public WebElement getTxt_DateNeeded() {
		return txt_DateNeeded;
	}

	public void setTxt_DateNeeded(WebElement txt_DateNeeded) {
		this.txt_DateNeeded = txt_DateNeeded;
	}

	public WebElement getTab_SiteInfo() {
		return tab_SiteInfo;
	}

	public void setTab_SiteInfo(WebElement tab_SiteInfo) {
		this.tab_SiteInfo = tab_SiteInfo;
	}

	public WebElement getBtn_SaveContinueSiteInfo() {
		return btn_SaveContinueSiteInfo;
	}

	public void setBtn_SaveContinueSiteInfo(WebElement btn_SaveContinueSiteInfo) {
		this.btn_SaveContinueSiteInfo = btn_SaveContinueSiteInfo;
	}

	public WebElement getTxt_NoteUltraSound() {
		return txt_NoteUltraSound;
	}

	public void setTxt_NoteUltraSound(WebElement txt_NoteUltraSound) {
		this.txt_NoteUltraSound = txt_NoteUltraSound;
	}

	public WebElement getTxt_NoteCallCenter() {
		return txt_NoteCallCenter;
	}

	public void setTxt_NoteCallCenter(WebElement txt_NoteCallCenter) {
		this.txt_NoteCallCenter = txt_NoteCallCenter;
	}

	public WebElement getChk_01() {
		return chk_01;
	}

	public void setChk_01(WebElement chk_01) {
		this.chk_01 = chk_01;
	}

	public WebElement getChk_02() {
		return chk_02;
	}

	public void setChk_02(WebElement chk_02) {
		this.chk_02 = chk_02;
	}

	public WebElement getChk_03() {
		return chk_03;
	}

	public void setChk_03(WebElement chk_03) {
		this.chk_03 = chk_03;
	}

	public WebElement getChk_04() {
		return chk_04;
	}

	public void setChk_04(WebElement chk_04) {
		this.chk_04 = chk_04;
	}

	public WebElement getChk_05() {
		return chk_05;
	}

	public void setChk_05(WebElement chk_05) {
		this.chk_05 = chk_05;
	}

	public WebElement getChk_06() {
		return chk_06;
	}

	public void setChk_06(WebElement chk_06) {
		this.chk_06 = chk_06;
	}

	public WebElement getChk_07() {
		return chk_07;
	}

	public void setChk_07(WebElement chk_07) {
		this.chk_07 = chk_07;
	}

	public WebElement getChk_08() {
		return chk_08;
	}

	public void setChk_08(WebElement chk_08) {
		this.chk_08 = chk_08;
	}

	public WebElement getChk_09() {
		return chk_09;
	}

	public void setChk_09(WebElement chk_09) {
		this.chk_09 = chk_09;
	}

	public WebElement getChk_10() {
		return chk_10;
	}

	public void setChk_10(WebElement chk_10) {
		this.chk_10 = chk_10;
	}

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
