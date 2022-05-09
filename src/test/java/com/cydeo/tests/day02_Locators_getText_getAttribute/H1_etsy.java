package com.cydeo.tests.day02_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H1_etsy {
    public static void main(String[] args) {
        //TC #1: Etsy Title Verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to
        driver.get("https://www.etsy.com");

        //3. Search for “wooden spoon”
        WebElement etsySearchBox= driver.findElement(By.id("global-enhancements-search-query"));
        etsySearchBox.sendKeys("wooden spoon"+ Keys.ENTER);

        //4. Verify title:
        String expectedTitle="Wooden spoon | Etsy";
        String actualTitle= driver.getTitle();

        if(actualTitle.startsWith(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }
        //Expected: “Wooden spoon | Etsy”
    }
}
