package com.thetestingacademy.ActionWindowsIframeJS;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium27_Action2 {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Actions")
    @Test
    public void testMethod27() throws InterruptedException {
       // driver.get("https://www.makymytrip.com/");

        driver.get("https://www.makymytrip.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        WebElement closeModal = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));

        wait.until(ExpectedConditions.visibilityOf(closeModal));

        Actions action = new Actions(driver);
        action.moveToElement(closeModal).click().build().perform();

        WebElement fromCity = driver.findElement(By.id("fromCity"));

        Thread.sleep(5000);

        action.moveToElement(fromCity).click().sendKeys("DEL").build().perform();

        Thread.sleep(5000);

        action.moveToElement(fromCity).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();
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
