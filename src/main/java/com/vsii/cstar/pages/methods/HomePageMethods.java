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
	
	//Mousehover to menu Screening Config
	public void mouseHoverScreeningConfig(){
		Actions action=new Actions(driver);
		action.moveToElement(objHomePage.getMenu_Screeningcfg()).perform();		
	}
	
	//Select submenu Team Calendar & Grid
	public void selectSubMenuTeamCalendar(){
		objHomePage.getSubmenu_Teamcalendar().click();;
	}
	
	//Mousehover to menu Products & Pricing
	public void mouseHoverProductPricing(){
		Actions action=new Actions(driver);
		action.moveToElement(objHomePage.getMenu_ProductPricing()).perform();		
	}
	
	//Select submenu Product Set
	public void selectSubMenuProductSet(){
		objHomePage.getSubmenu_ProductSet().click();;
	}
	
	//Select submenu Product List
	public void selectSubMenuProductList(){
		objHomePage.getSubmenu_ProductList().click();
	}
	
	//Select submenu Package
	public void selectSubMenuPackage(){
		objHomePage.getSubmenu_Package().click();
	}
}
