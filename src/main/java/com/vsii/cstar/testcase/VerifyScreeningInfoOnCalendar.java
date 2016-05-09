package com.vsii.cstar.testcase;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vsii.cstar.pages.methods.AppointmentsSingleScreeningPageMethod;
import com.vsii.cstar.pages.methods.HomePageMethods;
import com.vsii.cstar.pages.methods.LoginPageMethods;
import com.vsii.cstar.pages.methods.PackagePageMethod;
import com.vsii.cstar.pages.methods.ProductPageMethod;
import com.vsii.cstar.pages.methods.ProductSetPageMethod;
import com.vsii.cstar.pages.methods.ScreeningMaintainanceMethods;
import com.vsii.cstar.pages.methods.TeamCalendarMethods;

public class VerifyScreeningInfoOnCalendar {
	WebDriver driver;
	LoginPageMethods objLoginPageMethod;
	HomePageMethods objHomepageMethod;
	TeamCalendarMethods objTeamCalendarMethod;
	ScreeningMaintainanceMethods objScreeningMaintainanceMethod;
	AppointmentsSingleScreeningPageMethod objAptSingleScreenMethod;
	ProductSetPageMethod objProductSetMethod;
	ProductPageMethod objProductPageMethod;
	PackagePageMethod objPackagePageMethod;

	@BeforeClass
	public void start() {
		driver = new FirefoxDriver();
		objLoginPageMethod = new LoginPageMethods(driver);
		objHomepageMethod = new HomePageMethods(driver);
		objTeamCalendarMethod = new TeamCalendarMethods(driver);
		objScreeningMaintainanceMethod = new ScreeningMaintainanceMethods(driver);
		objAptSingleScreenMethod = new AppointmentsSingleScreeningPageMethod(driver);
		objProductSetMethod = new ProductSetPageMethod(driver);
		objProductPageMethod = new ProductPageMethod(driver);
		objPackagePageMethod = new PackagePageMethod(driver);

		// Setup browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://172.17.60.220:888/Login.aspx");
		driver.manage().window().maximize();
	}

	@Test
	public void t() throws InterruptedException, ParseException, IOException, SQLException {
		//Define input data
		String input_Month="April";
		String input_Date="4/5/2016";
		String input_Team="HOU - Houston";

		// Login to System
		objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com", "Thanhvc123@");
		
		// Select menu Team Calendar & Grid
		objHomepageMethod.mouseHoverScreeningConfig();
		objHomepageMethod.selectSubMenuTeamCalendar();
		
		// Choose filter
		objTeamCalendarMethod.selectMonth(input_Month);
		objTeamCalendarMethod.selectTeam(input_Team);
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_imgLoading")));
		
		//Get screening information on calendar
		String actual_ScreeningName=objTeamCalendarMethod.getScreeningName(input_Date);
		String actual_ScreeningTerritoty = objTeamCalendarMethod.getScreeningZipCode(input_Date);
		String actual_ScreeningRepresentative=objTeamCalendarMethod.getScreeningRepresentative(input_Date);
		String actual_ScreeningStatus= objTeamCalendarMethod.getScreeningStatus(input_Date);
		String actual_ScreeningDriveType = objTeamCalendarMethod.getScreeningDriveType(input_Date);
		
		//Go to screening and get all relate information
		objTeamCalendarMethod.selectScreeningByInputDate(input_Date);
		
		//Get Screening Name on Screening Maintainance Screen
		String expected_ScreeingName = objScreeningMaintainanceMethod.getScreeningName();
		
		//Get Screening Territory & Zip code on Screening Maintainance Screen
		String expected_ScreeingTerritory = objScreeningMaintainanceMethod.getScreeningTerritory().replace(",", "").split("-")[0];

		//Get screening representative on Screening Maintainance Screen
		String[] tmp_RepreName = objScreeningMaintainanceMethod.getScreeningRepresentative().split(", ");;
		String Fname = tmp_RepreName[0];
		String Lname = tmp_RepreName[1];
		String expected_ScreeningRepresentative=Lname+ " " +Fname;
		
		//Get screening Status & schedule code/time on Screening Maintainance Screen
		String scStatus = objScreeningMaintainanceMethod.getScreeningStatus();
		String scheduleCode= objScreeningMaintainanceMethod.getScreeningScheduleCode();
		String scheduleStartTime = objScreeningMaintainanceMethod.getScreeningScheduleTime().split(" - ")[0];
		String timeZone = objScreeningMaintainanceMethod.getScreeningTimeZone();
		String expected_ScreeningStatus=scStatus+ " " +scheduleCode+ " " +scheduleStartTime+ " " +timeZone;
		
		//Get screening drive type and drive time on Screening Maintainance Screen
		String driveTimeInMin = objScreeningMaintainanceMethod.getScreeningDriveTime().split(" \\(")[0];
		String expected_ScreeningDriveType=
				objScreeningMaintainanceMethod.getScreeningDriveType() + " " + driveTimeInMin;
		
			
		//Compare Screening information in both calendar and screening maintainance screen
		Assert.assertEquals(actual_ScreeningName, expected_ScreeingName);
		Assert.assertEquals(actual_ScreeningTerritoty, expected_ScreeingTerritory);
		Assert.assertEquals(actual_ScreeningRepresentative, expected_ScreeningRepresentative);
		Assert.assertEquals(actual_ScreeningStatus, expected_ScreeningStatus);
		Assert.assertEquals(actual_ScreeningDriveType, expected_ScreeningDriveType);
	}

	@AfterClass
	public void end() throws InterruptedException {
		// Thread.sleep(6000);
		driver.quit();
	}
}
