package com.example.lironsolomon;

import org.springframework.data.relational.core.sql.Insert;

import java.sql.*;
import java.util.ArrayList;


public class test_table {
    int id;
    String text;

    public test_table(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void SelectInfo(Connection con, ArrayList<test_table> list) {
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
     public void check(Connection con, ArrayList<test_table> list, String text1, int id1)
    {
        Connect connect = new Connect();
        for (test_table i:list) {
            if(i.getId() == id1) {
                return;
            }
        }
        try {
            connect.Insert(con, text1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void UpdateInfo(Connection con, ArrayList<test_table> list, String text1, int id1) {
        String query = "UPDATE test_table SET (text = ?) WHERE id = ?";
        try {
            con.setAutoCommit(false);
            PreparedStatement st = con.prepareStatement(query);
            for (test_table t : list) {
                st.setString(1, text1);
                st.setInt(2, id1);

            }
            check(con,list, text1, id1);
            st.executeUpdate();
            con.commit();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error!!");
        }
    }
}