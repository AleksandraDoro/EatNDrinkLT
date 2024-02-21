//package org.example.utils;
//
//import org.example.entity.Item;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class CRUDUtils {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public CRUDUtils(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Item> getItems() {
//        String sql = "SELECT id, name FROM items_table";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            String id = rs.getString("id");
//            String name = rs.getString("name");
//            String price = rs.getString("name");
//            return new Item(id, name, price);
//        });
//    }
//
//    public Item getItemByName(String itemName){
//        String sql = "SELECT id, name FROM items_table WHERE name = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{itemName}, (rs, rowNum) -> {
//            String id = rs.getString("id");
//            String name = rs.getString("name");
//            return new Item(id, name);
//        });
//    }
//
////    public Item getItemById(int itemId) {
////        String sql = "SELECT id, name FROM items_table WHERE id = ?";
////        return jdbcTemplate.queryForObject(sql, new Object[]{itemId}, (rs, rowNum) -> {
////            String id = rs.getString("id");
////            String name = rs.getString("name");
////            return new Item(id, name);
////        });
//    }
//
