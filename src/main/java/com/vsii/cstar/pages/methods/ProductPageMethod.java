/**
 * @author thanhvc
 * @Note: This method used to both Product List and Product detail screen
 */
package com.vsii.cstar.pages.methods;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor.Uri;
import com.vsii.cstar.pages.ProductPage;

public class ProductPageMethod {
	WebDriver driver;
	public ProductPage objProductPage = new ProductPage();

	public ProductPageMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objProductPage);
	}

	public void searchProduct(String productName) {
		objProductPage.getTxt_Search().sendKeys(productName);
		objProductPage.getBtn_Search().click();
	}

	public void selectProductByName(String productName) {
		String xpath_Product = "//a[contains(text(),'" + productName + "')]";
		driver.findElement(By.xpath(xpath_Product)).click();
	}

	// Find out product is actived or not
	public boolean isProductActived() {
		String srcAtb = objProductPage.getIcon_ProductStatus().getAttribute("src");
		boolean isActive;
		if (srcAtb.equalsIgnoreCase("../images/Check.GIF")) {
			isActive = true;
		} else {
			isActive = false;
		}

		return isActive;
	}

	// Get Product's Start Effective Date
	public Date getProductStartEffectiveDate() throws ParseException {
		String start_Eff1 = objProductPage.getLbl_StartEffectiveDate().getText();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date start_Eff2 = format.parse(start_Eff1);
		return start_Eff2;
	}

	// Get Product's End Effective Date
	public Date getProductEndEffectiveDate() throws ParseException {
		String end_Eff1 = objProductPage.getLbl_EndEffectiveDate().getText();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date end_Eff2 = format.parse(end_Eff1);
		return end_Eff2;
	}

	// Verify Screening Date is in Effective Date or not
	public boolean isScreeningDateInProductEffectivedDate(String screeningDate) throws ParseException {
		Date start_EffDate = this.getProductStartEffectiveDate();
		Date end_EffDate = this.getProductEndEffectiveDate();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date chkDate = format.parse(screeningDate);
		return chkDate.after(start_EffDate) && chkDate.before(end_EffDate);
	}

	// Get Product ID from Product's Detail page
	public int getProductID() {
		String url1 = driver.getCurrentUrl();
		String[] url2 = url1.split("productID=");
		String[] url3 = url2[1].split("&");
		String url4 = url3[0];
		int productId = Integer.parseInt(url4);
		System.out.println(productId);
		return productId;
	}

	// Click back to return to Product list
	public void returnToList() {
		objProductPage.getBtn_returnToList().click();
	}

	// Click to Team from Product List screen
	/**
	 * @NOTE: only use this method after you use getProductID method
	 */
	public void clicktoTeam(int productId) {
		String xpath_BtnTeam = "//a[@href='MaintainProductTeam.aspx?ProductTeamId=" + productId + "']";
		driver.findElement(By.xpath(xpath_BtnTeam)).click();
	}

	// Verify Product belong to the team or not
	public void isProductBelongToTeam(String team, int productId) {
		/**
		 * TODO: Find checked or not by team name here
		 */
	}
}
