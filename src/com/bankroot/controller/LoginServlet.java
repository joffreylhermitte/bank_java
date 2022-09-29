package com.bankroot.controller;

import com.bankroot.services.BCrypt;
import com.bankroot.services.Database;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginServlet",
        urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String login = null;

        try{
            Connection connection= Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE email=?");
            statement.setString(1,email);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                String id = data.getString("id");
                String name = data.getString("name");
                String emailLog = data.getString("email");
                String passwordLog = data.getString("password");


                boolean matched = BCrypt.checkpw(password,passwordLog);

                if(matched){
                    login = "Connexion réussi";
                    HttpSession idUser = request.getSession();
                    idUser.setAttribute("idUser",id);

                } else {
                    login = "Echec connexion";
                }

            }





        }catch (Exception se){
            se.printStackTrace();
        }

        request.setAttribute("login",login);
        response.sendRedirect("/bankroot/Index");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

