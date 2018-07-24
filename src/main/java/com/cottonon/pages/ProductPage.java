package com.cottonon.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cottonon.base.TestBase;

import junit.framework.Assert;

public class ProductPage extends TestBase{
	
	WebDriver driver;
	@FindBy(xpath="//*[@id='wrapper']/div/div/div/div/a/h4")
	WebElement allsection;
	
	@FindBy(xpath=".//*[@id='home-top-slot']/div[1]/div/div[3]/div[1]/a[2]/h4")
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
		//Actions a=new Actions(driver);
		//a.doubleClick(men).build().perform();
		men.click();
		Thread.sleep(3000);
		sortBy.click();
		hightolow.click();
		List<WebElement> allprice = driver.findElements(By.xpath("//*[@id='search-result-items']/li/div/div[4]/span[2]"));
		System.out.print("printing all values"+allprice);
		ArrayList<Integer> array=new ArrayList<Integer>();
		Iterator<WebElement> itr = allprice.iterator();
		while(itr.hasNext())
		{
			String data = itr.next().getText();
			System.out.print("printing each data"+data);
			if(data.contains("$"))
			{
				String actualdata = data.substring(1);
				double dData=Double.parseDouble(actualdata);
				int productprice=(int)(dData);
				array.add(productprice);
			}
		}
		for(int i=0; i < array.size()-1 ; i++)
		{
			if(array.get(i) < array.get(i+1))
			{
				System.out.println("obj.get(i)"+array.get(i));
				System.out.println("obj.get(i+1)"+array.get(i+1));
			}
			Assert.assertTrue(false);
		}
	}
	}
