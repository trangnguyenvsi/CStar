package com.vsii.cstar.pages.methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.vsii.cstar.pages.HomePage;

public class HomePageMethods {
	WebDriver driver;
	public HomePage objHomePage = new HomePage();

	public HomePageMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objHomePage);
	}
	
	public void mouseHoverScreeningConfig(){
		Actions action=new Actions(driver);
		action.moveToElement(objHomePage.getMenu_Screeningcfg()).perform();		
	}
	
	public void selectSubMenuTeamCalendar(){
		objHomePage.getSubmenu_Teamcalendar().click();;
	}
}
