package com.vsii.cstar.pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vsii.cstar.pages.ParticipantSearchPage;

public class ParticipantSearchPageMethod {
	WebDriver driver;
	public ParticipantSearchPage objParticipantSearchPage = new ParticipantSearchPage();

	public ParticipantSearchPageMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objParticipantSearchPage);
	}

	// Send key to textbox
	public void enter_TextToTextbox(WebElement element, String text) {
		// element.clear();
		element.sendKeys(text);
	}

	// Click to button
	public void click_ToButton(WebElement element) {
		element.click();
	}

	// Select checkbox
	public void select_Checkbox(WebElement elements) {
		if (elements.getAttribute("checked") == null) {
			elements.click();
		}
	}

	// De-Select checkbox
	public void deselect_Checkbox(WebElement elements) {
		if (elements.getAttribute("checked") != null) {
			elements.click();
		}
	}

	// Select dropdown list by visible text
	public void select_ValueInDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	// Search participant by phone
	public void searchByPhone(String phone) {
		// Enter phone
		objParticipantSearchPage.getTxt_TelephoneNumber().click();
		objParticipantSearchPage.getTxt_TelephoneNumber().clear();
		objParticipantSearchPage.getTxt_TelephoneNumber().sendKeys(phone);

		// Click button Search
		this.click_ToButton(objParticipantSearchPage.getBtn_PhoneSearch());
	}

	// Select searched participant by first name and last name
	public void selectParticipantByName(String FName, String LName) {
		String xpath_participant = "//td[preceding-sibling::td/span[contains(text(),'" + FName
				+ "')]][1]/span[contains(text(),'" + LName + "')]";
		driver.findElement(By.xpath(xpath_participant)).click();
	}

	// Check if participant is displayed in list or not
	public boolean isParticipantVisibled(String firstName, String lastName, String telephoneNo, String city, String state,
			String zipcode) {
		
		boolean isVisibled = false;
		
		String xpath_participant = "//td/span[contains(text(),'" + firstName + "')]/../../td/span[contains(text(),'"
				+ lastName + "')]/../../td/span[contains(text(),'" + telephoneNo + "')]/../../td/span[contains(text(),'"
				+ city + "')]/../../td/span[contains(text(),'" + state + "')]/../../td/span[contains(text(),'" + zipcode
				+ "')]";
		
		if (driver.findElement(By.xpath(xpath_participant)).isDisplayed()) {
			isVisibled=true;
		}
		
		return isVisibled;
	}

}
