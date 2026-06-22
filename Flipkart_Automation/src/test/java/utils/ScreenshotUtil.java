package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String fileName) {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        File destination = new File("./screenshots/" + fileName + ".png");

        try {

            FileUtils.copyFile(source, destination);

            System.out.println("Screenshot saved");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}