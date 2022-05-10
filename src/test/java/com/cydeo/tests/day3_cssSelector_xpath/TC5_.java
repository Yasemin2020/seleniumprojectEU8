package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC5_ {
    public static void main(String[] args) {
        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        //3- Enter incorrect username into login box:
        WebElement loginButton = driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));
        loginButton.sendKeys("incorrect"+ Keys.ENTER);
        //4- Click to `Reset password` button
        WebElement resetButton = driver.findElement(By.cssSelector("button[class='login-btn']"));
        resetButton.click();
        //5- Verify “error” label is as expected
        //Expected: Login or E-mail not found
        WebElement errorMessage = driver.findElement(By.cssSelector("div[class='errortext']"));


        String expectedErrorMessage="Login or E-mail not found";
        String actualErrorMessage=errorMessage.getText();

        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Reset button verification Passed!");
        }else{
            System.out.println("Reset button verification FAILED!!!");
        }

        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
    }
}
