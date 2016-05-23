package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInformationPage {

	// Buton back to site
	@FindBy(id = "ctl00_plcMain_btnContact")
	private WebElement btn_BackToSite;

	// Buton Add
	@FindBy(id = "ctl00_plcMain_btnAdd")
	private WebElement btn_ContactInfo_Add;

	// Buton Edit
	@FindBy(id = "ctl00_plcMain_btnEdit")
	private WebElement btn_ContactInfo_Edit;

	// Buton Printer Friendly
	@FindBy(id = "ctl00_plcMain_bntPrinterFriendly")
	private WebElement btn_ContactInfo_Print;

	// Buton Save
	@FindBy(id = "ctl00_plcMain_btnSaveContact")
	private WebElement btn_ContactInfo_Save;

	// Buton Cancel
	@FindBy(id = "ctl00_plcMain_btnCancel")
	private WebElement btn_ContactInfo_Cancel;

	// Link Add Address
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_rAddress_ctl00_lbAddAddress")
	private WebElement hpl_ContactInfo_AddAddress;

	// Link Add Phone
	@FindBy(id = "ctl00_plcMain_tcDetails_tpPhone_rptPhone_rPhone_ctl00_lbAddPhone")
	private WebElement hpl_ContactInfo_AddPhone;

	// Link Add mail
	@FindBy(id = "ctl00_plcMain_tcDetails_tpEmail_rptEmail_rptEmail_ctl00_lbAddEmail")
	private WebElement hpl_ContactInfo_AddMail;

	// Buton Save at Add/Edit Address popup
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_btnSave")
	private WebElement btn_SaveAddress;

	// Buton Cancel at Add/Edit Address popup
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_btnCancel")
	private WebElement btn_CancelAddress;

	// Buton Verify address at Add/Edit Address popup
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_ucfvAddress2_imbVerifyAddress")
	private WebElement btn_VerifyAddress;

	// Buton Verify zip code at Add/Edit Address popup
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_ucfvAddress2_ctlZipCode_ibVerifyZip")
	private WebElement btn_VerifyZipCode;

	// Buton Save Phone
	@FindBy(id = "ctl00_plcMain_tcDetails_tpPhone_rptPhone_btnSave")
	private WebElement btn_SavePhone;

	// Buton Cancel Phone
	@FindBy(id = "ctl00_plcMain_tcDetails_tpPhone_rptPhone_btnCancel")
	private WebElement btn_CancelUpdatePhone;

	// Buton Save Mail
	@FindBy(id = "id=ctl00_plcMain_tcDetails_tpEmail_rptEmail_btnSave")
	private WebElement btn_SaveMail;

	// Buton Cancel Mail
	@FindBy(id = "ctl00_plcMain_tcDetails_tpEmail_rptEmail_btnCancel")
	private WebElement btn_CancelUpdateMail;

	// Dropdown Salutation
	@FindBy(id = "ctl00_plcMain_ddlSal")
	private WebElement ddl_Salutation;

	// Textbox First name
	@FindBy(id = "ctl00_plcMain_txtFirst")
	private WebElement txt_FirstName;

	// Textbox MI name
	@FindBy(id = "ctl00_plcMain_txtMI")
	private WebElement txt_MIName;

	// Textbox Last Name
	@FindBy(id = "ctl00_plcMain_txtLast")
	private WebElement txt_LastName;

	// Dropdown Suffix
	@FindBy(id = "ctl00_plcMain_ddlSuff")
	private WebElement ddl_Suffix;

	// Dropdown Type
	@FindBy(id = "ctl00_plcMain_ddlContactType")
	private WebElement ddl_ContactType;

	// Textbox Title
	@FindBy(id = "ctl00_plcMain_txtFor")
	private WebElement txt_Title;

	// Areabox Comments
	@FindBy(id = "ctl00_plcMain_txtComment")
	private WebElement txt_Comments;

	// Checkbox Primary
	@FindBy(id = "ctl00_plcMain_chkPrimary")
	private WebElement chk_Primary;

	// Tab Address
	@FindBy(id = "__tab_ctl00_plcMain_tcDetails_tpAddress")
	private WebElement tab_Address;

	// Tab Phone
	@FindBy(id = "__tab_ctl00_plcMain_tcDetails_tpPhone")
	private WebElement tab_Phone;

	// Tab Email
	@FindBy(id = "__tab_ctl00_plcMain_tcDetails_tpEmail")
	private WebElement tab_Email;

	/////////////////// Elements at popup Add/Edit Address //////////////////
	
	//Checkbox Primary
	@FindBy(id="ctl00_plcMain_tcDetails_tpAddress_rptAddress_ucfvAddress2_chkPrimary")
	private WebElement chk_PrimaryAddress;

	// Dropdown Country
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_ucfvAddress2_ddlCountries")
	private WebElement ddl_Country;

	// Dropdown Type
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_ucfvAddress2_ddlAddressTypes")
	private WebElement ddl_AddressType;

	// Textbox Address 1
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_ucfvAddress2_txtAddress1")
	private WebElement txt_Address1;

	// Textbox Address 2
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_ucfvAddress2_txtAddress2")
	private WebElement txt_Address2;

	// Textbox Address 3
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_ucfvAddress2_txtAddress3")
	private WebElement txt_Address3;

	// Textbox City
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_ucfvAddress2_txtCity")
	private WebElement txt_City;

	// Textbox Zipcode
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_ucfvAddress2_ctlZipCode_txtZip")
	private WebElement txt_Zipcode;

	// Textbox Four
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_ucfvAddress2_txtSitePlus4")
	private WebElement txt_SitePlus4;

	// Textbox Notes
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_ucfvAddress2_txtAddressNotes")
	private WebElement txt_AddressNotes;

	// Checkbox Manual Geo Code
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_ucfvAddress2_chkManualGeoCode")
	private WebElement chk_ManualGeoCode;

	// Textbox Latitude
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_ucfvAddress2_txtLatVal")
	private WebElement txt_Latitude;

	// Textbox Longitude
	@FindBy(id = "ctl00_plcMain_tcDetails_tpAddress_rptAddress_ucfvAddress2_txtLongVal")
	private WebElement txt_Longitude;

	/////////////////// Elements at popup Add/Edit Phone //////////////////
	
	//Checkbox Primary
	@FindBy(id="ctl00_plcMain_tcDetails_tpPhone_rptPhone_ucfvPhone_fvPhone1_chkPrimary")
	private WebElement chk_PrimaryPhone;

	// Dropdown Type
	@FindBy(id = "ctl00_plcMain_tcDetails_tpPhone_rptPhone_ucfvPhone_fvPhone1_ddlPhoneTypes")
	private WebElement ddl_PhoneType;

	// Textbox phone number
	@FindBy(id = "ctl00_plcMain_tcDetails_tpPhone_rptPhone_ucfvPhone_fvPhone1_txtPhoneNumber")
	private WebElement txt_PhoneNo;

	// Textbox Extension
	@FindBy(id = "ctl00_plcMain_tcDetails_tpPhone_rptPhone_ucfvPhone_fvPhone1_txtExtension")
	private WebElement txt_PhoneExtension;

	/////////////////// Elements at popup Add/Edit Email //////////////////

	//Checkbox Primary
	@FindBy(id="ctl00_plcMain_tcDetails_tpEmail_rptEmail_ucfvEmail_fvEmail1_chkPrimary")
	private WebElement chk_PrimaryEmail;
	
	// Dropdown Type
	@FindBy(id = "ctl00_plcMain_tcDetails_tpEmail_rptEmail_ucfvEmail_fvEmail1_ddlEmailTypes")
	private WebElement ddl_EmailType;

	// Textbox email
	@FindBy(id = "ctl00_plcMain_tcDetails_tpEmail_rptEmail_ucfvEmail_fvEmail1_txtEmailAddress")
	private WebElement txt_Email;

	/**
	 * Bean shell
	 */
	
	

	public WebElement getBtn_BackToSite() {
		return btn_BackToSite;
	}

	public WebElement getChk_PrimaryEmail() {
		return chk_PrimaryEmail;
	}

	public void setChk_PrimaryEmail(WebElement chk_PrimaryEmail) {
		this.chk_PrimaryEmail = chk_PrimaryEmail;
	}

	public WebElement getChk_PrimaryPhone() {
		return chk_PrimaryPhone;
	}

	public void setChk_PrimaryPhone(WebElement chk_PrimaryPhone) {
		this.chk_PrimaryPhone = chk_PrimaryPhone;
	}

	public WebElement getChk_PrimaryAddress() {
		return chk_PrimaryAddress;
	}

	public void setChk_PrimaryAddress(WebElement chk_PrimaryAddress) {
		this.chk_PrimaryAddress = chk_PrimaryAddress;
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

	public void setBtn_BackToSite(WebElement btn_BackToSite) {
		this.btn_BackToSite = btn_BackToSite;
	}

	public WebElement getBtn_ContactInfo_Add() {
		return btn_ContactInfo_Add;
	}

	public void setBtn_ContactInfo_Add(WebElement btn_ContactInfo_Add) {
		this.btn_ContactInfo_Add = btn_ContactInfo_Add;
	}

	public WebElement getBtn_ContactInfo_Edit() {
		return btn_ContactInfo_Edit;
	}

	public void setBtn_ContactInfo_Edit(WebElement btn_ContactInfo_Edit) {
		this.btn_ContactInfo_Edit = btn_ContactInfo_Edit;
	}

	public WebElement getBtn_ContactInfo_Print() {
		return btn_ContactInfo_Print;
	}

	public void setBtn_ContactInfo_Print(WebElement btn_ContactInfo_Print) {
		this.btn_ContactInfo_Print = btn_ContactInfo_Print;
	}

	public WebElement getBtn_ContactInfo_Save() {
		return btn_ContactInfo_Save;
	}

	public void setBtn_ContactInfo_Save(WebElement btn_ContactInfo_Save) {
		this.btn_ContactInfo_Save = btn_ContactInfo_Save;
	}

	public WebElement getBtn_ContactInfo_Cancel() {
		return btn_ContactInfo_Cancel;
	}

	public void setBtn_ContactInfo_Cancel(WebElement btn_ContactInfo_Cancel) {
		this.btn_ContactInfo_Cancel = btn_ContactInfo_Cancel;
	}

	public WebElement getHpl_ContactInfo_AddAddress() {
		return hpl_ContactInfo_AddAddress;
	}

	public void setHpl_ContactInfo_AddAddress(WebElement hpl_ContactInfo_AddAddress) {
		this.hpl_ContactInfo_AddAddress = hpl_ContactInfo_AddAddress;
	}

	public WebElement getHpl_ContactInfo_AddPhone() {
		return hpl_ContactInfo_AddPhone;
	}

	public void setHpl_ContactInfo_AddPhone(WebElement hpl_ContactInfo_AddPhone) {
		this.hpl_ContactInfo_AddPhone = hpl_ContactInfo_AddPhone;
	}

	public WebElement getHpl_ContactInfo_AddMail() {
		return hpl_ContactInfo_AddMail;
	}

	public void setHpl_ContactInfo_AddMail(WebElement hpl_ContactInfo_AddMail) {
		this.hpl_ContactInfo_AddMail = hpl_ContactInfo_AddMail;
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

	public WebElement getBtn_VerifyAddress() {
		return btn_VerifyAddress;
	}

	public void setBtn_VerifyAddress(WebElement btn_VerifyAddress) {
		this.btn_VerifyAddress = btn_VerifyAddress;
	}

	public WebElement getBtn_VerifyZipCode() {
		return btn_VerifyZipCode;
	}

	public void setBtn_VerifyZipCode(WebElement btn_VerifyZipCode) {
		this.btn_VerifyZipCode = btn_VerifyZipCode;
	}

	public WebElement getBtn_SavePhone() {
		return btn_SavePhone;
	}

	public void setBtn_SavePhone(WebElement btn_SavePhone) {
		this.btn_SavePhone = btn_SavePhone;
	}

	public WebElement getBtn_CancelUpdatePhone() {
		return btn_CancelUpdatePhone;
	}

	public void setBtn_CancelUpdatePhone(WebElement btn_CancelUpdatePhone) {
		this.btn_CancelUpdatePhone = btn_CancelUpdatePhone;
	}

	public WebElement getBtn_SaveMail() {
		return btn_SaveMail;
	}

	public void setBtn_SaveMail(WebElement btn_SaveMail) {
		this.btn_SaveMail = btn_SaveMail;
	}

	public WebElement getBtn_CancelUpdateMail() {
		return btn_CancelUpdateMail;
	}

	public void setBtn_CancelUpdateMail(WebElement btn_CancelUpdateMail) {
		this.btn_CancelUpdateMail = btn_CancelUpdateMail;
	}

	public WebElement getDdl_Salutation() {
		return ddl_Salutation;
	}

	public void setDdl_Salutation(WebElement ddl_Salutation) {
		this.ddl_Salutation = ddl_Salutation;
	}

	public WebElement getTxt_FirstName() {
		return txt_FirstName;
	}

	public void setTxt_FirstName(WebElement txt_FirstName) {
		this.txt_FirstName = txt_FirstName;
	}

	public WebElement getTxt_MIName() {
		return txt_MIName;
	}

	public void setTxt_MIName(WebElement txt_MIName) {
		this.txt_MIName = txt_MIName;
	}

	public WebElement getTxt_LastName() {
		return txt_LastName;
	}

	public void setTxt_LastName(WebElement txt_LastName) {
		this.txt_LastName = txt_LastName;
	}

	public WebElement getDdl_Suffix() {
		return ddl_Suffix;
	}

	public void setDdl_Suffix(WebElement ddl_Suffix) {
		this.ddl_Suffix = ddl_Suffix;
	}

	public WebElement getDdl_ContactType() {
		return ddl_ContactType;
	}

	public void setDdl_ContactType(WebElement ddl_ContactType) {
		this.ddl_ContactType = ddl_ContactType;
	}

	public WebElement getTxt_Title() {
		return txt_Title;
	}

	public void setTxt_Title(WebElement txt_Title) {
		this.txt_Title = txt_Title;
	}

	public WebElement getTxt_Comments() {
		return txt_Comments;
	}

	public void setTxt_Comments(WebElement txt_Comments) {
		this.txt_Comments = txt_Comments;
	}

	public WebElement getChk_Primary() {
		return chk_Primary;
	}

	public void setChk_Primary(WebElement chk_Primary) {
		this.chk_Primary = chk_Primary;
	}

	public WebElement getDdl_Country() {
		return ddl_Country;
	}

	public void setDdl_Country(WebElement ddl_Country) {
		this.ddl_Country = ddl_Country;
	}

	public WebElement getDdl_AddressType() {
		return ddl_AddressType;
	}

	public void setDdl_AddressType(WebElement ddl_AddressType) {
		this.ddl_AddressType = ddl_AddressType;
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

	public WebElement getTxt_Zipcode() {
		return txt_Zipcode;
	}

	public void setTxt_Zipcode(WebElement txt_Zipcode) {
		this.txt_Zipcode = txt_Zipcode;
	}

	public WebElement getTxt_SitePlus4() {
		return txt_SitePlus4;
	}

	public void setTxt_SitePlus4(WebElement txt_SitePlus4) {
		this.txt_SitePlus4 = txt_SitePlus4;
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

	public WebElement getTxt_Latitude() {
		return txt_Latitude;
	}

	public void setTxt_Latitude(WebElement txt_Latitude) {
		this.txt_Latitude = txt_Latitude;
	}

	public WebElement getTxt_Longitude() {
		return txt_Longitude;
	}

	public void setTxt_Longitude(WebElement txt_Longitude) {
		this.txt_Longitude = txt_Longitude;
	}

	public WebElement getDdl_PhoneType() {
		return ddl_PhoneType;
	}

	public void setDdl_PhoneType(WebElement ddl_PhoneType) {
		this.ddl_PhoneType = ddl_PhoneType;
	}

	public WebElement getTxt_PhoneNo() {
		return txt_PhoneNo;
	}

	public void setTxt_PhoneNo(WebElement txt_PhoneNo) {
		this.txt_PhoneNo = txt_PhoneNo;
	}

	public WebElement getTxt_PhoneExtension() {
		return txt_PhoneExtension;
	}

	public void setTxt_PhoneExtension(WebElement txt_PhoneExtension) {
		this.txt_PhoneExtension = txt_PhoneExtension;
	}

	public WebElement getDdl_EmailType() {
		return ddl_EmailType;
	}

	public void setDdl_EmailType(WebElement ddl_EmailType) {
		this.ddl_EmailType = ddl_EmailType;
	}

	public WebElement getTxt_Email() {
		return txt_Email;
	}

	public void setTxt_Email(WebElement txt_Email) {
		this.txt_Email = txt_Email;
	}

}
