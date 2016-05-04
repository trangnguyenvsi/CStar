package com.vsii.cstar.testdata;

import org.testng.annotations.DataProvider;

import com.vsii.tsc.utility.ExcelHandle;;

public class TestData {
	@DataProvider(name="takeappointment")
	public static Object[][] takeappointment() {
		Object[][] data = ExcelHandle.getTable("./data/TestData.xlsx", "TeamCalendar", "TC02");
		return data;
	}
	
	
}
