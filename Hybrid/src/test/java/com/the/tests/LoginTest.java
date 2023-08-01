package com.the.tests;

import org.apache.commons.collections4.iterators.SkippingIterator;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.loginpage.DashboardPage;
import com.loginpage.LoginInPage;
import com.the.base.BaseClass;

public class LoginTest extends BaseClass{

	LoginInPage lp=null;
	DashboardPage dp=null;
	@BeforeSuite
	public void setup() throws Exception {
		intialization();
		reportInit();
		lp=new LoginInPage(driver);
	}
	
	@Test
	public void test01() {
		lp.validLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	
	@Test
	public void test02() {
		Assert.assertTrue(dp.verifyCourses1());
	}
	
	@Test
	public void test03() {
		throw new SkipException("skipping the test");
	}
}
