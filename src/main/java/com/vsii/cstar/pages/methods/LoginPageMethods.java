package com.vsii.cstar.pages.methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.vsii.cstar.pages.LoginPage;

public class LoginPageMethods {
	WebDriver driver;
	public LoginPage objLoginPage = new LoginPage();
	
	public LoginPageMethods(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,objLoginPage );
	}
	
	public void login(String email, String pwd){
		objLoginPage.getTxt_Email().sendKeys(email);
		objLoginPage.getTxt_Password().sendKeys(pwd);
		objLoginPage.getBtn_Login().click();
		
	}
}
