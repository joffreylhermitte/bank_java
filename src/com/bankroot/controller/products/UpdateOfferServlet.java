package com.bankroot.controller.products;

import com.bankroot.beans.OfferBean;
import com.bankroot.services.Database;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "UpdateOfferServlet",
            urlPatterns = "/UpdateOffer")
public class UpdateOfferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection connection = Database.getConnection();

            String product = request.getParameter("product");






            JSONArray array = OfferBean.arrayOfCondition(product);


            String conditionID = request.getParameter("condition");
            if (conditionID != null) {
                String name = request.getParameter("name");
                String operator = request.getParameter("operator");
                String value = request.getParameter("value");

                if (name != null) {
                    String condition = request.getParameter("conditionID");
                    Integer condID = Integer.parseInt(condition);

                    JSONObject object = array.getJSONObject(condID);
                    object.put("name", name);
                    object.put("value", value);
                    object.put("operator", operator);
                    if(name.equals("nombre")){

                        object.put("args",product);
                    }
                    String json = JSONObject.valueToString(array);
                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET description = ? WHERE id = ?");
                    preparedStatement.setString(1, json);
                    preparedStatement.setString(2, product);
                    preparedStatement.executeUpdate();

                }
            }
            request.setAttribute("array",array);
            request.setAttribute("products", product);

        }catch (Exception e){
            e.printStackTrace();
        }
        RequestDispatcher view = request.getRequestDispatcher("updateOffer.jsp");
        view.forward(request, response);
    }

}
