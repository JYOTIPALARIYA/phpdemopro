package com.qa.php.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.php.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath="//input[@id='userName']")
	WebElement username;
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='main-header']")
	WebElement img;
	@FindBy(xpath="//button[@id='login']")
	WebElement loginbtn;
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	public String validateLoginPage()
	{
	String s=driver.getTitle();
	return s;
	}
	public boolean validatelOGO()
	{
	 return(img.isDisplayed());	
	}
	public HomePage Login(String uname,String pass)
	{
		username.sendKeys(uname);
		password.sendKeys(pass);

		//driver.switchTo().frame("reCAPTCHA");
		
		loginbtn.click();
		return new HomePage();
	}

}
