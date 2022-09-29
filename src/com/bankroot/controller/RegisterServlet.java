package com.bankroot.controller;
import com.bankroot.services.BCrypt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.lang.*;




@WebServlet(
        name = "RegisterServlet",
        urlPatterns = "/Register"

)

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException  {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String hash = BCrypt.hashpw(password,BCrypt.gensalt(12));

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testjava?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","123456");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(name,email,password) VALUES (?,?,?) ");


            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,hash);

            System.out.print(preparedStatement.toString());

            preparedStatement.executeUpdate();

        }catch (Exception se){
            System.err.print(se.getMessage());
           se.printStackTrace();
        }

        req.setAttribute("name",name);
        req.setAttribute("email",email);
        RequestDispatcher view = req.getRequestDispatcher("viewInscription.jsp");
        view.forward(req, resp);

    }
}
