package org.example.utils;

import org.example.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CRUDUtils {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CRUDUtils(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Item> getItems() {
        String sql = "SELECT id, name FROM items_table";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            String id = rs.getString("id");
            String name = rs.getString("name");
            return new Item(id, name);
        });
    }

    public void addItem(String id, String name) {
        String sql = "INSERT INTO items_table (id, name) VALUES (?, ?)";
        jdbcTemplate.update(sql, id, name);
    }

    public void updateItem(String id, String name) {
        String sql = "UPDATE items_table SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, id);
    }

    public void deleteItem(String id) {
        String sql = "DELETE FROM items_table WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
