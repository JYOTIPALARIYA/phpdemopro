package com.qa.php.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.php.util.Util;
import com.qa.php.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public  static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	public TestBase()
	{
		prop=new Properties();
		
		try {
			FileInputStream ip=new FileInputStream("D:\\eclipseworkspace\\phpdemopro\\src\\main\\java\\com\\qa\\php\\config\\config.properties");

			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//initialising
	public static void Initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:/selenium/gc/chromedriver_win32 (1)/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","E:/selenium/gc/geckodriver-v0.26.0-win32/geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUTS,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
