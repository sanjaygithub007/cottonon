package com.cottonon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cottonon.base.TestBase;

public class SignMeInpage extends TestBase{
	
	@FindBy(xpath="//*[@class='icon icon-header-account']")
	WebElement RESiLink;
	
	@FindBy(xpath="//*[text()='Sign Me In']")
	WebElement SignMeInLink;
	
	@FindBy(xpath="//input[@type='email'and @class='input-text custom-input required']")
	WebElement email;
	
	@FindBy(xpath="//input[@class='input-text custom-input required'and @type='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='button action sign-me-in']")
	WebElement SignMeIn;
	
	@FindBy(xpath="//*[@id='primary']/h1/span/a")
	WebElement logout;
	
	public SignMeInpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void signinwithvalidData(String username,String epassword)
	{
		RESiLink.click();
		SignMeInLink.click();
		email.sendKeys(username);
		password.sendKeys(epassword);
		SignMeIn.click();
	}
	 
	public boolean verifyLogoutdisplay()
	{
		try {
			logout.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void logout()
	{
		logout.click();
	}
	
	

}
