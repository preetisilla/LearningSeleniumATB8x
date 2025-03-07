package com.thetestingacademy.ActionWindowsIframeJS;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium31_UploadFile {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Upload File")
    @Test
    public void testMethod31() throws InterruptedException {
        driver.get("https://awesomeqa.com/selenium/upload.html");

        Thread.sleep(5000);

        WebElement fileUpload = driver.findElement(By.id("fileToUpload"));
        WebElement submit = driver.findElement(By.name("submit"));

        String dir = System.getProperty("user.dir");
        System.out.println(dir);

        //C:\Users\Admin\IdeaProjects\LearningSeleniumATB8x\src\test\java\com\thetestingacademy\ex01_18Dec2024/Selenium01.java

        fileUpload.sendKeys(dir + "/src/test/java/com/thetestingacademy/ex01_18Dec2024/Selenium01.java");
        submit.click();

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
