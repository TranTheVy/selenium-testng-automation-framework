package automation.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    public static Object[][] getLoginData() throws IOException {

        DataFormatter formatter = new DataFormatter();
        try (FileInputStream file = new FileInputStream("src/test/resources/login-data.xlsx");
             Workbook workbook = WorkbookFactory.create(file)) {

            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getPhysicalNumberOfRows();
            if (rowCount < 2) {
                throw new IllegalStateException("No login data found in Excel (need at least 1 data row).");
            }

            List<Object[]> data = new ArrayList<>();

            for (int i = 1; i < rowCount; i++) {

                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }

                String username = formatter.formatCellValue(row.getCell(0)).trim();
                String password = formatter.formatCellValue(row.getCell(1)).trim();
                String expected = row.getCell(2).getStringCellValue();
                if (username.isEmpty() && password.isEmpty()) {
                    continue;
                }

                data.add(new Object[]{username, password, expected});
            }

            if (data.isEmpty()) {
                throw new IllegalStateException("No usable login data rows found in Excel.");
            }

            return data.toArray(new Object[0][]);
        }
    }
}
