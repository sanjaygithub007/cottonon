package com.cottonon.testcases;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cottonon.base.TestBase;
import com.cottonon.pages.VerifyBrokenLinksPage;

public class VerifyBrokenLinksTest extends TestBase{
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		init();
	}
	
	@Test
	public void validateLinks() throws IOException
	{
		VerifyBrokenLinksPage blp=new VerifyBrokenLinksPage(driver);
		ArrayList<String> linkUrl=blp.verifyLinks();
		blp.verifyLinkActive(linkUrl);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
