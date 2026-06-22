package com.parabank;

import org.openqa.selenium.By;

public class TransferFundsTest {

    // Transfer Funds
    public static void transferFunds() throws InterruptedException {

        BaseClass.openBrowser();
        Thread.sleep(3000);

        // Login
        BaseClass.driver.findElement(By.name("username")).sendKeys("stuby111");

        BaseClass.driver.findElement(By.name("password")).sendKeys("demo123");

        BaseClass.driver.findElement(By.xpath("//input[@value='Log In']")).click();

        Thread.sleep(5000);

        // Click Transfer Funds
        BaseClass.driver.findElement(By.linkText("Transfer Funds")).click();

        Thread.sleep(3000);

        // Enter Amount
        BaseClass.driver.findElement(By.id("amount")).sendKeys("1000");

        // Click Transfer Button
        BaseClass.driver.findElement(By.xpath("//input[@value='Transfer']")).click();

        Thread.sleep(5000);

        System.out.println("Funds Transfer Successful");

        BaseClass.closeBrowser();
    }



    // Invalid Amount
    public static void invalidAmountTransfer() throws InterruptedException {

        BaseClass.openBrowser();
        Thread.sleep(3000);

        // Login
        BaseClass.driver.findElement(By.name("username")).sendKeys("stuby111");

        BaseClass.driver.findElement(By.name("password")).sendKeys("demo123");

        BaseClass.driver.findElement(By.xpath("//input[@value='Log In']")).click();

        Thread.sleep(5000);

        // Click Transfer Funds
        BaseClass.driver.findElement(By.linkText("Transfer Funds")).click();

        Thread.sleep(3000);

        // Enter Invalid Amount
        BaseClass.driver.findElement(By.id("amount")).sendKeys("abc");

        // Click Transfer
        BaseClass.driver.findElement(By.xpath("//input[@value='Transfer']")).click();

        Thread.sleep(5000);

        System.out.println("Invalid Amount Tested");

        BaseClass.closeBrowser();
    }



    public static void main(String[] args) throws InterruptedException {

        transferFunds();

        Thread.sleep(5000);

        invalidAmountTransfer();
    }
}