package com.thetestingacademy.ex01_03Jan2025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium13_XpathAxes {
    @Test
    public void testMethod13() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://cdpn.io/AbdullahSajjad/fullpage/LYGVRgK?anon=true&view=fullpage");

        driver.switchTo().frame("result");

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitButton.click();

        String inputTextXpath = "//input[@id = 'username']";
        String errorMessageXpath = inputTextXpath + "/following-sibling::small";
        String labelMessageXpath = inputTextXpath + "/preceding-sibling::label";

        WebElement errorMessage = driver.findElement(By.xpath(errorMessageXpath));
        WebElement labelMessage = driver.findElement(By.xpath(labelMessageXpath));

        System.out.println(errorMessage.getText());
        System.out.println(labelMessage.getText());

        Assert.assertEquals(errorMessage.getText(),"Username must be at least 3 characters");
        Assert.assertEquals(labelMessage.getText(),"Username");

        Thread.sleep(3000);
        driver.quit();


    }

}
