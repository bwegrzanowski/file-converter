package pl.sda;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelFileReader {
    public List<Book> readBookData(String filePath) throws IOException {
        List<Book> result = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        List<String> headers = new ArrayList<>();
        Row headerRow = rowIterator.next();

        Iterator<Cell> headerRowIterator = headerRow.iterator();
        while (headerRowIterator.hasNext()) {
            Cell cell = headerRowIterator.next();
            headers.add(cell.getStringCellValue());
        }


        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Book book = new Book();
            Iterator<Cell> cellIterator = row.iterator();
            int i = 0;

//          possible better solution (in case you have numerical
//          formatted field and String defined class field):
//            DataFormatter formatter = new DataFormatter();
//            Cell cell = sheet.getRow(i).getCell(0);
//            String j_username = formatter.formatCellValue(cell);

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                CellType cellType = cell.getCellTypeEnum();
                String value = CellType.NUMERIC.equals(cellType)
                        ? ((Double) cell.getNumericCellValue()).toString()
                        : cell.getStringCellValue();

                setBookFieldValue(book, headers.get(i), value);
                i++;
            }
            result.add(book);
        }

        return result;
    }

    private void setBookFieldValue(Book book, String headers, String value) {
        if ("title".equals(headers)) {
            book.setTitle(value);
        }
        if ("authorsFirstName".equals(headers)) {
            book.setAuthorsFirstName(value);
        }
        if ("authorsLastName".equals(headers)) {
            book.setAuthorsLastName(value);
        }
        if ("ISBN".equals(headers)) {
            book.setISBN(value);
        }
        if ("releaseYear".equals(headers)) {
            Double doubleValue = Double.parseDouble(value);
            book.setReleaseYear(doubleValue.intValue());
        }
    }
}
