package com.vsii.cstar.pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.vsii.cstar.pages.AppointmentsSingleScreeningPage;

public class AppointmentsSingleScreeningPageMethod {
	WebDriver driver;
	public AppointmentsSingleScreeningPage objAppoinmentSingleScreen = new AppointmentsSingleScreeningPage();

	public AppointmentsSingleScreeningPageMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objAppoinmentSingleScreen);
	}

	public String getSpanIdByDateId(String time) {
		// Extract DateId
		String xpathScheduleTime = "//span[text()='" + time + "']";
		String dateId = driver.findElement(By.xpath(xpathScheduleTime)).getAttribute("id");

		// Extract cellId
		String constId = dateId.replace("_lblDate", "");
		return constId;
	}

	public String getParticipantName(String time) {
		String nameid = this.getSpanIdByDateId(time) + "_lblName";
		String participantName = driver.findElement(By.id(nameid)).getText();
		return participantName;
	}
	
	public String getParticipantPhoneZip(String time) {
		String phonezipId = this.getSpanIdByDateId(time) + "_lblPhoneZip";
		String phoneZip = driver.findElement(By.id(phonezipId)).getText();
		return phoneZip;
	}
	
	public String getParticipantAmount(String time) {
		String amtId = this.getSpanIdByDateId(time) + "_lblAmount";
		String amount = driver.findElement(By.id(amtId)).getText();
		return amount;
	}
	
	public String getParticipantAmountDue(String time) {
		String amtDueId = this.getSpanIdByDateId(time) + "_lblAmount";
		String amountDue = driver.findElement(By.id(amtDueId)).getText();
		return amountDue;
	}
}
