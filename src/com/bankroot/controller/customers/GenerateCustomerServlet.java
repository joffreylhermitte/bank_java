package com.bankroot.controller.customers;

import com.bankroot.beans.GenerateCustomerBean;
import com.bankroot.services.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "GenerateCustomerServlet",
            urlPatterns = "/GenerateCustomer")
public class GenerateCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String nombre = request.getParameter("nombre");
            int iteration = Integer.parseInt(nombre);
            Connection connection = Database.getConnection();

            for(int i=0;i<iteration;i++) {


                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customers(id,name,firstname,email,phone,birthday,children,contact,status_pro_id,status_perso_id) VALUES (NULL ,?,?,?,?,?,?,?,?,?)");
                String name = GenerateCustomerBean.getCustomers();
                String firstname = GenerateCustomerBean.getFirstname();
                String email = firstname + "." + name + "@example.com";
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, firstname);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, GenerateCustomerBean.getPhone());
                preparedStatement.setDate(5, GenerateCustomerBean.getBirthday());
                preparedStatement.setInt(6, GenerateCustomerBean.getChildren());
                preparedStatement.setBoolean(7, GenerateCustomerBean.getContact());
                preparedStatement.setInt(8, GenerateCustomerBean.getPro());
                preparedStatement.setInt(9, GenerateCustomerBean.getPerso());

                preparedStatement.executeUpdate();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        response.sendRedirect("/bankroot/ListCustomers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
