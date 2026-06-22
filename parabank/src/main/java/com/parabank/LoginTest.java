package com.parabank;

import org.openqa.selenium.By;

public class LoginTest {

   
	// 1. Valid Login
    public static void validLogin() throws InterruptedException {

        BaseClass.openBrowser();
        Thread.sleep(3000);

        BaseClass.driver.findElement(By.name("username")).sendKeys("stuby111");

        Thread.sleep(2000);

        BaseClass.driver.findElement(By.name("password")).sendKeys("demo123");

        Thread.sleep(2000);

        BaseClass.driver.findElement(By.xpath("//input[@value='Log In']")).click();

        Thread.sleep(5000);

        String text = BaseClass.driver.findElement(By.xpath("//h1")).getText();

        System.out.println(text);

        BaseClass.closeBrowser();
    }



    // 2. Invalid Password
    public static void invalidPasswordLogin() throws InterruptedException {

        BaseClass.openBrowser();
        Thread.sleep(3000);

        BaseClass.driver.findElement(By.name("username")).sendKeys("stuby111");

        BaseClass.driver.findElement(By.name("password")).sendKeys("wrong123");

        BaseClass.driver.findElement(By.xpath("//input[@value='Log In']")).click();

        Thread.sleep(5000);

        String error = BaseClass.driver.findElement(By.className("error")).getText();

        System.out.println(error);

        BaseClass.closeBrowser();
    }



    // 3. Empty Username or Password
    public static void emptyUsernameOrPasswordLogin() throws InterruptedException {

        // Empty Username
        BaseClass.openBrowser();
        Thread.sleep(3000);

        BaseClass.driver.findElement(By.name("password")).sendKeys("demo123");

        BaseClass.driver.findElement(By.xpath("//input[@value='Log In']")).click();

        Thread.sleep(5000);

        String error1 = BaseClass.driver.findElement(By.className("error")).getText();

        System.out.println(error1);

        BaseClass.closeBrowser();



        // Empty Password
        BaseClass.openBrowser();
        Thread.sleep(3000);

        BaseClass.driver.findElement(By.name("username")).sendKeys("stuby111");

        BaseClass.driver.findElement(By.xpath("//input[@value='Log In']")).click();

        Thread.sleep(5000);

        String error2 = BaseClass.driver.findElement(By.className("error")).getText();

        System.out.println(error2);

        BaseClass.closeBrowser();
    }



    public static void main(String[] args) throws InterruptedException {

        validLogin();

        invalidPasswordLogin();

        emptyUsernameOrPasswordLogin();
    }
}