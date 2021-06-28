package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

	private By header=By.className("pass some header here");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	

	public String getHomePageTitle() {
		return getPageTitle();
	}

	public String getHomePageHeader() {
		return getPageHeader(header);
	}
}
