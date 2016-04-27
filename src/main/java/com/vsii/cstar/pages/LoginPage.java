package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	/* Define web element*/
	//User name 
	@FindBy(xpath="//*[@id='ctlLogin_tbUsername']")
	private WebElement txt_Email;
	
	//Password
	@FindBy(xpath ="//*[@id='ctlLogin_txtPassword']")
	private WebElement txt_Password;	
		
	//Login button
	@FindBy(xpath="//*[@id='ctlLogin_btLogin']")
	private WebElement btn_Login;
	
	public WebElement getTxt_Email() {
		return txt_Email;
	}

	public void setTxt_Email(WebElement txt_Email) {
		this.txt_Email = txt_Email;
	}

	public WebElement getTxt_Password() {
		return txt_Password;
	}

	public void setTxt_Password(WebElement txt_Password) {
		this.txt_Password = txt_Password;
	}

	public WebElement getBtn_Login() {
		return btn_Login;
	}

	public void setBtn_Login(WebElement btn_Login) {
		this.btn_Login = btn_Login;
	}

	
	
	


}
