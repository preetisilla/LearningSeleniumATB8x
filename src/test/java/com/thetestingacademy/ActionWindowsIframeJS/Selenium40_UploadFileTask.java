package com.thetestingacademy.ActionWindowsIframeJS;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium40_UploadFileTask {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Upload File Browser stack task")
    @Test
    public void testMethod40() throws InterruptedException {
        driver.get("https://www.browserstack.com/app-automate");
        driver.findElement(By.linkText("Sign in")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email_login")));

        driver.findElement(By.id("user_email_login")).sendKeys("preetisilla18@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("Preeti@18");
        driver.findElement(By.id("user_submit")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Account']")));

        driver.get("https://app-automate.browserstack.com/dashboard/v2/getting-started");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("file")));

        WebElement fileUpload = driver.findElement(By.id("file"));
        fileUpload.sendKeys("C:/Users/Admin/Downloads/example.apk");
        WebElement apkSuccess = driver.findElement(By.className("tab-icon__left"));

        Assert.assertTrue(apkSuccess.isDisplayed());

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
