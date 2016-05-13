package com.vsii.cstar.testcase;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

public class VerifyItemsInSelectedProductSet_QueryDB {
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
	public void start() {

		driver = TestBase.driver;
		objLoginPageMethod = new LoginPageMethods(driver);
		objHomepageMethod = new HomePageMethods(driver);
		objTeamCalendarMethod = new TeamCalendarMethods(driver);
		objScreeningMaintainanceMethod = new ScreeningMaintainanceMethods(driver);
		objAptSingleScreenMethod = new AppointmentsSingleScreeningPageMethod(driver);
		objProductSetMethod = new ProductSetPageMethod(driver);
		objProductPageMethod = new ProductPageMethod(driver);
		objPackagePageMethod = new PackagePageMethod(driver);

		// Setup browser
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.get("http://172.17.60.220:888/Login.aspx");
		// driver.manage().window().maximize();
	}

	@Test
	public void TM24() throws InterruptedException, ParseException, IOException, SQLException {
		//input data
		TestBase.methodName = "TM24";
		String input_month="April";
		String input_Team="HOU - Houston";
		String input_Date = TestBase.screeningDate;
		
		// Login to System
		objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com", "Thanhvc123@");
		// Select menu Team Calendar & Grid
		objHomepageMethod.mouseHoverScreeningConfig();
		objHomepageMethod.selectSubMenuTeamCalendar();
		// Choose filter
		objTeamCalendarMethod.selectMonth(input_month);
		objTeamCalendarMethod.selectTeam(input_Team);
		
		//Wait for loading img to load
		objTeamCalendarMethod.waitForLoadingIconToLoad();
		
		// Select existing screening by its name
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
		String sqlCommand_03 = "exec AP_Offering_Select_By_DNIS "
				+ "@Product_Set_ID="+productSetId+",@Price_List_ID ="+priceLevelId
				+",@Sale_Source_Type_ID=2017,@Screening_ID="+screeningId;
		
		ResultSet rs3 = DBConnection.connectSQLServer(sqlCommand_03);
		ArrayList<String> expected_productPackageName = new ArrayList<>();
		ArrayList<String> expected_type = new ArrayList<>();
		ArrayList<String> expected_price = new ArrayList<>();
		while(rs3.next()){
			//get expected product/packet name
			expected_productPackageName.add(rs3.getString(2).trim().replaceAll("\\s+", " "));
			
			//get expected type
			expected_type.add(rs3.getString(6));
			
			//get expected product/package price
			expected_price.add(NumberFormat.getCurrencyInstance().format(rs3.getDouble(3)));
		}
		
		//Verify values seen in UI and values query from DB
		Assert.assertEquals(actual_productPackageName, expected_productPackageName);
		Assert.assertEquals(actual_type, expected_type);
		Assert.assertEquals(actual_price, expected_price);
		
		

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
