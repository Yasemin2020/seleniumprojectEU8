package com.cydeo.tests.day10_upload_actions_jsexecuter;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T6_JavascriptExecuter {
@Test
    public void javascript_executer_test1(){
    //1- Open a chrome browser
    //2- Go to: https://practice.cydeo.com/infinite_scroll
    Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");


    //3- Use below JavaScript method and scroll
    for (int i = 0; i < 10; i++) {


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(1);
        //x,y
        js.executeScript("window.scrollBy(0,750)");
        // ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,750)"); write it iin one line
    }



}

}


//a.  750 pixels down 10 times.
//b.  750 pixels up 10 times
//
//JavaScript method to use : window.scrollBy(0,0)