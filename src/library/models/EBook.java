package library.models;
import library.core.Book;
import library.core.User;

public class EBook extends Book {
    public EBook(String title) {
        super(title);
    }

    @Override
    public void borrowBook(User user) {
        System.out.println(user.getName() + " borrowed the e-book: " + getTitle());
    }
}
