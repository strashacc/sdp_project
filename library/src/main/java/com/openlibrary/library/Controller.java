package com.openlibrary.library;

import java.sql.*;

public class Controller {
    private static Controller instance;
    private Connection connection;
    private Statement statement;
    private Controller() throws SQLException{
        String url = "jdbc:postgresql://localhost:1234/library";
        String user = "postgres";
        String password = "qwerty123";

        this.connection = DriverManager.getConnection(url, user, password);
        this.statement = connection.createStatement();
    }
    public static Controller getInstance() throws SQLException{
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    public int getUserCount() throws SQLException{
        ResultSet result = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM users");
        return result.next() ? result.getInt("rowcount") : 0;
    }
}
