package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class screenshot {
	
	ExtentReports reports;
	ExtentTest logger;
	WebDriver driver;
	
	@Test
	public void check_title() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bala\\Downloads\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://selfservice-staging.adappt.co.uk/");
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("selenium"));
	}

}
