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

	//Get header of page
	public String getPageHeader(){
		return objTeamCalendar.getVal_PageHeader().getText();
	}
	
	//Get current month - year info
	public String getSelectedMonthYear(){
		return objTeamCalendar.getLbl_MonthYearInfo().getText();
	}
	
	// Select dropdown Month and choose a specific month
	public void selectMonth(String month) {
		Select selectobj = new Select(objTeamCalendar.getDropdown_Month());
		selectobj.selectByVisibleText(month);
	}

	// Select dropdown Year and choose a specific year by visible text
	public void selectYear(String year) {
		Select selectobj = new Select(objTeamCalendar.getDropdown_Year());
		selectobj.selectByVisibleText(year);
	}

	// Select dropdown Team and choose a specific team
	public void selectTeam(String teamCode) throws IOException, SQLException {
		String team = this.getFullTeamName(teamCode).trim();
		Select selectobj = new Select(objTeamCalendar.getDropdown_Team());
		selectobj.selectByVisibleText(team);
	}

	// Wait for loading img to load
	public void waitForLoadingIconToLoad() {
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
	public void rightClickToDateCell(String date) throws ParseException {
		String dateNew = this.convertDate(date);
		String xpathDate = "//table/tbody/tr/td[contains(@oncontextmenu,'" + dateNew + "')]";
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

	//Choose view type - Calendar
	public void selectCalendarView() {
		objTeamCalendar.getRadio_Calendar().click();
	}
	
	// Show all team's calendar
	public void selectShowAll() {
		objTeamCalendar.getCheckbox_Showall().click();
	}

	// Click to add screening
	public void addScreening() {
		objTeamCalendar.getOption_AddScreening().click();
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
	 * @throws ParseException 
	 */
	public boolean isScreeningExistThisDate(String date) throws ParseException {
		String dateNew = this.convertDate(date);
		String xpath_dateLocation = "//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
				+ dateNew + "')]";
		String value = driver.findElement(By.xpath(xpath_dateLocation)).getAttribute("oncontextmenu");
		// System.out.println(value);
		boolean isExisted = false;
		if (value.contains("'1','True','True'")) {
			isExisted = true;
		}
		return isExisted;
	}

	// Select screening by input date
	public void selectScreeningByInputDate(String date) throws ParseException {
		String dateNew = this.convertDate(date);
		String xpath_ScreeningHyperLinkLocator = "//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
				+ dateNew + "')]/span/b/a";
		driver.findElement(By.xpath(xpath_ScreeningHyperLinkLocator)).click();
	}

	//Get border color of a date
	public String getColorBorderOfADate(String currDate){
		String xpath_Date = "//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"+ currDate + "')]";
		return driver.findElement(By.xpath(xpath_Date)).getCssValue("border-left-color");
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
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public ArrayList<String> getTeamsHaveScreeningInUI(String date) throws IOException, SQLException, ParseException {
		String dateNew = this.convertDate(date);
		String teamName = "Null";
		ArrayList<String> teamNames = new ArrayList<>();
		for (int i = 0; i < this.getTeamList().size(); i++) {
			teamName = this.getTeamList().get(i).getText();
			this.selectTeam(teamName);
			new WebDriverWait(driver, 30)
					.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_imgLoading")));
			if (this.isScreeningExistThisDate(dateNew) == true) {
				System.out.println("Team " + teamName + " has screening in this date");
				teamNames.add(teamName);
			}
		}
		return teamNames;
	}

	public ArrayList<String> getTeamsHaveScreeningByQueryDB(String oldDate)
			throws ParseException, IOException, SQLException {
//		String newDate;
//		final String OLD_FORMAT = "MM/dd/yyyy";
//		final String NEW_FORMAT = "yyyy-MM-dd 00:00:00.000";
//		SimpleDateFormat dateFormat = new SimpleDateFormat(OLD_FORMAT);
//		Date d = dateFormat.parse(oldDate);
//		dateFormat.applyPattern(NEW_FORMAT);
//		newDate = dateFormat.format(d);
		// System.out.println(newDate);
		String teamData = "Null";
		ArrayList<String> teamNames = new ArrayList<>();

		String sqlCommand_01 = "select DISTINCT team.Team_Code, " + "empGroup.Employee_Group_Name "
				+ "from SC_Screenings sc " + "join PL_Employee_Groups "
				+ "empGroup on sc.Employee_Group_ID=empGroup.Employee_Group_ID "
				+ "join PL_Teams team on team.Employee_Group_ID=empGroup.Employee_Group_ID "
				+ "where sc.Screening_Date='" + oldDate + "'";
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

	// Get team full phrase (teamcode + team name)
	public String getFullTeamName(String teamCode) throws IOException, SQLException {
		String sqlCommand_GetTeamName = "select TOP(1)t.Team_Code, eg.Employee_Group_Name from PL_Teams t "
				+ "join PL_Employee_Groups eg on eg.Employee_Group_ID=t.Employee_Group_ID "
				+ "where t.Team_Code='"+teamCode+"'";
		ResultSet rs = DBConnection.connectSQLServer(sqlCommand_GetTeamName);
		
		String teamFullName = "Null";
		while(rs.next()){
			teamFullName = rs.getString(1) + " - " + rs.getString(2) ;
		}
		return teamFullName;
	}

	// Convert Date
	public String convertDate(String date) throws ParseException {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date2 = formatDate.parse(date);
		String finalDate = new SimpleDateFormat("M/d/yyyy").format(date2).toString();
		return finalDate;
	}

	// Get screening's name
	public String getScreeningName(String date) throws ParseException {
		String dateNew = this.convertDate(date);
		String xpath_screeningNamelocator = "//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
				+ dateNew + "')]/span/b/a";
		return driver.findElement(By.xpath(xpath_screeningNamelocator)).getText();
	}

	// Get screening's tertorial & zip code
	public String getScreeningZipCode(String date) throws ParseException {
		String dateNew = this.convertDate(date);
		String xpath_screeningZipCodelocator = "//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
				+ dateNew + "')]/span"; // /br[2]
		return driver.findElement(By.xpath(xpath_screeningZipCodelocator)).getText().split("\n")[1];
	}

	// Get screening's representative
	public String getScreeningRepresentative(String date) throws ParseException {
		String dateNew = this.convertDate(date);
		String xpath_screeningRepresentativelocator = "//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
				+ dateNew + "')]/span";
		return driver.findElement(By.xpath(xpath_screeningRepresentativelocator)).getText().split("\n")[3];
	}

	// Get screening's status
	public String getScreeningStatus(String date) throws ParseException {
		String dateNew = this.convertDate(date);
		String xpath_screeningRepresentativelocator = "//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
				+ dateNew + "')]/span";
		return driver.findElement(By.xpath(xpath_screeningRepresentativelocator)).getText().split("\n")[4];
	}

	// Get screening's drive type
	public String getScreeningDriveType(String date) throws ParseException {
		String dateNew = this.convertDate(date);
		String xpath_screeningDriveTypelocator = "//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
				+ dateNew + "')]/span";
		return driver.findElement(By.xpath(xpath_screeningDriveTypelocator)).getText().split("\n")[5]
				.replaceAll("\\d+.*", "").trim();
	}
	
	//Get full screening infomation
	public String getFullScreeningInfo(String date) throws ParseException {
		String dateNew = this.convertDate(date);
		String xpath_screeningDriveTypelocator = "//table[@id='ctl00_plcMain_calSchedule']/tbody/tr/td[contains(@oncontextmenu,'"
				+ dateNew + "')]/span";
		return driver.findElement(By.xpath(xpath_screeningDriveTypelocator)).getText();
	}
	
	//Select dropdownlist Territory
	public Select selectDropdownTerritory(){
		Select ddlTerritory = new Select(objTeamCalendar.getDdl_Territory());
		return ddlTerritory;
	}
	
	//Click to button save for Reserved Date function
	public void saveReservedDate(){
		objTeamCalendar.getBtn_SaveReservedDate().click();
	}
	
	public void cancelReservedDate(){
		objTeamCalendar.getBtn_CancelReservedDate().click();
	}
	
	//Reserved Date
	public void reservedDate(String date, String territory) throws ParseException{
		this.rightClickToDateCell(date);
		this.selectOptionReservedDate();
		this.waitForLoadingIconToLoad();
		this.selectDropdownTerritory().selectByVisibleText(territory);
		this.saveReservedDate();
		this.waitForLoadingIconToLoad();
	}
	
	//Get reserved date infomarion
	public String getReservedInfo(String date) throws ParseException{
		String dateNew = this.convertDate(date);
		String xpathReservedInfo = "//table/tbody/tr/td[contains(@oncontextmenu,'" + dateNew + "')]/span";
		return driver.findElement(By.xpath(xpathReservedInfo)).getText();
	}
	
}
