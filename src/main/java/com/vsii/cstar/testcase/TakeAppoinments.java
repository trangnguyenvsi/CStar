package com.vsii.cstar.testcase;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vsii.cstar.common.methods.CommonMethod;
import com.vsii.cstar.pages.methods.AppointmentsSingleScreeningPageMethod;
import com.vsii.cstar.pages.methods.HomePageMethods;
import com.vsii.cstar.pages.methods.LoginPageMethods;
import com.vsii.cstar.pages.methods.ScreeningMaintainanceMethods;
import com.vsii.cstar.pages.methods.TeamCalendarMethods;
import com.vsii.cstar.testdata.TestData;
import com.vsii.tsc.model.Appointment;
import com.vsii.tsc.model.PPackage;
import com.vsii.tsc.model.Product;
import com.vsii.tsc.utility.CommonOperations;
import com.vsii.tsc.utility.DBConnection;
import com.vsii.tsc.utility.DateTime;
import com.vsii.tsc.utility.TestBase;

public class TakeAppoinments {

	LoginPageMethods objLoginPageMethod;
	HomePageMethods objHomepageMethod;
	TeamCalendarMethods objTeamCalendarMethod;
	CommonMethod objCommonMethod;
	ScreeningMaintainanceMethods objScreeningMaintainanceMethod;
	AppointmentsSingleScreeningPageMethod objAptSingleScreenMethod;
	public static ResultSet rs_Screening;
	public static String Teamcode = "CLV";
	public static String newID = null;
	public static String screeningID = "";
	public static String screeningCode, siteName, appointmentCode, appointmentSequence, priceListID, productSetID;
	public static Date appointmentTime;
	public static boolean check = false;
	public static String objectID = null;
	public static ArrayList<Appointment> lAp = new ArrayList<Appointment>();

	@BeforeClass
	public void start() throws IOException, SQLException {
		objLoginPageMethod = new LoginPageMethods(TestBase.driver);
		objHomepageMethod = new HomePageMethods(TestBase.driver);
		objTeamCalendarMethod = new TeamCalendarMethods(TestBase.driver);
		objScreeningMaintainanceMethod = new ScreeningMaintainanceMethods(TestBase.driver);
		objAptSingleScreenMethod = new AppointmentsSingleScreeningPageMethod(TestBase.driver);
		objLoginPageMethod.login("nguyen.thi.thu.trang@vsi-international.com", "Trangntt123@");
		System.out.println("Login successfully");
		// CommonMethod.checkLogin();
	}

	@Test(priority = 0, description = "Verify screening exists or not")
	public void TM04() throws IOException, SQLException {
		TestBase.methodName = "TM04";
		// get Screening for inputed date
		rs_Screening = CommonMethod.getScreeningCode(TestBase.screeningDate);
		/*
		 * next() returns true if next row is present otherwise it returns
		 * false.
		 */
		while (rs_Screening.next()) {
			if (rs_Screening.getString(3).equals(Teamcode)) {
				screeningID = rs_Screening.getString(1);
				System.out.println(screeningID);
				screeningCode = rs_Screening.getString(2);
				siteName = rs_Screening.getString(4);
				priceListID = rs_Screening.getString(8);
				productSetID = rs_Screening.getString(6);
				check = true;
				break;
			}
		}
		Assert.assertEquals(check, true);
		// Verify screening infor

		// verify product&pricing

		System.out.println("Screening exists");
	}

	@Test(priority = 1, description = "Verify screening has appointment")
	public void test02() throws IOException, SQLException, ParseException {
		System.out.println("Please wait...");
		//get list Appointment
		List<Appointment> ex_appointment = CommonMethod.getExistAppointment(screeningID);
		if(ex_appointment.isEmpty()==false){
			objHomepageMethod.mouseHoverScreeningConfig();
			objHomepageMethod.selectSubMenuTeamCalendar();
			objTeamCalendarMethod.selectMonth(CommonMethod.getMonthBaseOnInputDate(TestBase.screeningDate));
			objTeamCalendarMethod.selectTeam("CLV - Cleveland");
//			objTeamCalendarMethod.clickScreening(12);
			objScreeningMaintainanceMethod.clickAppointmentsLinkText();
			objAptSingleScreenMethod.selectProductView();
		for (Appointment item : ex_appointment) {
			System.out.println(item.getAppointmentTime() + ": ");
			// Get product to product list
			List<Product> product = item.getProduct().getProduct();
			// Verify Product
			for (Product pro : product) {
				System.out.println(pro.getProductName());
			}	
			System.out.println(item.getAppointmentTime() + " Verify product successfully");
		}
	}
	}

	@Test(priority = 2, description = "Take appointments for screening", dataProvider = "listappointment", dataProviderClass = TestData.class)
	public void test03(String Participants_GUID, String Amount, String Ex_AmtTotal) throws IOException, SQLException {
		TestBase.methodName = "TM01";
		String statusCode;
		// Take a list of Appointment Cell GUID. It means list of appointment
		// has not scheduled
		ResultSet rs_AppointmentCell = CommonMethod.getAppointmentCell(screeningID);
		// Generate appointment code
		while (rs_AppointmentCell.next()) {
			System.out.println(rs_AppointmentCell.getString(4));
			appointmentTime = rs_AppointmentCell.getTime(4);
			appointmentSequence = rs_AppointmentCell.getString(5);
			SimpleDateFormat sdfDate = new SimpleDateFormat("hhmm");
			appointmentCode = screeningCode + sdfDate.format(appointmentTime).trim();
			System.out.println(sdfDate.format(appointmentTime));
			switch (appointmentSequence.length()) {
			case 1:
				appointmentCode = appointmentCode + "00" + appointmentSequence;
				break;
			case 2:
				appointmentCode = appointmentCode + "0" + appointmentSequence;
				break;
			case 3:
				appointmentCode = appointmentCode + appointmentSequence;
				break;
			default:

				break;
			}
			System.out.println(appointmentCode);
			// Take appointment for each participant
			// Create a Note. The output will be required input for next query.
			// No need to care about this query
			ResultSet rs_Object = CommonMethod.getObject();
			while (rs_Object.next()) {
				objectID = rs_Object.getString("ObjectID");
			}
			// take appointment
			ResultSet rs_NewID = CommonMethod.takeAppointment(rs_AppointmentCell.getString(1), Participants_GUID,
					Amount, appointmentCode, objectID, priceListID, productSetID, screeningID);
			System.out.println("Take appoinment successfully");
			while (rs_NewID.next()) {
				// printing the result
				System.out.println(rs_NewID.getString("NEWID"));
				newID = rs_NewID.getString("NEWID");
			}
			// to change the chosen appointment cell status to scheduled
			CommonMethod.changeAppointmentStatus(rs_AppointmentCell.getString(1));
			System.out.println("change appointment cell status successfully");

			// Assign package to the order
			List<Product> productList = new ArrayList<Product>();
			productList = CommonMethod.assignPackageRandom(productSetID, priceListID, newID);
			System.out.println("Assign package suscessfully");
			PPackage pp = new PPackage();
			pp.setProduct(productList);
			Appointment ap = new Appointment();
			ap.setScreeningCode(screeningCode);
			ap.setScreeningDate(TestBase.screeningDate);
			SimpleDateFormat sdfDate1 = new SimpleDateFormat("h:mm a");
			System.out.println(sdfDate1.format(appointmentTime));
			ap.setAppointmentTime(sdfDate1.format(appointmentTime));
			ap.setSequence(appointmentSequence);
			ap.setProduct(pp);
			ap.setSiteName(siteName);
			lAp.add(ap);
			break;
		}
	}

	@Test(priority = 4, description = "Verify taken appointment")
	public void test04() throws ParseException {
		System.out.println("Verify appointment");
		// Steps to access Appointments Screen
		objHomepageMethod.mouseHoverScreeningConfig();
		objHomepageMethod.selectSubMenuTeamCalendar();
		objTeamCalendarMethod.selectMonth(CommonMethod.getMonthBaseOnInputDate(TestBase.screeningDate));
		objTeamCalendarMethod.selectTeam("CLV - Cleveland");
		objTeamCalendarMethod.selectScreeningByInputDate("4/5/2016");
		objScreeningMaintainanceMethod.clickAppointmentsLinkText();
		objAptSingleScreenMethod.selectProductView();
		for (Appointment item : lAp) {
			// Get product to product list
			List<Product> product = item.getProduct().getProduct();
			// Verify Product
			for (Product pro : product) {
				switch (pro.getProductName()) {
				case "CA":
					Assert.assertEquals(objAptSingleScreenMethod.getCA(item.getAppointmentTime()), "X");
					System.out.println("verify CA success");
					break;
				case "AO":
					Assert.assertEquals(objAptSingleScreenMethod.getAO(item.getAppointmentTime()), "X");
					break;
				case "AB":
					Assert.assertEquals(objAptSingleScreenMethod.getAB(item.getAppointmentTime()), "X");
					break;
				case "OS":
					Assert.assertEquals(objAptSingleScreenMethod.getOS(item.getAppointmentTime()), "X");
					break;
				case "LI":
					Assert.assertEquals(objAptSingleScreenMethod.getLI(item.getAppointmentTime()), "X");
					break;
				case "GL":
					Assert.assertEquals(objAptSingleScreenMethod.getGL(item.getAppointmentTime()), "X");
					break;
				case "AF":
					Assert.assertEquals(objAptSingleScreenMethod.getAF(item.getAppointmentTime()), "X");
					break;
				case "PX":
					Assert.assertEquals(objAptSingleScreenMethod.getPX(item.getAppointmentTime()), "X");
					break;
				case "TX":
					Assert.assertEquals(objAptSingleScreenMethod.getTX(item.getAppointmentTime()), "X");
					break;
				case "RX":
					Assert.assertEquals(objAptSingleScreenMethod.getRX(item.getAppointmentTime()), "X");
					break;
				case "AX":
					Assert.assertEquals(objAptSingleScreenMethod.getAX(item.getAppointmentTime()), "X");
					break;
				case "LX":
					Assert.assertEquals(objAptSingleScreenMethod.getLX(item.getAppointmentTime()), "X");
					break;
				case "GX":
					Assert.assertEquals(objAptSingleScreenMethod.getGX(item.getAppointmentTime()), "X");
					break;
				case "CO":
					Assert.assertEquals(objAptSingleScreenMethod.getCO(item.getAppointmentTime()), "X");
					break;
				case "SL":
					Assert.assertEquals(objAptSingleScreenMethod.getSL(item.getAppointmentTime()), "X");
					break;
				case "A2":
					Assert.assertEquals(objAptSingleScreenMethod.getA2(item.getAppointmentTime()), "X");
					break;
				case "SX":
					Assert.assertEquals(objAptSingleScreenMethod.getSX(item.getAppointmentTime()), "X");
					break;
				case "TP":
					Assert.assertEquals(objAptSingleScreenMethod.getTP(item.getAppointmentTime()), "X");
					break;
				case "PP":
					Assert.assertEquals(objAptSingleScreenMethod.getPP(item.getAppointmentTime()), "X");
					break;
				case "XF":
					Assert.assertEquals(objAptSingleScreenMethod.getXF(item.getAppointmentTime()), "X");
					break;
				case "XM":
					Assert.assertEquals(objAptSingleScreenMethod.getXM(item.getAppointmentTime()), "X");
					break;
				case "X1":
					Assert.assertEquals(objAptSingleScreenMethod.getX1(item.getAppointmentTime()), "X");
					break;
				case "KX":
					Assert.assertEquals(objAptSingleScreenMethod.getKX(item.getAppointmentTime()), "X");
					break;
				case "YX":
					Assert.assertEquals(objAptSingleScreenMethod.getYX(item.getAppointmentTime()), "X");
					break;
				case "PY":
					Assert.assertEquals(objAptSingleScreenMethod.getPY(item.getAppointmentTime()), "X");
					break;
				case "MT":
					Assert.assertEquals(objAptSingleScreenMethod.getMT(item.getAppointmentTime()), "X");
					break;
				case "LK":
					Assert.assertEquals(objAptSingleScreenMethod.getLK(item.getAppointmentTime()), "X");
					break;
				case "XC":
					Assert.assertEquals(objAptSingleScreenMethod.getXC(item.getAppointmentTime()), "X");
					break;
				case "DX":
					Assert.assertEquals(objAptSingleScreenMethod.getDX(item.getAppointmentTime()), "X");
					break;
				case "BH":
					Assert.assertEquals(objAptSingleScreenMethod.getBH(item.getAppointmentTime()), "X");
					break;
				case "KH":
					Assert.assertEquals(objAptSingleScreenMethod.getKH(item.getAppointmentTime()), "X");
					break;
				case "KA":
					Assert.assertEquals(objAptSingleScreenMethod.getKA(item.getAppointmentTime()), "X");
					break;
				case "FV":
					Assert.assertEquals(objAptSingleScreenMethod.getFV(item.getAppointmentTime()), "X");
					break;
				case "FQ":
					Assert.assertEquals(objAptSingleScreenMethod.getFQ(item.getAppointmentTime()), "X");
					break;
				default:
					break;
				}
			}
			System.out.println(item.getAppointmentCode() + " Verify product successfully");
		}
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws Exception {
		CommonOperations.getMethodTestResult(testResult);
		CommonOperations.takePicture();
	}

	@AfterClass
	public void end() throws InterruptedException {

	}
}
