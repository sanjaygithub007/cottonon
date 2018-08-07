package com.cottonon.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cottonon.base.TestBase;
import com.cottonon.pages.ProductDetailspage;
import com.cottonon.pages.ProductPage;

public class ProductDetailsPageTest extends TestBase {
	
	ProductDetailspage productDetailspage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		init();
		productDetailspage=new ProductDetailspage(driver);
	}
	
	
	@Test
	public void validatefilter() throws IOException, InterruptedException
	{
		productDetailspage.GoToProductPage();
		productDetailspage.SelectProduct(2);
	}
	
	@Test
	public void valiadteImage() throws IOException
	{
		productDetailspage.GoToProductPage();
		productDetailspage.verifyImage();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
