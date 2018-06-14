package pl.sda;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelFileWriter {
    public void write(String filepath, List<Book> bookList) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("books");

        int rowCount = 0;
        Row headerRow = sheet.createRow(rowCount++);

        String[] headers = new String[]{"title", "authorsFirstName", "authorsLastName", "ISBN", "releaseYear"};
        int cellCount = 0;

        for (String header : headers) {
            Cell cell = headerRow.createCell(cellCount++);
            cell.setCellValue(header);
        }
        for (Book book : bookList) {

            cellCount = 0;
            Row row = sheet.createRow(rowCount++);

            Cell cellTitle = row.createCell(cellCount++);
            cellTitle.setCellValue(book.getTitle());

            Cell cellAuthorsFirstName = row.createCell(cellCount++);
            cellAuthorsFirstName.setCellValue(book.getAuthorsFirstName());

            Cell cellAuthorsLastName = row.createCell(cellCount++);
            cellAuthorsLastName.setCellValue(book.getAuthorsLastName());

            Cell cellISBN = row.createCell(cellCount++);
            cellISBN.setCellValue(book.getISBN());

            Cell cellReleaseYear = row.createCell(cellCount++);
            cellReleaseYear.setCellValue(book.getReleaseYear());
        }

        FileOutputStream fileOutputStream = new FileOutputStream(new File(filepath));
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
}
