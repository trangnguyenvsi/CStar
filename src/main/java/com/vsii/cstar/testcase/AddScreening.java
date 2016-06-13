package com.vsii.cstar.testcase;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vsii.cstar.common.methods.CommonMethod;
import com.vsii.cstar.pages.methods.AppointmentsSingleScreeningPageMethod;
import com.vsii.cstar.pages.methods.ContactInformationPageMethod;
import com.vsii.cstar.pages.methods.HomePageMethods;
import com.vsii.cstar.pages.methods.LoginPageMethods;
import com.vsii.cstar.pages.methods.PackagePageMethod;
import com.vsii.cstar.pages.methods.ProductPageMethod;
import com.vsii.cstar.pages.methods.ProductSetPageMethod;
import com.vsii.cstar.pages.methods.ScreeningInfoMethod;
import com.vsii.cstar.pages.methods.ScreeningInfoMethod.DDLNAME;
import com.vsii.cstar.pages.methods.ScreeningMaintainanceMethods.TAB;
import com.vsii.cstar.pages.methods.ScreeningMaintainanceMethods;
import com.vsii.cstar.pages.methods.SiteAddressPageMethod;
import com.vsii.cstar.pages.methods.SiteAddressPageMethod.SA_ADDRESS_INFO;
import com.vsii.cstar.pages.methods.SiteAddressPageMethod.SA_BUTON;
import com.vsii.cstar.pages.methods.SiteAddressPageMethod.SA_SITE_INFO;
import com.vsii.cstar.pages.methods.SiteAddressPageMethod.SA_TAB;
import com.vsii.cstar.pages.methods.SiteInfoMethod;
import com.vsii.cstar.pages.methods.SiteInfoMethod.SITE_FIELD;
import com.vsii.cstar.pages.methods.SiteListMethod;
import com.vsii.cstar.pages.methods.TeamCalendarMethods;
import com.vsii.tsc.utility.CommonOperations;
import com.vsii.tsc.utility.DBConnection;
import com.vsii.tsc.utility.TestBase;

@Listeners({ com.vsii.tsc.utility.Reports.class })
public class AddScreening {
	WebDriver driver;
	LoginPageMethods objLoginPageMethod;
	HomePageMethods objHomepageMethod;
	TeamCalendarMethods objTeamCalendarMethod;
	ScreeningMaintainanceMethods objScreeningMaintainanceMethod;
	AppointmentsSingleScreeningPageMethod objAptSingleScreenMethod;
	ProductSetPageMethod objProductSetMethod;
	ProductPageMethod objProductPageMethod;
	PackagePageMethod objPackagePageMethod;
	SiteListMethod objSiteListMethod;
	SiteInfoMethod objSiteInfoMethod;
	ScreeningInfoMethod objScreeningInfoMethod;
	SiteAddressPageMethod objSiteAddressPageMethod;
	ContactInformationPageMethod objContactInformationPageMethod;
	public String site_City;
	public String site_State;
	public String site_ZipCode;
	public String countryAbbr;
	public String employeeId;
	public String actual_DriveType;
	public String schedule_Code;
	public String sheduleTime;
	public String timeZone;
	public String actual_SiteName;
	public String HIPAAValue;

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
		objSiteListMethod = new SiteListMethod(driver);
		objSiteInfoMethod = new SiteInfoMethod(driver);
		objScreeningInfoMethod = new ScreeningInfoMethod(driver);
		objSiteAddressPageMethod = new SiteAddressPageMethod(driver);
		objContactInformationPageMethod = new ContactInformationPageMethod(driver);
	}

	@Test(priority = 0, description = "Create new screening and verify infomation at Screening Maintainance screen")
	public void TS01() throws ParseException, IOException, SQLException {
		TestBase.methodName = "TS01";

		// Query db to get zipcode of an exist site for this team
		String sqlCommand_01 = "select TOP(1)zip.Zip_Code from SC_Screenings sc "
				+ "join PL_Teams team on team.Employee_Group_ID=sc.Employee_Group_ID "
				+ "join SC_Sites site on site.Site_ID=sc.Site_ID "
				+ "join PL_Addresses_Sites adrsite on adrsite.Address_Group_ID=site.Address_Group_ID "
				+ "join PL_Zips zip on zip.Zip_ID = adrsite.Zip_ID " + "where team.Team_Code = '" + TestBase.teamCode
				+ "' " + "and adrsite.Geo_Quality_Message='Address validated, EXACT'";

		// Get zip code
		ResultSet rs = DBConnection.connectSQLServer(sqlCommand_01);
		String zipCode = "null";
		while (rs.next()) {
			zipCode = rs.getString(1);
		}

		// Login
		objLoginPageMethod.login(TestBase.userName, TestBase.password);
		// Go to Team Calendar & Grid screen
		objHomepageMethod.mouseHoverScreeningConfig();
		objHomepageMethod.selectSubMenuTeamCalendar();

		// Select month
		objTeamCalendarMethod.selectMonth(CommonMethod.getMonthBaseOnInputDate(TestBase.screeningDate));
		objTeamCalendarMethod.waitForLoadingIconToLoad();

		// Select team
		objTeamCalendarMethod.selectTeam(TestBase.teamCode);
		objTeamCalendarMethod.waitForLoadingIconToLoad();

		// Click add new screening
		objTeamCalendarMethod.rightClickToDateCell(TestBase.screeningDate);
		objTeamCalendarMethod.selectOptionAddScreening();
		objTeamCalendarMethod.waitForLoadingIconToLoad();

		// Site site by queried zip code
		objSiteListMethod.searchSiteByZipCode(zipCode);

		// Select first site in list
		objSiteListMethod.clickFirstSiteInList();

		/**
		 * Start: Colect site information
		 */

		// Get site name
		actual_SiteName = objSiteInfoMethod.getSiteInfo(SITE_FIELD.SITE_NAME).replaceAll("\\s+", " ");
		// System.out.println(actual_SiteName);

		// Get country abbr
		countryAbbr = objSiteInfoMethod.getSiteInfo(SITE_FIELD.COUNTRY_ABBR);

		// Select full country name and phone prefix number from DB
		String sqlCommand_02 = "select TOP(1) Country_Abbr,Country_Name, Country_Phone_Prefix "
				+ "from PL_Countries where Country_Abbr='" + countryAbbr + "'";
		ResultSet rs2 = DBConnection.connectSQLServer(sqlCommand_02);

		String countryName = "null";
		String countryPhonePrefix = "null";
		while (rs2.next()) {
			countryName = rs2.getString(2);
			countryPhonePrefix = rs2.getString(3);
		}

		// Get site city
		site_City = objSiteInfoMethod.getSiteInfo(SITE_FIELD.CITY);
		site_State = objSiteInfoMethod.getSiteInfo(SITE_FIELD.STATE);
		site_ZipCode = objSiteInfoMethod.getSiteInfo(SITE_FIELD.ZIP);

		// Get site address: combie multiple field
		String actual_SiteAddress = objSiteInfoMethod.getSiteInfo(SITE_FIELD.SITE_ADDRESS1) + "\n" + site_City + ", "
				+ site_State + " " + site_ZipCode + "\n" + countryName;

		// Get site phone
		String actual_SitePhone = ("+" + countryPhonePrefix + " " + objSiteInfoMethod.getSiteInfo(SITE_FIELD.PHONE))
				.replaceAll("\\s+", " ");
		if (objSiteInfoMethod.getSiteInfo(SITE_FIELD.PHONE_EXTENSION).toString().isEmpty()) {
			// Do nothing
		} else {
			actual_SitePhone = actual_SitePhone + " x: " + objSiteInfoMethod.getSiteInfo(SITE_FIELD.PHONE_EXTENSION);
		}

		objSiteInfoMethod.getSiteInfo(SITE_FIELD.FAX);

		// Get contact user name
		String actual_ContactName = (objSiteInfoMethod.getSiteInfo(SITE_FIELD.FIRST_NAME) + " "
				+ objSiteInfoMethod.getSiteInfo(SITE_FIELD.MI_NAME) + " "
				+ objSiteInfoMethod.getSiteInfo(SITE_FIELD.LAST_NAME)).replaceAll("\\s+", " ");

		// Get contact mail
		String actual_ContactMail = objSiteInfoMethod.getSiteInfo(SITE_FIELD.CONTACT_EMAIL);

		/**
		 * Stop: Colect site information
		 */

		// Click next to go to Screening Info screen
		objSiteInfoMethod.clickBtnNext();
		objSiteInfoMethod.waitForElementToLoad();

		String actual_RepresentativeVal;
		String actual_MarketingPlan = "Community";

		String actual_ProductSet;
		String actual_PriceList;

		// Select representative
		if ((objScreeningInfoMethod.getAllTextFromDropdownList(DDLNAME.REPRESENTATIVE).size()) < 2) {
			throw new SkipException("There isn'n any representative for this Screening");
		} else {
			actual_RepresentativeVal = objScreeningInfoMethod.getAllTextFromDropdownList(DDLNAME.REPRESENTATIVE).get(1);
			objScreeningInfoMethod.selectRepresentativeByText(actual_RepresentativeVal);
		}

		// Get employee id of selected representative
		employeeId = objScreeningInfoMethod.getEmployeeIdOfSelectedRep();

		// Select marketing plan
		if ((objScreeningInfoMethod.getAllTextFromDropdownList(DDLNAME.MARKETING_PLAN).size()) < 2) {
			throw new SkipException("There isn'n any marketing value in dropdown list");
		} else {
			objScreeningInfoMethod.selectMarketingPlanByText(actual_MarketingPlan);
			objScreeningInfoMethod.waitForElementToLoad();
		}

		// Select drive type
		if ((objScreeningInfoMethod.getAllTextFromDropdownList(DDLNAME.DRIVE_TYPE).size()) < 2) {
			throw new SkipException("There isn'n any drive type value in dropdown list");
		} else {
			actual_DriveType = objScreeningInfoMethod.getAllTextFromDropdownList(DDLNAME.DRIVE_TYPE).get(1);
			objScreeningInfoMethod.selectDriveTypeByText(actual_DriveType);
		}

		if ((objScreeningInfoMethod.getAllTextFromDropdownList(DDLNAME.PRODUCT_SET).size()) < 2) {
			throw new SkipException("There isn'n any product set for this screening");
		} else {
			actual_ProductSet = objScreeningInfoMethod.getAllTextFromDropdownList(DDLNAME.PRODUCT_SET).get(1);
			objScreeningInfoMethod.selectProductSetByItName(actual_ProductSet);
		}

		if ((objScreeningInfoMethod.getAllTextFromDropdownList(DDLNAME.PRICE_LEVEL).size()) < 2) {
			throw new SkipException("There isn'n any price level for this screening");
		} else {
			actual_PriceList = objScreeningInfoMethod.getAllTextFromDropdownList(DDLNAME.PRICE_LEVEL).get(1);
			objScreeningInfoMethod.selectPriceLevelByItName(actual_PriceList);
		}

		if ((objScreeningInfoMethod.getAllTextFromDropdownList(DDLNAME.PRICE_LEVEL).size()) < 2) {
			throw new SkipException("There isn'n any shcedule for this screening");
		} else {

		}

		HIPAAValue = objScreeningInfoMethod.getHIPAAValue();

		// Click buton Save and Continue to Screening
		objScreeningInfoMethod.clickBtnSaveContinueScreening();

		// Collect Address/Contact Info

		String expected_SiteName = objScreeningMaintainanceMethod.getScreeningName();

		String actual_ScreeningStatus = objScreeningMaintainanceMethod.getScreeningStatus();

		String expected_ScreeningStatus = "Preliminary";
		String expected_SiteAddress = objScreeningMaintainanceMethod.getSiteAddress();

		String expected_SitePhone = objScreeningMaintainanceMethod.getSitePhoneNo();

		String expected_ContactName = objScreeningMaintainanceMethod.getSiteContactUser();

		String expected_ContactMail = objScreeningMaintainanceMethod.getSiteContactEmail();

		// Verify site/contact information between Site Info screen and
		// Screening Maintainance screen
		Assert.assertEquals(actual_SiteName, expected_SiteName);
		Assert.assertEquals(actual_ScreeningStatus, expected_ScreeningStatus);
		Assert.assertEquals(actual_SiteAddress, expected_SiteAddress);
		Assert.assertEquals(actual_SitePhone, expected_SitePhone);

		// @note do not compare fax in case test use an exist site to create new
		// screening
		// Assert.assertEquals(actual_SiteFax, expected_SiteFax);
		Assert.assertEquals(actual_ContactName, expected_ContactName);
		Assert.assertEquals(actual_ContactMail, expected_ContactMail);

		// Collect Event Information

		// Get representative name
		String expected_Representative = objScreeningMaintainanceMethod.getScreeningRepresentative();

		// Get marketing plan type
		String expected_MarketingPlan = "Community";

		// Get drive type
		String expected_DriveType = objScreeningMaintainanceMethod.getDriveType();

		// Get schedule code
		schedule_Code = objScreeningMaintainanceMethod.getScreeningScheduleCode();

		// Get schedule time
		sheduleTime = objScreeningMaintainanceMethod.getScreeningScheduleTime();

		// Get timezone
		timeZone = objScreeningMaintainanceMethod.getScreeningTimeZone().trim();

		// Get selected product set in its dropdown box of Product & Pricing tab
		objScreeningMaintainanceMethod.selectProductsPricingTab();
		String expected_ProductSet = objScreeningMaintainanceMethod.getChosenProductSet();

		// Get price list
		String expected_PriceList = objScreeningMaintainanceMethod.getPriceLevel();

		// Verify Event Infomation and relate information of previous screen
		// (Screening Info)
		Assert.assertEquals(actual_RepresentativeVal, expected_Representative);
		Assert.assertEquals(actual_MarketingPlan, expected_MarketingPlan);
		Assert.assertEquals(actual_DriveType, expected_DriveType);
		Assert.assertEquals(actual_ProductSet, expected_ProductSet);
		Assert.assertEquals(actual_PriceList, expected_PriceList);
	}

	@Test(priority = 1, description = "Create new screening and verify infomation at Canlendar screen", dependsOnMethods = "TS01")
	public void TS02() throws ParseException, IOException, SQLException {
		TestBase.methodName = "TS02";

		// Click buton Exit at product & pricing tab
		objScreeningMaintainanceMethod.clickButonExit(TAB.PRODUCTS_PRICING);

		// Query to get name of representative
		String slqCommand_03 = "select Employee_ID, FName, LName from " + "PL_Employees where Employee_ID="
				+ employeeId;
		ResultSet rs = DBConnection.connectSQLServer(slqCommand_03);
		String actual_Representative = "null";
		while (rs.next()) {
			actual_Representative = (rs.getString(2) + " " + rs.getString(3)).replaceAll("\\s+", " ").trim();
		}
		
		

		System.out.println(sheduleTime);
		// get all collected actual data when create new Screening (at TS01)
		String actual_ScreeningInfo = actual_SiteName + "\n" + site_City + " " + site_State + " " + site_ZipCode + "\n"
				+ countryAbbr + "\n" + actual_Representative + "\n" + "Preliminary "
				// because this is new screening so its status should be above
				+ schedule_Code + " " + sheduleTime.split("-")[0].trim() + " " + timeZone + "\n" + actual_DriveType
				+ " 0 min" + "\n" + "$0.00";
		if (HIPAAValue.isEmpty()) {
			// Do nothing
		} else {
			actual_ScreeningInfo = actual_ScreeningInfo + "\n" + "H";
		}

		// because this is new screening so its drive time should be above
		System.out.println("Actual data is: " + actual_ScreeningInfo);

		// get data from calendar
		System.out.println("expect data is: ");

		String expected_ScreeningInfo = objTeamCalendarMethod.getFullScreeningInfo(TestBase.screeningDate);
		System.out.println(expected_ScreeningInfo);

		// Verify result
		Assert.assertEquals(actual_ScreeningInfo, expected_ScreeningInfo);
	}

	@Test(priority = 2, description = "Edit site address/contact and verify them", dependsOnMethods = "TS01")
	public void TS03() throws ParseException {
		// Go back to Screening Maintainance screen
		objTeamCalendarMethod.selectScreeningByInputDate(TestBase.screeningDate);

		// Click Edit Site
		objScreeningMaintainanceMethod.clickEditSite();

		// start
		objSiteAddressPageMethod.selectTab(SA_TAB.SITE_INFORMATION);
		objSiteAddressPageMethod.clickEditButonInTab(SA_TAB.SITE_INFORMATION, 1);
		objSiteAddressPageMethod.inputDataToSiteInformationTab(SA_SITE_INFO.SITE_NAME, "Khong duoc xoa");
		objSiteAddressPageMethod.inputDataToSiteInformationTab(SA_SITE_INFO.WEBSITE, "mail.gmail.com");
		objSiteAddressPageMethod.inputDataToSiteInformationTab(SA_SITE_INFO.SITE_TYPE, "Church");
		objSiteAddressPageMethod.inputDataToSiteInformationTab(SA_SITE_INFO.CHECK_BOX, "Ample Parking").click();
		objSiteAddressPageMethod.clickButon(SA_TAB.SITE_INFORMATION, SA_BUTON.SAVE);

		objSiteAddressPageMethod.selectTab(SA_TAB.ADDRESS);
		objSiteAddressPageMethod.clickEditButonInTab(SA_TAB.ADDRESS, 1);
		objSiteAddressPageMethod.inputDataToAddEditAddressForm(SA_ADDRESS_INFO.ADDRESS1,
				"6150 oak tree blvd s - Modified");
		objSiteAddressPageMethod.inputDataToAddEditAddressForm(SA_ADDRESS_INFO.ZIP_CODE, "10001");
		// Thread.sleep(6000);
		objSiteAddressPageMethod.clickButon(SA_TAB.ADDRESS, SA_BUTON.SAVE);

		objSiteAddressPageMethod.selectTab(SA_TAB.PHONE);
		objSiteAddressPageMethod.clickEditButonInTab(SA_TAB.PHONE, 1);
		objSiteAddressPageMethod.inputDataToUpdatePhoneForm(0, "Office", "(555) 444-3333", "");

		// Edit contact
		objSiteAddressPageMethod.viewContactInfo(1);
		objContactInformationPageMethod.clickEditContact();

		objContactInformationPageMethod.clickEditAddressByLocation(1);
		objContactInformationPageMethod.updateAddressInformation(0, "United States", "Home",
				"6150 oak tree blvd s - Modified", "add2", "add3", "44131", "1234", "Dont know yet", 0, "", "");

		objContactInformationPageMethod.selectTabPhone();
		objContactInformationPageMethod.clickEditPhoneByLocation(1);
		objContactInformationPageMethod.updatePhoneInformation(0, "Mobile", "(555) 555-54321", "");

		objContactInformationPageMethod.selectTabEmail();
		objContactInformationPageMethod.clickEditEmailByLocation(2);
		objContactInformationPageMethod.updateEmailInformation(1, "Office", "abc@gmail.com");

		objContactInformationPageMethod.updateContactInformation(0, "Dr.", "Test", "MI", "Mister", "Jr", "Billing",
				"Doc.", "No cmt");

	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws Exception {
		CommonOperations.getMethodTestResult(testResult);
		CommonOperations.takePicture();
	}

	@AfterClass
	public void end() {
		driver.quit();
	}
}
