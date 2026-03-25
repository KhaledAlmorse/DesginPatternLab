package library.decorator;


import library.core.BookInterface;
import library.core.User;

public class PremiumBookDecorator implements BookInterface {

    private final BookInterface wrappedBook;
    private static final int EXTRA_DAYS = 10;

    public PremiumBookDecorator(BookInterface book) {
        this.wrappedBook = book;
    }

    @Override
    public void borrowBook(User user) {
        wrappedBook.borrowBook(user);
        System.out.println("  [Premium] " + user.getName()
                + " gets " + EXTRA_DAYS + " extra borrowing days for: " + wrappedBook.getTitle());
    }

    @Override
    public void returnBook() {
        wrappedBook.returnBook();
    }

    @Override
    public String getTitle() {
        return wrappedBook.getTitle();
    }

    @Override
    public boolean isAvailable() {
        return wrappedBook.isAvailable();
    }
}