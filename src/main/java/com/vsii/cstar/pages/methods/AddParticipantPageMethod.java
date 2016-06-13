package com.vsii.cstar.pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vsii.cstar.pages.AddParticipantPage;

public class AddParticipantPageMethod {
	public WebDriver driver;
	public AddParticipantPage objAddParticipantPage = new AddParticipantPage();

	public AddParticipantPageMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objAddParticipantPage);
	}

	// Locate dropdown by element
	public Select locateDropdown(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	// Add Participant
	public void addNewParticipant(String salutation, String firstName, String MIName, String lastName, String suffix,
			String nickName, String DOB, String gender, String DNIS, String priorityCode, String VIP,
			String addressType, String address1, String address2, String address3, String zipCode, String addressNotes,
			String participantNotes, String phoneType, String phoneNo, String phoneExtension, String emailType,
			String email) {
		// Select salutation if testdata has value
		if (!salutation.isEmpty()) {
			this.locateDropdown(objAddParticipantPage.getDdl_Salutations()).selectByVisibleText(salutation);
		}

		// Enter first name
		objAddParticipantPage.getTxt_FirstName().sendKeys(firstName);

		// Enter MI name
		objAddParticipantPage.getTxt_MIName().sendKeys(MIName);

		// Enter Last Name
		objAddParticipantPage.getTxt_LastName().sendKeys(lastName);

		// Select suffix if testdata has value, else leave it empty
		if (!suffix.isEmpty()) {
			this.locateDropdown(objAddParticipantPage.getDdl_Suf()).selectByVisibleText(suffix);
		}

		// Enter nick name
		objAddParticipantPage.getTxt_NickName().sendKeys(nickName);

		// Select DOB by input to textbox
		objAddParticipantPage.getTxt_DOB().sendKeys(DOB);
		objAddParticipantPage.getLbl_DOB().click();

		// Select Gender
		this.locateDropdown(objAddParticipantPage.getDdl_Gender()).selectByVisibleText(gender);

		// Enter DNIS
		objAddParticipantPage.getLnk_selectDNIS().click();
		String xpath_valDNIS = "//div[@id='ctl00_body_ucFvParticipant_fvParticipant1_ctlDNIS_cbDnis_DropDown']/div/ul[@class='rcbList']/li[contains(text(),'"
				+ DNIS + "')]";
		driver.findElement(By.xpath(xpath_valDNIS)).click();

		// objAddParticipantPage.getTxt_DNIS().sendKeys(DNIS);
		// objAddParticipantPage.getLbl_DNIS().click();

		// Enter prioriry code
		objAddParticipantPage.getTxt_PrioriryCode().sendKeys(priorityCode);

		// Choose VIP
		if (!VIP.isEmpty()) {
			this.locateDropdown(objAddParticipantPage.getDdl_Vip()).selectByVisibleText(VIP);
		}

		// Select Address Type
		this.locateDropdown(objAddParticipantPage.getDdl_AddressTypes()).selectByVisibleText(addressType);

		// Enter Address Line 1
		objAddParticipantPage.getTxt_AddressLine1().sendKeys(address1);

		// Enter Address Line 2
		objAddParticipantPage.getTxt_AddressLine2().sendKeys(address2);

		// Enter Address Line 3
		objAddParticipantPage.getTxt_AddressLine3().sendKeys(address3);

		// Enter Zip Code
		objAddParticipantPage.getTxt_Zip().sendKeys(zipCode);

		// Verify Zipcode
		objAddParticipantPage.getBtn_VerifyZipcode().click();

		// Enter Address Note
		objAddParticipantPage.getTxt_AddressNotes().sendKeys(addressNotes);

		// Enter Participant Note
		objAddParticipantPage.getTxt_ParticipantNotes().sendKeys(participantNotes);

		// Select Phone Type
		if (!phoneType.isEmpty()) {
			this.locateDropdown(objAddParticipantPage.getDdl_PhoneTypes()).selectByVisibleText(phoneType);
		}

		// Enter phone number
		objAddParticipantPage.getTxt_PhoneNumber().click();
		objAddParticipantPage.getTxt_PhoneNumber().clear();
		objAddParticipantPage.getTxt_PhoneNumber().sendKeys(phoneNo);

		// Enter phone extension
		objAddParticipantPage.getTxt_PhoneExtension().sendKeys(phoneExtension);

		// Select email type
		if (!emailType.isEmpty()) {
			this.locateDropdown(objAddParticipantPage.getDdl_EmailTypes()).selectByVisibleText(emailType);
		}

		// Enter email address
		objAddParticipantPage.getTxt_EmailAddress().sendKeys(email);

		// Click button Save
		// objAddParticipantPage.getBtn_Save().click();
	}

	// Edit participant informations
	public void editParticipantInformations(String salutation, String firstName, String MIName, String lastName,
			String suffix, String nickName, String DOB, String gender, String VIP) {
		// Select salutation
		if (!salutation.isEmpty()) {
			this.locateDropdown(objAddParticipantPage.getDdl_Salutations()).selectByVisibleText(salutation);
		}

		// Enter first name
		objAddParticipantPage.getTxt_FirstName().clear();
		objAddParticipantPage.getTxt_FirstName().sendKeys(firstName);

		// Enter MI name
		objAddParticipantPage.getTxt_MIName().clear();
		objAddParticipantPage.getTxt_MIName().sendKeys(MIName);

		// Enter Last Name
		objAddParticipantPage.getTxt_LastName().clear();
		objAddParticipantPage.getTxt_LastName().sendKeys(lastName);

		// Select suffix if testdata has value, else leave it empty
		if (!suffix.isEmpty()) {
			this.locateDropdown(objAddParticipantPage.getDdl_Suf()).selectByVisibleText(suffix);
		}

		// Enter nick name
		objAddParticipantPage.getTxt_NickName().clear();
		objAddParticipantPage.getTxt_NickName().sendKeys(nickName);

		// Select DOB by input to textbox
		objAddParticipantPage.getTxt_DOB().clear();
		objAddParticipantPage.getTxt_DOB().sendKeys(DOB);
		objAddParticipantPage.getLbl_DOB().click();

		// Select Gender
		this.locateDropdown(objAddParticipantPage.getDdl_Gender()).selectByVisibleText(gender);

		
		// objAddParticipantPage.getTxt_DNIS().sendKeys(DNIS);
		// objAddParticipantPage.getLbl_DNIS().click();


		// Choose VIP
		if (!VIP.isEmpty()) {
			this.locateDropdown(objAddParticipantPage.getDdl_Vip()).selectByVisibleText(VIP);
		}
	}
}
