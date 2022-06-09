package com.cydeo.tests.day10_upload_actions_jsexecuter;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Registration_Form {
    @Test
    public void registration_form_test(){
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url") );
        //Create Java Faker Object
        Faker faker= new Faker();

//3. Enter first name
        WebElement inputFirstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        inputFirstName.sendKeys((faker.name().firstName()));
 //4. Enter last name
        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys((faker.name().lastName()));

//5. Enter username
        WebElement inputUserName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
       // inputUserName.sendKeys((faker.name().username().replaceAll(".","")));
        String user= faker.bothify("helpdesk###");
        inputUserName.sendKeys(user);

//6. Enter email address
        WebElement inputEmail = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys(user+"@email.com");
//7. Enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys(faker.numerify("########"));
        //System.out.println("faker.internet().password() = " + faker.internet().password());
//8. Enter phone number
        WebElement inputPhone = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhone.sendKeys(faker.numerify("###-###-####"));
//9. Select a gender from radio buttons
        WebElement inputGender=Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        inputGender.click();

//10. Enter date of birth
        WebElement inputBithday=Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        //faker.number().numberBetween(1920,2004);
        inputBithday.sendKeys("03/08/2022");

//11. Select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));

//12. Select Job Title
        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropdown.selectByIndex(faker.number().numberBetween(1,8));
//13. Select programming language from checkboxes
        WebElement inputLanguage=Driver.getDriver().findElement(By.xpath(" //input[@id='inlineCheckbox1']"));
        inputLanguage.click();

//14. Click to sign up button
        WebElement inputSignup = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        inputSignup.click();


//15. Verify success message “You’ve successfully completed registration.” is
//displayed.
        String actualResult =Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']/p")).getText() ;
        String expectedResult = "You've successfully completed registration!";
        Assert.assertEquals(actualResult, expectedResult);
    }
}
//TC#1: Registration form confirmation
//Note: Use JavaFaker OR read from configuration.properties file when possible.
//1. Open browser
//2. Go to website: https://practice.cydeo.com/registration_form
//3. Enter first name

//5. Enter username




//
//
//Note:
//1. Use new Driver utility class and method
//2. User JavaFaker when possible
//3. User ConfigurationReader when it makes sense