package com.example.Image_Search_J2EE;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SignupServlet", value = "/signup-servlet")
public class Signup extends HttpServlet {

    public void init() {

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

    public void destroy() {
    }
}