package com.vsii.cstar.testcase;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vsii.cstar.pages.methods.AppointmentsSingleScreeningPageMethod;
import com.vsii.cstar.pages.methods.HomePageMethods;
import com.vsii.cstar.pages.methods.LoginPageMethods;
import com.vsii.cstar.pages.methods.ProductPageMethod;
import com.vsii.cstar.pages.methods.ProductSetPageMethod;
import com.vsii.cstar.pages.methods.ScreeningMaintainanceMethods;
import com.vsii.cstar.pages.methods.TeamCalendarMethods;

public class testOnly {
	WebDriver driver;
	LoginPageMethods objLoginPageMethod;
	HomePageMethods objHomepageMethod;
	TeamCalendarMethods objTeamCalendarMethod;
	ScreeningMaintainanceMethods objScreeningMaintainanceMethod;
	AppointmentsSingleScreeningPageMethod objAptSingleScreenMethod;
	ProductSetPageMethod objProductSetMethod;
	ProductPageMethod objProductPageMethod;

	@BeforeClass
	public void start() {
		driver = new FirefoxDriver();
		objLoginPageMethod = new LoginPageMethods(driver);
		objHomepageMethod = new HomePageMethods(driver);
		objTeamCalendarMethod = new TeamCalendarMethods(driver);
		objScreeningMaintainanceMethod = new ScreeningMaintainanceMethods(driver);
		objAptSingleScreenMethod = new AppointmentsSingleScreeningPageMethod(driver);
		objProductSetMethod = new ProductSetPageMethod(driver);
		objProductPageMethod = new ProductPageMethod(driver);

		// Setup browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://172.17.60.220:888/Login.aspx");
		driver.manage().window().maximize();
	}

	@Test
	public void t() throws InterruptedException, ParseException {
		// Steps to access Appointments Screen
		String productName = "PRODUCT-1008";
		objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com", "Thanhvc123@");
		objHomepageMethod.mouseHoverProductPricing();
		objHomepageMethod.selectSubMenuProductList();
		objProductPageMethod.searchProduct(productName);
		objProductPageMethod.selectProductByName(productName);

		// Verify product is active or not
		if (objProductPageMethod.isProductActived() == true) {
			
		}
		else if (objProductPageMethod.isScreeningDateInProductEffectivedDate("04/06/2016")==true) {
			System.out.println("Continue");
		
		}
		else {
			System.out.println("End here");
		}
	
	}

	@AfterClass
	public void end() throws InterruptedException {
		Thread.sleep(6000);
		driver.quit();
	}
}
