package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteInfo {
	//Header
	@FindBy(id="ctl00_heading_lblHeading")
	private WebElement lbl_Header;
	
	//Lable team date info
	@FindBy(id="ctl00_body_lblTeamDateInfo")
	private WebElement lbl_TeamDateInfo;
	
	// Buton next
	@FindBy(id = "ctl00_body_btnNext")
	private WebElement btn_Next;

	//Buton Cancel
	@FindBy(id="ctl00_body_btnCancel")
	private WebElement btn_Cancel;
	
	// Textbox SiteName
	@FindBy(id = "ctl00_body_txtSiteName")
	private WebElement txt_Sitename;

	// Dropdown list Site Type
	@FindBy(id = "ctl00_body_ddlSiteTypes")
	private WebElement ddl_SiteType;

	// Dropdown list Address Type
	@FindBy(id = "ctl00_body_ddlAdrTypes")
	private WebElement ddl_AddressType;

	// Address status value
	@FindBy(id="ctl00_body_addressValidationInfo")
	private WebElement val_AddressStatus;
	
	//popup Address Suggestion
	@FindBy(id="ui-dialog-title-scWizAddrSugContainer")
	private WebElement popup_AddressSuggestion;
	
	// buton close Address Sugesstion
	@FindBy(css="span.ui-icon.ui-icon-closethick")
	private WebElement ico_CloseAddressSuggestion;
	
	// Textbox SiteAddress 1
	@FindBy(id = "ctl00_body_txtAddress1")
	private WebElement txt_SiteAddress1;

	// Textbox SiteAddress 2
	@FindBy(id = "ctl00_body_txtAddress2")
	private WebElement txt_SiteAddress2;

	// Textbox SiteAddress 3
	@FindBy(id = "ctl00_body_txtAddress3")
	private WebElement txt_SiteAddress3;

	// Textbox Country
	@FindBy(id = "ctl00_body_txtCountry")
	private WebElement txt_Country;

	// Textbox Zip
	@FindBy(id = "ctl00_body_ctlZipCode_txtZip")
	private WebElement txt_SiteZipCode;

	// Textbox City
	@FindBy(id = "ctl00_body_txtCity")
	private WebElement txt_City;

	// Checkbox manual Geo-Code
	@FindBy(id = "ctl00_body_chkManualGeoCode")
	private WebElement chk_ManualGeoCode;

	// Textbox Latitude
	@FindBy(id = "ctl00_body_txtLatVal")
	private WebElement txt_Latitude;

	// Textbox Longitude
	@FindBy(id = "ctl00_body_txtLongVal")
	private WebElement txt_Longitude;

	// Textbox State
	@FindBy(id = "ctl00_body_txtState")
	private WebElement txt_State;

	// Dropdown Salutation
	@FindBy(id = "ctl00_body_ctlSal")
	private WebElement ddl_Salutation;

	// Textbox FirstName
	@FindBy(id = "ctl00_body_txtContactFirstName")
	private WebElement txt_FirstName;

	// Textbox Mi Name
	@FindBy(id = "ctl00_body_txtContactMiddleName")
	private WebElement txt_MIName;

	// Textbox Last Name
	@FindBy(id = "ctl00_body_txtContactLastName")
	private WebElement txt_LastName;

	// Dropdown Suffix
	@FindBy(id = "ctl00_body_ctlSuff")
	private WebElement ddl_Suffix;

	// Dropdown contact type
	@FindBy(id = "ctl00_body_ddlContactTypes")
	private WebElement ddl_ContactType;

	// Textbox Contact Email
	@FindBy(id = "ctl00_body_txtContactEmail")
	private WebElement txt_ContactMail;

	// Dropdown contact email type
	@FindBy(id = "ctl00_body_ddlContactEmailTypes")
	private WebElement ddl_ContactMailType;

	// text box Site Email
	@FindBy(id = "ctl00_body_txtEntityEmail")
	private WebElement txt_SiteEmail;

	// Dropdown site email type
	@FindBy(id = "ctl00_body_ddlEmailTypes")
	private WebElement ddl_SiteMailType;

	// Textbox Phone
	@FindBy(id = "ctl00_body_ctlContactPhone_tbPhone")
	private WebElement txt_ContactPhone;

	// Textbox Extension (next to textbox Phone)
	@FindBy(id = "ctl00_body_txtExtension")
	private WebElement txt_PhoneExtension;
	
	//Dropdown phone type
	@FindBy(id="ctl00_body_ddlPhoneTypes")
	private WebElement ddl_PhoneType;

	// Textbox Fax
	@FindBy(id = "ctl00_body_ctlFaxControl_tbPhone")
	private WebElement txt_SiteFax;
	
	//Textbox website
	@FindBy(id="ctl00_body_txtWebSite")
	private WebElement txt_WebSite;

	/**
	 * bean shell
	 */

	
	
	public WebElement getDdl_SiteType() {
		return ddl_SiteType;
	}

	
	public WebElement getLbl_Header() {
		return lbl_Header;
	}


	public void setLbl_Header(WebElement lbl_Header) {
		this.lbl_Header = lbl_Header;
	}


	public WebElement getLbl_TeamDateInfo() {
		return lbl_TeamDateInfo;
	}


	public void setLbl_TeamDateInfo(WebElement lbl_TeamDateInfo) {
		this.lbl_TeamDateInfo = lbl_TeamDateInfo;
	}


	public WebElement getVal_AddressStatus() {
		return val_AddressStatus;
	}


	public void setVal_AddressStatus(WebElement val_AddressStatus) {
		this.val_AddressStatus = val_AddressStatus;
	}


	public WebElement getIco_CloseAddressSuggestion() {
		return ico_CloseAddressSuggestion;
	}


	public void setIco_CloseAddressSuggestion(WebElement ico_CloseAddressSuggestion) {
		this.ico_CloseAddressSuggestion = ico_CloseAddressSuggestion;
	}


	public WebElement getPopup_AddressSuggestion() {
		return popup_AddressSuggestion;
	}


	public void setPopup_AddressSuggestion(WebElement popup_AddressSuggestion) {
		this.popup_AddressSuggestion = popup_AddressSuggestion;
	}


	public WebElement getBtn_Cancel() {
		return btn_Cancel;
	}


	public void setBtn_Cancel(WebElement btn_Cancel) {
		this.btn_Cancel = btn_Cancel;
	}


	public WebElement getDdl_ContactMailType() {
		return ddl_ContactMailType;
	}


	public void setDdl_ContactMailType(WebElement ddl_ContactMailType) {
		this.ddl_ContactMailType = ddl_ContactMailType;
	}


	public WebElement getDdl_SiteMailType() {
		return ddl_SiteMailType;
	}


	public void setDdl_SiteMailType(WebElement ddl_SiteMailType) {
		this.ddl_SiteMailType = ddl_SiteMailType;
	}


	public WebElement getTxt_SiteEmail() {
		return txt_SiteEmail;
	}

	public void setTxt_SiteEmail(WebElement txt_SiteEmail) {
		this.txt_SiteEmail = txt_SiteEmail;
	}

	

	public WebElement getDdl_PhoneType() {
		return ddl_PhoneType;
	}

	public void setDdl_PhoneType(WebElement ddl_PhoneType) {
		this.ddl_PhoneType = ddl_PhoneType;
	}

	public WebElement getTxt_WebSite() {
		return txt_WebSite;
	}

	public void setTxt_WebSite(WebElement txt_WebSite) {
		this.txt_WebSite = txt_WebSite;
	}

	public WebElement getDdl_Salutation() {
		return ddl_Salutation;
	}

	public void setDdl_Salutation(WebElement ddl_Salutation) {
		this.ddl_Salutation = ddl_Salutation;
	}

	public WebElement getDdl_Suffix() {
		return ddl_Suffix;
	}

	public void setDdl_Suffix(WebElement ddl_Suffix) {
		this.ddl_Suffix = ddl_Suffix;
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

	public WebElement getTxt_SiteAddress2() {
		return txt_SiteAddress2;
	}

	public void setTxt_SiteAddress2(WebElement txt_SiteAddress2) {
		this.txt_SiteAddress2 = txt_SiteAddress2;
	}

	public WebElement getTxt_SiteAddress3() {
		return txt_SiteAddress3;
	}

	public void setTxt_SiteAddress3(WebElement txt_SiteAddress3) {
		this.txt_SiteAddress3 = txt_SiteAddress3;
	}

	public WebElement getDdl_AddressType() {
		return ddl_AddressType;
	}

	public void setDdl_AddressType(WebElement ddl_AddressType) {
		this.ddl_AddressType = ddl_AddressType;
	}

	public void setDdl_SiteType(WebElement ddl_SiteType) {
		this.ddl_SiteType = ddl_SiteType;
	}

	public WebElement getTxt_PhoneExtension() {
		return txt_PhoneExtension;
	}

	public void setTxt_PhoneExtension(WebElement txt_PhoneExtension) {
		this.txt_PhoneExtension = txt_PhoneExtension;
	}

	public WebElement getTxt_Country() {
		return txt_Country;
	}

	public void setTxt_Country(WebElement txt_Country) {
		this.txt_Country = txt_Country;
	}

	public WebElement getTxt_Sitename() {
		return txt_Sitename;
	}

	public void setTxt_Sitename(WebElement txt_Sitename) {
		this.txt_Sitename = txt_Sitename;
	}

	public WebElement getTxt_SiteAddress1() {
		return txt_SiteAddress1;
	}

	public void setTxt_SiteAddress1(WebElement txt_SiteAddress1) {
		this.txt_SiteAddress1 = txt_SiteAddress1;
	}

	public WebElement getTxt_SiteZipCode() {
		return txt_SiteZipCode;
	}

	public void setTxt_SiteZipCode(WebElement txt_SiteZipCode) {
		this.txt_SiteZipCode = txt_SiteZipCode;
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

	public WebElement getDdl_ContactType() {
		return ddl_ContactType;
	}

	public void setDdl_ContactType(WebElement ddl_ContactType) {
		this.ddl_ContactType = ddl_ContactType;
	}

	public WebElement getTxt_ContactMail() {
		return txt_ContactMail;
	}

	public void setTxt_ContactMail(WebElement txt_ContactMail) {
		this.txt_ContactMail = txt_ContactMail;
	}

	public WebElement getTxt_ContactPhone() {
		return txt_ContactPhone;
	}

	public void setTxt_ContactPhone(WebElement txt_ContactPhone) {
		this.txt_ContactPhone = txt_ContactPhone;
	}

	public WebElement getTxt_SiteFax() {
		return txt_SiteFax;
	}

	public void setTxt_SiteFax(WebElement txt_SiteFax) {
		this.txt_SiteFax = txt_SiteFax;
	}

	public WebElement getBtn_Next() {
		return btn_Next;
	}

	public void setBtn_Next(WebElement btn_Next) {
		this.btn_Next = btn_Next;
	}
}
