package pl.sda;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelFileReaderTest {

    @Test
    public void testRead() throws IOException {
        //given
        ExcelFileReader reader = new ExcelFileReader();

        List<Book> result = reader.readBookData("D:\\Programy\\SDA java projects\\converter\\src\\main\\resources\\books.xlsx");
        final Book book1 = new Book("w pustyni i w puszczy", "Henryk", "Sienkiewicz", "832-958-239", 1900);
        final Book book2 = new Book("dzieci z bulerbyn", "Jan", "Nowak", "849-327-523", 1977);
        final Book book3 = new Book("harry potter", "J.K.", "Rowling", "943-295-110", 1998);

        //when
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        //then
        Assert.assertEquals(books, result);
    }
}
