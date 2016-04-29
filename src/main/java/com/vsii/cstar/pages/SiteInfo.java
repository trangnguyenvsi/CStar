package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteInfo {
	@FindBy(id = "ctl00_body_btnNext")
	private WebElement btn_Next;

	public WebElement getBtn_Next() {
		return btn_Next;
	}

	public void setBtn_Next(WebElement btn_Next) {
		this.btn_Next = btn_Next;
	}
}
