package com.bankroot.controller.products;

import com.bankroot.beans.ConditionBean;
import com.bankroot.beans.CustomerBean;
import com.bankroot.beans.GenerateAccountBean;
import com.bankroot.beans.OfferBean;
import com.bankroot.services.Database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OfferServlet",
            urlPatterns = "/Offer")
public class OfferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            Statement statement1 = connection.createStatement();
            String idProduct = request.getParameter("id");
            Integer product = Integer.parseInt(idProduct);

            statement1.execute("DELETE FROM customers_has_product WHERE product_id='"+idProduct+"'");

            ResultSet data = statement.executeQuery("SELECT * FROM customers");
            List<ConditionBean> conditione = OfferBean.listOfCondition(product);
            List<Boolean> result = new ArrayList<>();

            while (data.next()) {
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

                Boolean offer = OfferBean.getOffer(conditione, customers);


                result.add(offer);

                PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO customers_has_product(customers_id,product_id,status,date,demarchage)VALUES (?,?,?,?,?)");
                prepareStatement.setInt(1,customers.getId());
                prepareStatement.setInt(2,product);
                prepareStatement.setBoolean(3,false);
                prepareStatement.setDate(4, GenerateAccountBean.generateDate());
                if(offer){
                    prepareStatement.setBoolean(5,true);
                }else{
                    prepareStatement.setBoolean(5,false);
                }

                prepareStatement.executeUpdate();


            }
            request.setAttribute("offer",result);

        }
        catch (Exception e){
            e.printStackTrace();
        }

        RequestDispatcher view = request.getRequestDispatcher("offer.jsp");
        view.forward(request, response);

    }
}
