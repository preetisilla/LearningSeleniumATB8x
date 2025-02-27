package com.thetestingacademy.ex01_23rdDec2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium07_Project2 {
    @Test
    public void testMethod07() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--incognito");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");

        //<a - open html tag
        // href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        // class="text-link"
        // data-qa="bericafeqo">
        // Start a free trial
        // </a> - close html tag

        //Link Text - full match
        // Partial Link Text - Partial Match

        WebElement link_freeTrialEleement = driver.findElement(By.linkText("Start a free trial"));
        link_freeTrialEleement.click();

        Thread.sleep(3000);
        driver.quit();
    }
}
