package com.vsii.cstar.testcase;

import org.testng.annotations.Test;

import com.vsii.cstar.pages.methods.HomePageMethods;
import com.vsii.cstar.pages.methods.LoginPageMethods;
import com.vsii.cstar.pages.methods.ScreeningMaintainanceMethods;
import com.vsii.cstar.pages.methods.TeamCalendarMethods;
import com.vsii.tsc.utility.DBConnection;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class VerifyAccountingTab {
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
	public void f() throws IOException, SQLException, ParseException {
		// Input data
		String input_Month = "April";
		String input_Team = "ACE - ACO - East";
		String input_Date = "4/8/2016";

		// Login to system
		objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com", "Thanhvc123@");

		// Select menu Team Calendar & Grid
		objHomepageMethod.mouseHoverScreeningConfig();
		objHomepageMethod.selectSubMenuTeamCalendar();

		// Choose filter
		objTeamCalendarMethod.selectMonth(input_Month);
		objTeamCalendarMethod.selectTeam(input_Team);

		// Select screening on calendar by specific date
		objTeamCalendarMethod.selectScreeningByInputDate(input_Date);

		// Get screening id
		String screeningId = "Null";
		String screeningMarketingId = driver.getCurrentUrl().split("ScreeningLinkID=")[1];
		// System.out.println(screeningMarketingId);
		if (screeningMarketingId.contains("|")) {
			screeningId = screeningMarketingId.split("\\|")[0];
		} else {
			screeningId = screeningMarketingId;
		}

		// Select Accounting tab
		objScreeningMaintainanceMethod.selectAccountingTab();

		// If there is a check request in this tab, continue to verify screen
		// data, else end this case
		ArrayList<String> actual_Purpose = new ArrayList<>();
		ArrayList<String> actual_Amount = new ArrayList<>();
		ArrayList<String> actual_PayAbleTo = new ArrayList<>();
		ArrayList<String> actual_DateNeeded = new ArrayList<>();

		if (objScreeningMaintainanceMethod.isCheckRequestExist() == true) {

			// Get actual value in screen
			int numOfCheckRequest = driver
					.findElements(By
							.xpath("//table[@id='ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_gvCheckRequests']/tbody/tr"))
					.size()-1;
			System.out.println(numOfCheckRequest);

			for (int i = 2; i <= numOfCheckRequest+1; i++) {
				String xpath_PurposeVal = "//table[@id='ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_gvCheckRequests']/tbody/tr["
						+ i + "]/td[2]/span";
				String xpath_AmountVal = "//table[@id='ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_gvCheckRequests']/tbody/tr["
						+ i + "]/td[4]/span";
				String xpath_PayAbleToVal = "//table[@id='ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_gvCheckRequests']/tbody/tr["
						+ i + "]/td[5]";
				String xpath_DateNeededVal = "//table[@id='ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_gvCheckRequests']/tbody/tr["
						+ i + "]/td[7]";
				actual_Purpose.add(driver.findElement(By.xpath(xpath_PurposeVal)).getText());
				actual_Amount.add(driver.findElement(By.xpath(xpath_AmountVal)).getText());
				actual_PayAbleTo.add(driver.findElement(By.xpath(xpath_PayAbleToVal)).getText());
				actual_DateNeeded.add(driver.findElement(By.xpath(xpath_DateNeededVal)).getText());
			}
			
			for (String string : actual_Purpose) {
				System.out.println(string);
			}

			// Query data from db and set them to expected variables
			String sqlCommand_01 = "declare @p2 int " + "set @p2=NULL " + "declare @p3 int " + "set @p3=NULL "
					+ "exec SC_Check_Request_Select_By_ScreeningID "
					+ "@Screening_Id="+screeningId+",@StatusCode=@p2 output,@RecordCount=@p3 output " + "select @p2, @p3";
			ArrayList<String> expected_Purpose = new ArrayList<>();
			ArrayList<String> expected_Amount = new ArrayList<>();
			ArrayList<String> expected_PayAbleTo = new ArrayList<>();
			ArrayList<String> expected_DateNeeded = new ArrayList<>();
			
			ResultSet rs = DBConnection.connectSQLServer(sqlCommand_01);
			
			while(rs.next()){
				expected_Purpose.add(rs.getString(28));
				expected_Amount.add(NumberFormat.getCurrencyInstance().format(rs.getDouble(2)+rs.getDouble(25)));
				expected_PayAbleTo.add(rs.getString(12));
				expected_DateNeeded.add(new SimpleDateFormat("M/dd/yyyy").format(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(rs.getString(4))));
			}
			
			for (String string2 : expected_Purpose) {
				System.out.println(string2);
			}
			
			Assert.assertEquals(actual_Purpose, expected_Purpose);
			Assert.assertEquals(actual_Amount, expected_Amount);
			Assert.assertEquals(actual_PayAbleTo, expected_PayAbleTo);
			Assert.assertEquals(actual_DateNeeded, expected_DateNeeded);
			
		} else {
			
			Assert.assertFalse(objScreeningMaintainanceMethod.isCheckRequestExist());
			System.out.println("This screening don't have any check request");
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
