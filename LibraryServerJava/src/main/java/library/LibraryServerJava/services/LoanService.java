package library.LibraryServerJava.services;

import library.LibraryServerJava.exception.EntityNotFoundException;
import library.LibraryServerJava.models.Book;
import library.LibraryServerJava.models.Loan;
import library.LibraryServerJava.models.User;
import library.LibraryServerJava.repository.BookRepository;
import library.LibraryServerJava.repository.LoanRepository;
import library.LibraryServerJava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    LoanRepository loanRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    // CREATE a loan.
    public Loan createLoan(String userId, String bookId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found."));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found."));

        Loan newLoan = new Loan();

        newLoan.setBook(book);
        newLoan.setLoanedBy(user);
        newLoan.setLoanedAt(newLoan.getLoanedAt());
        newLoan.setReturnBy(newLoan.getReturnBy());

        return loanRepository.save(newLoan);
    }

    // DELETE a loan.
    public String deleteLoan(String id) {
        loanRepository.deleteById(id);
        return "Loan successfully deleted!";
    }

    // GET a loan by ID.
    public Loan getLoanById(String id) {
        return loanRepository.findById(id).get();
    }

    // GET all loans.
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    // UPDATE a loan.
    public Loan updateLoan(String id, Loan updatedLoan) {
        return loanRepository.findById(id).map(existingLoan -> {
            if (updatedLoan.getBook() != null) {
                existingLoan.setBook(updatedLoan.getBook());
            }
            if (updatedLoan.getLoanedBy() != null) {
                existingLoan.setLoanedBy(updatedLoan.getLoanedBy());
            }
            if (updatedLoan.getLoanedAt() != null) {
                existingLoan.setLoanedAt(updatedLoan.getLoanedAt());
            }
            if (updatedLoan.getReturnBy() != null) {
                existingLoan.setReturnBy(updatedLoan.getReturnBy());
            }
            return loanRepository.save(existingLoan);
        })
                .orElseThrow(() -> new EntityNotFoundException("Loan with id " + id + " was not found."));
    }
}