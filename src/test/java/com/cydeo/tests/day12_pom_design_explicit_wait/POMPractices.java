package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.Pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POMPractices {

    LibraryLoginPage libraryLoginPage;
    @Test
    public void required_field_error_message_test(){
    //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");

        //3- Do not enter any information
        //4- Click to “Sign in” button
        libraryLoginPage= new LibraryLoginPage();
        libraryLoginPage.signInButton.click();

        //5- Verify expected error is displayed:
        //Expected: This field is required.

        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());

        Driver.closeDriver();


    }

    @Test
    public void invalid_email_format_error_message_test(){
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");

        //3- Enter invalid email format
        libraryLoginPage= new LibraryLoginPage();

        libraryLoginPage.inputUserName.sendKeys("somethingwrong");

        libraryLoginPage.signInButton.click();

        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.
        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());
        Driver.closeDriver();


    }
    @Test
    public void library_negative_login_test(){
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");

        libraryLoginPage = new LibraryLoginPage();

        //3- Enter incorrect username or incorrect password
        libraryLoginPage.inputUserName.sendKeys("wrong@username.com");
        libraryLoginPage.inputPassword.sendKeys("wrongpassword");
        libraryLoginPage.signInButton.click();

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMassage.isDisplayed());
        Driver.closeDriver();
    }


}
