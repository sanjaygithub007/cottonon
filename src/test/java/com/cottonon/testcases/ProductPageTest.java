 package com.cottonon.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.cottonon.base.TestBase;
//import com.cottonon.customlistener.Listener;
import com.cottonon.pages.ProductPage;



//@Listeners(Listener.class)
public class ProductPageTest extends TestBase{

	ProductPage productpage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		init();
		productpage=new ProductPage(driver);
	}
	
	
	@Test
	public void validatefilter() throws IOException, InterruptedException
	{
		productpage.verifyProdHightolowprice();
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
	

