package com.itlearn.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.LoginPage;
import com.itlearn.utility.ReadExcelFile;

public class LoginTest extends BaseTest {
	
	@Test
	void verifyLogin() {
		LoginPage lp = new LoginPage(driver);
		String username ="adinathborude1999@gmail.com";
		String password ="Adinath@#123456$";
		lp.loginPortal(username,password);
		
	}

	
}
