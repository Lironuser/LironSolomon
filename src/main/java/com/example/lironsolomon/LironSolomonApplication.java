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
        //con.Select(con.connect(), 44);
        //con.Insert(con.connect(),"liron");
        //con.Delete(con.connect(),"Liron");
        //con.Update(con.connect(), "check", 40);
        con.viewTable(con.connect());
    }
}
