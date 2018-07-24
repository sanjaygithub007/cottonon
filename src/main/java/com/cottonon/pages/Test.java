package com.cottonon.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class Test {
	

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","E:\\eclipse\\cottonon\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://cottonon.com");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Actions a=new Actions(driver);
		WebElement men = driver.findElement(By.xpath("//*[@id='wrapper']/div[4]/div/div/div/a[2]/h4"));
		a.doubleClick(men).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class='dropdown-title'])[3]")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'Price high to low')])[2]")).click();
		Thread.sleep(3000);
		List<WebElement> allprice = driver.findElements(By.xpath("//*[@id='search-result-items']/li/div/div[4]"));
		ArrayList<Integer> array=new ArrayList<Integer>();
		Iterator<WebElement> itr = allprice.iterator();
 		while(itr.hasNext())
		{
			String data = itr.next().getText();
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
