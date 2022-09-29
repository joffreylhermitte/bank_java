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

@WebServlet(name = "UpdateProductServlet",
            urlPatterns = "/updateProduct")
public class UpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String test = request.getParameter("test");
        Boolean exclusive1 = Boolean.valueOf(test);
        String limited = request.getParameter("limited");
        String category_id = request.getParameter("category_id");

        Boolean limited1 = Boolean.valueOf(limited);
        System.out.println(test);
        System.out.println(exclusive1);



        if(test!=null){
            exclusive1 = true;
        }

        if(limited!=null){
            limited1=true;
        }

        ProductBean.updateProduct(id, name, exclusive1, limited1, category_id);

        response.sendRedirect(request.getContextPath() + "/products");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id");
        int id = Integer.parseInt(request.getParameter("id"));

        List product = ProductBean.selectProduct(strId);
        List categories = ProductBean.categoriesList();
        String label = ProductBean.getCategoryLabel(id);

        request.setAttribute("product", product);
        request.setAttribute("categories", categories);
        request.setAttribute("id", strId);
        request.setAttribute("label", label);

        RequestDispatcher view = request.getRequestDispatcher("updateProduct.jsp");
        view.forward(request, response);

    }


}
