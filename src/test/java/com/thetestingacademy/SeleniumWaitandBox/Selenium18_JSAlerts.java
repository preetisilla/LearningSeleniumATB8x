package com.thetestingacademy.SeleniumWaitandBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium18_JSAlerts {
    @Test
    public void testMethod18(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alertElement = driver.findElement(By.xpath("//button[contains(text(),'Alert')]"));
        WebElement elementConfirm = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
        WebElement elementPrompt = driver.findElement(By.xpath("//button[contains(text(),'Prompt')]"));







    }
}
