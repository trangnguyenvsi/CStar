package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppointmentsSingleScreeningPage {
	//Radio button Show Product
	@FindBy(id="ctl00_body_rblShowProductsOrPhone_0")
	WebElement radio_ShowProduct;
	
	//Radio button Show Phone Zip
	@FindBy(id="ctl00_body_rblShowProductsOrPhone_1")
	WebElement radio_ShowPhoneZip;

	
	
	public WebElement getRadio_ShowProduct() {
		return radio_ShowProduct;
	}

	public void setRadio_ShowProduct(WebElement radio_ShowProduct) {
		this.radio_ShowProduct = radio_ShowProduct;
	}

	public WebElement getRadio_ShowPhoneZip() {
		return radio_ShowPhoneZip;
	}

	public void setRadio_ShowPhoneZip(WebElement radio_ShowPhoneZip) {
		this.radio_ShowPhoneZip = radio_ShowPhoneZip;
	}
}
