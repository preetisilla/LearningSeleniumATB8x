package com.thetestingacademy.ex01_30Dec2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium11_Task3_xpath {
    @Test
    public void testMethod11() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.idrive360.com/enterprise/login");
        Thread.sleep(5000);
        //<input
        // _ngcontent-whb-c4=""
        // autofocus=""
        // class="id-form-ctrl ng-pristine ng-valid ng-touched"
        // id="username"
        // name="username"
        // type="email">
        //WebElement username = driver.findElement(By.id("username"));

        //xpath core rule - //tagname[@attribut='value'] - relative xpath

        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("augtest_040823@idrive.com");
        //WebElement password = driver.findElement(By.id("password"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("123456");
        WebElement signInButton = driver.findElement(By.id("frm-btn"));
        signInButton.click();
        Thread.sleep(10000);
        //<h5
        // _ngcontent-mqg-c10=""
        // class="id-card-title">
        // Your free trial has expired<
        // /h5>
        WebElement freeTrial = driver.findElement(By.xpath("//h5[@class ='id-card-title']"));
        //className("id-card-title"));
        Assert.assertEquals(freeTrial.getText(),"Your free trial has expired");
        Thread.sleep(3000);
        driver.quit();

        //a[@id = 'btn-make-appointment']
    }

}
