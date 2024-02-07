package library.LibraryServerJava.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document(collection = "Loans")
public class Loan {
    @Id
    private String id;

    private String bookId;

    private String loanedBy;

    @CreatedDate
    private Date loanedAt;

    private LocalDate returnBy = LocalDate.now().plusDays(14);

    public Loan() {
    }

    // GETTERS.

    public String getId() {
        return id;
    }

    public String getBookId() {
        return bookId;
    }

    public String getLoanedBy() {
        return loanedBy;
    }

    public Date getLoanedAt() {
        return loanedAt;
    }

    public LocalDate getReturnBy() {
        return returnBy;
    }

    // SETTER for the return date, in order to be able to update it in postman.

    public void setReturnBy(LocalDate returnBy) {
        this.returnBy = returnBy;
    }
}