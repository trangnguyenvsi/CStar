package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddParticipantPage {
	// Textbox First Name
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtFirst")
	private WebElement txt_FirstName;

	// Textbox MI Name
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtMI")
	private WebElement txt_MIName;

	// Textbox Last Name
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtLast")
	private WebElement txt_LastName;

	// Textbox NickName
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtNickName")
	private WebElement txt_NickName;

	// Label DOB
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_lblDob")
	private WebElement lbl_DOB;

	// Textbox DOB
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtDOB_dateInput")
	private WebElement txt_DOB;

	// Checkbox Refused
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_chkRefused")
	private WebElement chk_Refused;

	// Checkbox Lead
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_chkFCL")
	private WebElement chk_Lead;

	// Textbox DNIS
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ctlDNIS_cbDnis_Input")
	private WebElement txt_DNIS;

	// Label DNIS
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_lblParticipantDNIS")
	private WebElement lbl_DNIS;

	// Textbox Prioriry Code
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtParticipantSource")
	private WebElement txt_PrioriryCode;

	// Textbox AddressLine1
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtAddressLine1")
	private WebElement txt_AddressLine1;

	// Textbox AddressLine2
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtAddressLine2")
	private WebElement txt_AddressLine2;

	// Textbox AddressLine3
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtAddressLine3")
	private WebElement txt_AddressLine3;

	// Textbox City
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtCity")
	private WebElement txt_City;

	// Textbox State
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtState")
	private WebElement txt_State;

	// Textbox Zip
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ctlZipCode_txtZip")
	private WebElement txt_Zip;

	// Button Verify Zipcode
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ctlZipCode_ibVerifyZip")
	private WebElement btn_VerifyZipcode;

	// Textbox AddressNotes
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtAddressNotes")
	private WebElement txt_AddressNotes;

	// Textbox PhoneNumber
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtPhoneNumber")
	private WebElement txt_PhoneNumber;

	// Textbox Extension
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtExtension")
	private WebElement txt_PhoneExtension;

	// Textbox EmailAddress
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtEmailAddress")
	private WebElement txt_EmailAddress;

	// Buton Save
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_btnSubmitSave_btnSubmit")
	private WebElement btn_Save;

	// Buton Cancel
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_btnCancel")
	private WebElement btn_Cancel;

	// Textarea Participant Notes
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtNotes")
	private WebElement txt_ParticipantNotes;

	// Linktext select DNIS
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ctlDNIS_cbDnis_Arrow")
	private WebElement lnk_selectDNIS;

	// Dropdown Salutations
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ddlSalutations")
	private WebElement ddl_Salutations;

	// Dropdown Suf
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ddlSuf")
	private WebElement ddl_Suf;

	// Dropdown Gender
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ddlGender")
	private WebElement ddl_Gender;

	// Dropdown Vip
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ddlVip")
	private WebElement ddl_Vip;

	// Dropdown Countries
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ddlCountries")
	private WebElement ddl_Countries;

	// Dropdown AddressTypes
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ddlAddressTypes")
	private WebElement ddl_AddressTypes;

	// Dropdown CountryCodes
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ddlCountryCodes")
	private WebElement ddl_CountryCodes;

	// Dropdown PhoneTypes
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ddlPhoneTypes")
	private WebElement ddl_PhoneTypes;

	// Dropdown EmailTypes
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_ddlEmailTypes")
	private WebElement ddl_EmailTypes;

	// Icon DOB Calendar
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtDOB_CalendarPopupButton")
	private WebElement ico_Calendar;

	// Calendar title
	@FindBy(id = "ctl00_body_ucFvParticipant_fvParticipant1_txtDOB_calendar_Title")
	private WebElement cal_Title;

	// Calendar previous multiple year
	@FindBy(xpath = "//td[@id='rcMView_PrevY']/a")
	private WebElement cal_PreviourMultipleYear;

	// Calendar next multiple year
	@FindBy(xpath = "//td[@id='rcMView_NextY']/a")
	private WebElement cal_NextMultipleYear;

	// Confirm selected month and year
	@FindBy(id = "rcMView_OK")
	private WebElement btn_SubmitMonthYear;
	
	//Get age value
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_lblAgeValue")
	private WebElement val_Age;
	
	//Save for edited information
	@FindBy(id="ctl00_body_ucFvParticipant_fvParticipant1_btnSave")
	private WebElement btn_SaveEditedInformation;
	
	

	//// table[@id='ctl00_body_ucFvParticipant_fvParticipant1_txtDOB_calendar_FastNavPopup']/tbody/tr/td/a[contains(text(),'May')]
	//// table[@id='ctl00_body_ucFvParticipant_fvParticipant1_txtDOB_calendar_FastNavPopup']/tbody/tr/td/a[contains(text(),'2015')]

	/**
	 * Parameter to store value
	 */
	private String salutation;
	private String firstName;
	private String MIName;
	private String lastName;
	private String suffix;
	private String nickName;
	private String DOB;
	private String age;
	private String gender;
	private String lead;
	private String DNIS;
	private String priorityCode;
	private String VIP;
	private String country;
	private String addressType;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String zipCode;
	private String addressNote;
	private String participantNote;
	private String countryCode;
	private String phoneType;
	private String phoneNumber;
	private String phoneExtension;
	private String emailType;
	private String email;
	
	/**
	 * Bean Shell
	 */
	// TODO BEAN SHELL START FROM HERE
	
	
	public WebElement getTxt_FirstName() {
		return txt_FirstName;
	}
	public WebElement getBtn_SaveEditedInformation() {
		return btn_SaveEditedInformation;
	}
	public void setBtn_SaveEditedInformation(WebElement btn_SaveEditedInformation) {
		this.btn_SaveEditedInformation = btn_SaveEditedInformation;
	}
	public WebElement getVal_Age() {
		return val_Age;
	}
	public void setVal_Age(WebElement val_Age) {
		this.val_Age = val_Age;
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
	public WebElement getTxt_NickName() {
		return txt_NickName;
	}
	public void setTxt_NickName(WebElement txt_NickName) {
		this.txt_NickName = txt_NickName;
	}
	public WebElement getLbl_DOB() {
		return lbl_DOB;
	}
	public void setLbl_DOB(WebElement lbl_DOB) {
		this.lbl_DOB = lbl_DOB;
	}
	public WebElement getTxt_DOB() {
		return txt_DOB;
	}
	public void setTxt_DOB(WebElement txt_DOB) {
		this.txt_DOB = txt_DOB;
	}
	public WebElement getChk_Refused() {
		return chk_Refused;
	}
	public void setChk_Refused(WebElement chk_Refused) {
		this.chk_Refused = chk_Refused;
	}
	public WebElement getChk_Lead() {
		return chk_Lead;
	}
	public void setChk_Lead(WebElement chk_Lead) {
		this.chk_Lead = chk_Lead;
	}
	public WebElement getTxt_DNIS() {
		return txt_DNIS;
	}
	public void setTxt_DNIS(WebElement txt_DNIS) {
		this.txt_DNIS = txt_DNIS;
	}
	public WebElement getLbl_DNIS() {
		return lbl_DNIS;
	}
	public void setLbl_DNIS(WebElement lbl_DNIS) {
		this.lbl_DNIS = lbl_DNIS;
	}
	public WebElement getTxt_PrioriryCode() {
		return txt_PrioriryCode;
	}
	public void setTxt_PrioriryCode(WebElement txt_PrioriryCode) {
		this.txt_PrioriryCode = txt_PrioriryCode;
	}
	public WebElement getTxt_AddressLine1() {
		return txt_AddressLine1;
	}
	public void setTxt_AddressLine1(WebElement txt_AddressLine1) {
		this.txt_AddressLine1 = txt_AddressLine1;
	}
	public WebElement getTxt_AddressLine2() {
		return txt_AddressLine2;
	}
	public void setTxt_AddressLine2(WebElement txt_AddressLine2) {
		this.txt_AddressLine2 = txt_AddressLine2;
	}
	public WebElement getTxt_AddressLine3() {
		return txt_AddressLine3;
	}
	public void setTxt_AddressLine3(WebElement txt_AddressLine3) {
		this.txt_AddressLine3 = txt_AddressLine3;
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
	public WebElement getBtn_VerifyZipcode() {
		return btn_VerifyZipcode;
	}
	public void setBtn_VerifyZipcode(WebElement btn_VerifyZipcode) {
		this.btn_VerifyZipcode = btn_VerifyZipcode;
	}
	public WebElement getTxt_AddressNotes() {
		return txt_AddressNotes;
	}
	public void setTxt_AddressNotes(WebElement txt_AddressNotes) {
		this.txt_AddressNotes = txt_AddressNotes;
	}
	public WebElement getTxt_PhoneNumber() {
		return txt_PhoneNumber;
	}
	public void setTxt_PhoneNumber(WebElement txt_PhoneNumber) {
		this.txt_PhoneNumber = txt_PhoneNumber;
	}
	public WebElement getTxt_PhoneExtension() {
		return txt_PhoneExtension;
	}
	public void setTxt_PhoneExtension(WebElement txt_PhoneExtension) {
		this.txt_PhoneExtension = txt_PhoneExtension;
	}
	public WebElement getTxt_EmailAddress() {
		return txt_EmailAddress;
	}
	public void setTxt_EmailAddress(WebElement txt_EmailAddress) {
		this.txt_EmailAddress = txt_EmailAddress;
	}
	public WebElement getBtn_Save() {
		return btn_Save;
	}
	public void setBtn_Save(WebElement btn_Save) {
		this.btn_Save = btn_Save;
	}
	public WebElement getBtn_Cancel() {
		return btn_Cancel;
	}
	public void setBtn_Cancel(WebElement btn_Cancel) {
		this.btn_Cancel = btn_Cancel;
	}
	public WebElement getTxt_ParticipantNotes() {
		return txt_ParticipantNotes;
	}
	public void setTxt_ParticipantNotes(WebElement txt_ParticipantNotes) {
		this.txt_ParticipantNotes = txt_ParticipantNotes;
	}
	public WebElement getLnk_selectDNIS() {
		return lnk_selectDNIS;
	}
	public void setLnk_selectDNIS(WebElement lnk_selectDNIS) {
		this.lnk_selectDNIS = lnk_selectDNIS;
	}
	public WebElement getDdl_Salutations() {
		return ddl_Salutations;
	}
	public void setDdl_Salutations(WebElement ddl_Salutations) {
		this.ddl_Salutations = ddl_Salutations;
	}
	public WebElement getDdl_Suf() {
		return ddl_Suf;
	}
	public void setDdl_Suf(WebElement ddl_Suf) {
		this.ddl_Suf = ddl_Suf;
	}
	public WebElement getDdl_Gender() {
		return ddl_Gender;
	}
	public void setDdl_Gender(WebElement ddl_Gender) {
		this.ddl_Gender = ddl_Gender;
	}
	public WebElement getDdl_Vip() {
		return ddl_Vip;
	}
	public void setDdl_Vip(WebElement ddl_Vip) {
		this.ddl_Vip = ddl_Vip;
	}
	public WebElement getDdl_Countries() {
		return ddl_Countries;
	}
	public void setDdl_Countries(WebElement ddl_Countries) {
		this.ddl_Countries = ddl_Countries;
	}
	public WebElement getDdl_AddressTypes() {
		return ddl_AddressTypes;
	}
	public void setDdl_AddressTypes(WebElement ddl_AddressTypes) {
		this.ddl_AddressTypes = ddl_AddressTypes;
	}
	public WebElement getDdl_CountryCodes() {
		return ddl_CountryCodes;
	}
	public void setDdl_CountryCodes(WebElement ddl_CountryCodes) {
		this.ddl_CountryCodes = ddl_CountryCodes;
	}
	public WebElement getDdl_PhoneTypes() {
		return ddl_PhoneTypes;
	}
	public void setDdl_PhoneTypes(WebElement ddl_PhoneTypes) {
		this.ddl_PhoneTypes = ddl_PhoneTypes;
	}
	public WebElement getDdl_EmailTypes() {
		return ddl_EmailTypes;
	}
	public void setDdl_EmailTypes(WebElement ddl_EmailTypes) {
		this.ddl_EmailTypes = ddl_EmailTypes;
	}
	public WebElement getIco_Calendar() {
		return ico_Calendar;
	}
	public void setIco_Calendar(WebElement ico_Calendar) {
		this.ico_Calendar = ico_Calendar;
	}
	public WebElement getCal_Title() {
		return cal_Title;
	}
	public void setCal_Title(WebElement cal_Title) {
		this.cal_Title = cal_Title;
	}
	public WebElement getCal_PreviourMultipleYear() {
		return cal_PreviourMultipleYear;
	}
	public void setCal_PreviourMultipleYear(WebElement cal_PreviourMultipleYear) {
		this.cal_PreviourMultipleYear = cal_PreviourMultipleYear;
	}
	public WebElement getCal_NextMultipleYear() {
		return cal_NextMultipleYear;
	}
	public void setCal_NextMultipleYear(WebElement cal_NextMultipleYear) {
		this.cal_NextMultipleYear = cal_NextMultipleYear;
	}
	public WebElement getBtn_SubmitMonthYear() {
		return btn_SubmitMonthYear;
	}
	public void setBtn_SubmitMonthYear(WebElement btn_SubmitMonthYear) {
		this.btn_SubmitMonthYear = btn_SubmitMonthYear;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMIName() {
		return MIName;
	}
	public void setMIName(String mIName) {
		MIName = mIName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLead() {
		return lead;
	}
	public void setLead(String lead) {
		this.lead = lead;
	}
	public String getDNIS() {
		return DNIS;
	}
	public void setDNIS(String dNIS) {
		DNIS = dNIS;
	}
	public String getPriorityCode() {
		return priorityCode;
	}
	public void setPriorityCode(String priorityCode) {
		this.priorityCode = priorityCode;
	}
	public String getVIP() {
		return VIP;
	}
	public void setVIP(String vIP) {
		VIP = vIP;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddressNote() {
		return addressNote;
	}
	public void setAddressNote(String addressNote) {
		this.addressNote = addressNote;
	}
	public String getParticipantNote() {
		return participantNote;
	}
	public void setParticipantNote(String participantNote) {
		this.participantNote = participantNote;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneExtension() {
		return phoneExtension;
	}
	public void setPhoneExtension(String phoneExtension) {
		this.phoneExtension = phoneExtension;
	}
	public String getEmailType() {
		return emailType;
	}
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
