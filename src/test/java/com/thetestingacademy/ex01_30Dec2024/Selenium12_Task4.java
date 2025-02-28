package com.thetestingacademy.ex01_30Dec2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;
import java.util.List;

public class Selenium12_Task4 {
    @Test
    public void testMethod12(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchBox.sendKeys("macmini");

        WebElement searchButton = driver.findElement(By.xpath("//button[@value='Search']"));
        searchButton.click();

        List<WebElement> searchTitles = driver.findElements(By.xpath("//div[@class='s-item__title']"));
        List<WebElement> searchPrices = driver.findElements(By.xpath("//span[@class='s-item__price']"));

        int size = Math.min(searchTitles.size(),searchPrices.size());
        for (int i =0 ; i< size; i++){
            System.out.println("Title : " + searchTitles.get(i).getText() + " || " + "Price : " + searchPrices.get(i).getText());
        }

        driver.quit();

    }
}
