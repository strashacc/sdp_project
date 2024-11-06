package com.openlibrary.Model;

public class ExternalBookAdapter extends Book {
    public ExternalBookAdapter(ExternalBook externalBook) {
        super(externalBook.getUniqueCode(), externalBook.getBookName(), externalBook.getBookAuthor(), externalBook.getBookImgLink());
    }
}