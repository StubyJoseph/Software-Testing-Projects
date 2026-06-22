package com.parabank;

import org.openqa.selenium.By;

public class BillPayTest {

    // 1. Pay Bill with Valid Details
    public static void validBillPay() throws InterruptedException {

        // Open Browser
        BaseClass.openBrowser();

        Thread.sleep(3000);

        // Enter Username
        BaseClass.driver.findElement(By.name("username")).sendKeys("stuby111");

        Thread.sleep(2000);

        // Enter Password
        BaseClass.driver.findElement(By.name("password")).sendKeys("demo123");

        Thread.sleep(2000);

        // Click Login Button
        BaseClass.driver.findElement(By.xpath("//input[@value='Log In']")).click();

        Thread.sleep(5000);

        // Click Bill Pay Link
        BaseClass.driver.findElement(By.linkText("Bill Pay")).click();

        Thread.sleep(3000);

        // Enter Payee Name
        BaseClass.driver.findElement(By.name("payee.name")).sendKeys("John");

        Thread.sleep(2000);

        // Enter Address
        BaseClass.driver.findElement(By.name("payee.address.street")).sendKeys("Kochi");

        Thread.sleep(2000);

        // Enter City
        BaseClass.driver.findElement(By.name("payee.address.city")).sendKeys("Ernakulam");

        Thread.sleep(2000);

        // Enter State
        BaseClass.driver.findElement(By.name("payee.address.state")).sendKeys("Kerala");

        Thread.sleep(2000);

        // Enter Zip Code
        BaseClass.driver.findElement(By.name("payee.address.zipCode")).sendKeys("682001");

        Thread.sleep(2000);

        // Enter Phone Number
        BaseClass.driver.findElement(By.name("payee.phoneNumber")).sendKeys("9876543210");

        Thread.sleep(2000);

        // Enter Account Number
        BaseClass.driver.findElement(By.name("payee.accountNumber")).sendKeys("12345");

        Thread.sleep(2000);

        // Confirm Account Number
        BaseClass.driver.findElement(By.name("verifyAccount")).sendKeys("12345");

        Thread.sleep(2000);

        // Enter Amount
        BaseClass.driver.findElement(By.name("amount")).sendKeys("500");

        Thread.sleep(2000);

        // Click Send Payment Button
        BaseClass.driver.findElement(By.xpath("//input[@value='Send Payment']")).click();

        Thread.sleep(5000);

        // Print Message
        System.out.println("Bill Payment Successful");

        // Close Browser
        BaseClass.closeBrowser();
    }


    
    

 // 2. Enter Invalid Account Number
    public static void invalidAccountNumberBillPay() throws InterruptedException {

        // Open Browser
        BaseClass.openBrowser();

        Thread.sleep(3000);

        // Enter Username
        BaseClass.driver.findElement(By.name("username")).sendKeys("stuby111");

        Thread.sleep(2000);

        // Enter Password
        BaseClass.driver.findElement(By.name("password")).sendKeys("demo123");

        Thread.sleep(2000);

        // Click Login Button
        BaseClass.driver.findElement(By.xpath("//input[@value='Log In']"))
                .click();

        Thread.sleep(5000);

        // Click Bill Pay Link
        BaseClass.driver.findElement(By.linkText("Bill Pay"))
                .click();

        Thread.sleep(3000);

        // Enter Payee Name
        BaseClass.driver.findElement(By.name("payee.name")).sendKeys("John");

        Thread.sleep(1000);

        // Enter Address
        BaseClass.driver.findElement(By.name("payee.address.street")).sendKeys("Kochi");

        Thread.sleep(1000);

        // Enter City
        BaseClass.driver.findElement(By.name("payee.address.city")).sendKeys("Ernakulam");

        Thread.sleep(1000);

        // Enter State
        BaseClass.driver.findElement(By.name("payee.address.state")).sendKeys("Kerala");

        Thread.sleep(1000);

        // Enter Zip Code
        BaseClass.driver.findElement(By.name("payee.address.zipCode")).sendKeys("682001");

        Thread.sleep(1000);

        // Enter Phone Number
        BaseClass.driver.findElement(By.name("payee.phoneNumber")).sendKeys("9876543210");

        Thread.sleep(1000);

        // Enter Invalid Account Number
        BaseClass.driver.findElement(By.name("payee.accountNumber")).sendKeys("abc");

        Thread.sleep(1000);

        // Confirm Invalid Account Number
        BaseClass.driver.findElement(By.name("verifyAccount")).sendKeys("xyz");

        Thread.sleep(1000);

        // Enter Amount
        BaseClass.driver.findElement(By.name("amount")).sendKeys("500");

        Thread.sleep(1000);

        // Click Send Payment Button
        BaseClass.driver.findElement(By.xpath("//input[@value='Send Payment']")).click();

        Thread.sleep(5000);

        // Capture Result Message
        String result = BaseClass.driver.findElement(By.xpath("//h1")).getText();

        // Print Result
        System.out.println("Result : " + result);

        // Close Browser
        BaseClass.closeBrowser();
    }




    public static void main(String[] args) throws InterruptedException {

        // Run Valid Bill Pay
        validBillPay();

        Thread.sleep(5000);

        // Run Invalid Account Number Scenario
        invalidAccountNumberBillPay();
    }
}