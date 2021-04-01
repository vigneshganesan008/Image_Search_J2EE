package com.example.Image_Search_J2EE;

import org.apache.commons.io.FileUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    Connection myConnection = null;

    public void init() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/image_search_j2ee", "root", "password");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!username.isEmpty() && !password.isEmpty()) {
            Statement myStmt = null;
            ResultSet myRs = null;

            try {
                String pass = null;
                String sql = "select password from users where username = '" + username + "';";
                myStmt = myConnection.createStatement();
                myRs = myStmt.executeQuery(sql);

                if (myRs.next()) {
                    pass = myRs.getString("password");
                }

                if (password.equals(pass)) {
                    Cookie[] cookies = request.getCookies();
                    if (cookies != null) {
                        for (Cookie cookie : cookies) {
                            cookie.setMaxAge(0);
                        }
                        System.out.println("Cookie deleted");
                    }


                    Cookie usernameCookie = new Cookie("username", request.getParameter("username"));
                    usernameCookie.setMaxAge(60 * 60 * 24);
                    response.addCookie(usernameCookie);
                    FileUtils.cleanDirectory(new File("C:\\Users\\Vicky\\Documents\\Projects\\Image_Search_J2EE\\src\\main\\webapp\\images"));
                    RequestDispatcher req = request.getRequestDispatcher("MainPage.jsp");
                    req.include(request, response);
                    System.out.println("Password Correct");
                } else {
                    System.out.println("Password InCorrect : " + pass + " : " + password);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }

    public void destroy() {
    }
}