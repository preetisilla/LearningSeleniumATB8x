package com.thetestingacademy.SVG;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium19_Project1 {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify the search results")
    @Test
    public void test_flipkart_search(){
        driver.get("https://www.flipkart.com/");

        driver.findElement(By.name("q")).sendKeys("macmini");

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[name()='svg']"));
        svgElements.get(0).click();

        List<WebElement> titleResults = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]"));
        for(WebElement title: titleResults){
            System.out.println(title.getText());
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
