package Library;

/**
 * Driver class to demonstrate the Library Management System.
 * Creates books, members, and performs lend/return operations.
 */
public class LibraryDemo {
    public static void main(String[] args) {
        Library library = new Library();

        // Create books with different constructors
        Book book1 = new Book("978-0-13-468599-1", "Effective Java");
        Book book2 = new Book("978-0-596-00712-6", "Head First Java", "Kathy Sierra");
        Book book3 = new Book("978-0-13-235088-4", "Clean Code", "Robert C. Martin");

        // Register members
        Member member1 = new Member("M001", "Alice Nakamya");
        Member member2 = new Member("M002", "Brian Ochieng");

        // Add books and members to library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.registerMember(member1);
        library.registerMember(member2);

        // Display initial state
        System.out.println(">>> INITIAL STATE <<<");
        library.displayStatus();

        // Perform lend operations
        System.out.println(">>> PERFORMING LEND OPERATIONS <<<\n");
        library.lendBook(book1, member1);
        library.lendBook(book2, member1);
        library.lendBook(book2, member2); // Should be rejected

        // Display state after lending
        System.out.println("\n>>> STATE AFTER LENDING <<<");
        library.displayStatus();

        // Return a book
        System.out.println(">>> PERFORMING RETURN OPERATIONS <<<\n");
        library.returnBook(book1, member1);

        // Display final state
        System.out.println("\n>>> FINAL STATE <<<");
        library.displayStatus();

        // Search demonstration
        System.out.println(">>> SEARCH RESULTS FOR 'Java' <<<");
        var results = library.searchByTitle("Java");
        for (Book book : results) {
            System.out.println("  " + book);
        }
    }
}
