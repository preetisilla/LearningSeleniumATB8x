package com.thetestingacademy.ex01_23rdDec2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class Selenium09_Task {
    @Test
    public void testMethod09() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--incognito");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        //<a
        // id="btn-make-appointment"
        // href="./profile.php#login"
        // class="btn btn-dark btn-lg">
        // Make Appointment
        // </a>

        WebElement linkMakeAppointment = driver.findElement(By.id("btn-make-appointment"));
        linkMakeAppointment.click();
        Thread.sleep(3000);

        //<input
        // type="text"
        // class="form-control"
        // id="txt-username"
        // name="username"
        // placeholder="Username"
        // value="" autocomplete="off">

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginBtn = driver.findElement(By.id("btn-login"));
        loginBtn.click();

        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

        assertThat(driver.getCurrentUrl()).isEqualTo("https://katalon-demo-cura.herokuapp.com/#appointment");

        Thread.sleep(3000);
        driver.quit();
    }
}
