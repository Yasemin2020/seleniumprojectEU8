package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {
    public static void main(String[] args) {
        // TC #1: Yahoo Title Verification
        // do setup for browser driver
        WebDriverManager.chromedriver().setup();

        //1. Open Chrome Browser
        WebDriver driver= new ChromeDriver();

        //make our page fullscreen
        driver.manage().window().maximize();

        //2.Go to https://www.yahoo.com
        driver.get("https://www.yahoo.com");

        //3. Verify Title
        //Expected:Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports &amp; Videos
        String expectedTitle="Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";
        String actualTitle= driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title is as expected. Verification PASSED ");
        }else{
            System.out.println("Title is not as expected. Verification FAILED");
        }

        driver.close();

    }
}
