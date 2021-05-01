package com.qa.php.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.php.base.TestBase;
import com.qa.php.pages.HomePage;
import com.qa.php.pages.LoginPage;
import com.qa.php.pages.Practice;

public class HomePageTest extends TestBase
{

HomePage h;
LoginPage l;
Practice p;
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		Initialization();
			l = new LoginPage();
			p=new Practice();
		h = l.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority=1)
	public void clickOnForms(){
		h.clickOnFormLink();
	}
	@Test(priority=2)
	public void clickOnPracticeForms(){
		h.clickOnFormLink();
		p=h.clickOnPracticeFormLink();
	}
	@AfterMethod
	public void cleardown()	
	{
	driver.close();	
	}
	
}
