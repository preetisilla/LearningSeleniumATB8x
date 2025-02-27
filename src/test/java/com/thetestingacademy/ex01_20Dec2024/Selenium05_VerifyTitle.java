package com.thetestingacademy.ex01_20Dec2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class Selenium05_VerifyTitle {
    @Test
    public void testMethod04() throws Exception {
//        EdgeOptions edgeOptions = new EdgeOptions();
//        edgeOptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        //TestNG assertions
        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");

        //AssertJ
        assertThat(driver.getTitle()).isEqualTo("CURA Healthcare Service").isNotBlank().isNotEmpty();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://katalon-demo-cura.herokuapp.com/");

        if(driver.getPageSource().contains("CURA1 Healthcare Service")){
            Assert.assertTrue(true);
        }else{
            throw new Exception("Heading Not Found!");
        }
    }
}
