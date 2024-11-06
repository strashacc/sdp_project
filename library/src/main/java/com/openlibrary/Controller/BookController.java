package com.openlibrary.Controller;
import com.openlibrary.Model.Book;
import com.openlibrary.Model.BookService;

import java.util.List;

// BookController.java
public class BookController {
    private BookService bookService;

    public BookController() {
        this.bookService = BookService.getInstance();
    }

    public void addBook(String type, int id, String title, String author, String imgLink) {
        // Create an AddBookCommand with the new constructor
        AddBookCommand addCommand = new AddBookCommand(BookService.getInstance(), type, id, title, author, imgLink);
        addCommand.execute();
    }

    public void undoAddBook() {
        AddBookCommand addCommand = new AddBookCommand(BookService.getInstance(), AddBookCommand.lastAddedBook);
        addCommand.undo(); // This will now reference the last added book
    }


    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}

