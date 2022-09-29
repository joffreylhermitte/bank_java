package com.bankroot.controller.products;

import com.bankroot.beans.CustomerHasProductBean;
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

@WebServlet(name = "CustomersProductServlet",
            urlPatterns = "/CustomersProduct")
public class CustomersProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idProduct");
        Integer idProduct = Integer.parseInt(id);

        try{
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            ResultSet data = statement.executeQuery("SELECT * FROM customers_has_product WHERE demarchage =1 AND product_id='"+idProduct+"'");
            List<CustomerHasProductBean> customerHasProductBeans = new ArrayList<>();

            while (data.next()){
                CustomerHasProductBean customerHasProductBean = new CustomerHasProductBean();
                customerHasProductBean.setCustomers_id(data.getInt("customers_id"));
                customerHasProductBean.setProduct_id(data.getInt("product_id"));
                customerHasProductBean.setStatus(data.getBoolean("status"));
                customerHasProductBean.setDate(data.getDate("date"));
                customerHasProductBean.setDemarchage(data.getBoolean("demarchage"));
                customerHasProductBean.getCustomerFirstname();
                customerHasProductBean.getCustomerName();
                customerHasProductBean.getCustomerPhone();
                customerHasProductBean.getCustomerEmail();

                customerHasProductBeans.add(customerHasProductBean);
            }
            request.setAttribute("customers",customerHasProductBeans);
        }catch (Exception e){
            e.printStackTrace();
        }

        RequestDispatcher view = request.getRequestDispatcher("customersOffer.jsp");
        view.forward(request, response);


    }
}
