package Library;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library member who can borrow books.
 * Each member has an ID, name, and a list of active loans.
 */
public class Member {
    private String memberId;
    private String name;
    private List<Loan> loans;

    /**
     * Creates a member with the given ID and name.
     * @param memberId unique identifier for the member
     * @param name the name of the member
     */
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.loans = new ArrayList<>();
    }

    // Getters and Setters
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    /**
     * Adds a loan to this member's active loans.
     * @param loan the loan to add
     */
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    /**
     * Removes a loan from this member's active loans.
     * @param loan the loan to remove
     */
    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    @Override
    public String toString() {
        return "Member [ID=" + memberId + ", Name=" + name + ", Active Loans=" + loans.size() + "]";
    }
}
