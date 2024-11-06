package com.openlibrary.library;

import java.sql.*;
import java.util.ArrayList;

public class LibraryController {
    private static LibraryController instance;
    private Connection connection;
    private Statement statement;
    private LibraryController() throws SQLException{
        String url = "jdbc:postgresql://localhost:1234/library";
        String user = "postgres";
        String password = "qwerty123";

        this.connection = DriverManager.getConnection(url, user, password);
        this.statement = connection.createStatement();
    }
    public static LibraryController getInstance() throws SQLException{
        if(instance == null)
            instance = new LibraryController();
        return instance;
    }

    public ArrayList<Book> getBooks() throws SQLException{
        ArrayList<Book> returnArrayList = new ArrayList<>();
        ResultSet result = statement.executeQuery("SELECT * FROM books");
        while (result.next()) {
            returnArrayList.add(        new Book.BookBuilder()
                                        .setId(result.getInt("id"))
                                        .setTitle(result.getString("title"))
                                        .setAuthor(result.getString("author"))
                                        .setDescription(result.getString("description"))
                                        .setImgLink(result.getString("img_link"))
                                        .setYear(result.getInt("year"))
                                        .build());
        }
        return returnArrayList;
    }

    public boolean addBook(Book book) throws SQLException{
        return statement.execute(String.format("INSERT INTO books(title, author, description, img_link, year) VALUES('%s', '%s', '%s', '%s', %d);", book.getTitle(), book.getAuthor(), book.getDescription(), book.getImgLink(), book.getYear()));
    }

    public int getUserCount() throws SQLException{
        return this.countRows("users");
    }
    public int getBookCount() throws SQLException{
        return this.countRows("books");
    }

    private int countRows(String table) throws SQLException{
        ResultSet result = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM " + table);
        return result.next() ? result.getInt("rowcount") : 0;
    }
}
