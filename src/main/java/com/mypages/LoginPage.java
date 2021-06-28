package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	//page locator
	private By emailId=By.id("email");
	private By password=By.id("pass");
	private By loginButton = By.xpath("//*[@name='login']");
	private By header = null;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//public getters 
	public WebElement getEmailId() {
		return getElement(emailId);
	}


	
	public WebElement getPassword() {
		return getElement(password);
	}



	public WebElement getLoginButton() {
		return getElement(loginButton);
	}


	public WebElement getHeader() {
		return getElement(header);
	}

	public String getLoginPageTitle() {
		return getPageTitle();
	}
	
	

	public String getLoginPageHeader() {
		return getPageHeader(header);
	}
	
//metho overloading	
	public HomePage	 doLogin(String username, String password) {
		getEmailId().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().click();
		
		return getInstance(HomePage.class);
	}
	
	public void	 doLogin() {
		getEmailId().sendKeys("");
		getPassword().sendKeys("");
		getLoginButton().click();
		
	}
	
	// suppose my input is like
	// username: shivanand@gmail.com
	// password: 123456
	public void doLogin(String userCred) {
		if(userCred.contains("username")) {
			getEmailId().sendKeys(userCred.split(":")[1].trim());
		}else if(userCred.contains("password")) {
			getEmailId().sendKeys(userCred.split(":")[1].trim());
		}
		getLoginButton().click();
	}
	
	
}
