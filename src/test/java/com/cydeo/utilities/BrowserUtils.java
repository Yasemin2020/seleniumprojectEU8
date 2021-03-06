package com.cydeo.utilities;
/*
In this class only general utility methods that are NOT related to some specific page.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class BrowserUtils {
    /*
    This method will accept int (in seconds) and execute Thread.sleep for given duration
     */
    public static void sleep(int second){
        second *=1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }
      /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */

    public static void switchWindowAndVerify(WebDriver driver, String expectedURL, String expectedInTitle){
        for (String windowHandle : driver.getWindowHandles()) {

            driver.switchTo().window(windowHandle);
            System.out.println("Current URL: "+ driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedURL)){
                break;
            }

        }
        // Assert: Title contains “expectedInTitle”
        String actualTitle=driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle) );

    }

 /*
    This method accepts a String "expectedTitle" and Asserts if it is true
     */

    public static void verifyTitle(WebDriver driver ,String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);

    }

    public static void waitForInvisibilityOf(WebElement webelement){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);//turn off the implicit wait before explicit wait
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webelement));
    }



}
