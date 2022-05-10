package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_cssSelector {
    public static void main(String[] args) {
        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        //3- Verify “Log in” button text is as expected:
        //Expected: Log In

        //tagName[attribute='value']
        //input[class='login-btn']
        //LOCATED BY USING CLASS ATTRIBUTE
        //WebElement signInButton= driver.findElement(By.cssSelector("input[class='login-btn']"));
        //LOCATED BY USING TYPE ATTRIBUTE
        //WebElement signInButton= driver.findElement(By.cssSelector("input[type='submit']"));

        //LOCATED BY USING VALUE ATTRIBUTE
        WebElement signInButton= driver.findElement(By.cssSelector("input[value='Log In']"));
        String expectedButton = "Log In";

        //Getting the value of attribute "value"
        String actualButton=signInButton.getAttribute("value");

        if (actualButton.equals(expectedButton)) {
            System.out.println("Log In button verification Passed!");
        }else{
            System.out.println("Log In button verification FAILED!!!");
        }




        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from
    }
}
