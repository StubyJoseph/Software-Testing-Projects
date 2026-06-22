package com.OpenCartAutomation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCart extends BaseClass {

    @Test(priority = 2)
    public void addToCart() throws InterruptedException {
      

        // Search for MacBook
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("MacBook");
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
        Thread.sleep(2000);

        // Open MacBook product
        driver.findElement(By.linkText("MacBook")).click();
        Thread.sleep(2000);

        // Add product to cart
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(2000);

        // Verify success message
        boolean success = driver.getPageSource().contains("Success");
        Assert.assertTrue(success, "Add To Cart Failed");

        System.out.println("Add To Cart Test Passed");
    }
}