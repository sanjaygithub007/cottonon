package com.cottonon.rough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;

public class Base {
	public static WebDriver driver;
	

	@Parameters("browser")
	public static WebDriver openbrowser(String browserName) {
		
		if(browserName.toLowerCase().equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		//log.debug("chrome launched");
		return driver;
		}
		
		else if(browserName.toLowerCase().equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
	    driver=new FirefoxDriver();
		//log.debug("firefox launched");
		return driver;
		}
		
		else if(browserName.toLowerCase().equalsIgnoreCase("ie"))
		{
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		driver=new InternetExplorerDriver();
		return driver;
		}
	return null;
	}
	
	public static void init()
	{
		openbrowser("browser");
	}
	
}
