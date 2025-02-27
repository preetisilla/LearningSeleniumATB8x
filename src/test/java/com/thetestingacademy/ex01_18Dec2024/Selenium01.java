package com.thetestingacademy.ex01_18Dec2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Selenium01 {
    @Test
    public void test_Selenium(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://app.vwo.com");
        driver.quit();

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--window-size=1920,1080");
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("headless");

        EdgeDriver edriver = new EdgeDriver(edgeOptions);
        edriver.get("https://app.vwo.com");
        edriver.quit();

    }
}
