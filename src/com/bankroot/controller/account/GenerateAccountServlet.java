package com.bankroot.controller.account;

import com.bankroot.beans.GenerateAccountBean;
import com.bankroot.services.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

@WebServlet(name = "GenerateAccountServlet",
            urlPatterns = "/GenerateAccount")
public class GenerateAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Connection connection = Database.getConnection();
        try {
            String nombre = request.getParameter("nombre");
            int iteration = Integer.parseInt(nombre);

            for(int i=0;i<iteration;i++) {
                Float amount = GenerateAccountBean.generateAmount();
                Date date = GenerateAccountBean.generateDate();
                int type = GenerateAccountBean.generateType();


                PreparedStatement statement = connection.prepareStatement("INSERT INTO account(id,amount,date,type_id) VALUES (NULL ,?,?,?)");
                statement.setFloat(1, amount);
                statement.setDate(2, date);
                statement.setInt(3, type);

                statement.executeUpdate();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        response.sendRedirect("/bankroot/ListCustomers");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
