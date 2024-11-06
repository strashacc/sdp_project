package com.openlibrary.Model;

// ExternalBook.java (Simulating an external API's book format)
class ExternalBook {
    private int uniqueCode;
    private String bookName;
    private String bookAuthor;
    private String bookImgLink;

    public ExternalBook(int uniqueCode, String bookName, String bookAuthor, String bookImgLink) {
        this.uniqueCode = uniqueCode;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookImgLink = bookImgLink;
    }

    public int getUniqueCode() { return uniqueCode; }
    public String getBookName() { return bookName; }
    public String getBookAuthor() { return bookAuthor; }
    public String getBookImgLink() { return bookImgLink; }
}

// ExternalBookAdapter.java
public class ExternalBookAdapter extends Book {
    public ExternalBookAdapter(ExternalBook externalBook) {
        super(externalBook.getUniqueCode(), externalBook.getBookName(), externalBook.getBookAuthor(), externalBook.getBookImgLink());
    }
}

