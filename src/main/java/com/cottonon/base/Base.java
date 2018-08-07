package com.cottonon.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;

public class Base {

	protected WebDriver driver; 
	@Parameters("browser")
	public Base(String browserName) {
		
		if(browserName.toLowerCase().equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		
		else if(browserName.toLowerCase().equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
	    driver=new FirefoxDriver();
		}
		
		else if(browserName.toLowerCase().equalsIgnoreCase("ie"))
		{
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		driver=new InternetExplorerDriver();
		}
	}
}
