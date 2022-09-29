package com.bankroot.controller.index;

import com.bankroot.beans.CustomerBean;
import com.bankroot.beans.ProductBean;
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

@WebServlet(name = "IndexServlet",
            urlPatterns = "/Index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            Statement statement1 = connection.createStatement();

            ResultSet data = statement.executeQuery("SELECT * FROM customers ORDER BY id DESC LIMIT 3");
            List<CustomerBean> result = new ArrayList<>();

            ResultSet data1 = statement1.executeQuery("SELECT * FROM product ORDER BY id DESC LIMIT 3");
            List<ProductBean> result1 = new ArrayList<>();

            while (data.next()){
                CustomerBean customerBean = new CustomerBean();
                customerBean.setId(data.getInt("id"));
                customerBean.setName(data.getString("name"));
                customerBean.setFirstname(data.getString("firstname"));

                result.add(customerBean);
            }

            while (data1.next()){
                ProductBean productBean = new ProductBean();
                productBean.setName(data1.getString("label"));
                productBean.setId(data1.getInt("id"));

                result1.add(productBean);
            }

            request.setAttribute("product",result1);

            request.setAttribute("customer",result);
        }catch (Exception e){
            e.printStackTrace();
        }

        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
}
