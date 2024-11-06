package com.openlibrary.library;

public class Book {
    private int id;
    private String title, author, description, imgLink;
    private int year;

    public Book(BookBuilder builder){
        this.id = builder.id;
        this.title = builder.title;
        this.author = builder.author;
        this.description = builder.description;
        this.year = builder.year;
        this.imgLink = builder.imgLink;
    }

    public String getAuthor() {
        return author;
    }
    public String getDescription() {
        return description;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getImgLink() {
        return imgLink;
    }
    public int getYear() {
        return year;
    }

    public static class BookBuilder{
        private int id;
        private int year;
        private String title, author, description, imgLink;

        public BookBuilder setId(int id){
            this.id = id;
            return this;
        }
        public BookBuilder setYear(int year){
            this.year = year;
            return this;
        }
        public BookBuilder setTitle(String title){
            this.title = title;
            return this;
        }
        public BookBuilder setAuthor(String author){
            this.author = author;
            return this;
        }
        public BookBuilder setDescription(String description){
            this.description = description;
            return this;
        }
        public BookBuilder setImgLink(String imgLink){
            this.imgLink = imgLink;
            return this;
        }
        public Book build(){
            return new Book(this);
        }
    }
}
