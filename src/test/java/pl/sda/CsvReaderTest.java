package pl.sda;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderTest {

    @Test
    public void testRead() throws IOException {
        //given
        CsvReader csvReader = new CsvReader();
        List<Book> result = csvReader.read("D:\\Programy\\SDA java projects\\converter\\src\\test\\resources\\books.csv");
        final Book book1 = new Book("w pustyni i w puszczy", "Henryk", "Sienkiewicz", "83295823958", 1900);
        final Book book2 = new Book("dzieci z bulerbyn", "Jan", "Nowak", "84932752385", 1977);
        final Book book3 = new Book("harry potter", "J.K.", "Rowling", "9432951105", 1998);

        //when
        List<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        //then
        Assert.assertEquals(result, books);

    }
}
