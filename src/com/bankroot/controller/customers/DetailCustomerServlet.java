package com.bankroot.controller.customers;


import com.bankroot.beans.AccountBean;
import com.bankroot.beans.CustomerBean;
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

@WebServlet(name = "DetailsCustomersServlet",
        urlPatterns = "/DetailsCustomers")
public class DetailCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCustomer = request.getParameter("id");
        int id = Integer.parseInt(idCustomer);

        try{
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            Statement statement2 = connection.createStatement();
            Statement statment3 = connection.createStatement();

            ResultSet data = statement.executeQuery("SELECT * FROM customers WHERE id='"+id+"'");
            List<CustomerBean> result = new ArrayList<>();



            ResultSet data3 = statement2.executeQuery("SELECT * FROM account WHERE id IN (SELECT account_id FROM customers_has_account WHERE customers_id='"+id+"')");
            List<AccountBean> result1 = new ArrayList<>();

            ResultSet data4 = statment3.executeQuery("SELECT * FROM customers_has_product WHERE customers_id='"+id+"'");
            List<CustomerHasProductBean> result2 = new ArrayList<>();



            float solde = CustomerBean.getSolde1(id);

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

            while (data3.next()){
                AccountBean account = new AccountBean();

                account.setId(data3.getInt("id"));
                account.setAmount(data3.getFloat("amount"));
                account.setDate(data3.getDate("date"));
                account.setType_id(data3.getInt("type_id"));
                account.setType(account.getType());

                result1.add(account);
            }

            while (data4.next()){
                CustomerHasProductBean customerHasProductBean = new CustomerHasProductBean();

                customerHasProductBean.setStatus(data4.getBoolean("status"));
                customerHasProductBean.setProduct_id(data4.getInt("product_id"));
                customerHasProductBean.setDate(data4.getDate("date"));
                customerHasProductBean.setDemarchage(data4.getBoolean("demarchage"));
                customerHasProductBean.getProduct();

                result2.add(customerHasProductBean);
            }

            request.setAttribute("solde",solde);
            request.setAttribute("product",result2);
            request.setAttribute("result1",result1);
            request.setAttribute("result",result);
        }catch (Exception e){
            e.printStackTrace();
        }


        RequestDispatcher view = request.getRequestDispatcher("detailsCustomer.jsp");
        view.forward(request, response);
    }
}

