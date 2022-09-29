package com.bankroot.controller.category;

import com.bankroot.services.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "AddCategoryServlet",
            urlPatterns = "/addCategory")
public class AddCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String label = request.getParameter("label");
        String category = request.getParameter("category");


        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO category (label, category_id)  VALUE (?, ? )");
            preparedStatement.setString(1, label);
            preparedStatement.setString(2, category);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.err.println(e);
        }
        response.sendRedirect(request.getContextPath() + "/Category");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
