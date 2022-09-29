package com.bankroot.controller.products;

import com.bankroot.beans.ProductBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OfferSettingServlet",
            urlPatterns = "/Settings")
public class OfferSettingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List products = ProductBean.productsList();

        request.setAttribute("products", products);
        RequestDispatcher view = request.getRequestDispatcher("settings.jsp");
        view.forward(request, response);
    }
}