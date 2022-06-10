package com.cydeo.tests.day11_actions_jsexecuter_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop {
    @Test
    public void dragAndDropTest(){

        Driver.getDriver().get("https://jqueryui.com/droppable/");

        WebElement frameElement= Driver.getDriver().findElement(By.xpath("//iframe[@class='demo-frame']"));
        Driver.getDriver().switchTo().frame(frameElement);

        WebElement smallSquare= Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigSquare= Driver.getDriver().findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(smallSquare, bigSquare).perform();

        String actualResult= bigSquare.getText();
        String expectedResult= "Dropped!";


        Assert.assertEquals(actualResult, expectedResult);

        Driver.getDriver().switchTo().parentFrame();
    }

}