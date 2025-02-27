package com.thetestingacademy.ex01_23rdDec2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium08_Project3 {
    @Test
    public void testMethod08() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--incognito");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://vwo.com/free-trial/");

        //<input
        // class="W(100%) Py(14px) input-text"
        // placeholder="name@yourcompany.com"
        // type="email"
        // id="page-v1-step1-email"
        // name="email"
        // data-qa="page-su-step1-v1-email"
        // required="">

        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("dhcqhjokq");

        //<input
        // class="Cur(p) Flxs(0) M(0) Pos(r) T(2px)"
        // type="checkbox"
        // name="gdpr_consent_checkbox"
        // id="page-free-trial-step1-cu-gdpr-consent-checkbox"
        // value="true" data-qa="page-free-trial-step1-gdpr-consent-checkbox">

        WebElement checkBoxPolicy = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkBoxPolicy.click();

        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        buttonList.get(0).click();

        //<div
        // class="C($color-red) Fz($font-size-12) Trsp($Op) Trsdu(0.15s) Op(0) invalid-input+Op(1) invalid-reason">
        // The email address you entered is incorrect.
        // </div>

        WebElement errorMessage = driver.findElement(By.className("invalid-reason"));
        //this is not unique but findElement find first element with the class name as invalid-reason
        Assert.assertEquals(errorMessage.getText(),"The email address you entered is incorrect.");

        Thread.sleep(3000);
        driver.quit();
    }
}
