package com.qa.php.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.php.base.TestBase;
import com.qa.php.pages.HomePage;
import com.qa.php.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage l;
	HomePage h;
	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		Initialization();
		l=new LoginPage();
		
	}
	@Test(priority=1)
	public void ValidateTitleloginpagetest()
	{
		String s=l.validateLoginPage();
		
		Assert.assertEquals("ToolsQA", s);
		
	}
	@Test(priority=2)
	public void ValidateImageloginpagetest()
	{
		boolean b=l.validatelOGO();
		
		Assert.assertTrue(b);
		
	}
	@Test(priority=3)
	public void logintoapp()
	{
		//if(driver.getTitle().equals("Privacy error"))
		h=l.Login(prop.getProperty("username"),prop.getProperty("password"));
				
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@AfterMethod
	public void cleardown()	
	{
	driver.close();	
	}

}
