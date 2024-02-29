package library.LibraryServerJava.controllers;

import library.LibraryServerJava.exception.EntityNotFoundException;
import library.LibraryServerJava.models.Loan;
import library.LibraryServerJava.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/loans")
public class LoanController {
    @Autowired
    LoanService loanService;

    // CREATE a loan.
    @PostMapping()
    public Loan createLoan(@RequestParam String userId, String bookId) {
        return loanService.createLoan(userId, bookId);
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
    @PutMapping("/{id}")
    public ResponseEntity<?> updateLoan(@PathVariable String id, @RequestBody Loan loanDetails) {
        try {
            Loan updatedLoan = loanService.updateLoan(id, loanDetails);
            return ResponseEntity.ok(updatedLoan);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}