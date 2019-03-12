package com.maveric.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CorporatePointofContact {

	@FindBy(xpath="//a[text()='Corporate']")
	WebElement corporateEle;
	
	@FindBy(xpath="//a[text()='Point of Contact']")
	WebElement pointOfContactEle;
	
	@FindBy(xpath="//span[text()='Administration Contact']")
	WebElement adminTab;
	
	@FindBy(xpath="//table[@id='yw0-body-table']/tbody/tr")
	List<WebElement> table;
	
	
	
	WebDriver driver;
	WebDriverWait wait;
	public CorporatePointofContact(WebDriver driver,WebDriverWait wait) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver,this);
	}
	
	

	public ArrayList<String> getAdministrationContactEmailIds() {
	
//	WebElement corporateEle=driver.findElement(By.xpath("//a[text()='Corporate']"));
	Actions action= new Actions(driver);
	action.moveToElement(corporateEle).pause(2000).build().perform();
	
	//WebElement pointOfContactEle =driver.findElement(By.xpath("//a[text()='Point of Contact']"));
	wait.until(ExpectedConditions.visibilityOf(pointOfContactEle));
	pointOfContactEle.click();
	
	//driver.findElement(By.xpath("//span[text()='Administration Contact']")).click();
	adminTab.click();
	
	
	//int noofRows=driver.findElements(By.xpath("//table[@id='yw0-body-table']/tbody/tr")).size();
	int noofRows=table.size();
	ArrayList<String> listOfEmailds=new ArrayList<String>(); //or List<string>
	
	for(int i =1;i<=noofRows;i++)
	{
	WebElement emailEle=driver.findElement(By.xpath("//table[@id='yw0-body-table']/tbody/tr["+i+"]/td[5]"));
	String emailId=emailEle.getText();
//	System.out.println(emailId);
	listOfEmailds.add(emailId);
	}
	return listOfEmailds;

}
}