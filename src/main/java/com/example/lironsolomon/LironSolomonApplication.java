package com.example.lironsolomon;
import javax.swing.JOptionPane;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.ArrayList;

@SpringBootApplication
public class LironSolomonApplication {

    public static void main(String[] args) throws SQLException {
        String pass = JOptionPane.showInputDialog("Enter your password");
        if(pass.equals("LironSolomon8597")){
            JOptionPane.showMessageDialog(null, "Welcome to - Liron Solomon project.");
            Connect con = new Connect();
            con.connect();
            ArrayList<test_table> list = new ArrayList<test_table>();
            //con.Insert(con.connect(), "Orian Ha Homo");
            //con.Delete(con.connect(), 47);
            //con.Update(con.connect(), Solomon, 50);
            //con.Select(con.connect(), 51);
            test_table getData = new test_table(56, "kjjk");
            getData.SelectInfo(con.connect(),list);
            //list.get(0).setText("Shmulmul");
            //getData.UpdateInfo(con.connect(), list, "Lila Ha Homo", 123456);
            con.SelectAll(con.connect());
        }else{
            JOptionPane.showMessageDialog(null, "Your password can not be confirmed.");
        }
    }
}
