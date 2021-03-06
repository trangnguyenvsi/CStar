package com.vsii.cstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
 //Define WebElements
	//User detail
	@FindBy(id="ctl00_login")
	private WebElement label_Account;
	
	//Menu Call center
	@FindBy(linkText="Call Center")
	private WebElement menu_CallCenter;
	
	//Submenu Participant Maintainance
	@FindBy(xpath="//a[contains(text(),'Outbound Only - Participant Maintenance')]")
	private WebElement submenu_ParticipantMaintenance;
	
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
	private WebElement submenu_ProductSet;
	
	//Submenu Product List
	@FindBy(xpath="//a[contains(text(),'Product List')]")
	private WebElement submenu_ProductList;
	
	//Submenu Package
	@FindBy(xpath="//a[contains(text(),'Package')]")
	WebElement submenu_Package;
	
	

	public WebElement getMenu_CallCenter() {
		return menu_CallCenter;
	}

	public void setMenu_CallCenter(WebElement menu_CallCenter) {
		this.menu_CallCenter = menu_CallCenter;
	}

	public WebElement getSubmenu_ParticipantMaintenance() {
		return submenu_ParticipantMaintenance;
	}

	public void setSubmenu_ParticipantMaintenance(WebElement submenu_ParticipantMaintenance) {
		this.submenu_ParticipantMaintenance = submenu_ParticipantMaintenance;
	}

	public WebElement getSubmenu_Package() {
		return submenu_Package;
	}

	public void setSubmenu_Package(WebElement submenu_Package) {
		this.submenu_Package = submenu_Package;
	}

	public WebElement getSubmenu_ProductList() {
		return submenu_ProductList;
	}

	public void setSubmenu_ProductList(WebElement submenu_ProductList) {
		this.submenu_ProductList = submenu_ProductList;
	}

	public WebElement getSubmenu_ProductSet() {
		return submenu_ProductSet;
	}

	public void setSubmenu_ProductSet(WebElement submenu_ProductSet) {
		this.submenu_ProductSet = submenu_ProductSet;
	}

	public WebElement getMenu_ProductPricing() {
		return menu_ProductPricing;
	}

	public void setMenu_ProductPricing(WebElement menu_ProductPricing) {
		this.menu_ProductPricing = menu_ProductPricing;
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
