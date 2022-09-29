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
import java.sql.PreparedStatement;

@WebServlet(name = "GenerateCustomerHasAccountServlet",
            urlPatterns = "/GenerateCustomerHasAccount")
public class GenerateCustomerHasAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Connection connection = Database.getConnection();

        try{
            String nombre = request.getParameter("nombre");
            int iteration = Integer.parseInt(nombre);

            for(int i =0;i<iteration;i++) {

                int id = GenerateAccountBean.generateCustomerId();
                int idAccount = GenerateAccountBean.generateAccountId();


                PreparedStatement statement = connection.prepareStatement("INSERT INTO customers_has_account(customers_id,account_id) VALUES (?,?)");
                statement.setInt(1, id);
                statement.setInt(2, idAccount);

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
