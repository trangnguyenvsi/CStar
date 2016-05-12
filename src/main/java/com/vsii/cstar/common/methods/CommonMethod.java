package com.vsii.cstar.common.methods;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.vsii.cstar.pages.LoginPage;
import com.vsii.cstar.pages.methods.LoginPageMethods;
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
				"' SELECT s.Screening_ID as ScreeningID, s.Screening_Code as ScreeningCode, t.team_Code as TeamCode, i.Site_Name as SiteName, a.address1 AS [Address1]"
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
	
	public String getMonthBaseOnInputDate(String date) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		//Convert string -> date
		Date date2 = dateFormat.parse(date);
		
		//Get month in int
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);
		int month = cal.get(Calendar.MONTH);
		
		//return month in a string text
		return new DateFormatSymbols().getMonths()[month];
	}
}
