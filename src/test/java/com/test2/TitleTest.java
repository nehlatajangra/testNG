package com.test2;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class TitleTest {
	WebDriver driver ;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
	    String baseUrl = "https://demo.guru99.com/test/newtours/";   
		System.out.println("Launching Google Chrome browser"); 
		driver.get(baseUrl);
	        
  }
	
	@Test(priority = 1)
	public void checkTitle() {
		String testTitle = "Welcome: Mercury Tours";
	    String originalTitle = driver.getTitle();
	    Assert.assertEquals(originalTitle, testTitle);
		System.out.println(originalTitle);
		System.out.println("Starting Test On Chrome Browser");
	}
	
	@AfterTest
	public void teardown() {
	
		 driver.close();
		 driver.quit();
		System.out.println("Finished Test On Chrome Browser");
	}
}
