package com.openlibrary.Controller;

import com.openlibrary.Model.Book;
import com.openlibrary.Model.BookFactory;
import com.openlibrary.Model.BookService;




public class AddBookCommand implements Command {
    private BookService bookService;
    private Book book;
    public static Book lastAddedBook;


    public AddBookCommand(BookService bookService, Book book) {
        this.bookService = bookService;
        this.book = book;
        lastAddedBook = book; // Keep track of the last added book
    }

    public AddBookCommand(BookService bookService, String type, int id, String title, String author, String imgLink) {
        this.bookService = bookService;
        this.book = BookFactory.createBook(type, id, title, author, imgLink);
        lastAddedBook = this.book; // Keep track of the last added book
    }



    @Override
    public void execute() {
        bookService.addBook(book);
    }
   


    }


