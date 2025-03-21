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

public class Selenium34_RelativeLocator1 {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Relative Locator1")
    @Test
    public void testMethod34() throws InterruptedException {
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");

        Thread.sleep(5000);

        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        search.sendKeys("India" + Keys.ENTER);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        Thread.sleep(3000);

        List<WebElement> states = driver.findElements(By.xpath("//div[contains(@class,'location-name')]/p"));

        for(WebElement s : states){
            //System.out.println(s.getText());
            String s1 = driver.findElement(with(By.tagName("p")).toLeftOf(s)).getText();
            String s2 = driver.findElement(with(By.tagName("span")).toRightOf(s)).getText();
            System.out.println(s.getText() + "  " + s1 + "  " + s2);

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
