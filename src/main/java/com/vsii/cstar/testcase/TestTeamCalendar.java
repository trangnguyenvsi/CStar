package com.vsii.cstar.testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vsii.cstar.common.methods.CommonMethod;
import com.vsii.cstar.pages.methods.LoginPageMethods;
import com.vsii.tsc.utility.TestBase;

public class TestTeamCalendar {
	
	LoginPageMethods loginObj = new LoginPageMethods(TestBase.driver);
	
	@Test
	public void test01(){
		//CommonMethod.checkLogin();
//		TestBase.driver.findElement(By.xpath("//*[@id='ctlLogin_tbUsername']")).sendKeys("nguyen.thi.thu.trang@vsi-international.com");
//		TestBase.driver.findElement(By.xpath("//*[@id='ctlLogin_txtPassword']")).sendKeys("Trangntt123@");
		loginObj.login("abc", "123");
	
		
	}
}
