package com.vsii.cstar.pages.methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.vsii.cstar.pages.AppointmentsSingleScreeningPage;

public class AppointmentListPageMethods {
	WebDriver driver;
	public AppointmentsSingleScreeningPage objAppoinmentSingleScreen = new AppointmentsSingleScreeningPage();

	public AppointmentListPageMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objAppoinmentSingleScreen);
	}

	public void getParticipantNameByScheduleTime(String time){
		
	}
}
