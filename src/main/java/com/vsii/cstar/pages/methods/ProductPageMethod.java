/**
 * @author thanhvc
 * @Note: This method used to both Product List and Product detail screen
 */
package com.vsii.cstar.pages.methods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.vsii.cstar.pages.ProductPage;

public class ProductPageMethod {
	WebDriver driver;
	public ProductPage objProductPage = new ProductPage();

	public ProductPageMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objProductPage);
	}

	// Seach Product by name
	public void searchProduct(String productName) {
		objProductPage.getTxt_Search().sendKeys(productName);
		objProductPage.getBtn_Search().click();
	}

	// Next page
	public void clickNextPage() {
		objProductPage.getBtn_NextPage().click();
	}

	// Select product by name
	public void selectProductByName(String productName) {
		String xpath_Product = "//a[contains(text(),'" + productName + "')]";
		driver.findElement(By.xpath(xpath_Product)).click();
	}

	// Select product by its code
	public void selectProductByCode(String productCode) throws InterruptedException {
		int numOfItems = driver.findElements(By.xpath("//table[@id='ctl00_body_grdProduct']/tbody/tr")).size() - 1;
		int i = 2;
		if (numOfItems > 15) {
			numOfItems = 15;
		}
		System.out.println("Number of record:  " + numOfItems);

		for (i = 2; i <= numOfItems + 1; i++) {
			String xpath_codeCol = "//table[@id='ctl00_body_grdProduct']/tbody/tr[" + i + "]/td[2]";
			String xpath_productNameCol = "//table[@id='ctl00_body_grdProduct']/tbody/tr[" + i + "]/td[1]";
			String code = driver.findElement(By.xpath(xpath_codeCol)).getText();
			// System.out.println("Code find in column is: "+ code);
			// System.out.println("Product code is: "+productCode);
			// System.out.println("Xpath product nam is:
			// "+xpath_productNameCol);
			if (code.equals(productCode)) {
				// Define new xpath to able to click to hyperlink Product Name
				String xpath_lnkProductName = "//table[@id='ctl00_body_grdProduct']/tbody/tr[" + i + "]/td/a";
				// Click to hyperlink
				driver.findElement(By.xpath(xpath_lnkProductName)).click();
				break;
			}

			if (i == numOfItems + 1) {
				this.clickNextPage();
				numOfItems = driver.findElements(By.xpath("//table[@id='ctl00_body_grdProduct']/tbody/tr")).size() - 1;
				i = 1;
				if (numOfItems > 15) {
					numOfItems = 15;
				}
				// System.out.println("New number of record: "+numOfItems);
				// System.out.println("New i: "+i);
			}
		}
	}

	// Find out product is actived or not
	/**
	 * @author thanhvc
	 * @NOTE: This method need to input a correct domain to value in if
	 *        statement to compare
	 */
	public boolean isProductActived() {
		String srcAtb = objProductPage.getIcon_ProductStatus().getAttribute("src");
		// System.out.println(srcAtb);

		String srcAtbCC = objProductPage.getIcon_CCStatus().getAttribute("src");
		// System.out.println(srcAtbCC);

		boolean isActive;
		if (srcAtb.equals("http://172.17.60.220:888/images/Check.GIF")
				&& srcAtbCC.equals("http://172.17.60.220:888/images/Check.GIF")) {
			isActive = true;
			System.out.println("Product actived");
		} else {
			isActive = false;
			System.out.println("Product inactived");
		}

		return isActive;
	}

	// Get product's name in detail page
	public String getProductName() {
		String productName = objProductPage.getLbl_ProductName().getText();
		return productName;
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
		// System.out.println(url2[1]);
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
		String xpath_BtnTeam = "//a[contains(@href,'MaintainProductTeam.aspx?ProductTeamId=" + productId
				+ "') and contains(@id,'hlEditTeam')]";
		;

		driver.findElement(By.xpath(xpath_BtnTeam)).click();
		;
	}

	// Verify Product belong to the team or not
	public boolean isProductBelongToTeam(String team, int productId) {
		boolean isBelongToTeam;
		String xpath_teamName = "//span[contains(text(),'" + team + "')]";
		String team_colId = driver.findElement(By.xpath(xpath_teamName)).getAttribute("id");
		String constId = team_colId.replace("_lblTeamName", "");
		String chkId = constId + "_chkActive";
		// System.out.println(chkId);
		String chkStatus = driver.findElement(By.id(chkId)).getAttribute("checked");
		// System.out.println(chkStatus);
		if (chkStatus.equals("true")) {
			isBelongToTeam = true;

		} else {

			isBelongToTeam = false;
		}
		return isBelongToTeam;

	}
}
