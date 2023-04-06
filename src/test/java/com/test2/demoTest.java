package com.test2;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class demoTest {
    @Test
    public void start(){
        System.out.println("demoTest \"start method\"");
    }
    // @BeforeMethod
    // public void process(){
    //     System.out.println("demoTest Started");
    // }
    // @AfterMethod
    // public void end(){
    //     System.out.println("demoTest Ended");
 
    // }
    @Test(groups = {"TestGroup"})
    public void end(){
            System.out.println("demoTest \"end method\"Started");
        }
        @Test(groups = {"TestGroup"})
        public void process(){
                System.out.println("demoTest \"process method\" Started");
            }
}
