package com.thetestingacademy.SeleniumException;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium38_StaleElement {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Selenium Exception Stale Element")
    @Test
    public void testMethod38() throws InterruptedException {
        try{
        driver.get("https://google.com");
        WebElement search = driver.findElement(By.id("APjFqb"));
        driver.navigate().refresh();
// refresh , DOM changes in single page
        search = driver.findElement(By.id("APjFqb")); // re-find the element to fix this exception
        search.sendKeys("testing");

        } catch (StaleElementReferenceException e) {// This exception occurs when element is no longer available in DOM (HTML page)
            System.out.println(e.getMessage());
        }

    }

    @AfterTest
    public void closeBrowser(){
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
