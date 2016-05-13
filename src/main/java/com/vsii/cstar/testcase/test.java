package com.vsii.cstar.testcase;

import java.text.ParseException;

import com.vsii.cstar.common.methods.CommonMethod;
import com.vsii.tsc.utility.TestBase;

public class test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		if(CommonMethod.isCurrentDate("2016-04-14 00:00:00") == true)
		{
			System.out.println("true");
		}
		else
			System.out.println("F");
	
	}

}
