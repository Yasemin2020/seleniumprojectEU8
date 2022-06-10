package com.cydeo.tests.day11_actions_jsexecuter_practice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Circle_Drag_And_Drop {
    @Test
    public void dragAndDrop_test(){

        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //Locate "Accept Cookies" button and click
        WebElement acceptCookiesButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(1);
        //x,y
        js.executeScript("window.scrollBy(0,250)");

        //Locate small and big circles to be able to drag them around
        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        //2. Drag and drop the small circle to bigger circle.
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(smallCircle, bigCircle).perform();
      /* actions.moveToElement(smallCircle) .clickAndHold(smallCircle)
                .pause(2000)
                .moveToElement(bigCircle)
                .pause(2000)
                .release()
                .perform();*/

        //3. Assert:
        //-Text in big circle changed to: “You did great!”

        String actualBigCircleText = bigCircle.getText();
        String expectedBigCircleText = "You did great!";

        Assert.assertEquals(actualBigCircleText, expectedBigCircleText);
    }

}
