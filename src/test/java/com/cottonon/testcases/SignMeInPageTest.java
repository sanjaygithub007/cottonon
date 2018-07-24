package com.cottonon.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cottonon.base.TestBase;
import com.cottonon.pages.SignMeInpage;

import junit.framework.Assert;

public class SignMeInPageTest extends TestBase{
	
	SignMeInpage signmeinpage;
	public static final Logger log=Logger.getLogger(SignMeInPageTest.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException
	{
		init();
	}
	
	@DataProvider(name="logindata")
	public String[][] getTestdata()
	{
		String[][] testrecords = null;
		try {
			
			testrecords = getdata("logindata.xlsx", "newdata");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testrecords;
	}
	
	@Test(dataProvider="logindata")
	public void testLogin(String username,String epassword,String runmode)
	{
		if(runmode.equalsIgnoreCase("n"))
		{
			throw new SkipException("user marked this record as no run");
		}
		log.info("=========Starting verification with different records======");
		signmeinpage=new SignMeInpage(driver);
		signmeinpage.signinwithvalidData(username, epassword);
		boolean status = signmeinpage.verifyLogoutdisplay();
		Assert.assertEquals(status, true);
		if(status)
		{
			signmeinpage.logout();
		}
		
		log.info("=========Ending of verification with different records======");

	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
