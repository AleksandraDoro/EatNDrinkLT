package org.example.utils;


public enum QueryTypes {

    SELECT("SELECT * from items_table"),
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
