package com.vsii.cstar.pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vsii.cstar.pages.SiteInfo;

public class SiteInfoMethod {
	WebDriver driver;
	public SiteInfo objSiteInfo = new SiteInfo();

	public enum SITE_FIELD {
		SITE_NAME, SITE_ADDRESS, COUNTRY_ABBR, CITY, ZIP, STATE, FIRST_NAME, LAST_NAME, MI_NAME, CONTACT_TYPE, PHONE, PHONE_EXTENSION, FAX, CONTACT_EMAIL, SITE_EMAIL
	}

	public SiteInfoMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objSiteInfo);
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
		case SITE_ADDRESS:
			if (objSiteInfo.getTxt_SiteAddress().getAttribute("disabled").toString() == null) {
				val = objSiteInfo.getTxt_SiteAddress().getText();
			} else {
				val = objSiteInfo.getTxt_SiteAddress().getAttribute("value");
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
			if (objSiteInfo.getTxt_City().getAttribute("disabled").toString() == null) {
				val = objSiteInfo.getTxt_City().getText();
			} else {
				val = objSiteInfo.getTxt_City().getAttribute("value");
			}
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
		case PHONE_EXTENSION:
			val = objSiteInfo.getTxt_PhoneExtension().getAttribute("value");
			break;
		case FAX:
			val = objSiteInfo.getTxt_SiteFax().getAttribute("value");
			break;
		case CONTACT_EMAIL:
			val = objSiteInfo.getTxt_ContactMail().getAttribute("value");
			// case SITE_EMAIL:
			// //No need yet
			// break;
		default:
			break;
		}
		return val;
	}

}
