package com.thetestingacademy.DatadrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTRealTime01 {
    @DataProvider(name = "LoginData", parallel = true)
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"admin@gmail.com","pass123"},
                new Object[]{"adin123@gmail.com","password"}
        };
    }

    @Test(dataProvider = "LoginData")
    public void loginTest(String email, String password){
        System.out.println(email + " | " + password);
    }
}
