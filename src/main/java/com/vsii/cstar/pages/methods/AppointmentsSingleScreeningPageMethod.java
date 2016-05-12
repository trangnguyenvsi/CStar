package com.vsii.cstar.pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.vsii.cstar.pages.AppointmentsSingleScreeningPage;

public class AppointmentsSingleScreeningPageMethod {
	WebDriver driver;
	public AppointmentsSingleScreeningPage objAppoinmentSingleScreen = new AppointmentsSingleScreeningPage();

	public AppointmentsSingleScreeningPageMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, objAppoinmentSingleScreen);
	}

	// Select Products & Pricing view
	public void selectProductView() {
		objAppoinmentSingleScreen.getRadio_ShowProduct().click();
	}

	// Select Phone, Zip view
	public void selectPhoneZipView() {
		objAppoinmentSingleScreen.getRadio_ShowPhoneZip().click();
	}

	// Get Span Id on Phone Zip View
	public String getSpanIdByDateId(String time) {
		// Extract DateId
		String xpathScheduleTime = "//span[text()='" + time + "']";
		String dateId = driver.findElement(By.xpath(xpathScheduleTime)).getAttribute("id");

		// Extract cellId
		String constId = dateId.replace("_lblDate", "");
		return constId;
	}

	// Get participant Name on Phone Zip View
	public String getParticipantName(String time) {
		String nameid = this.getSpanIdByDateId(time) + "_lblName";
		String participantName = driver.findElement(By.id(nameid)).getText();
		return participantName;
	}

	// Get participant Phone, Zip on Phone Zip View
	public String getParticipantPhoneZip(String time) {
		String phonezipId = this.getSpanIdByDateId(time) + "_lblPhoneZip";
		String phoneZip = driver.findElement(By.id(phonezipId)).getText();
		return phoneZip;
	}

	// Get Ammount on Phone Zip View
	public String getParticipantAmount(String time) {
		String amtId = this.getSpanIdByDateId(time) + "_lblAmount";
		String amount = driver.findElement(By.id(amtId)).getText();
		return amount;
	}

	// Get Amount Due on Phone Zip View
	public String getParticipantAmountDue(String time) {
		String amtDueId = this.getSpanIdByDateId(time) + "_lblAmount";
		String amountDue = driver.findElement(By.id(amtDueId)).getText();
		return amountDue;
	}

	public void getAllProductCode() {
		int colNo = driver.findElements(By.xpath("//th[@class='GridSingleChar' and @scope='col']")).size();
		for (int i = 0; i <= (colNo - 9); i++) {

		}
		// System.out.println(colNo);

	}

	// CA test
	public String getCA(String time) {
		String CA = "//tr[td/span='" + time + "']//td[5]";
		String CAValue = driver.findElement(By.xpath(CA)).getText();
		return CAValue;
	}

	// AO test
	public String getAO(String time) {
		String AO = "//tr[td/span='" + time + "']//td[6]";
		String AOValue = driver.findElement(By.xpath(AO)).getText();
		return AOValue;
	}

	// AB test
	public String getAB(String time) {
		String AB = "//tr[td/span='" + time + "']//td[7]";
		String ABValue = driver.findElement(By.xpath(AB)).getText();
		return ABValue;
	}

	// OS test
	public String getOS(String time) {
		String OS = "//tr[td/span='" + time + "']//td[8]";
		String OSValue = driver.findElement(By.xpath(OS)).getText();
		return OSValue;
	}

	// LI test
	public String getLI(String time) {
		String LI = "//tr[td/span='" + time + "']//td[9]";
		String LIValue = driver.findElement(By.xpath(LI)).getText();
		return LIValue;
	}

	// GL test
	public String getGL(String time) {
		String GL = "//tr[td/span='" + time + "']//td[10]";
		String GLValue = driver.findElement(By.xpath(GL)).getText();
		return GLValue;
	}

	// AF test
	public String getAF(String time) {
		String AF = "//tr[td/span='" + time + "']//td[11]";
		String AFValue = driver.findElement(By.xpath(AF)).getText();
		return AFValue;
	}

	// PX test
	public String getPX(String time) {
		String PX = "//tr[td/span='" + time + "']//td[12]";
		String PXValue = driver.findElement(By.xpath(PX)).getText();
		return PXValue;
	}

	// TX test
	public String getTX(String time) {
		String TX = "//tr[td/span='" + time + "']//td[13]";
		String TXValue = driver.findElement(By.xpath(TX)).getText();
		return TXValue;
	}

	// RX test
	public String getRX(String time) {
		String RX = "//tr[td/span='" + time + "']//td[14]";
		String RXValue = driver.findElement(By.xpath(RX)).getText();
		return RXValue;
	}

	// AX test
	public String getAX(String time) {
		String AX = "//tr[td/span='" + time + "']//td[15]";
		String AXValue = driver.findElement(By.xpath(AX)).getText();
		return AXValue;
	}

	// LX test
	public String getLX(String time) {
		String LX = "//tr[td/span='" + time + "']//td[16]";
		String LXValue = driver.findElement(By.xpath(LX)).getText();
		return LXValue;
	}

	// GX test
	public String getGX(String time) {
		String GX = "//tr[td/span='" + time + "']//td[17]";
		String GXValue = driver.findElement(By.xpath(GX)).getText();
		return GXValue;
	}

	// CO test
	public String getCO(String time) {
		String CO = "//tr[td/span='" + time + "']//td[18]";
		String COValue = driver.findElement(By.xpath(CO)).getText();
		return COValue;
	}

	// SL test
	public String getSL(String time) {
		String SL = "//tr[td/span='" + time + "']//td[19]";
		String SLValue = driver.findElement(By.xpath(SL)).getText();
		return SLValue;
	}

	// A2 test
	public String getA2(String time) {
		String A2 = "//tr[td/span='" + time + "']//td[20]";
		String A2Value = driver.findElement(By.xpath(A2)).getText();
		return A2Value;
	}

	// SX test
	public String getSX(String time) {
		String SX = "//tr[td/span='" + time + "']//td[21]";
		String SXValue = driver.findElement(By.xpath(SX)).getText();
		return SXValue;
	}

	// TP test
	public String getTP(String time) {
		String TP = "//tr[td/span='" + time + "']//td[22]";
		String TPValue = driver.findElement(By.xpath(TP)).getText();
		return TPValue;
	}

	// PP test
	public String getPP(String time) {
		String PP = "//tr[td/span='" + time + "']//td[23]";
		String PPValue = driver.findElement(By.xpath(PP)).getText();
		return PPValue;
	}

	// XF test
	public String getXF(String time) {
		String XF = "//tr[td/span='" + time + "']//td[24]";
		String XFValue = driver.findElement(By.xpath(XF)).getText();
		return XFValue;
	}

	// XM test
	public String getXM(String time) {
		String XM = "//tr[td/span='" + time + "']//td[25]";
		String XMValue = driver.findElement(By.xpath(XM)).getText();
		return XMValue;
	}

	// X1 test
	public String getX1(String time) {
		String X1 = "//tr[td/span='" + time + "']//td[26]";
		String X1Value = driver.findElement(By.xpath(X1)).getText();
		return X1Value;
	}

	// KX test
	public String getKX(String time) {
		String KX = "//tr[td/span='" + time + "']//td[27]";
		String KXValue = driver.findElement(By.xpath(KX)).getText();
		return KXValue;
	}

	// YX test
	public String getYX(String time) {
		String YX = "//tr[td/span='" + time + "']//td[28]";
		String YXValue = driver.findElement(By.xpath(YX)).getText();
		return YXValue;
	}

	// PY test
	public String getPY(String time) {
		String PY = "//tr[td/span='" + time + "']//td[29]";
		String PYValue = driver.findElement(By.xpath(PY)).getText();
		return PYValue;
	}

	// MT test
	public String getMT(String time) {
		String MT = "//tr[td/span='" + time + "']//td[30]";
		String MTValue = driver.findElement(By.xpath(MT)).getText();
		return MTValue;
	}

	// LK test
	public String getLK(String time) {
		String LK = "//tr[td/span='" + time + "']//td[31]";
		String LKValue = driver.findElement(By.xpath(LK)).getText();
		return LKValue;
	}

	// XC test
	public String getXC(String time) {
		String XC = "//tr[td/span='" + time + "']//td[32]";
		String XCValue = driver.findElement(By.xpath(XC)).getText();
		return XCValue;
	}

	// DX test
	public String getDX(String time) {
		String DX = "//tr[td/span='" + time + "']//td[33]";
		String DXValue = driver.findElement(By.xpath(DX)).getText();
		return DXValue;
	}

	// BH test
	public String getBH(String time) {
		String BH = "//tr[td/span='" + time + "']//td[34]";
		String BHValue = driver.findElement(By.xpath(BH)).getText();
		return BHValue;
	}

	// KH test
	public String getKH(String time) {
		String KH = "//tr[td/span='" + time + "']//td[35]";
		String KHValue = driver.findElement(By.xpath(KH)).getText();
		return KHValue;
	}

	// KA test
	public String getKA(String time) {
		String KA = "//tr[td/span='" + time + "']//td[36]";
		String KAValue = driver.findElement(By.xpath(KA)).getText();
		return KAValue;
	}

	// FV test
	public String getFV(String time) {
		String FV = "//tr[td/span='" + time + "']//td[37]";
		String FVValue = driver.findElement(By.xpath(FV)).getText();
		return FVValue;
	}
	
	//FQ test
		 public String getFQ(String time){
		  String FQ = "//tr[td/span='"+time+"']//td[38]";
		  String FQValue = driver.findElement(By.xpath(FQ)).getText();
		  return FQValue;
		 }
}
