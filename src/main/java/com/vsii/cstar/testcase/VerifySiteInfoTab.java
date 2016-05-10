package com.vsii.cstar.testcase;

import org.testng.annotations.Test;

import com.vsii.cstar.pages.methods.HomePageMethods;
import com.vsii.cstar.pages.methods.LoginPageMethods;
import com.vsii.cstar.pages.methods.ScreeningMaintainanceMethods;
import com.vsii.cstar.pages.methods.TeamCalendarMethods;
import com.vsii.tsc.utility.DBConnection;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class VerifySiteInfoTab {
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
	public void f() throws IOException, SQLException {
		// Input data
		String input_Month = "April";
		String input_Team = "HOU - Houston";
		String input_Date = "4/5/2016";

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

		// System.out.println("Screening id is: "+screeningId);

		// Get check status of all checkbox in UI and verify it with database
		// result
		String actual_chkStatus = "Null";
		String expected_chkStatus = "Null";

		// System.out.println(objScreeningMaintainanceMethod.getAllCheckboxName().size());
		String connection = "jdbc:sqlserver://172.17.60.220;databaseName=CStar;user=CStarDev;password=cstar";
		Connection conn = DriverManager.getConnection(connection);
		for (int i = 0; i < objScreeningMaintainanceMethod.getAllCheckboxName().size(); i++) {

			String chkName = objScreeningMaintainanceMethod.getAllCheckboxName().get(i);
			System.out.println(chkName);
			actual_chkStatus = objScreeningMaintainanceMethod.getAllCheckboxStatus().get(i);
			System.out.println(actual_chkStatus);

			// Get check status of by query with checkbox name conditions
			

			String sqlCommand_01 = "select st.System_Type, r.Has_It from SS_System_Types st "
					+ "join SC_Screening_Requirements r " + "on r.Requirement_Type_ID=st.System_Type_ID "
					+ "where r.Screening_ID=" + screeningId + " and st.System_Type=?";

			PreparedStatement statement = conn.prepareStatement(sqlCommand_01);
			statement.setString(1, chkName);

			ResultSet rs = statement.executeQuery();
			int hasIt = 0;
			while (rs.next()) {
				hasIt = rs.getInt("Has_It");
				System.out.println(hasIt);
			}
			if (hasIt == 1) {
				expected_chkStatus = "checked";
			} else {
				expected_chkStatus = "unchecked";
			}

			Assert.assertEquals(actual_chkStatus, expected_chkStatus);

		}
		//Close connections
		conn.close();
		
		//Get note for Ultrasound team
		String actual_NoteUltraSound = objScreeningMaintainanceMethod.getNoteToUltraSoundTeam();
		System.out.println("Note for Ultrasound in screen: "+actual_NoteUltraSound);
		
		//Get note for Call Center
		String actual_NoteCallCenter=objScreeningMaintainanceMethod.getNoteToCallCenter();
		System.out.println("Note for call center in screen: "+actual_NoteCallCenter);
		
		//Query DB to get note for Ultrasound team for this screening
		String sqlCommand_02 = "select Comment_Team, Comment_Call_Center "+
		"from sc_screenings where Screening_ID ="+screeningId;
		System.out.println(sqlCommand_02);
		ResultSet rs2 = DBConnection.connectSQLServer(sqlCommand_02);
		String expected_NoteUltraSound="Null";
		String expected_NoteCallCenter="Null";
		while(rs2.next()){
			expected_NoteUltraSound=rs2.getString(1);
			expected_NoteCallCenter=rs2.getString(2);
		}
		System.out.println("Note for UltraSound Team query from DB: "+expected_NoteUltraSound);
		System.out.println("Note for Call Center query from DB: "+expected_NoteCallCenter);
		
		
		//Verify note displayed on screen and note query from db for this screening id
		Assert.assertEquals(actual_NoteUltraSound, expected_NoteUltraSound);
		Assert.assertEquals(actual_NoteCallCenter,expected_NoteCallCenter);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
