// package com.test2;


// import java.util.concurrent.TimeUnit;

// import javax.swing.Popup;
// import javax.xml.xpath.XPath;

// import org.openqa.selenium.Alert;
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.testng.annotations.*;
// import java.io.FileInputStream;
// import java.io.IOException;
// import java.io.InputStream;
// import java.util.Properties;

// import io.github.bonigarcia.wdm.WebDriverManager;

// public class LoginTest {
//     WebDriver driver;
//     @Test
//     public void setUp(){
//         WebDriverManager.chromedriver().setup();
//         driver=new ChromeDriver();
//         driver.manage().window().maximize();
//         driver.get("https://demo.guru99.com/test/newtours/login.php");
//         System.out.println("App has been opened in the Browser");
//     }

//     @Test
//     public void sign() throws InterruptedException {
//         WebElement username=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
//         username.sendKeys("abc@123");
//         WebElement password1=driver.findElement(By.name("password"));
//         password1.sendKeys("123");
//         Thread.sleep(2000);
//         WebElement submit=driver.findElement(By.name("submit"));
//         submit.click();//a[contains(text(),'SIGN-OFF')]
//         System.out.println("Sign In Done");

        
//     }

//     @Test(dependsOnMethods = "sign")
//     public void signOut() throws InterruptedException {
//         WebElement signOff=driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]"));
//         signOff.click();
//         Thread.sleep(2000);
//         System.out.println("Sign Out Done");

//     }


//     @Test(dependsOnMethods = "signOut")
//     public void teardown() {
//         // driver.close();
//         // driver.quit();
//         System.out.println("Browser has been closed");
//     }

// }
