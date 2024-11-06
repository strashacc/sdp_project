package com.openlibrary.Model;

// BookFactory.java Factory pattern
public class BookFactory {
    public static Book createBook(String type, int id, String title, String author, String imgLink) {
        if (type.equalsIgnoreCase("Science")) {
            return new ScienceBook(id, title, author, imgLink);
        } else if (type.equalsIgnoreCase("Literature")) {
            return new LiteratureBook(id, title, author, imgLink);
        } else {
            return new Book(id, title, author, imgLink);
        }
    }
}

// Different types of books extending the Book class
class ScienceBook extends Book {
    public ScienceBook(int id, String title, String author, String imgLink) {
        super(id, title, author, imgLink);
    }
}

class LiteratureBook extends Book {
    public LiteratureBook(int id, String title, String author, String imgLink) {
        super(id, title, author, imgLink);
    }
}
