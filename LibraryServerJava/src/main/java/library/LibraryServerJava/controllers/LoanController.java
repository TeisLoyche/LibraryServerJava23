package library.LibraryServerJava.controllers;

import library.LibraryServerJava.models.Loan;
import library.LibraryServerJava.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/loans")
public class LoanController {
    @Autowired
    LoanService loanService;

    // CREATE a loan.
    @PostMapping()
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.createLoan(loan);
    }

    // DELETE a loan based on ID.
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteLoan(@PathVariable String id) {
        return loanService.deleteLoan(id);
    }
    // GET a loan by ID.
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Loan getLoanById(@PathVariable String id) {
        return loanService.getLoanById(id); }

    // GET ALL loans.
    @GetMapping("/all")
    public List<Loan> getAllLoans(){
        return loanService.getAllLoans();
    }

    // UPDATE a loan.
    @PutMapping()
    public Loan updateLoan(@RequestBody Loan loan) {
        return loanService.updateLoan(loan);
    }
}