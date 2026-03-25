import library.adapter.BookAdapter;
import library.adapter.ExternalBookData;
import library.core.Book;
import library.core.BookInterface;
import library.core.User;
import library.decorator.PremiumBookDecorator;
import library.facade.LibraryFacade;
import library.factory.BookFactory;
import library.models.EBook;
import library.proxy.EBookProxy;

public class Main {
    public static void main(String[] args) {

        //  Singleton
        LibraryFacade library = new LibraryFacade();
        System.out.println("=== Library Management System ===\n");

        // Users
        User john = new User("John", true);
        User alice = new User("Alice", false);

        //  Factory Method
        Book harryPotter = BookFactory.createBook(BookFactory.BookType.PHYSICAL, "Harry Potter");
        Book lotr = BookFactory.createBook(BookFactory.BookType.HISTORICAL, "Lord of the Rings");
        EBook dpatterns = (EBook) BookFactory.createBook(BookFactory.BookType.EBOOK, "Design Patterns");

        //  Decorator
        BookInterface premiumHarryPotter = new PremiumBookDecorator(harryPotter);

        //  Proxy
        BookInterface protectedEBook = new EBookProxy(dpatterns);

        library.addBook(premiumHarryPotter);
        library.addBook(lotr);
        library.addBook(protectedEBook);

        //  Adapter
        ExternalBookData externalData = new ExternalBookData("Clean Code", true, "Robert Martin", 2008);
        BookInterface adaptedBook = new BookAdapter(externalData);
        library.addBook(adaptedBook);

        //  Observer
        library.subscribeForNotifications(john);
        library.subscribeForNotifications(alice);

        System.out.println("---  Decorator + Proxy ---");
        library.borrowBook("Harry Potter", john);
        library.borrowBook("Design Patterns", alice);
        library.borrowBook("Design Patterns", john);

        System.out.println("\n---  Adapter ---");
        library.borrowBook("Clean Code by Robert Martin (2008)", alice);

        System.out.println("\n---  Observer (return triggers notification) ---");
        library.returnBook("Harry Potter");

        System.out.println("\n---  Chain of Responsibility ---");
        library.borrowBook("Lord of the Rings", alice, 5);
        library.borrowBook("Lord of the Rings", john, 10);
        library.borrowBook("Lord of the Rings", john, 20);
    }
}