package com.vsii.cstar.common.methods;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.naming.spi.DirStateFactory.Result;

import org.testng.Assert;

import com.vsii.cstar.pages.LoginPage;
import com.vsii.cstar.pages.methods.LoginPageMethods;
import com.vsii.tsc.model.Appointment;
import com.vsii.tsc.model.PPackage;
import com.vsii.tsc.model.Product;
import com.vsii.tsc.utility.DBConnection;
import com.vsii.tsc.utility.TestBase;

public class CommonMethod {
	//If logged in, don't need to login. If not, log into system
	public static void checkLogin(){
		String email;
		String pwd;
		LoginPage loginPageObj = new LoginPage();
		LoginPageMethods loginPageMethodObj = new LoginPageMethods(TestBase.driver);
//		email = TestBase.p.getProperty("email");
//		pwd = TestBase.p.getProperty("password");
		email = "nguyen.thi.thu.trang@vsi-international.com";
		pwd = "Trangntt123@";
		if(loginPageObj.getTxt_Email().isDisplayed()==true){
			loginPageMethodObj.login(email, pwd);	
		}	
	}
	public static ResultSet getScreeningCode(String date) throws IOException
	{
		String sqlGetScreening = "DECLARE @Screening_Date DATETIME ='"+ date+
				"' SELECT s.Screening_ID, s.Screening_Code , t.team_Code, i.Site_Name, a.address1 AS [Address1],s.Product_Set_ID ,ps.Product_Set_Name, s.Price_List_ID, pl.Price_List_Name"
				+" FROM SC_Screenings s with (nolock) join sc_sites i with (nolock) on s.Site_ID = i.Site_ID"
				+" join PL_Addresses_Sites a with (nolock) on i.Address_Group_ID = a.Address_Group_ID and a.[primary] = 1"
		        +" JOIN PL_Zips z with (nolock) ON a.Zip_ID = z.Zip_ID"
		        + " JOIN PL_Political_SubDivisions psd with (nolock) ON z.PSD_ID = psd.PSD_ID"
		        +" JOIN PL_Countries c with (nolock) ON psd.Country_ID = c.Country_ID"
				+" join PL_Teams t with (nolock) on t.Employee_Group_ID = s.Employee_Group_ID"
				+" JOIN SS_System_Types st6 with (nolock) ON t.team_Type_ID = st6.System_Type_ID"
		        +" JOIN SS_System_Types st8 with (nolock) ON s.Screening_Type_ID = st8.System_Type_ID"
		        +" JOIN SS_System_Types st10 with (nolock) ON s.Screening_Status_Type_ID = st10.System_Type_ID"
		        +" JOIN SC_Schedule_Templates sch with (nolock) ON s.Schedule_Template_ID = sch.Schedule_Template_ID"
		        +" JOIN PP_Product_Sets ps with (nolock) ON s.Product_Set_ID = ps.Product_Set_ID"
		        +" JOIN PP_Price_Lists pl with (nolock) ON s.Price_list_ID = pl.Price_list_ID"
				+" JOIN SS_System_Types st11 with (nolock) ON t.Team_Type_ID = st11.System_Type_ID"
		        +" JOIN SS_System_Types st9 with (nolock) ON s.Marketing_Plan_ID = st9.System_Type_ID"
				+" LEFT JOIN vw_Screening_Sponsors ss with (nolock) ON s.Screening_ID = ss.screening_id AND ss.Zip_Relation_Active = 1"
				+" LEFT JOIN SS_System_Types st7 with (nolock)	ON s.HIPAA_Form_Type_ID = st7.System_Type_ID"        
				+" where s.Screening_Status_Type_ID = 83  and s.Screening_Date = @Screening_Date";
				
				ResultSet rs_Screening = DBConnection.connectSQLServer(sqlGetScreening);
				return rs_Screening;
	}
	public static ResultSet getAppointmentCell(String screeningID) throws IOException
	{
		String sqlGetAppointmentCell = "DECLARE @Screening_ID int = "+Integer.valueOf(screeningID)
		+" SELECT TOP 1 Appointment_Cell_GUID, s.Screening_ID, Screening_Code, Appointment_Time, Sequence, System_Type, ac.Active, Member, Confirmed"
		+" FROM [dbo].[CC_Appointment_Cells] ac JOIN [dbo].[SC_Screenings] s ON ac.Screening_ID = s.Screening_ID JOIN [dbo].[SS_System_Types] st ON ac.Cell_Status_Type_ID = st.System_Type_ID"
		+" where s.screening_ID = @Screening_ID and System_Type = 'Open' and ac.Active = 1";
		System.out.println("Get appointment cell has not scheduled");
		ResultSet rs_AppointmentCell = DBConnection.connectSQLServer(sqlGetAppointmentCell);
		return rs_AppointmentCell;
	}
	// Create a Note. The output will be required input for next query. No need to care about this query
	public static ResultSet getObject() throws IOException
	{
		String sqlCommand_01 = "declare @p2 int set @p2=NULL declare @p3 int set @p3=NULL exec CC_Note_Group_Add @Created_By=3640,@StatusCode=@p2 output,@ObjectID=@p3 output select @p2 as StatusCode, @p3 as ObjectID";	
		ResultSet rs_Object = DBConnection.connectSQLServer(sqlCommand_01);		
		return rs_Object;
	}
	public static ResultSet takeAppointment(String appointmentCell, String participantGUID, String amount, String appointmentCode, String objectID, String priceListID, String productSetID, String screeningID ) throws IOException
	{
		String sqlCommand_02 = "DECLARE @NEWID uniqueidentifier = NEWID() " + "SELECT @NEWID as NEWID "
				+ "declare @p29 int " + "set @p29=NULL " + "exec CC_Order_Add " + "@Order_Guid=@NEWID,"
				+ "@Appointment_Cell_GUID=" + "'" + appointmentCell + "'," + "@Order_Status_Type_ID=381,"
				+ "@Participant_GUID=" + "'" + participantGUID + "'," + "@Order_Group_GUID=NULL,"
				+ "@Previous_Order_GUID=NULL," + "@Amount=" + "'" + amount + "'," + "@Appointment_Code=" + "N'"
				+ appointmentCode + "'," + "@Created_By=3640," + "@DNIS_ID=17," + "@From_FSA=NULL," + "@Note_Group_ID="
				+ "'" + objectID + "'," + "@Order_Type_ID=379," + "@Order_Sub_Type_ID=NULL," + "@Price_List_ID=" + "'"
				+ priceListID + "'," + "@Product_Set_ID=" + "'" + productSetID + "'," + "@Processed_Date=NULL,"
				+ "@Script_ID=72," + "@Source_Code_ID=NULL," + "@Tax_Group_ID=NULL," + "@Screening_ID=" + "'"
				+ screeningID + "'," + "@Comment=NULL," + "@Ship_To_Address_ID=NULL," + "@Fax_To_ID=NULL,"
				+ "@Order_Reason_Type_ID=NULL," + "@Ship_Method_Type_ID=598," + "@Paperless_Status_Type_ID=NULL,"
				+ "@Order_Origination_Type_ID=1695," + "@StatusCode=@p29 output " + "select @p29";
		ResultSet rs_NewID = DBConnection.connectSQLServer(sqlCommand_02);
		return rs_NewID;
	}
	// to change the chosen appointment cell status to scheduled
	public static void changeAppointmentStatus(String appointmentCell) throws IOException
	{
		String sqlCommand_03 = "declare @p4 int " + "set @p4=NULL " + "declare @p5 int " + "set @p5=NULL "
					+ "exec CC_Appointment_Cell_Update_Status " + "@Appointment_Cell_GUID=" + "'" + appointmentCell
					+ "'," + "@Modified_By=3640," + "@Cell_Status_Type_Id=393," + "@StatusCode=@p4 output,"
					+ "@RowsAffected=@p5 output " + "select @p4, @p5";
		DBConnection.connectSQLServer(sqlCommand_03);				
	}
	public static String getMonthBaseOnInputDate(String date) throws ParseException{
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		  //Convert string -> date
		  Date date2 = dateFormat.parse(date);
		  
		  //Get month in int
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date2);
		  int month = cal.get(Calendar.MONTH);
		  
		  //return month in a string text
		  return new DateFormatSymbols().getMonths()[month];
		 }
	/*
	 * This method takes radom package or product for participant
	 */
	public static List<Product> assignPackageRandom(String productSet, String priceListID, String appointmentID) throws IOException, SQLException
	{
		ArrayList<Product> productList = new ArrayList<Product>();
		String listProudct = "DECLARE @Product_Set_ID int ="+productSet
				+" select p.Product_ID, p.Product_Code from PP_Products p JOIN PP_Product_Set_Product_Xref psp"
				+" ON p.Product_ID = psp.Product_ID"
				+" WHERE psp.Product_Set_ID = @Product_Set_ID and p.active = 1 and psp.active = 1";
		ResultSet rs_listProduct = DBConnection.connectSQLServer(listProudct);	
		String listPackage = "DECLARE @Product_Set_ID int = "+productSet
				+" select p.Package_ID from PP_Packages p JOIN PP_Product_Set_Package_Xref psp"
				+" ON p.Package_ID = psp.Package_ID"
				+" WHERE psp.Product_Set_ID = @Product_Set_ID and p.active = 1 and psp.active = 1";
		ResultSet rs_listpackage = DBConnection.connectSQLServer(listPackage);
		
		List<ResultSet> rs = new ArrayList<ResultSet>();
		rs.add(rs_listProduct);
		rs.add(rs_listpackage);
		Random rand1 = new Random();
		int choice = rand1.nextInt(rs.size());
		if(choice == 1){
			List<String> product = new ArrayList<String>();
			while(rs_listProduct.next())
			{
				product.add(rs_listProduct.getString(1));
			}
			Random rand_product = new Random();
			int choiceproduct = rand_product.nextInt(product.size());
			String sqlCommand_03 = "declare @p10 int set @p10=NULL declare @p11 int set @p11=NULL exec CC_Order_Product_Assign" 
			+" @Amount=139.00, @DNIS_Code=N'AAA', @Script_Used=NULL, @Modified_By=3858, @Order_GUID=" + "'" + appointmentID + "', @Product_ID="
					+ "'" + product.get(choiceproduct) + "', @Sale_Source_Type_ID=2017, "
			+"@Price_List_ID=" + "'" + priceListID + "', @Quantity=1, @StatusCode=@p10 output, @RowsAffected=@p11 output select @p10, @p11";	
			ResultSet rs_Product = DBConnection.connectSQLServer(sqlCommand_03);
			//get product list
			
			while(rs_Product.next())
			{
				Product product1 = new Product();
				product1.setProductName(rs_Product.getString(1));
				productList.add(product1);
			}
			return productList;
		}
		else
		{
			List<String> pack = new ArrayList<String>();
			while(rs_listpackage.next()){
				pack.add(rs_listpackage.getString(1));
			}
			Random rand_package = new Random();
			int choicepack = rand_package.nextInt(pack.size());
			// Assign package to the order
			String sqlCommand_04 = "declare @p11 int " + "set @p11=NULL " + "declare @p12 int " + "set @p12=NULL "
					+ " exec CC_Order_Package_Assign " + "@Adjustment_ID=NULL," + "@Amount=244.00," + "@DNIS_Code=N'AAA',"
					+ " @Script_Used=NULL," + "@Modified_By=3640," + "@Order_GUID=" + "'" + appointmentID + "'," + "@Package_ID="
					+ "'" + pack.get(choicepack) + "'," + "@Price_List_ID=" + "'" + priceListID + "',"
					+ " @Exception_Reason_Type_ID=NULL," + "@Sale_Source_Type_ID=2017," + "@StatusCode=@p11 output,"
					+ " @RowsAffected=@p12 output " + "select @p11, @p12";
			DBConnection.connectSQLServer(sqlCommand_04);
			//get product list
			String sqlCommand_05 = " select Product_Code from dbo.PP_Products "
					+ "where product_id in (select Product_ID from dbo.PP_Package_Product_Xref where Package_ID = "
					+ pack.get(choicepack) + ")";

			ResultSet rs_ProductList = DBConnection.connectSQLServer(sqlCommand_05);
			while(rs_ProductList.next())
			{
				Product product = new Product();
				product.setProductName(rs_ProductList.getString(1));
				productList.add(product);
			}
			return productList;
		}

	}
	public static List<Appointment> getExistAppointment(String screeningID) throws IOException, SQLException
	{
		List<Appointment> appointment = new ArrayList<Appointment>();
		String sql_getExistAppointment  = "DECLARE @Screening_ID int = "+Integer.valueOf(screeningID)
		+" SELECT ac.Appointment_Cell_GUID, s.Screening_ID, Screening_Code, Appointment_Time, Sequence, o.Appointment_Code"
		+" FROM [dbo].[CC_Appointment_Cells] ac JOIN [dbo].[SC_Screenings] s ON ac.Screening_ID = s.Screening_ID JOIN [dbo].[SS_System_Types] st ON ac.Cell_Status_Type_ID = st.System_Type_ID"
		+" JOIN [dbo].[CC_Orders] o ON o.Appointment_Cell_GUID = ac.Appointment_Cell_GUID"
		+" where s.screening_ID = @Screening_ID and System_Type = 'Scheduled' and ac.Active = 1";
		ResultSet rs_existAppointment =DBConnection.connectSQLServer(sql_getExistAppointment);
		while(rs_existAppointment.next())
		{
			Appointment ap = new Appointment();
			Date appointmentTime = rs_existAppointment.getTime(4);

			SimpleDateFormat sdfDate1 = new SimpleDateFormat("h:mm a");
			System.out.println(sdfDate1.format(appointmentTime));
			ap.setAppointmentTime(sdfDate1.format(appointmentTime));
			
			ap.setScreeningCode(rs_existAppointment.getString(3));
			ap.setSequence(rs_existAppointment.getString(5));
			ap.setScreeningDate(TestBase.screeningDate);
			ap.setAppointmentCode(rs_existAppointment.getString(6));
			
			//get product
			List<Product> product = new ArrayList<Product>();
			String sql_getProductbyAppointmentCode  = "DECLARE @Appointment_Code nvarchar(30) = '"+ap.getAppointmentCode()+"'"
					+" SELECT p.Product_ID, p.Product_Code  FROM CC_Orders o JOIN CC_Order_Products_Xref opX ON o.Order_GUID = opX.Order_GUID"
					+" JOIN PP_Products p ON opX.Product_ID = p.Product_ID WHERE Appointment_Code = @Appointment_Code";
					ResultSet rs_getProductbyProduct =DBConnection.connectSQLServer(sql_getProductbyAppointmentCode);
		
					while(rs_getProductbyProduct.next())
					{
						Product pro = new Product();
						pro.setProductName(rs_getProductbyProduct.getString(2));
						product.add(pro);
					}
			String sql_getPackagebyAppointmentCode  = "DECLARE @Appointment_Code nvarchar(30) =  '"+ap.getAppointmentCode()+"'"
							+" SELECT opkgX.Package_ID, p.Product_Code FROM CC_Orders o "
					+" JOIN CC_Order_Packages_Xref opkgX ON o.Order_GUID = opkgX.Order_GUID"
							+" JOIN PP_Package_Product_Xref pkgpX ON opkgX.Package_ID = pkgpX.Package_ID"
					+" JOIN PP_Products p ON p.Product_ID = pkgpx.Product_ID"
					        +" WHERE Appointment_Code = @Appointment_Code";
			ResultSet rs_getProductByPackage =DBConnection.connectSQLServer(sql_getPackagebyAppointmentCode);
			while(rs_getProductByPackage.next()){
					Product pro = new Product();
					pro.setProductName(rs_getProductByPackage.getString(2));
					product.add(pro);
				}
			PPackage pac = new PPackage();
			pac.setProduct(product);
			ap.setProduct(pac);	
			appointment.add(ap);
			System.out.println(ap.getAppointmentCode());
		}
		return appointment;
	}
//public static boolean verifyAppointment(List<Appointment> listApp)
//{
//	for (Appointment item : listApp) {
//		// Get product to product list
//		List<Product> product = item.getProduct().getProduct();
//		// Verify Product
//		for (Product pro : product) {
//			switch (pro.getProductName()) {
//			case "CA":
//				Assert.assertEquals(objAptSingleScreenMethod.getCA(item.getAppointmentTime()), "X");
//				System.out.println("verify CA success");
//				break;
//			case "AO":
//				Assert.assertEquals(objAptSingleScreenMethod.getAO(item.getAppointmentTime()), "X");
//				break;
//			case "AB":
//				Assert.assertEquals(objAptSingleScreenMethod.getAB(item.getAppointmentTime()), "X");
//				break;
//			case "OS":
//				Assert.assertEquals(objAptSingleScreenMethod.getOS(item.getAppointmentTime()), "X");
//				break;
//			case "LI":
//				Assert.assertEquals(objAptSingleScreenMethod.getLI(item.getAppointmentTime()), "X");
//				break;
//			case "GL":
//				Assert.assertEquals(objAptSingleScreenMethod.getGL(item.getAppointmentTime()), "X");
//				break;
//			case "AF":
//				Assert.assertEquals(objAptSingleScreenMethod.getAF(item.getAppointmentTime()), "X");
//				break;
//			case "PX":
//				Assert.assertEquals(objAptSingleScreenMethod.getPX(item.getAppointmentTime()), "X");
//				break;
//			case "TX":
//				Assert.assertEquals(objAptSingleScreenMethod.getTX(item.getAppointmentTime()), "X");
//				break;
//			case "RX":
//				Assert.assertEquals(objAptSingleScreenMethod.getRX(item.getAppointmentTime()), "X");
//				break;
//			case "AX":
//				Assert.assertEquals(objAptSingleScreenMethod.getAX(item.getAppointmentTime()), "X");
//				break;
//			case "LX":
//				Assert.assertEquals(objAptSingleScreenMethod.getLX(item.getAppointmentTime()), "X");
//				break;
//			case "GX":
//				Assert.assertEquals(objAptSingleScreenMethod.getGX(item.getAppointmentTime()), "X");
//				break;
//			case "CO":
//				Assert.assertEquals(objAptSingleScreenMethod.getCO(item.getAppointmentTime()), "X");
//				break;
//			case "SL":
//				Assert.assertEquals(objAptSingleScreenMethod.getSL(item.getAppointmentTime()), "X");
//				break;
//			case "A2":
//				Assert.assertEquals(objAptSingleScreenMethod.getA2(item.getAppointmentTime()), "X");
//				break;
//			case "SX":
//				Assert.assertEquals(objAptSingleScreenMethod.getSX(item.getAppointmentTime()), "X");
//				break;
//			case "TP":
//				Assert.assertEquals(objAptSingleScreenMethod.getTP(item.getAppointmentTime()), "X");
//				break;
//			case "PP":
//				Assert.assertEquals(objAptSingleScreenMethod.getPP(item.getAppointmentTime()), "X");
//				break;
//			case "XF":
//				Assert.assertEquals(objAptSingleScreenMethod.getXF(item.getAppointmentTime()), "X");
//				break;
//			case "XM":
//				Assert.assertEquals(objAptSingleScreenMethod.getXM(item.getAppointmentTime()), "X");
//				break;
//			case "X1":
//				Assert.assertEquals(objAptSingleScreenMethod.getX1(item.getAppointmentTime()), "X");
//				break;
//			case "KX":
//				Assert.assertEquals(objAptSingleScreenMethod.getKX(item.getAppointmentTime()), "X");
//				break;
//			case "YX":
//				Assert.assertEquals(objAptSingleScreenMethod.getYX(item.getAppointmentTime()), "X");
//				break;
//			case "PY":
//				Assert.assertEquals(objAptSingleScreenMethod.getPY(item.getAppointmentTime()), "X");
//				break;
//			case "MT":
//				Assert.assertEquals(objAptSingleScreenMethod.getMT(item.getAppointmentTime()), "X");
//				break;
//			case "LK":
//				Assert.assertEquals(objAptSingleScreenMethod.getLK(item.getAppointmentTime()), "X");
//				break;
//			case "XC":
//				Assert.assertEquals(objAptSingleScreenMethod.getXC(item.getAppointmentTime()), "X");
//				break;
//			case "DX":
//				Assert.assertEquals(objAptSingleScreenMethod.getDX(item.getAppointmentTime()), "X");
//				break;
//			case "BH":
//				Assert.assertEquals(objAptSingleScreenMethod.getBH(item.getAppointmentTime()), "X");
//				break;
//			case "KH":
//				Assert.assertEquals(objAptSingleScreenMethod.getKH(item.getAppointmentTime()), "X");
//				break;
//			case "KA":
//				Assert.assertEquals(objAptSingleScreenMethod.getKA(item.getAppointmentTime()), "X");
//				break;
//			case "FV":
//				Assert.assertEquals(objAptSingleScreenMethod.getFV(item.getAppointmentTime()), "X");
//				break;
//			case "FQ":
//				Assert.assertEquals(objAptSingleScreenMethod.getFQ(item.getAppointmentTime()), "X");
//				break;
//			default:
//				break;
//			}
//		}
//		System.out.println(item.getAppointmentCode() + " Verify product successfully");
//	}
//	return true;
//}
	public static ResultSet getPackagebyAppointmentCode(String appointmentCode) throws IOException{
		String sql_getPackagebyAppointmentCode  = "DECLARE @Appointment_Code nvarchar(30) =  '"+appointmentCode+"'"
		+" SELECT opkgX.Package_ID FROM CC_Orders o JOIN CC_Order_Packages_Xref opkgX ON o.Order_GUID = opkgX.Order_GUID"
        +" WHERE Appointment_Code = @Appointment_Code";
		ResultSet rs_getPProduct =DBConnection.connectSQLServer(sql_getPackagebyAppointmentCode);
		return rs_getPProduct;
	}
	public static ResultSet getProductByPackage(String pack) throws IOException
	{
		String sqlCommand_05 = " select Product_Code from dbo.PP_Products "
				+ "where product_id in (select Product_ID from dbo.PP_Package_Product_Xref where Package_ID = "
				+ pack + ")";

		ResultSet rs_ProductList = DBConnection.connectSQLServer(sqlCommand_05);
		return rs_ProductList;
	}
	public static boolean isCurrentDate(String Date) throws ParseException
	{	  
		boolean isCurrent = true;
		  //Convert is to correct format
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		  Date selectDatetmp = dateFormat.parse(Date);
		  String selectDate1 = new SimpleDateFormat("M/d/yyyy").format(selectDatetmp);
		  Date selectDate = new SimpleDateFormat("M/d/yyyy").parse(selectDate1);
		  
		  //Define today date  
		  SimpleDateFormat dateFormat1 = new SimpleDateFormat("M/d/yyyy");
		  Date date = new Date();
		  String todayDatetmp = dateFormat1.format(date);
		  Date todayDate = dateFormat1.parse(todayDatetmp);
		    
		  //Compare screeningDate and todayDate  
		  if(selectDate.before(todayDate)){
			   isCurrent = true;
		  }
	
		  else 
		  {

		   isCurrent = false;
		  }
		  return isCurrent;
}
}

