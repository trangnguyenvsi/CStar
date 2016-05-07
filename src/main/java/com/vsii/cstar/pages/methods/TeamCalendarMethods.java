package com.vsii.cstar.pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vsii.cstar.pages.TeamCalendarPage;
import com.vsii.tsc.utility.TestBase;

public class TeamCalendarMethods {
	WebDriver driver;
	public TeamCalendarPage objTeamCalendar = new TeamCalendarPage();

	public TeamCalendarMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objTeamCalendar);
	}

	// Select dropdown Month and choose a specific month
	public void selectMonth(String month) {
		Select selectobj = new Select(objTeamCalendar.getDropdown_Month());
		selectobj.selectByVisibleText(month);
	}

	// Select dropdown Year and choose a specific year
	public void selectYear(String year) {
		Select selectobj = new Select(objTeamCalendar.getDropdown_Year());
		selectobj.selectByVisibleText(year);
	}

	// Select dropdown Team and choose a specific team
	public void selectTeam(String team) {
		Select selectobj = new Select(objTeamCalendar.getDropdown_Team());
		selectobj.selectByVisibleText(team);
	}

	// Select a screening that visibling in calendar - select with screening
	// name
	public void selectExistingScreening(String screeningName) {
		// Thread.sleep("10000");
		// driver.findElement(By.linkText(screeningName)).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.linkText(screeningName)).click();
//		String xpath = "(//span[@id='lbl04DD2016']/b/a)[12]";
//		driver.findElement(By.xpath(xpath)).click();
	}

	

	// Righ click to a date in calendar - to prepare for add/select screening
	public void rightClickToDateCell(String date) {
		String xpathDate = "//table/tbody/tr/td[contains(@oncontextmenu,'" + date + "')]";
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.xpath(xpathDate))).perform();
	}

	// Click to Add Screening (after right click to a date)
	public void selectOptionAddScreening() {
		objTeamCalendar.getOption_AddScreening().click();
	}

	// Click to Reserved (after right click to a date)
	public void selectOptionReservedDate() {
		objTeamCalendar.getOption_Reserved().click();
	}

	// Choose view type - Grid
	public void selectGridView() {
		objTeamCalendar.getRadio_Grid().click();
	}

	// Show all team's calendar
	public void selectShowAll() {
		objTeamCalendar.getCheckbox_Showall().click();
	}

	// Click to add screening
	public void addScreening() {
		objTeamCalendar.getOption_AddScreening().click();
	}

	// Click to Reserved Date
	public void reservedDate() {
		objTeamCalendar.getOption_Reserved().click();
	}

	// Click to View Screening
	public void viewScreeningInNewWindow() {
		objTeamCalendar.getOption_ViewScreening().click();
	}

	// Click to Travel
	public void viewTravel() {
		objTeamCalendar.getOption_Travel().click();
	}

	// Click to Site Change
	public void siteChange() {
		objTeamCalendar.getOption_SiteChange().click();
	}
}
