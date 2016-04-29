package com.vsii.cstar.pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	
	public void selectTeam(String team){
		Select selectobj=new Select(objTeamCalendar.getDropdown_Team());
		selectobj.selectByVisibleText(team);
	}
	
	public void selectExistingScreening(String screeningName){
		driver.findElement(By.linkText(screeningName)).click();
	}
}
