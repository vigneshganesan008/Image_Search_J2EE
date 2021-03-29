package com.example.Image_Search_J2EE;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "ImageSearchServlet", value = "/image_search-servlet")
public class ImageSearch extends HttpServlet {
    /*Cookie cookie = null;
    Cookie[] cookies = null;
    public String loggedInUser;
    public void init() {*/



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      /*  // Get an array of Cookies associated with this domain
        cookies = request.getCookies();
        System.out.println(cookie.getName());
        System.out.println(cookie.getValue());*/
    }


}
