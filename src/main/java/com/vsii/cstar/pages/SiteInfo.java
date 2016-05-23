package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteInfo {
	//Buton next
	@FindBy(id = "ctl00_body_btnNext")
	private WebElement btn_Next;

	//Textbox SiteName
	@FindBy(id="ctl00_body_txtSiteName")
	private WebElement txt_Sitename;
	
	//Textbox SiteAddress 1
	@FindBy(id="ctl00_body_txtAddress1")
	private WebElement txt_SiteAddress;
	
	//Textbox Country
	@FindBy(id="ctl00_body_txtCountry")
	private WebElement txt_Country;

	//Textbox Zip
	@FindBy(id="ctl00_body_ctlZipCode_txtZip")
	private WebElement txt_SiteZipCode;
	
	//Textbox City
	@FindBy(id="ctl00_body_txtCity")
	private WebElement txt_City;
	
	//Textbox State
	@FindBy(id="ctl00_body_txtState")
	private WebElement txt_State;
	
	//Textbox FirstName
	@FindBy(id="ctl00_body_txtContactFirstName")
	private WebElement txt_FirstName;
	
	//Textbox Mi Name
	@FindBy(id="ctl00_body_txtContactMiddleName")
	private WebElement txt_MIName;
	
	//Textbox Last Name
	@FindBy(id="ctl00_body_txtContactLastName")
	private WebElement txt_LastName;
	
	//Dropdown contact type
	@FindBy(id="ctl00_body_ddlContactTypes")
	private WebElement ddl_ContactType;
	
	//Textbox Email
	@FindBy(id="ctl00_body_txtContactEmail")
	private WebElement txt_ContactMail;
	
	//Textbox Phone
	@FindBy(id="ctl00_body_ctlContactPhone_tbPhone")
	private WebElement txt_ContactPhone;
	
	//Textbox Extension (next to textbox Phone)
	@FindBy(id="ctl00_body_txtExtension")
	private WebElement txt_PhoneExtension;
	
	//Textbox Fax
	@FindBy(id="ctl00_body_ctlFaxControl_tbPhone")
	private WebElement txt_SiteFax;
	
	
	
	

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

	public WebElement getTxt_SiteAddress() {
		return txt_SiteAddress;
	}

	public void setTxt_SiteAddress(WebElement txt_SiteAddress) {
		this.txt_SiteAddress = txt_SiteAddress;
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
