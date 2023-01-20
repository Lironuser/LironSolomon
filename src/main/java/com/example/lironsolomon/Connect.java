package com.example.lironsolomon;
import java.sql.*;

public class Connect {
    public  Connection connect(){
        String jdbcURL = "jdbc:postgresql://localhost:5432/Test";
        String userName = "postgres";
        String password = "lironSolomon8597";
        try{
            Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("\nConnection complete.");

            return connection;
        } catch (SQLException e) {
            System.out.printf("Error!!");
            throw new RuntimeException(e);

        }

    }
    public void Select(Connection con, int id1) throws RuntimeException {
        String query = "SELECT id, text FROM test_table WHERE id =?";
        try (Statement stmt = con.createStatement()) {
            con.setAutoCommit(false);
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, id1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String text = rs.getString("text");
                int id = rs.getInt("id");
                System.out.println("| "+text + " | " +id+" |");
            }
            st.close();
            con.commit();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error!!");
            throw new RuntimeException(e);
        }
    }

    public void SelectAll(Connection con) throws RuntimeException {
        String query = "SELECT * FROM test_table";
        try (Statement stmt = con.createStatement()) {
            con.setAutoCommit(false);
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String text = rs.getString("text");
                int id = rs.getInt("id");
                System.out.println("| "+text + " | " +id+" |");
            }
            st.close();
            con.commit();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error!!");
            throw new RuntimeException(e);
        }
    }

    public void Insert(Connection con, String text1)  throws SQLException{
        String query = "INSERT INTO test_table (text)" +
                "VALUES (?)";
        try (Statement stmt = con.createStatement()) {
            con.setAutoCommit(false);
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1,text1);
            st.executeUpdate();
            st.close();
            con.commit();
            con.close();
        } catch (SQLException e) {
            System.out.printf("Error!!");
            throw new RuntimeException(e);
        }
    }
    public void Delete(Connection con, int id1) throws SQLException{
        String query = "DELETE FROM test_table WHERE id=?";
        try (Statement stmt = con.createStatement()) {
            con.setAutoCommit(false);
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1,id1);
            st.executeUpdate();
            st.close();
            con.commit();
            con.close();
        } catch (SQLException e) {
            System.out.printf("Error!!");
            throw new RuntimeException(e);
        }
    }

    public void Update(Connection con,String text1, int id1)  throws SQLException{
        String query= "UPDATE test_table SET text = ?  WHERE id = ?";
        try (Statement stmt = con.createStatement()) {
            con.setAutoCommit(false);
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, text1);
            st.setInt(2, id1);
            st.executeUpdate();
            st.close();
            con.commit();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("Error!!");
            throw new RuntimeException(e);
        }
    }

}
