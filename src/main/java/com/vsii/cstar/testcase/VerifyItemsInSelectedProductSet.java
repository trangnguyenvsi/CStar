package com.vsii.cstar.testcase;

import java.lang.reflect.Array;
import java.util.Arrays;
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
import com.vsii.cstar.pages.methods.ProductSetPageMethod;
import com.vsii.cstar.pages.methods.ScreeningMaintainanceMethods;
import com.vsii.cstar.pages.methods.TeamCalendarMethods;

public class VerifyItemsInSelectedProductSet {
	WebDriver driver;
	LoginPageMethods objLoginPageMethod;
	HomePageMethods objHomepageMethod;
	TeamCalendarMethods objTeamCalendarMethod;
	ScreeningMaintainanceMethods objScreeningMaintainanceMethod;
	AppointmentsSingleScreeningPageMethod objAptSingleScreenMethod;
	ProductSetPageMethod objProductSetMethod;

	@BeforeClass
	public void start() {
		driver = new FirefoxDriver();
		objLoginPageMethod = new LoginPageMethods(driver);
		objHomepageMethod = new HomePageMethods(driver);
		objTeamCalendarMethod = new TeamCalendarMethods(driver);
		objScreeningMaintainanceMethod = new ScreeningMaintainanceMethods(driver);
		objAptSingleScreenMethod = new AppointmentsSingleScreeningPageMethod(driver);
		objProductSetMethod = new ProductSetPageMethod(driver);

		// Setup browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://172.17.60.220:888/Login.aspx");
		driver.manage().window().maximize();
	}

	@Test
	public void t() throws InterruptedException {
		// Verify Product in a product set
		String productSetName="Medicare- Annual Wellness Visit";
		objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com", "Thanhvc123@");
		objHomepageMethod.mouseHoverScreeningConfig();
		objHomepageMethod.selectSubMenuTeamCalendar();
		objTeamCalendarMethod.selectTeam("ACE - ACO - East");
		objTeamCalendarMethod.selectExistingScreening("TESTSITE-001");
		objScreeningMaintainanceMethod.selectProductsPricingTab();
		objScreeningMaintainanceMethod.selectDdlProductSet(productSetName);
		Thread.sleep(20000);
		String[] product1 = objScreeningMaintainanceMethod.getProductsOfChosenProductSet();
		Arrays.sort(product1);

		// Verify product in product set of Products & Pricing
		objHomepageMethod.mouseHoverProductPricing();
		objHomepageMethod.selectSubMenuProductSet();
		objProductSetMethod.searchProductSet(productSetName);
		objProductSetMethod.viewDetailProductSet(productSetName);
		String[] products2 = objProductSetMethod.getProductsOfOpenedProductSet();
		
		Arrays.sort(products2);
		// Compare 2 result
		// for (int i = 0; i <
		// objScreeningMaintainanceMethod.getProductsOfChosenProductSet().length;
		// i++) {
		// for (int j = 0; j <
		// objProductSetMethod.getProductsOfOpenedProductSet().length; j++) {
		// Assert.assertEquals(product1[], expected);
		
		
		if (Arrays.equals(product1, products2)) {
			System.out.println("Same");
		}
		else{
			System.out.println("Not Same");
		}

	}

	@AfterClass
	public void end() throws InterruptedException {
		// Thread.sleep(6000);
		driver.quit();
	}
}
