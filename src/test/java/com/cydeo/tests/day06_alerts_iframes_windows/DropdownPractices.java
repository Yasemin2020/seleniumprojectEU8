package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class DropdownPractices {
    public static void main(String[] args) {
        //TC #5: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cydeo.com/dropdown
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //3. Select Illinois
        //4. Select Virginia
        //5. Select California
        //6. Verify final selected option is California.
        //Use all Select options. (visible text, value, index)


    }
}
