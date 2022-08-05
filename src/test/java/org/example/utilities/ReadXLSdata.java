package org.example.utilities;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadXLSdata {
    public static void main(String[] args) {
        ReadXLSdata red = new ReadXLSdata();
        try {
          Object[][] testdata = red.getData();
           /* System.out.println("final data--"+testdata[1][1]);
            System.out.println("final data--"+testdata[1][0]);*/
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @DataProvider(name = "signindata")
    public Object[][] getData() throws EncryptedDocumentException, IOException {
        File f = new File(new File(System.getProperty("user.dir")) + "\\src\\test\\java\\org\\example\\testData\\LoginData.xlsx");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet("sheet1");
        int totalRows = sheetName.getLastRowNum();
        System.out.println(totalRows);
        Row rowCells = sheetName.getRow(0);
        int totalCols = rowCells.getLastCellNum();
        System.out.println(totalCols);
        DataFormatter format = new DataFormatter();
        String testData[][] = new String[totalRows][totalCols];
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
                System.out.println(testData[i - 1][j]);
            }
        }
        return testData;
    }
}













