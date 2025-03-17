package com.thetestingacademy.DatadrivenTesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcel {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("CTD.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();

        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while(cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                if(cell.getCellType() == CellType.NUMERIC){
                    System.out.println(cell.getNumericCellValue());
                }
                if(cell.getCellType() == CellType.STRING) {
                    System.out.println(cell.getStringCellValue());
                }
            }

        }

    }
}
