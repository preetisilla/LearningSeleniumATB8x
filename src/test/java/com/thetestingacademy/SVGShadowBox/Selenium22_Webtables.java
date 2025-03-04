package com.thetestingacademy.SVGShadowBox;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium22_Webtables {

    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Webtables")
    @Test
    public void testMethod22() throws InterruptedException {
        driver.get("https://awesomeqa.com/webtable.html");
        // rows = //table[@id='customers']/tbody/tr
        // columns - //table[@id='customers']/tbody/tr[2]/td

        Thread.sleep(3000);
        int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int column = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();
        for (int i = 2; i <= row ; i++){
            for(int j = 1; j<=column ; j++){
                String xpathElement = "//table[@id='customers']/tbody/tr[" +i+"]/td["+j+"]";
                WebElement dataElement = driver.findElement(By.xpath(xpathElement));
                System.out.println(dataElement.getText());
                //System.out.println(data);
                if(dataElement.getText().contains("Helen")){
                    WebElement country = driver.findElement(By.xpath(xpathElement+"/following-sibling::td"));
                    System.out.println("Country of Helen is " + country.getText());
                }
            }
        }
    }

    @AfterTest
    public void closeBrowser(){
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
