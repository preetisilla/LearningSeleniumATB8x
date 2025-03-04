package com.thetestingacademy.SVGShadowBox;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium21_JSProject3 {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify the JS")
    @Test
    public void test_JS() throws InterruptedException {
        driver.get("https://selectorshub.com/xpath-practice-page/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement div_to_scroll = driver.findElement(By.xpath("//div[@id='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true);",div_to_scroll);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(div_to_scroll));

        WebElement inputBox = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"input#pizza\")");
        inputBox.sendKeys("farmhouse");
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
