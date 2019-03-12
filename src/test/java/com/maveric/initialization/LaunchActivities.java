package com.maveric.initialization;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.maveric.utilities.PropertiesHandler;

public class LaunchActivities {
	
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
	

}
