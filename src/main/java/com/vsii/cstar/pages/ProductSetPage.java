package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSetPage {
	@FindBy(id = "ctl00_body_txtSearch")
	private WebElement txt_Search;

	@FindBy(id = "ctl00_body_btnSearch")
	private WebElement btn_Search;

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
