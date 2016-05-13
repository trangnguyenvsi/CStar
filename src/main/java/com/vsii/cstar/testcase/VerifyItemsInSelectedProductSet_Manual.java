package com.vsii.cstar.testcase;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
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
import com.vsii.cstar.pages.methods.PackagePageMethod;
import com.vsii.cstar.pages.methods.ProductPageMethod;
import com.vsii.cstar.pages.methods.ProductSetPageMethod;
import com.vsii.cstar.pages.methods.ScreeningMaintainanceMethods;
import com.vsii.cstar.pages.methods.TeamCalendarMethods;

public class VerifyItemsInSelectedProductSet_Manual {
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
		driver = new FirefoxDriver();
		objLoginPageMethod = new LoginPageMethods(driver);
		objHomepageMethod = new HomePageMethods(driver);
		objTeamCalendarMethod = new TeamCalendarMethods(driver);
		objScreeningMaintainanceMethod = new ScreeningMaintainanceMethods(driver);
		objAptSingleScreenMethod = new AppointmentsSingleScreeningPageMethod(driver);
		objProductSetMethod = new ProductSetPageMethod(driver);
		objProductPageMethod = new ProductPageMethod(driver);
		objPackagePageMethod = new PackagePageMethod(driver);

		// Setup browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://172.17.60.220:888/Login.aspx");
		driver.manage().window().maximize();
	}

	@Test
	public void t() throws InterruptedException, ParseException, IOException, SQLException {
		// Login to System

		ArrayList<String> productValid = new ArrayList<>();
		ArrayList<String> packageValid = new ArrayList<>();
		String productCode = "Null";
		String packetCode = "Null";
		ArrayList<String> productListId = new ArrayList<>();
		String productSetName = "Wellness, AF, LI, GL, Risk, ADX Bloodcard (2015)";
		objLoginPageMethod.login("vuong.cong.thanh@vsi-international.com", "Thanhvc123@");
		// Select menu Team Calendar & Grid
		objHomepageMethod.mouseHoverScreeningConfig();
		objHomepageMethod.selectSubMenuTeamCalendar();
		// Choose filter
		objTeamCalendarMethod.selectMonth("April");
		objTeamCalendarMethod.selectTeam("HOU - Houston");
		// Select existing screening by its name
		objTeamCalendarMethod.selectExistingScreening("First Church of Pearland");
		// Select tab Products & Pricing
		objScreeningMaintainanceMethod.selectProductsPricingTab();
		// Get products and packages
		ArrayList<String> productExpected = objScreeningMaintainanceMethod.getProductsOnly();
		ArrayList<String> packageExpected = objScreeningMaintainanceMethod.getPacketOnly();

		for (String string1 : productExpected) {
			System.out.println("Screeing's Products:  " + string1);
		}

		for (String string2 : packageExpected) {
			System.out.println("Screeing's Packages:  " + string2);
		}

		// Acess product set scren
		objHomepageMethod.mouseHoverProductPricing();
		objHomepageMethod.selectSubMenuProductSet();

		// Search and view detail product set
		objProductSetMethod.searchProductSet(productSetName);
		objProductSetMethod.viewDetailProductSet(productSetName);

		// Get product/package in product set screen
		String[] products2 = objProductSetMethod.getProductsOfOpenedProductSet();
		String[] packages2 = objProductSetMethod.getPackagesOfOpenedProductSet();

		for (String string3 : products2) {
			System.out.println("Products in product set:  " + string3);
		}

		for (String string4 : packages2) {
			System.out.println("Packages in product set:  " + string4);
		}

		for (int t = 0; t < products2.length; t++) {
			productCode = products2[t];
			System.out.println("Current verify product code:  " + productCode);

			objHomepageMethod.mouseHoverProductPricing();
			objHomepageMethod.selectSubMenuProductList();
			objProductPageMethod.searchProduct(productCode);
			objProductPageMethod.selectProductByCode(productCode);
			String team = "HOU-Houston *";
			int productId = objProductPageMethod.getProductID();
			String ProductName = objProductPageMethod.getProductName();
			if (objProductPageMethod.isProductActived() == true) {
				if (objProductPageMethod.isScreeningDateInProductEffectivedDate("04/05/2016") == true) {

					System.out.println("Screening date is in product's effective date");
					driver.navigate().back();
					objProductPageMethod.clicktoTeam(productId);
					if (objProductPageMethod.isProductBelongToTeam(team, productId) == true) {
						System.out.println("Product is belong to team");
						productValid.add(ProductName);
						productListId.add(Integer.toString(productId));
					}
				}
			}
		}

		for (String string : productValid) {
			System.out.println("Product is valid is: " + string);
		}

		// Find valid package
		for (int j = 0; j < packages2.length; j++) {
			packetCode = packages2[j];
			objHomepageMethod.mouseHoverProductPricing();
			objHomepageMethod.selectSubMenuPackage();
			objPackagePageMethod.searchPackage(packetCode);
			objPackagePageMethod.selectPackageByCode(packetCode);
			for (int t = 0; t < productListId.size(); t++) {
				int productId = Integer.parseInt(productListId.get(t));

				System.out.println(objPackagePageMethod.isProductBelongToPackage(productId));
				if (objPackagePageMethod.isProductBelongToPackage(productId) == true) {
					System.out.println("Package " + packetCode + " included product ");
					packageValid.add(objPackagePageMethod.getPackageName());
					break;
				} else {
					System.out.println("Package " + packetCode + " not included product ");
				}
			}
		}
		for (String string2 : packageValid) {
			System.out.println("Valid package is: " + string2);
		}

		// Verify product & package show on screening is correct or not
		boolean isProductCorrect;
		boolean isPackageCorrect;

		// Verify product
		if (productValid.size() == productExpected.size()) {
			if (productValid.equals(productExpected)) {
				isProductCorrect = true;
				System.out.println("valid");
			} else {
				isProductCorrect = false;
				System.out.println("invalid");
			}
		} else {
			isProductCorrect = false;
			System.out.println("invalid");
		}

		// Verify package
		if (packageValid.size() == packageExpected.size()) {
			if (packageValid.equals(packageExpected)) {
				isPackageCorrect = true;
				System.out.println("valid");
			} else {
				isPackageCorrect = false;
				System.out.println("invalid");
			}
		} else {
			isPackageCorrect = false;
			System.out.println("invalid");
		}
		
		Assert.assertTrue(isProductCorrect);
		Assert.assertTrue(isPackageCorrect);

	}

	@AfterClass
	public void end() throws InterruptedException {
		// Thread.sleep(6000);
		driver.quit();
	}
}
