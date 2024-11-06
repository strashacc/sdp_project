package com.openlibrary.Controller;


import com.openlibrary.Model.BookService;

public class RemoveBookCommand implements Command {
    private BookService bookService;
    private int bookId;

    public RemoveBookCommand(BookService bookService, int bookId) {
        this.bookService = bookService;
        this.bookId = bookId;
    }

    @Override
    public void execute() {
        bookService.removeBook(bookId);
        bookService.setLastCommand(this);
    }


}
