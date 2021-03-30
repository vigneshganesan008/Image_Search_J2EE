package com.example.Image_Search_J2EE;

import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SignupServlet", value = "/signup-servlet")
public class Signup extends HttpServlet {
    Connection myConnection = null;
    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/image_search_j2ee", "root", "password");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String c_password = request.getParameter("c_password");
        String email = request.getParameter("email");

        if(username.isEmpty() ||
                password.isEmpty() || c_password.isEmpty() || email.isEmpty())
        {
            if(password == c_password) {
                RequestDispatcher req = request.getRequestDispatcher("index.jsp");
                req.include(request, response);
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String c_password = request.getParameter("c_password");
        String email = request.getParameter("email");

        PreparedStatement myStmt = null;

        try {
            if (password.equals(c_password)) {

                String sql = "insert into users " + "(username, password, email) " + "values (?, ?, ?)";

                myStmt = myConnection.prepareStatement(sql);

                myStmt.setString(1, username);
                myStmt.setString(2, password);
                myStmt.setString(3, email);

                myStmt.execute();

                RequestDispatcher req = request.getRequestDispatcher("index.jsp");
                req.include(request, response);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}