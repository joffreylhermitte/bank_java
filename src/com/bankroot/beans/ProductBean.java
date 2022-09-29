package com.bankroot.beans;

import com.bankroot.services.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductBean {

    private int id;
    private String name;
    private boolean exclusive;
    private boolean limited;
    private int category_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getExclusive() {
        return exclusive;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    public boolean getLimited() {
        return limited;
    }

    public void setLimited(boolean limited) {
        this.limited = limited;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public static void addProduct (String name, Boolean exclusive, Boolean limited, String category_id) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product (label, exclusive, limited,description, category_id) VALUE (?, ?, ?,?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setBoolean(2, exclusive);
            preparedStatement.setBoolean(3, limited);
            preparedStatement.setString(4, "[]");
            preparedStatement.setString(5,category_id);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public static void deleteProduct (String id) {
        Connection connection = Database.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM product WHERE id = '" + id + "'" );
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static List productsList() {
        Connection connection = Database.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("SELECT * FROM product");
            List<ProductBean> results = new ArrayList<>();

            while(data.next()) {
                ProductBean product = new ProductBean();

                product.setId(data.getInt("id"));
                product.setName(data.getString("label"));
                product.setExclusive(data.getBoolean("exclusive"));
                product.setLimited(data.getBoolean("limited"));
                product.setCategory_id(data.getInt("category_id"));

                results.add(product);

            }

            return results;
        } catch (Exception e) {
            System.err.println(e);
        }

        return null;
    }

    public static List categoriesList() {
        Connection connection = Database.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("SELECT * FROM category");
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

    public static void updateProduct(String id, String name, Boolean exclusive, Boolean limited, String category_id) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET label = ?, exclusive = ?, limited = ?,category_id = ? WHERE id = ?");

            preparedStatement.setString(1, name);
            preparedStatement.setBoolean(2, exclusive);
            preparedStatement.setBoolean(3, limited);
            preparedStatement.setString(4, category_id);
            preparedStatement.setString(5, id);

            preparedStatement.executeUpdate();
        } catch (Exception e ) {
            System.err.println(e);
        }
    }

    public static List selectProduct(String id) {
        Connection connection = Database.getConnection();
        try{
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("SELECT * FROM product WHERE id = '" + id + "'");
            List<ProductBean> results = new ArrayList<>();

            while(data.next()) {
                ProductBean product = new ProductBean();

                product.setId(data.getInt("id"));
                product.setName(data.getString("label"));
                product.setExclusive(data.getBoolean("exclusive"));
                product.setLimited(data.getBoolean("limited"));
                product.setCategory_id(data.getInt("category_id"));

                results.add(product);
            }

            return results;
        } catch (Exception e) {
            System.err.println(e);
        }

        return null;
    }

    public static String getCategoryLabel(int category_id) {
        Connection connection = Database.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("SELECT label FROM category WHERE id = '" + category_id + "'");

            while(data.next()) {
                String label = data.getString("label");

                return label;
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return null;
    }



}
