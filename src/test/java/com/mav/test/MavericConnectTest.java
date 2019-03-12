package com.mav.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.maveric.initialization.LaunchActivities;
import com.maveric.pageobjects.CorporatePointofContact;
import com.maveric.pageobjects.MavericLoginPage;
import com.maveric.pageobjects.MavericportalPage;

import com.maveric.utilities.PropertiesHandler;

public class MavericConnectTest  {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Properties prop;
	
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser"})
	public void initialization(@Optional("ch") String browser) throws IOException
	{
		// TODO Auto-generated method stub
				
				System.out.println("opt" + browser);
				prop=PropertiesHandler.getPropertyDetails("Utilities/data.properties");
				System.out.println(browser);
				launchBrowser(browser);
				
							
				
				
			//	driver=new ChromeDriver();
				driver.manage().window().maximize();
				wait= new WebDriverWait(driver,10);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void launchBrowser(String browser)
	{
	switch (browser.toLowerCase())
	{
	case "ch" :
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver= new ChromeDriver();
		break;
		
	case "chrome" :
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver=new ChromeDriver();
		break;
		
	case "ff":
	case "firefox":
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver=new ChromeDriver();
		break;
	case "ie":
	case"internetexplorer":
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver=new ChromeDriver();
		break;
	default:
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver=new ChromeDriver();
		break;
		
		
	}
	}
	
	@AfterTest(alwaysRun=true)
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
//test1
	@Test(priority=3,groups="high")
	public  void PositiveCredentialCheck() throws IOException {
		

		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		String expectedtitle=prop.getProperty("expectedtitle");
		
		driver.get(url);
		
		//total number of links
		
		/*List<WebElement> liksEle=driver.findElements(By.tagName("a"));
		int noOfLinks=liksEle.size()*/
		
		
		MavericLoginPage login=new MavericLoginPage(driver);
		login.sendUsername(username);
		login.sendPassword(password);
		login.clickOnLogin();
		int noOfLinks=login.getNoOfLinks();
		System.out.println(noOfLinks);
		
		
	/*	MavericLoginPage.sendUsername(driver,username);
		MavericLoginPage.sendPassword(driver,password);
		MavericLoginPage.clickOnLogin(driver);*/
		
		
		
	/*	System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();*/
		
				//username
				/*WebElement user=driver.findElement(By.xpath("//input[@id='LoginForm_username']"));
				user.sendKeys(username);*/
				
				//password
				/*WebElement pwd=driver.findElement(By.id("LoginForm_password"));
//				WebElement pwd=driver.findElement(By.cssSelector(cssSelector)("LoginForm_password"));
				pwd.sendKeys(password);*/
				
				//login
				/*WebElement login=driver.findElement(By.xpath("//input[@name='yt0']"));
				login.click();*/
		
				MavericportalPage qms =new MavericportalPage(driver,wait);
				String actualTitle=qms.waitForQmsDisplayAndgetTitle();
				/*wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='QMS']")));
		        
				String actualTitle=driver.getTitle();
				System.out.println(actualTitle);*/
				String expectedTitle1=expectedtitle;
				
				/*if(actualTitle.equals(expectedTitle1))
				{
					System.out.println("Test case passed");
				}
				else
				{
					System.out.println("test case failed");
				}*/
				
				
				
				driver.findElement(By.xpath("//a[text()='QMS']")).click();
				Assert.assertEquals(actualTitle, expectedTitle1,"validations on Positivecredentials check");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//li[@class='expandable lastExpandable'])[1]")));
				driver.findElement(By.xpath("(//div[@class='hitarea expandable-hitarea lastExpandable-hitarea'])[1]")).click();
				String text1=driver.findElement(By.xpath("(//li[@class='expandable'])[1]")).getText();
				System.out.println(text1);
				String text2=driver.findElement(By.xpath("//li[@id='3']")).getText();
				System.out.println(text2);
				String text3=driver.findElement(By.xpath("//li[@id='4']")).getText();
				System.out.println(text3);
				
				
				

	}
	
				
				
				
				
}


