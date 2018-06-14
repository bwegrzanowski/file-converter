package pl.sda;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class CsvWriter implements SdaFilaWriter {

    @Override
    public void write(List<Book> books, String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        final int classLength = Book.class.getDeclaredFields().length;


        final Field[] declaredFields = Book.class.getDeclaredFields();
        for (int i = 0; i < classLength - 1; i++) {
            bufferedWriter.write(declaredFields[i].getName());
            bufferedWriter.write(";");
        }
        bufferedWriter.write(declaredFields[classLength - 1].getName());
        bufferedWriter.newLine();

        for (Book book : books) {
//          temporary, non-generic solution
            bufferedWriter.write(book.getTitle());
            bufferedWriter.write(";");
            bufferedWriter.write(book.getAuthorsFirstName());
            bufferedWriter.write(";");
            bufferedWriter.write(book.getAuthorsLastName());
            bufferedWriter.write(";");
            bufferedWriter.write(book.getISBN());
            bufferedWriter.write(";");
            bufferedWriter.write(String.valueOf(book.getReleaseYear()));
            bufferedWriter.write("\r\n");

        }


        bufferedWriter.close();
        fileWriter.close();
    }
}
