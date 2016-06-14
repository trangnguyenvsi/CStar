package com.vsii.cstar.testcase;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vsii.cstar.common.methods.CommonMethod;
import com.vsii.cstar.pages.methods.ContactInformationPageMethod;
import com.vsii.cstar.pages.methods.HomePageMethods;
import com.vsii.cstar.pages.methods.LoginPageMethods;
import com.vsii.cstar.pages.methods.ScreeningInfoMethod;
import com.vsii.cstar.pages.methods.ScreeningMaintainanceMethods;
import com.vsii.cstar.pages.methods.SiteInfoMethod;
import com.vsii.cstar.pages.methods.SiteInfoMethod.SITE_FIELD;
import com.vsii.cstar.pages.methods.SiteListMethod;
import com.vsii.cstar.pages.methods.TeamCalendarMethods;
import com.vsii.cstar.pages.methods.ScreeningMaintainanceMethods.TAB;
import com.vsii.cstar.testdata.AddScreeningData;
import com.vsii.cstar.testdata.Screening;
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
	SiteListMethod objSiteListMethod;
	SiteInfoMethod objSiteInfoMethod;
	ScreeningInfoMethod objScreeningInfoMethod;
	ContactInformationPageMethod objContactInformationPageMethod;
	Screening objScreening;
	boolean useExistingSite;

	static Properties p;

	@BeforeClass
	public void start() throws IOException, InterruptedException {
		driver = TestBase.driver;
		objLoginPageMethod = new LoginPageMethods(driver);
		objHomepageMethod = new HomePageMethods(driver);
		objTeamCalendarMethod = new TeamCalendarMethods(driver);
		objScreeningMaintainanceMethod = new ScreeningMaintainanceMethods(driver);
		objSiteListMethod = new SiteListMethod(driver);
		objSiteInfoMethod = new SiteInfoMethod(driver);
		objScreeningInfoMethod = new ScreeningInfoMethod(driver);
		objScreening = new Screening();
		objContactInformationPageMethod = new ContactInformationPageMethod(driver);
	}

	@Test(priority = 0, description = "login successfully", dataProvider = "Choose setup screening kind", dataProviderClass = AddScreeningData.class)
	public void TS01(String isCreateScreeningByExistingSite) {
		TestBase.methodName = "TS01";
		System.out.println("Executing: Testcase TS01: Login successfully");

		objLoginPageMethod.login(TestBase.userName, TestBase.password);
		Assert.assertEquals(objHomepageMethod.getLoginAccount(), TestBase.userName);

		// Create trigger to run script (setup new screening by existing site or
		// by creating new site)
		if (isCreateScreeningByExistingSite.equals("true") == true) {
			useExistingSite = true;
		} else {
			useExistingSite = false;
		}

		System.out.println(useExistingSite);
		System.out.println("Completed" + "\n");
	}

	@Test(priority = 1, description = "Click to Team Calendar & Grid")
	public void TS02() {
		TestBase.methodName = "TS02";
		System.out.println(
				"Executing: Testcase TS02: Click on menu Team Calendar & Grid and verify new displayed screen");

		objHomepageMethod.mouseHoverScreeningConfig();
		objHomepageMethod.selectSubMenuTeamCalendar();

		Assert.assertEquals(objTeamCalendarMethod.getPageHeader(), "Team Calendar");

		System.out.println("Completed" + "\n");
	}

	@Test(priority = 2, description = "Verify status of current date on calendar")
	public void TS03() {
		TestBase.methodName = "TS03";
		System.out.println("Executing: Testcase TS03: Verify status of current date on calendar");

		try {
			// Get server datetime
			URL obj = new URL("http://172.17.60.220:888/Login.aspx");
			URLConnection conn = obj.openConnection();
			Map<String, List<String>> map = conn.getHeaderFields();

			String date = map.get("Date").get(0);
			System.out.println(date);

			// Get current UTC datetime
			SimpleDateFormat formatDate1 = new SimpleDateFormat("EEE, d MMM yyyy hh:mm:ss z");
			SimpleDateFormat formatDate2 = new SimpleDateFormat("M/d/yyyy");
			Date date2 = formatDate1.parse(date);

			Calendar cal = Calendar.getInstance();
			cal.setTime(date2);
			cal.add(Calendar.HOUR_OF_DAY, -11);

			String currentDate = formatDate2.format(cal.getTime());

			// Get current date's border color
			String currDateBorderColor = driver.findElement(
					By.xpath("//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
							+ currentDate + "')]"))
					.getCssValue("border-top-color");

			// Verify current date must have border color is yellow
			Assert.assertEquals(currDateBorderColor, "rgba(255, 154, 0, 1)");

			String server = conn.getHeaderField("Server");

			if (server == null) {
				System.out.println("Key 'Server' is not found!");
			} else {
				System.out.println("Server - " + server);
			}

			System.out.println("\n Done");

		} catch (Exception e) {
			System.out.println("could connect to site");
			e.printStackTrace();
		}

		System.out.println("Completed" + "\n");
	}

	@Test(priority = 3, description = "Check month, year change function")
	public void TS04() throws ParseException, IOException, SQLException {
		TestBase.methodName = "TS04";
		System.out.println(
				"Executing: Testcase TS04: Check month, year that display on calendar when change those information in dropdown list");
		objTeamCalendarMethod.selectMonth("April");
		objTeamCalendarMethod.waitForLoadingIconToLoad();
		objTeamCalendarMethod.selectYear("2016");
		objTeamCalendarMethod.waitForLoadingIconToLoad();

		Assert.assertEquals(objTeamCalendarMethod.getSelectedMonthYear(), "April 2016");

		objTeamCalendarMethod.selectMonth("June");
		objTeamCalendarMethod.waitForLoadingIconToLoad();
		objTeamCalendarMethod.selectYear("2016");
		objTeamCalendarMethod.waitForLoadingIconToLoad();

		Assert.assertEquals(objTeamCalendarMethod.getSelectedMonthYear(), "June 2016");

		// Go Site List screen again
		objTeamCalendarMethod.selectMonth(CommonMethod.getMonthBaseOnInputDate(TestBase.screeningDate));
		objTeamCalendarMethod.waitForLoadingIconToLoad();
		objTeamCalendarMethod.selectYear(CommonMethod.getYearBaseOnInputDate(TestBase.screeningDate));
		objTeamCalendarMethod.waitForLoadingIconToLoad();
		objTeamCalendarMethod.selectTeam(TestBase.teamCode);
		objTeamCalendarMethod.waitForLoadingIconToLoad();

		System.out.println("Completed" + "\n");

	}

	@Test(priority = 4, description = "verify types of view when select Calendar and select Grid")

	public void TS05() {
		TestBase.methodName = "TS05";
		System.out.println("Executing: Testcase TS05: Verify types of view when select Calendar and select Grid View");
		// Select grid view
		objTeamCalendarMethod.selectGridView();
		objTeamCalendarMethod.waitForLoadingIconToLoad();

		// Is grid display?
		boolean isGridView = false;
		if (driver.findElements(By.id("ctl00_plcMain_grdSchedule")).size() != 0) {
			isGridView = true;
		}
		Assert.assertTrue(isGridView);

		// Select calendar view
		objTeamCalendarMethod.selectCalendarView();
		objTeamCalendarMethod.waitForLoadingIconToLoad();

		// Is calendar display?
		boolean isCalendarView = false;
		if (driver.findElements(By.id("ctl00_plcMain_calSchedule")).size() != 0) {
			isCalendarView = true;
		}
		Assert.assertTrue(isCalendarView);

		System.out.println("Completed" + "\n");
	}

	@Test(priority = 5, description = "Verify Reserved Date function")
	public void TS06() throws ParseException {
		TestBase.methodName = "TS06";
		System.out.println("Executing: Testcase TS06: Verify Reserved Date function");
		String selectedTerritory = "Cleveland East";
		String date = TestBase.screeningDate;

		// reserved a date
		objTeamCalendarMethod.reservedDate(date, selectedTerritory);
		// verify result - at selected date should show "Reserved + name of
		// territory

		Assert.assertEquals(objTeamCalendarMethod.getReservedInfo(date), ("Reserved " + selectedTerritory));
		System.out.println("Completed" + "\n");
	}

	@Test(priority = 6, description = "To check Site List screen when click Add Screening")
	public void TS07() throws ParseException {
		TestBase.methodName = "TS07";
		System.out.println("Executing: Testcase TS07: Check Site List screen when click Add Screening");

		objTeamCalendarMethod.rightClickToDateCell(TestBase.screeningDate);
		objTeamCalendarMethod.addScreening();
		objTeamCalendarMethod.waitForLoadingIconToLoad();

		Assert.assertEquals(objSiteListMethod.getPageHeader(), "List Screening");
		Assert.assertEquals(objSiteListMethod.getPageDefaultQuestion(),
				"What is the zip code of the screening you would like to enter?");

		System.out.println("Completed" + "\n");
	}

	@Test(priority = 7, description = "Verify Return to Calendar button function")
	public void TS08() throws ParseException, IOException, SQLException {
		TestBase.methodName = "TS08";
		System.out.println("Executing: Testcase TS08: Verify Return to Calendar button function");

		objSiteListMethod.clickReturnTeamCalendar();
		objSiteListMethod.waitToElementLoaded();

		// Check if Team Calendar screen is appeared or not
		Assert.assertEquals(objTeamCalendarMethod.getPageHeader(), "Team Calendar");

		// // Go Site List screen again
		// objTeamCalendarMethod.selectMonth(CommonMethod.getMonthBaseOnInputDate(TestBase.screeningDate));
		// objTeamCalendarMethod.waitForLoadingIconToLoad();
		// objTeamCalendarMethod.selectYear(CommonMethod.getYearBaseOnInputDate(TestBase.screeningDate));
		// objTeamCalendarMethod.waitForLoadingIconToLoad();
		// objTeamCalendarMethod.selectTeam(TestBase.teamCode);
		// objTeamCalendarMethod.waitForLoadingIconToLoad();
		objTeamCalendarMethod.rightClickToDateCell(TestBase.screeningDate);
		objTeamCalendarMethod.addScreening();
		objTeamCalendarMethod.waitForLoadingIconToLoad();

		System.out.println("Completed" + "\n");
	}

	@Test(priority = 8, dataProvider = "VerifyZipCode", dataProviderClass = AddScreeningData.class)
	public void TS09(String zipCode, String isCorrect) throws ParseException {
		TestBase.methodName = "TS09";
		System.out.println("Executing: Testcase TS09: Verify validation zipcode function");

		boolean isC = false;
		if (isCorrect.equals("true")) {
			isC = true;
		}

		objSiteListMethod.clearZipCode();

		if (objSiteListMethod.isLoadingIMGDisplayed() == true) {
			objSiteListMethod.waitToElementLoaded();
		}

		objSiteListMethod.enterZipCode(zipCode);
		objSiteListMethod.clickBtnVerifyZip();
		objSiteListMethod.waitToElementLoaded();

		boolean actual_Message = objSiteListMethod.isZipCodeCorrect();
		Assert.assertEquals(actual_Message, isC);

		System.out.println("Completed" + "\n");
	}

	@Test(priority = 9, description = "Select existing site to setup screening", dataProvider = "Existing Site", dataProviderClass = AddScreeningData.class)
	public void TS10(String zipCode, String siteName) {
		TestBase.methodName = "TS10";
		System.out.println("Executing: Testcase TS10: Select existing site to setup screening");
		if (useExistingSite == true) {

			// Enter zipcode which has existing site
			objSiteListMethod.clearZipCode();
			objSiteListMethod.waitToElementLoaded();
			objSiteListMethod.enterZipCode(zipCode);
			objSiteListMethod.clickBtnVerifyZip();
			objSiteListMethod.waitToElementLoaded();

			// Click search to show up existing site
			objSiteListMethod.clickBtnSearch();
			objSiteInfoMethod.waitForElementToLoad();

			// Click to existing site by site's name
			String xpath_ExistingSiteLocator = "//a[contains(text(),'" + siteName + "')]";
			driver.findElement(By.xpath(xpath_ExistingSiteLocator)).click();
			objSiteInfoMethod.waitForElementToLoad();

			// Verify site's name in new displayed screen
			Assert.assertEquals(objSiteInfoMethod.getSiteInfo(SITE_FIELD.SITE_NAME), siteName);

			// Store site address/contact informations to object Screening to
			// verify with created Screening later
			objScreening.setSiteName(objSiteInfoMethod.getSiteInfo(SITE_FIELD.SITE_NAME));
			objScreening.setSiteType(objSiteInfoMethod.getSiteInfo(SITE_FIELD.SITE_TYPE));
			objScreening.setSiteAddressType(objSiteInfoMethod.getSiteInfo(SITE_FIELD.ADDRESS_TYPE));
			objScreening.setSiteAddress1(objSiteInfoMethod.getSiteInfo(SITE_FIELD.SITE_ADDRESS1));
			objScreening.setSiteAddress2(objSiteInfoMethod.getSiteInfo(SITE_FIELD.SITE_ADDRESS2));
			objScreening.setSiteAddress3(objSiteInfoMethod.getSiteInfo(SITE_FIELD.SITE_ADDRESS3));
			objScreening.setSiteCountry(objSiteInfoMethod.getSiteInfo(SITE_FIELD.COUNTRY_ABBR));
			objScreening.setSiteZipCode(objSiteInfoMethod.getSiteInfo(SITE_FIELD.ZIP));
			objScreening.setSiteCity(objSiteInfoMethod.getSiteInfo(SITE_FIELD.CITY));
			objScreening.setSiteState(objSiteInfoMethod.getSiteInfo(SITE_FIELD.STATE));
			objScreening.setContactFirstName(objSiteInfoMethod.getSiteInfo(SITE_FIELD.FIRST_NAME));
			objScreening.setContactMIName(objSiteInfoMethod.getSiteInfo(SITE_FIELD.MI_NAME));
			objScreening.setContactLastName(objSiteInfoMethod.getSiteInfo(SITE_FIELD.LAST_NAME));
			objScreening.setContactType(objSiteInfoMethod.getSiteInfo(SITE_FIELD.CONTACT_TYPE));
			objScreening.setContactEmail(objSiteInfoMethod.getSiteInfo(SITE_FIELD.CONTACT_EMAIL));

			if (objSiteInfoMethod.getSiteInfo(SITE_FIELD.CONTACT_EMAIL_TYPE).equals("Select Type")) {
				objScreening.setContactEmailType("");
			} else {
				objScreening.setContactEmailType(objSiteInfoMethod.getSiteInfo(SITE_FIELD.CONTACT_EMAIL_TYPE));
			}
			objScreening.setContactPhoneNo(objSiteInfoMethod.getSiteInfo(SITE_FIELD.PHONE));
			objScreening.setContactPhoneType(objSiteInfoMethod.getSiteInfo(SITE_FIELD.PHONE_TYPE));
			objScreening.setContactPhoneExtension(objSiteInfoMethod.getSiteInfo(SITE_FIELD.PHONE_EXTENSION));

			// Click next to go to Screeing Info screen
			objSiteInfoMethod.clickBtnNext();
			objSiteInfoMethod.waitForElementToLoad();
		} else {
			throw new SkipException("Skip this testcase because configuration is create new site to set up screening");
		}

		System.out.println("Completed" + "\n");

	}

	@Test(priority = 10, description = "Create new site to setup screening")
	public void TS11() throws ParseException {
		TestBase.methodName = "TS11";
		System.out.println("Executing: Testcase TS11: Create new site to setup screening");
		if (useExistingSite == false) {
			objSiteListMethod.clickBtnSearch();
			// objSiteInfoMethod.waitForElementToLoad();
			// objSiteListMethod.clickBtnNewSite();
			// objSiteInfoMethod.waitForElementToLoad();
			new WebDriverWait(driver, 30)
					.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_imgLoading")));

			driver.findElement(By.id("ctl00_plcMain_btnNewSite")).click();
			new WebDriverWait(driver, 30)
					.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_imgLoading")));

			// Assert.assertEquals(objSiteInfoMethod.getHeaderText(), "New
			// Screening Wizard");
			// Assert.assertEquals(objSiteInfoMethod.getTeamDateInfo(), ("Team:
			// " + TestBase.teamCode + " Screening Date: "
			// +
			// objTeamCalendarMethod.convertDate(TestBase.screeningDate).trim().replaceAll("\\s+",
			// " ")));

		} else {
			throw new SkipException(
					"Skip this testcase because configuration is use existing site to set up screening");
		}
		System.out.println("Completed" + "\n");
	}

	@Test(priority = 11, description = "To check validation address function", dataProvider = "Validation Address", dataProviderClass = AddScreeningData.class)
	public void TS12(String address1, String expectMessage) throws InterruptedException {
		TestBase.methodName = "TS12";
		System.out.println("Executing: Testcase TS12: Check validation address function");

		if (useExistingSite == false) {

			// Input address line 1
			objSiteInfoMethod.clearAddress1();
			objSiteInfoMethod.inputAddress1(address1);

			// While validate message is not displayed, click to 2 textbox
			// Address 1
			// and Address 2 until it's displayed
			while (objSiteInfoMethod.getAddressStatus().length() == 0) {
				objSiteInfoMethod.objSiteInfo.getTxt_SiteAddress2().click();
				objSiteInfoMethod.objSiteInfo.getTxt_SiteAddress1().click();
			}

			// If validate message is "Bad Address", then close suggestion popup
			// first
			if (objSiteInfoMethod.getAddressStatus().equals("Bad Address") == true) {
				new WebDriverWait(driver, 30)
						.until(ExpectedConditions.visibilityOfElementLocated(By.id("scWizAddrSugContainer")));
				objSiteInfoMethod.closeAddressSuggestion();
			}

			// Verify address
			Assert.assertEquals(objSiteInfoMethod.getAddressStatus(), expectMessage);

			// Reload page for next test
			driver.navigate().refresh();
		} else {
			throw new SkipException(
					"Skip this testcase because configuration is use existing site to set up screening");
		}

		System.out.println("Completed" + "\n");

	}

	@Test(priority = 12, description = "Create new site", dataProvider = "CreateNewSite", dataProviderClass = AddScreeningData.class)
	public void TS13(String zipCode, String siteName, String siteType, String addressType, String address1,
			String address2, String address3, String city, String manualGeoCode, String latitude, String longitude,
			String salutation, String firstName, String MIName, String lastName, String suffix, String contactType,
			String email, String emailType, String siteEmail, String siteEmailType, String phoneNo,
			String phoneExtension, String phoneType, String faxNo, String website) {

		TestBase.methodName = "TS13";
		System.out.println("Executing: Testcase TS13: Create new site successfully");

		if (useExistingSite == false) {

			// Get site city information

			if (city.equals("0")) {
				objScreening.setSiteCity(objSiteInfoMethod.getSiteInfo(SITE_FIELD.CITY));
			} else {
				objScreening.setSiteCity(city);
			}

			// Get site zipcode
			String siteZipcode = objSiteInfoMethod.getSiteInfo(SITE_FIELD.ZIP);
			// Get site state
			String siteState = objSiteInfoMethod.getSiteInfo(SITE_FIELD.STATE);
			// Get site country
			String siteCountry = objSiteInfoMethod.getSiteInfo(SITE_FIELD.COUNTRY_ABBR);

			int check = Integer.parseInt(manualGeoCode);

			objSiteInfoMethod.createNewSite(siteName, siteType, addressType, address1, address2, address3, city, check,
					latitude, longitude, salutation, firstName, MIName, lastName, suffix, contactType, email, emailType,
					siteEmail, siteEmailType, phoneNo, phoneExtension, phoneType, faxNo, website);

			// Set input data to an object to use to verify in other screen
			objScreening.setSiteName(siteName);
			objScreening.setSiteType(siteType);
			objScreening.setSiteAddressType(addressType);
			objScreening.setSiteAddress1(address1);
			objScreening.setSiteAddress2(address2);
			objScreening.setSiteAddress3(address3);
			objScreening.setSiteZipCode(siteZipcode);
			objScreening.setSiteState(siteState);
			objScreening.setSiteCountry(siteCountry);
			objScreening.setContactFirstName(firstName);
			objScreening.setContactMIName(MIName);
			objScreening.setContactLastName(lastName);
			objScreening.setContactType(contactType);
			objScreening.setContactEmail(email);
			objScreening.setContactEmailType(emailType);
			objScreening.setContactPhoneNo(phoneNo);
			objScreening.setContactPhoneExtension(phoneExtension);
			objScreening.setContactPhoneType(phoneType);
		} else {
			throw new SkipException(
					"Skip this testcase because configuration is use existing site to set up screening");
		}

		System.out.println("Completed" + "\n");

	}

	@Test(priority = 13, description = "Verify dropdown ACO Type when Marketing Plan is ACO and when Marketing Plan is other choice", dataProvider = "ACO Type Verification", dataProviderClass = AddScreeningData.class)
	public void TS14(String marketingPlan, String isACOTypeEnabled) {

		TestBase.methodName = "TS14";
		System.out.println(
				"Executing: Testcase TS14: Verify dropdown ACO Type when Marketing Plan is ACO and when Marketing Plan is other choice");
		boolean isTrue;
		boolean isACOTypeAbleToSelect = false;

		// Declare value of isDisable base on test data
		if (isACOTypeEnabled.equals("yes")) {
			isTrue = true;
		} else {
			isTrue = false;
		}

		// Select ACO for Marketing plan
		objScreeningInfoMethod.selectMarketingPlanByText(marketingPlan);
		objScreeningInfoMethod.waitForElementToLoad();

		// Get atribute "disabled" of ACO Type dropdown
		String atb_ACOType = objScreeningInfoMethod.objScreeningInfo.getDdl_ACOType().getAttribute("disabled");

		// If marketing plan is another value than ACO, atribute disable should
		// be visibled and has value is "disable"
		if (atb_ACOType == null) {
			isACOTypeAbleToSelect = true;
		}

		// Verify status of ACO Type when Marketing plan is selected
		Assert.assertEquals(isACOTypeAbleToSelect, isTrue);
		System.out.println("Completed" + "\n");

	}

	@Test(priority = 14, description = "Save and continue to Screening when all mandatory field is fullfilled and valid", dataProvider = "ScreeningInfoData", dataProviderClass = AddScreeningData.class)
	public void TS15(String repName, String marketingPlan, String acoType, String driveType, String siteOpenTime,
			String siteCloseTime, String productSetName, String priceLevelName, String scheduleCode)
			throws IOException, SQLException {
		TestBase.methodName = "TS15";
		System.out.println(
				"Executing: Testcase TS15: Save and continue to Screening when all mandatory field is fullfilled and valid");
		// Set input data to an object to use to verify in other screen
		objScreening.setRepresentative(repName);
		objScreening.setMarketingPlan(marketingPlan);
		objScreening.setDriverType(driveType);
		if (siteOpenTime.equals("default") == true) {
			objScreening.setSiteOpenTime(
					objScreeningInfoMethod.objScreeningInfo.getTxt_SiteHoursOpenTime().getAttribute("value"));
		} else {
			objScreening.setSiteOpenTime(siteOpenTime);
		}

		if (siteCloseTime.equals("default") == true) {
			objScreening.setSiteCloseTime(
					objScreeningInfoMethod.objScreeningInfo.getTxt_SiteHoursCloseTime().getAttribute("value"));
		} else {
			objScreening.setSiteCloseTime(siteCloseTime);
		}

		objScreening.setProductSet(productSetName);
		objScreening.setPriceLevel(priceLevelName);

		if (scheduleCode.equals("default") == true) {
			objScreening.setScheduleCode(new Select(objScreeningInfoMethod.objScreeningInfo.getDropdown_ScheduleCode())
					.getFirstSelectedOption().getText());
		} else {
			objScreening.setScheduleCode(scheduleCode);
		}

		// Get Employee Id of CSR, because this id is used to get expected name
		// to verify CSR in calendar
		objScreeningInfoMethod.selectRepresentativeByText(repName);
		// Set it value (id) in Object Screening
		objScreening.setEmployeeId(objScreeningInfoMethod.getEmployeeIdOfSelectedRep());

		// Get HIPAAValue
		objScreening.setHIPAAValue(objScreeningInfoMethod.getHIPAAValue());

		// Input data to Screening Info form
		objScreeningInfoMethod.updateScreeningInfo(repName, marketingPlan, acoType, driveType, siteOpenTime,
				siteCloseTime, productSetName, priceLevelName, scheduleCode);

		// Get Screening Id (use for query later)
		String screeningMarketingId = driver.getCurrentUrl().split("ScreeningLinkID=")[1];
		if (screeningMarketingId.contains("|")) {
			objScreening.setScreeningId(screeningMarketingId.split("\\|")[0]);
		} else {
			objScreening.setScreeningId(screeningMarketingId);
		}

		// Verify Screening Maintainance screen should display after click Save
		// & Continue to Screening successfully

		Assert.assertEquals(objScreeningMaintainanceMethod.getPageHeader(), "Screening Maintenance");

		// Verify site infomation and screening information

		// Get full country name
		String queryCountryName = "select TOP(1) Country_Abbr,Country_Name, Country_Phone_Prefix "
				+ "from PL_Countries where Country_Abbr='" + objScreening.getSiteCountry() + "'";
		ResultSet rs2 = DBConnection.connectSQLServer(queryCountryName);

		String countryName = "null";
		String countryPhonePrefix = "null";
		while (rs2.next()) {
			countryName = rs2.getString(2);
			countryPhonePrefix = rs2.getString(3);
		}

		// Get delivery point
		String queryGetDeliveryPoint = "select TOP(1)adr.Delivery_point from PL_Addresses_Sites adr "
				+ "join SC_Sites site on site.Address_Group_ID = adr.Address_Group_ID " + "where site.Site_Name ='"
				+ objScreening.getSiteName() + "'";
		ResultSet listDeliveryPoint = DBConnection.connectSQLServer(queryGetDeliveryPoint);
		String fourPlus = "";
		while (listDeliveryPoint.next()) {
			fourPlus = listDeliveryPoint.getString(1);
		}

		// Define expected screening's site address
		String expected_SiteAddress = "";
		if (fourPlus == null) {
			expected_SiteAddress = (objScreening.getSiteAddress1() + "\n" + objScreening.getSiteAddress2() + "\n"
					+ objScreening.getSiteAddress3() + "\n" + objScreening.getSiteCity() + ", "
					+ objScreening.getSiteState() + " " + objScreening.getSiteZipCode() + "\n" + countryName)
							.replaceAll("[\n]+", "\n");
		} else {
			expected_SiteAddress = (objScreening.getSiteAddress1() + "\n" + objScreening.getSiteAddress2() + "\n"
					+ objScreening.getSiteAddress3() + "\n" + objScreening.getSiteCity() + ", "
					+ objScreening.getSiteState() + " " + objScreening.getSiteZipCode() + "-" + fourPlus + "\n"
					+ countryName).replaceAll("[\n]+", "\n");
		}

		// Verify screening's site address
		Assert.assertEquals(objScreeningMaintainanceMethod.getSiteAddress(), expected_SiteAddress);

		// Define expected contact name
		String expected_ContactName = (objScreening.getContactFirstName() + " " + objScreening.getContactMIName() + " "
				+ objScreening.getContactLastName()).replaceAll("\\s+", " ");

		// Verify contact name
		Assert.assertEquals(objScreeningMaintainanceMethod.getSiteContactUser(), expected_ContactName);

		// Verify contact type
		Assert.assertEquals(objScreeningMaintainanceMethod.getSiteContactType(), objScreening.getContactType());

		// Define expected contact phone number
		String expected_ContactPhoneNo = "+" + countryPhonePrefix + " " + objScreening.getContactPhoneNo();
		// If contact phone has extension, then after phone no should be has
		// character (x:) and extension value
		if (!objScreening.getContactPhoneExtension().isEmpty()) {
			expected_ContactPhoneNo = expected_ContactPhoneNo + " x: " + objScreening.getContactPhoneExtension();
		}

		// Verify contact phone number
		Assert.assertEquals(objScreeningMaintainanceMethod.getSiteContactPhone(), expected_ContactPhoneNo);

		// Verify contact phone type
		Assert.assertEquals(objScreeningMaintainanceMethod.getSiteContactPhoneType(),
				objScreening.getContactPhoneType());

		// Verify contact email
		Assert.assertEquals(objScreeningMaintainanceMethod.getSiteContactEmail(), objScreening.getContactEmail());

		// Verify contact email type
		Assert.assertEquals(objScreeningMaintainanceMethod.getSiteContactEmailType(),
				objScreening.getContactEmailType());

		// Verify CSR name
		Assert.assertEquals(objScreeningMaintainanceMethod.getScreeningRepresentative(),
				objScreening.getRepresentative());

		// Verify marketing plan type
		Assert.assertEquals(objScreeningMaintainanceMethod.getMarketingPlan(), objScreening.getMarketingPlan());

		// Verify drive type
		Assert.assertEquals(objScreeningMaintainanceMethod.getScreeningDriveType(), objScreening.getDriverType());

		// Verify facility time
		String expected_FacilityTime = objScreening.getSiteOpenTime() + " - " + objScreening.getSiteCloseTime();
		Assert.assertEquals(objScreeningMaintainanceMethod.getFacilityTime(), expected_FacilityTime);

		// Get schedule time to verify it with Team Calendar screen
		objScreening.setScheduleTime(objScreeningMaintainanceMethod.getScreeningScheduleTime());

		System.out.println("Completed" + "\n");
	}

	@Test(priority = 15, description = "Verify fields in Site Info tab")
	public void TS16() {
		TestBase.methodName = "TS16";
		System.out.println("Executing: Testcase TS16: Verify fields in Site Info tab");
		// Select site info tab
		objScreeningMaintainanceMethod.selectSiteInfoTab();

		// Verify label Screening requirements should displayed in this tab
		Assert.assertTrue(
				objScreeningMaintainanceMethod.objScreeningMaintainance.getLbl_ScreeningRequirements().isDisplayed());

		// Verify label Note for Ultrasound Team should displayed in this tab
		Assert.assertTrue(
				objScreeningMaintainanceMethod.objScreeningMaintainance.getLbl_Note4UltraSound().isDisplayed());

		// Verify label Note for Call Center should displayed in this tab
		Assert.assertTrue(
				objScreeningMaintainanceMethod.objScreeningMaintainance.getLbl_Note4CallCenter().isDisplayed());

		// Verify label Dimensions should displayed in this tab
		Assert.assertTrue(objScreeningMaintainanceMethod.objScreeningMaintainance.getLbl_Dimensions().isDisplayed());
		System.out.println("Completed" + "\n");
	}

	@Test(priority = 16, description = "Verify fields in Accounting tab")
	public void TS17() {
		TestBase.methodName = "TS17";
		System.out.println("Executing: Testcase TS17: Verify fields in Accounting tab");
		// Select Accounting tab
		objScreeningMaintainanceMethod.selectAccountingTab();

		// Verify label Payments FulFilled should displayed in this tab
		Assert.assertTrue(
				objScreeningMaintainanceMethod.objScreeningMaintainance.getLbl_PaymentsFulFilled().isDisplayed());

		// Verify label Payments Requested should displayed in this tab
		Assert.assertTrue(
				objScreeningMaintainanceMethod.objScreeningMaintainance.getLbl_PaymentsRequested().isDisplayed());

		// Verify label Total should displayed in this tab
		Assert.assertTrue(objScreeningMaintainanceMethod.objScreeningMaintainance.getLbl_Total().isDisplayed());

		// Verify hyper link Add a Check Request should displayed in this tab
		Assert.assertTrue(
				objScreeningMaintainanceMethod.objScreeningMaintainance.getLnk_AddCheckRequest().isDisplayed());
		System.out.println("Completed" + "\n");
	}

	@Test(priority = 17, description = "Verify fields in Product & Pricing tab")
	public void TS18() {
		TestBase.methodName = "TS18";
		System.out.println("Executing: Testcase TS18: Verify fields in Product & Pricing tab");

		// Select Products & Pricing tab
		objScreeningMaintainanceMethod.selectProductsPricingTab();

		// Verify Dropdown Select Product Set should be displayed
		Assert.assertTrue(objScreeningMaintainanceMethod.objScreeningMaintainance.getDdl_ProductSet().isDisplayed());

		// Verify Dropdown Select Price Level should be displayed
		Assert.assertTrue(objScreeningMaintainanceMethod.objScreeningMaintainance.getDdl_PriceLevel().isDisplayed());
		System.out.println("Completed" + "\n");
	}

	@Test(priority = 18, description = "Verify fields in Travel tab")
	public void TS19() {
		TestBase.methodName = "TS19";
		System.out.println("Executing: Testcase TS19: Verify fields in Travel tab");

		// Select Travel tab
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_Travel().click();

		// Verify label From start point to site should be displayed on this tab
		Assert.assertTrue(
				objScreeningMaintainanceMethod.objScreeningMaintainance.getLbl_FromStartPointToSite().isDisplayed());

		// Verify label From site to end point should be displayed on this tab
		Assert.assertTrue(
				objScreeningMaintainanceMethod.objScreeningMaintainance.getLbl_FromSiteToEndPoint().isDisplayed());

		// Verify button Calculate Directions should be displayed on this tab
		Assert.assertTrue(
				objScreeningMaintainanceMethod.objScreeningMaintainance.getBtn_CalculateDirections().isDisplayed());

		// Verify button Run preliminary LOD should be displayed on this tab
		Assert.assertTrue(
				objScreeningMaintainanceMethod.objScreeningMaintainance.getBtn_RunPreliminaryLOD().isDisplayed());
		System.out.println("Completed" + "\n");
	}

	@Test(priority = 19, description = "Verify fields in Advance Travel tab")
	public void TS20() {
		TestBase.methodName = "TS20";
		System.out.println("Executing: Testcase TS20: Verify fields in Advance Travel tab");

		// Select Advance Travel tab
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_AdvanceTravel().click();

		// Verify label Violation should be displayed on this tab
		Assert.assertTrue(objScreeningMaintainanceMethod.objScreeningMaintainance.getLbl_Violations().isDisplayed());

		// Verify button Calculate Directions should be displayed on this tab
		Assert.assertTrue(objScreeningMaintainanceMethod.objScreeningMaintainance.getBtn_AdvTrv_CalculateDrirections()
				.isDisplayed());

		// Verify button Run preliminary LOD should be displayed on this tab
		Assert.assertTrue(objScreeningMaintainanceMethod.objScreeningMaintainance.getBtn_AdvTrv_RunPreliminaryLOD()
				.isDisplayed());
		System.out.println("Completed" + "\n");
	}

	@Test(priority = 20, description = "Verify fields in Marketing tab")
	public void TS21() {
		TestBase.methodName = "TS21";
		System.out.println("Executing: Testcase TS21: Verify fields in Marketing tab");

		// Select Marketing tab
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_Marketing().click();

		// Verify Dropdown Marketing Plan should be displayed
		Assert.assertTrue(objScreeningMaintainanceMethod.objScreeningMaintainance.getDdl_MarketingPlan().isDisplayed());

		// Verify Dropdown ACOType should be displayed
		Assert.assertTrue(objScreeningMaintainanceMethod.objScreeningMaintainance.getDdl_ACOType().isDisplayed());
		System.out.println("Completed" + "\n");
	}

	@Test(priority = 21, description = "Verify fields in History tab")
	public void TS22() {
		TestBase.methodName = "TS22";
		System.out.println("Executing: Testcase TS22: Verify fields in History tab");

		// Select History tab
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_History().click();
		objScreeningMaintainanceMethod.waitForPageToLoad(30);

		// Verify grid History should be displayed
		Assert.assertTrue(objScreeningMaintainanceMethod.objScreeningMaintainance.getGrid_History().isDisplayed());
		System.out.println("Completed" + "\n");
	}

	@Test(priority = 22, description = "Verify fields in Operation tab")
	public void TS23() {
		TestBase.methodName = "TS23";
		System.out.println("Executing: Testcase TS23: Verify fields in Operation tab");

		// Select Operations tab
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_Operations().click();

		// Verify dropdown Status should be displayed
		Assert.assertTrue(objScreeningMaintainanceMethod.objScreeningMaintainance.getDdl_Status().isDisplayed());

		// Verify dropdown Status should be displayed
		Assert.assertTrue(objScreeningMaintainanceMethod.objScreeningMaintainance.getDdl_Reasons().isDisplayed());
		System.out.println("Completed" + "\n");
	}

	@Test(priority = 23, description = "Verify Save & Continue function")
	public void TS24() {
		TestBase.methodName = "TS24";
		throw new SkipException(
				"TS24: Skip due to this testcase no longer needed (its purpose is the same with TS26 to TS32)");
	}

	@Test(priority = 24, description = "To check new screening in calendar")
	public void TS25() throws IOException, SQLException {
		TestBase.methodName = "TS25";
		System.out.println("Executing: Testcase TS25: Check new screening in calendar");
		// Get active tab
		String activeTab = driver.findElement(By.xpath("//span[contains(@class,'ajax__tab_active')]/span/span/span"))
				.getText();

		// Click button Exit in selected tab
		if (objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_SiteInfo().getText()
				.equals(activeTab) == true) {
			objScreeningMaintainanceMethod.clickButonExit(TAB.SITE_INFO);
		} else if (objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_Accounting().getText()
				.equals(activeTab) == true) {
			objScreeningMaintainanceMethod.clickButonExit(TAB.ACCOUNTING);
		} else if (objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_ProductsPricing().getText()
				.equals(activeTab) == true) {
			objScreeningMaintainanceMethod.clickButonExit(TAB.PRODUCTS_PRICING);
		} else if (objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_Travel().getText()
				.equals(activeTab) == true) {
			objScreeningMaintainanceMethod.clickButonExit(TAB.TRAVEL);
		} else if (objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_AdvanceTravel().getText()
				.equals(activeTab) == true) {
			objScreeningMaintainanceMethod.clickButonExit(TAB.ADVANCED_TRAVEL);
		} else if (objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_Marketing().getText()
				.equals(activeTab) == true) {
			objScreeningMaintainanceMethod.clickButonExit(TAB.MARKETING);
		} else if (objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_Notes().getText()
				.equals(activeTab) == true) {
			objScreeningMaintainanceMethod.clickButonExit(TAB.NOTES);
		} else if (objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_History().getText()
				.equals(activeTab) == true) {
			objScreeningMaintainanceMethod.clickButonExit(TAB.HISTORY);
		} else if (objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_Operations().getText()
				.equals(activeTab) == true) {
			objScreeningMaintainanceMethod.clickButonExit(TAB.OPERATION);
		}

		// Get screening informations on a selected date
		String actual_ScreeningInformations = "";
		try {
			actual_ScreeningInformations = objTeamCalendarMethod.getFullScreeningInfo(TestBase.screeningDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Get CSR expected name (format is FName + Lname) by its id (get it
		// when create screening)
		String getExpectCSR = "select Employee_ID, FName, LName from " + "PL_Employees where Employee_ID="
				+ objScreening.getEmployeeId();
		ResultSet rs = DBConnection.connectSQLServer(getExpectCSR);
		String expected_Representative = "null";
		try {
			while (rs.next()) {
				expected_Representative = (rs.getString(2) + " " + rs.getString(3)).replaceAll("\\s+", " ").trim();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Get time zone by zipcode
		String queryTimeZone = "select Time_Zone from PL_Zips where Zip_Code='" + objScreening.getSiteZipCode() + "'";

		ResultSet rsTimeZone = DBConnection.connectSQLServer(queryTimeZone);
		String timeZone = "";
		while (rsTimeZone.next()) {
			timeZone = rsTimeZone.getString(1).trim();
		}

		// Define expected result
		String expected_ScreeningInformations = objScreening.getSiteName() + "\n" + objScreening.getSiteCity() + " "
				+ objScreening.getSiteState() + " " + objScreening.getSiteZipCode() + "\n"
				+ objScreening.getSiteCountry() + "\n" + expected_Representative + "\n" + "Preliminary "
				+ objScreening.getScheduleCode() + " " + objScreening.getScheduleTime().split("-")[0].trim() + " "
				+ timeZone + "\n" + objScreening.getDriverType() + " 0 min" + "\n" + "$0.00";

		// Insert character "H" to last row if screening has HIPAA Value
		if (objScreening.getHIPAAValue().isEmpty()) {
			// Do nothing
		} else {
			expected_ScreeningInformations = expected_ScreeningInformations + "\n" + "H";
		}

		// Verify actual result with expected result
		Assert.assertEquals(actual_ScreeningInformations, expected_ScreeningInformations);
		System.out.println("Completed" + "\n");
	}

	@Test(priority = 25, description = "Save and Continue after check all Screening Requirements")
	public void TS26() {
		TestBase.methodName = "TS26";
		System.out.println("Executing: Testcase TS26: Save and Continue after update Site info tab");

		// Re-select createe Screening
		try {
			objTeamCalendarMethod.selectScreeningByInputDate(TestBase.screeningDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Select Site Info tab
		objScreeningMaintainanceMethod.selectSiteInfoTab();

		// Check all Screening Requirements checkbox
		objScreeningMaintainanceMethod.selectSiteRequirements("*Climate Controlled Cooling - Set from 68 to 78");
		objScreeningMaintainanceMethod.selectSiteRequirements("*Climate Controlled Heat - Set from 68 to 78");
		objScreeningMaintainanceMethod.selectSiteRequirements("*Non Smoking Room for Screening*");
		objScreeningMaintainanceMethod.selectSiteRequirements("*Room Size minimum 40' X40' or 1600 sq ft");
		objScreeningMaintainanceMethod.selectSiteRequirements("8 Large Tables and 35-40 Chairs available at site");
		objScreeningMaintainanceMethod.selectSiteRequirements("Adequate lighting (prefer adjustable lighting)");
		objScreeningMaintainanceMethod.selectSiteRequirements("Adequate Parking ( 10 - 15 Spaces)");
		objScreeningMaintainanceMethod.selectSiteRequirements("Minimum of 5+ Electrical outlets");
		objScreeningMaintainanceMethod.selectSiteRequirements("Restroom Accessibility");
		objScreeningMaintainanceMethod.selectSiteRequirements("Wheelchair Accessible");

		// Add notes for ultrasound team
		objScreeningMaintainanceMethod.sendNoteToUltraSoundTeam("This is note for Ultrasound Team");

		// Add notes for Call center
		objScreeningMaintainanceMethod.sendNoteToCallCenter("This is note for Call Center");

		// Click Save & Continue
		objScreeningMaintainanceMethod.saveAndContinueAtSiteInfoTab();
		objScreeningMaintainanceMethod.waitForPageToLoad(30);

		// Re-select Site Info tab
		objScreeningMaintainanceMethod.selectSiteInfoTab();

		// Verify checkbox should be check all
		Assert.assertTrue(objScreeningMaintainanceMethod
				.isScreeningRequirementsChecked("*Climate Controlled Cooling - Set from 68 to 78"));
		Assert.assertTrue(objScreeningMaintainanceMethod
				.isScreeningRequirementsChecked("*Climate Controlled Heat - Set from 68 to 78"));
		Assert.assertTrue(
				objScreeningMaintainanceMethod.isScreeningRequirementsChecked("*Non Smoking Room for Screening*"));
		Assert.assertTrue(objScreeningMaintainanceMethod
				.isScreeningRequirementsChecked("*Room Size minimum 40' X40' or 1600 sq ft"));
		Assert.assertTrue(objScreeningMaintainanceMethod
				.isScreeningRequirementsChecked("8 Large Tables and 35-40 Chairs available at site"));
		Assert.assertTrue(objScreeningMaintainanceMethod
				.isScreeningRequirementsChecked("Adequate lighting (prefer adjustable lighting)"));
		Assert.assertTrue(
				objScreeningMaintainanceMethod.isScreeningRequirementsChecked("Adequate Parking ( 10 - 15 Spaces)"));
		Assert.assertTrue(
				objScreeningMaintainanceMethod.isScreeningRequirementsChecked("Minimum of 5+ Electrical outlets"));
		Assert.assertTrue(objScreeningMaintainanceMethod.isScreeningRequirementsChecked("Restroom Accessibility"));
		Assert.assertTrue(objScreeningMaintainanceMethod.isScreeningRequirementsChecked("Wheelchair Accessible"));

		// Verify Notes for UltraSound Team should have text as inputed
		Assert.assertEquals(objScreeningMaintainanceMethod.getNoteToUltraSoundTeam(),
				"This is note for Ultrasound Team");

		// Verify Notes for Call Center should have text as inputed
		Assert.assertEquals(objScreeningMaintainanceMethod.getNoteToCallCenter(), "This is note for Call Center");
		System.out.println("Completed" + "\n");

	}

	@Test(priority = 26, description = "Add a check request with amount above 300$")
	public void TS27() {
		TestBase.methodName = "TS27";
		System.out.println("Executing: Testcase TS27: Add a check request with amount above 300$");

		// Check Request Purpose
		String purpose = "Room Rent";

		// Select Accounting tab
		objScreeningMaintainanceMethod.selectAccountingTab();

		// Click link Add a check request
		objScreeningMaintainanceMethod.objScreeningMaintainance.getLnk_AddCheckRequest().click();
		objScreeningMaintainanceMethod.waitForPageToLoad(30);

		// Select Purpose : Roms rent
		new Select(objScreeningMaintainanceMethod.objScreeningMaintainance.getChk_Purpose())
				.selectByVisibleText(purpose);

		// Enter amount = 300$
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_Amount().sendKeys("300");

		// Enter date needer

		// Get current date
		Date date = new Date();

		// Set format date by month/day/year
		SimpleDateFormat formatDate = new SimpleDateFormat("M/d/yyyy");

		// Increase day by 1 to get tomorow date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, +1);

		// Define tomorow date
		String tomorowDate = formatDate.format(cal.getTime());

		// Input tomorow date to Date Needed field
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_DateNeeded().sendKeys(tomorowDate);

		// Click Save
		objScreeningMaintainanceMethod.objScreeningMaintainance.getBtn_SaveCheckRequest().click();
		objScreeningMaintainanceMethod.waitForSaveCheckRequest();

		// Verify status of check request should be Pending Approvel
		Assert.assertEquals(objScreeningMaintainanceMethod.getCheckRequestStatus(purpose), "Pending Approval");
		System.out.println("Completed" + "\n");

	}

	@Test(priority = 27, description = "Add a check request with amount below 50$")
	public void TS28() {
		TestBase.methodName = "TS28";
		System.out.println("Executing: Testcase TS28: Add a check request with amount below 50$");
		// Check Request Purpose
		String purpose = "Room Rent";

		// Edit checkrequest with amount decrease to $50
		objScreeningMaintainanceMethod.clickLinkEditCheckRequestByItsPurpose(purpose);
		objScreeningMaintainanceMethod.waitForPageToLoad(30);
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_Amount().clear();
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_Amount().sendKeys("50");
		objScreeningMaintainanceMethod.objScreeningMaintainance.getBtn_SaveCheckRequest().click();
		objScreeningMaintainanceMethod.waitForSaveCheckRequest();

		// Verify status of check request should be Requested
		Assert.assertEquals(objScreeningMaintainanceMethod.getCheckRequestStatus(purpose), "Requested");
		System.out.println("Completed" + "\n");
	}

	@Test(priority = 28, description = "Verify Product Set that displayed in correspont dropdown")
	public void TS29() {
		TestBase.methodName = "TS29";
		System.out.println("Executing: Testcase TS29: Verify Product Set that displayed in correspont dropdown");

		// Select Products & Pricing tab
		objScreeningMaintainanceMethod.selectProductsPricingTab();

		// Verify default value in dropdown Products should be chosen product
		// when creating screening
		Assert.assertEquals(new Select(objScreeningMaintainanceMethod.objScreeningMaintainance.getDdl_ProductSet())
				.getFirstSelectedOption().getText(), objScreening.getProductSet());
		System.out.println("Completed" + "\n");
	}

	@Test(priority = 29, description = "Change product set and Save & Continue")
	public void TS30() {
		TestBase.methodName = "30";
		System.out.println("Executing: Testcase TS30: Change product set and Save & Continue");
		// Select Products & Pricing tab
		objScreeningMaintainanceMethod.selectProductsPricingTab();
		// Get number of product set in dropdown
		Select ddlProductSet = new Select(objScreeningMaintainanceMethod.objScreeningMaintainance.getDdl_ProductSet());
		int noOfProductSet = ddlProductSet.getOptions().size();

		// Get index of selected option
		String currentSelectedOption = ddlProductSet.getFirstSelectedOption().getText();
		int selectedOptionIndex = 0;
		for (int i = 0; i < ddlProductSet.getOptions().size(); i++) {
			if (ddlProductSet.getOptions().get(i).getText().equals(currentSelectedOption)) {
				selectedOptionIndex = i;
				break;
			}
		}

		// If number of Product set is equal or greater than 3, then select next
		// product set, else select privious product set
		String newProductSetName = "";

		if (noOfProductSet >= 3 && (selectedOptionIndex + 1) < ddlProductSet.getOptions().size()) {
			newProductSetName = ddlProductSet.getOptions().get(selectedOptionIndex + 1).getText();
			ddlProductSet.selectByIndex(selectedOptionIndex + 1);
			objScreeningMaintainanceMethod.waitForPageToLoad(30);

		} else if (noOfProductSet >= 3 && (selectedOptionIndex - 1) >= 1) {
			newProductSetName = ddlProductSet.getOptions().get(selectedOptionIndex - 1).getText();
			ddlProductSet.selectByIndex(selectedOptionIndex - 1);
			objScreeningMaintainanceMethod.waitForPageToLoad(30);
		} else {
			throw new SkipException("There isn't any other product set to select");
		}

		objScreeningMaintainanceMethod.objScreeningMaintainance.getBtn_SaveContinue_ProPrice().click();
		objScreeningMaintainanceMethod.waitForPageToLoad(30);

		// Re-select Product&Pricing tab
		objScreeningMaintainanceMethod.selectProductsPricingTab();

		// Verify new selected Product set should displayed correctly in
		// dropdown box
		Assert.assertEquals(ddlProductSet.getFirstSelectedOption().getText(), newProductSetName);
		System.out.println("Completed" + "\n");

	}

	@Test(priority = 30, description = "Change price level and Save & Continue")
	public void TS31() {
		TestBase.methodName = "TS31";
		System.out.println("Executing: Testcase TS31: Change price level and Save & Continue");

		// Select Products & Pricing tab
		objScreeningMaintainanceMethod.selectProductsPricingTab();
		// Get number of price level in dropdown
		Select ddlPriceLevel = new Select(objScreeningMaintainanceMethod.objScreeningMaintainance.getDdl_PriceLevel());
		int noOfPriceLevel = ddlPriceLevel.getOptions().size();

		// Get index of selected option
		String currentSelectedOption = ddlPriceLevel.getFirstSelectedOption().getText();
		int selectedOptionIndex = 0;
		for (int i = 0; i < ddlPriceLevel.getOptions().size(); i++) {
			if (ddlPriceLevel.getOptions().get(i).getText().equals(currentSelectedOption)) {
				selectedOptionIndex = i;
				break;
			}
		}

		// If number of price level is equal or greater than 3, then select next
		// price, else select previous price
		String newPriceName = "";

		if (noOfPriceLevel >= 3 && (selectedOptionIndex + 1) < ddlPriceLevel.getOptions().size()) {
			newPriceName = ddlPriceLevel.getOptions().get(selectedOptionIndex + 1).getText();
			ddlPriceLevel.selectByIndex(selectedOptionIndex + 1);
			objScreeningMaintainanceMethod.waitForPageToLoad(30);

		} else if (noOfPriceLevel >= 3 && (selectedOptionIndex - 1) >= 1) {
			newPriceName = ddlPriceLevel.getOptions().get(selectedOptionIndex - 1).getText();
			ddlPriceLevel.selectByIndex(selectedOptionIndex - 1);
			objScreeningMaintainanceMethod.waitForPageToLoad(30);
		} else {
			throw new SkipException("There isn't any other price level to select");
		}

		objScreeningMaintainanceMethod.objScreeningMaintainance.getBtn_SaveContinue_ProPrice().click();
		objScreeningMaintainanceMethod.waitForPageToLoad(30);

		// Re-select Product&Pricing tab
		objScreeningMaintainanceMethod.selectProductsPricingTab();

		// Verify new selected Product set should displayed correctly in
		// dropdown box
		Assert.assertEquals(ddlPriceLevel.getFirstSelectedOption().getText(), newPriceName);
		System.out.println("Completed" + "\n");

	}

	@Test(priority = 31, description = "Update new screening / facility time and Save")
	public void TS32() {
		TestBase.methodName = "TS32";
		System.out.println("Executing: Testcase TS31: Update new screening / facility time and Save");

		// Select Advance Travel tab
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_AdvanceTravel().click();

		// Update Facility Open Time
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_FacilityOpenTime().clear();
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_FacilityOpenTime().sendKeys("6:00 AM");

		// Update Facility Close Time
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_FacilityCloseTime().clear();
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_FacilityCloseTime().sendKeys("6:00 PM");

		// Update Start Scan Time
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_StartScanTime().clear();
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_StartScanTime().sendKeys("7:30 AM");
		objScreeningMaintainanceMethod.objScreeningMaintainance.getBtn_OverrideStartScan().click();
		objScreeningMaintainanceMethod.waitForPageToLoad(30);

		// Update End Scan Time
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_EndScanTime().clear();
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_EndScanTime().sendKeys("4:30 PM");
		objScreeningMaintainanceMethod.objScreeningMaintainance.getBtn_OverrideEndScan().click();
		objScreeningMaintainanceMethod.waitForPageToLoad(60);

		// Click Save & Continue
		objScreeningMaintainanceMethod.objScreeningMaintainance.getBtn_SaveAdvTrv().click();
		objScreeningMaintainanceMethod.waitForPageToLoad(60);

		// Reload page
		driver.navigate().refresh();

		// Re-select Advance Travel tab
		objScreeningMaintainanceMethod.objScreeningMaintainance.getTab_AdvanceTravel().click();

		// Verify updated data is displayed correctly
		Assert.assertEquals(
				objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_FacilityOpenTime().getAttribute("value"),
				"6:00 AM");
		Assert.assertEquals(objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_FacilityCloseTime()
				.getAttribute("value"), "6:00 PM");
		Assert.assertEquals(
				objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_StartScanTime().getAttribute("value"),
				"7:30 AM");
		Assert.assertEquals(
				objScreeningMaintainanceMethod.objScreeningMaintainance.getTxt_EndScanTime().getAttribute("value"),
				"4:30 PM");
		System.out.println("Completed" + "\n");

	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws Exception {
		CommonOperations.getMethodTestResult(testResult);
		CommonOperations.takePicture();
	}

	@AfterClass
	public void end() throws InterruptedException, IOException {

		p = CommonOperations.readConfig();
		Connection conn = null;
		@SuppressWarnings("unused")
		ResultSet rs = null;
		Statement stmt = null;
		// String sqlCommand;

		// Defining the SQL URL
		String dbAddress = p.getProperty("SQLServer_address");
		String dbName = p.getProperty("SQLServer_dbName");
		String user = p.getProperty("SQLServer_user");
		String pwd = p.getProperty("SQLServer_pwd");

		// Driver of SQLServer
		String driver1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connection = "jdbc:sqlserver://" + dbAddress + ";databaseName=" + dbName + ";user=" + user + ";password="
				+ pwd;
		if (useExistingSite == false) {
			String queryDeleteData = "DELETE SC_Screening_History where screening_id in "
					+ "(select Screening_ID from SC_Screenings where Site_ID in (select Site_ID from SC_Sites where Site_Name = '"
					+ objScreening.getSiteName() + "')) "
					+ "DELETE SC_Screening_LOD where screening_id in (select Screening_ID from SC_Screenings where Site_ID in "
					+ "(select Site_ID from SC_Sites where Site_Name = '" + objScreening.getSiteName() + "')) "
					+ "DELETE SC_Screening_Products_Denied_Xref where Screening_ID in (select Screening_ID from SC_Screenings "
					+ "where Site_ID in (select Site_ID from SC_Sites where Site_Name = '" + objScreening.getSiteName()
					+ "')) "
					+ "DELETE SC_Screening_Requirements where screening_id in (select Screening_ID from SC_Screenings where Site_ID "
					+ "in (select Site_ID from SC_Sites where Site_Name = '" + objScreening.getSiteName() + "')) "
					+ "DELETE SC_Check_Requests where screening_id in (select Screening_ID from SC_Screenings where Site_ID in "
					+ "(select Site_ID from SC_Sites where Site_Name = '" + objScreening.getSiteName() + "')) "
					+ "DELETE SC_Screenings where screening_id in (select Screening_ID from SC_Screenings where Site_ID in "
					+ "(select Site_ID from SC_Sites where Site_Name = '" + objScreening.getSiteName() + "')) "
					+ "DELETE SC_Site_Reviews where site_id in (select Site_ID from SC_Sites where Site_Name = '"
					+ objScreening.getSiteName() + "') "
					+ "DELETE SC_Site_Requirements where site_id in (select Site_ID from SC_Sites where Site_Name = '"
					+ objScreening.getSiteName() + "') "
					+ "DELETE SC_Sites where site_id in (select Site_ID from SC_Sites where Site_Name = '"
					+ objScreening.getSiteName() + "')";

			String queryDeleteReservedDate = "DELETE SC_Calendars where Employee_Group_ID "
					+ "in (select cal.Employee_Group_ID from SC_Calendars cal "
					+ "join PL_Teams team on cal.Employee_Group_ID=team.Employee_Group_ID "
					+ "join SS_System_Types st on st.System_Type_ID=cal.Control_Type_ID " + "where team.Team_Code='"
					+ TestBase.teamCode + "' and cal.Control_Type_ID=111 " + "and cal.Event_Date='"
					+ TestBase.screeningDate + "')";

			// Perform connection
			try {
				// Loading the driver and creating its instance
				Class.forName(driver1).newInstance();
				// Establishing the connection with the database

				conn = DriverManager.getConnection(connection);
				/*
				 * createStatement() method creates a Statement object for
				 * sending SQL to the database. It executes the SQL and returns
				 * the result it produces
				 */
				stmt = conn.createStatement();
				/*
				 * executeQuery() method executes the SQL statement which
				 * returns a single ResultSet type object.
				 */
				stmt.execute(queryDeleteData);
				stmt.execute(queryDeleteReservedDate);
				// stmt.execute(deleteCheckRequest);
			} catch (Exception e) {
				System.out.println("Couldn't connect to DB");
				System.out.print(e);

			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Couldn't close connection");
					System.out.print(e);
				}
			}

		} else {
			String queryDeleteData2 = "DECLARE @screeningId INT " + "set @screeningId = "
					+ objScreening.getScreeningId() + " DELETE SC_Screening_History where screening_id = @screeningId "
					+ "DELETE SC_Screening_LOD where screening_id = @screeningId "
					+ "DELETE SC_Screening_Products_Denied_Xref where Screening_ID=@screeningId "
					+ "DELETE SC_Screening_Requirements where screening_id = @screeningId "
					+ "DELETE SC_Check_Requests where screening_id = @screeningId "
					+ "DELETE SC_Screenings where screening_id = @screeningId";
			String queryDeleteReservedDate = "DELETE SC_Calendars where Employee_Group_ID "
					+ "in (select cal.Employee_Group_ID from SC_Calendars cal "
					+ "join PL_Teams team on cal.Employee_Group_ID=team.Employee_Group_ID "
					+ "join SS_System_Types st on st.System_Type_ID=cal.Control_Type_ID " + "where team.Team_Code='"
					+ TestBase.teamCode + "' and cal.Control_Type_ID=111 " + "and cal.Event_Date='"
					+ TestBase.screeningDate + "')";

			// Perform connection
			try {
				// Loading the driver and creating its instance
				Class.forName(driver1).newInstance();
				// Establishing the connection with the database

				conn = DriverManager.getConnection(connection);
				/*
				 * createStatement() method creates a Statement object for
				 * sending SQL to the database. It executes the SQL and returns
				 * the result it produces
				 */
				stmt = conn.createStatement();
				/*
				 * executeQuery() method executes the SQL statement which
				 * returns a single ResultSet type object.
				 */
				stmt.execute(queryDeleteData2);
				stmt.execute(queryDeleteReservedDate);
				// stmt.execute(deleteCheckRequest);
			} catch (Exception e) {
				System.out.println("Couldn't connect to DB");
				System.out.print(e);

			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Couldn't close connection");
					System.out.print(e);
				}
				// Thread.sleep(5000);
				driver.quit();
			}
		}
	}

}