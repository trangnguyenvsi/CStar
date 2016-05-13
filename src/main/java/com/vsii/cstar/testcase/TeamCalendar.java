package com.vsii.cstar.testcase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
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
import com.vsii.cstar.testdata.TestData;
import com.vsii.tsc.model.Appointment;
import com.vsii.tsc.model.PPackage;
import com.vsii.tsc.model.Product;
import com.vsii.tsc.utility.CommonOperations;
import com.vsii.tsc.utility.DBConnection;
import com.vsii.tsc.utility.TestBase;

public class TeamCalendar {
	WebDriver driver;
	LoginPageMethods objLoginPageMethod;
	HomePageMethods objHomepageMethod;
	TeamCalendarMethods objTeamCalendarMethod;
	ScreeningMaintainanceMethods objScreeningMaintainanceMethod;
	AppointmentsSingleScreeningPageMethod objAptSingleScreenMethod;
	ProductSetPageMethod objProductSetMethod;
	ProductPageMethod objProductPageMethod;
	PackagePageMethod objPackagePageMethod;
	public static ResultSet rs_Screening;
	public static String newID = null;
	public static String screeningID = "";
	public static String screeningCode, siteName, appointmentCode, appointmentSequence, priceListID, productSetID;
	public static Date appointmentTime;
	public static boolean check = false;
	public static String objectID = null;
	public static ArrayList<Appointment> lAp = new ArrayList<Appointment>();

	@BeforeClass
	public void start() throws IOException, InterruptedException {
		// driver = new FirefoxDriver();
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

		// driver.get(CommonOperations.readConfig().getProperty("baseUrl"));
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(priority = 0, description = "Verify screening exists or not")
	public void TC01() throws IOException, SQLException {
		TestBase.methodName = "TC01";
		System.out.println("TC01: Verify screening for " + TestBase.teamCode + " in " + TestBase.screeningDate);
		// get Screening for inputed date
		rs_Screening = CommonMethod.getScreeningCode(TestBase.screeningDate);
		/*
		 * next() returns true if next row is present otherwise it returns
		 * false.
		 */
		while (rs_Screening.next()) {
			if (rs_Screening.getString(3).equals(TestBase.teamCode)) {
				screeningID = rs_Screening.getString(1);
				screeningCode = rs_Screening.getString(2);
				siteName = rs_Screening.getString(4);
				priceListID = rs_Screening.getString(8);
				productSetID = rs_Screening.getString(6);
				check = true;
				break;
			}
		}
		if (check == true) {
			System.out.println("Screening exists");
		} else {
			System.out.println("Verified screening is not exist");
		}
		Assert.assertEquals(check, true);
	}

	/*
	 * 
	 */
	@Test(priority = 1, description = "Verify Screening information on calendar")
	public void TC02() throws InterruptedException, ParseException, IOException, SQLException {

		// Define input data
		TestBase.methodName = "TC02";

		// Run if screening exist, skip if screening not exist, depend on TC01
		if (check == true) {

			System.out.println("Verify Screening information on Calendar");
			String input_Date = TestBase.screeningDate;
			String input_Team = TestBase.teamCode;
			// System.out.println(input_Team);
			// System.out.println(objTeamCalendarMethod.getFullTeamName(input_Team));
			String input_Month = CommonMethod.getMonthBaseOnInputDate(input_Date);

			objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com", "Thanhvc123@");

			// Select menu Team Calendar & Grid
			objHomepageMethod.mouseHoverScreeningConfig();
			objHomepageMethod.selectSubMenuTeamCalendar();

			// Choose filter
			objTeamCalendarMethod.selectMonth(input_Month);
			objTeamCalendarMethod.selectTeam(input_Team);
			new WebDriverWait(driver, 30)
					.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_imgLoading")));

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

			// Get Screening Territory & Zip code on Screening Maintainance
			// Screen
			String expected_ScreeingTerritory = objScreeningMaintainanceMethod.getScreeningTerritory().replace(",", "")
					.split("-")[0];

			// Get screening representative on Screening Maintainance Screen
			String[] tmp_RepreName = objScreeningMaintainanceMethod.getScreeningRepresentative().split(", ");
			;
			String Fname = tmp_RepreName[0];
			String Lname = tmp_RepreName[1];
			String expected_ScreeningRepresentative = Lname + " " + Fname;

			// Get screening Status & schedule code/time on Screening
			// Maintainance
			// Screen
			String scStatus = objScreeningMaintainanceMethod.getScreeningStatus();
			String scheduleCode = objScreeningMaintainanceMethod.getScreeningScheduleCode();
			String scheduleStartTime = objScreeningMaintainanceMethod.getScreeningScheduleTime().split(" - ")[0];
			String timeZone = objScreeningMaintainanceMethod.getScreeningTimeZone();
			String expected_ScreeningStatus = scStatus + " " + scheduleCode + " " + scheduleStartTime + " " + timeZone;

			// Get screening drive type and drive time on Screening Maintainance
			// Screen
			// String driveTimeInMin =
			// objScreeningMaintainanceMethod.getScreeningDriveTime().split("
			// \\(")[0];
			String expected_ScreeningDriveType = objScreeningMaintainanceMethod.getScreeningDriveType(); // +
																											// "
																											// "
																											// +
																											// driveTimeInMin;

			// Compare Screening information in both calendar and screening
			// maintainance screen

			// Print to console compare result
			if (actual_ScreeningName.equals(expected_ScreeingName)) {
				System.out.println(
						"Screening name on calendar is map with Screening name in Screening Maintainance screen");
			} else {
				System.out.println(
						"Screening name on calendar is not map with Screening name in Screening Maintainance screen");
			}
			if (actual_ScreeningTerritoty.equals(expected_ScreeingTerritory)) {
				System.out.println(
						"Screening's territoty on calendar is map with Screening's territoty in Screening Maintainance screen");
			} else {
				System.out.println(
						"Screening's territoty on calendar is not map with Screening's territoty in Screening Maintainance screen");
			}
			if (actual_ScreeningRepresentative.equals(expected_ScreeningRepresentative)) {
				System.out.println(
						"Screening's representative on calendar is map with Screening's representative in Screening Maintainance screen");
			} else {
				System.out.println(
						"Screening's representative on calendar is not map with Screening's representative in Screening Maintainance screen");
			}
			if (actual_ScreeningStatus.equals(expected_ScreeningStatus)) {
				System.out.println(
						"Screening's status on calendar is map with Screening's status in Screening Maintainance screen");
			} else {
				System.out.println(
						"Screening's status on calendar is not map with Screening's status in Screening Maintainance screen");
			}
			if (actual_ScreeningDriveType.equals(expected_ScreeningDriveType)) {
				System.out.println(
						"Screening's Drive Type on calendar is map with Screening's Drive Type in Screening Maintainance screen");
			} else {
				System.out.println(
						"Screening's Drive Type on calendar is not map with Screening's Drive Type in Screening Maintainance screen");
			}

			Assert.assertEquals(actual_ScreeningName, expected_ScreeingName);
			Assert.assertEquals(actual_ScreeningTerritoty, expected_ScreeingTerritory);
			Assert.assertEquals(actual_ScreeningRepresentative, expected_ScreeningRepresentative);
			Assert.assertEquals(actual_ScreeningStatus, expected_ScreeningStatus);
			Assert.assertEquals(actual_ScreeningDriveType, expected_ScreeningDriveType);
		} else {
			throw new SkipException("Screening is not exist");
		}
	}

	@Test(priority = 2, description = "Verify screening site/event informations on Screening Maintainance")
	public void TC03() throws InterruptedException, ParseException, IOException, SQLException {
		TestBase.methodName = "TC03";

		// Run if screening exist, skip if screening not exist, depend on TC01
		if (check == true) {

			System.out.println("Verify Screening Site/Event informations on Screening Maintainance");
			// Login to System
			// objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com",
			// "Thanhvc123@");

			// String input_Date = TestBase.screeningDate;
			// String input_Team = TestBase.teamCode;
			// String input_Month =
			// CommonMethod.getMonthBaseOnInputDate(input_Date);

			// Select menu Team Calendar & Grid
			// objHomepageMethod.mouseHoverScreeningConfig();
			// objHomepageMethod.selectSubMenuTeamCalendar();

			// Choose filter
			// objTeamCalendarMethod.selectMonth(input_Month);
			// objTeamCalendarMethod.selectTeam(input_Team);
			// new WebDriverWait(driver,
			// 30).until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_imgLoading")));

			// Go to screening
			// objTeamCalendarMethod.selectScreeningByInputDate(input_Date);

			// Get screening id
			String screeningId = "Null";
			String screeningMarketingId = driver.getCurrentUrl().split("ScreeningLinkID=")[1];
			// System.out.println(screeningMarketingId);
			if (screeningMarketingId.contains("|")) {
				screeningId = screeningMarketingId.split("\\|")[0];
			} else {
				screeningId = screeningMarketingId;
			}

			// Get Address/Contact info
			// Get Site Address
			String actual_SiteAddress = objScreeningMaintainanceMethod.getSiteAddress().split("\n")[0];
			// System.out.println(actual_SiteAddress);

			// Get site city
			String actual_SiteCity = objScreeningMaintainanceMethod.getSiteAddress().split("\n")[1].split(",")[0];
			// System.out.println(actual_SiteCity);

			// Get site zip code
			String actual_SiteZipCode = "Null";
			if (objScreeningMaintainanceMethod.getSiteAddress().split("\n")[1].contains("-")) {
				actual_SiteZipCode = objScreeningMaintainanceMethod.getSiteAddress().split("\n")[1].split("-")[0]
						.replaceAll("[\\D]", "");
			} else {
				actual_SiteZipCode = objScreeningMaintainanceMethod.getSiteAddress().split("\n")[1].replace("\\D", "");
			}

			// System.out.println(actual_SiteZipCode);

			// Get site phone
			String actual_SitePhone = objScreeningMaintainanceMethod.getSitePhoneNo().replace("+1", "").replace("(", "")
					.replace(")", "").replace("-", "").replaceAll("[\\s]", "");
			if (actual_SitePhone.isEmpty()) {
				actual_SitePhone = "null";
			}

			// System.out.println(actual_SitePhone);

			// Get site fax
			String actual_SiteFax = objScreeningMaintainanceMethod.getSiteFaxNo().replace("+1", "").replace("(", "")
					.replace(")", "").replace("-", "").replaceAll("[\\s]", "");
			if (actual_SiteFax.isEmpty()) {
				actual_SiteFax = "null";
			}
			// System.out.println(actual_SiteFax);

			// Get contact name
			String actual_ContactName = objScreeningMaintainanceMethod.getSiteContactUser();
			if (actual_ContactName.isEmpty()) {
				actual_ContactName = "null";
			}
			// System.out.println(actual_ContactName);

			// Get contact phone
			String actual_ContactPhone = objScreeningMaintainanceMethod.getSiteContactPhone().replace("+1", "")
					.replace("(", "").replace(")", "").replace("-", "").replaceAll("[\\s]", "");
			if (actual_ContactPhone.isEmpty()) {
				actual_ContactPhone = "null";
			}
			// System.out.println(actual_ContactPhone);

			// Get contact email
			String actual_ContactEmail = objScreeningMaintainanceMethod.getSiteContactEmail();
			if (actual_ContactEmail.isEmpty()) {
				actual_ContactEmail = "null";
			}
			// System.out.println(actual_ContactEmail);

			// Get expect data of address/contact info from database
			String sqlCommand_01 = "select addSite.Address1, addSite.City, "
					+ "zip.Zip_Code, phoneNo2.Line_Number AS [Phone_Site], "
					+ "phoneNo1.Line_Number AS [Fax_Site], ct.FName, ct.LName, st3.System_Type, "
					+ "phoneNo3.Line_Number, ig.Internet_Text from SC_Sites site "
					+ "join SC_Screenings sc on sc.Site_ID=site.Site_ID "
					+ "join PL_Address_Groups addGroup on addGroup.Address_Group_ID=site.Address_Group_ID "
					+ "join PL_Addresses_Sites addSite on addSite.Address_Group_ID=addGroup.Address_Group_ID "
					+ "join PL_Zips zip on zip.Zip_ID = addSite.Zip_ID "
					+ "LEFT JOIN PL_Phone_Numbers phoneNo2 on phoneNo2.Phone_Group_ID=site.Phone_Group_ID "
					+ "and phoneNo2.Phone_Type_ID=266"
					+ "LEFT JOIN PL_Phone_Numbers phoneNo1 on phoneNo1.Phone_Group_ID=site.Phone_Group_ID "
					+ "and phoneNo1.Phone_Type_ID=40 "
					+ "join PL_Contacts ct on ct.Contact_Group_ID=site.Contact_Group_ID "
					+ "join SS_System_Types st3 on st3.System_Type_ID=ct.Contact_Type_ID "
					+ "LEFT JOIN PL_Phone_Numbers phoneNo3 on phoneNo3.Phone_Group_ID=ct.Phone_Group_ID "
					+ "and phoneNo3.Phone_Type_ID=266 "
					+ "LEFT JOIN PL_Internet_Text ig on ig.Internet_Group_ID=ct.Internet_Group_ID "
					+ "where sc.Screening_ID=" + screeningId + "";

			ResultSet rs1 = DBConnection.connectSQLServer(sqlCommand_01);

			// Declare expected variables
			String expected_SiteAddress = "Null";
			String expected_SiteCity = "Null";
			String expected_SiteZipCode = "Null";
			String expected_SitePhone = "Null";
			String expected_SiteFax = "Null";
			String expected_ContactName = "Null";
			String expected_ContactPhone = "Null";
			String expected_ContactEmail = "Null";

			// Get value from result set and put them to declared variables
			while (rs1.next()) {
				expected_SiteAddress = rs1.getString("Address1");
				expected_SiteCity = rs1.getString("City");
				expected_SiteZipCode = rs1.getString("Zip_Code");
				expected_SitePhone = rs1.getString("Phone_Site");
				expected_SiteFax = rs1.getString("Fax_Site");
				expected_ContactName = rs1.getString("FName") + " " + rs1.getString("LName");
				expected_ContactPhone = rs1.getString("Line_Number");
				expected_ContactEmail = rs1.getString("Internet_Text");
			}
			try {
				expected_SiteFax.toString();
			} catch (Exception e) {
				expected_SiteFax = "null";
			}
			try {
				expected_SitePhone.toString();
			} catch (Exception e) {
				expected_SitePhone = "null";
			}
			try {
				expected_ContactName.toString();
			} catch (Exception e) {
				expected_ContactName = "null";
			}
			try {
				expected_ContactPhone.toString();
			} catch (Exception e) {
				expected_ContactPhone = "null";
			}
			try {
				expected_ContactEmail.toString();
			} catch (Exception e) {
				expected_ContactEmail = "null";
			}

			//Print verify result of Address/Contact Info in console
			if (actual_SiteAddress.equals(expected_SiteAddress)) {
				System.out.println("Site Address displayed on screen is map with address query from DB");
			}
			

			// Verfiy values in interface and values get in database
			Assert.assertEquals(actual_SiteAddress, expected_SiteAddress);
			Assert.assertEquals(actual_SiteCity, expected_SiteCity);
			Assert.assertEquals(actual_SiteZipCode, expected_SiteZipCode);
			Assert.assertEquals(actual_SitePhone, expected_SitePhone);
			Assert.assertEquals(actual_SiteFax, expected_SiteFax);
			Assert.assertEquals(actual_ContactName, expected_ContactName);
			// Assert.assertEquals(actual_ContactPhone, expected_ContactPhone);
			Assert.assertEquals(actual_ContactEmail, expected_ContactEmail);

			// Get event information

			// Get representative value
			String actual_Representative = objScreeningMaintainanceMethod.getScreeningRepresentative();
			// System.out.println(actual_Representative);

			// Get representative's department
			String actual_RepresentativeDepartment = objScreeningMaintainanceMethod.getRepresentativeDepartment();
			// System.out.println(actual_RepresentativeDepartment);

			// Get drive type
			String actual_DriveType = objScreeningMaintainanceMethod.getDriveType();
			// System.out.println(actual_DriveType);

			// Get drive time
			String actual_DriveTime = objScreeningMaintainanceMethod.getDriveTime();
			// System.out.println(actual_DriveTime);

			// Get price level
			String actual_PriceLevel = objScreeningMaintainanceMethod.getPriceLevel();
			// System.out.println(actual_PriceLevel);

			// Get facility time
			String actual_FacilityStart = objScreeningMaintainanceMethod.getFacilityTime().split(" -")[0];
			String actual_FacilityClose = objScreeningMaintainanceMethod.getFacilityTime().split("- ")[1];
			// System.out.println(actual_FacilityStart);
			// System.out.println(actual_FacilityClose);

			// Get marketing plan type
			String actual_MarketingPlan = objScreeningMaintainanceMethod.getMarketingPlan();
			// System.out.println(actual_MarketingPlan);

			// Get site type
			String actual_SiteType = objScreeningMaintainanceMethod.getSiteType();
			// System.out.println(actual_SiteType);

			// Get marketing zipcode
			String actual_MarketingZipCode = objScreeningMaintainanceMethod.getMarketingZipCode();
			// System.out.println(actual_MarketingZipCode);

			// Get expected value from db
			String sqlCommand_02 = "select e.FName, e.LName, d.Department_Name, st1.System_Type AS [Driver_Type], "
					+ "sc.Drive_Time, price.Price_List_Name, sc.Facility_Open, sc.Facility_Close, "
					+ "st2.System_Type AS [Marketing_Plan], st3.System_Type AS [Site_Type], "
					+ "zip.Zip_Code AS [Marketing_Zip] from SC_Screenings sc "
					+ "join PL_Employees e on e.Employee_ID=sc.Sales_Rep "
					+ "join PL_Employee_Group_Employee_Xref ege on ege.Employee_ID=e.Employee_ID and ege.[Primary]=1 "
					+ "join PL_Employee_Groups eg on eg.Employee_Group_ID=ege.Employee_Group_ID "
					+ "and eg.Employee_Group_Type_ID=1245 "
					+ "join PL_Departments d on d.Department_ID=eg.Department_ID "
					+ "join SS_System_Types st1 on st1.System_Type_ID=sc.Drive_Type_ID "
					+ "join PP_Price_Lists price on price.Price_List_ID=sc.Price_List_ID "
					+ "join SS_System_Types st2 on st2.System_Type_ID=sc.Marketing_Plan_ID "
					+ "join SC_Sites site on site.Site_ID=sc.Site_ID "
					+ "join SS_System_Types st3 on st3.System_Type_ID=site.Site_Type_ID "
					+ "join PL_Zips zip on zip.Zip_ID=sc.Marketing_Postal_Code_ID " + "where sc.Screening_ID="
					+ screeningId;

			ResultSet rs2 = DBConnection.connectSQLServer(sqlCommand_02);

			// Declare expected variable
			String expected_Representative = "Null";
			String expected_RepresentativeDepartment = "Null";
			String expected_DriveType = "Null";
			String expected_PriceLevel = "Null";
			String expected_FacilityStart = "Null";
			String expected_FacilityClose = "Null";
			String expected_MarketingPlan = "Null";
			String expected_SiteType = "Null";
			String expected_MarketingZipCode = "Null";

			// set queries value to declared variables
			while (rs2.next()) {
				expected_Representative = rs2.getString("LName") + ", " + rs2.getString("FName");
				expected_RepresentativeDepartment = rs2.getString("Department_Name");
				expected_DriveType = rs2.getString(4);
				expected_PriceLevel = rs2.getString(6);

				// Get facility open time value from db and convert it to
				// correct
				// format as interface
				String tmp_expected_FacilityStart = "Null";
				tmp_expected_FacilityStart = rs2.getString(7);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
				Date dateOpen = dateFormat.parse(tmp_expected_FacilityStart);
				expected_FacilityStart = new SimpleDateFormat("K:mm a").format(dateOpen).toString();

				// Get facility close time value from db and convert it to
				// correct
				// format as interface
				String tmp_expected_FacilityClose = "Null";
				tmp_expected_FacilityClose = rs2.getString(8);
				Date dateClose = dateFormat.parse(tmp_expected_FacilityClose);
				expected_FacilityClose = new SimpleDateFormat("K:mm a").format(dateClose).toString();

				// Get marketing plan value from db
				expected_MarketingPlan = rs2.getString(9);

				// Get site type form db
				expected_SiteType = rs2.getString(10);

				// Get marketing zip code from db
				expected_MarketingZipCode = rs2.getString(11);
			}
			// System.out.println(expected_Representative);
			// System.out.println(expected_RepresentativeDepartment);
			// System.out.println(expected_DriveType);
			// System.out.println(expected_PriceLevel);
			// System.out.println(expected_FacilityStart);
			// System.out.println(expected_FacilityClose);
			// System.out.println(expected_MarketingPlan);
			// System.out.println(expected_SiteType);
			// System.out.println(expected_MarketingZipCode);

			// Verify values seen on screening and values queries from database
			Assert.assertEquals(actual_Representative, expected_Representative);
			Assert.assertEquals(actual_RepresentativeDepartment, expected_RepresentativeDepartment);
			Assert.assertEquals(actual_DriveType, expected_DriveType);
			Assert.assertEquals(actual_PriceLevel, expected_PriceLevel);
			Assert.assertEquals(actual_FacilityStart, expected_FacilityStart);
			Assert.assertEquals(actual_FacilityClose, expected_FacilityClose);
			Assert.assertEquals(actual_MarketingPlan, expected_MarketingPlan);
			Assert.assertEquals(actual_SiteType, expected_SiteType);
			Assert.assertEquals(actual_MarketingZipCode, expected_MarketingZipCode);
		} else {
			throw new SkipException("Screening is not exist");
		}
	}

	@Test(priority = 3, description = "Verify Site Info tab information")
	public void TC04() throws IOException, SQLException, ParseException {
		TestBase.methodName = "TC04";

		// Run if screening exist, skip if screening not exist, depend on TC01
		if (check == true) {

			// Input data
			String input_Date = TestBase.screeningDate;
			String input_Team = TestBase.teamCode;
			String input_Month = CommonMethod.getMonthBaseOnInputDate(input_Date);

			// Login to system
			// objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com",
			// "Thanhvc123@");

			// Select menu Team Calendar & Grid
			// objHomepageMethod.mouseHoverScreeningConfig();
			// objHomepageMethod.selectSubMenuTeamCalendar();

			// Choose filter
			// objTeamCalendarMethod.selectMonth(input_Month);
			// objTeamCalendarMethod.selectTeam(input_Team);

			// Select screening on calendar by specific date
			// objTeamCalendarMethod.selectScreeningByInputDate(input_Date);

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

			// Get check status of all checkbox in UI and verify it with
			// database
			// result
			String actual_chkStatus = "Null";
			String expected_chkStatus = "Null";

			// System.out.println(objScreeningMaintainanceMethod.getAllCheckboxName().size());
			String connection = "jdbc:sqlserver://172.17.60.220;databaseName=CStar;user=CStarDev;password=cstar";
			Connection conn = DriverManager.getConnection(connection);
			for (int i = 0; i < objScreeningMaintainanceMethod.getAllCheckboxName().size(); i++) {

				String chkName = objScreeningMaintainanceMethod.getAllCheckboxName().get(i);
				// System.out.println(chkName);
				actual_chkStatus = objScreeningMaintainanceMethod.getAllCheckboxStatus().get(i);
				// System.out.println(actual_chkStatus);

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
			// Close connections
			conn.close();

			// Get note for Ultrasound team
			String actual_NoteUltraSound = objScreeningMaintainanceMethod.getNoteToUltraSoundTeam();
			// System.out.println("Note for Ultrasound in screen: " +
			// actual_NoteUltraSound);

			// Get note for Call Center
			String actual_NoteCallCenter = objScreeningMaintainanceMethod.getNoteToCallCenter();
			// System.out.println("Note for call center in screen: " +
			// actual_NoteCallCenter);

			// Query DB to get note for Ultrasound team for this screening
			String sqlCommand_02 = "select Comment_Team, Comment_Call_Center "
					+ "from sc_screenings where Screening_ID =" + screeningId;
			// System.out.println(sqlCommand_02);
			ResultSet rs2 = DBConnection.connectSQLServer(sqlCommand_02);
			String expected_NoteUltraSound = "Null";
			String expected_NoteCallCenter = "Null";
			while (rs2.next()) {
				expected_NoteUltraSound = rs2.getString(1);
				expected_NoteCallCenter = rs2.getString(2);
			}
			System.out.println("Note for UltraSound Team query from DB: " + expected_NoteUltraSound);
			System.out.println("Note for Call Center query from DB: " + expected_NoteCallCenter);

			// Verify note displayed on screen and note query from db for this
			// screening id
			Assert.assertEquals(actual_NoteUltraSound, expected_NoteUltraSound);
			Assert.assertEquals(actual_NoteCallCenter, expected_NoteCallCenter);
		} else {
			throw new SkipException("Screening is not exist");
		}
	}

	@Test(priority = 4, description = "Verify Accounting tab information")
	public void TC05() throws IOException, SQLException, ParseException {
		TestBase.methodName = "TC05";
		// Run if screening exist, skip if screening not exist, depend on TC01
		if (check == true) {

			// Input data
			String input_Date = TestBase.screeningDate;
			String input_Team = TestBase.teamCode;
			String input_Month = CommonMethod.getMonthBaseOnInputDate(input_Date);

			// Login to system
			// objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com",
			// "Thanhvc123@");

			// Select menu Team Calendar & Grid
			// objHomepageMethod.mouseHoverScreeningConfig();
			// objHomepageMethod.selectSubMenuTeamCalendar();

			// Choose filter
			// objTeamCalendarMethod.selectMonth(input_Month);
			// objTeamCalendarMethod.selectTeam(input_Team);

			// Select screening on calendar by specific date
			// objTeamCalendarMethod.selectScreeningByInputDate(input_Date);

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

			// If there is a check request in this tab, continue to verify
			// screen
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
						.size() - 1;
				System.out.println(numOfCheckRequest);

				for (int i = 2; i <= numOfCheckRequest + 1; i++) {
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
						+ "exec SC_Check_Request_Select_By_ScreeningID " + "@Screening_Id=" + screeningId
						+ ",@StatusCode=@p2 output,@RecordCount=@p3 output " + "select @p2, @p3";
				ArrayList<String> expected_Purpose = new ArrayList<>();
				ArrayList<String> expected_Amount = new ArrayList<>();
				ArrayList<String> expected_PayAbleTo = new ArrayList<>();
				ArrayList<String> expected_DateNeeded = new ArrayList<>();

				ResultSet rs = DBConnection.connectSQLServer(sqlCommand_01);

				while (rs.next()) {
					expected_Purpose.add(rs.getString(28));
					expected_Amount.add(NumberFormat.getCurrencyInstance().format(rs.getDouble(2) + rs.getDouble(25)));
					expected_PayAbleTo.add(rs.getString(12));
					expected_DateNeeded.add(new SimpleDateFormat("M/dd/yyyy")
							.format(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(rs.getString(4))));
				}

				for (String string2 : expected_Purpose) {
					System.out.println(string2);
				}

				Assert.assertEquals(actual_Purpose, expected_Purpose);
				Assert.assertEquals(actual_Amount, expected_Amount);
				Assert.assertEquals(actual_PayAbleTo, expected_PayAbleTo);
				Assert.assertEquals(actual_DateNeeded, expected_DateNeeded);

			} else {

				throw new SkipException("This screening don't have any check request");

			}
		} else {
			throw new SkipException("Screening is not exist");
		}

	}

	@Test(priority = 5, description = "Verify products/packages and their prices in Products & Pricing tab")
	public void TC06() throws InterruptedException, ParseException, IOException, SQLException {
		// input data
		TestBase.methodName = "TC06";
		// Run if screening exist, skip if screening not exist, depend on TC01
		if (check == true) {

			// Input data
			String input_Date = TestBase.screeningDate;
			String input_Team = TestBase.teamCode;
			String input_Month = CommonMethod.getMonthBaseOnInputDate(input_Date);

			// Login to System
			// objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com",
			// "Thanhvc123@");
			// Select menu Team Calendar & Grid
			// objHomepageMethod.mouseHoverScreeningConfig();
			// objHomepageMethod.selectSubMenuTeamCalendar();
			// Choose filter
			// objTeamCalendarMethod.selectMonth(input_Month);
			// objTeamCalendarMethod.selectTeam(input_Team);

			// Wait for loading img to load
			// objTeamCalendarMethod.waitForLoadingIconToLoad();

			// Select existing screening by its name
			// objTeamCalendarMethod.selectScreeningByInputDate(input_Date);

			// Get screening id
			String screeningId = "Null";
			String screeningMarketingId = driver.getCurrentUrl().split("ScreeningLinkID=")[1];
			// System.out.println(screeningMarketingId);
			if (screeningMarketingId.contains("|")) {
				screeningId = screeningMarketingId.split("\\|")[0];
			} else {
				screeningId = screeningMarketingId;
			}

			// Select tab Products & Pricing
			objScreeningMaintainanceMethod.selectProductsPricingTab();

			// Get selected product set id
			Select select1 = new Select(
					driver.findElement(By.id("ctl00_body_tabScreeningInfo_tabPnlProductPricing_ddlProductSet")));
			String productSetId = select1.getFirstSelectedOption().getAttribute("value");

			// Get selected price level id
			Select select2 = new Select(
					driver.findElement(By.id("ctl00_body_tabScreeningInfo_tabPnlProductPricing_ddlPriceLevel")));
			String priceLevelId = select2.getFirstSelectedOption().getAttribute("value");

			// Get actual products and packages
			ArrayList<String> actual_productPackageName = objScreeningMaintainanceMethod.getAllItemsInProductSet();

			// Get actual type
			ArrayList<String> actual_type = objScreeningMaintainanceMethod.getItemTypeInProductSet();

			// Get actual price
			ArrayList<String> actual_price = objScreeningMaintainanceMethod.getItemPriceInProductSet();

			// Query db and get product/packet list
			String sqlCommand_03 = "exec AP_Offering_Select_By_DNIS " + "@Product_Set_ID=" + productSetId
					+ ",@Price_List_ID =" + priceLevelId + ",@Sale_Source_Type_ID=2017,@Screening_ID=" + screeningId;

			ResultSet rs3 = DBConnection.connectSQLServer(sqlCommand_03);
			ArrayList<String> expected_productPackageName = new ArrayList<>();
			ArrayList<String> expected_type = new ArrayList<>();
			ArrayList<String> expected_price = new ArrayList<>();
			while (rs3.next()) {
				// get expected product/packet name
				expected_productPackageName.add(rs3.getString(2).trim().replaceAll("\\s+", " "));

				// get expected type
				expected_type.add(rs3.getString(6));

				// get expected product/package price
				expected_price.add(NumberFormat.getCurrencyInstance().format(rs3.getDouble(3)));
			}

			// Verify values seen in UI and values query from DB
			Assert.assertEquals(actual_productPackageName, expected_productPackageName);
			Assert.assertEquals(actual_type, expected_type);
			Assert.assertEquals(actual_price, expected_price);
		} else {
			throw new SkipException("Screening is not exist");
		}

	}

	/**
	 * @author chienpt
	 */

	@Test(priority = 6, description = "Verify screening has appointment")
	public void TC07() throws IOException, SQLException, ParseException {
		TestBase.methodName = "TC07";
		// Run if screening exist, skip if screening not exist, depend on TC01
		if (check == true) {
			// Run if screening date is smaller than current date
			if (CommonMethod.isCurrentDate(TestBase.screeningDate) == true) {
				String input_Team = TestBase.teamCode;
				// get list Appointment
				List<Appointment> ex_appointment = CommonMethod.getExistAppointment(screeningID);
				if (ex_appointment.isEmpty() == false) {
					// objHomepageMethod.mouseHoverScreeningConfig();
					// objHomepageMethod.selectSubMenuTeamCalendar();
					// objTeamCalendarMethod.selectMonth(CommonMethod.getMonthBaseOnInputDate(TestBase.screeningDate));
					// objTeamCalendarMethod.selectTeam(input_Team);

					// objTeamCalendarMethod.clickScreening(12);
					objScreeningMaintainanceMethod.clickAppointmentsLinkText();
					objAptSingleScreenMethod.selectProductView();
					for (Appointment item : ex_appointment) {
						System.out.println(item.getAppointmentTime() + ": ");
						// Get product to product list
						List<Product> product = item.getProduct().getProduct();
						// Verify Product
						for (Product pro : product) {

							switch (pro.getProductName()) {
							case "CA":
								Assert.assertEquals(objAptSingleScreenMethod.getCA(item.getAppointmentTime()), "X");
								System.out.println("verify CA success");
								break;
							case "AO":
								Assert.assertEquals(objAptSingleScreenMethod.getAO(item.getAppointmentTime()), "X");
								break;
							case "AB":
								Assert.assertEquals(objAptSingleScreenMethod.getAB(item.getAppointmentTime()), "X");
								break;
							case "OS":
								Assert.assertEquals(objAptSingleScreenMethod.getOS(item.getAppointmentTime()), "X");
								break;
							case "LI":
								Assert.assertEquals(objAptSingleScreenMethod.getLI(item.getAppointmentTime()), "X");
								break;
							case "GL":
								Assert.assertEquals(objAptSingleScreenMethod.getGL(item.getAppointmentTime()), "X");
								break;
							case "AF":
								Assert.assertEquals(objAptSingleScreenMethod.getAF(item.getAppointmentTime()), "X");
								break;
							case "PX":
								Assert.assertEquals(objAptSingleScreenMethod.getPX(item.getAppointmentTime()), "X");
								break;
							case "TX":
								Assert.assertEquals(objAptSingleScreenMethod.getTX(item.getAppointmentTime()), "X");
								break;
							case "RX":
								Assert.assertEquals(objAptSingleScreenMethod.getRX(item.getAppointmentTime()), "X");
								break;
							case "AX":
								Assert.assertEquals(objAptSingleScreenMethod.getAX(item.getAppointmentTime()), "X");
								break;
							case "LX":
								Assert.assertEquals(objAptSingleScreenMethod.getLX(item.getAppointmentTime()), "X");
								break;
							case "GX":
								Assert.assertEquals(objAptSingleScreenMethod.getGX(item.getAppointmentTime()), "X");
								break;
							case "CO":
								Assert.assertEquals(objAptSingleScreenMethod.getCO(item.getAppointmentTime()), "X");
								break;
							case "SL":
								Assert.assertEquals(objAptSingleScreenMethod.getSL(item.getAppointmentTime()), "X");
								break;
							case "A2":
								Assert.assertEquals(objAptSingleScreenMethod.getA2(item.getAppointmentTime()), "X");
								break;
							case "SX":
								Assert.assertEquals(objAptSingleScreenMethod.getSX(item.getAppointmentTime()), "X");
								break;
							case "TP":
								Assert.assertEquals(objAptSingleScreenMethod.getTP(item.getAppointmentTime()), "X");
								break;
							case "PP":
								Assert.assertEquals(objAptSingleScreenMethod.getPP(item.getAppointmentTime()), "X");
								break;
							case "XF":
								Assert.assertEquals(objAptSingleScreenMethod.getXF(item.getAppointmentTime()), "X");
								break;
							case "XM":
								Assert.assertEquals(objAptSingleScreenMethod.getXM(item.getAppointmentTime()), "X");
								break;
							case "X1":
								Assert.assertEquals(objAptSingleScreenMethod.getX1(item.getAppointmentTime()), "X");
								break;
							case "KX":
								Assert.assertEquals(objAptSingleScreenMethod.getKX(item.getAppointmentTime()), "X");
								break;
							case "YX":
								Assert.assertEquals(objAptSingleScreenMethod.getYX(item.getAppointmentTime()), "X");
								break;
							case "PY":
								Assert.assertEquals(objAptSingleScreenMethod.getPY(item.getAppointmentTime()), "X");
								break;
							case "MT":
								Assert.assertEquals(objAptSingleScreenMethod.getMT(item.getAppointmentTime()), "X");
								break;
							case "LK":
								Assert.assertEquals(objAptSingleScreenMethod.getLK(item.getAppointmentTime()), "X");
								break;
							case "XC":
								Assert.assertEquals(objAptSingleScreenMethod.getXC(item.getAppointmentTime()), "X");
								break;
							case "DX":
								Assert.assertEquals(objAptSingleScreenMethod.getDX(item.getAppointmentTime()), "X");
								break;
							case "BH":
								Assert.assertEquals(objAptSingleScreenMethod.getBH(item.getAppointmentTime()), "X");
								break;
							case "KH":
								Assert.assertEquals(objAptSingleScreenMethod.getKH(item.getAppointmentTime()), "X");
								break;
							case "KA":
								Assert.assertEquals(objAptSingleScreenMethod.getKA(item.getAppointmentTime()), "X");
								break;
							case "FV":
								Assert.assertEquals(objAptSingleScreenMethod.getFV(item.getAppointmentTime()), "X");
								break;
							case "FQ":
								Assert.assertEquals(objAptSingleScreenMethod.getFQ(item.getAppointmentTime()), "X");
								break;
							default:
								break;
							}
							System.out.println(item.getAppointmentCode() + " Verify product successfully");
						}
					}
				}
			} else {
				throw new SkipException("Screening Date is in future");
			}
		} else {
			throw new SkipException("Screening is not exist");
		}
	}

	@Test(priority = 7, description = "Take appointments for screening", dataProvider = "listappointment", dataProviderClass = TestData.class)
	public void TC08(String Participants_GUID, String Amount, String Ex_AmtTotal)
			throws IOException, SQLException, ParseException {
		TestBase.methodName = "TC08";

		// Run if screening exist, skip if screening not exist, depend on TC01
		if (check == true) {
			// Run if screening date is smaller than current date
			if (CommonMethod.isCurrentDate(TestBase.screeningDate) == false) {
				// Take a list of Appointment Cell GUID. It means list of
				// appointment
				// has not scheduled
				ResultSet rs_AppointmentCell = CommonMethod.getAppointmentCell(screeningID);
				Assert.assertEquals(rs_AppointmentCell.wasNull(), false);
				// Generate appointment code
				while (rs_AppointmentCell.next()) {
					System.out.println(rs_AppointmentCell.getString(4));
					appointmentTime = rs_AppointmentCell.getTime(4);
					appointmentSequence = rs_AppointmentCell.getString(5);
					SimpleDateFormat sdfDate = new SimpleDateFormat("hhmm");
					appointmentCode = screeningCode + sdfDate.format(appointmentTime).trim();
					System.out.println(sdfDate.format(appointmentTime));
					switch (appointmentSequence.length()) {
					case 1:
						appointmentCode = appointmentCode + "00" + appointmentSequence;
						break;
					case 2:
						appointmentCode = appointmentCode + "0" + appointmentSequence;
						break;
					case 3:
						appointmentCode = appointmentCode + appointmentSequence;
						break;
					default:
						appointmentCode = appointmentCode + appointmentSequence;
						break;
					}
					System.out.println(appointmentCode);
					// Take appointment for each participant
					// Create a Note. The output will be required input for next
					// query.
					// No need to care about this query
					ResultSet rs_Object = CommonMethod.getObject();
					while (rs_Object.next()) {
						objectID = rs_Object.getString("ObjectID");
					}
					// take appointment
					ResultSet rs_NewID = CommonMethod.takeAppointment(rs_AppointmentCell.getString(1),
							Participants_GUID, Amount, appointmentCode, objectID, priceListID, productSetID,
							screeningID);
					System.out.println("Take appoinment successfully");
					while (rs_NewID.next()) {
						// printing the result
						System.out.println(rs_NewID.getString("NEWID"));
						newID = rs_NewID.getString("NEWID");
					}
					// to change the chosen appointment cell status to scheduled
					CommonMethod.changeAppointmentStatus(rs_AppointmentCell.getString(1));
					System.out.println("change appointment cell status successfully");

					// Assign package to the order
					List<Product> productList = new ArrayList<Product>();
					productList = CommonMethod.assignPackageRandom(productSetID, priceListID, newID);
					System.out.println("Assign package suscessfully");
					PPackage pp = new PPackage();
					pp.setProduct(productList);
					Appointment ap = new Appointment();
					ap.setScreeningCode(screeningCode);
					ap.setScreeningDate(TestBase.screeningDate);
					SimpleDateFormat sdfDate1 = new SimpleDateFormat("h:mm a");
					System.out.println(sdfDate1.format(appointmentTime));
					ap.setAppointmentTime(sdfDate1.format(appointmentTime));
					ap.setSequence(appointmentSequence);
					ap.setProduct(pp);
					ap.setSiteName(siteName);
					lAp.add(ap);
					break;
				}
			} else {
				throw new SkipException("Screening already occurred");
			}
		} else {
			throw new SkipException("Screening is not exist");
		}

	}

	@Test(priority = 8, description = "Verify taken appointment")
	public void TC09() throws ParseException, IOException, SQLException {
		TestBase.methodName = "TC09";

		// Run if screening exist, skip if screening not exist, depend on TC01
		if (check == true) {
			// Run if screening date is smaller than current date
			if (CommonMethod.isCurrentDate(TestBase.screeningDate) == false) {

				String input_Team = TestBase.teamCode;
				System.out.println("Verify appointment");
				// Steps to access Appointments Screen
				objHomepageMethod.mouseHoverScreeningConfig();
				objHomepageMethod.selectSubMenuTeamCalendar();
				objTeamCalendarMethod.selectMonth(CommonMethod.getMonthBaseOnInputDate(TestBase.screeningDate));
				objTeamCalendarMethod.selectTeam(input_Team);
				objTeamCalendarMethod.selectScreeningByInputDate(TestBase.screeningDate);
				objScreeningMaintainanceMethod.clickAppointmentsLinkText();
				objAptSingleScreenMethod.selectProductView();
				for (Appointment item : lAp) {
					// Get product to product list
					List<Product> product = item.getProduct().getProduct();
					// Verify Product
					for (Product pro : product) {
						switch (pro.getProductName()) {
						case "CA":
							Assert.assertEquals(objAptSingleScreenMethod.getCA(item.getAppointmentTime()), "X");
							System.out.println("verify CA success");
							break;
						case "AO":
							Assert.assertEquals(objAptSingleScreenMethod.getAO(item.getAppointmentTime()), "X");
							break;
						case "AB":
							Assert.assertEquals(objAptSingleScreenMethod.getAB(item.getAppointmentTime()), "X");
							break;
						case "OS":
							Assert.assertEquals(objAptSingleScreenMethod.getOS(item.getAppointmentTime()), "X");
							break;
						case "LI":
							Assert.assertEquals(objAptSingleScreenMethod.getLI(item.getAppointmentTime()), "X");
							break;
						case "GL":
							Assert.assertEquals(objAptSingleScreenMethod.getGL(item.getAppointmentTime()), "X");
							break;
						case "AF":
							Assert.assertEquals(objAptSingleScreenMethod.getAF(item.getAppointmentTime()), "X");
							break;
						case "PX":
							Assert.assertEquals(objAptSingleScreenMethod.getPX(item.getAppointmentTime()), "X");
							break;
						case "TX":
							Assert.assertEquals(objAptSingleScreenMethod.getTX(item.getAppointmentTime()), "X");
							break;
						case "RX":
							Assert.assertEquals(objAptSingleScreenMethod.getRX(item.getAppointmentTime()), "X");
							break;
						case "AX":
							Assert.assertEquals(objAptSingleScreenMethod.getAX(item.getAppointmentTime()), "X");
							break;
						case "LX":
							Assert.assertEquals(objAptSingleScreenMethod.getLX(item.getAppointmentTime()), "X");
							break;
						case "GX":
							Assert.assertEquals(objAptSingleScreenMethod.getGX(item.getAppointmentTime()), "X");
							break;
						case "CO":
							Assert.assertEquals(objAptSingleScreenMethod.getCO(item.getAppointmentTime()), "X");
							break;
						case "SL":
							Assert.assertEquals(objAptSingleScreenMethod.getSL(item.getAppointmentTime()), "X");
							break;
						case "A2":
							Assert.assertEquals(objAptSingleScreenMethod.getA2(item.getAppointmentTime()), "X");
							break;
						case "SX":
							Assert.assertEquals(objAptSingleScreenMethod.getSX(item.getAppointmentTime()), "X");
							break;
						case "TP":
							Assert.assertEquals(objAptSingleScreenMethod.getTP(item.getAppointmentTime()), "X");
							break;
						case "PP":
							Assert.assertEquals(objAptSingleScreenMethod.getPP(item.getAppointmentTime()), "X");
							break;
						case "XF":
							Assert.assertEquals(objAptSingleScreenMethod.getXF(item.getAppointmentTime()), "X");
							break;
						case "XM":
							Assert.assertEquals(objAptSingleScreenMethod.getXM(item.getAppointmentTime()), "X");
							break;
						case "X1":
							Assert.assertEquals(objAptSingleScreenMethod.getX1(item.getAppointmentTime()), "X");
							break;
						case "KX":
							Assert.assertEquals(objAptSingleScreenMethod.getKX(item.getAppointmentTime()), "X");
							break;
						case "YX":
							Assert.assertEquals(objAptSingleScreenMethod.getYX(item.getAppointmentTime()), "X");
							break;
						case "PY":
							Assert.assertEquals(objAptSingleScreenMethod.getPY(item.getAppointmentTime()), "X");
							break;
						case "MT":
							Assert.assertEquals(objAptSingleScreenMethod.getMT(item.getAppointmentTime()), "X");
							break;
						case "LK":
							Assert.assertEquals(objAptSingleScreenMethod.getLK(item.getAppointmentTime()), "X");
							break;
						case "XC":
							Assert.assertEquals(objAptSingleScreenMethod.getXC(item.getAppointmentTime()), "X");
							break;
						case "DX":
							Assert.assertEquals(objAptSingleScreenMethod.getDX(item.getAppointmentTime()), "X");
							break;
						case "BH":
							Assert.assertEquals(objAptSingleScreenMethod.getBH(item.getAppointmentTime()), "X");
							break;
						case "KH":
							Assert.assertEquals(objAptSingleScreenMethod.getKH(item.getAppointmentTime()), "X");
							break;
						case "KA":
							Assert.assertEquals(objAptSingleScreenMethod.getKA(item.getAppointmentTime()), "X");
							break;
						case "FV":
							Assert.assertEquals(objAptSingleScreenMethod.getFV(item.getAppointmentTime()), "X");
							break;
						case "FQ":
							Assert.assertEquals(objAptSingleScreenMethod.getFQ(item.getAppointmentTime()), "X");
							break;
						default:
							break;
						}
					}
					System.out.println(item.getAppointmentCode() + " Verify product successfully");
				}
			} else {
				throw new SkipException("Screening already occurred");

			}
		} else {
			throw new SkipException("Screening is not exist");
		}
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
