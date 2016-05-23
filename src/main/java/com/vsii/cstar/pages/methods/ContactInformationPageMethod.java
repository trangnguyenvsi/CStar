package com.vsii.cstar.pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vsii.cstar.pages.ContactInformationPage;

public class ContactInformationPageMethod {
	WebDriver driver;
	public ContactInformationPage objContactInformationPage = new ContactInformationPage();

	// declare driver and source elements
	public ContactInformationPageMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objContactInformationPage);
	}

	// Wait for loading image (after click Save buton) to load
	/**
	 * @note Wait for loading image (after click buton Save) to load
	 */
	public void waitForLoadingImageToLoad() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_imgLoading")));
	}

	// Wait for loading image to load (when click a function buton at Add/Edit
	// Address window)
	/**
	 * @note Wait for loading image to load (when click a function buton at
	 *       Add/Edit Address window)
	 */
	public void waitForLoadingImageToLoad2() {
		new WebDriverWait(driver, 30).until(ExpectedConditions
				.invisibilityOfElementLocated(By.id("ctl00_plcMain_tcDetails_tpAddress_rptAddress_up1Progress")));
	}

	// Click buton Add
	public void clickAddContact() {
		objContactInformationPage.getBtn_ContactInfo_Add().click();
		this.waitForLoadingImageToLoad();
	}

	// Click buton Edit
	public void clickEditContact() {
		objContactInformationPage.getBtn_ContactInfo_Edit().click();
		this.waitForLoadingImageToLoad();
	}

	// Verify checkbox Primary Contact
	/**
	 * @return true if checkbox Primary for this Contact is checked
	 */
	public boolean isPrimaryContact() {
		boolean isSelect = false;
		String statusChkPrimary = objContactInformationPage.getChk_Primary().getAttribute("checked");
		if (statusChkPrimary.toString() != null) {
			isSelect = true;
		}
		return isSelect;
	}

	// Check/uncheck to Primary contact
	public void checkUncheckPrimaryContactCheckbox() {
		objContactInformationPage.getChk_Primary().click();
	}

	// Select dropdown Salutation
	public Select selectDropdownSalutation() {
		Select ddlSalutation = new Select(objContactInformationPage.getDdl_Salutation());
		return ddlSalutation;
	}

	// Clear text from text box First Name
	public void clearTxtFisrtName() {
		objContactInformationPage.getTxt_FirstName().clear();
	}

	// Enter text to text box First Name
	public void inputFirstName(String firstName) {
		objContactInformationPage.getTxt_FirstName().sendKeys(firstName);
	}

	// Clear text in text box MI Name
	public void clearTxtMIName() {
		objContactInformationPage.getTxt_MIName().clear();
	}

	// Enter text to text box MI Name
	public void inputMIName(String MIName) {
		objContactInformationPage.getTxt_MIName().sendKeys(MIName);
	}

	// Clear text from text box Last Name
	public void clearTxtLastName() {
		objContactInformationPage.getTxt_LastName().clear();
	}

	// Enter text to text box Last Name
	public void inputLastName(String lastName) {
		objContactInformationPage.getTxt_LastName().sendKeys(lastName);
	}

	// Select dropdown Suffix
	public Select selectDropdownSuffix() {
		Select ddlSuffix = new Select(objContactInformationPage.getDdl_Suffix());
		return ddlSuffix;
	}

	// Select dropdown type (contact)
	public Select selectDropdownContactType() {
		Select ddlContactType = new Select(objContactInformationPage.getDdl_ContactType());
		return ddlContactType;
	}

	// Clear text from text box Title
	public void clearTxtTitle() {
		objContactInformationPage.getTxt_Title().clear();
	}

	// Enter text to text box Title
	public void inputTitle(String title) {
		objContactInformationPage.getTxt_Title().sendKeys(title);
	}

	// Clear text from text box Comments
	public void clearTxtComment() {
		objContactInformationPage.getTxt_Comments().clear();
	}

	// Enter text to text box Comments
	public void inputComment(String comment) {
		objContactInformationPage.getTxt_Comments().sendKeys(comment);
	}

	// Save Contact Information
	public void saveContactInformation() {
		objContactInformationPage.getBtn_ContactInfo_Save().click();
	}

	// Cancel update contact information
	public void cancelUpdateContactInformation() {
		objContactInformationPage.getBtn_ContactInfo_Cancel().click();
	}

	// Add or Update contact informations
	public void updateContactInformation(int check, String salutation, String fisrtName, String MIName, String lastName,
			String suffix, String contactType, String title, String comment) {
		if (check == 1) {
			this.checkUncheckPrimaryContactCheckbox();
		}
		this.selectDropdownSalutation().selectByVisibleText(salutation);

		this.clearTxtFisrtName();
		this.inputFirstName(fisrtName);

		this.clearTxtMIName();
		this.inputMIName(MIName);

		this.clearTxtLastName();
		this.inputLastName(lastName);

		this.selectDropdownSuffix().selectByVisibleText(suffix);

		this.selectDropdownContactType().selectByVisibleText(contactType);

		this.clearTxtTitle();
		this.inputTitle(title);

		this.clearTxtComment();
		this.inputComment(comment);

		this.saveContactInformation();
		this.waitForLoadingImageToLoad();
	}

	// Select tab Address
	public void selectTabAddress() {
		objContactInformationPage.getTab_Address().click();
	}

	// Select tab Phone
	public void selectTabPhone() {
		objContactInformationPage.getTab_Phone().click();
	}

	// Select tab Email
	public void selectTabEmail() {
		objContactInformationPage.getTab_Email().click();
	}

	// Click Add Address
	public void clickAddAddress() {
		objContactInformationPage.getHpl_ContactInfo_AddAddress().click();
	}

	// Count number of contact's address
	public int getNumberOfAddress() {
		int numberOfAddress = driver
				.findElements(By.xpath("//div[@id='ctl00_plcMain_tcDetails_tpAddress']/table/tbody/tr[2]/td/div"))
				.size();
		return numberOfAddress;
	}

	// Click Edit Address by its location (if you know where it is)
	/**
	 * @param location
	 *            : Choose 1 for primary address
	 */
	public void clickEditAddressByLocation(int location) {
		String xpath_lnk_Edit = "//div[@id='ctl00_plcMain_tcDetails_tpAddress']/table/tbody/tr[2]/td/div[" + location
				+ "]/a[1]";
		driver.findElement(By.xpath(xpath_lnk_Edit)).click();
		this.waitForLoadingImageToLoad();
	}

	// Click Edit Address by its name (if you no what's it name)
	/**
	 * @param address1
	 *            : Address that show up in screen
	 */
	public void clickEditAddressByItsAddress(String address1) {
		int numOfAddress = this.getNumberOfAddress();
		String location = null;
		for (int i = 1; i <= numOfAddress; i++) {
			String xpath_Address1Val = "//div[@id='ctl00_plcMain_tcDetails_tpAddress']/table/tbody/tr[2]/td/div[" + i
					+ "]/span[2]";
			String addressVal = driver.findElement(By.xpath(xpath_Address1Val)).getText();
			if (addressVal.equals(address1)) {
				location = Integer.toString(i);
				break;
			}
		}
		if (location == null) {
			System.out.println("Input address not match with any address on screen");
		} else {
			String xpath_lnk_Edit = "//div[@id='ctl00_plcMain_tcDetails_tpAddress']/table/tbody/tr[2]/td/div["
					+ location + "]/a[1]";
			driver.findElement(By.xpath(xpath_lnk_Edit)).click();
			this.waitForLoadingImageToLoad();
		}
	}

	// Find out checkbox Primary Address is check or not
	/**
	 * @return true if checkbox Primary Address is checked
	 */
	public boolean isPrimaryAddress() {
		boolean isChecked = false;
		String chkStatus = objContactInformationPage.getChk_PrimaryAddress().getAttribute("checked");
		if (chkStatus.toString() != null) {
			isChecked = true;
		}
		return isChecked;
	}

	// Check or Uncheck checkbox Primary (Address)
	public void checkToCheckboxPrimaryAddress() {
		objContactInformationPage.getChk_PrimaryAddress().click();
	}

	// Select dropdown Country
	public Select selectCounry() {
		Select ddlCountry = new Select(objContactInformationPage.getDdl_Country());
		return ddlCountry;
	}

	// Select dropdown Type (Address)
	public Select selectAddressType() {
		Select ddlAddressType = new Select(objContactInformationPage.getDdl_AddressType());
		return ddlAddressType;
	}

	// Clear text from Address line 1
	public void clearTxtAddressLine1() {
		objContactInformationPage.getTxt_Address1().clear();
	}

	// Input Address line 1
	public void inputAddressLine1(String address1) {
		objContactInformationPage.getTxt_Address1().sendKeys(address1);
	}

	// Clear text from Address line 2
	public void clearTxtAddressLine2() {
		objContactInformationPage.getTxt_Address2().clear();
	}

	// Input Address line 2
	public void inputAddressLine2(String address2) {
		objContactInformationPage.getTxt_Address2().sendKeys(address2);
	}

	// Clear text from Address line 3
	public void clearTxtAddressLine3() {
		objContactInformationPage.getTxt_Address3().clear();
	}

	// Input Address line 3
	public void inputAddressLine3(String address3) {
		objContactInformationPage.getTxt_Address3().sendKeys(address3);
	}

	// Clear text from textbox City
	public void clearTxtCity() {
		objContactInformationPage.getTxt_City().clear();
	}

	// Input City
	public void inputCity(String city) {
		objContactInformationPage.getTxt_City().sendKeys(city);
	}

	// Clear text from textbox Zip Code
	public void clearTxtZipCode() {
		objContactInformationPage.getTxt_Zipcode().clear();
	}

	// Input Zip Code
	public void inputZipCode(String zipCode) {
		objContactInformationPage.getTxt_Zipcode().sendKeys(zipCode);
	}

	// Clear text from textbox Four
	public void clearTxtFour() {
		objContactInformationPage.getTxt_SitePlus4().clear();
	}

	// Input Four
	public void inputFour(String four) {
		objContactInformationPage.getTxt_SitePlus4().sendKeys(four);
	}

	// Clear text from textbox Notes
	public void clearTxtNote() {
		objContactInformationPage.getTxt_AddressNotes().clear();
	}

	// Input Notes
	public void inputNote(String note) {
		objContactInformationPage.getTxt_AddressNotes().sendKeys(note);
	}

	// Check to check box Manual Geo-Code
	public void checkToCheckboxManualGeoCode() {
		objContactInformationPage.getChk_ManualGeoCode().click();
		this.waitForLoadingImageToLoad2();
	}

	// Input Latitude
	public void inputLatitude(String latitude) {
		objContactInformationPage.getTxt_Latitude().sendKeys(latitude);
	}

	// Input Longitude
	public void inputLongitude(String longitude) {
		objContactInformationPage.getTxt_Longitude().sendKeys(longitude);
	}

	// Click buton verify address
	public void clickButonVerifyAddress() {
		objContactInformationPage.getBtn_VerifyAddress().click();
	}

	// Click buton verify zip code
	public void clickButonVerifyZipCode() {
		objContactInformationPage.getBtn_VerifyZipCode().click();
		this.waitForLoadingImageToLoad2();
	}

	// Click buton Save Address
	public void saveAddress() {
		objContactInformationPage.getBtn_SaveAddress().click();
		this.waitForLoadingImageToLoad2();
	}

	// Click buton Cancel update Address
	public void cancelUpdateAddress() {
		objContactInformationPage.getBtn_CancelAddress().click();
		this.waitForLoadingImageToLoad2();
	}

	// Update address information
	/**
	 * 
	 * @param check
	 *            : 1 for check or uncheck check box, other value to leave it
	 *            alone
	 * @param country
	 *            : Country name, It should be match with values in dropdown
	 *            list Country
	 * @param addressType
	 *            : Address type, It should be match with values in dropdown
	 *            list Type (mandatory)
	 * @param address1
	 *            : Enter Address Line 1 (mandatory)
	 * @param address2
	 *            : Enter Address Line 2 (optional)
	 * @param address3
	 *            : Enter Address Line 3 (optional)
	 * @param city
	 *            : City in text, it can auto visible when zip code enter is
	 *            corrected, so in below method dont need to input City value
	 * @param zipCode
	 *            : Enter correct zip cpde (madatory)
	 * @param four
	 *            : Site plus 4 (optional)
	 * @param note
	 *            : Address notes (optional)
	 * @param manual_Geo_Code
	 *            : 1 for check manual geo code checkbox
	 * @param latitude
	 *            : Enter Latitude if Manual Geo Code is checked, if not, leave
	 *            it empty
	 * @param longitude
	 *            : Enter Longitude if Manual Geo Code is checked, if not, leave
	 *            it empty
	 */
	public void updateAddressInformation(int check, String country, String addressType, String address1,
			String address2, String address3, String zipCode, String four, String note, int manual_Geo_Code,
			String latitude, String longitude) {
		if (check == 1) {
			this.checkToCheckboxPrimaryAddress();
		}
		this.selectCounry().selectByVisibleText(country);
		
		this.selectAddressType().selectByVisibleText(addressType);
		
		this.clearTxtZipCode();
		this.inputZipCode(zipCode);
		
		this.clickButonVerifyZipCode();
		
		this.clearTxtAddressLine1();
		this.inputAddressLine1(address1);
		
		this.clearTxtAddressLine2();
		this.inputAddressLine2(address2);
		
		this.clearTxtAddressLine3();
		this.inputAddressLine3(address3);
		// this.inputCity(city);
		
		this.clearTxtFour();
		this.inputFour(four);
		
		this.clearTxtNote();
		this.inputNote(note);

		if (manual_Geo_Code == 1) {
			this.checkToCheckboxManualGeoCode();
			this.inputLatitude(latitude);
			this.inputLongitude(longitude);
		}

		this.saveAddress();
		this.waitForLoadingImageToLoad2();
	}

	// Get number of contact's phone
	public int getNumberOfContactsPhone() {
		int noOfContactsPhone = driver
				.findElements(By.xpath("//div[@id='ctl00_plcMain_tcDetails_tpPhone']/table/tbody/tr[2]/td/div")).size();
		return noOfContactsPhone;
	}

	// Click edit Phone by its location
	/**
	 * @param location
	 *            : 1 for edit primary Phone No.
	 */
	public void clickEditPhoneByLocation(int location) {
		String xpath_hpl_Edit = "//div[@id='ctl00_plcMain_tcDetails_tpPhone']/table/tbody/tr[2]/td/div[" + location
				+ "]/a";
		driver.findElement(By.xpath(xpath_hpl_Edit)).click();
		this.waitForLoadingImageToLoad();
	}

	// Fint out checkbox Primary (phone) is checked or not
	public boolean isPrimaryPhone() {
		boolean isChecked = false;
		String checkStatus = objContactInformationPage.getChk_PrimaryPhone().getAttribute("checked");
		if (checkStatus.toString() != null) {
			isChecked = true;
		}
		return isChecked;
	}

	// Check or uncheck checkbox primary
	public void checkUncheckCheckboxPrimaryPhone() {
		objContactInformationPage.getChk_PrimaryPhone().click();
	}

	// Select phone type
	public Select selectPhoneType() {
		Select ddlPhoneType = new Select(objContactInformationPage.getDdl_PhoneType());
		return ddlPhoneType;
	}
	
	// Clear phone number
		public void clearTxtPhoneNo() {
			objContactInformationPage.getTxt_PhoneNo().clear();
		}

	// Input phone number
	public void inputPhoneNo(String phoneNo) {
		objContactInformationPage.getTxt_PhoneNo().sendKeys(phoneNo);
	}

	// Clear phone extension
	public void clearTxtPhoneExtension() {
		objContactInformationPage.getTxt_PhoneExtension().clear();
	}
	
	// Input phone extension
	public void inputPhoneExtension(String phoneExtension) {
		objContactInformationPage.getTxt_PhoneExtension().sendKeys(phoneExtension);
	}

	// Click buton save phone
	public void savePhone() {
		objContactInformationPage.getBtn_SavePhone().click();
		this.waitForLoadingImageToLoad();
	}

	// Click buton cancel update phone
	public void cancelUpdatePhone() {
		objContactInformationPage.getBtn_CancelUpdatePhone().click();
		this.waitForLoadingImageToLoad();
	}

	// Update phone information
	/**
	 * @param check
	 *            : choose 1 for check to checkbox Primary
	 * @param phoneType
	 *            : Select type, value should match with values in dropdown list
	 *            Type
	 * @param phoneNo
	 *            : Enter phone No
	 * @param phoneExtension
	 *            : Enter phone extension
	 */
	public void updatePhoneInformation(int check, String phoneType, String phoneNo, String phoneExtension) {
		if (check == 1) {
			this.checkUncheckCheckboxPrimaryPhone();
		}
		this.selectPhoneType().selectByVisibleText(phoneType);
		
		this.clearTxtPhoneNo();
		this.inputPhoneNo(phoneNo);
		
		this.clearTxtPhoneExtension();
		this.inputPhoneExtension(phoneExtension);
		
		this.savePhone();
	}

	// Get number of contact's email
	public int getNumberOfContactsEmail() {
		int noOfContactsEmail = driver
				.findElements(By.xpath("//div[@id='ctl00_plcMain_tcDetails_tpEmail']/table/tbody/tr[2]/td/div")).size();
		return noOfContactsEmail;
	}

	// Click Edit Email by its location
	/**
	 * @param location
	 *            : choose 1 for click buton Edit at Primary Phone
	 */
	public void clickEditEmailByLocation(int location) {
		String xpath_hpl_Edit = "//div[@id='ctl00_plcMain_tcDetails_tpEmail']/table/tbody/tr[2]/td[" + location
				+ "]/div/a";
		driver.findElement(By.xpath(xpath_hpl_Edit)).click();
		this.waitForLoadingImageToLoad();
	}

	// Check or uncheck checkbox Primary Email
	public void checkUncheckCheckboxPrimaryEmail() {
		objContactInformationPage.getChk_PrimaryEmail().click();
	}

	// Select dropdown type (Email)
	public Select selectEmailType() {
		Select ddlEmailType = new Select(objContactInformationPage.getDdl_EmailType());
		return ddlEmailType;
	}

	// Clear text from textbox Email
	public void clearTxtEmail() {
		objContactInformationPage.getTxt_Email().clear();
	}

	// Enter text to textbox Email
	public void inputEmail(String email) {
		objContactInformationPage.getTxt_Email().sendKeys(email);
	}

	// Click buton Save Email
	public void saveEmail() {
		objContactInformationPage.getBtn_SavePhone().click();
		this.waitForLoadingImageToLoad2();
	}

	// Click buton cancel update Email
	public void cancelUpdateEmail() {
		objContactInformationPage.getBtn_CancelUpdatePhone().click();
		this.waitForLoadingImageToLoad2();
	}

	// Update email information
	/**
	 * @param check
	 *            : choose 1 for check to checkbox Primary
	 * @param emailType
	 *            : Email type, input value should be match with values in
	 *            dropdown list Type
	 * @param email
	 *            : Enter email
	 */
	public void updateEmailInformation(int check, String emailType, String email) {
		if (check == 1) {
			this.checkUncheckCheckboxPrimaryEmail();
		}

		this.selectEmailType().selectByVisibleText(emailType);
		this.clearTxtEmail();
		this.inputEmail(email);
		this.saveEmail();
	}

}
