package com.bankroot.controller.customers;

import com.bankroot.beans.CustomerBean;
import com.bankroot.services.Database;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchCustomersServlet",urlPatterns = "/Search")
public class SearchCustomersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");

            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("SELECT * FROM customers WHERE name='"+name+"' OR firstname='"+name+"'");
            List<CustomerBean> resultat = new ArrayList<>();

            while (data.next()) {
                CustomerBean customer = new CustomerBean();
                customer.setId(data.getInt("id"));
                customer.setName(data.getString("name"));
                customer.setFirstname(data.getString("firstname"));

                resultat.add(customer);


            }
            request.setAttribute("resultat",resultat);


            RequestDispatcher view = request.getRequestDispatcher("search.jsp");
            view.forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

