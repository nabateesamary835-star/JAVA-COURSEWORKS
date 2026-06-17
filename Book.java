package Library;

/**
 * Represents a book in the community library system.
 * Each book has an ISBN, title, author, and availability status.
 */
public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean available;

    /**
     * Constructor 1 - creates a book with ISBN and title only.
     * @param isbn the unique identifier for the book
     * @param title the title of the book
     */
    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.author = "Not Specified";
        this.available = true;
    }

    /**
     * Constructor 2 (overloaded) - creates a book with ISBN, title, and author.
     * @param isbn the unique identifier for the book
     * @param title the title of the book
     * @param author the author of the book
     */
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book [ISBN=" + isbn + ", Title=" + title + ", Author=" + author + ", Available=" + available + "]";
    }
}
