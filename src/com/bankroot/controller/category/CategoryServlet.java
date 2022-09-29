package com.bankroot.controller.category;

import com.bankroot.beans.CategoryBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet",
            urlPatterns = "/Category")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List category = CategoryBean.categoryList();
        request.setAttribute("mainCategory",category);
        RequestDispatcher view = request.getRequestDispatcher("category.jsp");
        view.forward(request, response);

    }
}
