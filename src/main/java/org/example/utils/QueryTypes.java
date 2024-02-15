package org.example.utils;


public enum QueryTypes {
    INSERT("INSERT INTO items_table VALUES(?,?)"),
    SELECT("SELECT * from items_table"),
    UPDATE("UPDATE items_table set name = ? where id = ?"),
    DELETE("DELETE From items_table WHERE name = ?"),
    ORDER("SELECT * FROM items_table ORDER BY id"),
    SELECTID("SELECT name from items_table where id = ?"),
    SELECTNAME("SELECT id from items_table where name = ?");


    private final String query;

    QueryTypes(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
