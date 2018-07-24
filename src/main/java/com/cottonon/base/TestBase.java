package com.cottonon.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.cottonon.excelreder.Excel_Reader;

public class TestBase {
	public WebDriver driver;
	public Properties prop;
	public Excel_Reader excel;
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger(TestBase.class);
	
	public void init() throws IOException
	{
		String log4jConfPath = "E:\\eclipse\\cottonon\\src\\test\\resources\\properties\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		loadProerties();
		selectbrowser(prop.getProperty("browser"));
		getsite(prop.getProperty("url"));
	}
	
	public void loadProerties() throws IOException
	{
		prop=new Properties();
		fis=new FileInputStream("E:\\eclipse\\cottonon\\src\\main\\java\\com\\cottonon\\config\\config.properties");
		prop.load(fis);
		log.debug("congig file loaded");
	}
	
	public WebDriver selectbrowser(String browser) {
		
		if(browser.toLowerCase().equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		log.debug("chrome launched");
		return driver;
		}
		
		else if(browser.toLowerCase().equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
	    driver=new FirefoxDriver();
		log.debug("firefox launched");
		return driver;
		}
		
		else if(browser.toLowerCase().equalsIgnoreCase("ie"))
		{
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		driver=new InternetExplorerDriver();
		return driver;
		}
return null;
}
	public void getsite(String url)
	{
		log.info("your cottonon shopping site is opening");
		driver.get(url);
		log.debug("new url is opening");
		driver.manage().window().maximize();
		log.debug("window is maximizing");
	}
	
	public String[][] getdata(String excelname,String sheetname) throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\cottonon\\testdata\\"+excelname;
		excel=new Excel_Reader(path);
		String[][] data=excel.getexceldata(sheetname);
		return data;
		
		
	}
	/*public void failure(String testmethodname)
	{
		String userdir=System.getProperty("user.dir");
		String customlocation="//src//main//java//com//cottonon//screenshots//";
		String failureimgfilename=userdir+customlocation+new SimpleDateFormat("dd-MM-yyyy-HH-ss").format(new GregorianCalendar().getTime())+testmethodname+".png";
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File(failureimgfilename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
