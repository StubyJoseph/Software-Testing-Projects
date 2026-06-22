package com.parabank;

import org.openqa.selenium.By;

public class RegistrationTest {

    // 1. Valid Registration
    public static void validRegistration() throws InterruptedException {

        BaseClass.openBrowser();
        Thread.sleep(3000);

        BaseClass.driver.findElement(By.linkText("Register")).click();
        Thread.sleep(2000);

        BaseClass.driver.findElement(By.id("customer.firstName")).sendKeys("Stuby");
        Thread.sleep(1000);

        BaseClass.driver.findElement(By.id("customer.lastName")).sendKeys("Joseph");
        Thread.sleep(1000);

        BaseClass.driver.findElement(By.id("customer.address.street")).sendKeys("Kochi");
        Thread.sleep(1000);

        BaseClass.driver.findElement(By.id("customer.address.city")).sendKeys("Ernakulam");
        Thread.sleep(1000);

        BaseClass.driver.findElement(By.id("customer.address.state")).sendKeys("Kerala");
        Thread.sleep(1000);

        BaseClass.driver.findElement(By.id("customer.address.zipCode")).sendKeys("682001");
        Thread.sleep(1000);

        BaseClass.driver.findElement(By.id("customer.phoneNumber")).sendKeys("9876543210");
        Thread.sleep(1000);

        BaseClass.driver.findElement(By.id("customer.ssn")).sendKeys("12345");
        Thread.sleep(1000);

        BaseClass.driver.findElement(By.id("customer.username")).sendKeys("stuby111");
        Thread.sleep(1000);

        BaseClass.driver.findElement(By.id("customer.password")).sendKeys("demo123");
        Thread.sleep(1000);

        BaseClass.driver.findElement(By.id("repeatedPassword")).sendKeys("demo123");
        Thread.sleep(1000);

        BaseClass.driver.findElement(By.xpath("//input[@value='Register']")).click();

        Thread.sleep(3000);

        System.out.println("Registration Successful");

        BaseClass.closeBrowser();
    }


    

    // 2. Missing Fields
    public static void missingFieldsRegistration() throws InterruptedException {

        BaseClass.openBrowser();
        Thread.sleep(3000);

        BaseClass.driver.findElement(By.linkText("Register")).click();
        Thread.sleep(2000);

        BaseClass.driver.findElement(By.id("customer.firstName")).sendKeys("Stuby");
        Thread.sleep(1000);

        BaseClass.driver.findElement(By.xpath("//input[@value='Register']")).click();

        Thread.sleep(3000);

        System.out.println("Missing Fields Tested");

        BaseClass.closeBrowser();
    }

    


  // 3. Register with Existing Username
    public static void existingUsernameRegistration()throws InterruptedException {

        // Open Browser
        BaseClass.openBrowser();

        Thread.sleep(3000);

        // Click Register Link
        BaseClass.driver.findElement(By.linkText("Register")).click();

        Thread.sleep(2000);

        // Enter First Name
        BaseClass.driver.findElement(By.id("customer.firstName")).sendKeys("Mary");

        Thread.sleep(1000);

        // Enter Last Name
        BaseClass.driver.findElement(By.id("customer.lastName")).sendKeys("Joseph");

        Thread.sleep(1000);

        // Enter Address
        BaseClass.driver.findElement(By.id("customer.address.street")).sendKeys("Kochi");

        Thread.sleep(1000);

        // Enter City
        BaseClass.driver.findElement(By.id("customer.address.city")).sendKeys("Ernakulam");

        Thread.sleep(1000);

        // Enter State
        BaseClass.driver.findElement(By.id("customer.address.state")).sendKeys("Kerala");

        Thread.sleep(1000);

        // Enter Zip Code
        BaseClass.driver.findElement(By.id("customer.address.zipCode")).sendKeys("682001");

        Thread.sleep(1000);

        // Enter Phone Number
        BaseClass.driver.findElement(By.id("customer.phoneNumber")).sendKeys("9876543210");

        Thread.sleep(1000);

        // Enter SSN
        BaseClass.driver.findElement(By.id("customer.ssn")).sendKeys("12345");

        Thread.sleep(1000);

        // Existing Username
        BaseClass.driver.findElement(By.id("customer.username")).sendKeys("stuby111");

        Thread.sleep(1000);

        // Enter Password
        BaseClass.driver.findElement(By.id("customer.password")).sendKeys("demo123");

        Thread.sleep(1000);

        // Confirm Password
        BaseClass.driver.findElement(By.id("repeatedPassword")).sendKeys("demo123");

        Thread.sleep(1000);

        // Click Register Button
        BaseClass.driver.findElement(By.xpath("//input[@value='Register']")).click();

        Thread.sleep(3000);

        // Capture Error Message
        String errorMessage = BaseClass.driver.findElement(By.id("customer.username.errors")).getText();

        // Print Error Message
        System.out.println("Error Message : " + errorMessage);

      
        BaseClass.closeBrowser();
    }



    public static void main(String[] args)throws InterruptedException {
    	
    	validRegistration();
    	missingFieldsRegistration();
        existingUsernameRegistration();
    }
}