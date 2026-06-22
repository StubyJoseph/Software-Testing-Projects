package com.OpenCartAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareProducts extends BaseClass {

    @Test(priority = 3)
    public void compareProducts() throws InterruptedException {
    	
        // Search for Mac products
        driver.findElement(By.name("search")).sendKeys("Mac");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();

        Thread.sleep(2000);

        // Add MacBook to compare
        driver.findElement(By.linkText("MacBook")).click();
        Thread.sleep(1000);
        // Use the correct locator for "Add to Compare"
        driver.findElement(By.xpath("//button[@data-original-title='Compare this Product']")).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        // Add MacBook Pro to compare
        driver.findElement(By.linkText("MacBook Pro")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@data-original-title='Compare this Product']")).click();
        Thread.sleep(1000);

        // Go to product comparison page
        driver.findElement(By.linkText("product comparison")).click();
        Thread.sleep(2000);

        // Assert both products are present
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("MacBook"), "MacBook not found in comparison");
        Assert.assertTrue(pageSource.contains("MacBook Pro"), "MacBook Pro not found in comparison");

        System.out.println("Compare Products Passed");
    }
}