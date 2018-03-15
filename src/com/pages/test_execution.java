package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;


public class test_execution {
	
	WebDriver driver;
	
	
	@Test
	public void select_feeds() throws InterruptedException, AWTException, IOException {

		driver.findElement(By.xpath("//a[@class='update']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
		Runtime.getRuntime().exec("E:\\FileUpload.exe");
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		List<WebElement> upload = driver.findElements(By.xpath("//button[@type='button']"));
		System.out.println("totla buttons = " +upload.size());
		WebElement b=upload.get(1);
		Actions action = new Actions(driver);
		action.moveToElement(b).click().perform();
		Thread.sleep(3000);
		

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
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345678");
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
