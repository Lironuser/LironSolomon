package com.example.lironsolomon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class LironSolomonApplication {

    public static void main(String[] args) throws SQLException {
        //SpringApplication.run(LironSolomonApplication.class, args);
        System.out.println("Welcome");
        Connect con = new Connect();
        con.connect();
        //con.Insert(con.connect(),"liron");
        //con.Delete(con.connect(),"check", 42);
        con.Update(con.connect(), "liron", 42);
        con.Select(con.connect(), 43);
    }
}
