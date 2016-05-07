package com.vsii.cstar.pages.methods;

import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.soap.Node;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.xalan.transformer.XalanProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vsii.cstar.pages.ScreeningMaintenance;

public class ScreeningMaintainanceMethods {
	WebDriver driver;
	public ScreeningMaintenance objScreeningMaintainance = new ScreeningMaintenance();

	public ScreeningMaintainanceMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objScreeningMaintainance);
	}

	// Click to Appointments hyperlink
	public void clickAppointmentsLinkText() {
		objScreeningMaintainance.getLink_Appointments().click();
	}

	// Select tab Site Info
	public void selectSiteInfoTab() {
		objScreeningMaintainance.getTab_SiteInfo().click();
	}

	// Select tab Products & Pricing
	public void selectProductsPricingTab() {
		objScreeningMaintainance.getTab_ProductsPricing().click();
	}

	// Select and choose product set
	public void selectDdlProductSet(String productSetname) {
		Select selecto = new Select(objScreeningMaintainance.getDdl_ProductSet());
		selecto.selectByVisibleText(productSetname);
	}

	// Get name of all product/packet in product set
	public String[] getProductsOfChosenProductSet() {
		int NumOfProduct2 = driver
				.findElements(By
						.xpath("//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr"))
				.size() - 1;

		// Declare array Product - prepare to get all product/packet name to
		// this Array
		String[] product2 = new String[NumOfProduct2];

		// Test arrayList

		for (int i = 2; i <= NumOfProduct2 + 1; i++) {
			String xpath_product = "//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr["
					+ i + "]/td";
			product2[i - 2] = driver.findElement(By.xpath(xpath_product)).getText();
		}

		Arrays.sort(product2);
		return product2;
	}

	// Get check status of 1st checkbox in Site's requirements / Site info tab
	public String getCheckStatus() {
		String chkStatus = objScreeningMaintainance.getChk_01().getAttribute("checked");
		return chkStatus;
	}

	// Select 1st checkbox in tab Site Info
	public void checkSiteRequirements() {
		objScreeningMaintainance.getChk_01().click();
	}

	// Get text from Note for UltraSound Team textbox
	public String getNoteToUltraSoundTeam() {
		String noteUlr = objScreeningMaintainance.getTxt_NoteUltraSound().getText();
		return noteUlr;
	}

	// Clear text from Note for UltraSound Team textbox
	public void clearNoteToUltraSoundTeam() {
		objScreeningMaintainance.getTxt_NoteUltraSound().clear();
	}

	// Enter text to Note for UltraSound Team textbox
	public void sendNoteToUltraSoundTeam(String note1) {
		objScreeningMaintainance.getTxt_NoteUltraSound().sendKeys(note1);
	}

	// Get text from Note for Call Center
	public String getNoteToCallCenter() {
		String noteCC = objScreeningMaintainance.getTxt_NoteCallCenter().getText();
		return noteCC;
	}

	// Clear text from Note for Call Center
	public void clearNoteToCallCenter() {
		objScreeningMaintainance.getTxt_NoteCallCenter().clear();
	}

	// Enter text to Note for Call Center
	public void sendNoteToCallCenter(String note2) {
		objScreeningMaintainance.getTxt_NoteCallCenter().sendKeys(note2);
	}

	// Click to Save & Continue at Site Info tab
	public void saveAndContinueAtSiteInfoTab() {
		objScreeningMaintainance.getBtn_SaveContinueSiteInfo().click();

	}

	// Wait for loading icon disappeared
	public void waitForPageToLoad(int timeInSecond) {
		new WebDriverWait(driver, timeInSecond)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_body_imgLoaderScreening")));
	}

	/**
	 * TODO: new method to get product only
	 * 
	 * @return
	 */
	public ArrayList<String> getProductsOnly() {
		int NumOfProduct2 = driver
				.findElements(By
						.xpath("//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr"))
				.size() - 1;

		// Declare array Product - prepare to get all product/packet name to
		// this Array
		ArrayList<String> product = new ArrayList<>();

		// Test arrayList

		for (int i = 2; i <= NumOfProduct2 + 1; i++) {
			String xpath_ProductNode = "//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr["
					+ i + "]/td[2]";
			String value = driver.findElement(By.xpath(xpath_ProductNode)).getText();
			String xpath_ProPac = "//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr["
					+ i + "]/td[1]";
			if (value.equals("Product")) {
				product.add(driver.findElement(By.xpath(xpath_ProPac)).getText());
			} 
//			else {
//				System.out.println("There isn't any products");
//
//			}

		}
		return product;
	}

	public ArrayList<String> getPacketOnly() {
		int NumOfProduct2 = driver
				.findElements(By
						.xpath("//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr"))
				.size() - 1;

		// Declare array Product - prepare to get all product/packet name to
		// this Array
		ArrayList<String> packet = new ArrayList<>();

		// Test arrayList

		for (int i = 2; i <= NumOfProduct2 + 1; i++) {
			String xpath_ProductNode = "//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr["
					+ i + "]/td[2]";
			String value = driver.findElement(By.xpath(xpath_ProductNode)).getText();
			String xpath_ProPac = "//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr["
					+ i + "]/td[1]";
			if (value.equals("Package")) {
				packet.add(driver.findElement(By.xpath(xpath_ProPac)).getText());
			} 
//				else {
//				System.out.println("There isn't any packet");
//
//			}

		}
		return packet;
	}
}
