package com.cottonon.pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cottonon.base.TestBase;

public class ProductDetailspage extends TestBase{
	

	
	@FindBy(xpath="//*[@id='mega-menu']/ul/li[5]")
	WebElement Men;
	
	@FindBy(xpath="//*[@id='search-result-items']/li")
	WebElement AllProducts;
	
	@FindBy(xpath=".//*[@id='44795ec7772e8bc891353ccc12']/div[1]/a/img")
	WebElement teeimage;
	
	@FindBy(xpath="//*[@id='product-content']/div[4]/ul/li[2]/div[2]/ul/li")
	WebElement AllSize;
	
	@FindBy(xpath="//*[@id='add-to-cart']")
	WebElement AddToBag;
	
	@FindBy(xpath=".//*[@id='slide-dialog-container']/div/div[2]/div[1]/div")
	WebElement SizeMsg;
	
	@FindBy(xpath="//span[text()='In Stock']")
	WebElement InStockMsg;
	
	@FindBy(xpath="//*[@id='pdpMain']/div[1]/div[2]/a")
	WebElement TargetImage;
	
	
	public ProductDetailspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public ProductPage GoToProductPage() throws IOException
	{
		Men.click();
		Men.click();
		return new ProductPage(driver);
	}
	
	public void selectproduct()
	{
		Actions a=new Actions(driver);
		teeimage.click();
		//a.moveToElement(target)
		
	}
	
	
	
	public void SelectProduct(int num)
	{
		int Number=0;
		int i=0;
		HashMap hm=new HashMap();
		List<WebElement> Products= driver.findElements(By.xpath("//*[@id='search-result-items']/li"));
		System.out.println(Number=Products.size());
		Iterator itr =Products.iterator();
		for(i=0;i<Number;i++)
		{
		if(itr.hasNext())
		{
			Object data=itr.next();
			String Product=data.toString();
				hm.put(i,Product);
			//	System.out.println(hm);

			}
		//System.out.println("\n");
		}
	
			Set s=hm.keySet();
			Iterator itr1=s.iterator();
			while(itr1.hasNext())
			{
				Object kobj=itr.next();
				Integer io=(Integer)kobj;
				int wdata=io.intValue();   //optional due to Autoboxing
				if(wdata==num)
				{
					Object vobj=hm.get(kobj);
					
					System.out.println(vobj);
					
				}
		}
	}
	
	public void verifyImage() {

		teeimage.click();
		Actions a=new Actions(driver);
		a.moveToElement(TargetImage);
		String imageinfo=TargetImage.getAttribute("title");
		System.out.println(imageinfo);
		
		
	}
	
	
	
	

}
