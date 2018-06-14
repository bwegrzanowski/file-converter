package pl.sda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader implements SdaFileReader{
    @Override
        public List<Book> read(String filePath)  throws IOException {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String[] headers = null;
            String line;
            List<Book> books = new ArrayList<>();
            int i = 0;

            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                if (i == 0) {
                    headers = line.split(";");
                    i++;
                } else {
                    Book parsedBook = parseCsvRow(headers, line);
                    books.add(parsedBook);
                }
            }
            return books;
        }

        private Book parseCsvRow(String[] headers, String line) {
            Book book = new Book();
            String[] values = line.split(";");

            for (int i = 0; i < headers.length; i++) {
                setBookFieldFromCsvFile(book, headers[i], values[i]);
            }

            return book;
        }

        private void setBookFieldFromCsvFile(Book book, String header, String value) {
            if ("title".equals(header)) {
                book.setTitle(value);
            }
            if ("authorsFirstName".equals(header)) {
                book.setAuthorsFirstName(value);
            }
            if ("authorsLastName".equals(header)) {
                book.setAuthorsLastName(value);
            }
            if ("ISBN".equals(header)) {
                book.setISBN(value);
            }
            if ("releaseYear".equals(header)) {
                book.setReleaseYear(Integer.parseInt(value));
            }
        }

}

