package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T7_NonSelect {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
    @Test
    public void nonSelect(){
        WebElement dropdown= driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        dropdown.click();
        WebElement facebook = driver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[4]"));
        facebook.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Giriş Yap veya Kaydol";

        Assert.assertEquals(actualTitle, expectedTitle);


    }
    @Test
    public void multipleSelectDropdown(){
        List<WebElement> multipleSelectDropdown =driver.findElements(By.xpath("//select[@name='Languages']//option"));
        Select select = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        for (WebElement each : multipleSelectDropdown) {
            select.selectByVisibleText(each.getText());
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        }
        for (WebElement each : multipleSelectDropdown) {
            if (each.isSelected()){
                System.out.println(each.getText());
            }
        }
        for (WebElement eachLanguage : multipleSelectDropdown) {
            select.deselectAll();
        }


    }

}
/*
TC #7: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up”
 TC #8: Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.

 */