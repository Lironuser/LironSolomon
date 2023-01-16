package com.example.lironsolomon;
import java.sql.*;

public class Connect {
    public  Connection connect(){
        String jdbcURL = "jdbc:postgresql://localhost:5432/Test";
        String userName = "postgres";
        String password = "Liron1630";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.printf("There is connection");

            return connection;
        } catch (SQLException e) {
            System.out.printf("Error!!");
            throw new RuntimeException(e);

        }

    }
    public void viewTable(Connection con) throws SQLException  {
        String query = "select * from data";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String dd = rs.getString("dd");
                int ID = rs.getInt("id");
                System.out.println(dd + ", " +ID);
            }
            con.close();
        } catch (SQLException e) {
            System.out.printf("Error!!");
            throw new RuntimeException(e);
        }
    }

}
