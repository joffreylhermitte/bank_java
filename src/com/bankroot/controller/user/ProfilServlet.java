package com.bankroot.controller.user;

import com.bankroot.services.Database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "ProfilServlet",
            urlPatterns = "/Profil")
public class ProfilServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session1 = request.getSession();
            String id = (String)session1.getAttribute("idUser");
            Integer idUser = Integer.parseInt(id);
            String name="";
            String firstname="";
            String email="";
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            ResultSet data = statement.executeQuery("SELECT * FROM employee WHERE id='"+idUser+"'");

            while (data.next()){
                 name = data.getString("name");
                 firstname = data.getString("firstname");
                 email = data.getString("email");
            }

            request.setAttribute("name",name);
            request.setAttribute("firstname",firstname);
            request.setAttribute("email",email);
        }catch (Exception e){
            e.printStackTrace();
        }

        RequestDispatcher view = request.getRequestDispatcher("user.jsp");
        view.forward(request, response);
    }
}
