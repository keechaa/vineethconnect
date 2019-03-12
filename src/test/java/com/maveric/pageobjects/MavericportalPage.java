package com.maveric.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MavericportalPage {
	static By qmsLoc=By.xpath("//a[text()='QMS']");
	WebDriver driver;
	WebDriverWait wait;
	
	public MavericportalPage(WebDriver driver2, WebDriverWait wait2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
		this.wait=wait2;
	}

	public String waitForQmsDisplayAndgetTitle()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(qmsLoc)); //dont hardcode thats y giving as instance variable
        
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		return actualTitle;
	}
	
	

}
