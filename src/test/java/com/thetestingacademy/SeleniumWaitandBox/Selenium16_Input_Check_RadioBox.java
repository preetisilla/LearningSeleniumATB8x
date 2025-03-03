package com.thetestingacademy.SeleniumWaitandBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium16_Input_Check_RadioBox {
    @Test
    public void testMethod16(){
        WebDriver driver = new EdgeDriver();

        driver.get("https://awesomeqa.com/practice.html");

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Preeti");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Silla");

        //Radio box
        driver.findElement(By.xpath("//input[@id='sex-1']")).click();

        //Check Box
        driver.findElement(By.xpath("//input[@id='tool-1']")).click();

        driver.quit();


    }
}
