package library.LibraryServerJava.repository;

import library.LibraryServerJava.models.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanRepository extends MongoRepository<Loan, String> {
}
