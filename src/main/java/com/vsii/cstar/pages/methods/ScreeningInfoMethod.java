package com.vsii.cstar.pages.methods;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vsii.cstar.pages.ScreeningInfo;

public class ScreeningInfoMethod {
	WebDriver driver;
	public ScreeningInfo objScreeningInfo = new ScreeningInfo();

	public enum DDLNAME {
		REPRESENTATIVE, MARKETING_PLAN, DRIVE_TYPE, PRODUCT_SET, PRICE_LEVEL, SCHEDULE_CODE
	};

	public ScreeningInfoMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objScreeningInfo);
	}

	public void selectRepresentativeByText(String repName) {
		Select oSelect = new Select(objScreeningInfo.getDropdown_Representative());
		oSelect.selectByVisibleText(repName);
	}

	public void selectMarketingPlanByText(String marketingPlan) {
		Select oSelect = new Select(objScreeningInfo.getDropdown_MarketingPlan());
		oSelect.selectByVisibleText(marketingPlan);
	}

	public void selectDriveTypeByText(String driveType) {
		Select oSelect = new Select(objScreeningInfo.getDropdown_DriveType());
		oSelect.selectByVisibleText(driveType);
	}

	public void waitForElementToLoad() {
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_body_imgProgress")));
	}

	public void selectProductSetByItName(String productSetName) {
		Select oSelect = new Select(objScreeningInfo.getDropdown_ProductSet());
		oSelect.selectByVisibleText(productSetName);
	}

	public void selectPriceLevelByItName(String priceLevelName) {
		Select oSelect = new Select(objScreeningInfo.getDropdown_PriceLevel());
		oSelect.selectByVisibleText(priceLevelName);
	}

	public void clickBtnSaveContinueScreening() {
		objScreeningInfo.getBtn_SaveNContinueToScreening().click();
	}

	public ArrayList<String> getAllTextFromDropdownList(DDLNAME dropdownName) {
		ArrayList<String> result = new ArrayList<>();
		switch (dropdownName) {
		case REPRESENTATIVE:
			result.clear();
			Select oSelect = new Select(objScreeningInfo.getDropdown_Representative());
			for (WebElement webElement : oSelect.getOptions()) {
				result.add(webElement.getText());
			}
			break;
		case DRIVE_TYPE:
			result.clear();
			Select oSelect1 = new Select(objScreeningInfo.getDropdown_DriveType());
			for (WebElement webElement : oSelect1.getOptions()) {
				result.add(webElement.getText());
			}
			break;
		case MARKETING_PLAN:
			result.clear();
			Select oSelect2 = new Select(objScreeningInfo.getDropdown_MarketingPlan());
			for (WebElement webElement : oSelect2.getOptions()) {
				result.add(webElement.getText());
			}
			break;
		case PRODUCT_SET:
			result.clear();
			Select oSelect3 = new Select(objScreeningInfo.getDropdown_ProductSet());
			for (WebElement webElement : oSelect3.getOptions()) {
				result.add(webElement.getText());
			}
			break;
		case PRICE_LEVEL:
			result.clear();
			Select oSelect4 = new Select(objScreeningInfo.getDropdown_PriceLevel());
			for (WebElement webElement : oSelect4.getOptions()) {
				result.add(webElement.getText());
			}
			break;
		case SCHEDULE_CODE:
			result.clear();
			Select oSelect5 = new Select(objScreeningInfo.getDropdown_ScheduleCode());
			for (WebElement webElement : oSelect5.getOptions()) {
				result.add(webElement.getText());
			}
			break;

		default:
			break;
		}
		return result;
	}

	public String getEmployeeIdOfSelectedRep() {
		Select oSelect = new Select(objScreeningInfo.getDropdown_Representative());
		String employeeId = oSelect.getFirstSelectedOption().getAttribute("value");
		return employeeId;
	}

	public String getValueFromSelectedOption(DDLNAME dropdownName) {
		String val = null;
		switch (dropdownName) {
		case REPRESENTATIVE:
			Select oSelect = new Select(objScreeningInfo.getDropdown_Representative());
			val = oSelect.getFirstSelectedOption().getText();
			break;
		case MARKETING_PLAN:
			Select oSelect1 = new Select(objScreeningInfo.getDropdown_MarketingPlan());
			val = oSelect1.getFirstSelectedOption().getText();
			break;
		case DRIVE_TYPE:
			Select oSelect2 = new Select(objScreeningInfo.getDropdown_DriveType());
			val = oSelect2.getFirstSelectedOption().getText();
			break;
		case PRODUCT_SET:
			Select oSelect3 = new Select(objScreeningInfo.getDropdown_DriveType());
			val = oSelect3.getFirstSelectedOption().getText();
			break;
		case PRICE_LEVEL:
			Select oSelect4 = new Select(objScreeningInfo.getDropdown_PriceLevel());
			val = oSelect4.getFirstSelectedOption().getText();
			break;
		case SCHEDULE_CODE:
			Select oSelect5 = new Select(objScreeningInfo.getDropdown_ScheduleCode());
			val = oSelect5.getFirstSelectedOption().getText();
			break;
		default:
			break;
		}

		return val;
	}

	public String getHIPAAValue() {
		return objScreeningInfo.getVal_HIPAA().getText();
	}
}