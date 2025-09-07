package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileOperations {

    /**
     * Reads data from an Excel sheet and returns it as a Map.
     *
     * @param filePath  Path of the Excel file.
     * @param sheetName Name of the sheet to read.
     * @return Map<String, String> containing key-value pairs from the sheet.
     * @throws IOException if the file is not found or cannot be read.
     */
    public static Map<String, String> readDataFromExcel(String filePath, String sheetName) throws IOException {
        Map<String, String> data = new HashMap<>();

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        for (Row row : sheet) {
            Cell keyCell = row.getCell(0);
            Cell valueCell = row.getCell(1);

            if (keyCell != null && valueCell != null) {
                data.put(keyCell.toString().trim(), valueCell.toString().trim());
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
}
