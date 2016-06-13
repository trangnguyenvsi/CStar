package com.vsii.cstar.pages.methods;

import java.util.ArrayList;
import java.util.Arrays;

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

	public enum TAB {
		SITE_INFO, ACCOUNTING, PRODUCTS_PRICING, TRAVEL, ADVANCED_TRAVEL, MARKETING, NOTES, HISTORY, OPERATION
	}

	public ScreeningMaintainanceMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objScreeningMaintainance);
	}

	// Get header of page
	public String getPageHeader() {
		return objScreeningMaintainance.getLbl_Heading().getText();
	}

	// get Screening name
	public String getScreeningName() {
		return objScreeningMaintainance.getLbl_ScreeningName().getText();
	}

	// Get site address
	public String getSiteAddress() {
		return objScreeningMaintainance.getLabel_SiteAddress().getText();
	}

	// Get site phone no
	public String getSitePhoneNo() {
		return objScreeningMaintainance.getLabel_SitePhoneNo().getText();
	}

	// Get site fax no
	public String getSiteFaxNo() {
		return objScreeningMaintainance.getLabel_SiteFaxNo().getText();
	}

	// Get site contact name
	public String getSiteContactUser() {
		return objScreeningMaintainance.getLabel_SiteContact().getText();
	}

	// Get site's contact type
	public String getSiteContactType() {
		return objScreeningMaintainance.getVal_ContactType().getText();
	}

	// Get site contact phone
	public String getSiteContactPhone() {
		return objScreeningMaintainance.getLabel_SiteContactPhoneNo().getText();
	}

	// Get site contact phone type
	public String getSiteContactPhoneType() {
		return objScreeningMaintainance.getVal_ContactPhoneType().getText().replaceAll("\\(", "").replaceAll("\\)", "");
	}

	// Get site contact email
	public String getSiteContactEmail() {
		return objScreeningMaintainance.getLabel_SiteContactEmail().getText();
	}

	// Get site contact email type
	public String getSiteContactEmailType() {
		return objScreeningMaintainance.getVal_ContactEmailType().getText();
	}

	// Get Screening representative
	public String getScreeningRepresentative() {
		return objScreeningMaintainance.getLabel_Representative().getText();
	}

	// Get representative's department
	public String getRepresentativeDepartment() {
		return objScreeningMaintainance.getLabel_Department().getText();
	}

	// Get drive type
	public String getDriveType() {
		return objScreeningMaintainance.getLabel_DriveType().getText();
	}

	// Get drive time
	public String getDriveTime() {
		return objScreeningMaintainance.getLabel_DriveTime().getText();
	}

	// Get price level
	public String getPriceLevel() {
		return objScreeningMaintainance.getLabel_PriceLevel().getText();
	}

	// Get facility time
	public String getFacilityTime() {
		return objScreeningMaintainance.getLabel_FacilityTime().getText();
	}

	// Get marketing plan
	public String getMarketingPlan() {
		return objScreeningMaintainance.getLabel_MarketingPlan().getText();
	}

	// Get site type
	public String getSiteType() {
		return objScreeningMaintainance.getLabel_SiteType().getText();
	}

	// Get marketing zip code
	public String getMarketingZipCode() {
		return objScreeningMaintainance.getLabel_MarketingZipCode().getText();
	}

	// Get time screening has status: Preliminary
	public String getPreliminaryTime() {
		return objScreeningMaintainance.getLbl_Premininary().getText();
	}

	// Get time screening has status: Scheduling
	public String getSchedulingTime() {
		return objScreeningMaintainance.getLbl_Scheduling().getText();
	}

	// Get time screening has status: Expecting Upload
	public String getExpectingUpload() {
		return objScreeningMaintainance.getLbl_ExpectingUpload().getText();
	}

	// Get Screening Territory
	public String getScreeningTerritory() {
		return objScreeningMaintainance.getLabel_SiteAddress().getText().split("\n")[1];
	}

	// Get Screening Status
	public String getScreeningStatus() {
		return objScreeningMaintainance.getLbl_ScreeningStatus().getText();
	}

	// Get Screening's Drive Type
	public String getScreeningDriveType() {
		return objScreeningMaintainance.getLabel_DriveType().getText();
	}

	// Get Screening's Drive Time
	public String getScreeningDriveTime() {
		return objScreeningMaintainance.getLabel_DriveTime().getText();
	}

	// Get Screening's Schedule code
	public String getScreeningScheduleCode() {
		return objScreeningMaintainance.getLabel_ScheduleCode().getText();
	}

	// Get Screening's Schedule time
	public String getScreeningScheduleTime() {
		return objScreeningMaintainance.getLbl_ScheduleTime().getText();
	}

	// Get Screening's Time zone
	public String getScreeningTimeZone() {
		return objScreeningMaintainance.getLbl_TimeZone().getText();
	}

	// Click to Appointments hyperlink
	public void clickAppointmentsLinkText() {
		objScreeningMaintainance.getLink_Appointments().click();
	}

	// Select tab Site Info
	public void selectSiteInfoTab() {
		objScreeningMaintainance.getTab_SiteInfo().click();
	}

	// Get all checkbox name in site info tab - Site infor tab
	public ArrayList<String> getAllCheckboxName() {
		int NoOfCheckBox = driver
				.findElements(
						By.xpath("//table[@id='ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo']/tbody/tr"))
				.size();
		ArrayList<String> checkboxNames = new ArrayList<>();
		for (int i = 1; i <= NoOfCheckBox; i++) {
			String xpath_chkNamelocation = "//table[@id='ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo']/tbody/tr["
					+ i + "]/td[2]";
			checkboxNames.add(driver.findElement(By.xpath(xpath_chkNamelocation)).getText());
		}
		return checkboxNames;
	}

	// Get all checkbox status - Site infor tab
	public ArrayList<String> getAllCheckboxStatus() {
		int NoOfCheckBox = driver
				.findElements(
						By.xpath("//table[@id='ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo']/tbody/tr"))
				.size();
		ArrayList<String> chkStatus = new ArrayList<>();
		for (int i = 1; i <= NoOfCheckBox; i++) {
			String xpath_chklocation = "//table[@id='ctl00_body_tabScreeningInfo_tabPnlSiteInfo_grdSiteInfo']/tbody/tr["
					+ i + "]/td[1]/input";
			String value = driver.findElement(By.xpath(xpath_chklocation)).getAttribute("checked");
			if (value != null) {
				chkStatus.add("checked");
			} else {
				chkStatus.add("unchecked");
			}
		}
		return chkStatus;
	}

	// Select tab Accounting
	public void selectAccountingTab() {
		objScreeningMaintainance.getTab_Accounting().click();
	}

	// Get payments fullfill value - Accounting tab
	public String getPaymentsFullfilledValue() {
		return objScreeningMaintainance.getVal_PaymentsFullfilled().getText();
	}

	// Get payments request value - Accounting tab
	public String getPaymentsRequestedValue() {
		return objScreeningMaintainance.getVal_PaymentsRequested().getText();
	}

	// Check if there is any check request or not - Accounting tab
	public boolean isCheckRequestExist() {
		boolean isExisted;
		if (driver.findElements(By.id("ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_gvCheckRequests"))
				.size() != 0) {
			isExisted = true;
		} else {
			isExisted = false;
		}
		return isExisted;
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

	// Get chosen product set
	public String getChosenProductSet() {
		Select selecto = new Select(objScreeningMaintainance.getDdl_ProductSet());
		String chosenProductSet = selecto.getFirstSelectedOption().getText();
		return chosenProductSet;
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

	// Select checkbox in tab Site Info by check box's name
	public void selectSiteRequirements(String checkboxName) {

		// Declare checkbox location
		String xpath_chk_ScreeningRequirements = "//td[following-sibling::td[contains(text(),\"" + checkboxName
				+ "\")]]/input";

		// Get checkbox status
		String chkStatus = driver.findElement(By.xpath(xpath_chk_ScreeningRequirements)).getAttribute("checked");

		// If checkbox is checked, then leave it alone, else check it
		if (chkStatus == null) {
			driver.findElement(By.xpath(xpath_chk_ScreeningRequirements)).click();
		}
	}

	// De-Select checkbox in tab Site Info by check box's name
	public void deselectSiteRequirements(String checkboxName) {
		// Declare checkbox location
		String xpath_chk_ScreeningRequirements = "//td[following-sibling::td[contains(text(),\"" + checkboxName
				+ "\")]]/input";

		// Get checkbox status
		String chkStatus = driver.findElement(By.xpath(xpath_chk_ScreeningRequirements)).getAttribute("checked");

		// If checkbox is checked, then leave it alone, else check it
		if (chkStatus.toString() != null) {
			driver.findElement(By.xpath(xpath_chk_ScreeningRequirements)).click();
		}
	}

	// Get status of checkbox Screening requirements
	public boolean isScreeningRequirementsChecked(String checkboxName) {
		boolean isChecked = false;

		// Declare checkbox location
		String xpath_chk_ScreeningRequirements = "//td[following-sibling::td[contains(text(),\"" + checkboxName
				+ "\")]]/input";

		// Get checkbox status
		String chkStatus = driver.findElement(By.xpath(xpath_chk_ScreeningRequirements)).getAttribute("checked");

		// Get boolean value base on condition of checkbox
		if (chkStatus.toString() != null) {
			isChecked = true;
		}

		return isChecked;
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

	// Add new check request
	public void addCheckRequest(String purpose, String payAbleTo, String amount, String VAT, String dateNeedeed) {
		// Click link Add Check Request
		objScreeningMaintainance.getLnk_AddCheckRequest().click();
		this.waitForPageToLoad(30);

		// Select purpose
		new Select(objScreeningMaintainance.getChk_Purpose()).selectByVisibleText(purpose);
		objScreeningMaintainance.getChk_PayTo().sendKeys(payAbleTo);
		objScreeningMaintainance.getTxt_Amount().sendKeys(amount);
		objScreeningMaintainance.getTxt_VAT().sendKeys(VAT);
		objScreeningMaintainance.getTxt_DateNeeded().sendKeys(dateNeedeed);

		// Save
		objScreeningMaintainance.getBtn_SaveCheckRequest().click();
		this.waitForSaveCheckRequest();
	}

	//Click link Edit check request base on its purpose
	public void clickLinkEditCheckRequestByItsPurpose(String purpose) {
		String xpath_EditButton = "//span[contains(text(),'" + purpose + "')]/../../td/a[contains(text(),'Edit')]";
		driver.findElement(By.xpath(xpath_EditButton)).click();
		this.waitForPageToLoad(30);
	}
	
	//Get check request status by its purpose
	public String getCheckRequestStatus(String purpose){
		String xpath_Status="//td[preceding-sibling::td/span[contains(text(),'"+purpose+"')]][8]/a";
		return driver.findElement(By.xpath(xpath_Status)).getText();
	}

	// Wait for loading icon disappeared
	public void waitForPageToLoad(int timeInSecond) {
		new WebDriverWait(driver, timeInSecond)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_body_imgLoaderScreening")));
	}

	// Wait for save check request
	public void waitForSaveCheckRequest() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(
				By.id("ctl00_body_tabScreeningInfo_tabPnlAccounting_ctlCheckRequest_imgLoaderScreening")));
	}

	/**
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
			// else {
			// System.out.println("There isn't any products");
			//
			// }

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
			// else {
			// System.out.println("There isn't any packet");
			//
			// }

		}
		return packet;
	}

	// Get all items (name) in product set list
	public ArrayList<String> getAllItemsInProductSet() {
		int NumOfItems = driver
				.findElements(By
						.xpath("//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr"))
				.size() - 1;

		// Declare array Product - prepare to get all product/packet name to
		// this Array
		ArrayList<String> items = new ArrayList<>();

		// Test arrayList

		for (int i = 2; i <= NumOfItems + 1; i++) {
			String xpath_ProPac = "//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr["
					+ i + "]/td[1]";
			items.add(driver.findElement(By.xpath(xpath_ProPac)).getText().trim());
		}

		return items;
	}

	// Get all items (type) in product set list
	public ArrayList<String> getItemTypeInProductSet() {
		int NumOfItems = driver
				.findElements(By
						.xpath("//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr"))
				.size() - 1;

		// Declare array Product - prepare to get all product/packet name to
		// this Array
		ArrayList<String> itemType = new ArrayList<>();

		// Test arrayList

		for (int i = 2; i <= NumOfItems + 1; i++) {
			String xpath_ProPac = "//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr["
					+ i + "]/td[2]";
			itemType.add(driver.findElement(By.xpath(xpath_ProPac)).getText());
		}

		return itemType;
	}

	// Get all items (price) in product set list
	public ArrayList<String> getItemPriceInProductSet() {
		int NumOfItems = driver
				.findElements(By
						.xpath("//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr"))
				.size() - 1;

		// Declare array Product - prepare to get all product/packet name to
		// this Array
		ArrayList<String> itemPrice = new ArrayList<>();

		// Test arrayList

		for (int i = 2; i <= NumOfItems + 1; i++) {
			String xpath_ProPac = "//table[@id='ctl00_body_tabScreeningInfo_tabPnlProductPricing_grdPackages2']/tbody/tr["
					+ i + "]/td[4]";
			itemPrice.add(driver.findElement(By.xpath(xpath_ProPac)).getText());
		}

		return itemPrice;
	}

	public void clickButonExit(TAB tabname) {
		switch (tabname) {

		case SITE_INFO:
			objScreeningMaintainance.getBtn_Exit_SiteInfo().click();
			break;
		case ACCOUNTING:
			objScreeningMaintainance.getBtn_Exit_Accounting().click();
			break;
		case PRODUCTS_PRICING:
			objScreeningMaintainance.getBtn_Exit_PPtab().click();
			break;
		case TRAVEL:
			objScreeningMaintainance.getBtn_Exit_Travel().click();
			break;
		case ADVANCED_TRAVEL:
			objScreeningMaintainance.getBtn_Exit_AdvanceTravel().click();
			break;
		case MARKETING:
			objScreeningMaintainance.getBtn_Exit_Marketing().click();
			break;
		case NOTES:
			objScreeningMaintainance.getBtn_Exit_Notes().click();
			break;
		case HISTORY:
			objScreeningMaintainance.getBtn_Exit_History().click();
			break;
		case OPERATION:
			objScreeningMaintainance.getBtn_Exit_Operations().click();
			break;
		default:
			break;
		}
	}

	public void clickEditSite() {
		objScreeningMaintainance.getBtn_EditSite().click();
	}

}
