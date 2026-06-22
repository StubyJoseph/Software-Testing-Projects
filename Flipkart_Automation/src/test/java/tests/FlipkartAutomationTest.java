
package tests;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import utils.ScreenshotUtil;

public class FlipkartAutomationTest extends BaseClass {

	// Task 1: Verify Website Title

	@Test(priority = 1)
	public void verifyTitle() {

		String title = driver.getTitle();
        System.out.println("Website Title : " + title);
        Assert.assertFalse(title.isEmpty());
        System.out.println("Title Verified Successfully");
	}


	
	
	
	// Task 2: Handle Login Popup & Search Product
	@Test(priority = 2)
	public void searchProduct() throws InterruptedException {
		// Wait for and close Login Popup if present
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.b3wTlE")));
			Thread.sleep(3000);
			closeBtn.click();
			Thread.sleep(2000); // Allow popup to close
			System.out.println("Login Popup Closed");
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Login Popup Not Displayed");
		}
		// Search Product
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.click();
		Thread.sleep(3000);
		searchBox.sendKeys("iphone");
		Thread.sleep(3000);
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		System.out.println("Product Search Successful");
	}

	
	
	
	
	
	// Task 3: Print Product Names
	@Test(priority = 3)
	public void printProducts() throws InterruptedException {

		List<WebElement> products = driver.findElements(By.xpath("//div[contains(text(),'iPhone')]"));
		System.out.println("Total Products Found : " + products.size());
		for (int i = 0; i < Math.min(products.size(), 5); i++) {
			System.out.println(products.get(i).getText());
		}
		Assert.assertTrue(products.size() > 0);
		System.out.println("Products Printed Successfully");
	}

	
	
	
	
	// Task 4: Mouse Hover and Click on Electronics
	@Test(priority = 4)
	public void mouseHoverElectronics() throws InterruptedException {

		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Electronics Menu
		WebElement electronics = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Electronics')]")));
		// Mouse Hover on Electronics
		action.moveToElement(electronics).perform();
		System.out.println("Mouse Hover Successful");
		Thread.sleep(3000); // Search Box
		WebElement searchBox = driver.findElement(By.name("q"));
		// Move Mouse to Search Box
		action.moveToElement(searchBox).perform();
		Thread.sleep(2000);
		System.out.println("Mouse Hover Closed Successfully");
	}

	
	
	
	
	
	// Task 5: Click First Product and Handle Window
	@Test(priority = 5)
	public void clickFirstProduct() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		List<WebElement> products = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'iPhone')]")));
		Assert.assertTrue(products.size() > 0);
		String parentWindow = driver.getWindowHandle();
		// Click Product
		products.get(0).click();
		System.out.println("Product Clicked Successfully");
		// Wait for New Tab
		Thread.sleep(10000);
		Set<String> allWindows = driver.getWindowHandles();
		// Switch to New Window
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}				
		System.out.println("Switched To Product Window");

	}

	
	
	
	
	
	// Task 6 : Verify Product Details
	@Test(priority = 6)
	public void verifyProductDetails() {

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			// Wait for product page URL
			wait.until(ExpectedConditions.urlContains("flipkart.com"));
            System.out.println("Current URL : " + driver.getCurrentUrl());

			// Product Name
			WebElement productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
            String name = productName.getText();

			// Product Price
			WebElement productPrice = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'₹')]")));
            String price = productPrice.getText();
            System.out.println("Product Name : " + name);
			System.out.println("Product Price : " + price);

			Assert.assertFalse(name.isEmpty());
            System.out.println("Product Details Verified");

		} catch (Exception e) {

			System.out.println("Unable To Fetch Product Details");
			e.printStackTrace();

			Assert.fail("Product Details Verification Failed");
		}
	}

	
	
	// Task 7: Take Screenshot and Close Browser
	@Test(priority = 7)
	public void takeScreenshot() {
		ScreenshotUtil.takeScreenshot(driver, "flipkart_search");
		System.out.println("Screenshot Captured Successfully");
		// Close Browser
		driver.quit();

		System.out.println("Browser Closed Successfully");
	}

}
