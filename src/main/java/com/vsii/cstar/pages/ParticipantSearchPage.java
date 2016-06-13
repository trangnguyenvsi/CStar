package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParticipantSearchPage {
	// Textbox Telephone Number
	@FindBy(id = "ctl00_body_ucParticipantSearch_txtSearchTelephone")
	private WebElement txt_TelephoneNumber;

	// Buton Search by Phone
	@FindBy(name = "ctl00$body$ucParticipantSearch$btnPhoneSearch")
	private WebElement btn_PhoneSearch;

	// Textbox Zip Code
	@FindBy(id = "ctl00_body_ucParticipantSearch_txtZip")
	private WebElement txt_SearchZip;

	// Buton Search by Zip
	@FindBy(name = "ctl00$body$ucParticipantSearch$btnZipSearch")
	private WebElement btn_ZipSearch;

	// Textbox Email
	@FindBy(id = "ctl00_body_ucParticipantSearch_txtEmail")
	private WebElement txt_Email;

	// Buton Search by Email
	@FindBy(name = "ctl00$body$ucParticipantSearch$btnEmailSearch")
	private WebElement btn_EmailSearch;

	// Buton Clear
	@FindBy(name = "ctl00$body$ucParticipantSearch$btnClear")
	private WebElement btn_Clear;

	// Buton Add New
	@FindBy(name = "ctl00$body$ucParticipantSearch$btnAddNew")
	private WebElement btn_AddNew;

	// Linktext Advanced Search
	@FindBy(id = "ctl00_body_ucParticipantSearch_lbSearchType")
	private WebElement lnk_AdvancedSearch;

	// Linktext Name & DOB Search
	@FindBy(id = "ctl00_body_ucParticipantSearch_lbNameDOBSearch")
	private WebElement lnk_NameDOBSearch;

	// Linktext Medicare ID Search
	@FindBy(id = "ctl00_body_ucParticipantSearch_lbMedicareIDSearch")
	private WebElement lnk_MedicareIDSearch;

	/**
	 * Bean shell
	 */
	
	public WebElement getTxt_TelephoneNumber() {
		return txt_TelephoneNumber;
	}

	public void setTxt_TelephoneNumber(WebElement txt_TelephoneNumber) {
		this.txt_TelephoneNumber = txt_TelephoneNumber;
	}

	public WebElement getBtn_PhoneSearch() {
		return btn_PhoneSearch;
	}

	public void setBtn_PhoneSearch(WebElement btn_PhoneSearch) {
		this.btn_PhoneSearch = btn_PhoneSearch;
	}

	public WebElement getTxt_SearchZip() {
		return txt_SearchZip;
	}

	public void setTxt_SearchZip(WebElement txt_SearchZip) {
		this.txt_SearchZip = txt_SearchZip;
	}

	public WebElement getBtn_ZipSearch() {
		return btn_ZipSearch;
	}

	public void setBtn_ZipSearch(WebElement btn_ZipSearch) {
		this.btn_ZipSearch = btn_ZipSearch;
	}

	public WebElement getTxt_Email() {
		return txt_Email;
	}

	public void setTxt_Email(WebElement txt_Email) {
		this.txt_Email = txt_Email;
	}

	public WebElement getBtn_EmailSearch() {
		return btn_EmailSearch;
	}

	public void setBtn_EmailSearch(WebElement btn_EmailSearch) {
		this.btn_EmailSearch = btn_EmailSearch;
	}

	public WebElement getBtn_Clear() {
		return btn_Clear;
	}

	public void setBtn_Clear(WebElement btn_Clear) {
		this.btn_Clear = btn_Clear;
	}

	public WebElement getBtn_AddNew() {
		return btn_AddNew;
	}

	public void setBtn_AddNew(WebElement btn_AddNew) {
		this.btn_AddNew = btn_AddNew;
	}

	public WebElement getLnk_AdvancedSearch() {
		return lnk_AdvancedSearch;
	}

	public void setLnk_AdvancedSearch(WebElement lnk_AdvancedSearch) {
		this.lnk_AdvancedSearch = lnk_AdvancedSearch;
	}

	public WebElement getLnk_NameDOBSearch() {
		return lnk_NameDOBSearch;
	}

	public void setLnk_NameDOBSearch(WebElement lnk_NameDOBSearch) {
		this.lnk_NameDOBSearch = lnk_NameDOBSearch;
	}

	public WebElement getLnk_MedicareIDSearch() {
		return lnk_MedicareIDSearch;
	}

	public void setLnk_MedicareIDSearch(WebElement lnk_MedicareIDSearch) {
		this.lnk_MedicareIDSearch = lnk_MedicareIDSearch;
	}

	
}
