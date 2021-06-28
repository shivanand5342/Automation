package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypages.*;


public class LoginTest extends BaseTest{

	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String actualTitle=page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "give ExpectedTitle");
	}
	
	@Test(priority=2)
	public void verifyLoginPageHeaderTest() {
		String actualHeader=page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(actualHeader);
		Assert.assertEquals(actualHeader, "give ExpectedHeader");
	}
	
	@Test(priority=3)
	public void doLoginTest() {
		HomePage homePage=page.getInstance(LoginPage.class).doLogin("aaa@gmail.com", "pasword");
		String headerHome = homePage.getHomePageHeader();
		System.out.println(headerHome);
		Assert.assertEquals(headerHome, "give ExpectedHeader");
		
	}
}
