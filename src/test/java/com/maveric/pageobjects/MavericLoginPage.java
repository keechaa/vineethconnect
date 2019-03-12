package com.maveric.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MavericLoginPage {
	
/*	By userNameLoc =By.xpath("//input[@id='LoginForm_username']");
	By passwordLoc=By.id("LoginForm_password");
	By loginLoc=By.xpath("//input[@name='yt0']");
	By textLoc=By.xpath("//div[text()='Invalid user name']");*/
	
	@FindBy(xpath="//input[@id='LoginForm_username']")
	WebElement userNameEle;
	
	@FindBy(id="LoginForm_password")
	WebElement passwordEle;
	
	@FindBy(xpath="//input[@name='yt0']")
	WebElement loginEle;
	
	@FindBy(xpath="//div[text()='Invalid user name']")
	WebElement errorTextEle;
	
	@FindBy(tagName="a")
	List<WebElement> liksEle;
	
	WebDriver driver;
	
	
	
	public MavericLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}


	public  void sendUsername(String username)
	{
	
	
		
		userNameEle.sendKeys(username);
	}
	
	
	public  void sendPassword(String password)
	
	{
	
//	WebElement pwd=driver.findElement(By.cssSelector(cssSelector)("LoginForm_password"));
	passwordEle.sendKeys(password);
	}
	
	public  void clickOnLogin()
	{
	
	loginEle.click();

}
	
	public  String getText()
	{
		
		String actualText= errorTextEle.getText();
		System.out.println(actualText);
		return actualText;
	}
	
	public int getNoOfLinks()
	{
		//List<WebElement> liksEle=driver.findElements(By.tagName="a");
		int noOfLinks=liksEle.size();
		return noOfLinks;
	}
	}
