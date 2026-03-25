package library.adapter;

public class ExternalBookData {
    String bookTitle;
    boolean isBorrowable;
    String authorName;
    int year;

    public ExternalBookData(String bookTitle, boolean isBorrowable, String authorName, int year) {
        this.bookTitle = bookTitle;
        this.isBorrowable = isBorrowable;
        this.authorName = authorName;
        this.year = year;
    }
}