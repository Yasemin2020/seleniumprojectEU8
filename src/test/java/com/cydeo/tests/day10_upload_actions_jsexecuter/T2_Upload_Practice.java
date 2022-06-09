package com.cydeo.tests.day10_upload_actions_jsexecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {
    @Test
    public void upload_test(){
        //1. Go to https://practice.cydeo.com/upload

        Driver.getDriver().get("https://practice.cydeo.com/upload");
        //2. Find some small file from your computer, and get the path of it.,
        String path = "C:\\Users\\Dell\\Desktop\\HTML Class\\OIP.jpg";


        //input[@id='file-submit']


        //3. Upload the file.
        WebElement fileUpload=Driver.getDriver().findElement(By.id("file-upload"));

        fileUpload.sendKeys(path);


        //4. Assert:
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        //-File uploaded text is displayed on the page
        WebElement fileUploadedHeader = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedHeader.isDisplayed());


    }



}
