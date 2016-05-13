package com.vsii.cstar.testcase;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.vsii.tsc.utility.DBConnection;
import com.vsii.tsc.utility.TestBase;

public class VerifyScreeningInformation {
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
	public void start() throws ParseException {
		
		driver = TestBase.driver;
		objLoginPageMethod = new LoginPageMethods(driver);
		objHomepageMethod = new HomePageMethods(driver);
		objTeamCalendarMethod = new TeamCalendarMethods(driver);
		objScreeningMaintainanceMethod = new ScreeningMaintainanceMethods(driver);
		objAptSingleScreenMethod = new AppointmentsSingleScreeningPageMethod(driver);
		objProductSetMethod = new ProductSetPageMethod(driver);
		objProductPageMethod = new ProductPageMethod(driver);
		objPackagePageMethod = new PackagePageMethod(driver);
	}

	@Test
	public void TC02() throws InterruptedException, ParseException, IOException, SQLException {
		TestBase.methodName="TC02";
		// Login to System
		objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com", "Thanhvc123@");
		
		String input_Date = TestBase.screeningDate;
		String input_Team= TestBase.teamCode;
		System.out.println(input_Date);
		String input_Month = CommonMethod.getMonthBaseOnInputDate(input_Date);
		System.out.println(input_Month);
		

		// Select menu Team Calendar & Grid
		objHomepageMethod.mouseHoverScreeningConfig();
		objHomepageMethod.selectSubMenuTeamCalendar();

		// Choose filter
		objTeamCalendarMethod.selectMonth(input_Month);
		objTeamCalendarMethod.selectTeam(input_Team);
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_imgLoading")));

		// Go to screening
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

		 // Get Address/Contact info
		
		 // Get Site Address
		 String actual_SiteAddress =
		 objScreeningMaintainanceMethod.getSiteAddress().split("\n")[0];
		 System.out.println(actual_SiteAddress);
		
		 // Get site city
		 String actual_SiteCity =
		 objScreeningMaintainanceMethod.getSiteAddress().split("\n")[1].split(",")[0];
		 System.out.println(actual_SiteCity);
		
		 // Get site zip code
		 String actual_SiteZipCode = "Null";
		 if
		 (objScreeningMaintainanceMethod.getSiteAddress().split("\n")[1].contains("-"))
		 {
		 actual_SiteZipCode =
		 objScreeningMaintainanceMethod.getSiteAddress().split("\n")[1].split("-")[0]
		 .replaceAll("[\\D]", "");
		 } else {
		 actual_SiteZipCode =
		 objScreeningMaintainanceMethod.getSiteAddress().split("\n")[1].replace("\\D",
		 "");
		 }
		
		 System.out.println(actual_SiteZipCode);
		
		 // Get site phone
		 String actual_SitePhone =
		 objScreeningMaintainanceMethod.getSitePhoneNo().replace("+1",
		 "").replace("(", "")
		 .replace(")", "").replace("-", "").replaceAll("[\\s]", "");
		 if (actual_SitePhone.isEmpty()) {
		 actual_SitePhone = "null";
		 }
		
		 System.out.println(actual_SitePhone);
		
		 // Get site fax
		 String actual_SiteFax =
		 objScreeningMaintainanceMethod.getSiteFaxNo().replace("+1",
		 "").replace("(", "")
		 .replace(")", "").replace("-", "").replaceAll("[\\s]", "");
		 if (actual_SiteFax.isEmpty()) {
		 actual_SiteFax = "null";
		 }
		 System.out.println(actual_SiteFax);
		
		 // Get contact name
		 String actual_ContactName =
		 objScreeningMaintainanceMethod.getSiteContactUser();
		 if(actual_ContactName.isEmpty()){
		 actual_ContactName="null";
		 }
		 System.out.println(actual_ContactName);
		
		 // Get contact phone
		 String actual_ContactPhone =
		 objScreeningMaintainanceMethod.getSiteContactPhone().replace("+1",
		 "")
		 .replace("(", "").replace(")", "").replace("-",
		 "").replaceAll("[\\s]", "");
		 if(actual_ContactPhone.isEmpty()){
		 actual_ContactPhone="null";
		 }
		 System.out.println(actual_ContactPhone);
		
		 // Get contact email
		 String actual_ContactEmail =
		 objScreeningMaintainanceMethod.getSiteContactEmail();
		 if(actual_ContactEmail.isEmpty()){
		 actual_ContactEmail="null";
		 }
		 System.out.println(actual_ContactEmail);
		
		 // Get expect data of address/contact info from database
		 String sqlCommand_01 = "select addSite.Address1, addSite.City, "
		 +"zip.Zip_Code, phoneNo2.Line_Number AS [Phone_Site], "
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
		 expected_ContactName = rs1.getString("FName") + " " +
		 rs1.getString("LName");
		 expected_ContactPhone = rs1.getString("Line_Number");
		 expected_ContactEmail = rs1.getString("Internet_Text");
		 }
		 try {
		 expected_SiteFax.toString();
		 } catch (Exception e) {
		 expected_SiteFax="null";
		 }
		 try {
		 expected_SitePhone.toString();
		 } catch (Exception e) {
		 expected_SitePhone="null";
		 }
		 try {
		 expected_ContactName.toString();
		 } catch (Exception e) {
		 expected_ContactName="null";
		 }
		 try {
		 expected_ContactPhone.toString();
		 } catch (Exception e) {
		 expected_ContactPhone="null";
		 }
		 try {
		 expected_ContactEmail.toString();
		 } catch (Exception e) {
		 expected_ContactEmail="null";
		 }
		
		 System.out.println(expected_SiteAddress);
		 System.out.println(expected_SiteCity);
		 System.out.println(expected_SiteZipCode);
		 System.out.println(expected_SitePhone);
		 System.out.println(expected_SiteFax);
		 System.out.println(expected_ContactName);
		 System.out.println(expected_ContactPhone);
		 System.out.println(expected_ContactEmail);
		
		 //Verfiy values in interface and values get in database
		 Assert.assertEquals(actual_SiteAddress, expected_SiteAddress);
		 Assert.assertEquals(actual_SiteCity, expected_SiteCity);
		 Assert.assertEquals(actual_SiteZipCode, expected_SiteZipCode);
		 Assert.assertEquals(actual_SitePhone, expected_SitePhone);
		 Assert.assertEquals(actual_SiteFax, expected_SiteFax);
		 Assert.assertEquals(actual_ContactName, expected_ContactName);
		 Assert.assertEquals(actual_ContactPhone, expected_ContactPhone);
		 Assert.assertEquals(actual_ContactEmail, expected_ContactEmail);

		// Get event information

		// Get representative value
		String actual_Representative = objScreeningMaintainanceMethod.getScreeningRepresentative();
		System.out.println(actual_Representative);

		// Get representative's department
		String actual_RepresentativeDepartment = objScreeningMaintainanceMethod.getRepresentativeDepartment();
		System.out.println(actual_RepresentativeDepartment);

		// Get drive type
		String actual_DriveType = objScreeningMaintainanceMethod.getDriveType();
		System.out.println(actual_DriveType);

		// Get drive time
		String actual_DriveTime = objScreeningMaintainanceMethod.getDriveTime();
		System.out.println(actual_DriveTime);

		// Get price level
		String actual_PriceLevel = objScreeningMaintainanceMethod.getPriceLevel();
		System.out.println(actual_PriceLevel);

		// Get facility time
		String actual_FacilityStart = objScreeningMaintainanceMethod.getFacilityTime().split(" -")[0];
		String actual_FacilityClose = objScreeningMaintainanceMethod.getFacilityTime().split("- ")[1];
		System.out.println(actual_FacilityStart);
		System.out.println(actual_FacilityClose);

		// Get marketing plan type
		String actual_MarketingPlan = objScreeningMaintainanceMethod.getMarketingPlan();
		System.out.println(actual_MarketingPlan);

		// Get site type
		String actual_SiteType = objScreeningMaintainanceMethod.getSiteType();
		System.out.println(actual_SiteType);

		// Get marketing zipcode
		String actual_MarketingZipCode = objScreeningMaintainanceMethod.getMarketingZipCode();
		System.out.println(actual_MarketingZipCode);

		// Get expected value from db
		String sqlCommand_02 = "select e.FName, e.LName, d.Department_Name, st1.System_Type AS [Driver_Type], "
				+ "sc.Drive_Time, price.Price_List_Name, sc.Facility_Open, sc.Facility_Close, "
				+ "st2.System_Type AS [Marketing_Plan], st3.System_Type AS [Site_Type], "
				+ "zip.Zip_Code AS [Marketing_Zip] from SC_Screenings sc "
				+ "join PL_Employees e on e.Employee_ID=sc.Sales_Rep "
				+ "join PL_Employee_Group_Employee_Xref ege on ege.Employee_ID=e.Employee_ID and ege.[Primary]=1 "
				+ "join PL_Employee_Groups eg on eg.Employee_Group_ID=ege.Employee_Group_ID "
				+ "and eg.Employee_Group_Type_ID=1245 " + "join PL_Departments d on d.Department_ID=eg.Department_ID "
				+ "join SS_System_Types st1 on st1.System_Type_ID=sc.Drive_Type_ID "
				+ "join PP_Price_Lists price on price.Price_List_ID=sc.Price_List_ID "
				+ "join SS_System_Types st2 on st2.System_Type_ID=sc.Marketing_Plan_ID "
				+ "join SC_Sites site on site.Site_ID=sc.Site_ID "
				+ "join SS_System_Types st3 on st3.System_Type_ID=site.Site_Type_ID "
				+ "join PL_Zips zip on zip.Zip_ID=sc.Marketing_Postal_Code_ID " + "where sc.Screening_ID="+screeningId;

		ResultSet rs2 = DBConnection.connectSQLServer(sqlCommand_02);
		
		//Declare expected variable
		String expected_Representative = "Null";
		String expected_RepresentativeDepartment = "Null";
		String expected_DriveType = "Null";
		String expected_PriceLevel = "Null";
		String expected_FacilityStart = "Null";
		String expected_FacilityClose = "Null";
		String expected_MarketingPlan = "Null";
		String expected_SiteType = "Null";
		String expected_MarketingZipCode = "Null";
		
		//set queries value to declared variables 
		while(rs2.next()){
			expected_Representative = rs2.getString("LName") + ", " +rs2.getString("FName");
			expected_RepresentativeDepartment = rs2.getString("Department_Name");
			expected_DriveType = rs2.getString(4);
			expected_PriceLevel = rs2.getString(6);
			
			//Get facility open time value from db and convert it to correct format as interface 
			String tmp_expected_FacilityStart = "Null";
			tmp_expected_FacilityStart = rs2.getString(7);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			Date dateOpen = dateFormat.parse(tmp_expected_FacilityStart);
			expected_FacilityStart=new SimpleDateFormat("K:mm a").format(dateOpen).toString();

			//Get facility close time value from db and convert it to correct format as interface
			String tmp_expected_FacilityClose = "Null";
			tmp_expected_FacilityClose=rs2.getString(8);
			Date dateClose = dateFormat.parse(tmp_expected_FacilityClose);
			expected_FacilityClose = new SimpleDateFormat("K:mm a").format(dateClose).toString();
			
			//Get marketing plan value from db
			expected_MarketingPlan = rs2.getString(9);
			
			//Get site type form db
			expected_SiteType=rs2.getString(10);
			
			//Get marketing zip code from db
			expected_MarketingZipCode = rs2.getString(11);
		}
			System.out.println(expected_Representative);
			System.out.println(expected_RepresentativeDepartment);
			System.out.println(expected_DriveType);
			System.out.println(expected_PriceLevel);
			System.out.println(expected_FacilityStart);
			System.out.println(expected_FacilityClose);
			System.out.println(expected_MarketingPlan);
			System.out.println(expected_SiteType);
			System.out.println(expected_MarketingZipCode);

			//Verify values seen on screening and values queries from database
			Assert.assertEquals(actual_Representative, expected_Representative);
			Assert.assertEquals(actual_RepresentativeDepartment, expected_RepresentativeDepartment);
			Assert.assertEquals(actual_DriveType, expected_DriveType);
			Assert.assertEquals(actual_PriceLevel, expected_PriceLevel);
			Assert.assertEquals(actual_FacilityStart, expected_FacilityStart);
			Assert.assertEquals(actual_FacilityClose, expected_FacilityClose);
			Assert.assertEquals(actual_MarketingPlan, expected_MarketingPlan);
			Assert.assertEquals(actual_SiteType, expected_SiteType);
			Assert.assertEquals(actual_MarketingZipCode, expected_MarketingZipCode);
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
