package com.cottonon.testcases;

import java.io.IOException;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cottonon.base.TestBase;
import com.cottonon.pages.HomePage;
import com.cottonon.pages.ProductPage;
import com.cottonon.util.Utility;

public class HomePageTest extends TestBase {
	HomePage homepage;
	Scanner sc=new Scanner(System.in);
	
	@BeforeMethod
	public void setup() throws IOException
	{
		init();
		homepage=new HomePage(driver);
	}
   @Test 
    public void validatemoveableLink()
    {
	   boolean flag=homepage.clickOnFreeDeliverylink();
	   Assert.assertTrue(flag, "got clickandcollect page");
    }
   
   @Test 
   public void validatemoveableLink2()
   {
	   boolean flag=homepage.clcikOnTenoff();
	   Assert.assertTrue(flag, "got clickOnTenOff page");
   }
   
   @Test
   public void valiadtesearchbox() throws IOException {
	   System.out.println("Enter what u want to search");
	   String data=sc.nextLine();
	   ProductPage productpage=homepage.searchfield(data);
	   //Assert.assertEqua(productpage, "search page not open sucessfully");
   }
   
   @AfterMethod
   public void TearDown(ITestResult result)
   {
	   if(ITestResult.FAILURE==result.getStatus())
	   {
		 try {
			Utility.screenShot(driver, result.getName());
			System.out.println("screenshot taken");
		} catch (IOException e) {
			e.printStackTrace();
		}
	   }
	   
	   driver.quit();
   }
  
}
