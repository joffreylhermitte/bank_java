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

@WebServlet(name = "ListCustomersServlet",
        urlPatterns = "/ListCustomers")
public class ListCustomersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            Connection connection= Database.getConnection();


                Statement statement = connection.createStatement();
                ResultSet data =statement.executeQuery("SELECT * FROM customers");
                List<CustomerBean> result = new ArrayList<>();
                while (data.next()){
                    CustomerBean customers = new CustomerBean();


                    customers.setId(data.getInt("id"));
                    customers.setName(data.getString("name"));
                    customers.setFirstname(data.getString("firstname"));
                    customers.setEmail(data.getString("email"));
                    customers.setPhone(data.getString("phone"));
                    customers.setBirthday(data.getDate("birthday"));
                    customers.setChildren(data.getInt("children"));
                    customers.setContact(data.getBoolean("contact"));
                    customers.setStatus_pro_id(data.getInt("status_pro_id"));
                    customers.setStatus_perso_id(data.getInt("status_perso_id"));
                    customers.setAge(customers.getAge());
                    customers.setStatusPro(customers.getStatusPro());
                    customers.setStatusPerso(customers.getStatusPerso());

                    result.add(customers);

                }
                request.setAttribute("result",result);
                RequestDispatcher view = request.getRequestDispatcher("listeclients.jsp");
                view.forward(request, response);







        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

