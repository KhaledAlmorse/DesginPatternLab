package library.core;

public class Book implements BookInterface {
    private String title;
    private boolean isAvailable;

    public Book(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void borrowBook(User user) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(user.getName() + " borrowed: " + title);
        } else {
            System.out.println(title + " is not available.");
        }
    }

    @Override
    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }
}