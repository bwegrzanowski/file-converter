package pl.sda;

import java.io.IOException;
import java.util.List;

public interface SdaFileReader {
    List<Book> read(String filePath) throws IOException;
}
