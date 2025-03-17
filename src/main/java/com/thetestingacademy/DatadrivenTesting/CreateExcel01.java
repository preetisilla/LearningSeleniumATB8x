package com.thetestingacademy.DatadrivenTesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CreateExcel01 {
    public static void main(String[] args) throws IOException {
        Map<String, Object> data = new TreeMap<>();
        data.put("1", new Object[]{"LoginId", "Email", "Password"});
        data.put("2", new Object[]{"1", "preeti@live.com", "12345"});
        data.put("3", new Object[]{"2", "test@live.com", "pass12345"});

        createExcel("CTD.xlsx",data);
    }

    static String createExcel(String name, Map data) throws IOException {
        Set<String> keyset = data.keySet();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");

        int rownum = 0;

        for (String key : keyset) {
            Row r = sheet.createRow(rownum++);
            Object[] objectA = (Object[]) data.get(key);
            int cellnum = 0;
            for (Object o : objectA) {
                Cell cell = r.createCell(cellnum++);
                if( o instanceof String)
                cell.setCellValue((String) o);
                if( o instanceof Integer)
                    cell.setCellValue((Integer) o);
            }
        }

        FileOutputStream outputStream = new FileOutputStream(new File(name));
        workbook.write(outputStream);
        outputStream.close();
        return name;
    }
}
