package miniprojectpackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SwagLab {
	 public static void main(String[] args) throws InterruptedException {
            
		    

	        // Launch browser
		    WebDriver driver = new FirefoxDriver();
		    
		    
	        driver.manage().window().maximize();
	        
	        // Open Swag Labs
	        driver.get("https://www.saucedemo.com/");
	        
	        

	        // Login
	        driver.findElement(By.id("user-name")).sendKeys("standard_user");
	        driver.findElement(By.id("password")).sendKeys("secret_sauce");
	        Thread.sleep(1000);
	        driver.findElement(By.id("login-button")).click();
	        
	        Thread.sleep(1000);
	        // Add product to cart
	        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	        
	        Thread.sleep(1000);
	        
	        // Verify cart count
	        String count = driver.findElement(By.className("shopping_cart_badge")).getText();
	        System.out.println("Cart count = " + count);
           
	        
	        // Open cart
	        driver.findElement(By.className("shopping_cart_link")).click();
	        
	        Thread.sleep(2000);
	        
	        // Checkout
	        driver.findElement(By.id("checkout")).click();
	      
	        
	        // Enter details
	        driver.findElement(By.id("first-name")).sendKeys("Stuby");
	        driver.findElement(By.id("last-name")).sendKeys("Joseph");
	        driver.findElement(By.id("postal-code")).sendKeys("680001");
	        Thread.sleep(2000);
	        driver.findElement(By.id("continue")).click();
	        
	        Thread.sleep(2000);
	        
	        // Finish order
	        driver.findElement(By.id("finish")).click();
	        
	        Thread.sleep(2000);
	        
	        // Print success message
	        String msg = driver.findElement(By.className("complete-header")).getText();
	        System.out.println(msg);
	        Thread.sleep(1000);
	        
	        // Close browser
	        driver.quit();
	    }

}
