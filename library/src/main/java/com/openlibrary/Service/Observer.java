package com.openlibrary.Service;

import com.openlibrary.Model.Book;

public interface Observer {
    void update(Book book);
}