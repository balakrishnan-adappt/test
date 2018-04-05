package com.pages;

import java.awt.AWTException;

import java.awt.Toolkit;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.apache.commons.lang3.RandomStringUtils;

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
	public void select_feeds() throws InterruptedException, AWTException, IOException {

		driver.findElement(By.xpath("//a[contains(text(),'Category')]")).click();
		Thread.sleep(3000);
		
		/*Delete Feeds*/
//		List<WebElement> delete_icon = driver.findElements(By.xpath("//span[@class='fa fa-trash']"));
//		if(delete_icon.size()>0) {
//			WebElement delete=delete_icon.get(1);
//			Actions action=new Actions(driver);
//			action.moveToElement(delete).click().perform();
//			System.out.println("delete icon is clicked");
//			Thread.sleep(3000);
//			Alert myAlert = driver.switchTo().alert();
//	        myAlert.accept();
//	        String parent_window=driver.getWindowHandle();
//	        String sub_window=null;
//	        Set<String> handles=driver.getWindowHandles();
//	        Iterator<String> iterator=handles.iterator();
//	        while(iterator.hasNext()) {
//	        	sub_window=iterator.next();
//	        }
//	        driver.switchTo().window(sub_window);
//	        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
//	        Thread.sleep(3000);
//	        System.out.println("feed has been deleted");
//		}else {
//			System.out.println("there is no feed to delete");
//		}
//		
		
		/*Add Category*/
		String pagecount = driver.findElement(By.xpath("//div[@class='page-count']")).getText();
		System.out.println("total number of categories before adding= "+pagecount);
		driver.findElement(By.xpath("//button[contains(text(),'Add Category')]")).click();
		Date d = new Date(System.currentTimeMillis());
		driver.findElement(By.id("catname")).sendKeys("Category "+d);
		driver.findElement(By.xpath("//button[contains(text(),'create')]")).click();
		Thread.sleep(3000);
		WebElement cat_count = driver.findElement(By.xpath("//div[@class='page-count']"));
		System.out.println("Total number of categories after adding = "+cat_count.getText());
		Thread.sleep(3000);
		
		/*Edit category*/
		List<WebElement> edit_cat=driver.findElements(By.xpath("//span[@class='fa fa-pencil']"));
		if(edit_cat.size()>0) {
		System.out.println("total categories= "+edit_cat.size());
		WebElement edit_icon=edit_cat.get(1);
		Actions action=new Actions(driver);
		action.moveToElement(edit_icon).click().perform();
		System.out.println("Edit icon is clicked");
		Date date= new Date(System.currentTimeMillis());
		WebElement edit_category=driver.findElement(By.id("catname"));
		edit_category.clear();
		edit_category.sendKeys("EditCat "+date);
		driver.findElement(By.xpath("//button[contains(text(),'update')]")).click();
		System.out.println("Category name is changed");
		Thread.sleep(3000);
		}else {
			System.out.println("There is no category");
		}
		
		
		/*Delete Feeds*/
		List<WebElement> delete_icon = driver.findElements(By.xpath("//span[@class='fa fa-trash']"));
		if(delete_icon.size()>0) {
			WebElement delete=delete_icon.get(1);
			Actions action=new Actions(driver);
			action.moveToElement(delete).click().perform();
			System.out.println("delete icon is clicked");
			Thread.sleep(3000);
//			Alert myAlert = driver.switchTo().alert();
//	        myAlert.accept();
	        String parent_window=driver.getWindowHandle();
	        String sub_window=null;
	        Set<String> handles=driver.getWindowHandles();
	        Iterator<String> iterator=handles.iterator();
	        while(iterator.hasNext()) {
	        	sub_window=iterator.next();
	        }
	        driver.switchTo().window(sub_window);
	        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
	        Thread.sleep(3000);
	        System.out.println("category has been deleted");
	        driver.switchTo().window(parent_window);
		}else {
			System.out.println("There is no category to delete");
		}
		
		
		
		
		
		
		
		//Edit Feeds
//		List<WebElement> edit=driver.findElements(By.xpath("//span[@class='fa fa-pencil']"));
//		WebElement edit_icon=edit.get(1);
//		Actions action=new Actions(driver);
//		action.moveToElement(edit_icon).click().perform();
//		System.out.println("Edit icon is clicked");
//		Date date= new Date(System.currentTimeMillis());
//		WebElement edit_feed=driver.findElement(By.id("feed_title"));
//		edit_feed.clear();
//		edit_feed.sendKeys("EditedFeed "+date);
//		System.out.println("feed name is changed");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[contains(text(),'update')]")).click();
//		Thread.sleep(3000);
//		System.out.println("Feed is updated");
		
		
//		driver.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
//		Runtime.getRuntime().exec("E:\\FileUpload.exe");
//		driver.switchTo().activeElement();
//		Thread.sleep(3000);
//		List<WebElement> upload = driver.findElements(By.xpath("//button[@type='button']"));
//		System.out.println("total buttons = " +upload.size());
//		WebElement b=upload.get(1);
//		Actions action = new Actions(driver);
//		action.moveToElement(b).click().perform();
//		Thread.sleep(3000);
//		WebElement firstname=driver.findElement(By.xpath("//input[@name='firstName']"));
//		String first_name=firstname.getAttribute("value");
//		System.out.println("firstname before update is  "+first_name);
//		firstname.clear();
//		firstname.sendKeys(generateRandomString(8));
//		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastName']"));
//		String last_name=lastname.getAttribute("value");
//		System.out.println("lastname before update is   "+last_name);
//		lastname.clear();
//		lastname.sendKeys(generateRandomString(9));
//		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
//		String user_name=username.getAttribute("value");
//		System.out.println("username is  "+ user_name );
//		WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
//		String email_id=email.getAttribute("value");
//		System.out.println("email id is  "+email_id);
//		
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(3000);
//		
//		WebElement firstname1=driver.findElement(By.xpath("//input[@name='firstName']"));
//		String first_name1=firstname1.getAttribute("value");
//		System.out.println("firstname after update is  "+first_name1);
//		
//		WebElement lastname1 = driver.findElement(By.xpath("//input[@name='lastName']"));
//		String last_name1=lastname1.getAttribute("value");
//		System.out.println("lastname after update is   "+last_name1);
		
	}

	
		  public String generateRandomString(int length) {
			  return RandomStringUtils.randomAlphabetic(length);
			 }
	
	
	@BeforeTest
	public void setup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bala\\Downloads\\chromedriver_2.37\\chromedriver2.37.exe");
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
		System.out.println("password is entered");
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
