package pl.sda;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONFileReader {
    public List<Book> readBookData(String filePath) throws IOException {
        List<Book> result = new ArrayList<>();

        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String json = new String(bytes, "UTF-8");

        JSONObject jsonObject = new JSONObject(json);

        String rootKey = jsonObject.keySet().iterator().next();

        JSONArray rawValues = new JSONArray(jsonObject.get(rootKey).toString());

        for (Object rawValue : rawValues) {
            JSONObject value = new JSONObject(rawValue.toString());
            String title = value.get("title").toString();
            String authorsFirstName = value.get("authorsFirstName").toString();
            String authorsLastName = value.get("authorsLastName").toString();
            String ISBN = value.get("ISBN").toString();
            Integer releaseYear = Integer.parseInt(value.get("releaseYear").toString());

            Book book = new Book();
            book.setTitle(title);
            book.setAuthorsFirstName(authorsFirstName);
            book.setAuthorsLastName(authorsLastName);
            book.setISBN(ISBN);
            book.setReleaseYear(releaseYear);

            result.add(book);
        }
        return result;
    }
}
