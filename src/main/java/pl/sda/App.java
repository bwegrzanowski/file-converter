package pl.sda;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        final String readFilePath = "D:\\Programy\\SDA java projects\\converter\\src\\main\\resources\\books.csv";
        final String writeFilePath = "D:\\Programy\\SDA java projects\\converter\\src\\main\\resources\\csvWriter.csv";

        CsvReader csvReader = new CsvReader();
        JSONFileReader jsonFileReader = new JSONFileReader();

        List<Book> bookList = new ArrayList<>();

        try {
            bookList = csvReader.read(readFilePath);
            for (Book book : bookList) {
                System.out.println('\n' + book.getTitle() + " " + book.getAuthorsFirstName() + " "
                        + book.getAuthorsLastName() + " " + book.getReleaseYear());
            }
        } catch (IOException e) {
            System.out.println("ERROR");
        }
        CsvWriter csvWriter = new CsvWriter();
        csvWriter.write(bookList, writeFilePath);


        ExcelFileReader excelFileReader = new ExcelFileReader();
        bookList = excelFileReader.readBookData("D:\\Programy\\SDA java projects\\converter\\src\\main\\resources\\books.xlsx");
        System.out.println(bookList);

        ExcelFileWriter excelFileWriter = new ExcelFileWriter();
        excelFileWriter.write("D:\\Programy\\SDA java projects\\converter\\src\\main\\resources\\excelResult.xlsx", bookList);

        List<Book> books = jsonFileReader.readBookData("D:\\Programy\\SDA java projects\\converter\\src\\main\\resources\\books.json");
        System.out.println(books);

        JSONFileWriter jsonFileWriter = new JSONFileWriter();
        jsonFileWriter.write("D:\\Programy\\SDA java projects\\converter\\src\\main\\resources\\jsonWriter.json", books);

    }
}
