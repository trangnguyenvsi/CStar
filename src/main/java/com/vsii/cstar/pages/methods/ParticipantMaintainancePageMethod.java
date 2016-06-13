package com.vsii.cstar.pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vsii.cstar.pages.ParticipantMaintainancePage;

public class ParticipantMaintainancePageMethod {
	public WebDriver driver;
	public ParticipantMaintainancePage objParticipantMaintainancePage = new ParticipantMaintainancePage();

	public ParticipantMaintainancePageMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objParticipantMaintainancePage);
	}

	// Locate to dropdown list element
	public Select locateToDropdown(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	// Wait for address form processing
	public void waitForAddressFormProcessing() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.id(
				"ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_imgLoaderScreening")));
	}

	// Wait for Address Form is displayed
	public void waitForAddressFormDisplay() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id(
				"ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_pnlAddress")));
	}

	// Input data to Add/Edit Address form
	public void enterDataToAddressForm(String addressType, String address1, String address2, String address3,
			String zipCode, String city, String addressNotes) {
		// Edit address type
		if (!addressType.isEmpty()) {
			this.locateToDropdown(objParticipantMaintainancePage.getDdl_AddressType()).selectByVisibleText(addressType);
		}

		// Edit Address line 1
		objParticipantMaintainancePage.getTxt_Address1().clear();
		objParticipantMaintainancePage.getTxt_Address1().sendKeys(address1);

		// Edit Address line 2
		objParticipantMaintainancePage.getTxt_Address2().clear();
		objParticipantMaintainancePage.getTxt_Address2().sendKeys(address2);

		// Edit Address line 3
		objParticipantMaintainancePage.getTxt_Address3().clear();
		objParticipantMaintainancePage.getTxt_Address3().sendKeys(address3);

		// Edit Zipcode
		objParticipantMaintainancePage.getTxt_Zip().clear();
		this.waitForAddressFormProcessing();
		objParticipantMaintainancePage.getTxt_Zip().sendKeys(zipCode);
		objParticipantMaintainancePage.getBtn_VerifyZipcode().click();
		this.waitForAddressFormProcessing();

		// Edit City
		if (!city.isEmpty()) {
			objParticipantMaintainancePage.getTxt_City().clear();
			objParticipantMaintainancePage.getTxt_City().sendKeys(city);
		}

		// Edit Address Notes
		objParticipantMaintainancePage.getTxt_AddressNotes().clear();
		objParticipantMaintainancePage.getTxt_AddressNotes().sendKeys(addressNotes);

	}

	// Check if primary address has correct information or not
	public boolean isPrimaryAddressIsCorrect(String addressType, String address1, String address2, String address3,
			String city, String state, String zipcode, String addressNotes) {
		boolean isCorrect = false;

		String xpath_PrimaryAdrInfo = "//div[@id='ctl00_body_ucFvParticipant_fvParticipant1_ucPartTabsItemTemplate_tcParticipantTabs_tpAddress_ucAddressRepeater_rAddress_ctl01_pnlItem']/span[contains(text(),'"
				+ addressType + "')]/../span[contains(text(),'" + address1 + "')]/../span[contains(text(),'" + address2
				+ "')]/../span[contains(text(),'" + address3 + "')]/../span[contains(text(),'" + city
				+ "')]/../span[contains(text(),'" + state + "')]/../span[contains(text(),'" + zipcode
				+ "')]/../span[contains(text(),'" + addressNotes + "')]";

		if (driver.findElement(By.xpath(xpath_PrimaryAdrInfo)).isDisplayed()) {
			isCorrect = true;
		}

		return isCorrect;
	}
}
