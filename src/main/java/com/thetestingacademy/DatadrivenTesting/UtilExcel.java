package com.thetestingacademy.DatadrivenTesting;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {

    static Workbook book;
    static Sheet sheet;

    public static String SHEET_PATH = System.getProperty("user.dir") + "/src/main/resources/TestData.XLSX";

    public static Object[][] getTestDataFromExcel(String sheetName) throws IOException {
        FileInputStream file = null;
        try {
            file = new FileInputStream(SHEET_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        book = WorkbookFactory.create(file);
        sheet = book.getSheet(sheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i =0; i<sheet.getLastRowNum(); i++){
            for(int j = 0; j<sheet.getRow(0).getLastCellNum();j++){
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }

        return null;
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return getTestDataFromExcel("Sheet1");
    }

}
