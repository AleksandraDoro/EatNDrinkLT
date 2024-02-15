package org.example;

import org.example.database.DBConnection;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Application {
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        dbConnection.getConnection();

    }
}