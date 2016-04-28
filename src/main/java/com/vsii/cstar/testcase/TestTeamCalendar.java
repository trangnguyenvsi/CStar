package com.vsii.cstar.testcase;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.vsii.cstar.pages.methods.LoginPageMethods;
import com.vsii.cstar.testdata.TestData;
import com.vsii.tsc.utility.DBConnection;
import com.vsii.tsc.utility.TestBase;

public class TestTeamCalendar {
	
	LoginPageMethods loginObj ;
	//@Test
	public void test01(){
		loginObj = new LoginPageMethods(TestBase.driver);
		//CommonMethod.checkLogin();
//		TestBase.driver.findElement(By.xpath("//*[@id='ctlLogin_tbUsername']")).sendKeys("nguyen.thi.thu.trang@vsi-international.com");
//		TestBase.driver.findElement(By.xpath("//*[@id='ctlLogin_txtPassword']")).sendKeys("Trangntt123@");
		loginObj.login("abc", "123");		
	}
	@Test(priority = 1, description = "takeappointment", dataProvider = "takeappointment", dataProviderClass = TestData.class)
	public void test02(String Screening_ID, String Product_Set_ID, String Price_List_ID
, String Appointment_Cell_GUID, String Appointment_Code, String Participants_GUID, String Amount) throws IOException, SQLException{
		
		String statusCode;
		String objectID = null;
		String newID = null;
		
		String sqlCommand_01 = "declare @p2 int set @p2=NULL declare @p3 int set @p3=NULL exec CC_Note_Group_Add @Created_By=3640,@StatusCode=@p2 output,@ObjectID=@p3 output select @p2 as StatusCode, @p3 as ObjectID";
		
		
		//set an appointment for the chosen participant
		ResultSet rs_Object = DBConnection.connectSQLServer(sqlCommand_01);
		/*next() returns true if next row is present otherwise it returns false. */
		while(rs_Object.next()){
		//printing the result
		System.out.println(rs_Object.getString("StatusCode"));
		System.out.println(rs_Object.getString("ObjectID"));
		objectID=rs_Object.getString("ObjectID");
		}
		
		String sqlCommand_02 = "DECLARE @NEWID uniqueidentifier = NEWID() "+
				"SELECT @NEWID as NEWID "+
				"declare @p29 int "+
				"set @p29=NULL "+
				"exec CC_Order_Add "+ 
				"@Order_Guid=@NEWID,"+
				"@Appointment_Cell_GUID="+"'"+Appointment_Cell_GUID+"',"+
				"@Order_Status_Type_ID=381,"+
				"@Participant_GUID="+"'"+Participants_GUID+"',"+
				"@Order_Group_GUID=NULL,"+
				"@Previous_Order_GUID=NULL,"+
				"@Amount="+"'"+Amount+"',"+
				"@Appointment_Code="+"N'"+Appointment_Code+"',"+
				"@Created_By=3640,"+
				"@DNIS_ID=17,"+
				"@From_FSA=NULL,"+
				"@Note_Group_ID="+"'"+objectID+"',"+
				"@Order_Type_ID=379,"+
				"@Order_Sub_Type_ID=NULL,"+
				"@Price_List_ID="+"'"+Price_List_ID+"',"+
				"@Product_Set_ID="+"'"+Product_Set_ID+"',"+
				"@Processed_Date=NULL,"+
				"@Script_ID=72,"+
				"@Source_Code_ID=NULL,"+
				"@Tax_Group_ID=NULL,"+
				"@Screening_ID="+"'"+Screening_ID+"',"+
				"@Comment=NULL,"+
				"@Ship_To_Address_ID=NULL,"+
				"@Fax_To_ID=NULL,"+
				"@Order_Reason_Type_ID=NULL,"+
				"@Ship_Method_Type_ID=598,"+
				"@Paperless_Status_Type_ID=NULL,"+
				"@Order_Origination_Type_ID=1695,"+
				"@StatusCode=@p29 output "+
				"select @p29";
		
		//take appointment
		ResultSet rs_NewID = DBConnection.connectSQLServer(sqlCommand_02);
		while(rs_NewID.next()){
			//printing the result
			System.out.println(rs_NewID.getString("NEWID"));
			newID=rs_NewID.getString("NEWID");
			}
		
		
		//to change the chosen appointment cell status to scheduled
		String sqlCommand_03 = "declare @p4 int "+
				"set @p4=NULL "+
				"declare @p5 int "+
				"set @p5=NULL "+
				"exec CC_Appointment_Cell_Update_Status "+ 
				"@Appointment_Cell_GUID="+"'"+Appointment_Cell_GUID+"',"+
				"@Modified_By=3640,"+
				"@Cell_Status_Type_Id=393,"+
				"@StatusCode=@p4 output,"+
				"@RowsAffected=@p5 output "+
				"select @p4, @p5";
		DBConnection.connectSQLServer(sqlCommand_03);
		System.out.println("change appointment cell status successfully");
		
		//Assign package to the order
		String sqlCommand_04 = "declare @p11 int "+
				"set @p11=NULL "+
				"declare @p12 int "+
				"set @p12=NULL "+
				"exec CC_Order_Package_Assign "+ 
				"@Adjustment_ID=NULL,"+
				"@Amount=244.00,"+
				"@DNIS_Code=N'AAA',"+
				"@Script_Used=NULL,"+
				"@Modified_By=3640,"+
				"@Order_GUID="+"'"+newID+"',"+
				"@Package_ID=521,"+
				"@Price_List_ID=404,"+
				"@Exception_Reason_Type_ID=NULL,"+
				"@Sale_Source_Type_ID=2017,"+
				"@StatusCode=@p11 output,"+
				"@RowsAffected=@p12 output "+
				"select @p11, @p12";

		DBConnection.connectSQLServer(sqlCommand_04);
		System.out.println("Assign package suscessfully");
		
	}
	
}
