package com.vsii.cstar.pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.vsii.cstar.pages.PackagePage;

public class PackagePageMethod {
	WebDriver driver;
	public PackagePage objPackagePage = new PackagePage();

	public PackagePageMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objPackagePage);
	}

	// Enter text to search textbox
	public void sendKeyToSearchTxt(String inputData) {
		objPackagePage.getTxt_SearchPackage().sendKeys(inputData);
	}

	// Click button Search
	public void clickButtonSearch() {
		objPackagePage.getBtn_Search().click();
	}

	// Search packet
	public void searchPackage(String inputData) {
		this.sendKeyToSearchTxt(inputData);
		this.clickButtonSearch();
	}

	// Click button nextpage
	public void clickNextPage() {
		objPackagePage.getBtn_Next().click();
	}

	// Select package by its code
	public void selectPackageByCode(String packageCode) throws InterruptedException {
		int numOfItems = driver.findElements(By.xpath("//table[@id='ctl00_body_grdPackage']/tbody/tr")).size() - 1;
		int i = 2;
		if (numOfItems > 15) {
			numOfItems = 15;
		}
		System.out.println("Number of record:  " + numOfItems);

		for (i = 2; i <= numOfItems + 1; i++) {
			String xpath_codeCol = "//table[@id='ctl00_body_grdPackage']/tbody/tr[" + i + "]/td[2]";
			String code = driver.findElement(By.xpath(xpath_codeCol)).getText();
			// System.out.println("Code find in column is: "+ code);
			// System.out.println("Product code is: "+productCode);
			// System.out.println("Xpath product nam is:
			// "+xpath_productNameCol);
			if (code.equals(packageCode)) {
				// Define new xpath to able to click to hyperlink Product Name
				String xpath_lnkProductName = "//table[@id='ctl00_body_grdPackage']/tbody/tr[" + i + "]/td/a";
				// Click to hyperlink
				driver.findElement(By.xpath(xpath_lnkProductName)).click();
				break;
			}

			if (i == numOfItems + 1) {
				this.clickNextPage();
				numOfItems = driver.findElements(By.xpath("//table[@id='ctl00_body_grdPackage']/tbody/tr")).size() - 1;
				i = 1;
				if (numOfItems > 15) {
					numOfItems = 15;
				}
				// System.out.println("New number of record: "+numOfItems);
				// System.out.println("New i: "+i);
			}
		}
	}

	// Check if Product is belong to Package or not
	public boolean isProductBelongToPackage(int productId) {
		// Get number or product in list
		boolean isTrue = false;
		int numOfProducts = driver.findElements(By.xpath("//table[@id='ctl00_plcMain_dgPackageDisplay']/tbody/tr"))
				.size();
		for (int i = 2; i <= numOfProducts; i++) {

			String xpath_ProductCodeCol = "//table[@id='ctl00_plcMain_dgPackageDisplay']/tbody/tr[" + i + "]/td[2]";
			String productIdInCol = driver.findElement(By.xpath(xpath_ProductCodeCol)).getText();
			// System.out.println("Product id in interface is: " +
			// productIdInCol);
			// System.out.println("Product id is: " + productId);
			if (productIdInCol.equals(Integer.toString(productId))) {
				isTrue = true;
				break;
			}
		}
		return isTrue;
	}
	
	//Get package name in detail page
	public String getPackageName(){
		return objPackagePage.getLbl_PackageName().getText();
	}
}
