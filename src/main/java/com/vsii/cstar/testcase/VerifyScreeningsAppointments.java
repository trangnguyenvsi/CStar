package com.vsii.cstar.testcase;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import com.vsii.cstar.pages.methods.ScreeningMaintainanceMethods;
import com.vsii.cstar.pages.methods.TeamCalendarMethods;
import com.vsii.cstar.testdata.TestData;
import com.vsii.tsc.utility.CommonOperations;
import com.vsii.tsc.utility.DBConnection;
import com.vsii.tsc.utility.TestBase;

public class VerifyScreeningsAppointments {

	LoginPageMethods objLoginPageMethod;
	HomePageMethods objHomepageMethod;
	TeamCalendarMethods objTeamCalendarMethod;
	ScreeningMaintainanceMethods objScreeningMaintainanceMethod;
	AppointmentsSingleScreeningPageMethod objAptSingleScreenMethod;

	@BeforeClass
	public void start() {
		objLoginPageMethod = new LoginPageMethods(TestBase.driver);
		objHomepageMethod = new HomePageMethods(TestBase.driver);
		objTeamCalendarMethod = new TeamCalendarMethods(TestBase.driver);
		objScreeningMaintainanceMethod = new ScreeningMaintainanceMethods(TestBase.driver);
		objAptSingleScreenMethod = new AppointmentsSingleScreeningPageMethod(TestBase.driver);
		objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com", "Thanhvc123@");
		// CommonMethod.checkLogin();

	}

	@Test(priority = 1, description = "takeappointment", dataProvider = "takeappointment", dataProviderClass = TestData.class)
	public void test02(String Screening_ID, String Product_Set_ID, String Price_List_ID, String Appointment_Cell_GUID,
			String Appointment_Code, String Participants_GUID, String Amount, String Package_ID, String Ex_Time,
			String Ex_Sequence, String Ex_Name, String Ex_AmtTotal) throws IOException, SQLException {

		TestBase.methodName = "TM01";

		String statusCode;
		String objectID = null;
		String newID = null;

		String sqlCommand_01 = "declare @p2 int set @p2=NULL declare @p3 int set @p3=NULL exec CC_Note_Group_Add @Created_By=3640,@StatusCode=@p2 output,@ObjectID=@p3 output select @p2 as StatusCode, @p3 as ObjectID";

		// set an appointment for the chosen participant
		ResultSet rs_Object = DBConnection.connectSQLServer(sqlCommand_01);
		/*
		 * next() returns true if next row is present otherwise it returns
		 * false.
		 */
		while (rs_Object.next()) {
			// printing the result
			System.out.println(rs_Object.getString("StatusCode"));
			System.out.println(rs_Object.getString("ObjectID"));
			objectID = rs_Object.getString("ObjectID");
		}

		String sqlCommand_02 = "DECLARE @NEWID uniqueidentifier = NEWID() " + "SELECT @NEWID as NEWID "
				+ "declare @p29 int " + "set @p29=NULL " + "exec CC_Order_Add " + "@Order_Guid=@NEWID,"
				+ "@Appointment_Cell_GUID=" + "'" + Appointment_Cell_GUID + "'," + "@Order_Status_Type_ID=381,"
				+ "@Participant_GUID=" + "'" + Participants_GUID + "'," + "@Order_Group_GUID=NULL,"
				+ "@Previous_Order_GUID=NULL," + "@Amount=" + "'" + Amount + "'," + "@Appointment_Code=" + "N'"
				+ Appointment_Code + "'," + "@Created_By=3640," + "@DNIS_ID=17," + "@From_FSA=NULL," + "@Note_Group_ID="
				+ "'" + objectID + "'," + "@Order_Type_ID=379," + "@Order_Sub_Type_ID=NULL," + "@Price_List_ID=" + "'"
				+ Price_List_ID + "'," + "@Product_Set_ID=" + "'" + Product_Set_ID + "'," + "@Processed_Date=NULL,"
				+ "@Script_ID=72," + "@Source_Code_ID=NULL," + "@Tax_Group_ID=NULL," + "@Screening_ID=" + "'"
				+ Screening_ID + "'," + "@Comment=NULL," + "@Ship_To_Address_ID=NULL," + "@Fax_To_ID=NULL,"
				+ "@Order_Reason_Type_ID=NULL," + "@Ship_Method_Type_ID=598," + "@Paperless_Status_Type_ID=NULL,"
				+ "@Order_Origination_Type_ID=1695," + "@StatusCode=@p29 output " + "select @p29";

		// take appointment
		ResultSet rs_NewID = DBConnection.connectSQLServer(sqlCommand_02);
		while (rs_NewID.next()) {
			// printing the result
			System.out.println(rs_NewID.getString("NEWID"));
			newID = rs_NewID.getString("NEWID");
		}

		// to change the chosen appointment cell status to scheduled
		String sqlCommand_03 = "declare @p4 int " + "set @p4=NULL " + "declare @p5 int " + "set @p5=NULL "
				+ "exec CC_Appointment_Cell_Update_Status " + "@Appointment_Cell_GUID=" + "'" + Appointment_Cell_GUID
				+ "'," + "@Modified_By=3640," + "@Cell_Status_Type_Id=393," + "@StatusCode=@p4 output,"
				+ "@RowsAffected=@p5 output " + "select @p4, @p5";
		DBConnection.connectSQLServer(sqlCommand_03);
		System.out.println("change appointment cell status successfully");

		// Assign package to the order
		String sqlCommand_04 = "declare @p11 int " + "set @p11=NULL " + "declare @p12 int " + "set @p12=NULL "
				+ "exec CC_Order_Package_Assign " + "@Adjustment_ID=NULL," + "@Amount=244.00," + "@DNIS_Code=N'AAA',"
				+ "@Script_Used=NULL," + "@Modified_By=3640," + "@Order_GUID=" + "'" + newID + "'," + "@Package_ID="
				+ "'" + Package_ID + "'," + "@Price_List_ID=" + "'" + Price_List_ID + "',"
				+ "@Exception_Reason_Type_ID=NULL," + "@Sale_Source_Type_ID=2017," + "@StatusCode=@p11 output,"
				+ "@RowsAffected=@p12 output " + "select @p11, @p12";

		DBConnection.connectSQLServer(sqlCommand_04);
		System.out.println("Assign package suscessfully");

		// Steps to access Appointments Screen
		objHomepageMethod.mouseHoverScreeningConfig();
		objHomepageMethod.selectSubMenuTeamCalendar();

		objTeamCalendarMethod.selectTeam("CLV - Cleveland");
		objTeamCalendarMethod.selectExistingScreening("St Stephen Church");
		objScreeningMaintainanceMethod.clickAppointmentsLinkText();

		// Input a disired time (time that participant was choose)
		// String aptTime = "9:00 AM";

		// Verify database with web - actual result should be extracted from
		// database
		// Assert.assertEquals(Ex_Name,
		// objAptSingleScreenMethod.getParticipantName(Ex_Time));
		// Assert.assertEquals("+1 (281) 485-7699, 77581",
		// objAptSingleScreenMethod.getParticipantPhoneZip(Ex_Time));
		// Assert.assertEquals(Ex_AmtTotal,
		// objAptSingleScreenMethod.getParticipantAmount(Ex_Time));
		// Assert.assertEquals(Ex_AmtTotal, objAptSingleScreenMethod.get);

		/* Verify Product */
		objAptSingleScreenMethod.selectProductView();
		String sqlCommand_05 = " select Product_Code from dbo.PP_Products "
				+ "where product_id in (select Product_ID from dbo.PP_Package_Product_Xref where Package_ID = "
				+ Package_ID + ")";

		// ArrayList<String> productList = new ArrayList<String>();
		ResultSet rs_ProductList = DBConnection.connectSQLServer(sqlCommand_05);
		// Get product to product list
		while (rs_ProductList.next()) {
			String product = rs_ProductList.getString("Product_Code");
			switch (product) {
			case "CA":
				Assert.assertEquals(objAptSingleScreenMethod.getCA(Ex_Time), "X");
				System.out.println("verify CA success");
				break;
			case "AO":
				Assert.assertEquals(objAptSingleScreenMethod.getAO(Ex_Time), "X");
				break;
			default:
				break;
			}
		}

	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws Exception {
		CommonOperations.getMethodTestResult(testResult);
		CommonOperations.takePicture();
	}

	@AfterClass
	public void end() throws InterruptedException {

	}
}
