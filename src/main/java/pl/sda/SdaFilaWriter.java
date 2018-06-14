package pl.sda;

import java.io.IOException;
import java.util.List;

public interface SdaFilaWriter {
    public void write(List<Book> books, String filePath) throws IOException;
}
