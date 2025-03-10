package com.thetestingacademy.ActionWindowsIframeJS;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium36_RelativeLocator2 {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Relative Locator2")
    @Test
    public void testMethod36() throws InterruptedException {
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");

        Thread.sleep(5000);

        driver.switchTo().frame("result");

        WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
        submit.click();

        Thread.sleep(3000);

        WebElement username = driver.findElement(By.id("username"));

        WebElement label = driver.findElement(with(By.tagName("label")).above(username));

        WebElement error = driver.findElement(with(By.tagName("small")).below(username));

        System.out.println(label.getText());

        System.out.println(error.getText());

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
