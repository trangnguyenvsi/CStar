package com.vsii.cstar.testcase;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vsii.cstar.pages.methods.HomePageMethods;
import com.vsii.cstar.pages.methods.LoginPageMethods;
import com.vsii.cstar.pages.methods.TeamCalendarMethods;

public class VerifyTeamsHaveScreeningOnSpecificDate {
	WebDriver driver;
	LoginPageMethods objLoginPageMethod;
	HomePageMethods objHomepageMethod;
	TeamCalendarMethods objTeamCalendarMethod;

	@BeforeClass
	public void start() {
		driver = new FirefoxDriver();
		objLoginPageMethod = new LoginPageMethods(driver);
		objHomepageMethod = new HomePageMethods(driver);
		objTeamCalendarMethod = new TeamCalendarMethods(driver);

		// Setup browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://172.17.60.220:888/Login.aspx");
		driver.manage().window().maximize();
	}

	@Test
	public void t() throws InterruptedException, ParseException, IOException, SQLException {
		// Login to System
		String input_CheckedDate = "4/27/2016";
		objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com", "Thanhvc123@");

		// Select menu Team Calendar & Grid
		objHomepageMethod.mouseHoverScreeningConfig();
		objHomepageMethod.selectSubMenuTeamCalendar();

		// Select month want to check date have screenings
		objTeamCalendarMethod.selectMonth("April");

		// Get all team have Screening in date chosen in user interface
		ArrayList<String> actual_TeamList = new ArrayList<>();
		actual_TeamList = objTeamCalendarMethod.getTeamsHaveScreeningInUI(input_CheckedDate);
		
		// Get all team have Screening in date chosen by query data
		ArrayList<String> expected_TeamList = new ArrayList<>();
		expected_TeamList = objTeamCalendarMethod.getTeamsHaveScreeningByQueryDB(input_CheckedDate);

		// Verify with database result: at chosen date, teams on calendar have
		// screening is same with teams querry from database have screening for
		// that date
		boolean isSame = actual_TeamList.equals(expected_TeamList);
		Assert.assertTrue(isSame);
	}

	@AfterClass
	public void end() throws InterruptedException {
		// Thread.sleep(6000);
		driver.quit();
	}
}
