package com.bankroot.beans;

import com.bankroot.services.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class CustomerHasProductBean {

    private int customers_id;
    private int product_id;
    private boolean status;
    private Date date;
    private boolean demarchage;

    public int getCustomers_id() {
        return customers_id;
    }

    public void setCustomers_id(int customers_id) {
        this.customers_id = customers_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDemarchage() {
        return demarchage;
    }

    public void setDemarchage(boolean demarchage) {
        this.demarchage = demarchage;
    }

    public String getProduct(){

        Connection connection = Database.getConnection();

        try{
            Statement statement = connection.createStatement();
             ResultSet data =statement.executeQuery("SELECT * FROM product WHERE id='"+product_id+"'");
            //List<ProductBean> productBeans = new ArrayList<>();

            while (data.next()){
                String label = data.getString("label");

                return label;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public String getCustomerFirstname(){
        Connection connection = Database.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("SELECT * FROM customers WHERE id='"+customers_id+"' AND contact=1");


            while (data.next()){
                String firstname = data.getString("firstname");


                return firstname;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;


    }

    public String getCustomerName(){
        Connection connection = Database.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("SELECT * FROM customers WHERE id='"+customers_id+"'AND contact=1");


            while (data.next()){
                String name = data.getString("name");


                return name;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;


    }

    public String getCustomerPhone(){
        Connection connection = Database.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("SELECT * FROM customers WHERE id='"+customers_id+"'AND contact=1");


            while (data.next()){
                String phone = data.getString("phone");


                return phone;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;


    }

    public String getCustomerEmail(){
        Connection connection = Database.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("SELECT * FROM customers WHERE id='"+customers_id+"'AND contact=1");


            while (data.next()){
                String email = data.getString("email");


                return email;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;


    }
}
