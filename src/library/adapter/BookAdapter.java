package library.adapter;

import library.core.BookInterface;
import library.core.User;

public class BookAdapter implements BookInterface {

    private final ExternalBookData externalData;
    private boolean available;

    public BookAdapter(ExternalBookData externalData) {
        this.externalData = externalData;
        this.available = externalData.isBorrowable;
    }

    @Override
    public String getTitle() {
        // Map external "bookTitle" → our "title"
        return externalData.bookTitle + " by " + externalData.authorName + " (" + externalData.year + ")";
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void borrowBook(User user) {
        if (available) {
            available = false;
            System.out.println("[Adapted] " + user.getName() + " borrowed external book: " + getTitle());
        } else {
            System.out.println("[Adapted] " + getTitle() + " is not borrowable.");
        }
    }

    @Override
    public void returnBook() {
        available = true;
        System.out.println("[Adapted] " + getTitle() + " has been returned.");
    }
}