package com.thetestingacademy.SeleniumWaitandBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Selenium17_Select {
    @Test
    public void testMethod17(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        System.out.println(driver.getTitle());

        driver.manage().window().maximize();

        WebElement elementSelect = driver.findElement(By.id("dropdown"));
        Select select = new Select(elementSelect);
        select.selectByVisibleText("Option 2");
        select.selectByIndex(1);

        driver.quit();
    }
}
