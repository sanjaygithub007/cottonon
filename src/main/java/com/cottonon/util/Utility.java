package com.cottonon.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	
	public static void screenShot(WebDriver driver,String screenshotName ) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots/"+screenshotName+".png"));
		
	}
}
