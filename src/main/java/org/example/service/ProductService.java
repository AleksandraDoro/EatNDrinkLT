package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class ProductService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getProductInfo(String requestedItem) {
        List<String> price = isItemAvailable(requestedItem);
        if (!price.isEmpty()) {
            return price.get(0);
        } else {
            if (callMock1()) {
                // Выполняем GET запрос к mock2
                return new RestTemplate().getForObject("http://localhost:8082/api/mock02", String.class);
            } else {
                return "Такого не завезли. И не завезут. Совсем зажрались!";
            }
        }
    }

    // Метод для проверки наличия запрошенного продукта в базе данных
    public List<String> isItemAvailable(String item) {
        List<String> result = jdbcTemplate.query("SELECT price FROM items_table WHERE name = ?",
                new Object[]{item},
                (rs, rowNum) -> rs.getString("price"));
        return result; // Если список не пустой, значит, товар доступен
    }

    @Bean
    public boolean callMock1() {
        return new Random().nextBoolean();
    }


}