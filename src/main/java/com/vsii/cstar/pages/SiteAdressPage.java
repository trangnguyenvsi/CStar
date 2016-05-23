package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteAdressPage {
	////////// Tab Location/////////////////

	// Tab Address
	@FindBy(id = "__tab_ctl00_plcMain_tbcSiteAddress_tpAddress")
	private WebElement tab_Address;

	// Tab Phone
	@FindBy(id = "__tab_ctl00_plcMain_tbcSiteAddress_tpPhone")
	private WebElement tab_Phone;

	// Tab Email
	@FindBy(id = "__tab_ctl00_plcMain_tbcSiteAddress_tpEmail")
	private WebElement tab_Email;

	// Tab Site Information
	@FindBy(id = "__tab_ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo")
	private WebElement tab_SiteInfo;

	// Tab Restriction
	@FindBy(id = "__tab_ctl00_plcMain_tbcSiteAddress_tbpnlRestrictions")
	private WebElement tab_Restriction;

	// Tab Notes
	@FindBy(id = "__tab_ctl00_plcMain_tbcSiteAddress_tabPnlNotes")
	private WebElement tab_Notes;

	// Tab Past Events
	@FindBy(id = "__tab_ctl00_plcMain_tbcSiteAddress_TabPanel8")
	private WebElement tab_PastEvents;

	// Tab History
	@FindBy(id = "__tab_ctl00_plcMain_tbcSiteAddress_TabPanel9")
	private WebElement tab_History;

	///////////// Element in Address tab/////////////////

	// Link Add Address
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_rAddress_ctl00_lbAddAddress")
	private WebElement lnk_AddAddress;

	///////////// Element in Add/Edit Address popup //////////////

	// Checkbox Primary
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_ucfvAddress2_chkPrimary")
	private WebElement chk_Primary;

	// Dropdown Country
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_ucfvAddress2_ddlCountries")
	private WebElement ddl_Country;

	// Dropdown Type (address)
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_ucfvAddress2_ddlAddressTypes")
	private WebElement ddl_AddressType;

	// Textbox Address line 1
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_ucfvAddress2_txtAddress1")
	private WebElement txt_Address1;

	// Textbox Address line 2
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_ucfvAddress2_txtAddress2")
	private WebElement txt_Address2;

	// Textbox Address line 3
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_ucfvAddress2_txtAddress3")
	private WebElement txt_Address3;

	// Textbox City
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_ucfvAddress2_txtCity")
	private WebElement txt_City;

	// Textbox Zipcode
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_ucfvAddress2_ctlZipCode_txtZip")
	private WebElement txt_ZipCode;

	// Textbox Four
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_ucfvAddress2_txtSitePlus4")
	private WebElement txt_Four;

	// Textbox notes
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_ucfvAddress2_txtAddressNotes")
	private WebElement txt_Notes;

	// Checkbox Manual Geo-Code
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_ucfvAddress2_chkManualGeoCode")
	private WebElement chk_ManualGeoCode;

	// Checkbox Manual Latitude
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_ucfvAddress2_txtLatVal")
	private WebElement txt_Latitude;

	// Checkbox Manual Longitude
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_ucfvAddress2_txtLongVal")
	private WebElement txt_Longitude;

	// Buton Verify Address
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_ucfvAddress2_imbVerifyAddress")
	private WebElement btn_VerifyAddress;

	// Buton Verify ZipCode
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_ucfvAddress2_ctlZipCode_ibVerifyZip")
	private WebElement btn_VerifyZipCode;

	// Buton Save
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_btnSave")
	private WebElement btn_Adr_Save;

	// Buton Cancel
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_btnCancel")
	private WebElement btn_Adr_Cancel;

	///////////// Element in Site Information tab/////////////////
	// Textbox Site name
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo_txtSiteInfoSiteName")
	private WebElement txt_SiteName;

	// Textbox Website
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo_txtWebSiteVal")
	private WebElement txt_Website;

	// Dropdown Site type
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo_ddlSiteType")
	private WebElement ddl_SiteType;

	// Dropdown Denomination
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo_ddlDenomination")
	private WebElement ddl_Denomination;

	// Text box No. of Members
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo_txtNoOfMembers")
	private WebElement txt_NoOfMembers;

	// Text box dimession lenght
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo_txLength")
	private WebElement txt_DimensionLenght;

	// Text box dimession Breadth
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo_txtBreadth")
	private WebElement txt_DimensionBreadth;

	// Text box Square Feet
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo_txtSquareFeet")
	private WebElement txt_SquareFeed;

	// buton Save
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo_btnSiteInfoSave")
	private WebElement btn_SiteInfo_Save;

	// Buton Cancel
	@FindBy(id = "ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo_btnSiteInfoCancel")
	private WebElement btn_SiteInfo_Cancel;

	

	/**
	 * Bean shell
	 */

	public WebElement getTab_Address() {
		return tab_Address;
	}

	public WebElement getBtn_SiteInfo_Save() {
		return btn_SiteInfo_Save;
	}

	public void setBtn_SiteInfo_Save(WebElement btn_SiteInfo_Save) {
		this.btn_SiteInfo_Save = btn_SiteInfo_Save;
	}

	public WebElement getBtn_SiteInfo_Cancel() {
		return btn_SiteInfo_Cancel;
	}

	public void setBtn_SiteInfo_Cancel(WebElement btn_SiteInfo_Cancel) {
		this.btn_SiteInfo_Cancel = btn_SiteInfo_Cancel;
	}

	public WebElement getChk_Primary() {
		return chk_Primary;
	}

	public void setChk_Primary(WebElement chk_Primary) {
		this.chk_Primary = chk_Primary;
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

	public WebElement getBtn_Adr_Save() {
		return btn_Adr_Save;
	}

	public void setBtn_Adr_Save(WebElement btn_Adr_Save) {
		this.btn_Adr_Save = btn_Adr_Save;
	}

	public WebElement getBtn_Adr_Cancel() {
		return btn_Adr_Cancel;
	}

	public void setBtn_Adr_Cancel(WebElement btn_Adr_Cancel) {
		this.btn_Adr_Cancel = btn_Adr_Cancel;
	}

	public WebElement getDdl_AddressType() {
		return ddl_AddressType;
	}

	public void setDdl_AddressType(WebElement ddl_AddressType) {
		this.ddl_AddressType = ddl_AddressType;
	}

	public WebElement getDdl_Country() {
		return ddl_Country;
	}

	public void setDdl_Country(WebElement ddl_Country) {
		this.ddl_Country = ddl_Country;
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

	public WebElement getTxt_ZipCode() {
		return txt_ZipCode;
	}

	public void setTxt_ZipCode(WebElement txt_ZipCode) {
		this.txt_ZipCode = txt_ZipCode;
	}

	public WebElement getTxt_Four() {
		return txt_Four;
	}

	public void setTxt_Four(WebElement txt_Four) {
		this.txt_Four = txt_Four;
	}

	public WebElement getTxt_Notes() {
		return txt_Notes;
	}

	public void setTxt_Notes(WebElement txt_Notes) {
		this.txt_Notes = txt_Notes;
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

	public WebElement getTxt_SiteName() {
		return txt_SiteName;
	}

	public void setTxt_SiteName(WebElement txt_SiteName) {
		this.txt_SiteName = txt_SiteName;
	}

	public WebElement getTxt_Website() {
		return txt_Website;
	}

	public void setTxt_Website(WebElement txt_Website) {
		this.txt_Website = txt_Website;
	}

	public WebElement getDdl_SiteType() {
		return ddl_SiteType;
	}

	public void setDdl_SiteType(WebElement ddl_SiteType) {
		this.ddl_SiteType = ddl_SiteType;
	}

	public WebElement getDdl_Denomination() {
		return ddl_Denomination;
	}

	public void setDdl_Denomination(WebElement ddl_Denomination) {
		this.ddl_Denomination = ddl_Denomination;
	}

	public WebElement getTxt_NoOfMembers() {
		return txt_NoOfMembers;
	}

	public void setTxt_NoOfMembers(WebElement txt_NoOfMembers) {
		this.txt_NoOfMembers = txt_NoOfMembers;
	}

	public WebElement getTxt_DimensionLenght() {
		return txt_DimensionLenght;
	}

	public void setTxt_DimensionLenght(WebElement txt_DimensionLenght) {
		this.txt_DimensionLenght = txt_DimensionLenght;
	}

	public WebElement getTxt_DimensionBreadth() {
		return txt_DimensionBreadth;
	}

	public void setTxt_DimensionBreadth(WebElement txt_DimensionBreadth) {
		this.txt_DimensionBreadth = txt_DimensionBreadth;
	}

	public WebElement getTxt_SquareFeed() {
		return txt_SquareFeed;
	}

	public void setTxt_SquareFeed(WebElement txt_SquareFeed) {
		this.txt_SquareFeed = txt_SquareFeed;
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

	public WebElement getTab_SiteInfo() {
		return tab_SiteInfo;
	}

	public void setTab_SiteInfo(WebElement tab_SiteInfo) {
		this.tab_SiteInfo = tab_SiteInfo;
	}

	public WebElement getTab_Restriction() {
		return tab_Restriction;
	}

	public void setTab_Restriction(WebElement tab_Restriction) {
		this.tab_Restriction = tab_Restriction;
	}

	public WebElement getTab_Notes() {
		return tab_Notes;
	}

	public void setTab_Notes(WebElement tab_Notes) {
		this.tab_Notes = tab_Notes;
	}

	public WebElement getTab_PastEvents() {
		return tab_PastEvents;
	}

	public void setTab_PastEvents(WebElement tab_PastEvents) {
		this.tab_PastEvents = tab_PastEvents;
	}

	public WebElement getTab_History() {
		return tab_History;
	}

	public void setTab_History(WebElement tab_History) {
		this.tab_History = tab_History;
	}

	public WebElement getLnk_AddAddress() {
		return lnk_AddAddress;
	}

	public void setLnk_AddAddress(WebElement lnk_AddAddress) {
		this.lnk_AddAddress = lnk_AddAddress;
	}

}
