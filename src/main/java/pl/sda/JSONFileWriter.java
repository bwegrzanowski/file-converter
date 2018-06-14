package pl.sda;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JSONFileWriter {
    public void write(String filePath, List<Book> bookList) {
        try {

            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            JSONArray jsonArray = new JSONArray();
            for (Book book : bookList) {
                JSONObject bookJson = new JSONObject();
                bookJson.put("title", book.getTitle());
                bookJson.put("authorsFirstName", book.getAuthorsFirstName());
                bookJson.put("authorsLastName", book.getAuthorsLastName());
                bookJson.put("ISBN", book.getISBN());
                bookJson.put("releaseYear", book.getReleaseYear());
                jsonArray.put(bookJson);
            }

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("jsonWriter", jsonArray);

            bufferedWriter.write(jsonObject.toString());

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
