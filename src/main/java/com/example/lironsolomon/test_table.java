package com.example.lironsolomon;

import java.sql.*;
import java.util.ArrayList;


public class test_table {
    int id;
    String text;
    public test_table(int id, String text){
        this.id = id;
        this.text = text;
    }
    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void SelectInfo(Connection con, ArrayList<test_table> list ){
        String query = "SELECT * FROM test_table";
        try (Statement stmt = con.createStatement()) {
            con.setAutoCommit(false);
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String text = rs.getString("text");
                int id = rs.getInt("id");
                list.add(new test_table(id, text));
            }
            System.out.println(".........................");
            st.close();
            con.commit();
            con.close();
            for (int i = 0; i < list.size(); i++) {
                System.out.println("Id = " + list.get(i).getId() + '.');
                System.out.println("Text = " + list.get(i).getText() + '.');
                System.out.println(".........................");
            }
        } catch (SQLException e) {
            System.out.println("Error!!");
            throw new RuntimeException(e);
        }
    }

    public void UpdateInfo(Connection con, int id1){

    }
}
