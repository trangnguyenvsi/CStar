package com.vsii.cstar.testcase;

import org.testng.annotations.Test;

import com.vsii.cstar.pages.methods.HomePageMethods;
import com.vsii.cstar.pages.methods.LoginPageMethods;
import com.vsii.cstar.pages.methods.ScreeningMaintainanceMethods;
import com.vsii.cstar.pages.methods.TeamCalendarMethods;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class UpdateSiteInfo {
	WebDriver driver;
	LoginPageMethods objLoginPageMethod;
	HomePageMethods objHomepageMethod;
	TeamCalendarMethods objTeamCalendarMethod;
	ScreeningMaintainanceMethods objScreeningMaintainanceMethod;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		objLoginPageMethod = new LoginPageMethods(driver);
		objHomepageMethod = new HomePageMethods(driver);
		objTeamCalendarMethod = new TeamCalendarMethods(driver);
		objScreeningMaintainanceMethod = new ScreeningMaintainanceMethods(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://172.17.60.220:888/Login.aspx");
		driver.manage().window().maximize();
	}

	@Test
	public void f() {
		objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com", "Thanhvc123@");
		// Select menu Team Calendar & Grid
		objHomepageMethod.mouseHoverScreeningConfig();
		objHomepageMethod.selectSubMenuTeamCalendar();
		// Choose filter
		objTeamCalendarMethod.selectMonth("April");
		objTeamCalendarMethod.selectTeam("CLV - Cleveland");
		// Select existing screening by its name
		objTeamCalendarMethod.selectExistingScreening("St Stephen Church");

		// Get check status of 1st checkbox before check it

		Boolean result = false;
		try {
			if (objScreeningMaintainanceMethod.getCheckStatus() != null) {
				result = true;
			}
		} catch (Exception e) {
		}

		// Define expected result when knowing check status after checked
		String expectedResult = "Null";
		if (result == true) {
			expectedResult = "unchecked";
		} else {
			expectedResult = "checked";
		}

		System.out.println("Expected:  " + expectedResult);

		// Check to checkbox
		objScreeningMaintainanceMethod.checkSiteRequirements();
		
		//Enter text to Notes field
		boolean isModified1;
		if(objScreeningMaintainanceMethod.getNoteToUltraSoundTeam().equals("Some note to Ultrasound Team")){
			objScreeningMaintainanceMethod.clearNoteToUltraSoundTeam();
			objScreeningMaintainanceMethod.sendNoteToUltraSoundTeam("Some note to Ultrasound Team - Modified");
			isModified1=true;
		}
		else {
			objScreeningMaintainanceMethod.clearNoteToUltraSoundTeam();
			objScreeningMaintainanceMethod.sendNoteToUltraSoundTeam("Some note to Ultrasound Team");	
			isModified1=false;
		}
		
		boolean isModified2;
		if(objScreeningMaintainanceMethod.getNoteToCallCenter().equals("Some note to Call Center")){
			objScreeningMaintainanceMethod.clearNoteToCallCenter();
			objScreeningMaintainanceMethod.sendNoteToCallCenter("Some note to Call Center - Modified");
			isModified2=true;
		}
		else {
			objScreeningMaintainanceMethod.clearNoteToCallCenter();
			objScreeningMaintainanceMethod.sendNoteToCallCenter("Some note to Call Center");
			isModified2=false;
		}
		
		//Save & continue to Screening
		objScreeningMaintainanceMethod.saveAndContinueAtSiteInfoTab();

		// Wait for loading progress icon is disappeared
		objScreeningMaintainanceMethod.waitForPageToLoad(30);
		// Reload page
		driver.navigate().refresh();

		// Verify checkbox is checked or not
		objScreeningMaintainanceMethod.selectSiteInfoTab();
		Boolean result2 = false;
		try {
			if (objScreeningMaintainanceMethod.getCheckStatus() != null) {
				result2 = true;
			}
		} catch (Exception e) {
		}
		String actualResult = "Null";
		if (result2 == true) {
			actualResult = "checked";
		} else {
			actualResult = "unchecked";
		}
		System.out.println("Actual:  " + actualResult);

		Assert.assertEquals(actualResult, expectedResult);

		//Verify notes entered (automate) is correct or not
		if(isModified1==true){
			Assert.assertEquals(objScreeningMaintainanceMethod.getNoteToUltraSoundTeam(), "Some note to Ultrasound Team - Modified");
		}
		else {
			Assert.assertEquals(objScreeningMaintainanceMethod.getNoteToUltraSoundTeam(), "Some note to Ultrasound Team");
		}
		
		if(isModified2==true){
			Assert.assertEquals(objScreeningMaintainanceMethod.getNoteToCallCenter(), "Some note to Call Center - Modified");
		}
		else {
			Assert.assertEquals(objScreeningMaintainanceMethod.getNoteToCallCenter(), "Some note to Call Center");
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
