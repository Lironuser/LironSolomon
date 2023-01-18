package com.example.lironsolomon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class LironSolomonApplication {

    public static void main(String[] args) throws SQLException {
        //SpringApplication.run(LironSolomonApplication.class, args);
        System.out.println("Welcome to - Liron Solomon project.");
        Connect con = new Connect();
        con.connect();
        con.Select(con.connect(), 44);
    }
}
