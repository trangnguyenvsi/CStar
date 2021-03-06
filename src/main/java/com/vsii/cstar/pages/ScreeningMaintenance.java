package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScreeningMaintenance {
	// Define WebElement
	/**
	 * Below Elements is in Address/Contact Info information block
	 */
	// Screening header
	@FindBy(id = "ctl00_heading_lblHeading")
	private WebElement lbl_Heading;

	// Site Address Information
	// Screening name
	@FindBy(id = "ctl00_body_lblSiteNmVal")
	private WebElement lbl_ScreeningName;

	// Screening status
	@FindBy(id = "ctl00_body_lblStatusVal")
	private WebElement lbl_ScreeningStatus;

	// Site address
	@FindBy(id = "ctl00_body_litPrimaryAddress_top")
	private WebElement label_SiteAddress;

	// site phone no
	@FindBy(id = "ctl00_body_ctlSitePhone_lblPhoneNumber")
	private WebElement label_SitePhoneNo;

	// Site fax no
	@FindBy(id = "ctl00_body_ctlSiteFax_lblPhoneNumber")
	private WebElement label_SiteFaxNo;

	// Site contact - contact person
	@FindBy(id = "ctl00_body_lblPrimaryContactNameVal")
	private WebElement label_SiteContact;

	// Contact type
	@FindBy(id = "ctl00_body_lblPrimaryContactTypeVal")
	private WebElement val_ContactType;

	// Site contact - phone no
	@FindBy(id = "ctl00_body_ctlPhonePrimaryContact_lblPhoneNumber")
	private WebElement label_SiteContactPhoneNo;

	// Contact phone type
	@FindBy(id = "ctl00_body_ctlPhonePrimaryContact_lblPhoneType")
	private WebElement val_ContactPhoneType;

	// Site contact - email
	@FindBy(id = "ctl00_body_lblPrimaryContactEmailVal")
	private WebElement label_SiteContactEmail;

	// Contact email type
	@FindBy(id = "ctl00_body_lblPrimaryContactEmailTypeVal")
	private WebElement val_ContactEmailType;

	/**
	 * Below Elements is in Event Information information block
	 */
	// Representative name
	@FindBy(id = "ctl00_body_lblEventRepresentativeVal")
	private WebElement label_Representative;

	// Representative's department
	@FindBy(id = "ctl00_body_lblDepartmentVal")
	private WebElement label_Department;

	// Drived type
	@FindBy(id = "ctl00_body_lblEventDriveTypeVal")
	private WebElement label_DriveType;

	// Drive Time
	@FindBy(id = "ctl00_body_lblEventDriveTimeVal")
	private WebElement label_DriveTime;

	// Price Level
	@FindBy(id = "ctl00_body_lblEventPriveLevelVal")
	private WebElement label_PriceLevel;

	// Facility start and close time
	@FindBy(id = "ctl00_body_lblFacilityTimeVal")
	private WebElement label_FacilityTime;

	// Label schedule time
	@FindBy(id = "ctl00_body_lblEventScheduleVal")
	private WebElement lbl_ScheduleTime;

	// Label time zone
	@FindBy(id = "ctl00_body_lblEventScheduleTimeZone")
	private WebElement lbl_TimeZone;

	// Mareting Plan
	@FindBy(id = "ctl00_body_lblMarketingInfoPlanVal")
	private WebElement label_MarketingPlan;

	// Site type
	@FindBy(id = "ctl00_body_lblMarketingSiteTypeVal")
	private WebElement label_SiteType;

	// Marketing Zip Code
	@FindBy(id = "ctl00_body_lblMarketingPostalSectorVal")
	private WebElement label_MarketingZipCode;

	/**
	 * Below Elements is in Other Information block
	 */
	// Preliminary time
	@FindBy(id = "ctl00_body_lblPreliminaryVal")
	private WebElement lbl_Premininary;

	// Scheduling time
	@FindBy(id = "ctl00_body_lblSchedulingVal")
	private WebElement lbl_Scheduling;

	// Expecting Upload time
	@FindBy(id = "ctl00_body_lblExpectingUploadVal")
	private WebElement lbl_ExpectingUpload;

	// Field Reported time
	@FindBy(id = "ctl00_body_lblResultsVal")
	private WebElement lbl_FieldReport;

	// Loading Result time
	@FindBy(id = "ctl00_body_lblLoadingResultsVal")
	private WebElement lbl_LoadingResult;

	// Complete time
	@FindBy(id = "ctl00_body_lblCompletedVal")
	private WebElement lbl_Complete;

	// Changed time
	@FindBy(id = "ctl00_body_lblChangedVal")
	private WebElement lbl_Changed;

	// Change Reason
	@FindBy(id = "ctl00_body_lblChangeReasonVal")
	private WebElement lbl_ChangeReason;

	// Schedule Code
	@FindBy(id = "ctl00_body_lblInfoScheduleVal")
	private WebElement label_ScheduleCode;

	// Hyper link Appointments
	@FindBy(id = "ctl00_body_lnkScreeningAppointment")
	private WebElement link_Appointments;

	/**
	 * Elements in Products & Pricing Tab
	 */
	// Tab location
	@FindBy(id = "__tab_ctl00_body_tabScreeningInfo_tabPnlProductPricing")
	private WebElement tab_ProductsPricing;

	// Dropdown ProductSet
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlProductPricing_ddlProductSet")
	private WebElement ddl_ProductSet;

	// Dropdown Price Level
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlProductPricing_ddlPriceLevel")
	private WebElement ddl_PriceLevel;

	// Buton Exit - tab Product & Pricing
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlProductPricing_btnProductPricingExit")
	private WebElement btn_Exit_PPtab;
	
	//Button Save & Continue
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlProductPricing_btnProductPricingSaveContinue")
	private WebElement btn_SaveContinue_ProPrice;

	/**
	 * Site info tab
	 */
	// Tab location
	@FindBy(id = "__tab_ctl00_body_tabScreeningInfo_tabPnlSiteInfo")
	private WebElement tab_SiteInfo;

	// Texbox Note for UltraSound Team
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_txtUltrasoundNotes")
	private WebElement txt_NoteUltraSound;

	// Texbox Note for Call center
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_txtCallCenterNotes")
	private WebElement txt_NoteCallCenter;

	// Checkbox Site Requirements
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl02_chkActive")
	private WebElement chk_01;

	// Checkbox Site Requirements
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl03_chkActive")
	private WebElement chk_02;

	// Checkbox Site Requirements
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl04_chkActive")
	private WebElement chk_03;

	// Checkbox Site Requirements
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl05_chkActive")
	private WebElement chk_04;

	// Checkbox Site Requirements
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl06_chkActive")
	private WebElement chk_05;

	// Checkbox Site Requirements
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl07_chkActive")
	private WebElement chk_06;

	// Checkbox Site Requirements
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl08_chkActive")
	private WebElement chk_07;

	// Checkbox Site Requirements
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl09_chkActive")
	private WebElement chk_08;

	// Checkbox Site Requirements
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl10_chkActive")
	private WebElement chk_09;

	// Checkbox Site Requirements
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo_ctl11_chkActive")
	private WebElement chk_10;

	// Button Save & Continue
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_btnSiteInfoSaveContinue")
	private WebElement btn_SaveContinueSiteInfo;

	// Buton Edit Site
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_btnSiteInfoViewEdit")
	private WebElement btn_EditSite;

	// Button Exit
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_btnSiteInfoExit")
	private WebElement btn_Exit_SiteInfo;

	// Label Screening Requirements
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_lblScreeningReq")
	private WebElement lbl_ScreeningRequirements;

	// Label Notes for Ultrasound Team
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_lblUltrasoundNotes")
	private WebElement lbl_Note4UltraSound;

	// Label Notes for Call Center
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_lblCallCenterNotes")
	private WebElement lbl_Note4CallCenter;

	// Label Dimension
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlSiteInfo_lblDimensions")
	private WebElement lbl_Dimensions;

	/**
	 * Accounting tab
	 */
	// Tab Accounting location
	@FindBy(id = "__tab_ctl00_body_tabScreeningInfo_tabPnlAccounting")
	private WebElement tab_Accounting;

	// Link Add a check request
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_lnkAddCheck")
	private WebElement lnk_AddCheckRequest;

	// Dropdown Purpose
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_ctlCheckPurpose")
	private WebElement chk_Purpose;

	// Dropdown Payable to
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_txtPayableTo")
	private WebElement chk_PayTo;

	// Textbox Amount
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_ctlAmount_radInputBox")
	private WebElement txt_Amount;

	// Textbox VAT
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_ctlVatAmount_radInputBox")
	private WebElement txt_VAT;

	// Textbox date
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_chkDateNeeded_dateInput")
	private WebElement txt_DateNeeded;
	
	//Button Save Check Request
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_btnSave")
	private WebElement btn_SaveCheckRequest;

	// Value payment fullfill
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_lblTotalFulfilled")
	private WebElement val_PaymentsFullfilled;

	// Value payments requested
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_lblTotalRequested")
	private WebElement val_PaymentsRequested;

	// Value toltal
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_lblTotalPayments")
	private WebElement val_Total;

	// Button Exit
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlAccounting_btnAccountingExit")
	private WebElement btn_Exit_Accounting;

	// Label Payment fullfilled
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_lblFulfilledTxt")
	private WebElement lbl_PaymentsFulFilled;

	// Label Payments Requested
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_lblRequestedTxt")
	private WebElement lbl_PaymentsRequested;

	// Label Total
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_lblTotalPaymentsTxt")
	private WebElement lbl_Total;
	
	/**
	 * Travel tab
	 */
	// Tab location
	@FindBy(id = "__tab_ctl00_body_tabScreeningInfo_tabPnlTravel")
	private WebElement tab_Travel;

	//Label From start point to site
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlTravel_lblFromStartPointToSite")
	private WebElement lbl_FromStartPointToSite;
	
	//Label From site to end point
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlTravel_lblFromSiteToEndPoint")
	private WebElement lbl_FromSiteToEndPoint;

	// Button Exit
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlTravel_btnTravelExit")
	private WebElement btn_Exit_Travel;
	
	//Button Calculate Directions
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlTravel_btnTravelCalculateDirections")
	private WebElement btn_CalculateDirections;
	
	//Button Run Preliminary LOD
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlTravel_btnRunPreliminaryLOD")
	private WebElement btn_RunPreliminaryLOD;


	/**
	 * Advance Travel tab
	 */
	// Tab location
	@FindBy(id = "__tab_ctl00_body_tabScreeningInfo_tabPnlAdvanceTravel")
	private WebElement tab_AdvanceTravel;
	
	//Label Violations
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAdvanceTravel_lblAdvancedVioloations")
	private WebElement lbl_Violations;
	
	//Textbox Facility Open Time
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAdvanceTravel_tpAdvTravelFrom_dateInput")
	private WebElement txt_FacilityOpenTime;
	
	//Textbox Facility Close Time
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAdvanceTravel_tpAdvTravelTo_dateInput")
	private WebElement txt_FacilityCloseTime;
	
	//Textbox Start Scan
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAdvanceTravel_tpAdvStartScan_radTimePicker_dateInput")
	private WebElement txt_StartScanTime;
	
	//Textbox End Scan
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAdvanceTravel_tpAdvEndScan_radTimePicker_dateInput")
	private WebElement txt_EndScanTime;
	
	//Button Override Start Scan Time
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAdvanceTravel_btnAdvancedStartScanOverride")
	private WebElement btn_OverrideStartScan;
	
	//Button Override End Scan Time
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAdvanceTravel_btnAdvancedEndScanOverride")
	private WebElement btn_OverrideEndScan;
	
	//Button Calculate Directions
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAdvanceTravel_btnAdvancedCalculateDirections")
	private WebElement btn_AdvTrv_CalculateDrirections;
	
	//Button Run Preliminary LOD
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAdvanceTravel_btnAdvancedRunPreliminaryLOD")
	private WebElement btn_AdvTrv_RunPreliminaryLOD;

	// Button Exit
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlAdvanceTravel_btnAdvacedExit")
	private WebElement btn_Exit_AdvanceTravel;
	
	//Button Save& Exit
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAdvanceTravel_btnAdvancedSaveExit")
	private WebElement btn_SaveExitAdvTrv;
	
	//Button Save
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlAdvanceTravel_btnAdvancedSaveContinue")
	private WebElement btn_SaveAdvTrv;

	/**
	 * Marketing tab
	 */
	// tab location
	@FindBy(id = "__tab_ctl00_body_tabScreeningInfo_tabPnlMarketing")
	private WebElement tab_Marketing;
	
	//Dropdown Marketing plan
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlMarketing_ddlMarketingPlanTabs")
	private WebElement ddl_MarketingPlan;
	
	//Dropdown ACO Type
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlMarketing_ctlACOType")
	private WebElement ddl_ACOType;

	// Button Exit
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlMarketing_btnMarketingExit")
	private WebElement btn_Exit_Marketing;

	/**
	 * Note tab
	 */
	// tab location
	@FindBy(id = "__tab_ctl00_body_tabScreeningInfo_tabPnlNotes")
	private WebElement tab_Notes;

	// Button Exit
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlNotes_btnNotesExit")
	private WebElement btn_Exit_Notes;

	/**
	 * History tab
	 * 
	 */
	// tab location
	@FindBy(id = "__tab_ctl00_body_tabScreeningInfo_tabPnlHistory")
	private WebElement tab_History;
	
	//Grid History
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlHistory_grdHistory")
	private WebElement grid_History;

	// Button Exit
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlHistory_btnHistoryExit")
	private WebElement btn_Exit_History;

	/**
	 * Operation tab
	 */
	// tab location
	@FindBy(id = "__tab_ctl00_body_tabScreeningInfo_tabPnlOperations")
	private WebElement tab_Operations;
	
	//Dropdown status
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlOperations_ddlOpStatusList")
	private WebElement ddl_Status;
	
	//Dropdown reasons
	@FindBy(id="ctl00_body_tabScreeningInfo_tabPnlOperations_ddlOperationReasons")
	private WebElement ddl_Reasons;

	// Button Exit
	@FindBy(id = "ctl00_body_tabScreeningInfo_tabPnlOperations_btnOperationExit")
	private WebElement btn_Exit_Operations;

	/**
	 * Bean shell
	 */
	
	

	public WebElement getVal_ContactPhoneType() {
		return val_ContactPhoneType;
	}

	public WebElement getBtn_SaveExitAdvTrv() {
		return btn_SaveExitAdvTrv;
	}

	public void setBtn_SaveExitAdvTrv(WebElement btn_SaveExitAdvTrv) {
		this.btn_SaveExitAdvTrv = btn_SaveExitAdvTrv;
	}

	public WebElement getBtn_SaveAdvTrv() {
		return btn_SaveAdvTrv;
	}

	public void setBtn_SaveAdvTrv(WebElement btn_SaveAdvTrv) {
		this.btn_SaveAdvTrv = btn_SaveAdvTrv;
	}

	public WebElement getTxt_FacilityOpenTime() {
		return txt_FacilityOpenTime;
	}

	public void setTxt_FacilityOpenTime(WebElement txt_FacilityOpenTime) {
		this.txt_FacilityOpenTime = txt_FacilityOpenTime;
	}

	public WebElement getTxt_FacilityCloseTime() {
		return txt_FacilityCloseTime;
	}

	public void setTxt_FacilityCloseTime(WebElement txt_FacilityCloseTime) {
		this.txt_FacilityCloseTime = txt_FacilityCloseTime;
	}

	public WebElement getTxt_StartScanTime() {
		return txt_StartScanTime;
	}

	public void setTxt_StartScanTime(WebElement txt_StartScanTime) {
		this.txt_StartScanTime = txt_StartScanTime;
	}

	public WebElement getTxt_EndScanTime() {
		return txt_EndScanTime;
	}

	public void setTxt_EndScanTime(WebElement txt_EndScanTime) {
		this.txt_EndScanTime = txt_EndScanTime;
	}

	public WebElement getBtn_OverrideStartScan() {
		return btn_OverrideStartScan;
	}

	public void setBtn_OverrideStartScan(WebElement btn_OverrideStartScan) {
		this.btn_OverrideStartScan = btn_OverrideStartScan;
	}

	public WebElement getBtn_OverrideEndScan() {
		return btn_OverrideEndScan;
	}

	public void setBtn_OverrideEndScan(WebElement btn_OverrideEndScan) {
		this.btn_OverrideEndScan = btn_OverrideEndScan;
	}


	public WebElement getBtn_SaveContinue_ProPrice() {
		return btn_SaveContinue_ProPrice;
	}

	public void setBtn_SaveContinue_ProPrice(WebElement btn_SaveContinue_ProPrice) {
		this.btn_SaveContinue_ProPrice = btn_SaveContinue_ProPrice;
	}

	public WebElement getBtn_SaveCheckRequest() {
		return btn_SaveCheckRequest;
	}

	public void setBtn_SaveCheckRequest(WebElement btn_SaveCheckRequest) {
		this.btn_SaveCheckRequest = btn_SaveCheckRequest;
	}

	public WebElement getDdl_Status() {
		return ddl_Status;
	}

	public void setDdl_Status(WebElement ddl_Status) {
		this.ddl_Status = ddl_Status;
	}

	public WebElement getDdl_Reasons() {
		return ddl_Reasons;
	}

	public void setDdl_Reasons(WebElement ddl_Reasons) {
		this.ddl_Reasons = ddl_Reasons;
	}

	public WebElement getGrid_History() {
		return grid_History;
	}

	public void setGrid_History(WebElement grid_History) {
		this.grid_History = grid_History;
	}

	public WebElement getDdl_MarketingPlan() {
		return ddl_MarketingPlan;
	}

	public void setDdl_MarketingPlan(WebElement ddl_MarketingPlan) {
		this.ddl_MarketingPlan = ddl_MarketingPlan;
	}

	public WebElement getDdl_ACOType() {
		return ddl_ACOType;
	}

	public void setDdl_ACOType(WebElement ddl_ACOType) {
		this.ddl_ACOType = ddl_ACOType;
	}

	public WebElement getLbl_Violations() {
		return lbl_Violations;
	}

	public void setLbl_Violations(WebElement lbl_Violations) {
		this.lbl_Violations = lbl_Violations;
	}

	public WebElement getBtn_AdvTrv_CalculateDrirections() {
		return btn_AdvTrv_CalculateDrirections;
	}

	public void setBtn_AdvTrv_CalculateDrirections(WebElement btn_AdvTrv_CalculateDrirections) {
		this.btn_AdvTrv_CalculateDrirections = btn_AdvTrv_CalculateDrirections;
	}

	public WebElement getBtn_AdvTrv_RunPreliminaryLOD() {
		return btn_AdvTrv_RunPreliminaryLOD;
	}

	public void setBtn_AdvTrv_RunPreliminaryLOD(WebElement btn_AdvTrv_RunPreliminaryLOD) {
		this.btn_AdvTrv_RunPreliminaryLOD = btn_AdvTrv_RunPreliminaryLOD;
	}

	public WebElement getBtn_CalculateDirections() {
		return btn_CalculateDirections;
	}

	public void setBtn_CalculateDirections(WebElement btn_CalculateDirections) {
		this.btn_CalculateDirections = btn_CalculateDirections;
	}

	public WebElement getBtn_RunPreliminaryLOD() {
		return btn_RunPreliminaryLOD;
	}

	public void setBtn_RunPreliminaryLOD(WebElement btn_RunPreliminaryLOD) {
		this.btn_RunPreliminaryLOD = btn_RunPreliminaryLOD;
	}

	public WebElement getLbl_FromStartPointToSite() {
		return lbl_FromStartPointToSite;
	}

	public void setLbl_FromStartPointToSite(WebElement lbl_FromStartPointToSite) {
		this.lbl_FromStartPointToSite = lbl_FromStartPointToSite;
	}

	public WebElement getLbl_FromSiteToEndPoint() {
		return lbl_FromSiteToEndPoint;
	}

	public void setLbl_FromSiteToEndPoint(WebElement lbl_FromSiteToEndPoint) {
		this.lbl_FromSiteToEndPoint = lbl_FromSiteToEndPoint;
	}

	public WebElement getDdl_PriceLevel() {
		return ddl_PriceLevel;
	}

	public void setDdl_PriceLevel(WebElement ddl_PriceLevel) {
		this.ddl_PriceLevel = ddl_PriceLevel;
	}

	public WebElement getVal_PaymentsFullfilled() {
		return val_PaymentsFullfilled;
	}

	public void setVal_PaymentsFullfilled(WebElement val_PaymentsFullfilled) {
		this.val_PaymentsFullfilled = val_PaymentsFullfilled;
	}

	public WebElement getVal_PaymentsRequested() {
		return val_PaymentsRequested;
	}

	public void setVal_PaymentsRequested(WebElement val_PaymentsRequested) {
		this.val_PaymentsRequested = val_PaymentsRequested;
	}

	public WebElement getVal_Total() {
		return val_Total;
	}

	public void setVal_Total(WebElement val_Total) {
		this.val_Total = val_Total;
	}

	public WebElement getLbl_PaymentsFulFilled() {
		return lbl_PaymentsFulFilled;
	}

	public void setLbl_PaymentsFulFilled(WebElement lbl_PaymentsFulFilled) {
		this.lbl_PaymentsFulFilled = lbl_PaymentsFulFilled;
	}

	public WebElement getLbl_ScreeningRequirements() {
		return lbl_ScreeningRequirements;
	}

	public void setLbl_ScreeningRequirements(WebElement lbl_ScreeningRequirements) {
		this.lbl_ScreeningRequirements = lbl_ScreeningRequirements;
	}

	public WebElement getLbl_Note4UltraSound() {
		return lbl_Note4UltraSound;
	}

	public void setLbl_Note4UltraSound(WebElement lbl_Note4UltraSound) {
		this.lbl_Note4UltraSound = lbl_Note4UltraSound;
	}

	public WebElement getLbl_Note4CallCenter() {
		return lbl_Note4CallCenter;
	}

	public void setLbl_Note4CallCenter(WebElement lbl_Note4CallCenter) {
		this.lbl_Note4CallCenter = lbl_Note4CallCenter;
	}

	public WebElement getLbl_Dimensions() {
		return lbl_Dimensions;
	}

	public void setLbl_Dimensions(WebElement lbl_Dimensions) {
		this.lbl_Dimensions = lbl_Dimensions;
	}

	public WebElement getBtn_Exit_Accounting() {
		return btn_Exit_Accounting;
	}

	public void setBtn_Exit_Accounting(WebElement btn_Exit_Accounting) {
		this.btn_Exit_Accounting = btn_Exit_Accounting;
	}

	public WebElement getBtn_Exit_SiteInfo() {
		return btn_Exit_SiteInfo;
	}

	public void setBtn_Exit_SiteInfo(WebElement btn_Exit_SiteInfo) {
		this.btn_Exit_SiteInfo = btn_Exit_SiteInfo;
	}

	public WebElement getTab_Travel() {
		return tab_Travel;
	}

	public void setTab_Travel(WebElement tab_Travel) {
		this.tab_Travel = tab_Travel;
	}

	public WebElement getBtn_Exit_Travel() {
		return btn_Exit_Travel;
	}

	public void setBtn_Exit_Travel(WebElement btn_Exit_Travel) {
		this.btn_Exit_Travel = btn_Exit_Travel;
	}

	public WebElement getTab_AdvanceTravel() {
		return tab_AdvanceTravel;
	}

	public void setTab_AdvanceTravel(WebElement tab_AdvanceTravel) {
		this.tab_AdvanceTravel = tab_AdvanceTravel;
	}

	public WebElement getBtn_Exit_AdvanceTravel() {
		return btn_Exit_AdvanceTravel;
	}

	public void setBtn_Exit_AdvanceTravel(WebElement btn_Exit_AdvanceTravel) {
		this.btn_Exit_AdvanceTravel = btn_Exit_AdvanceTravel;
	}

	public WebElement getTab_Marketing() {
		return tab_Marketing;
	}

	public void setTab_Marketing(WebElement tab_Marketing) {
		this.tab_Marketing = tab_Marketing;
	}

	public WebElement getBtn_Exit_Marketing() {
		return btn_Exit_Marketing;
	}

	public void setBtn_Exit_Marketing(WebElement btn_Exit_Marketing) {
		this.btn_Exit_Marketing = btn_Exit_Marketing;
	}

	public WebElement getTab_Notes() {
		return tab_Notes;
	}

	public void setTab_Notes(WebElement tab_Notes) {
		this.tab_Notes = tab_Notes;
	}

	public WebElement getBtn_Exit_Notes() {
		return btn_Exit_Notes;
	}

	public void setBtn_Exit_Notes(WebElement btn_Exit_Notes) {
		this.btn_Exit_Notes = btn_Exit_Notes;
	}

	public WebElement getTab_History() {
		return tab_History;
	}

	public void setTab_History(WebElement tab_History) {
		this.tab_History = tab_History;
	}

	public WebElement getBtn_Exit_History() {
		return btn_Exit_History;
	}

	public void setBtn_Exit_History(WebElement btn_Exit_History) {
		this.btn_Exit_History = btn_Exit_History;
	}

	public WebElement getTab_Operations() {
		return tab_Operations;
	}

	public void setTab_Operations(WebElement tab_Operations) {
		this.tab_Operations = tab_Operations;
	}

	public WebElement getBtn_Exit_Operations() {
		return btn_Exit_Operations;
	}

	public void setBtn_Exit_Operations(WebElement btn_Exit_Operations) {
		this.btn_Exit_Operations = btn_Exit_Operations;
	}

	public void setVal_ContactPhoneType(WebElement val_ContactPhoneType) {
		this.val_ContactPhoneType = val_ContactPhoneType;
	}

	public WebElement getVal_ContactEmailType() {
		return val_ContactEmailType;
	}

	public void setVal_ContactEmailType(WebElement val_ContactEmailType) {
		this.val_ContactEmailType = val_ContactEmailType;
	}

	public WebElement getVal_ContactType() {
		return val_ContactType;
	}

	public void setVal_ContactType(WebElement val_ContactType) {
		this.val_ContactType = val_ContactType;
	}

	public WebElement getLbl_Heading() {
		return lbl_Heading;
	}

	public void setLbl_Heading(WebElement lbl_Heading) {
		this.lbl_Heading = lbl_Heading;
	}

	public WebElement getBtn_EditSite() {
		return btn_EditSite;
	}

	public void setBtn_EditSite(WebElement btn_EditSite) {
		this.btn_EditSite = btn_EditSite;
	}

	public WebElement getBtn_Exit_PPtab() {
		return btn_Exit_PPtab;
	}

	public void setBtn_Exit_PPtab(WebElement btn_Exit_PPtab) {
		this.btn_Exit_PPtab = btn_Exit_PPtab;
	}

	public WebElement getLabel_Department() {
		return label_Department;
	}

	public void setLabel_Department(WebElement label_Department) {
		this.label_Department = label_Department;
	}

	public WebElement getLabel_FacilityTime() {
		return label_FacilityTime;
	}

	public void setLabel_FacilityTime(WebElement label_FacilityTime) {
		this.label_FacilityTime = label_FacilityTime;
	}

	public WebElement getLabel_SiteType() {
		return label_SiteType;
	}

	public void setLabel_SiteType(WebElement label_SiteType) {
		this.label_SiteType = label_SiteType;
	}

	public WebElement getLabel_MarketingZipCode() {
		return label_MarketingZipCode;
	}

	public void setLabel_MarketingZipCode(WebElement label_MarketingZipCode) {
		this.label_MarketingZipCode = label_MarketingZipCode;
	}

	public WebElement getLbl_Premininary() {
		return lbl_Premininary;
	}

	public void setLbl_Premininary(WebElement lbl_Premininary) {
		this.lbl_Premininary = lbl_Premininary;
	}

	public WebElement getLbl_Scheduling() {
		return lbl_Scheduling;
	}

	public void setLbl_Scheduling(WebElement lbl_Scheduling) {
		this.lbl_Scheduling = lbl_Scheduling;
	}

	public WebElement getLbl_ExpectingUpload() {
		return lbl_ExpectingUpload;
	}

	public void setLbl_ExpectingUpload(WebElement lbl_ExpectingUpload) {
		this.lbl_ExpectingUpload = lbl_ExpectingUpload;
	}

	public WebElement getLbl_FieldReport() {
		return lbl_FieldReport;
	}

	public void setLbl_FieldReport(WebElement lbl_FieldReport) {
		this.lbl_FieldReport = lbl_FieldReport;
	}

	public WebElement getLbl_LoadingResult() {
		return lbl_LoadingResult;
	}

	public void setLbl_LoadingResult(WebElement lbl_LoadingResult) {
		this.lbl_LoadingResult = lbl_LoadingResult;
	}

	public WebElement getLbl_Complete() {
		return lbl_Complete;
	}

	public void setLbl_Complete(WebElement lbl_Complete) {
		this.lbl_Complete = lbl_Complete;
	}

	public WebElement getLbl_Changed() {
		return lbl_Changed;
	}

	public void setLbl_Changed(WebElement lbl_Changed) {
		this.lbl_Changed = lbl_Changed;
	}

	public WebElement getLbl_ChangeReason() {
		return lbl_ChangeReason;
	}

	public void setLbl_ChangeReason(WebElement lbl_ChangeReason) {
		this.lbl_ChangeReason = lbl_ChangeReason;
	}

	public WebElement getLbl_PaymentsRequested() {
		return lbl_PaymentsRequested;
	}

	public void setLbl_PaymentsRequested(WebElement lbl_PaymentsRequested) {
		this.lbl_PaymentsRequested = lbl_PaymentsRequested;
	}

	public WebElement getLbl_Total() {
		return lbl_Total;
	}

	public void setLbl_Total(WebElement lbl_Total) {
		this.lbl_Total = lbl_Total;
	}

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
