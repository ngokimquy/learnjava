package org.example;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("thong tin nay duoc them vao tu kimquydev");
        try {
            // Đường dẫn đến file Excel
            FileInputStream file = new FileInputStream(new File("src/main/java/org/people.xlsx"));

            // Tạo Workbook từ file Excel
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Lấy sheet đầu tiên trong workbook
            XSSFSheet sheet = workbook.getSheetAt(5);
            boolean flag = true;
            // Duyệt qua các hàng trong sheet
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        default:
                            System.out.print("Unknown Cell Type");
                    }
                }
                System.out.println();
                    /*if (flag)
                    {
                        flag = false;
                        continue;
                    }

                    String a = row.getCell(0).getStringCellValue();
                    System.out.println(a);
                    String a1 = row.getCell(1).getStringCellValue();
                    System.out.println(a1);
                    Double b = row.getCell(2).getNumericCellValue();
                    System.out.println(b);
                Double b1 = row.getCell(3).getNumericCellValue();
                System.out.println(b);
                Double b2 = row.getCell(4).getNumericCellValue();
                System.out.println(b);
                String c = row.getCell(5).getStringCellValue();
                System.out.println(c);

*/

            }

            // Đóng file và workbook
            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}