package com.example.lironsolomon;
import javax.swing.JOptionPane;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class LironSolomonApplication {

    public static void main(String[] args) throws SQLException {
        String pass = JOptionPane.showInputDialog("Enter your password");
        if(pass.equals("LironSolomon8597")){
            JOptionPane.showMessageDialog(null, "Welcome to - Liron Solomon project.");
            Connect con = new Connect();
            con.connect();
            con.Insert(con.connect(), "Liron");
            //con.Delete(con.connect(), 47);
            con.SelectAll(con.connect());
        }else{
            JOptionPane.showMessageDialog(null, "Your password can not be confirmed.");
        }
    }
}
