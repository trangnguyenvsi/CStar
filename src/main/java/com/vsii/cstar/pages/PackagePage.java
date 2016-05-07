package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PackagePage {
	//Textbox Search package
	@FindBy(id="ctl00_body_txtSearch")
	private WebElement txt_SearchPackage;
	
	//Button Search
	@FindBy(id="ctl00_body_btnSearch")
	private WebElement btn_Search;
	
	//Button Next page
	@FindBy(xpath="//input[contains(@alt,'Next') and contains(@src,'next.gif')]")
	private WebElement btn_Next;
	
	//Package name in detail page
	@FindBy(id="ctl00_plcMain_lblPackageNameVal")
	private WebElement lbl_PackageName;
	
	
	
	public WebElement getLbl_PackageName() {
		return lbl_PackageName;
	}

	public void setLbl_PackageName(WebElement lbl_PackageName) {
		this.lbl_PackageName = lbl_PackageName;
	}

	public WebElement getTxt_SearchPackage() {
		return txt_SearchPackage;
	}

	public void setTxt_SearchPackage(WebElement txt_SearchPackage) {
		this.txt_SearchPackage = txt_SearchPackage;
	}

	public WebElement getBtn_Search() {
		return btn_Search;
	}

	public void setBtn_Search(WebElement btn_Search) {
		this.btn_Search = btn_Search;
	}

	public WebElement getBtn_Next() {
		return btn_Next;
	}

	public void setBtn_Next(WebElement btn_Next) {
		this.btn_Next = btn_Next;
	}
	
	
}
