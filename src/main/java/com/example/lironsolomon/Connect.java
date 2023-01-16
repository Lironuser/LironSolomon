package com.example.lironsolomon;
import java.sql.*;

public class Connect {
    public  Connection connect(){
        String jdbcURL = "jdbc:postgresql://localhost:5432/Test";
        String userName = "postgres";
        String password = "Liron1630";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.printf("\nConnection complete\n");

            return connection;
        } catch (SQLException e) {
            System.out.printf("Error!!");
            throw new RuntimeException(e);

        }

    }
    public void viewTable(Connection con) throws RuntimeException {
        String query = "select * from Ishambel";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String text = rs.getString("text");
                int ID = rs.getInt("id");
                System.out.println(text + ", " +ID);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error!!");
            throw new RuntimeException(e);
        }
    }

    public void Insert(Connection con,String text)  throws SQLException{
        String Text=text;
        String query = "insert into Ishambel (Text)\n" +
                "VALUES ('"+text+"');";
        try (Statement stmt = con.createStatement()) {
            int rs = stmt.executeUpdate(query);
            con.close();
        } catch (SQLException e) {
            System.out.printf("Error!!");
            throw new RuntimeException(e);
        }
    }
    public void Delete(Connection con, String text1) throws SQLException{
        String query = "delete from Ishambel where text = 'Liron'";
        try (Statement stmt = con.createStatement()) {
            int rs = stmt.executeUpdate(query);
            con.close();
        } catch (SQLException e) {
            System.out.printf("Error!!");
            throw new RuntimeException(e);
        }
    }

}