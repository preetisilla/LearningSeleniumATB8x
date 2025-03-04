package com.thetestingacademy.SeleniumWaitandBox;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium18_JSAlerts {
    @Test
    public void testMethod18(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alertElement = driver.findElement(By.xpath("//button[contains(text(),'Alert')]"));
        WebElement elementConfirm = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
        WebElement elementPrompt = driver.findElement(By.xpath("//button[contains(text(),'Prompt')]"));

        alertElement.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),"You successfully clicked an alert");

        elementConfirm.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
       // alert1.dismiss(); to cancel

        Assert.assertEquals(result.getText(),"You clicked: Ok");

        elementPrompt.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("Preeti");
        alert2.accept();

        Assert.assertEquals(result.getText(),"You entered: Preeti");

    }
}
