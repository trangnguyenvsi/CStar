package com.vsii.cstar.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vsii.cstar.pages.methods.AppointmentsSingleScreeningPageMethod;
import com.vsii.cstar.pages.methods.HomePageMethods;
import com.vsii.cstar.pages.methods.LoginPageMethods;
import com.vsii.cstar.pages.methods.ScreeningMaintainanceMethods;
import com.vsii.cstar.pages.methods.TeamCalendarMethods;

public class VerifyScreeningsAppointments2 {
	WebDriver driver;
	LoginPageMethods objLoginPageMethod;
	HomePageMethods objHomepageMethod;
	TeamCalendarMethods objTeamCalendarMethod;
	ScreeningMaintainanceMethods objScreeningMaintainanceMethod;
	AppointmentsSingleScreeningPageMethod objAptSingleScreenMethod;

	@BeforeClass
	public void start() {
		driver = new FirefoxDriver();
		objLoginPageMethod = new LoginPageMethods(driver);
		objHomepageMethod = new HomePageMethods(driver);
		objTeamCalendarMethod = new TeamCalendarMethods(driver);
		objScreeningMaintainanceMethod = new ScreeningMaintainanceMethods(driver);
		objAptSingleScreenMethod = new AppointmentsSingleScreeningPageMethod(driver);

		// Setup browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://172.17.60.220:888/Login.aspx");
		driver.manage().window().maximize();
	}

	@Test
	public void VerifyScreeningAppointments() {
		// Steps to access Appointments Screen
		objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com", "Thanhvc123@");
		objHomepageMethod.mouseHoverScreeningConfig();
		objHomepageMethod.selectSubMenuTeamCalendar();
		objTeamCalendarMethod.selectMonth("April");
		objTeamCalendarMethod.selectTeam("HOU - Houston");
		objTeamCalendarMethod.selectExistingScreening("First Church of Pearland");
		objScreeningMaintainanceMethod.clickAppointmentsLinkText();

		// Input a disired time (time that participant was choose)
		String aptTime = "9:00 AM";

		// Verify database with web - actual result should be extracted from
		// database
		Assert.assertEquals("RMseMMaMie BMldMan", objAptSingleScreenMethod.getParticipantName(aptTime));
		Assert.assertEquals("+1 (281) 485-7699, 77581", objAptSingleScreenMethod.getParticipantPhoneZip(aptTime));
		Assert.assertEquals("$129.00", objAptSingleScreenMethod.getParticipantAmount(aptTime));
		Assert.assertEquals("$129.00", objAptSingleScreenMethod.getParticipantAmountDue(aptTime));
	}

	@AfterClass
	public void end() throws InterruptedException {
		// Thread.sleep(6000);
		driver.quit();
	}
}
