package library.LibraryServerJava.services;

import library.LibraryServerJava.models.Loan;
import library.LibraryServerJava.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    LoanRepository loanRepository;

    // CREATE a loan.
    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
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
    public Loan updateLoan(Loan loan) {
        return loanRepository.save(loan);
    }
}