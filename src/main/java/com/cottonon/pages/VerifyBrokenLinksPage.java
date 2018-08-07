package com.cottonon.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.cottonon.base.TestBase;

public class VerifyBrokenLinksPage extends TestBase{
	public String url;
	
	public VerifyBrokenLinksPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public ArrayList<String> verifyLinks()
	{
		ArrayList<String> Stringlinks=new ArrayList<String>();
		//String s[]=new String(i);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(int i=0;i<links.size();i++)
		{
			WebElement element = links.get(i);
			url = element.getAttribute("href");
			System.out.println(url);
			Stringlinks.add(url);
		}
			return Stringlinks;
	}
	public void verifyLinkActive(ArrayList<String> linkUrl) throws IOException
	{
		try {
			Iterator<String> itr=linkUrl.iterator();
			while(itr.hasNext())
			{
				Object data=itr.next();
				String sdata=data.toString(); 
			URL url=new URL(sdata);
			HttpURLConnection httpUrlConnect=(HttpURLConnection)url.openConnection();
			httpUrlConnect.setConnectTimeout(3000);
			
			if(httpUrlConnect.getResponseCode()==200)
			{
				System.out.println(linkUrl+"_"+httpUrlConnect.getResponseMessage());
			}
			if(httpUrlConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
			{
				System.out.println(linkUrl+"httpUrlConnect.getResponseMessage()");
			}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
