package excelauth;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {


    public static String getCellData(int rowNumber, int cellNumber) throws IOException {
        Cell data = null;
        String cellData = null;

        FileInputStream file = null;
        try {
            String dosyaYolu = "src/main/resources/test.xlsx";
            file = new FileInputStream(dosyaYolu);

            Workbook excel = WorkbookFactory.create(file);

            Sheet sheet = excel.getSheetAt(0);
            data = sheet.getRow(rowNumber).getCell(cellNumber);

            if (data != null) {
                cellData = data.toString();
            } else {
                System.out.println("Hücre verisi bulunamadı.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                file.close();

            }
        }
        return cellData;
    }
}







