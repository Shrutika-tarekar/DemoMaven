package com.loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginInPage {

	WebDriver lpdriver=null;
	public LoginInPage(WebDriver driver) {
		this.lpdriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button")
	WebElement loginbtn;
	
//	public WebElement getusername() {
//		return lpdriver.findElement(By.id("email"));
//		
//	}
	
	public void loginToApplication(String uname, String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginbtn.click();
//		getusername().sendKeys(uname);
	}
	
	// directly open dashboardPage 
	public DashboardPage validLogin() {
		username.sendKeys("kiran@gmail.com");
		password.sendKeys("123456");
		loginbtn.click();
		return new DashboardPage(lpdriver);
	}
}
