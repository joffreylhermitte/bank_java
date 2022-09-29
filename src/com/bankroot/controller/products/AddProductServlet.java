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

@WebServlet(name = "AddProductServlet",
            urlPatterns = "/addProduct")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String exclusive = request.getParameter("exclusive");
        Boolean exclusive1 = Boolean.valueOf(exclusive);
        String limited = request.getParameter("limited");
        Boolean limited1 = Boolean.valueOf(limited);
        if(exclusive!=null){
            exclusive1=true;
        }

        if(limited!=null){
            limited1=true;
        }

        String category_id = request.getParameter("category_id");

        ProductBean.addProduct(name, exclusive1, limited1, category_id);

        response.sendRedirect(request.getContextPath() + "/products");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List categories = ProductBean.categoriesList();

        request.setAttribute("categories", categories);
        RequestDispatcher view = request.getRequestDispatcher("ajouteroffre.jsp");
        view.forward(request, response);
    }
}
