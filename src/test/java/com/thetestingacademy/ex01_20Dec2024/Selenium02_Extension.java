package com.thetestingacademy.ex01_20Dec2024;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Selenium02_Extension {
    @Test
    public void testMethod01(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addExtensions(new File("src/test/java/com/thetestingacademy/ex01_20Dec2024/AdBlock.crx"));

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://youtube.com");
    }
}
