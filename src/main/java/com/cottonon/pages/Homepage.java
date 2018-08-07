package com.cottonon.pages;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cottonon.base.TestBase;
import com.google.common.base.Function;

public class HomePage extends TestBase {
	
	//@FindBy(xpath="//a[text()='FREE delivery on orders over $55']")
	WebElement FreeCLickAndCollectlink;
	
	@FindBy(xpath=".//*[@id='primary']/div[1]/div/div[1]/div/div[1]/div/h2")
	WebElement clickandcollecttext;
	
	@FindBy(xpath="//*[@id='service-propositions']/div/div[4]/div/div/a\r\n")
	WebElement clickon10off;
	
	@FindBy(xpath=".//*[@id='primary']/div/div[1]/div[1]/div/div/a/img[1]\r\n")
	WebElement clickon10offtext;
	
	@FindBy(id="q")
	WebElement searchbox;
	
	@FindBy(xpath="//*[@id='search-suggestions']/div/div[1]/div[1]")
	WebElement suggestiontable;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean clickOnFreeDeliverylink()
	{
		WebDriverWait wait=new WebDriverWait(driver,2000);
		FreeCLickAndCollectlink=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='service-propositions']/div/div[3]/div/div/a")));
		FreeCLickAndCollectlink.click();
		return clickandcollecttext.isDisplayed();
		
	}
	public boolean clcikOnTenoff()
	{
		@SuppressWarnings("deprecation")
		Wait<WebDriver> fluentwait=new FluentWait<WebDriver>(driver).withTimeout(30,TimeUnit.SECONDS).pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		@SuppressWarnings("unchecked")
		WebElement element=fluentwait.until(new Function()
				{
					public Object apply(Object arg0) {
						// TODO Auto-generated method stub
						return clickon10off;
					}
				});
		element.click();
		return clickon10offtext.isDisplayed();
	}
	
	public ProductPage searchfield(String data) throws IOException
	{
		searchbox.click();
		searchbox.sendKeys(data);
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='search-suggestions']/div")));
        List<WebElement> Sugesstiondatas=driver.findElements(By.xpath("//*[@id='search-suggestions']/div/div[1]/div[1]"));	
        int size=Sugesstiondatas.size();
        System.out.println(size);
        for(WebElement element : Sugesstiondatas)
        {
        	String sugessiondata=element.getText();
        	System.out.println(sugessiondata);
        	if(sugessiondata==data)
        	{
        		element.click();
        	}
        }
		return new ProductPage(driver);

        
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
