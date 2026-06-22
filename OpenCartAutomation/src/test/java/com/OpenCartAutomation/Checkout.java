package com.OpenCartAutomation;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkout extends BaseClass {

    @Test(priority = 4)
    public void checkoutProcessTest() throws InterruptedException {
       

        // Search for MacBook
        driver.findElement(By.name("search")).sendKeys("MacBook");
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
        Thread.sleep(2000);

        // Open MacBook product
        driver.findElement(By.linkText("MacBook")).click();
        Thread.sleep(2000);

        // Add product to cart
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(2000);

        // Navigate to cart page
        driver.findElement(By.xpath("//a[contains(@title,'Shopping Cart')]")).click();
        Thread.sleep(2000);
        

        // Click checkout
        driver.findElement(By.linkText("Checkout")).click();
        Thread.sleep(2000);

        // Verify checkout page
        Assert.assertTrue(driver.getTitle().contains("Checkout"), "Checkout Page Not Displayed");

        System.out.println("Checkout Process Test Passed");
    }
}