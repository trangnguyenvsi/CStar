package com.vsii.cstar.testdata;

import org.testng.annotations.DataProvider;

import com.vsii.tsc.utility.ExcelHandle;

public class AddScreening {
	@DataProvider(name="Choose setup screening kind")
	public static Object[][] chooseSetupScreeningKind() {
		Object[][] data = ExcelHandle.getTable("./data/AddScreening.xlsx", "TeamCalendar", "TS01");
		return data;
	}
	
	@DataProvider(name="VerifyZipCode")
	public static Object[][] verifyZipcode() {
		Object[][] data = ExcelHandle.getTable("./data/AddScreening.xlsx", "TeamCalendar", "TS09");
		return data;
	}
	
	@DataProvider(name="Existing Site")
	public static Object[][] existingSite() {
		Object[][] data = ExcelHandle.getTable("./data/AddScreening.xlsx", "TeamCalendar", "TS10");
		return data;
	}
	
	@DataProvider(name="Validation Address")
	public static Object[][] validationAddress() {
		Object[][] data = ExcelHandle.getTable("./data/AddScreening.xlsx", "TeamCalendar", "TS12");
		return data;
	}
	
	@DataProvider(name="CreateNewSite")
	public static Object[][] takeappointment() {
		Object[][] data = ExcelHandle.getTable("./data/AddScreening.xlsx", "TeamCalendar", "TS13");
		return data;
	}
	
	@DataProvider(name="ACO Type Verification")
	public static Object[][] verifyACOTypeDropdown() {
		Object[][] data = ExcelHandle.getTable("./data/AddScreening.xlsx", "TeamCalendar", "TS14");
		return data;
	}
	
	@DataProvider(name="ScreeningInfoData")
	public static Object[][] takeappointment3() {
		Object[][] data = ExcelHandle.getTable("./data/AddScreening.xlsx", "TeamCalendar", "TS15");
		return data;
	}
	
	//TODO Testdata for testcase Participant
	@DataProvider(name="Add Participant")
	public static Object[][] addParticipant() {
		Object[][] data = ExcelHandle.getTable("./data/Participant.xlsx", "Participant", "PM01");
		return data;
	}
	
	@DataProvider(name="Edit participant")
	public static Object[][] editParticipant() {
		Object[][] data = ExcelHandle.getTable("./data/Participant.xlsx", "Participant", "PM04");
		return data;
	}
}
