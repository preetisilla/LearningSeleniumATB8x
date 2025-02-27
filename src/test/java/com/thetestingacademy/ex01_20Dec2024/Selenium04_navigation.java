package com.thetestingacademy.ex01_20Dec2024;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium04_navigation {
    @Test
    public void testMethod03(){
        EdgeDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://sdet.live");
// same as get but has back n forward option
        edgeDriver.navigate().to("https://thetestingacademy.com");
        edgeDriver.navigate().back();
        edgeDriver.navigate().forward();
        System.out.println(edgeDriver.getTitle());
    }
}
