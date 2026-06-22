package com.OpenCartAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProduct extends BaseClass {

    @Test(priority = 1)
    public void searchProduct() throws InterruptedException {
        // Search for "Mac"
        driver.findElement(By.name("search")).sendKeys("Mac");
        Thread.sleep(2000);

        // Click Search Button
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
        Thread.sleep(3000);

        // Open MacBook Product
        driver.findElement(By.linkText("MacBook")).click();
        Thread.sleep(3000);

        // Verify Product Displayed
        Assert.assertTrue(driver.getPageSource().contains("MacBook"), "MacBook not displayed in product details.");

        System.out.println("MacBook Details Displayed Successfully");
    }
}