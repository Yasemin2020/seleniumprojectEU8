package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_DropdownSelect {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void T5_SelectDropdown(){
        Select dropdown= new Select(driver.findElement(By.xpath("//select[@id='state']")));
        dropdown.selectByValue("IL");
        dropdown.selectByVisibleText("Virginia");
        dropdown.selectByIndex(5);
        String actualSelectedItem=dropdown.getFirstSelectedOption().getText();
        String expectedSelectedItem="California";
        Assert.assertEquals(actualSelectedItem,expectedSelectedItem);

    }

    /*
    1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
     */
}
