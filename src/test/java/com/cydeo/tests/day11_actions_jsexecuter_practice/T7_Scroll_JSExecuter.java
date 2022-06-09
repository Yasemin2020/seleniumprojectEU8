package com.cydeo.tests.day11_actions_jsexecuter_practice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_Scroll_JSExecuter {

    @Test
    public void task7_scroll_test(){
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        //3- Scroll down to “Cydeo” link

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", cydeoLink);


        //4- Scroll up to “Home” link
        BrowserUtils.sleep(3);
        js.executeScript("arguments[1].scrollIntoView(true)", cydeoLink, homeLink);
        //5- Use below provided JS method only
    }

}



//JavaScript method to use : arguments[0].scrollIntoView(true)
//Note: You need to locate the links as web elements and pass them as
//arguments into executeScript() method