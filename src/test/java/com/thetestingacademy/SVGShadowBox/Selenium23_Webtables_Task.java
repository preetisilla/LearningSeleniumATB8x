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

public class Selenium23_Webtables_Task {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Webtable task")
    @Test
    public void testMethod23() throws InterruptedException {
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        Thread.sleep(10000);

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Hacker@4321");
        driver.findElement(By.xpath("//button[contains(@class,'orangehrm-login-button')]")).click();

        Thread.sleep(3000);

        int rows = driver.findElements(By.xpath("//div[@class='oxd-table-card']")).size();
        int columns = driver.findElements(By.xpath("//div[@class='oxd-table-card'][1]//div[@class='oxd-table-cell oxd-padding-cell']")).size();


        //div[@class='oxd-table-card']//div[@class='oxd-table-cell oxd-padding-cell']
        for(int i = 1 ; i <= rows; i++){
            for(int j = 1; j <= columns; j++){

                String xpathString = "//div[@class='oxd-table-card']["+i+"]//div[@class='oxd-table-cell oxd-padding-cell']["+j+"]";
                String result = driver.findElement(By.xpath(xpathString)).getText();
                //System.out.println(result);
                if(result.equals("Terminated")){

                    System.out.println(result);
                    String xpathDeleteString = "//div[@class='oxd-table-card']["+i+"]//div[@class='oxd-table-cell oxd-padding-cell'][9]/descendant::button";
                    WebElement delete = driver.findElement(By.xpath(xpathDeleteString));
                    System.out.println("Delete the terminated employee");
                    delete.click();
                    j=columns+1;
                    i=rows+1;

                    Thread.sleep(3000);
                    //div[@class='oxd-table-card'][1]//div[contains(@class,'oxd-table-cell')][9]/descendant::button
                }

            }
        }

        //div[contains(@class,'oxd-table-row')]/div[contains(@class,'oxd-table-cell')]

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
