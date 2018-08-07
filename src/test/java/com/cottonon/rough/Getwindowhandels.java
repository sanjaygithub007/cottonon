package com.cottonon.rough;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Getwindowhandels extends Base {

	public static void main(String[] args) throws InterruptedException {

		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		init();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Starting @199']")).click();
		driver.findElement(By.xpath("//img[@alt='Kraasa Slippers']")).click();
		ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(0));
		driver.switchTo().window(windows.get(1));
	}

}
