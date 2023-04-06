package com.test2;

import java.util.concurrent.TimeUnit;
import javax.swing.Popup;
import javax.xml.xpath.XPath;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProAppTest {
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
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);

            WebElement fname=driver.findElement(By.name("firstName"));
            fname.sendKeys(prop.getProperty("fname"));
            WebElement lname=driver.findElement(By.name("lastName"));
            lname.sendKeys(prop.getProperty("lname"));
            WebElement phone=driver.findElement(By.name("phone"));
            phone.sendKeys(prop.getProperty("phone"));
            WebElement email=driver.findElement(By.name("userName"));
            email.sendKeys(prop.getProperty("email"));
            WebElement address=driver.findElement(By.name("address1"));
            address.sendKeys(prop.getProperty("address"));
            WebElement city=driver.findElement(By.name("city"));
            city.sendKeys(prop.getProperty("city"));
            WebElement state=driver.findElement(By.name("state"));
            state.sendKeys(prop.getProperty("state"));
            WebElement postalCode=driver.findElement(By.name("postalCode"));
            postalCode.sendKeys(prop.getProperty("postalCode"));
            WebElement country=driver.findElement(By.name("country"));
            country.sendKeys(prop.getProperty("country"));
            WebElement username=driver.findElement(By.name("email"));
            username.sendKeys(prop.getProperty("username"));
            WebElement password=driver.findElement(By.name("password"));
            password.sendKeys(prop.getProperty("password"));
            WebElement cpassword=driver.findElement(By.name("confirmPassword"));
            cpassword.sendKeys(prop.getProperty("cpassword"));
            Thread.sleep(2000);
            WebElement submit=driver.findElement(By.name("submit"));
            submit.click();

            Thread.sleep(2000);
            System.out.println("Details has been filled out");
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }




    @Test(dependsOnMethods = "fillForm")
    public void signInClick() throws InterruptedException {
        WebElement signin=driver.findElement(By.xpath("//a[contains(text(),'sign-in')]"));
        signin.click();
        System.out.println("Sign In Has Done");
        // implicitWait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }



    @Test(dependsOnMethods = "signInClick")
    public void addClose() {
        try{
            WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
            driver.switchTo().frame(frame1);
            driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
            driver.switchTo().defaultContent();
            System.out.println("Add closed");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Add ");
            try{
                driver.switchTo().frame(0);
                driver.close();
            }
            finally{
                System.out.println("Add Resolved");

            }    
        }
    }




    @Test(dependsOnMethods = "addClose")
    public void signIn() throws InterruptedException {
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            Thread.sleep(2000);
            WebElement username=driver.findElement(By.name("userName"));
            username.sendKeys(prop.getProperty("username"));
            WebElement password1=driver.findElement(By.name("password"));
            password1.sendKeys(prop.getProperty("password"));
            Thread.sleep(2000);
            WebElement submit=driver.findElement(By.name("submit"));
            submit.click();//a[contains(text(),'SIGN-OFF')]
            System.out.println("Log In Done");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }  
    }




    @Test(dependsOnMethods = "signIn")
    public void signOut() throws InterruptedException {
        //Explicit wait
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'SIGN-OFF')]")));
        WebElement signOff=driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]"));
        signOff.click();
        System.out.println("Sign Out Done");
    }


    @Test(dependsOnMethods = "signOut")
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
        System.out.println("Browser has been closed");     
    }
    
}

