package com.openlibrary.Model;

// BookService.java (Singleton)
import java.util.ArrayList;
import java.util.List;

import com.openlibrary.Service.Observer;

public class BookService {
    private static BookService instance;
    private List<Book> books;

    private BookService() {
        books = new ArrayList<>();
    }

    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        notifyObservers(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }
    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id);
        notifyObservers(null);
    }

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(Book book) {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }
}
