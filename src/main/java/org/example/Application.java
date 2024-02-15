package org.example;

import org.example.utils.CRUDUtils;
import org.example.utils.DBConnection;

public class Application {
//    public static void main(String[] args) {
//        DBConnection dbConnection = new DBConnection();
//        dbConnection.getConnection();

        public static void main(String[] args) {
                  CRUDUtils crudUtils = new CRUDUtils();
            System.out.println(crudUtils.addItem("1", "Буханка"));

    }
}