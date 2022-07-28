package m2.clip03;

public class BookService_Assertion {

    public static void main(String[] args) {
        new BookService_Assertion().isBookReadyForPublication(null);
    }

    // Don't forget to enable assertions by using -ea when running the program
    public boolean isBookReadyForPublication(Book book) {
        assert book != null : "Book is null";

        // ...

        return false;
    }
}
