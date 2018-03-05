package com.pages;

import java.awt.Toolkit;
import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test_execution {
	
	WebDriver driver;
	
	@Test
	public void select_feeds() throws InterruptedException {
		List<WebElement> title= driver.findElements(By.xpath("//div[starts-with(@id,'5a')]"));
		Iterator<WebElement> header=title.iterator();
		while(header.hasNext()) {
			WebElement titles=header.next();
			if(titles.getText().equals("Oil & Gas")) {
				System.out.println("feed is found");
				Thread.sleep(3000);
			boolean feed=titles.isSelected();
			if(feed==true) {
				System.out.println("feed is already subscribed");
			}else {
//				JavascriptExecutor executor = (JavascriptExecutor)driver;
//				executor.executeScript("arguments[0].click();", titles);
//				titles.click();
		
				Actions action = new Actions(driver);
				action.moveToElement(titles).click().perform();
				Thread.sleep(3000);
			}
			}
		}
		
		}
	
	
	
	
	@BeforeTest
	public void setup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bala\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://selfservice-staging.adappt.co.uk/");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
    	Dimension screenResolution = new Dimension((int) 
    	                    toolkit.getScreenSize().getWidth(), (int) 
    	                    toolkit.getScreenSize().getHeight());
    	driver.manage().window().setSize(screenResolution);
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("superadmin");
		System.out.println("username is entered");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Welcome1!");
		System.out.println("password is enetered");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("login successful");
		
	}
	
	@AfterTest
	public void close_browser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
