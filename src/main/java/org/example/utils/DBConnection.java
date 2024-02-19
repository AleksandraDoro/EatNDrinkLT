package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/template1",
                    "postgres", "");
            System.out.println("Я все еще работаю как надо");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}

