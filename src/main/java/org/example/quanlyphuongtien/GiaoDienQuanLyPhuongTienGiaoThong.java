package org.example.quanlyphuongtien;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GiaoDienQuanLyPhuongTienGiaoThong {
    QuanLyOto quanLyOto = new QuanLyOto();
    Scanner sc = new Scanner(System.in);

    String chuoiGiaoDienChinh = "1. Nhap thong tin Oto\n" +
            "2. Hien thi danh sach oto\n" +
            "3. Import Data Oto\n" +
            "4. Ket Thuc "
            ;

    public  void  giaodienChinh()
    {
        boolean flag = true;
        while (flag)
        {

            System.out.println(chuoiGiaoDienChinh);
            String inputString;
            inputString = sc.nextLine();

            switch (inputString)
            {
                case  "1": giaodienThemOto();break;
                case  "2": giaodienListOto();break;
                case  "3": giaodienImportOto();break;
                case  "4": flag = false; break;

            }

        }

    }


    public  void giaodienThemOto()
    {
        OTo oto = new OTo();
        String inputString;
        System.out.println("vui long nhap thong tin xe:");

        System.out.println("1. Nhap hang san xuat: ");
        inputString = sc.nextLine();
        oto.hangSanXuat  = inputString;
        System.out.println("2. Nhap ten phuong tien:");
        inputString = sc.nextLine();
        oto.tenPhuongTien = inputString;
        System.out.println("3. Nhap nam san xuat:");
        inputString = sc.nextLine();
        oto.namSanXuat = Integer.parseInt(inputString);

        System.out.println("4. Nhap van toc toi da:");
        inputString = sc.nextLine();
        oto.vantocToiDa = Double.parseDouble(inputString);
        System.out.println("5. Nhap so choi ngoi:");
        inputString = sc.nextLine();
        oto.soChoNgoi = Integer.parseInt(inputString);
        System.out.println("6. Nhap loai dong co:");
        inputString = sc.nextLine();
        oto.kieuDongCo = inputString;

        quanLyOto.themOto(oto);
        System.out.println("O To da nhap thanh cong");



    }

    public  void giaodienListOto()
    {

        System.out.println(quanLyOto.dataListOto());

    }
    public  void giaodienImportOto()
    {

        String filePath = "src/main/java/org/people.xlsx"; // Đường dẫn đến file Excel

        OTo oto = new OTo();
        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(5); // Lấy sheet đầu tiên

            // Bỏ qua hàng đầu tiên (thường là tiêu đề)
            boolean isFirstRow = true; // Cờ để kiểm tra nếu là hàng đầu tiên
            for (Row row : sheet) {
                if (isFirstRow) {
                    isFirstRow = false; // Đánh dấu đã xử lý xong hàng đầu tiên
                    continue; // Bỏ qua hàng đầu tiên
                }

                // Duyệt qua các ô trong hàng
                for (Cell cell : row) {


                    System.out.println("fsdfsd3"
                            );
                  quanLyOto.themOto(oto);

                }
             //   System.out.println(); // Xuống dòng sau mỗi hàng
            }
        } catch (FileNotFoundException e) {
            System.out.println("File không tìm thấy: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }




    }


}
