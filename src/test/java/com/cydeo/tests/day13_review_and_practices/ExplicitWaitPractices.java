package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.Pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {
    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();
    }
    @Test
    public void remove_button_test(){
        //3- Click to “Remove” button
       dynamicControlsPage.removeButton.click();

        //4- Wait until “loading bar disappears”
      /*  Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);//turn off the implicit wait before explicit wait
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));*/
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed
        try{
            Assert.assertTrue(!dynamicControlsPage.checkBox.isDisplayed());

            //assertFalse method will pass the test if the boolean value returned is: false
            Assert.assertFalse(dynamicControlsPage.checkBox.isDisplayed());
        }catch(NoSuchElementException e){
            Assert.assertTrue(true);
        }


        //b. “It’s gone!” message is displayed.
       // Assert.assertTrue(dynamicControlsPage.itsGoneMessage.isDisplayed());
        Assert.assertTrue(dynamicControlsPage.itsGoneMessage.getText().equals("It's gone!"));



    }

    @Test
    public void enable_button_test(){

        //3- Click to “Enable” button
        dynamicControlsPage.enableButton.click();

        //4- Wait until “loading bar disappears”
        //5- Verify:
        //a. Input box is enabled.
        //b. “It’s enabled!” message is displayed.
    }


}
