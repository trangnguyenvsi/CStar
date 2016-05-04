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

	// Select Products & Pricing view
	public void selectProductView() {
		objAppoinmentSingleScreen.getRadio_ShowProduct().click();
	}

	// Select Phone, Zip view
	public void selectPhoneZipView() {
		objAppoinmentSingleScreen.getRadio_ShowPhoneZip().click();
	}

	// Get Span Id on Phone Zip View
	public String getSpanIdByDateId(String time) {
		// Extract DateId
		String xpathScheduleTime = "//span[text()='" + time + "']";
		String dateId = driver.findElement(By.xpath(xpathScheduleTime)).getAttribute("id");

		// Extract cellId
		String constId = dateId.replace("_lblDate", "");
		return constId;
	}

	// Get participant Name on Phone Zip View
	public String getParticipantName(String time) {
		String nameid = this.getSpanIdByDateId(time) + "_lblName";
		String participantName = driver.findElement(By.id(nameid)).getText();
		return participantName;
	}

	// Get participant Phone, Zip on Phone Zip View
	public String getParticipantPhoneZip(String time) {
		String phonezipId = this.getSpanIdByDateId(time) + "_lblPhoneZip";
		String phoneZip = driver.findElement(By.id(phonezipId)).getText();
		return phoneZip;
	}

	// Get Ammount on Phone Zip View
	public String getParticipantAmount(String time) {
		String amtId = this.getSpanIdByDateId(time) + "_lblAmount";
		String amount = driver.findElement(By.id(amtId)).getText();
		return amount;
	}

	// Get Amount Due on Phone Zip View
	public String getParticipantAmountDue(String time) {
		String amtDueId = this.getSpanIdByDateId(time) + "_lblAmount";
		String amountDue = driver.findElement(By.id(amtDueId)).getText();
		return amountDue;
	}

	public void getAllProductCode() {
		int colNo = driver.findElements(By.xpath("//th[@class='GridSingleChar' and @scope='col']")).size();
		for (int i = 0; i <= (colNo - 9); i++) {

		}
		// System.out.println(colNo);

	}
	//CA test
	 public String getCA(String time){
	  String CA = "//tr[td/span='"+time+"']//td[5]";
	  String CAValue = driver.findElement(By.xpath(CA)).getText();
	  return CAValue;
	 }
	 //AO test
	 public String getAO(String time){
	  String AO = "//tr[td/span='"+time+"']//td[6]";
	  String AOValue = driver.findElement(By.xpath(AO)).getText();
	  return AOValue;
	 }
	 //AB test
	 public String getAB(String time){
	  String AB = "//tr[td/span='"+time+"']//td[7]";
	  String ABValue = driver.findElement(By.xpath(AB)).getText();
	  return ABValue;
	 }
}
