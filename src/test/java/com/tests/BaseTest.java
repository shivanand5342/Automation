package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.mypages.BasePage;
import com.mypages.Page;

public class BaseTest {

	WebDriver driver;
	public Page page;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setUpTest(String browser) {
		if(browser.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			//WebDriverManager.FirefoxDriver().setup();
			driver=new FirefoxDriver();
		}else{
			System.out.println("no browser is defined in xml file...");
		}
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		page=new BasePage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
