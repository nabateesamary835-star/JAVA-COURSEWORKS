package Library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the community library that holds collections of books and members.
 * Provides operations to add books, register members, lend/return books, and search.
 */
public class Library {
    private List<Book> books;
    private List<Member> members;

    /**
     * Creates an empty library.
     */
    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    /**
     * Adds a book to the library collection.
     * @param book the book to add
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Registers a new member with the library.
     * @param member the member to register
     */
    public void registerMember(Member member) {
        members.add(member);
    }

    /**
     * Lends a book to a member.
     * Enforces the business rule: a book may be on at most one active loan at any time.
     * @param book the book to lend
     * @param member the member borrowing the book
     * @return true if the loan was successful, false otherwise
     */
    public boolean lendBook(Book book, Member member) {
        if (!book.isAvailable()) {
            System.out.println("REJECTED: \"" + book.getTitle() + "\" is currently on loan and cannot be lent again.");
            return false;
        }

        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(14);

        Loan loan = new Loan(member, book, borrowDate, dueDate);
        book.setAvailable(false);
        member.addLoan(loan);

        System.out.println("SUCCESS: \"" + book.getTitle() + "\" lent to " + member.getName() +
                ". Due date: " + dueDate);
        return true;
    }

    /**
     * Returns a book from a member, making it available again.
     * @param book the book being returned
     * @param member the member returning the book
     * @return true if the return was successful, false if the member doesn't have this book
     */
    public boolean returnBook(Book book, Member member) {
        Loan found = null;

        for (Loan loan : member.getLoans()) {
            if (loan.getBook().equals(book)) {
                found = loan;
                break;
            }
        }

        if (found != null) {
            member.removeLoan(found);
            book.setAvailable(true);
            System.out.println("SUCCESS: \"" + book.getTitle() + "\" returned by " + member.getName());
            return true;
        } else {
            System.out.println("FAILED: " + member.getName() + " does not have \"" + book.getTitle() + "\" on loan.");
            return false;
        }
    }

    /**
     * Searches for books by title (case-insensitive partial match).
     * @param title the title to search for
     * @return a list of matching books
     */
    public List<Book> searchByTitle(String title) {
        List<Book> matches = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matches.add(book);
            }
        }
        return matches;
    }

    /**
     * Displays the current state of the library.
     */
    public void displayStatus() {
        System.out.println("===== LIBRARY STATUS =====");
        System.out.println("\nBooks in collection:");
        for (Book book : books) {
            System.out.println("  " + book);
        }
        System.out.println("\nRegistered members:");
        for (Member member : members) {
            System.out.println("  " + member);
            for (Loan loan : member.getLoans()) {
                System.out.println("    * " + loan);
            }
        }
        System.out.println("==========================\n");
    }

    // Getters
    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }
}
