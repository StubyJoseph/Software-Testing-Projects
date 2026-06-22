package com.OpenCartAutomation;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    protected WebDriver driver;

    @BeforeClass
    public void setup() {
    	
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
    }

    @BeforeMethod
	public void openApplication()throws InterruptedException {
		
        driver.get("https://opencart.abstracta.us/");
        Thread.sleep(1000);        
    }

    @AfterClass
    public void tearDown() {
        
            driver.quit();
        
    }
}