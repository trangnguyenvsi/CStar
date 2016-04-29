package com.vsii.cstar.common.methods;

import com.vsii.cstar.pages.LoginPage;
import com.vsii.cstar.pages.methods.LoginPageMethods;
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

}
