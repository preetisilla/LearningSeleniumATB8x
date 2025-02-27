package com.thetestingacademy.ex01_23rdDec2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class Selenium06_Project1 {
    @Test
    public void testMethod06() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--incognito");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");

        //Assert.assertEquals(driver.getTitle(),"VWO - Application"); title is changing so ignore this assertions
        //Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        WebElement passwordInputBox = driver.findElement(By.id("login-password"));
        passwordInputBox.sendKeys("password");

        WebElement signinButton = driver.findElement(By.id("js-login-btn"));
        signinButton.click();

        Thread.sleep(3000);

        WebElement errorMessage = driver.findElement(By.id("js-notification-box-msg"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(),"Your email, password, IP address or location did not match");

        //assertJ
        assertThat(errorMessage.getText()).isNotEmpty().isNotBlank().isEqualTo("Your email, password, IP address or location did not match");

        driver.quit();
    }
}
