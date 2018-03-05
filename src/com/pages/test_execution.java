package com.pages;

import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test_execution {
	
	WebDriver driver;
	
	@Test
	public void select_feeds() {
		
	}
	
	
	
	@BeforeTest
	public void setup() {
		
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("login successful");
		
	}
	
	@AfterTest
	public void close_browser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
