package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteList {
 //Define web elements
	//Textbox Zipcode
	@FindBy(id="ctl00_plcMain_ctlZipCodeSearch_txtZip")
	private WebElement txt_Zip;
	
	//Button Verify Zip Code
	@FindBy(id="ctl00_plcMain_ctlZipCodeSearch_ibVerifyZip")
	private WebElement btn_VerifyZip;
	
	//Button Search
	@FindBy(id="ctl00_plcMain_btnEnter")
	private WebElement btn_Search;
	
	//Loading Image
	@FindBy(id="ctl00_imgLoading")
	private WebElement img_Loading;
	
	

	public WebElement getImg_Loading() {
		return img_Loading;
	}

	public void setImg_Loading(WebElement img_Loading) {
		this.img_Loading = img_Loading;
	}

	public WebElement getTxt_Zip() {
		return txt_Zip;
	}

	public void setTxt_Zip(WebElement txt_Zip) {
		this.txt_Zip = txt_Zip;
	}

	public WebElement getBtn_VerifyZip() {
		return btn_VerifyZip;
	}

	public void setBtn_VerifyZip(WebElement btn_VerifyZip) {
		this.btn_VerifyZip = btn_VerifyZip;
	}

	public WebElement getBtn_Search() {
		return btn_Search;
	}

	public void setBtn_Search(WebElement btn_Search) {
		this.btn_Search = btn_Search;
	}
}
