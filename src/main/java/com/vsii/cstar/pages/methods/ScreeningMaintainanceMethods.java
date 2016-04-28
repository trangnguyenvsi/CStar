package com.vsii.cstar.pages.methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.vsii.cstar.pages.ScreeningMaintenance;

public class ScreeningMaintainanceMethods {
	WebDriver driver;
	public ScreeningMaintenance objScreeningMaintainance = new ScreeningMaintenance();
	
	public ScreeningMaintainanceMethods(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, objScreeningMaintainance);
	}
	
	public void clickAppointmentsLinkText(){
		objScreeningMaintainance.getLink_Appointments().click();
	}
}
