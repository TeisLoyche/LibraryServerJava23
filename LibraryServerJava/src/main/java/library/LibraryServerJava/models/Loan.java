package library.LibraryServerJava.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document(collection = "Loans")
public class Loan {
    @Id
    private String id;

    @DBRef
    private Book book;

    @DBRef
    private User loanedBy;

    @CreatedDate
    private Date loanedAt;

    private LocalDate returnBy = LocalDate.now().plusDays(14);

    public Loan() {
    }

    // GETTERS.

    public String getId() {
        return id;
    }

    public Date getLoanedAt() {
        return loanedAt;
    }

    public LocalDate getReturnBy() {
        return returnBy;
    }

    public Book getBook() {
        return book;
    }

    public User getLoanedBy() {
        return loanedBy;
    }

    // SETTERS.

    public void setReturnBy(LocalDate returnBy) {
        this.returnBy = returnBy;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setLoanedBy(User loanedBy) {
        this.loanedBy = loanedBy;
    }

    public void setLoanedAt(Date loanedAt) {
        this.loanedAt = loanedAt;
    }
}