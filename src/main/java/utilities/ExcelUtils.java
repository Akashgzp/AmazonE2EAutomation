package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {

    Workbook workbook;

    Sheet sheet;

    public ExcelUtils(String path) throws Exception {

        workbook = WorkbookFactory.create(
                new FileInputStream(path));

    }

    public int getRowCount(String sheetName) {

        sheet = workbook.getSheet(sheetName);

        return sheet.getLastRowNum();

    }

    public int getCellCount(String sheetName) {

        sheet = workbook.getSheet(sheetName);

        return sheet.getRow(0).getLastCellNum();

    }

    public String getCellData(String sheetName,int row,int col) {

        sheet = workbook.getSheet(sheetName);

        return sheet.getRow(row)
                .getCell(col)
                .toString();

    }

}