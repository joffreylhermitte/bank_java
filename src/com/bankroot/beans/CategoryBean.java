package com.bankroot.beans;

import com.bankroot.services.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryBean {

    private int id;
    private String label;
    private int categoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    public static List subCategoryList(String categoryID) {
        Connection connection = Database.getConnection();
        try {

            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("SELECT * FROM category WHERE category_id="+categoryID);
            List<CategoryBean> results = new ArrayList<>();

            while(data.next()) {
                CategoryBean category = new CategoryBean();

                category.setId(data.getInt("id"));
                category.setLabel(data.getString("label"));
                category.setCategoryId(data.getInt("category_id"));

                results.add(category);
            }

            return results;

        } catch(Exception e) {
            System.err.println(e);
        }

        return null;
    }


    public static List categoryList() {
        Connection connection = Database.getConnection();
        try {

            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("SELECT * FROM category WHERE category_id IS NULL ");
            List<CategoryBean> results = new ArrayList<>();

            while(data.next()) {
                CategoryBean category = new CategoryBean();

                category.setId(data.getInt("id"));
                category.setLabel(data.getString("label"));
                category.setCategoryId(data.getInt("category_id"));

                results.add(category);
            }

            return results;

        } catch(Exception e) {
            System.err.println(e);
        }

        return null;
    }


}
