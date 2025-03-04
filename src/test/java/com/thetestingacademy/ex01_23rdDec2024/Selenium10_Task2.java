package com.thetestingacademy.ex01_23rdDec2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium10_Task2 {
    @Test
    public void testMethod10() throws InterruptedException {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--incognito");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://awesomeqa.com/practice.html");

        //<input
        // name="firstname"
        // style="-webkit-appearance: none; appearance: none;
        // background-color: #fcfcfc;
        // border-color: rgba(173, 176, 182, 0.3); border-radius: 0px; border-style: solid; border-width: 1px; color: #787d85; font-family: verdana, helvetica, arial, verdana, sans-serif; font-size: 13px; height: 38px; line-height: 22px; margin: 0px; outline: 0px; padding: 5px 15px; vertical-align: baseline;"
        // type="text">
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Preeti");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Silla");
        WebElement gender = driver.findElement(By.cssSelector("input[value='Female']"));
        gender.click();
        WebElement experience = driver.findElement(By.cssSelector("input[value='7']"));
        experience.click();
        WebElement datepicker = driver.findElement(By.id("datepicker"));
        datepicker.sendKeys("12022025");
        WebElement profession = driver.findElement(By.cssSelector("input[value='Automation Tester']"));
        profession.click();
        WebElement tools = driver.findElement(By.cssSelector("input[value='Selenium Webdriver']"));
        tools.click();
        Thread.sleep(3000);
        driver.quit();
    }
}