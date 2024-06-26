package library.LibraryServerJava.repository;

import library.LibraryServerJava.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}