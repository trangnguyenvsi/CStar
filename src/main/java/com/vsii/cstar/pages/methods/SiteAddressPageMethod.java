package com.vsii.cstar.pages.methods;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vsii.cstar.pages.SiteAdressPage;

public class SiteAddressPageMethod {
	WebDriver driver;
	public SiteAdressPage objSiteAdressPage = new SiteAdressPage();

	// tab name at Site Address page
	public enum SA_TAB {
		ADDRESS, PHONE, EMAIL, SITE_INFORMATION, RESTRICTIONS, NOTES, PAST_EVENTS, HISTORY, CONTACT_INFO
	}

	// fields, labels at tab Address and in Add/Edit Address screen
	public enum SA_ADDRESS_INFO {
		ADDRESS_TYPE, ADDRESS1, ADDRESS2, ADDRESS3, CITY, STATE, ZIP_CODE, COUNTRY_NAME, SITE_STATUS, FOUR, NOTES, CHK_MN_GEO_CODE, LATITUDE, LONGITUDE, CHK_PRIMARY
	}

	// fields in site information tab
	public enum SA_SITE_INFO {
		SITE_NAME, WEBSITE, SITE_TYPE, DENOMINATION, NO_OF_MEMS, DIMENSION_LENGHT, DIMENSION_BREADTH, SQUARE_FEED, CHECK_BOX
	}

	// buton in screen
	public enum SA_BUTON {
		VIEW, ADD, EDIT, SAVE, RETURN_TO_LIST, RETURN_TO_SREENING, PRINT, VERIFY_ADDRESS, VERIFY_ZIPCODE, CANCEL, BACK_TO_SITE
	}

	public SiteAddressPageMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objSiteAdressPage);
	}

	// Select tab
	public void selectTab(SA_TAB tabName) {
		switch (tabName) {
		case ADDRESS:
			objSiteAdressPage.getTab_Address().click();
			break;
		case PHONE:
			objSiteAdressPage.getTab_Phone().click();
			break;
		case EMAIL:
			objSiteAdressPage.getTab_Email().click();
			break;
		case SITE_INFORMATION:
			objSiteAdressPage.getTab_SiteInfo().click();
			break;
		case RESTRICTIONS:
			objSiteAdressPage.getTab_Restriction().click();
			break;
		case NOTES:
			objSiteAdressPage.getTab_Notes().click();
			break;
		case PAST_EVENTS:
			objSiteAdressPage.getTab_PastEvents().click();
			break;
		case HISTORY:
			objSiteAdressPage.getTab_History().click();
			break;
		default:
			break;
		}
	}

	// Edit primary information
	/**
	 * @note Choose tab name first (by enum), then select desired block
	 *       information, use 999 to select primary information. For other tab
	 *       like Site Information and Restriction, orderNumber is any int value
	 * 
	 */
	public void clickEditButonInTab(SA_TAB tabName, int orderNumber) {
		if (orderNumber == 999) {
			switch (tabName) {
			case ADDRESS:
				driver.findElement(By
						.xpath("//div[@id='ctl00_plcMain_tbcSiteAddress_tpAddress']/table/tbody/tr[2]/td/div[contains(@style,'Gainsboro')]/a"))
						.click();
				this.waitForLoadingImgToLoad();
				break;
			case PHONE:
				driver.findElement(By
						.xpath("//div[@id='ctl00_plcMain_tbcSiteAddress_tpPhone']/table/tbody/tr[2]/td/div[contains(@style,'Gainsboro')]/a"))
						.click();
				this.waitForLoadingImgToLoad();
				break;
			case EMAIL:
				driver.findElement(By
						.xpath("//div[@id='ctl00_plcMain_tbcSiteAddress_tpEmail']/table/tbody/tr[2]/td/div[contains(@style,'Gainsboro')]/a"))
						.click();
				this.waitForLoadingImgToLoad();
				break;
			case SITE_INFORMATION:
				driver.findElement(By.id("ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo_btnSiteInfoEdit")).click();
				this.waitForLoadingImgToLoad();
				break;
			case RESTRICTIONS:
				driver.findElement(By.id("ctl00_plcMain_tbcSiteAddress_tbpnlRestrictions_btnRestrictionEdit")).click();
				this.waitForLoadingImgToLoad();
				break;
			default:
				break;
			}
		} else {
			switch (tabName) {
			case ADDRESS:
				driver.findElement(
						By.xpath("//div[@id='ctl00_plcMain_tbcSiteAddress_tpAddress']/table/tbody/tr[2]/td/div["
								+ orderNumber + "]/a"))
						.click();
				this.waitForLoadingImgToLoad();
				break;
			case PHONE:
				driver.findElement(
						By.xpath("//div[@id='ctl00_plcMain_tbcSiteAddress_tpPhone']/table/tbody/tr[2]/td/div["
								+ orderNumber + "]/a"))
						.click();
				this.waitForLoadingImgToLoad();
				break;
			case EMAIL:
				driver.findElement(
						By.xpath("//div[@id='ctl00_plcMain_tbcSiteAddress_tpEmail']/table/tbody/tr[2]/td/div["
								+ orderNumber + "]/a"))
						.click();
				this.waitForLoadingImgToLoad();
				break;
			case SITE_INFORMATION:
				driver.findElement(By.id("ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo_btnSiteInfoEdit")).click();
				this.waitForLoadingImgToLoad();
				break;

			case RESTRICTIONS:
				driver.findElement(By.id("ctl00_plcMain_tbcSiteAddress_tbpnlRestrictions_btnRestrictionEdit")).click();
				this.waitForLoadingImgToLoad();
				break;
			default:
				break;
			}
		}
	}

	// Get static value from tab Address, Phone and Email
	/**
	 * @return values of all field in block information
	 * @note Please input 999 to get all informations of primary address, else
	 *       use order number of address block to get their information
	 */
	public Map<SA_ADDRESS_INFO, String> getAddressInformations(int addressOrderNumber) {
		Map<SA_ADDRESS_INFO, String> vals = new HashMap<>();

		if (addressOrderNumber == 999) {
			/// 999: when you wanna get primary address information
			// Clear values before put new values in
			vals.clear();

			// Put values into define string
			String xpath_AddressBlockInfo = "//div[@id='ctl00_plcMain_tbcSiteAddress_tpAddress']/table/tbody/tr[2]/td/div[contains(@style,'Gainsboro')]";
			String siteType = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[1]")).getText();
			String address1 = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[2]")).getText();
			String address2 = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[3]")).getText();
			String address3 = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[4]")).getText();
			String city = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[5]")).getText();
			String state = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[6]")).getText();
			String zipCode = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[7]")).getText();
			String countryFullName = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[8]")).getText();
			String siteStatus = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[9]")).getText();

			// put selected values to Map
			vals.put(SA_ADDRESS_INFO.ADDRESS_TYPE, siteType);
			vals.put(SA_ADDRESS_INFO.ADDRESS1, address1);
			vals.put(SA_ADDRESS_INFO.ADDRESS2, address2);
			vals.put(SA_ADDRESS_INFO.ADDRESS3, address3);
			vals.put(SA_ADDRESS_INFO.CITY, city);
			vals.put(SA_ADDRESS_INFO.STATE, state);
			vals.put(SA_ADDRESS_INFO.ZIP_CODE, zipCode);
			vals.put(SA_ADDRESS_INFO.COUNTRY_NAME, countryFullName);
			vals.put(SA_ADDRESS_INFO.SITE_STATUS, siteStatus);
		} else {
			// Clear values before put new values in
			vals.clear();
			// Put values into define string
			String xpath_AddressBlockInfo = "//div[@id='ctl00_plcMain_tbcSiteAddress_tpAddress']/table/tbody/tr[2]/td/div["
					+ addressOrderNumber + "]";
			String siteType = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[1]")).getText();
			String address1 = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[2]")).getText();
			String address2 = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[3]")).getText();
			String address3 = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[4]")).getText();
			String city = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[5]")).getText();
			String state = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[6]")).getText();
			String zipCode = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[7]")).getText();
			String countryFullName = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[8]")).getText();
			String siteStatus = driver.findElement(By.xpath(xpath_AddressBlockInfo + "/span[9]")).getText();

			// put selected values to Map
			vals.put(SA_ADDRESS_INFO.ADDRESS_TYPE, siteType);
			vals.put(SA_ADDRESS_INFO.ADDRESS1, address1);
			vals.put(SA_ADDRESS_INFO.ADDRESS2, address2);
			vals.put(SA_ADDRESS_INFO.ADDRESS3, address3);
			vals.put(SA_ADDRESS_INFO.CITY, city);
			vals.put(SA_ADDRESS_INFO.STATE, state);
			vals.put(SA_ADDRESS_INFO.ZIP_CODE, zipCode);
			vals.put(SA_ADDRESS_INFO.COUNTRY_NAME, countryFullName);
			vals.put(SA_ADDRESS_INFO.SITE_STATUS, siteStatus);
		}
		return vals;
	}

	// Input data to Site Information tab
	/**
	 * 
	 * @param fieldName
	 *            : name of field (get them by enum SITE_INFO)
	 * @param value
	 *            : if field select is checkbox, value is name of checkbox
	 * @return a checkbox if selected field is CHECK_BOX
	 */
	public WebElement inputDataToSiteInformationTab(SA_SITE_INFO fieldName, String value) {
		WebElement checkbox = null;
		switch (fieldName) {
		case SITE_NAME:
			objSiteAdressPage.getTxt_SiteName().clear();
			objSiteAdressPage.getTxt_SiteName().sendKeys(value);
			break;
		case WEBSITE:
			objSiteAdressPage.getTxt_Website().clear();
			objSiteAdressPage.getTxt_Website().sendKeys(value);
			break;
		case SITE_TYPE:
			Select select1 = new Select(objSiteAdressPage.getDdl_SiteType());
			select1.selectByVisibleText(value);
			this.waitForLoadingImgToLoad();
			break;
		// Demomination didn't exist when Site Type is not Church
		case DENOMINATION:
			Select select2 = new Select(objSiteAdressPage.getDdl_Denomination());
			select2.selectByVisibleText(value);
			break;

		// No of men didn't exist when Site Type is not Church
		case NO_OF_MEMS:
			objSiteAdressPage.getTxt_NoOfMembers().clear();
			objSiteAdressPage.getTxt_NoOfMembers().sendKeys(value);
			break;
		case DIMENSION_LENGHT:
			objSiteAdressPage.getTxt_DimensionLenght().clear();
			objSiteAdressPage.getTxt_DimensionLenght().sendKeys(value);
			break;
		case DIMENSION_BREADTH:
			objSiteAdressPage.getTxt_DimensionBreadth().clear();
			objSiteAdressPage.getTxt_DimensionBreadth().sendKeys(value);
			break;
		case CHECK_BOX:
			String xpath_chkRow = "//table[@id='ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo_grdSiteInfo']/tbody/tr";
			// Get number of checkbox in screen
			int chkNumber = driver.findElements(By.xpath(xpath_chkRow)).size();

			// Get position of checkbox by its value
			String chkOrder = "null";
			for (int i = 1; i <= chkNumber; i++) {
				String xpath_chkVal = "//table[@id='ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo_grdSiteInfo']/tbody/tr["
						+ i + "]/td[2]";
				String actual_Val = driver.findElement(By.xpath(xpath_chkVal)).getText();
				if (actual_Val.equals(value)) {
					chkOrder = Integer.toString(i);
					break;
				} else {
					System.out.println("Checkbox number "+i+" not match with input value");
				}
			}

			// Get checkbox element by otained position
			String xpath_checkbox = "//table[@id='ctl00_plcMain_tbcSiteAddress_tbpnlSiteInfo_grdSiteInfo']/tbody/tr["
					+ chkOrder + "]/td/input";
			checkbox = driver.findElement(By.xpath(xpath_checkbox));
			break;
		default:
			break;
		}
		return checkbox;
	}

	// Wait for image loading to load
	/**
	 * @author thanhvc
	 * @note use this for other screen except Add/Edit Address Screen
	 */
	public void waitForLoadingImgToLoad() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_imgLoading")));
	}

	// Wait for image loading to load / when add/edit address info
	/**
	 * @author thanhvc
	 * @note use this for Add/Edit Address Screen
	 */
	public void waitForLoadingImgToLoad2() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(
				By.id("ctl00_plcMain_tbcSiteAddress_tpAddress_ucAddressRepeater_imgLoaderScreening")));
	}

	// Input data Add/Edit Address form
	/**
	 * 
	 * @param fieldName
	 *            : name of field (get them by enum SA_ADDRESS_INFO)
	 * @param val
	 *            : input values to textbox, or chosen value in dropdown list
	 * 
	 */
	public void inputDataToAddEditAddressForm(SA_ADDRESS_INFO fieldName, String val) {
		switch (fieldName) {
		case CHK_PRIMARY:
			objSiteAdressPage.getChk_Primary().click();
			break;
		case COUNTRY_NAME:
			Select ddlCountry = new Select(objSiteAdressPage.getDdl_Country());
			ddlCountry.selectByVisibleText(val);
			break;
		case ADDRESS_TYPE:
			Select ddlType = new Select(objSiteAdressPage.getDdl_AddressType());
			ddlType.selectByVisibleText(val);
			break;
		case ADDRESS1:
			objSiteAdressPage.getTxt_Address1().sendKeys(val);
			break;
		case ADDRESS2:
			objSiteAdressPage.getTxt_Address2().sendKeys(val);
			break;
		case ADDRESS3:
			objSiteAdressPage.getTxt_Address3().sendKeys(val);
			break;
		case CITY:
			objSiteAdressPage.getTxt_City().sendKeys(val);
			break;
		case ZIP_CODE:
			objSiteAdressPage.getTxt_ZipCode().sendKeys(val);
			break;
		case FOUR:
			objSiteAdressPage.getTxt_Four().sendKeys(val);
			break;
		case NOTES:
			objSiteAdressPage.getTxt_Notes().sendKeys(val);
			break;
		case CHK_MN_GEO_CODE:
			objSiteAdressPage.getChk_ManualGeoCode().click();
			this.waitForLoadingImgToLoad2();
			break;
		case LATITUDE:
			objSiteAdressPage.getTxt_Latitude().sendKeys(val);
			break;
		case LONGITUDE:
			objSiteAdressPage.getTxt_Longitude().sendKeys(val);
			break;
		default:
			break;
		}
	}

	/**
	 * @author thanhvc
	 * @date 23/6/2016
	 * @note Only create for address tab, site information tab, contact
	 *       information. If anyone else need other fields, plz insert them to
	 *       this method
	 */
	public void clickButon(SA_TAB tabName, SA_BUTON butonName) {
		switch (tabName) {
		case ADDRESS:
			switch (butonName) {
			case VERIFY_ADDRESS:
				objSiteAdressPage.getBtn_VerifyAddress().click();
				break;
			case VERIFY_ZIPCODE:
				objSiteAdressPage.getBtn_VerifyZipCode().click();
				this.waitForLoadingImgToLoad2();
				break;
			case SAVE:
				objSiteAdressPage.getBtn_Adr_Save().click();
				this.waitForLoadingImgToLoad2();
				break;
			case CANCEL:
				objSiteAdressPage.getBtn_Adr_Cancel().click();
				this.waitForLoadingImgToLoad2();
				break;
			default:
				break;
			}
			break;
		case SITE_INFORMATION:
			switch (butonName) {
			case SAVE:
				objSiteAdressPage.getBtn_SiteInfo_Save().click();
				this.waitForLoadingImgToLoad();
				break;
			case CANCEL:
				objSiteAdressPage.getBtn_SiteInfo_Cancel().click();
				this.waitForLoadingImgToLoad();
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
	}

	// Get number of contacts
	public int getNumberOfContacts() {
		int noOfContacts = driver.findElements(By.xpath("//table[@id='ctl00_plcMain_grdContactInfo']/tbody/tr")).size()
				- 1;
		return noOfContacts;
	}

	// View contact information
	/**
	 * 
	 * @param orderNum
	 *            : line number where address located
	 * @note use orderNum = 1 when to view primary contact information
	 */
	public void viewContactInfo(int orderNum) {
		String xpath_btn_View = "//table[@id='ctl00_plcMain_grdContactInfo']/tbody/tr[" + (orderNum + 1) + "]/td/input";
		driver.findElement(By.xpath(xpath_btn_View)).click();
		this.waitForLoadingImgToLoad();
	}
}
