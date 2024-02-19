package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Application(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        waitForTerminationSignal();
    }

    private static void waitForTerminationSignal() {

        System.out.println("НАЖМИ ЧТО-НИБУДЬ И ЭТО ЗАКОНЧИТСЯ");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}