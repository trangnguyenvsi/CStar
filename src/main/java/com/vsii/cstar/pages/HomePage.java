package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
 //Define WebElements
	//User detail
	@FindBy(id="ctl00_login")
	private WebElement label_Account;
	
	//Menu Screening Config
	@FindBy(xpath="//a[contains(text(),'Screening Config')]")
	private WebElement menu_Screeningcfg;
	
	//Submenu Team Calendar & Grid
	@FindBy(xpath="//a[contains(text(),'Team Calendar and Grid')]")
	private WebElement submenu_Teamcalendar;
	
	//Menu Products & Pricing
	@FindBy(xpath="//a[contains(text(),'Products & Pricing')]")
	private WebElement menu_ProductPricing;

	//Submenu Product Set
	@FindBy(xpath="//a[contains(text(),'Product Set')]")
	private WebElement menu_ProductSet;
	
	

	public WebElement getMenu_ProductPricing() {
		return menu_ProductPricing;
	}

	public void setMenu_ProductPricing(WebElement menu_ProductPricing) {
		this.menu_ProductPricing = menu_ProductPricing;
	}

	public WebElement getMenu_ProductSet() {
		return menu_ProductSet;
	}

	public void setMenu_ProductSet(WebElement menu_ProductSet) {
		this.menu_ProductSet = menu_ProductSet;
	}

	public WebElement getLabel_Account() {
		return label_Account;
	}

	public void setLabel_Account(WebElement label_Account) {
		this.label_Account = label_Account;
	}

	public WebElement getMenu_Screeningcfg() {
		return menu_Screeningcfg;
	}

	public void setMenu_Screeningcfg(WebElement menu_Screeningcfg) {
		this.menu_Screeningcfg = menu_Screeningcfg;
	}

	public WebElement getSubmenu_Teamcalendar() {
		return submenu_Teamcalendar;
	}

	public void setSubmenu_Teamcalendar(WebElement submenu_Teamcalendar) {
		this.submenu_Teamcalendar = submenu_Teamcalendar;
	}
}
