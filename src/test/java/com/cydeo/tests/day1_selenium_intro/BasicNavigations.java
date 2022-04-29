package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
        //1- Set up the "browser driver"
        WebDriverManager.chromedriver().setup();

        //2- Create instance of the Selenium WebDriver
        // This is line opening an empty browser
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //3- Go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        //get the title of the page
        String currentTitle= driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        //Get the current URL using Selenium
        String currentURL= driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //Stop code Execution for 3 seconds
        Thread.sleep(3000);

        // use Selenium driver to navigate back
        driver.navigate().back();

        //Stop code Execution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate forward
        driver.navigate().forward();

        //Stop code Execution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate refresh
        driver.navigate().refresh();

        //use selenium to navigate to()
        driver.navigate().to("https://www.google.com");

        //get the title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());

        currentTitle= driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        //Get the current URL using Selenium
        currentURL= driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //This will close the currently opened window
        driver.close();

        driver.quit();



    }

}
