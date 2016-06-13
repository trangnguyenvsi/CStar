package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParticipantMaintainancePage {
	// Buton Refresh
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpCommunication_btnRefreshCommunication")
	private WebElement btn_Refresh;

	// Buton Add Note
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpNotes_ucNotesList_btnAddNotes")
	private WebElement btn_AddNote;

	// Checkbox Primary Address
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_ucfvAddress2_chkPrimary")
	private WebElement chk_PrimaryAddress;

	// Textbox Address1
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_ucfvAddress2_txtAddress1")
	private WebElement txt_Address1;

	// Textbox Address2
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_ucfvAddress2_txtAddress2")
	private WebElement txt_Address2;

	// Textbox Address3
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_ucfvAddress2_txtAddress3")
	private WebElement txt_Address3;

	// Textbox City
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_ucfvAddress2_txtCity")
	private WebElement txt_City;

	// Textbox State
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_ucfvAddress2_txtState")
	private WebElement txt_State;

	// Textbox Zip
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_ucfvAddress2_ctlZipCode_txtZip")
	private WebElement txt_Zip;

	// Textbox AddressNotes
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_ucfvAddress2_txtAddressNotes")
	private WebElement txt_AddressNotes;

	// Checkbox Manual Geo Code
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_ucfvAddress2_chkManualGeoCode")
	private WebElement chk_ManualGeoCode;

	// Buton Save Address
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_btnSave")
	private WebElement btn_SaveAddress;

	// Buton Cancel Address
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_btnCancel")
	private WebElement btn_CancelAddress;

	// Buton Save Phone
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpPhone_ucPhoneRepeater_btnSave")
	private WebElement btn_SavePhone;

	// Buton Cancel Phone
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpPhone_ucPhoneRepeater_btnCancel")
	private WebElement btn_CancelPhone;

	// Buton Save Email
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpEmail_ucEmailRepeater_btnSave")
	private WebElement btn_SaveEmail;

	// Buton Cancel Email
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpEmail_ucEmailRepeater_btnCancel")
	private WebElement btn_CancelEmail;

	// Buton Continue
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpGiftCards_ucGiftCards_btnCancelGC")
	private WebElement btn_Continue;

	// Buton Cancel GiftCard
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpGiftCards_ucGiftCards_btnHdnCancelReason")
	private WebElement btn_CancelGiftCard;

	// Buton Retrieve
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpGiftCards_btnGiftCardRetrieveHidden")
	private WebElement btn_Retrieve;

	// Buton Add
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpIdentification_ucPartAddtionalIDs_btnAdd")
	private WebElement btn_Add;

	// Buton Edit
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_btnEdit")
	private WebElement btn_Edit;

	// Buton Return to Search
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_btnReturnToList")
	private WebElement btn_ReturnToSearch;

	// Buton Log Call
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_callHistoryControl_btnRecordCallHistory")
	private WebElement btn_LogCall;

	// Buton Schedule Appointment
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_callHistoryControl_btnAddAppointment")
	private WebElement btn_ScheduleAppointment;

	// Buton Call History
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_callHistoryControl_hfHdnCallHistory")
	private WebElement btn_CallHistory;

	// Textbox Name Call History
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_callHistoryControl_txtName")
	private WebElement txt_NameCallHistory;

	// Textbox Phone Call History
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_callHistoryControl_ctlPhone_tbPhone")
	private WebElement txt_PhoneCallHistory;

	// Textbox Dnis_Input Call History
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_callHistoryControl_ctlDNIS_cbDnis_Input")
	private WebElement txt_DNIS_Input;

	// Textbox Date Call History
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_callHistoryControl_dtPickerCallDate_dateInput")
	private WebElement txt_Date_LogCall;

	// Textbox Disposition Call History
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_callHistoryControl_ddlDispo_ddSysType_Input")
	private WebElement txt_Disposition;

	// Buton Save Log Call
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_callHistoryControl_btnSave")
	private WebElement btn_SaveLogCall;

	// Buton Cancel Log Call
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_callHistoryControl_btnCancel")
	private WebElement btn_CancelLogCall;

	// Buton Appointment Wizard
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_callHistoryControl_btnApptWizard")
	private WebElement btn_AppointmentWizard;

	// Buton Close
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_callHistoryControl_btnClose")
	private WebElement btn_CloseScheduleAppoinment;

	// Buton Close
	@FindBy(id = "ctl00_body_ucFvParticipant_ucCapscan_btnClose")
	private WebElement btn_Close;

	// Buton
	@FindBy(id = "ctl00_body_ucFvParticipant_btnShowPopup")
	private WebElement btn_ctl00_body_ucFvParticipant_btnShowPopup;

	// Textbox ctl00_ddlEndCallDispo_ddSysType_Input
	@FindBy(id = "ctl00_ddlEndCallDispo_ddSysType_Input")
	private WebElement txt_ctl00_ddlEndCallDispo_ddSysType_Input;

	// Buton Ok
	@FindBy(id = "ctl00_btnEndCallOk")
	private WebElement btn_Ok;

	// Buton Cancel
	@FindBy(id = "ctl00_btnCancel")
	private WebElement btn_Cancel;

	// Linktext Edit Contact Via Phone
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_Preferences1_gvPreferences_ctl02_lbtnEdit")
	private WebElement lnk_Edit_ContactViaPhone;

	// Linktext Edit Contact via eMail
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_Preferences1_gvPreferences_ctl03_lbtnEdit")
	private WebElement lnk_Edit_ContactViaEmail;

	// Linktext Edit Request E-Newsletter
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_Preferences1_gvPreferences_ctl04_lbtnEdit")
	private WebElement lnk_Edit_RequestENewsletter;

	// Linktext Edit Contact via Mail
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_Preferences1_gvPreferences_ctl05_lbtnEdit")
	private WebElement lnk_Edit_ContactViaMail;

	// Linktext Edit Membership
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_Preferences1_gvPreferences_ctl06_lbtnEdit")
	private WebElement lnk_Edit_Membership;

	// Linktext Edit Share information with 3rd party
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_Preferences1_gvPreferences_ctl07_lbtnEdit")
	private WebElement lnk_Edit_ShareInformationWith3rdParty;
	
	//Value fields (static field)
	
	//Value of Name
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblNameValue")
	private WebElement val_Name;
	
	//Value of Nickname
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblNickName")
	private WebElement val_NickName;
	
	//Value of DOB
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblDobValue")
	private WebElement val_DOB;
	
	//Value of age
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblAgeValue")
	private WebElement val_Age;
	
	//Value of gender
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblGenderValue")
	private WebElement val_Gender;
	
	//Value of Lead
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblFCLValue")
	private WebElement val_Lead;
	
	//value of DNIS
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblParticipantSourceValue")
	private WebElement val_DNIS;
	
	//Value or Prioriry Code
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_Label2")
	private WebElement val_PriorityCode;
	
	//Value of VIP
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblVipValue")
	private WebElement val_VIP;
	
	//Value of Address Type
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblPrimaryAddressType")
	private WebElement val_AddressType;
	
	//Value of Address Line 1
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblPrimaryAddressStreet1")
	private WebElement val_Address1;
	
	//Value of Address Line 2
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblPrimaryAddressStreet2")
	private WebElement val_Address2;
	
	//Value of Address Line 3
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblPrimaryAddressStreet3")
	private WebElement val_Address3;
	
	//Value of City
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblPrimaryAddressCity")
	private WebElement val_City;
	
	//Value of State
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblPrimaryAddressState")
	private WebElement val_State;
	
	//Value of Zipcode
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblPrimaryAddressZip")
	private WebElement val_Zipcode;
	
	//Value of Country
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblPrimaryAddressCountry")
	private WebElement val_Country;
	
	//Value of Address note
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblPrimaryAddressComment")
	private WebElement val_AddressNote;
	
	//Value of phone type
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblPrimaryPhoneType")
	private WebElement val_PhoneType;
	
	//Value of phone number
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblPrimaryPhoneNumber")
	private WebElement val_PhoneNo;
	
	//Value of email type
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblPrimaryEmailType")
	private WebElement val_EmailType;
	
	//Value of email
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblPrimaryEmail")
	private WebElement val_Email;
	
	//Tab Appointments
	@FindBy(id="__tab_ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAppointments")
	private WebElement tab_Appoinments;
	
	//Tab Communication
	@FindBy(id="__tab_ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpCommunication")
	private WebElement tab_Communication;
	
	//tab Participant History
	@FindBy(id="__tab_ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpHistory")
	private WebElement tab_ParticipantHistory;
	
	//Tab Notes
	@FindBy(id="__tab_ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpNotes")
	private WebElement tab_Notes;
	
	//Tab address
	@FindBy(id="__tab_ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress")
	private WebElement tab_Address;
	
	//tab phone
	@FindBy(id="__tab_ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpPhone")
	private WebElement tab_Phone;
	
	//Tab Email
	@FindBy(id="__tab_ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpEmail")
	private WebElement tab_Email;
	
	//Tab Gift card
	@FindBy(id="__tab_ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpGiftCards")
	private WebElement tab_GiftCards;
	
	//Tab indentification
	@FindBy(id="__tab_ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpIdentification")
	private WebElement tab_Identification;
	
	//Tab AWV Checks
	@FindBy(id="__tab_ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAWV")
	private WebElement tab_AWVChecks;

	//Linktext Edit Current Address
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_rAddress_ctl01_lbEdit")
	private WebElement lnk_EditCurrentAddress;
	
	//Dropdown list Address Type
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_ucfvAddress2_ddlAddressTypes")
	private WebElement ddl_AddressType;
	
	//Button Verify Zipcode
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_ucfvAddress2_ctlZipCode_ibVerifyZip")
	private WebElement btn_VerifyZipcode;
	
	//Panel Address (address form)
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_pnlAddress")
	private WebElement pu_AddressForm;
	
	//Value primary address type
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_rAddress_ctl01_lblAddressType")
	private WebElement val_AddressType2;
	
	//Value primary address line 1
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_rAddress_ctl01_lblAddress1")
	private WebElement val_Address1_2;
	
	/**
	 * Bean Shell
	 */
	//TODO BEAN SHELL HERE
	

	public WebElement getBtn_Refresh() {
		return btn_Refresh;
	}

	public WebElement getPu_AddressForm() {
		return pu_AddressForm;
	}

	public void setPu_AddressForm(WebElement pu_AddressForm) {
		this.pu_AddressForm = pu_AddressForm;
	}

	public WebElement getBtn_VerifyZipcode() {
		return btn_VerifyZipcode;
	}

	public void setBtn_VerifyZipcode(WebElement btn_VerifyZipcode) {
		this.btn_VerifyZipcode = btn_VerifyZipcode;
	}

	public WebElement getDdl_AddressType() {
		return ddl_AddressType;
	}

	public void setDdl_AddressType(WebElement ddl_AddressType) {
		this.ddl_AddressType = ddl_AddressType;
	}

	public WebElement getLnk_EditCurrentAddress() {
		return lnk_EditCurrentAddress;
	}

	public void setLnk_EditCurrentAddress(WebElement lnk_EditCurrentAddress) {
		this.lnk_EditCurrentAddress = lnk_EditCurrentAddress;
	}

	public WebElement getTab_Appoinments() {
		return tab_Appoinments;
	}

	public void setTab_Appoinments(WebElement tab_Appoinments) {
		this.tab_Appoinments = tab_Appoinments;
	}

	public WebElement getTab_Communication() {
		return tab_Communication;
	}

	public void setTab_Communication(WebElement tab_Communication) {
		this.tab_Communication = tab_Communication;
	}

	public WebElement getTab_ParticipantHistory() {
		return tab_ParticipantHistory;
	}

	public void setTab_ParticipantHistory(WebElement tab_ParticipantHistory) {
		this.tab_ParticipantHistory = tab_ParticipantHistory;
	}

	public WebElement getTab_Notes() {
		return tab_Notes;
	}

	public void setTab_Notes(WebElement tab_Notes) {
		this.tab_Notes = tab_Notes;
	}

	public WebElement getTab_Address() {
		return tab_Address;
	}

	public void setTab_Address(WebElement tab_Address) {
		this.tab_Address = tab_Address;
	}

	public WebElement getTab_Phone() {
		return tab_Phone;
	}

	public void setTab_Phone(WebElement tab_Phone) {
		this.tab_Phone = tab_Phone;
	}

	public WebElement getTab_Email() {
		return tab_Email;
	}

	public void setTab_Email(WebElement tab_Email) {
		this.tab_Email = tab_Email;
	}

	public WebElement getTab_GiftCards() {
		return tab_GiftCards;
	}

	public void setTab_GiftCards(WebElement tab_GiftCards) {
		this.tab_GiftCards = tab_GiftCards;
	}

	public WebElement getTab_Identification() {
		return tab_Identification;
	}

	public void setTab_Identification(WebElement tab_Identification) {
		this.tab_Identification = tab_Identification;
	}

	public WebElement getTab_AWVChecks() {
		return tab_AWVChecks;
	}

	public void setTab_AWVChecks(WebElement tab_AWVChecks) {
		this.tab_AWVChecks = tab_AWVChecks;
	}

	public WebElement getVal_Name() {
		return val_Name;
	}

	public void setVal_Name(WebElement val_Name) {
		this.val_Name = val_Name;
	}

	public WebElement getVal_NickName() {
		return val_NickName;
	}

	public void setVal_NickName(WebElement val_NickName) {
		this.val_NickName = val_NickName;
	}

	public WebElement getVal_DOB() {
		return val_DOB;
	}

	public void setVal_DOB(WebElement val_DOB) {
		this.val_DOB = val_DOB;
	}

	public WebElement getVal_Age() {
		return val_Age;
	}

	public void setVal_Age(WebElement val_Age) {
		this.val_Age = val_Age;
	}

	public WebElement getVal_Gender() {
		return val_Gender;
	}

	public void setVal_Gender(WebElement val_Gender) {
		this.val_Gender = val_Gender;
	}

	public WebElement getVal_Lead() {
		return val_Lead;
	}

	public void setVal_Lead(WebElement val_Lead) {
		this.val_Lead = val_Lead;
	}

	public WebElement getVal_DNIS() {
		return val_DNIS;
	}

	public void setVal_DNIS(WebElement val_DNIS) {
		this.val_DNIS = val_DNIS;
	}

	public WebElement getVal_PriorityCode() {
		return val_PriorityCode;
	}

	public void setVal_PriorityCode(WebElement val_PriorityCode) {
		this.val_PriorityCode = val_PriorityCode;
	}

	public WebElement getVal_VIP() {
		return val_VIP;
	}

	public void setVal_VIP(WebElement val_VIP) {
		this.val_VIP = val_VIP;
	}

	public WebElement getVal_AddressType() {
		return val_AddressType;
	}

	public void setVal_AddressType(WebElement val_AddressType) {
		this.val_AddressType = val_AddressType;
	}

	public WebElement getVal_Address1() {
		return val_Address1;
	}

	public void setVal_Address1(WebElement val_Address1) {
		this.val_Address1 = val_Address1;
	}

	public WebElement getVal_Address2() {
		return val_Address2;
	}

	public void setVal_Address2(WebElement val_Address2) {
		this.val_Address2 = val_Address2;
	}

	public WebElement getVal_Address3() {
		return val_Address3;
	}

	public void setVal_Address3(WebElement val_Address3) {
		this.val_Address3 = val_Address3;
	}

	public WebElement getVal_City() {
		return val_City;
	}

	public void setVal_City(WebElement val_City) {
		this.val_City = val_City;
	}

	public WebElement getVal_State() {
		return val_State;
	}

	public void setVal_State(WebElement val_State) {
		this.val_State = val_State;
	}

	public WebElement getVal_Zipcode() {
		return val_Zipcode;
	}

	public void setVal_Zipcode(WebElement val_Zipcode) {
		this.val_Zipcode = val_Zipcode;
	}

	public WebElement getVal_Country() {
		return val_Country;
	}

	public void setVal_Country(WebElement val_Country) {
		this.val_Country = val_Country;
	}

	public WebElement getVal_AddressNote() {
		return val_AddressNote;
	}

	public void setVal_AddressNote(WebElement val_AddressNote) {
		this.val_AddressNote = val_AddressNote;
	}

	public WebElement getVal_PhoneType() {
		return val_PhoneType;
	}

	public void setVal_PhoneType(WebElement val_PhoneType) {
		this.val_PhoneType = val_PhoneType;
	}

	public WebElement getVal_PhoneNo() {
		return val_PhoneNo;
	}

	public void setVal_PhoneNo(WebElement val_PhoneNo) {
		this.val_PhoneNo = val_PhoneNo;
	}

	public WebElement getVal_EmailType() {
		return val_EmailType;
	}

	public void setVal_EmailType(WebElement val_EmailType) {
		this.val_EmailType = val_EmailType;
	}

	public WebElement getVal_Email() {
		return val_Email;
	}

	public void setVal_Email(WebElement val_Email) {
		this.val_Email = val_Email;
	}

	public void setBtn_Refresh(WebElement btn_Refresh) {
		this.btn_Refresh = btn_Refresh;
	}

	public WebElement getBtn_AddNote() {
		return btn_AddNote;
	}

	public void setBtn_AddNote(WebElement btn_AddNote) {
		this.btn_AddNote = btn_AddNote;
	}

	public WebElement getChk_PrimaryAddress() {
		return chk_PrimaryAddress;
	}

	public void setChk_PrimaryAddress(WebElement chk_PrimaryAddress) {
		this.chk_PrimaryAddress = chk_PrimaryAddress;
	}

	public WebElement getTxt_Address1() {
		return txt_Address1;
	}

	public void setTxt_Address1(WebElement txt_Address1) {
		this.txt_Address1 = txt_Address1;
	}

	public WebElement getTxt_Address2() {
		return txt_Address2;
	}

	public void setTxt_Address2(WebElement txt_Address2) {
		this.txt_Address2 = txt_Address2;
	}

	public WebElement getTxt_Address3() {
		return txt_Address3;
	}

	public void setTxt_Address3(WebElement txt_Address3) {
		this.txt_Address3 = txt_Address3;
	}

	public WebElement getTxt_City() {
		return txt_City;
	}

	public void setTxt_City(WebElement txt_City) {
		this.txt_City = txt_City;
	}

	public WebElement getTxt_State() {
		return txt_State;
	}

	public void setTxt_State(WebElement txt_State) {
		this.txt_State = txt_State;
	}

	public WebElement getTxt_Zip() {
		return txt_Zip;
	}

	public void setTxt_Zip(WebElement txt_Zip) {
		this.txt_Zip = txt_Zip;
	}

	public WebElement getTxt_AddressNotes() {
		return txt_AddressNotes;
	}

	public void setTxt_AddressNotes(WebElement txt_AddressNotes) {
		this.txt_AddressNotes = txt_AddressNotes;
	}

	public WebElement getChk_ManualGeoCode() {
		return chk_ManualGeoCode;
	}

	public void setChk_ManualGeoCode(WebElement chk_ManualGeoCode) {
		this.chk_ManualGeoCode = chk_ManualGeoCode;
	}

	public WebElement getBtn_SaveAddress() {
		return btn_SaveAddress;
	}

	public void setBtn_SaveAddress(WebElement btn_SaveAddress) {
		this.btn_SaveAddress = btn_SaveAddress;
	}

	public WebElement getBtn_CancelAddress() {
		return btn_CancelAddress;
	}

	public void setBtn_CancelAddress(WebElement btn_CancelAddress) {
		this.btn_CancelAddress = btn_CancelAddress;
	}

	public WebElement getBtn_SavePhone() {
		return btn_SavePhone;
	}

	public void setBtn_SavePhone(WebElement btn_SavePhone) {
		this.btn_SavePhone = btn_SavePhone;
	}

	public WebElement getBtn_CancelPhone() {
		return btn_CancelPhone;
	}

	public void setBtn_CancelPhone(WebElement btn_CancelPhone) {
		this.btn_CancelPhone = btn_CancelPhone;
	}

	public WebElement getBtn_SaveEmail() {
		return btn_SaveEmail;
	}

	public void setBtn_SaveEmail(WebElement btn_SaveEmail) {
		this.btn_SaveEmail = btn_SaveEmail;
	}

	public WebElement getBtn_CancelEmail() {
		return btn_CancelEmail;
	}

	public void setBtn_CancelEmail(WebElement btn_CancelEmail) {
		this.btn_CancelEmail = btn_CancelEmail;
	}

	public WebElement getBtn_Continue() {
		return btn_Continue;
	}

	public void setBtn_Continue(WebElement btn_Continue) {
		this.btn_Continue = btn_Continue;
	}

	public WebElement getBtn_CancelGiftCard() {
		return btn_CancelGiftCard;
	}

	public void setBtn_CancelGiftCard(WebElement btn_CancelGiftCard) {
		this.btn_CancelGiftCard = btn_CancelGiftCard;
	}

	public WebElement getBtn_Retrieve() {
		return btn_Retrieve;
	}

	public void setBtn_Retrieve(WebElement btn_Retrieve) {
		this.btn_Retrieve = btn_Retrieve;
	}

	public WebElement getBtn_Add() {
		return btn_Add;
	}

	public void setBtn_Add(WebElement btn_Add) {
		this.btn_Add = btn_Add;
	}

	public WebElement getBtn_Edit() {
		return btn_Edit;
	}

	public void setBtn_Edit(WebElement btn_Edit) {
		this.btn_Edit = btn_Edit;
	}

	public WebElement getBtn_ReturnToSearch() {
		return btn_ReturnToSearch;
	}

	public void setBtn_ReturnToSearch(WebElement btn_ReturnToSearch) {
		this.btn_ReturnToSearch = btn_ReturnToSearch;
	}

	public WebElement getBtn_LogCall() {
		return btn_LogCall;
	}

	public void setBtn_LogCall(WebElement btn_LogCall) {
		this.btn_LogCall = btn_LogCall;
	}

	public WebElement getBtn_ScheduleAppointment() {
		return btn_ScheduleAppointment;
	}

	public void setBtn_ScheduleAppointment(WebElement btn_ScheduleAppointment) {
		this.btn_ScheduleAppointment = btn_ScheduleAppointment;
	}

	public WebElement getBtn_CallHistory() {
		return btn_CallHistory;
	}

	public void setBtn_CallHistory(WebElement btn_CallHistory) {
		this.btn_CallHistory = btn_CallHistory;
	}

	public WebElement getTxt_NameCallHistory() {
		return txt_NameCallHistory;
	}

	public void setTxt_NameCallHistory(WebElement txt_NameCallHistory) {
		this.txt_NameCallHistory = txt_NameCallHistory;
	}

	public WebElement getTxt_PhoneCallHistory() {
		return txt_PhoneCallHistory;
	}

	public void setTxt_PhoneCallHistory(WebElement txt_PhoneCallHistory) {
		this.txt_PhoneCallHistory = txt_PhoneCallHistory;
	}

	public WebElement getTxt_DNIS_Input() {
		return txt_DNIS_Input;
	}

	public void setTxt_DNIS_Input(WebElement txt_DNIS_Input) {
		this.txt_DNIS_Input = txt_DNIS_Input;
	}

	public WebElement getTxt_Date_LogCall() {
		return txt_Date_LogCall;
	}

	public void setTxt_Date_LogCall(WebElement txt_Date_LogCall) {
		this.txt_Date_LogCall = txt_Date_LogCall;
	}

	public WebElement getTxt_Disposition() {
		return txt_Disposition;
	}

	public void setTxt_Disposition(WebElement txt_Disposition) {
		this.txt_Disposition = txt_Disposition;
	}

	public WebElement getBtn_SaveLogCall() {
		return btn_SaveLogCall;
	}

	public void setBtn_SaveLogCall(WebElement btn_SaveLogCall) {
		this.btn_SaveLogCall = btn_SaveLogCall;
	}

	public WebElement getBtn_CancelLogCall() {
		return btn_CancelLogCall;
	}

	public void setBtn_CancelLogCall(WebElement btn_CancelLogCall) {
		this.btn_CancelLogCall = btn_CancelLogCall;
	}

	public WebElement getBtn_AppointmentWizard() {
		return btn_AppointmentWizard;
	}

	public void setBtn_AppointmentWizard(WebElement btn_AppointmentWizard) {
		this.btn_AppointmentWizard = btn_AppointmentWizard;
	}

	public WebElement getBtn_CloseScheduleAppoinment() {
		return btn_CloseScheduleAppoinment;
	}

	public void setBtn_CloseScheduleAppoinment(WebElement btn_CloseScheduleAppoinment) {
		this.btn_CloseScheduleAppoinment = btn_CloseScheduleAppoinment;
	}

	public WebElement getBtn_Close() {
		return btn_Close;
	}

	public void setBtn_Close(WebElement btn_Close) {
		this.btn_Close = btn_Close;
	}

	public WebElement getBtn_ctl00_body_ucFvParticipant_btnShowPopup() {
		return btn_ctl00_body_ucFvParticipant_btnShowPopup;
	}

	public void setBtn_ctl00_body_ucFvParticipant_btnShowPopup(WebElement btn_ctl00_body_ucFvParticipant_btnShowPopup) {
		this.btn_ctl00_body_ucFvParticipant_btnShowPopup = btn_ctl00_body_ucFvParticipant_btnShowPopup;
	}

	public WebElement getTxt_ctl00_ddlEndCallDispo_ddSysType_Input() {
		return txt_ctl00_ddlEndCallDispo_ddSysType_Input;
	}

	public void setTxt_ctl00_ddlEndCallDispo_ddSysType_Input(WebElement txt_ctl00_ddlEndCallDispo_ddSysType_Input) {
		this.txt_ctl00_ddlEndCallDispo_ddSysType_Input = txt_ctl00_ddlEndCallDispo_ddSysType_Input;
	}

	public WebElement getBtn_Ok() {
		return btn_Ok;
	}

	public void setBtn_Ok(WebElement btn_Ok) {
		this.btn_Ok = btn_Ok;
	}

	public WebElement getBtn_Cancel() {
		return btn_Cancel;
	}

	public void setBtn_Cancel(WebElement btn_Cancel) {
		this.btn_Cancel = btn_Cancel;
	}

	public WebElement getLnk_Edit_ContactViaPhone() {
		return lnk_Edit_ContactViaPhone;
	}

	public void setLnk_Edit_ContactViaPhone(WebElement lnk_Edit_ContactViaPhone) {
		this.lnk_Edit_ContactViaPhone = lnk_Edit_ContactViaPhone;
	}

	public WebElement getLnk_Edit_ContactViaEmail() {
		return lnk_Edit_ContactViaEmail;
	}

	public void setLnk_Edit_ContactViaEmail(WebElement lnk_Edit_ContactViaEmail) {
		this.lnk_Edit_ContactViaEmail = lnk_Edit_ContactViaEmail;
	}

	public WebElement getLnk_Edit_RequestENewsletter() {
		return lnk_Edit_RequestENewsletter;
	}

	public void setLnk_Edit_RequestENewsletter(WebElement lnk_Edit_RequestENewsletter) {
		this.lnk_Edit_RequestENewsletter = lnk_Edit_RequestENewsletter;
	}

	public WebElement getLnk_Edit_ContactViaMail() {
		return lnk_Edit_ContactViaMail;
	}

	public void setLnk_Edit_ContactViaMail(WebElement lnk_Edit_ContactViaMail) {
		this.lnk_Edit_ContactViaMail = lnk_Edit_ContactViaMail;
	}

	public WebElement getLnk_Edit_Membership() {
		return lnk_Edit_Membership;
	}

	public void setLnk_Edit_Membership(WebElement lnk_Edit_Membership) {
		this.lnk_Edit_Membership = lnk_Edit_Membership;
	}

	public WebElement getLnk_Edit_ShareInformationWith3rdParty() {
		return lnk_Edit_ShareInformationWith3rdParty;
	}

	public void setLnk_Edit_ShareInformationWith3rdParty(WebElement lnk_Edit_ShareInformationWith3rdParty) {
		this.lnk_Edit_ShareInformationWith3rdParty = lnk_Edit_ShareInformationWith3rdParty;
	}

}
