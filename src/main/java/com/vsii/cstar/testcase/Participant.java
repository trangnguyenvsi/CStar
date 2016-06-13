package com.vsii.cstar.testcase;

import org.testng.annotations.Test;

import com.vsii.cstar.pages.methods.AddParticipantPageMethod;
import com.vsii.cstar.pages.methods.HomePageMethods;
import com.vsii.cstar.pages.methods.LoginPageMethods;
import com.vsii.cstar.pages.methods.ParticipantMaintainancePageMethod;
import com.vsii.cstar.pages.methods.ParticipantSearchPageMethod;
import com.vsii.cstar.testdata.TestData;
import com.vsii.tsc.utility.CommonOperations;
import com.vsii.tsc.utility.TestBase;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Participant {
	public WebDriver driver;
	public LoginPageMethods objLoginPageMethods;
	public HomePageMethods objHomePageMethods;
	public ParticipantSearchPageMethod objParticipantSearchPageMethod;
	public AddParticipantPageMethod objAddParticipantPageMethod;
	public ParticipantMaintainancePageMethod objParticipantMaintainancePageMethod;
	static Properties p;
	public String participantID;

	@BeforeClass
	public void beforeClass() {
		driver = TestBase.driver;
		objLoginPageMethods = new LoginPageMethods(driver);
		objHomePageMethods = new HomePageMethods(driver);
		objParticipantSearchPageMethod = new ParticipantSearchPageMethod(driver);
		objAddParticipantPageMethod = new AddParticipantPageMethod(driver);
		objParticipantMaintainancePageMethod = new ParticipantMaintainancePageMethod(driver);

		// Login
		objLoginPageMethods.login(TestBase.userName, TestBase.password);
		objHomePageMethods.mouseHoverCallCenter();
		objHomePageMethods.selectSubMenuPariticipantMaintainance();

	}

	@Test(priority = 0, description = "Add new participant", dataProvider = "Add Participant", dataProviderClass = TestData.class)
	public void PM01(String salutation, String firstName, String MIName, String lastName, String suffix,
			String nickName, String DOB, String gender, String DNIS, String priorityCode, String VIP,
			String addressType, String address1, String address2, String address3, String zipCode, String addressNotes,
			String participantNotes, String phoneType, String phoneNo, String phoneExtension, String emailType,
			String email) {
		// Click to button Add new
		objParticipantSearchPageMethod.objParticipantSearchPage.getBtn_AddNew().click();

		// Enter valid data to form
		objAddParticipantPageMethod.addNewParticipant(salutation, firstName, MIName, lastName, suffix, nickName, DOB,
				gender, DNIS, priorityCode, VIP, addressType, address1, address2, address3, zipCode, addressNotes,
				participantNotes, phoneType, phoneNo, phoneExtension, emailType, email);

		// Get inputed value and set them to variables to verify later
		objAddParticipantPageMethod.objAddParticipantPage.setSalutation(salutation);
		objAddParticipantPageMethod.objAddParticipantPage.setFirstName(firstName);
		objAddParticipantPageMethod.objAddParticipantPage.setMIName(MIName);
		objAddParticipantPageMethod.objAddParticipantPage.setLastName(lastName);
		objAddParticipantPageMethod.objAddParticipantPage.setSuffix(suffix);
		objAddParticipantPageMethod.objAddParticipantPage.setNickName(nickName);
		objAddParticipantPageMethod.objAddParticipantPage.setDOB(DOB);
		objAddParticipantPageMethod.objAddParticipantPage
				.setAge(objAddParticipantPageMethod.objAddParticipantPage.getVal_Age().getText());
		objAddParticipantPageMethod.objAddParticipantPage.setGender(gender);
		objAddParticipantPageMethod.objAddParticipantPage.setDNIS(DNIS);
		objAddParticipantPageMethod.objAddParticipantPage.setPriorityCode(priorityCode);
		objAddParticipantPageMethod.objAddParticipantPage.setVIP(VIP);
		objAddParticipantPageMethod.objAddParticipantPage
				.setCountry(new Select(objAddParticipantPageMethod.objAddParticipantPage.getDdl_Countries())
						.getFirstSelectedOption().getText());
		objAddParticipantPageMethod.objAddParticipantPage.setAddressType(addressType);
		objAddParticipantPageMethod.objAddParticipantPage.setAddress1(address1);
		objAddParticipantPageMethod.objAddParticipantPage.setAddress2(address2);
		objAddParticipantPageMethod.objAddParticipantPage.setAddress3(address3);
		objAddParticipantPageMethod.objAddParticipantPage.setZipCode(zipCode);
		objAddParticipantPageMethod.objAddParticipantPage
				.setCity(objAddParticipantPageMethod.objAddParticipantPage.getTxt_City().getAttribute("value"));
		objAddParticipantPageMethod.objAddParticipantPage
				.setState(objAddParticipantPageMethod.objAddParticipantPage.getTxt_State().getAttribute("value"));
		objAddParticipantPageMethod.objAddParticipantPage.setAddressNote(addressNotes);
		objAddParticipantPageMethod.objAddParticipantPage.setParticipantNote(participantNotes);
		objAddParticipantPageMethod.objAddParticipantPage
				.setCountryCode(new Select(objAddParticipantPageMethod.objAddParticipantPage.getDdl_CountryCodes())
						.getFirstSelectedOption().getText());
		objAddParticipantPageMethod.objAddParticipantPage.setPhoneType(phoneType);
		objAddParticipantPageMethod.objAddParticipantPage.setPhoneNumber(phoneNo);
		objAddParticipantPageMethod.objAddParticipantPage.setPhoneExtension(phoneExtension);
		objAddParticipantPageMethod.objAddParticipantPage.setEmailType(emailType);
		objAddParticipantPageMethod.objAddParticipantPage.setEmail(email);

		// Click Save
		objAddParticipantPageMethod.objAddParticipantPage.getBtn_Save().click();

		// Get participant GUID from url
		participantID = driver.getCurrentUrl().split("id=")[1].split("&AddLead")[0];

		// After saving successfully, verify saved data is correct or not
		// Verify expected name should be in format salutation + first name + MI
		// name + last name + suffix
		Assert.assertEquals(objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Name().getText(),
				(objAddParticipantPageMethod.objAddParticipantPage.getSalutation() + " "
						+ objAddParticipantPageMethod.objAddParticipantPage.getFirstName() + " "
						+ objAddParticipantPageMethod.objAddParticipantPage.getMIName() + " "
						+ objAddParticipantPageMethod.objAddParticipantPage.getLastName() + " "
						+ objAddParticipantPageMethod.objAddParticipantPage.getSuffix()).replaceAll("\\s+", " ")
								.trim());

		// Verify nickname is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_NickName().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getNickName());

		// Verify DOB is correct or not
		Assert.assertEquals(objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_DOB().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getDOB());

		// Verify Age is correct or not
		Assert.assertEquals(objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Age().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getAge());

		// Verify gender should be M if participant is Male or F if participant
		// is Female
		if (objAddParticipantPageMethod.objAddParticipantPage.getGender().equals("Male")) {
			Assert.assertEquals(
					objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Gender().getText(), "M");
		} else {
			Assert.assertEquals(
					objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Gender().getText(), "F");
		}

		// Verify DNIS is correct or not
		Assert.assertEquals(objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_DNIS().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getDNIS());

		// Verify priority code is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_PriorityCode().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getPriorityCode());

		// Verify VIP is correct or not
		if (VIP.isEmpty()) {
			Assert.assertEquals(
					objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_VIP().getText(), "No");
		} else {
			Assert.assertEquals(
					objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_VIP().getText(), "Yes");
		}

		// Verify address type is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_AddressType().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getAddressType());

		// Verify address line 1 is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Address1().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getAddress1());

		// Verify address line 2 is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Address2().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getAddress2());

		// Verify address line 3 is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Address3().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getAddress3());

		// Verify city is correct or not
		Assert.assertEquals(objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_City().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getCity());

		// Verify state is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_State().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getState());

		// Verify zipcode is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Zipcode().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getZipCode());

		// Verify address note is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_AddressNote().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getAddressNote());

		// Verify phone type is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_PhoneType().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getPhoneType());

		// Verify phone no should correct and be leading with +(country code)
		String expected_PhoneNumber = "+" + objAddParticipantPageMethod.objAddParticipantPage.getCountryCode() + " "
				+ objAddParticipantPageMethod.objAddParticipantPage.getPhoneNumber();
		if (!objAddParticipantPageMethod.objAddParticipantPage.getPhoneExtension().isEmpty()) {
			expected_PhoneNumber = expected_PhoneNumber + " x: "
					+ objAddParticipantPageMethod.objAddParticipantPage.getPhoneExtension();
		}
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_PhoneNo().getText().trim(),
				expected_PhoneNumber);

		// Verify email type is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_EmailType().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getEmailType());

		// Verify email is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Email().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getEmail());

	}

	@Test(priority = 1, description = "Search participant by their phone")
	public void PM02() {
		// Select menu Participant Maintainance again
		objHomePageMethods.mouseHoverCallCenter();
		objHomePageMethods.selectSubMenuPariticipantMaintainance();

		// Search for created participant by its phone number
		objParticipantSearchPageMethod
				.searchByPhone(objAddParticipantPageMethod.objAddParticipantPage.getPhoneNumber());

		// Verify this participant should displayed on list when search
		// completed
		Assert.assertTrue(objParticipantSearchPageMethod.isParticipantVisibled(
				objAddParticipantPageMethod.objAddParticipantPage.getFirstName(),
				objAddParticipantPageMethod.objAddParticipantPage.getLastName(),
				objAddParticipantPageMethod.objAddParticipantPage.getPhoneNumber(),
				objAddParticipantPageMethod.objAddParticipantPage.getCity(),
				objAddParticipantPageMethod.objAddParticipantPage.getState(),
				objAddParticipantPageMethod.objAddParticipantPage.getZipCode()));

	}

	@Test(priority = 2, description = "select searched participant by his/her first and last name")
	public void PM03() {
		// Select created participant
		objParticipantSearchPageMethod.selectParticipantByName("tester", "mister");

		// Verify participant information again when select from Participant
		// Search screen
		// Verify expected name should be in format salutation + first name + MI
		// name + last name + suffix
		Assert.assertEquals(objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Name().getText(),
				(objAddParticipantPageMethod.objAddParticipantPage.getSalutation() + " "
						+ objAddParticipantPageMethod.objAddParticipantPage.getFirstName() + " "
						+ objAddParticipantPageMethod.objAddParticipantPage.getMIName() + " "
						+ objAddParticipantPageMethod.objAddParticipantPage.getLastName() + " "
						+ objAddParticipantPageMethod.objAddParticipantPage.getSuffix()).replaceAll("\\s+", " ")
								.trim());

		// Verify nickname is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_NickName().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getNickName());

		// Verify DOB is correct or not
		Assert.assertEquals(objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_DOB().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getDOB());

		// Verify Age is correct or not
		Assert.assertEquals(objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Age().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getAge());

		// Verify gender should be M if participant is Male or F if participant
		// is Female
		if (objAddParticipantPageMethod.objAddParticipantPage.getGender().equals("Male")) {
			Assert.assertEquals(
					objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Gender().getText(), "M");
		} else {
			Assert.assertEquals(
					objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Gender().getText(), "F");
		}

		// Verify DNIS is correct or not
		Assert.assertEquals(objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_DNIS().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getDNIS());

		// Verify priority code is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_PriorityCode().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getPriorityCode());

		// Verify VIP is correct or not
		if (objAddParticipantPageMethod.objAddParticipantPage.getVIP().equals("No")) {
			Assert.assertEquals(
					objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_VIP().getText(), "No");
		} else {
			Assert.assertEquals(
					objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_VIP().getText(), "Yes");
		}

		// Verify address type is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_AddressType().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getAddressType());

		// Verify address line 1 is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Address1().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getAddress1());

		// Verify address line 2 is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Address2().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getAddress2());

		// Verify address line 3 is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Address3().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getAddress3());

		// Verify city is correct or not
		Assert.assertEquals(objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_City().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getCity());

		// Verify state is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_State().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getState());

		// Verify zipcode is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Zipcode().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getZipCode());

		// Verify address note is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_AddressNote().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getAddressNote());

		// Verify phone type is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_PhoneType().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getPhoneType());

		// Verify phone no should correct and be leading with +(country code)
		String expected_PhoneNumber = "+" + objAddParticipantPageMethod.objAddParticipantPage.getCountryCode() + " "
				+ objAddParticipantPageMethod.objAddParticipantPage.getPhoneNumber();
		if (!objAddParticipantPageMethod.objAddParticipantPage.getPhoneExtension().isEmpty()) {
			expected_PhoneNumber = expected_PhoneNumber + " x: "
					+ objAddParticipantPageMethod.objAddParticipantPage.getPhoneExtension();
		}
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_PhoneNo().getText().trim(),
				expected_PhoneNumber);

		// Verify email type is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_EmailType().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getEmailType());

		// Verify email is correct or not
		Assert.assertEquals(
				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Email().getText(),
				objAddParticipantPageMethod.objAddParticipantPage.getEmail());

	}

//	@Test(priority = 3, description = "Edit Participant's informations", dataProvider = "Edit participant", dataProviderClass = TestData.class)
//	public void PM04(String salutation, String firstName, String MIName, String lastName, String suffix,
//			String nickName, String DOB, String gender, String VIP) {
//		// Click button Edit
//		objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getBtn_Edit().click();
//
//		// Edit participant informations
//		objAddParticipantPageMethod.editParticipantInformations(salutation, firstName, MIName, lastName, suffix,
//				nickName, DOB, gender, VIP);
//
//		// Get new participant information to verify them later
//		objAddParticipantPageMethod.objAddParticipantPage.setSalutation(salutation);
//		objAddParticipantPageMethod.objAddParticipantPage.setFirstName(firstName);
//		objAddParticipantPageMethod.objAddParticipantPage.setMIName(MIName);
//		objAddParticipantPageMethod.objAddParticipantPage.setLastName(lastName);
//		objAddParticipantPageMethod.objAddParticipantPage.setSuffix(suffix);
//		objAddParticipantPageMethod.objAddParticipantPage.setNickName(nickName);
//		objAddParticipantPageMethod.objAddParticipantPage.setDOB(DOB);
//		objAddParticipantPageMethod.objAddParticipantPage
//				.setAge(objAddParticipantPageMethod.objAddParticipantPage.getVal_Age().getText());
//		objAddParticipantPageMethod.objAddParticipantPage.setGender(gender);
//		objAddParticipantPageMethod.objAddParticipantPage.setVIP(VIP);
//
//		// Click Save to completed edit participant informations
//		objAddParticipantPageMethod.objAddParticipantPage.getBtn_SaveEditedInformation().click();
//
//		// Verify participant informations after update successfully
//		// Verify expected name should be in format salutation + first name + MI
//		// name + last name + suffix
//		Assert.assertEquals(objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Name().getText(),
//				(objAddParticipantPageMethod.objAddParticipantPage.getSalutation() + " "
//						+ objAddParticipantPageMethod.objAddParticipantPage.getFirstName() + " "
//						+ objAddParticipantPageMethod.objAddParticipantPage.getMIName() + " "
//						+ objAddParticipantPageMethod.objAddParticipantPage.getLastName() + " "
//						+ objAddParticipantPageMethod.objAddParticipantPage.getSuffix()).replaceAll("\\s+", " ")
//								.trim());
//
//		// Verify nickname is correct or not
//		Assert.assertEquals(
//				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_NickName().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getNickName());
//
//		// Verify DOB is correct or not
//		Assert.assertEquals(objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_DOB().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getDOB());
//
//		// Verify Age is correct or not
//		Assert.assertEquals(objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Age().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getAge());
//
//		// Verify gender should be M if participant is Male or F if participant
//		// is Female
//		if (objAddParticipantPageMethod.objAddParticipantPage.getGender().equals("Male")) {
//			Assert.assertEquals(
//					objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Gender().getText(), "M");
//		} else {
//			Assert.assertEquals(
//					objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Gender().getText(), "F");
//		}
//
//		// Verify DNIS is correct or not
//		Assert.assertEquals(objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_DNIS().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getDNIS());
//
//		// Verify priority code is correct or not
//		Assert.assertEquals(
//				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_PriorityCode().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getPriorityCode());
//
//		// Verify VIP is correct or not
//		if (objAddParticipantPageMethod.objAddParticipantPage.getVIP().equals("No")) {
//			Assert.assertEquals(
//					objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_VIP().getText(), "No");
//		} else {
//			Assert.assertEquals(
//					objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_VIP().getText(), "Yes");
//		}
//
//		// Verify address type is correct or not
//		Assert.assertEquals(
//				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_AddressType().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getAddressType());
//
//		// Verify address line 1 is correct or not
//		Assert.assertEquals(
//				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Address1().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getAddress1());
//
//		// Verify address line 2 is correct or not
//		Assert.assertEquals(
//				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Address2().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getAddress2());
//
//		// Verify address line 3 is correct or not
//		Assert.assertEquals(
//				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Address3().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getAddress3());
//
//		// Verify city is correct or not
//		Assert.assertEquals(objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_City().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getCity());
//
//		// Verify state is correct or not
//		Assert.assertEquals(
//				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_State().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getState());
//
//		// Verify zipcode is correct or not
//		Assert.assertEquals(
//				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Zipcode().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getZipCode());
//
//		// Verify address note is correct or not
//		Assert.assertEquals(
//				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_AddressNote().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getAddressNote());
//
//		// Verify phone type is correct or not
//		Assert.assertEquals(
//				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_PhoneType().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getPhoneType());
//
//		// Verify phone no should correct and be leading with +(country code)
//		String expected_PhoneNumber = "+" + objAddParticipantPageMethod.objAddParticipantPage.getCountryCode() + " "
//				+ objAddParticipantPageMethod.objAddParticipantPage.getPhoneNumber();
//		if (!objAddParticipantPageMethod.objAddParticipantPage.getPhoneExtension().isEmpty()) {
//			expected_PhoneNumber = expected_PhoneNumber + " x: "
//					+ objAddParticipantPageMethod.objAddParticipantPage.getPhoneExtension();
//		}
//		Assert.assertEquals(
//				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_PhoneNo().getText().trim(),
//				expected_PhoneNumber);
//
//		// Verify email type is correct or not
//		Assert.assertEquals(
//				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_EmailType().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getEmailType());
//
//		// Verify email is correct or not
//		Assert.assertEquals(
//				objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getVal_Email().getText(),
//				objAddParticipantPageMethod.objAddParticipantPage.getEmail());
//	}

	@Test(priority=4, description = "Edit Participant Current Address")
	public void editCurrentAddress() {
		// TODO put your code here
		// Click to tab Address
		objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getTab_Address().click();

		// Click edit current address
		objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getLnk_EditCurrentAddress().click();
		
		//Wait for address form is display
		objParticipantMaintainancePageMethod.waitForAddressFormDisplay();

		// Edit data of current address
		objParticipantMaintainancePageMethod.enterDataToAddressForm("Office", "Address line 1 - edited",
				"Address line 2 - edited", "Address line 2 - edited", "10001", "Ha Noi", "New address note");

		// Click Save Address
		objParticipantMaintainancePageMethod.objParticipantMaintainancePage.getBtn_SaveAddress().click();

		// Wait for Save
		objParticipantMaintainancePageMethod.waitForAddressFormProcessing();
		
		//Verify edited Address
		
	}

	// @Test(description = "Insert new address and make it primary")
	// public void addNewAddress() {
	// // TODO put your code here
	// }
	//
	// @Test(description = "Edit Current Phone")
	// public void editCurrentPhone() {
	// // TODO put your code here
	// }
	//
	// @Test(description = "Add new Phone and make it is primary")
	// public void addNewPhone() {
	// // TODO put your code here
	// }
	//
	// @Test(description = "Edit current email")
	// public void editCurrentEmail() {
	// // TODO put your code here
	// }
	//
	// @Test(description = "add new Email and make it as primary")
	// public void addNewEmail() {
	// // TODO put your code here
	// }
	//
	// @Test(description = "Edit Opt In/Out")
	// public void editOpt() {
	// // TODO put your code here
	// }
	//
	// @Test(description = "add or update Indentification")
	// public void updateIndentification() {
	// // TODO put your code here
	// }

	@AfterClass
	public void afterClass() throws InterruptedException, IOException {

		String deleteParticipant = "DECLARE @participantGUID UNIQUEIDENTIFIER " + "DECLARE @adrGroup INT "
				+ "DECLARE @phoneGroup INT " + "DECLARE @internetGroup INT " + "DECLARE @noteGroup INT "
				+ "SET @participantGUID='" + participantID + "' "
				+ "SET @adrGroup = (select Address_Group_ID from PL_Participants where Participant_GUID=@participantGUID) "
				+ "SET @phoneGroup = (select Phone_Group_ID from PL_Participants where Participant_GUID=@participantGUID) "
				+ "SET @internetGroup = (select Internet_Group_ID from PL_Participants where Participant_GUID=@participantGUID) "
				+ "SET @noteGroup = (select Note_Group_ID from PL_Participants where Participant_GUID=@participantGUID) "
				+ "DELETE PL_Participants where Participant_GUID=@participantGUID "
				+ "DELETE PL_Addresses_Participants where Address_Group_ID=@adrGroup "
				+ "DELETE PL_Address_Groups where Address_Group_ID=@adrGroup "
				+ "DELETE PL_Phone_Numbers where Phone_Group_ID=@phoneGroup "
				+ "DELETE PL_Phone_Groups where Phone_Group_ID=@phoneGroup "
				+ "DELETE PL_Internet_Text where Internet_Group_ID=@internetGroup "
				+ "DELETE PL_Internet_Groups where Internet_Group_ID=@internetGroup "
				+ "DELETE CC_Notes where Note_Group_ID=@noteGroup "
				+ "DELETE CC_Note_Groups WHERE Note_Group_ID=@noteGroup";

		// Defind connection string
		p = CommonOperations.readConfig();
		Connection conn = null;
		@SuppressWarnings("unused")
		ResultSet rs = null;
		Statement stmt = null;
		// String sqlCommand;

		// Defining the SQL URL
		String dbAddress = p.getProperty("SQLServer_address");
		String dbName = p.getProperty("SQLServer_dbName");
		String user = p.getProperty("SQLServer_user");
		String pwd = p.getProperty("SQLServer_pwd");

		// Driver of SQLServer
		String driver1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connection = "jdbc:sqlserver://" + dbAddress + ";databaseName=" + dbName + ";user=" + user + ";password="
				+ pwd;

		// Delete
		try {
			// Loading the driver and creating its instance
			Class.forName(driver1).newInstance();
			// Establishing the connection with the database

			conn = DriverManager.getConnection(connection);
			/*
			 * createStatement() method creates a Statement object for sending
			 * SQL to the database. It executes the SQL and returns the result
			 * it produces
			 */
			stmt = conn.createStatement();
			/*
			 * executeQuery() method executes the SQL statement which returns a
			 * single ResultSet type object.
			 */
			stmt.execute(deleteParticipant);
		} catch (Exception e) {
			System.out.println("Couldn't connect to DB");
			System.out.print(e);

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Couldn't close connection");
				System.out.print(e);
			}
		}

		driver.quit();
	}
}
