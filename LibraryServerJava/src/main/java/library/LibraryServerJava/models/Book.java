package library.LibraryServerJava.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Books")
public class Book {
    @Id
    private String id;

    private String title;

    private String author;

    private String description;

    private int pages;

    public Book() {
    }

    // GETTERS.

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public int getPages() {
        return pages;
    }
}