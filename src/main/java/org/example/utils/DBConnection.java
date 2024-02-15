package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
    private final String host = "localhost";
    private final String port = "5432";
    private final String databaseName = "postgres";
    private final String userName = "postgres";
    private final String password = "1234";


    public Connection getConnection() {
        Connection conn = null;
        try {
            String password = "";
            conn = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/"+ databaseName,
                    userName, password);
            System.out.println("Connection was successful");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}

