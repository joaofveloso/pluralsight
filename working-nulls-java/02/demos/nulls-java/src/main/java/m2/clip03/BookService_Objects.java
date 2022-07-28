package m2.clip03;

import java.util.Objects;

public class BookService_Objects {

    public static void main(String[] args) {
        new BookService_Objects().isBookReadyForPublication(null);
    }

    public boolean isBookReadyForPublication(Book book) {
        Objects.requireNonNull(book, "Book is null");

        // ...

        return false;
    }
}
