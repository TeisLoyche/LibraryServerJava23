package library.LibraryServerJava.services;

import library.LibraryServerJava.models.Book;
import library.LibraryServerJava.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    // CREATE a book.
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // DELETE a book.
    public String deleteBook(String id) {
        bookRepository.deleteById(id);
        return "Book successfully deleted!";
    }

    // GET a book by ID.
    public Book getBookById(String id) {
        return bookRepository.findById(id).get();
    }

    // GET all books.
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // UPDATE a book.
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }
}