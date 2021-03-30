package com.example.Image_Search_J2EE;

import java.sql.*;

public class DBConnect {
    public static Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/image_search_j2ee", "root", "password");
        return con;
    }

    public static void main(String[] args) {
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            //System.out.println(getConnection());
            String sql = "select * from users;";
            Connection myConn = getConnection();
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {

                String username = myRs.getString("username");
                String password = myRs.getString("password");
                String email = myRs.getString("email");

                System.out.println(username + "\n" + password + "\n" + email);

            }
            // execute query
            myRs = myStmt.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
