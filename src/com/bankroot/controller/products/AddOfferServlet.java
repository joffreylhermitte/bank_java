package com.bankroot.controller.products;

import com.bankroot.beans.OfferBean;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddOfferServlet",
            urlPatterns = "/AddOffer")
public class AddOfferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");




        String name = request.getParameter("name");
        String value = request.getParameter("value");
        String operator = request.getParameter("operator");
        String productID = request.getParameter("productID");

        if (name != null && value != null && operator!= null) {
            JSONArray array = OfferBean.arrayOfCondition(productID);

            final JSONObject json = new JSONObject();
            json.put("name", name);

            json.put("value", value);

            json.put("operator", operator);

            if(name.equals("nombre")){

                json.put("args",productID);
            }



                array.put(json);





            //   String products =(String) session.getAttribute("products");

            String jsonValue = JSONObject.valueToString(array);

            OfferBean.updateOffer(jsonValue, productID);
        }
        request.setAttribute("products", product);
        RequestDispatcher view = request.getRequestDispatcher("addOffer.jsp");
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
