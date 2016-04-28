package com.vsii.cstar.pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vsii.cstar.pages.TeamCalendarPage;

public class TeamCalendarMethods {
	WebDriver driver;
	public TeamCalendarPage objTeamCalendar = new TeamCalendarPage();
	

	public TeamCalendarMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objTeamCalendar);
	}
	
	//Select dropdown Month and choose a specific month
	public void selectMonth(String month){
		Select selectobj=new Select(objTeamCalendar.getDropdown_Month());
		selectobj.selectByVisibleText(month);
	}

	//Select dropdown Year and choose a specific year	
	public void selectYear(String year){
		Select selectobj=new Select(objTeamCalendar.getDropdown_Year());
		selectobj.selectByVisibleText(year);
	}
	
	//Select dropdown Team and choose a specific team
	public void selectTeam(String team){
		Select selectobj=new Select(objTeamCalendar.getDropdown_Team());
		selectobj.selectByVisibleText(team);
	}
	
	//Select a screening that visibling in calendar - select with screening name
	public void selectExistingScreening(String screeningName){
		driver.findElement(By.linkText(screeningName)).click();
	}
	
	//Righ click to a date in calendar - to prepare for add/select screening
	public void rightToDateCell(String date){
		String xpathDate="//table/tbody/tr/td[contains(@oncontextmenu,'" +date+ "')]";
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.xpath(xpathDate))).perform();
	}
	
	//Click to Add Screening (after right click to a date) 
	public void selectOptionAddScreening(){
		objTeamCalendar.getOption_AddScreening().click();
	}
	
	//Click to Reserved (after right click to a date)
	public void selectOptionReservedDate(){
		objTeamCalendar.getOption_Reserved().click();
	}
	
	//Choose view type - Grid
	public void selectGridView(){
		objTeamCalendar.getRadio_Grid().click();
	}
	
	
}
