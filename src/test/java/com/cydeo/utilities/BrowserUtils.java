package com.cydeo.utilities;
/*
In this class only general utility methods that are NOT related to some specific page.
 */

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserUtils {
    /*
    This method will accept int (in seconds) and execute Thread.sleep for given duration
     */
    public void sleep(int second){
        second *=1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedURL, String expectedInTitle){
        for (String windowHandle : driver.getWindowHandles()) {

            driver.switchTo().window(windowHandle);
            System.out.println("Current URL: "+ driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedURL)){
                break;
            }

        }
        //5. Assert: Title contains “Etsy”
        String actualTitle=driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle) );

    }

}
