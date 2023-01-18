package com.example.lironsolomon;
import java.sql.*;

public class Connect {
    public  Connection connect(){
        String jdbcURL = "jdbc:postgresql://localhost:5432/Test";
        String userName = "postgres";
        String password = "Liron1630";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("\nConnection complete\n");

            return connection;
        } catch (SQLException e) {
            System.out.printf("Error!!");
            throw new RuntimeException(e);

        }

    }
    public void viewTable(Connection con) throws RuntimeException {
        String query = "select * from test_table";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String text = rs.getString("text");
                int id = rs.getInt("id");
                System.out.println(text + ", " +id);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error!!");
            throw new RuntimeException(e);
        }
    }

    public void Select(Connection con, int id) throws SQLException{
        String query = "SELECT * FROM test_table WHERE id = id";
        try (Statement stmt = con.createStatement()) {
            int rs = stmt.executeUpdate(query);
            con.close();
        } catch (SQLException e) {
            System.out.printf("Error!!");
            throw new RuntimeException(e);
        }
    }

    public void Insert(Connection con, String text)  throws SQLException{
        String Text=text;
        String query = "INSERT INTO test_table (Text)\n" +
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
        String query = "DELETE FROM test_table WHERE text = text1";
        try (Statement stmt = con.createStatement()) {
            int rs = stmt.executeUpdate(query);
            con.close();
        } catch (SQLException e) {
            System.out.printf("Error!!");
            throw new RuntimeException(e);
        }
    }

    public void Update(Connection con,String text, int id)  throws SQLException{
        String query=String.format("UPDATE \"test_table\""+
                "SET text='%s'"+
                "WHERE id = %d;",text, id);
        try (Statement stmt = con.createStatement()) {
            int rs = stmt.executeUpdate(query);
            con.close();
        } catch (SQLException e) {
            System.out.println("Error!!");
            throw new RuntimeException(e);
        }
    }

}
