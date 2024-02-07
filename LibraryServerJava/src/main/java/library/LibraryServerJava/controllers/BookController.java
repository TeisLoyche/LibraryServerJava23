package library.LibraryServerJava.controllers;

import library.LibraryServerJava.models.Book;
import library.LibraryServerJava.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/books")
public class BookController {
    @Autowired
    BookService bookService;

    // CREATE a book.
    @PostMapping()
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    // DELETE a book based on ID.
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable String id) {
        return bookService.deleteBook(id);
    }

    // GET a book by ID.
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable String id) {
        return bookService.getBookById(id); }

    // GET ALL books.
    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    // UPDATE a book.
    @PutMapping()
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }
}