package com.thetestingacademy.ex01_20Dec2024;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium03_CloseQuit {
    @Test
    public void testMethod02() {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://youtube.com");

        //Close vs Quit
        driver.close();
        //close the current tab not full browser, session id is not null, session is invalid state

        //driver.quit();
        //close full browser and session is null
    }
}

