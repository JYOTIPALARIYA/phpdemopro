package com.qa.php.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.php.base.TestBase;


public class HomePage extends TestBase{
	@FindBy(xpath = "//div[@class='header-text' and text()='Forms']")
	WebElement forms;
	
	@FindBy(xpath = "//div[@class='element-list collapse show']//span[@class='text']")
	WebElement practiceform;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFormLink(){
		forms.click();

	}
	public Practice clickOnPracticeFormLink(){
		practiceform.click();
		return new Practice();
	}
	
	
}
