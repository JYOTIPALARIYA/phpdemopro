package com.qa.php.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.php.base.TestBase;
import com.qa.php.pages.HomePage;
import com.qa.php.pages.LoginPage;
import com.qa.php.pages.Practice;
import com.qa.php.util.Util;

;

public class PracticeTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	Util testUtil;
	Practice p;
	String sheetName="Practice";
	public PracticeTest(){
		super();
		
}


@BeforeMethod
public void setUp() throws InterruptedException {
	
	Initialization();
	testUtil = new Util();
	loginPage = new LoginPage();
	homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	homePage.clickOnFormLink();
	p=homePage.clickOnPracticeFormLink();
}
@DataProvider
public Object[][] getPracticeTestData(){
	Object data[][] = Util.getTestData(sheetName);
	return data;
}

@Test(priority=1,dataProvider="getPracticeTestData")
public void verifyForm(String FirstName,String LastName,String Email,String Phone, String Subject,String Location){
	//p.fillForm("Jyoti", "Palariya","jy@gmail.com","1234567891","ComputerScience","Nainital");
	p.fillForm(FirstName,LastName,Email,Phone,Subject,Location);
	
}
@AfterMethod()
public void closedr()
{
driver.close();	
}


}
