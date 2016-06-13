package com.vsii.cstar.pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vsii.cstar.pages.SiteInfo;

public class SiteInfoMethod {
	WebDriver driver;
	public SiteInfo objSiteInfo = new SiteInfo();

	public enum SITE_FIELD {
		SITE_NAME, SITE_TYPE, ADDRESS_TYPE, SITE_ADDRESS1, SITE_ADDRESS2, SITE_ADDRESS3, COUNTRY_ABBR, CITY, ZIP, STATE, FIRST_NAME, LAST_NAME, MI_NAME, CONTACT_TYPE, PHONE, PHONE_TYPE, PHONE_EXTENSION, FAX, CONTACT_EMAIL, CONTACT_EMAIL_TYPE, SITE_EMAIL
	}

	public SiteInfoMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objSiteInfo);
	}

	// Get header text
	public String getHeaderText() {
		return objSiteInfo.getLbl_Header().getText();
	}

	// Get team date info
	public String getTeamDateInfo() {
		return objSiteInfo.getLbl_TeamDateInfo().getText();
	}

	// Click buton Next
	public void clickBtnNext() {
		objSiteInfo.getBtn_Next().click();
	}

	// Wait for loading image to load
	public void waitForElementToLoad() {
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_body_imgProgress")));
	}

	// wait for address status appeared
	public void waitForAddressStatusDisplay() {
		new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.findElement(By.id("ctl00_body_addressValidationInfo")).getText().length() != 0;
			}
		});
	}

	// waith for auto suggest displayed
	public void waitForAutoSuggestionToDisplay() {
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-dialog-title-scWizAddrSugContainer")));
	}

	// Clear text from textbox Name
	public void clearSiteName() {
		objSiteInfo.getTxt_Sitename().clear();
	}

	// input text to textbox Name
	public void inputSiteName(String siteName) {
		objSiteInfo.getTxt_Sitename().sendKeys(siteName);
	}

	// Select site type
	public Select selectSiteType() {
		Select ddlSiteType = new Select(objSiteInfo.getDdl_SiteType());
		return ddlSiteType;
	}

	// Select address type
	public Select selectAddressType() {
		Select ddlAddressType = new Select(objSiteInfo.getDdl_AddressType());
		return ddlAddressType;
	}

	// Clear text from textbox Address 1
	public void clearAddress1() {
		objSiteInfo.getTxt_SiteAddress1().clear();
	}

	// Input text to textbox Address 1
	public void inputAddress1(String address1) {
		objSiteInfo.getTxt_SiteAddress1().sendKeys(address1);
	}

	// Get address status
	public String getAddressStatus() {
		return objSiteInfo.getVal_AddressStatus().getText();
	}

	// Check if popup Address Suggestion is displayed or not
	public boolean isAddressSuggestionDisplay() {

		boolean isDisplayed = false;
		if (objSiteInfo.getPopup_AddressSuggestion().isDisplayed() == true) {
			isDisplayed = true;
		}
		return isDisplayed;
	}

	// Close Address Suggestion
	public void closeAddressSuggestion() {
		objSiteInfo.getIco_CloseAddressSuggestion().click();
	}

	// Clear text from textbox Address 2
	public void clearAddress2() {
		objSiteInfo.getTxt_SiteAddress2().clear();
	}

	// Input text to textbox Address 2
	public void inputAddress2(String address2) {
		objSiteInfo.getTxt_SiteAddress2().sendKeys(address2);
	}

	// Clear text from textbox Address 3
	public void clearAddress3() {
		objSiteInfo.getTxt_SiteAddress3().clear();
	}

	// Input text to textbox Address 3
	public void inputAddress3(String address3) {
		objSiteInfo.getTxt_SiteAddress3().sendKeys(address3);
	}

	// Clear text from textbox City
	public void clearCity() {
		objSiteInfo.getTxt_City().clear();
	}

	// Input text to textbox City
	public void inputCity(String city) {
		objSiteInfo.getTxt_City().sendKeys(city);
	}

	// Check to checkbox Manual Geo-Code
	public void checkToManualGeoCode() {
		objSiteInfo.getChk_ManualGeoCode().click();
	}

	// Clear text from textbox latitude
	public void clearLatitude() {
		objSiteInfo.getTxt_Latitude().clear();
	}

	// Input text to textbox latitude
	public void inputLatitude(String latitude) {
		objSiteInfo.getTxt_Latitude().sendKeys(latitude);
	}

	// Clear text from textbox longitude
	public void clearLongitude() {
		objSiteInfo.getTxt_Longitude().clear();
	}

	// Input text to textbox latitude
	public void inputLongitude(String longitude) {
		objSiteInfo.getTxt_Latitude().sendKeys(longitude);
	}

	// Select salutation
	public Select selectSalutation() {
		Select ddlSalutation = new Select(objSiteInfo.getDdl_Salutation());
		return ddlSalutation;
	}

	// Clear text from textbox first name
	public void clearFirstName() {
		objSiteInfo.getTxt_FirstName().clear();
	}

	// input text to textbox first name
	public void inputFirstName(String firstName) {
		objSiteInfo.getTxt_FirstName().sendKeys(firstName);
	}

	// Clear text from textbox MI name
	public void clearMIName() {
		objSiteInfo.getTxt_MIName().clear();
	}

	// Input text to textbox MI name
	public void inputMIName(String MIName) {
		objSiteInfo.getTxt_MIName().sendKeys(MIName);
	}

	// Clear text from textbox last name
	public void clearLastName() {
		objSiteInfo.getTxt_LastName().clear();
	}

	// Input text from textbox last name
	public void inputLastName(String lastName) {
		objSiteInfo.getTxt_LastName().sendKeys(lastName);
	}

	// select dropdown Suffix
	public Select selectSuffix() {
		Select ddlSuffix = new Select(objSiteInfo.getDdl_Suffix());
		return ddlSuffix;
	}

	// Select Dropdown Contact Type
	public Select selectContactType() {
		Select ddlContactType = new Select(objSiteInfo.getDdl_ContactType());
		return ddlContactType;
	}

	// Clear text from textbox Email
	public void clearEmail() {
		objSiteInfo.getTxt_ContactMail().clear();
	}

	// Input text to textbox Email
	public void inputEmail(String contactMail) {
		objSiteInfo.getTxt_ContactMail().sendKeys(contactMail);
	}

	// Select contact mail type
	public Select selectContactMailType() {
		Select ddlContactMailType = new Select(objSiteInfo.getDdl_ContactMailType());
		return ddlContactMailType;
	}

	// Clear text from textbox Site Email
	public void clearSiteEmail() {
		objSiteInfo.getTxt_SiteEmail().clear();
	}

	// Input text to textbox Site Email
	public void inputSiteEmail(String siteEmail) {
		objSiteInfo.getTxt_SiteEmail().sendKeys(siteEmail);
	}

	// Select site mail type
	public Select selectSiteMailType() {
		Select ddlSiteMailType = new Select(objSiteInfo.getDdl_SiteMailType());
		return ddlSiteMailType;
	}

	// Clear text from textbox Phone
	public void clearPhone() {
		objSiteInfo.getTxt_ContactPhone().clear();
	}

	// Input text to textbox Phone
	public void inputPhone(String phoneNo) {
		objSiteInfo.getTxt_ContactPhone().sendKeys(phoneNo);
	}

	// Clear text from textbox Phone Extension
	public void clearPhoneExtension() {
		objSiteInfo.getTxt_PhoneExtension().clear();
	}

	// Input text to textbox Phone Extension
	public void inputPhoneExtension(String phoneExtension) {
		objSiteInfo.getTxt_PhoneExtension().sendKeys(phoneExtension);
	}

	// Select dropdown phone type
	public Select selectPhoneType() {
		Select ddlPhoneType = new Select(objSiteInfo.getDdl_PhoneType());
		return ddlPhoneType;
	}

	// Clear text from textbox Fax
	public void clearFax() {
		objSiteInfo.getTxt_SiteFax().clear();
	}

	// Input text to textbox Fax
	public void inputFax(String faxNo) {
		objSiteInfo.getTxt_SiteFax().sendKeys(faxNo);
	}

	// Clear text from textbox website
	public void clearWebsite() {
		objSiteInfo.getTxt_WebSite().clear();
	}

	// Input text to textbox website
	public void inputWebsite(String website) {
		objSiteInfo.getTxt_WebSite().sendKeys(website);
	}

	// Click buton Cancel
	public void clickButonCancel() {
		objSiteInfo.getBtn_Cancel().click();
	}

	// Create new site
	/**
	 * 
	 * @param siteName
	 *            : Mandatory
	 * @param siteType
	 *            : Mandatory
	 * @param addressType
	 *            : Mandatory
	 * @param address1
	 *            : Mandatory
	 * @param address2
	 * @param address3
	 * @param city
	 *            : Type 0 if you dont want to modify it
	 * @param check
	 *            : Type 1 if you want to manual geo-code, 0 for vice-versa
	 * @param latitude
	 *            : only need to input data when check = 1
	 * @param longitude
	 *            : only need to input data when check = 1
	 * @param salutation
	 *            : Leave empty ("") for default value
	 * @param firstName
	 *            : Mandatory
	 * @param MIName
	 * @param lastName
	 *            : Mandatory
	 * @param suffix
	 *            : Leave empty ("") for default value
	 * @param contactType
	 *            : Mandatory
	 * @param email
	 * @param emailType
	 *            : Leave empty ("") for default value
	 * @param siteEmail
	 * @param siteEmailType
	 *            : Leave empty ("") for default value
	 * @param phoneNo
	 *            : Mandatory
	 * @param phoneExtension
	 * @param phoneType
	 *            : Mandatory
	 * @param faxNo
	 * @param website
	 */
	public void createNewSite(String siteName, String siteType, String addressType, String address1, String address2,
			String address3, String city, int manualGeoCode, String latitude, String longitude, String salutation,
			String firstName, String MIName, String lastName, String suffix, String contactType, String email,
			String emailType, String siteEmail, String siteEmailType, String phoneNo, String phoneExtension,
			String phoneType, String faxNo, String website) {
		// input site name
		this.clearSiteName();
		this.inputSiteName(siteName);

		// select site type
		this.selectSiteType().selectByVisibleText(siteType);

		// Select address type
		this.selectAddressType().selectByVisibleText(addressType);

		// input primary address (address 1)
		this.clearAddress1();
		this.inputAddress1(address1);

		// input primary address (address 2)
		this.clearAddress2();
		this.inputAddress2(address2);

		// perform click to address1 again
		this.objSiteInfo.getTxt_SiteAddress1().click();
		this.objSiteInfo.getTxt_SiteAddress2().click();

		// Wait for 10s for address status display
		this.waitForAddressStatusDisplay();

		// if it diplayed, and its value is "Bad Address", close popup Auto
		// Suggestion
		if (this.getAddressStatus().equals("Bad Address")) {
			this.closeAddressSuggestion();
		}

		// input primary address (address 3)
		this.clearAddress3();
		this.inputAddress3(address3);

		// Input city value, if city = 0, then leave it alone
		if (city.equals("0")) {
			// dont update/insert city value
		} else {
			this.clearCity();
			this.inputCity(city);
		}

		// If check = 1, then update manual geo-code
		if (manualGeoCode == 1) {
			this.checkToManualGeoCode();
			// input latitude
			this.clearLatitude();
			this.inputLatitude(latitude);
			// input longitude
			this.clearLongitude();
			this.inputLongitude(longitude);
		}

		// select Salutation
		if (salutation.isEmpty()) {
			// Leave dropdown in default value
		} else {
			this.selectSalutation().selectByVisibleText(salutation);
		}

		// input first name
		this.clearFirstName();
		this.inputFirstName(firstName);

		// input MI name
		this.clearMIName();
		this.inputMIName(MIName);

		// input last name
		this.clearLastName();
		this.inputLastName(lastName);

		// select suffix
		if (suffix.isEmpty()) {
			// Leave dropdown in default value
		} else {
			this.selectSuffix().selectByVisibleText(suffix);
		}

		// select contact type
		this.selectContactType().selectByVisibleText(contactType);

		// input contact email
		this.clearEmail();
		this.inputEmail(email);

		// Select contact email type
		if (emailType.isEmpty()) {
			// Leave dropdown in default value
		} else {
			this.selectContactMailType().selectByVisibleText(emailType);
		}

		// input site email
		this.clearSiteEmail();
		this.inputSiteEmail(siteEmail);

		// select site email type
		if (siteEmailType.isEmpty()) {
			// Leave dropdown in default value
		} else {
			this.selectSiteMailType().selectByVisibleText(siteEmailType);
		}

		// input phone no.
		this.clearPhone();
		this.inputPhone(phoneNo);

		// input phone extension
		this.clearPhoneExtension();
		this.inputPhoneExtension(phoneExtension);

		// select phone type
		this.selectPhoneType().selectByVisibleText(phoneType);

		// input fax no.
		this.clearFax();
		this.inputFax(faxNo);

		// input website address
		this.clearWebsite();
		this.inputWebsite(website);

		// Save Site Info form
		this.clickBtnNext();
		this.waitForElementToLoad();

	}

	// Get site informations
	public String getSiteInfo(SITE_FIELD fieldName) {
		String val = null;
		switch (fieldName) {
		case SITE_NAME:
			if (objSiteInfo.getTxt_Sitename().getAttribute("disabled").toString() == null) {
				val = objSiteInfo.getTxt_Sitename().getText();
			} else {
				val = objSiteInfo.getTxt_Sitename().getAttribute("value");
			}

			break;

		case SITE_TYPE:
			val = new Select(objSiteInfo.getDdl_SiteType()).getFirstSelectedOption().getText();
			break;

		case ADDRESS_TYPE:
			val = new Select(objSiteInfo.getDdl_AddressType()).getFirstSelectedOption().getText();
			break;

		case SITE_ADDRESS1:
			if (objSiteInfo.getTxt_SiteAddress1().getAttribute("disabled").toString() == null) {
				val = objSiteInfo.getTxt_SiteAddress1().getText();
			} else {
				val = objSiteInfo.getTxt_SiteAddress1().getAttribute("value");
			}
			break;

		case SITE_ADDRESS2:
			if (objSiteInfo.getTxt_SiteAddress2().getAttribute("disabled").toString() == null) {
				val = objSiteInfo.getTxt_SiteAddress2().getText();
			} else {
				val = objSiteInfo.getTxt_SiteAddress2().getAttribute("value");
			}
			break;
		case SITE_ADDRESS3:
			if (objSiteInfo.getTxt_SiteAddress3().getAttribute("disabled").toString() == null) {
				val = objSiteInfo.getTxt_SiteAddress3().getText();
			} else {
				val = objSiteInfo.getTxt_SiteAddress3().getAttribute("value");
			}
			break;

		case COUNTRY_ABBR:
			if (objSiteInfo.getTxt_Country().getAttribute("disabled").toString() == null) {
				val = objSiteInfo.getTxt_Country().getText();
			} else {
				val = objSiteInfo.getTxt_Country().getAttribute("value");
			}
			break;

		case CITY:
			val = objSiteInfo.getTxt_City().getAttribute("value");
			break;
		case ZIP:
			if (objSiteInfo.getTxt_SiteZipCode().getAttribute("disabled").toString() == null) {
				val = objSiteInfo.getTxt_SiteZipCode().getText();
			} else {
				val = objSiteInfo.getTxt_SiteZipCode().getAttribute("value");
			}
			break;
		case STATE:
			if (objSiteInfo.getTxt_State().getAttribute("disabled").toString() == null) {
				val = objSiteInfo.getTxt_State().getText();
			} else {
				val = objSiteInfo.getTxt_State().getAttribute("value");
			}
			break;
		case FIRST_NAME:
			val = objSiteInfo.getTxt_FirstName().getAttribute("value");
			break;
		case MI_NAME:
			val = objSiteInfo.getTxt_MIName().getAttribute("value");
			break;
		case LAST_NAME:
			val = objSiteInfo.getTxt_LastName().getAttribute("value");
			break;
		case CONTACT_TYPE:
			Select select1 = new Select(objSiteInfo.getDdl_ContactType());
			val = select1.getFirstSelectedOption().getText();
			break;
		case PHONE:
			val = objSiteInfo.getTxt_ContactPhone().getAttribute("value");
			break;
		case PHONE_TYPE:
			val = new Select(objSiteInfo.getDdl_PhoneType()).getFirstSelectedOption().getText();
			break;
		case PHONE_EXTENSION:
			val = objSiteInfo.getTxt_PhoneExtension().getAttribute("value");
			break;
		case FAX:
			val = objSiteInfo.getTxt_SiteFax().getAttribute("value");
			break;
		case CONTACT_EMAIL:
			val = objSiteInfo.getTxt_ContactMail().getAttribute("value");
			break;
		case CONTACT_EMAIL_TYPE:
			val = new Select(objSiteInfo.getDdl_ContactMailType()).getFirstSelectedOption().getText();
			break;
			// case SITE_EMAIL:
			// No need yet
		default:
			break;
		}
		return val;
	}

}
