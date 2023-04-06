package com.test2;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaAppTest {
    WebDriver driver;
    @Test
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");
        System.out.println("App has been opened in the Browser");
    }
    @Test(dependsOnMethods = "setUp")
    public   void registerMethod(){
    WebElement rgster=driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]"));
    rgster.click();  
    System.out.println("Register Link has been clicked");
    }

    @Test(dependsOnMethods ="registerMethod" )
    public void fillForm() throws InterruptedException{
        WebElement fname=driver.findElement(By.name("firstName"));
        fname.sendKeys("Neha");
        WebElement lname=driver.findElement(By.name("lastName"));
        lname.sendKeys("Jangra");
        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("9123456789");
        WebElement email=driver.findElement(By.name("userName"));
        email.sendKeys("abc@gmail.com");
        WebElement address=driver.findElement(By.name("address1"));
       address.sendKeys("Phase 4 Mohali");
       WebElement city=driver.findElement(By.name("city"));
       city.sendKeys("Mohali");
       WebElement state=driver.findElement(By.name("state"));
       state.sendKeys("Punjab");
       WebElement postalCode=driver.findElement(By.name("postalCode"));
       postalCode.sendKeys("160059");
       WebElement country=driver.findElement(By.name("country"));
       country.sendKeys("India");
       WebElement username=driver.findElement(By.name("email"));
       username.sendKeys("abc@123");
       WebElement password=driver.findElement(By.name("password"));
       password.sendKeys("123");
       WebElement cpassword=driver.findElement(By.name("confirmPassword"));
       cpassword.sendKeys("123");
       Thread.sleep(2000);
       WebElement submit=driver.findElement(By.name("submit"));
       submit.click();

       Thread.sleep(2000);
       System.out.println("Details has been filled out");
    }

    @Test(dependsOnMethods = "fillForm")
    public void signIn() throws InterruptedException {
        WebElement signin=driver.findElement(By.xpath("//a[contains(text(),'sign-in')]"));
        signin.click();
        Thread.sleep(2000);
        WebElement adds=driver.findElement(By.xpath("//iframe[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']"));
        adds.click();
        Thread.sleep(2000);
        // WebElement username=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
        // username.sendKeys("abc@123");
        // WebElement password1=driver.findElement(By.name("password"));
        // password1.sendKeys("123");
        // Thread.sleep(2000);
        // WebElement submit=driver.findElement(By.name("submit"));
        // submit.click();


        System.out.println("Sign In Has Done");

    }
    @Test(dependsOnMethods = "fillForm")
    public void teardown() {
        driver.close();
        driver.quit();
        System.out.println("Browser has been closed");

        
    }
    
}
