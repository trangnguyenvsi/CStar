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
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vsii.cstar.common.methods.CommonMethod;
import com.vsii.cstar.pages.methods.AppointmentsSingleScreeningPageMethod;
import com.vsii.cstar.pages.methods.HomePageMethods;
import com.vsii.cstar.pages.methods.LoginPageMethods;
import com.vsii.cstar.pages.methods.PackagePageMethod;
import com.vsii.cstar.pages.methods.ProductPageMethod;
import com.vsii.cstar.pages.methods.ProductSetPageMethod;
import com.vsii.cstar.pages.methods.ScreeningMaintainanceMethods;
import com.vsii.cstar.pages.methods.TeamCalendarMethods;
import com.vsii.tsc.utility.CommonOperations;
import com.vsii.tsc.utility.TestBase;

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
	public void start() throws IOException, InterruptedException {
//		driver = new FirefoxDriver();
		driver = TestBase.driver;
		objLoginPageMethod = new LoginPageMethods(driver);
		objHomepageMethod = new HomePageMethods(driver);
		objTeamCalendarMethod = new TeamCalendarMethods(driver);
		objScreeningMaintainanceMethod = new ScreeningMaintainanceMethods(driver);
		objAptSingleScreenMethod = new AppointmentsSingleScreeningPageMethod(driver);
		objProductSetMethod = new ProductSetPageMethod(driver);
		objProductPageMethod = new ProductPageMethod(driver);
		objPackagePageMethod = new PackagePageMethod(driver);
		
		// Login to System
		
//		driver.get(CommonOperations.readConfig().getProperty("baseUrl"));
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

	}

	@Test(priority = 0, description = "Verify Teams have screening on a specific date")
	public void TC01() throws InterruptedException, ParseException, IOException, SQLException {
		// Define input data
		TestBase.methodName = "TC01";
		
		String input_Date = "2016-04-15 00:00:00";
		String input_Month = CommonMethod.getMonthBaseOnInputDate(input_Date);
		System.out.println(input_Month);
		String input_Team = "ACE - ACO - East";
		System.out.println(input_Team);
		
		objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com", "Thanhvc123@");

		// Select menu Team Calendar & Grid
		objHomepageMethod.mouseHoverScreeningConfig();
		objHomepageMethod.selectSubMenuTeamCalendar();

		// Choose filter
		objTeamCalendarMethod.selectMonth(input_Month);
		objTeamCalendarMethod.selectTeam(input_Team);
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_imgLoading")));

		// Get screening information on calendar
		String actual_ScreeningName = objTeamCalendarMethod.getScreeningName(input_Date);
		String actual_ScreeningTerritoty = objTeamCalendarMethod.getScreeningZipCode(input_Date);
		String actual_ScreeningRepresentative = objTeamCalendarMethod.getScreeningRepresentative(input_Date);
		String actual_ScreeningStatus = objTeamCalendarMethod.getScreeningStatus(input_Date);
		String actual_ScreeningDriveType = objTeamCalendarMethod.getScreeningDriveType(input_Date);

		// Go to screening and get all relate information
		objTeamCalendarMethod.selectScreeningByInputDate(input_Date);

		// Get Screening Name on Screening Maintainance Screen
		String expected_ScreeingName = objScreeningMaintainanceMethod.getScreeningName();

		// Get Screening Territory & Zip code on Screening Maintainance Screen
		String expected_ScreeingTerritory = objScreeningMaintainanceMethod.getScreeningTerritory().replace(",", "")
				.split("-")[0];

		// Get screening representative on Screening Maintainance Screen
		String[] tmp_RepreName = objScreeningMaintainanceMethod.getScreeningRepresentative().split(", ");
		;
		String Fname = tmp_RepreName[0];
		String Lname = tmp_RepreName[1];
		String expected_ScreeningRepresentative = Lname + " " + Fname;

		// Get screening Status & schedule code/time on Screening Maintainance
		// Screen
		String scStatus = objScreeningMaintainanceMethod.getScreeningStatus();
		String scheduleCode = objScreeningMaintainanceMethod.getScreeningScheduleCode();
		String scheduleStartTime = objScreeningMaintainanceMethod.getScreeningScheduleTime().split(" - ")[0];
		String timeZone = objScreeningMaintainanceMethod.getScreeningTimeZone();
		String expected_ScreeningStatus = scStatus + " " + scheduleCode + " " + scheduleStartTime + " " + timeZone;

		// Get screening drive type and drive time on Screening Maintainance
		// Screen
		String driveTimeInMin = objScreeningMaintainanceMethod.getScreeningDriveTime().split(" \\(")[0];
		String expected_ScreeningDriveType = objScreeningMaintainanceMethod.getScreeningDriveType() + " "
				+ driveTimeInMin;

		// Compare Screening information in both calendar and screening
		// maintainance screen
		Assert.assertEquals(actual_ScreeningName, expected_ScreeingName);
		Assert.assertEquals(actual_ScreeningTerritoty, expected_ScreeingTerritory);
		Assert.assertEquals(actual_ScreeningRepresentative, expected_ScreeningRepresentative);
		Assert.assertEquals(actual_ScreeningStatus, expected_ScreeningStatus);
		Assert.assertEquals(actual_ScreeningDriveType, expected_ScreeningDriveType);
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws Exception {
		CommonOperations.getMethodTestResult(testResult);
		CommonOperations.takePicture();
	}

	@AfterClass
	public void end() throws InterruptedException {
		// Thread.sleep(6000);
		driver.quit();
	}
}
