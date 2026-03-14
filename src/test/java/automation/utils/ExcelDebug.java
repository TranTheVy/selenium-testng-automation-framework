package automation.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class ExcelDebug {
    public static void main(String[] args) throws Exception {
        String path = "src/test/resources/login-data.xlsx";
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream file = new FileInputStream(path);
             Workbook workbook = WorkbookFactory.create(file)) {
            Sheet sheet = workbook.getSheetAt(0);

            System.out.println("Excel path: " + path);
            System.out.println("Rows: " + sheet.getPhysicalNumberOfRows());

            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    System.out.println(i + ": <null row>");
                    continue;
                }
                String c0 = formatter.formatCellValue(row.getCell(0)).trim();
                String c1 = formatter.formatCellValue(row.getCell(1)).trim();
                System.out.println(i + ": [" + c0 + "] [" + c1 + "]");
            }
        }
    }
}
