package Library;

import java.time.LocalDate;

/**
 * Represents a loan connecting exactly one member to exactly one book.
 * Records the borrow date and due date.
 */
public class Loan {
    private Member member;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    /**
     * Creates a loan for the given member and book.
     * @param member the member borrowing the book
     * @param book the book being borrowed
     * @param borrowDate the date the book was borrowed
     * @param dueDate the date the book must be returned
     */
    public Loan(Member member, Book book, LocalDate borrowDate, LocalDate dueDate) {
        this.member = member;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    // Getters and Setters
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Loan [Member=" + member.getName() + ", Book=" + book.getTitle() + ", Borrowed=" + borrowDate + ", Due=" + dueDate + "]";
    }
}
