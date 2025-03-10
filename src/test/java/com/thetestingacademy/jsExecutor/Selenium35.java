package com.thetestingacademy.jsExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium35 {
    @Test
    public void testMethod35(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        String URL = "https://selectorshub.com/xpath-practice-page/";
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get(URL);
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        String url = js.executeScript(" return document.URL").toString();
        System.out.println(url);

        String title = js.executeScript(" return document.title").toString();
        System.out.println(title);

    }
}
