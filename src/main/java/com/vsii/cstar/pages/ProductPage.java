package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
	// Textbox Search
	@FindBy(id = "ctl00_body_txtSearch")
	private WebElement txt_Search;

	// Button Search
	@FindBy(id = "ctl00_body_btnSearch")
	private WebElement btn_Search;

	// Button Next page
	@FindBy(xpath = "//input[contains(@src,'next.gif')]")
	private WebElement btn_NextPage;

	// Product name in detail page
	@FindBy(id="ctl00_plcMain_lblProductNameVal")
	private WebElement lbl_ProductName;

	// Product's status icon
	@FindBy(id = "ctl00_plcMain_imgActive")
	private WebElement icon_ProductStatus;
	
	//Call center's status
	@FindBy(id="ctl00_plcMain_imgSS2017")
	private WebElement icon_CCStatus;

	// Product's start effective date
	@FindBy(id = "ctl00_plcMain_lblES2017")
	private WebElement lbl_StartEffectiveDate;

	// Product's end effective date
	@FindBy(id = "ctl00_plcMain_lblEE2017")
	private WebElement lbl_EndEffectiveDate;

	// button Return to the list
	@FindBy(id = "ctl00_plcMain_btnRTList")
	WebElement btn_returnToList;

	
	
	public WebElement getIcon_CCStatus() {
		return icon_CCStatus;
	}

	public void setIcon_CCStatus(WebElement icon_CCStatus) {
		this.icon_CCStatus = icon_CCStatus;
	}

	public WebElement getLbl_ProductName() {
		return lbl_ProductName;
	}

	public void setLbl_ProductName(WebElement lbl_ProductName) {
		this.lbl_ProductName = lbl_ProductName;
	}

	public WebElement getBtn_NextPage() {
		return btn_NextPage;
	}

	public void setBtn_NextPage(WebElement btn_NextPage) {
		this.btn_NextPage = btn_NextPage;
	}

	public WebElement getBtn_returnToList() {
		return btn_returnToList;
	}

	public void setBtn_returnToList(WebElement btn_returnToList) {
		this.btn_returnToList = btn_returnToList;
	}

	public WebElement getLbl_StartEffectiveDate() {
		return lbl_StartEffectiveDate;
	}

	public void setLbl_StartEffectiveDate(WebElement lbl_StartEffectiveDate) {
		this.lbl_StartEffectiveDate = lbl_StartEffectiveDate;
	}

	public WebElement getLbl_EndEffectiveDate() {
		return lbl_EndEffectiveDate;
	}

	public void setLbl_EndEffectiveDate(WebElement lbl_EndEffectiveDate) {
		this.lbl_EndEffectiveDate = lbl_EndEffectiveDate;
	}

	public WebElement getIcon_ProductStatus() {
		return icon_ProductStatus;
	}

	public void setIcon_ProductStatus(WebElement icon_ProductStatus) {
		this.icon_ProductStatus = icon_ProductStatus;
	}

	public WebElement getTxt_Search() {
		return txt_Search;
	}

	public void setTxt_Search(WebElement txt_Search) {
		this.txt_Search = txt_Search;
	}

	public WebElement getBtn_Search() {
		return btn_Search;
	}

	public void setBtn_Search(WebElement btn_Search) {
		this.btn_Search = btn_Search;
	}

}
