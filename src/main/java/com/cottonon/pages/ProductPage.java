package com.cottonon.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cottonon.base.TestBase;

public class ProductPage extends TestBase{
	
	WebDriver driver;
	@FindBy(xpath="//*[@id='wrapper']/div/div/div/div/a/h4")
	WebElement allsection;
	
	//@FindBy(xpath="(//*[@class='overlay-button'])[2]")
	@FindBy(xpath=".//*[@id='main']/div[5]/div[2]/div[2]/a/h3")
	WebElement men;
	
	@FindBy(xpath="(//*[@class='dropdown-title'])[3]")
	WebElement sortBy;
	
	@FindBy(xpath="(//*[contains(text(),'Price high to low')])[2]")
	WebElement hightolow;
	
	//@FindBy(xpath="//*[@id='search-result-items']/li/div/div[4]")
	//WebElements prodPricing;
	
	public ProductPage(WebDriver driver) throws IOException
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyProdHightolowprice() throws InterruptedException
	{
		Actions a=new Actions(driver);
		//a.doubleClick(men).build().perform();
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView();", men);
		a.moveToElement(men);
		men.click();
		Thread.sleep(3000);
		sortBy.click();
		hightolow.click();
		List<WebElement> allprice = driver.findElements(By.xpath("//*[@id='search-result-items']/li/div/div[4]"));
		System.out.print("printing all values"+allprice);
		ArrayList<Integer> array=new ArrayList<Integer>();////*[@id='search-result-items']/li
		Iterator<WebElement> itr = allprice.iterator();
		while(itr.hasNext())
		{
			String data = itr.next().getText();
			System.out.println(data);
			if(data.contains("$"))
			{
				String actualdata = data.substring(1);
				double dData=Double.parseDouble(actualdata);
				int productprice=(int)(dData);
				array.add(productprice);
			}
		}
		for(int i=0; i < array.size() -1 ; i++)
		{
			if(array.get(i) <= array.get(i+1))
			{
				System.out.println("obj.get(i)"+array.get(i));
				System.out.println("obj.get(i+1)"+array.get(i+1));
			}else {
			Assert.assertTrue(false);
		}
		}
	}
	public void verifyProductPage()
	{
		Actions a=new Actions(driver);
		//a.doubleClick(men).build().perform();
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView();", men);
		a.moveToElement(men);
		men.click();
		
		
	}
	}
