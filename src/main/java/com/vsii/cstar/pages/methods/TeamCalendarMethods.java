package com.vsii.cstar.pages.methods;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vsii.cstar.pages.TeamCalendarPage;
import com.vsii.tsc.utility.DBConnection;

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

	//Wait for loading img to load
	public void waitForLoadingIconToLoad(){
		new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_imgLoading")));
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
		// String xpath = "(//span[@id='lbl04DD2016']/b/a)[12]";
		// driver.findElement(By.xpath(xpath)).click();
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

	// Check if screening exist in checked date or not
	/**
	 * 
	 * @param date
	 *            :Date should be in MM/dd/YYYY format (exclude zero leading)
	 * @return true if date have screening, false if date not contain any
	 *         screenings
	 */
	public boolean isScreeningExistThisDate(String date) {
		String xpath_dateLocation = "//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
				+ date + "')]";
		String value = driver.findElement(By.xpath(xpath_dateLocation)).getAttribute("oncontextmenu");
		// System.out.println(value);
		boolean isExisted = false;
		if (value.contains("'1','True','True'")) {
			isExisted = true;
		}
		return isExisted;
	}
	
	//Select screening by input date
	public void selectScreeningByInputDate(String date){
		String xpath_ScreeningHyperLinkLocator=
				"//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
				+ date + "')]/span/b/a";
		driver.findElement(By.xpath(xpath_ScreeningHyperLinkLocator)).click();
	}

	// Get all team list in dropdown list Team
	public List<WebElement> getTeamList() {
		Select select = new Select(objTeamCalendar.getDropdown_Team());
		List<WebElement> teamList = select.getOptions();
		return teamList;
	}

	// Get teams have screening in chosend date
	/**
	 * @NOTE Date chosen must have month same with selected month
	 * @param date
	 * @return All team have screening in chosen date
	 */
	public ArrayList<String> getTeamsHaveScreeningInUI(String date) {
		String teamName = "Null";
		ArrayList<String> teamNames = new ArrayList<>();
		for (int i = 0; i < this.getTeamList().size(); i++) {
			teamName = this.getTeamList().get(i).getText();
			this.selectTeam(teamName);
			new WebDriverWait(driver, 30)
					.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_imgLoading")));
			if (this.isScreeningExistThisDate(date) == true) {
				System.out.println("Team " + teamName + " has screening in this date");
				teamNames.add(teamName);
			}
		}
		return teamNames;
	}

	public ArrayList<String> getTeamsHaveScreeningByQueryDB(String oldDate)
			throws ParseException, IOException, SQLException {
		String newDate;
		final String OLD_FORMAT = "MM/dd/yyyy";
		final String NEW_FORMAT = "yyyy-MM-dd 00:00:00.000";
		SimpleDateFormat dateFormat = new SimpleDateFormat(OLD_FORMAT);
		Date d = dateFormat.parse(oldDate);
		dateFormat.applyPattern(NEW_FORMAT);
		newDate = dateFormat.format(d);
		// System.out.println(newDate);
		String teamData = "Null";
		ArrayList<String> teamNames = new ArrayList<>();

		String sqlCommand_01 = "select DISTINCT team.Team_Code, " + "empGroup.Employee_Group_Name "
				+ "from SC_Screenings sc " + "join PL_Employee_Groups "
				+ "empGroup on sc.Employee_Group_ID=empGroup.Employee_Group_ID "
				+ "join PL_Teams team on team.Employee_Group_ID=empGroup.Employee_Group_ID "
				+ "where sc.Screening_Date='" + newDate + "'";
		ResultSet rs1 = DBConnection.connectSQLServer(sqlCommand_01);
		while (rs1.next()) {
			String teamCode = rs1.getString(1);
			String teamName = rs1.getString(2);
			System.out.println(teamCode + " - " + teamName);
			teamData = teamCode + " - " + teamName;
			teamNames.add(teamData);
		}
		return teamNames;
	}

	// Get screening's name
	public String getScreeningName(String date) {
		String xpath_screeningNamelocator = "//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
				+ date + "')]/span/b/a";
		return driver.findElement(By.xpath(xpath_screeningNamelocator)).getText();
	}

	// Get screening's tertorial & zip code
	public String getScreeningZipCode(String date) {
		String xpath_screeningZipCodelocator = "//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
				+ date + "')]/span"; // /br[2]
		return driver.findElement(By.xpath(xpath_screeningZipCodelocator)).getText().split("\n")[1];
	}

	// Get screening's representative
	public String getScreeningRepresentative(String date) {
		String xpath_screeningRepresentativelocator = "//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
				+ date + "')]/span";
		return driver.findElement(By.xpath(xpath_screeningRepresentativelocator)).getText().split("\n")[3];
	}

	// Get screening's status
	public String getScreeningStatus(String date) {
		String xpath_screeningRepresentativelocator = "//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
				+ date + "')]/span";
		return driver.findElement(By.xpath(xpath_screeningRepresentativelocator)).getText().split("\n")[4];
	}

	// Get screening's drive type
	public String getScreeningDriveType(String date) {
		String xpath_screeningDriveTypelocator = "//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
				+ date + "')]/span";
		return driver.findElement(By.xpath(xpath_screeningDriveTypelocator)).getText().split("\n")[5];
	}
	
	//Get screening basic info
	public void getScreeningBasicInfo(String date){
		System.out.println(this.getScreeningName(date));
		this.getScreeningName(date);
		System.out.println(this.getScreeningZipCode(date));
		this.getScreeningZipCode(date);
		System.out.println(this.getScreeningRepresentative(date));
		this.getScreeningRepresentative(date);
		System.out.println(this.getScreeningStatus(date));
		this.getScreeningStatus(date);
		System.out.println(this.getScreeningDriveType(date));
		this.getScreeningDriveType(date);
	}
	
}
