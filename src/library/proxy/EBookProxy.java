package library.proxy;

import library.core.BookInterface;
import library.core.User;
import library.models.EBook;

public class EBookProxy implements BookInterface {

    private final EBook eBook;

    public EBookProxy(EBook eBook) {
        this.eBook = eBook;
    }

    @Override
    public void borrowBook(User user) {
        if (user.isPremium()) {
            eBook.borrowBook(user);
        } else {
            System.out.println("[Access Denied] \"" + eBook.getTitle()
                    + "\" is a premium e-book. Upgrade your account to access it.");
        }
    }

    @Override
    public void returnBook() {
        eBook.returnBook();
    }

    @Override
    public String getTitle() {
        return eBook.getTitle();
    }

    @Override
    public boolean isAvailable() {
        return eBook.isAvailable();
    }
}
