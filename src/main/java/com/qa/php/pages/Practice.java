package com.qa.php.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.php.base.TestBase;

public class Practice extends TestBase {
	@FindBy(xpath="//input[@id='firstName']")
	WebElement fName;
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lName;
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement useremail;
	@FindBy(xpath="//label[text()=\"Male\"]")
	WebElement gender;
	@FindBy(xpath="//input[@id='userNumber']")
	WebElement phnumber;
	@FindBy(xpath="//input[@id='subjectsInput']")
	WebElement subb;
	@FindBy(xpath="//label[text()='Sports']")
	WebElement chk;
	@FindBy(xpath="//input[@id='uploadPicture']")
	WebElement upload;
	@FindBy(xpath="//*[@id='currentAddress']")
	WebElement text;
	@FindBy(xpath="//button[@id=\"submit\"]")
	WebElement submitbtn;
	
	@FindBy(xpath="//*[@id='closeLargeModal']")
	WebElement cancelModel;
	
	
	public Practice() {
		PageFactory.initElements(driver, this);
	}
	public void fillForm(String name,String laname,String usermail,String Num,String sub,String currentAdd){
		
		fName.sendKeys(name);
		lName.sendKeys(laname);
		useremail.sendKeys(usermail);
		gender.click();
		phnumber.sendKeys(Num);
		subb.sendKeys(sub);
		chk.click();
		text.sendKeys("Hi there");
		upload.sendKeys("C://Users//jyoti//Downloads/IMG-20200821-WA0014.jpg");
		submitbtn.click();
		cancelModel.click();
	}


	
	
	
	
	
	

}
