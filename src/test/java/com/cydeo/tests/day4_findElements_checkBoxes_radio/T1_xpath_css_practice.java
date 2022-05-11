package com.cydeo.tests.day4_findElements_checkBoxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_css_practice {
    public static void main(String[] args) {
        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");
        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //a. “Home” link
        //locator only (total of 6)
        //syntax1
        WebElement homeLink_ex1= driver.findElement(By.cssSelector("a[class='nav-link']"));
        //syntax2
        WebElement homeLink_ex2= driver.findElement(By.cssSelector("a.nav-link"));
        //Locate homelink using cssSelector, href  value
        WebElement homeLink_ex3= driver.findElement(By.cssSelector("a[href='/']"));

        //b. “Forgot password” header
        //Locate header using cssSelector:locate parent element and move down to h2
        WebElement header_ex1= driver.findElement(By.cssSelector("div.example>h2"));

        //Locate header xpath:locate parent element and move down to h2
        //WebElement header_ex2= driver.findElement(By.xpath("//h2[.='Forgot Password']"));//. is the same with text()
        WebElement header_ex2= driver.findElement(By.xpath("//h2[text()='Forgot Password']"));


        //c. “E-mail” text
        WebElement emailLabel_ex1= driver.findElement(By.xpath("//label[@for='email']"));

        //d. E-mail input box
        WebElement emailInput= driver.findElement(By.xpath("//input[@name='email']"));

        WebElement emailInput2= driver.findElement(By.xpath("//input[contains(@pattern,'0-9')]"));

        //e. “Retrieve password” button
        WebElement retrievePasswordButton= driver.findElement(By.xpath("//button[@id='form_submit']"));
        WebElement retrievePasswordButton2= driver.findElement(By.xpath("//button[@class='radius']"));

        //f. “Powered by Cydeo text
        WebElement poweredByCydeoText= driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        //4. Verify all web elements are displayed.
        System.out.println("homeLink_ex1.isDisplayed() = " + homeLink_ex1.isDisplayed());
        System.out.println("header_ex1.isDisplayed() = " + header_ex1.isDisplayed());
        System.out.println("emailInput.isDisplayed() = " + emailInput.isDisplayed());
        System.out.println("retrievePasswordButton.isDisplayed() = " + retrievePasswordButton.isDisplayed());
        System.out.println("emailLabel_ex1.isDisplayed() = " + emailLabel_ex1.isDisplayed());

    }
}
