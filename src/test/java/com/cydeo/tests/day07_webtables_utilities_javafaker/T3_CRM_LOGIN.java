package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRM_LOGIN {
    public WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void crm_login_test(){
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/ ");

        //3. Enter valid username
        //helpdesk1@cybertekschool.com  UserUser
        //Helpdesk2@cybertekschool.com  UserUser
        WebElement inpuUsername= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inpuUsername.sendKeys("helpdesk1@cybertekschool.com");

        //4. Enter valid password
        WebElement inputPassword = driver.findElement((By.xpath("//input[@name='USER_PASSWORD']")));
        inputPassword.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value ='Log In']"));
        loginButton.click();

        //6. Verify title is as expected:
        //Expected: Portal

        BrowserUtils.verifyTitle(driver, "Portal");


    }

    @Test
    public void crm_login_test2(){
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/ ");

        CRM_Utilities.crm_login(driver);
        //6. Verify title is as expected:
        //Expected: Portal

        BrowserUtils.verifyTitle(driver, "Portal");


    }




}
