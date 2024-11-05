package com.openlibrary.library;

import java.util.Scanner;
import java.sql.*;

public class temp {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:1234/library";
        String user = "postgres";
        String password = "qwerty123";

        try(Connection connection = DriverManager.getConnection(url, user, password)){
            if(connection != null){
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
