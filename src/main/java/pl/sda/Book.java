package pl.sda;

import java.util.Objects;

public class Book {
    private String title;
    private String authorsFirstName;
    private String authorsLastName;
    private String ISBN;
    private int releaseYear;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return releaseYear == book.releaseYear &&
                Objects.equals(title, book.title) &&
                Objects.equals(authorsFirstName, book.authorsFirstName) &&
                Objects.equals(authorsLastName, book.authorsLastName) &&
                Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public String toString() {
        return title + "\t" + authorsFirstName + "\t" + authorsLastName + "\t" + ISBN +"\t" + releaseYear;
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, authorsFirstName, authorsLastName, ISBN, releaseYear);
    }

    public Book() {
    }

    public Book(String title, String authorsFirstName, String authorsLastName, String ISBN, int releaseYear) {
        this.title = title;
        this.authorsFirstName = authorsFirstName;
        this.authorsLastName = authorsLastName;
        this.ISBN = ISBN;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorsFirstName() {
        return authorsFirstName;
    }

    public void setAuthorsFirstName(String authorsFirstName) {
        this.authorsFirstName = authorsFirstName;
    }

    public String getAuthorsLastName() {
        return authorsLastName;
    }

    public void setAuthorsLastName(String authorsLastName) {
        this.authorsLastName = authorsLastName;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
