package com.bankroot.beans;

import com.bankroot.services.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CustomerBean {
    private int id;
    private String name;
    private String firstname;
    private String email;
    private String phone;
    private Date birthday;
    private int children;
    private boolean contact;
    private int status_pro_id;
    private int status_perso_id;
    private float age;
    private String labelPro;
    private String labelPerso;

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public boolean isContact() {
        return contact;
    }

    public void setContact(boolean contact) {
        this.contact = contact;
    }

    public int getStatus_pro_id() {
        return status_pro_id;
    }

    public void setStatus_pro_id(int status_pro_id) {
        this.status_pro_id = status_pro_id;
    }

    public int getStatus_perso_id() {
        return status_perso_id;
    }

    public void setStatus_perso_id(int status_perso_id) {
        this.status_perso_id = status_perso_id;
    }

    public float getAge(){
        int age;
        Date date = birthday;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = dateFormat.format(date);
        String[] parts = birthday.split("-");
        String part1 = parts[0];
        String part2 = parts[1];
        String part3 = parts[2];
        int year = Integer.parseInt(part1);
        int month = Integer.parseInt(part2);
        int day = Integer.parseInt(part3);
        Calendar today = Calendar.getInstance();
        int actualYear = today.get(Calendar.YEAR);
        int actualMonth = today.get(Calendar.MONTH);
        int actualDay = today.get(Calendar.DAY_OF_MONTH);

        if(month>actualMonth){
            age = (actualYear-year)-1;
        }else if(month==actualMonth && day>actualDay){
            age = (actualYear-year)-1;
        }else {
            age = actualYear-year;
        }

        return age;

    }

    public void setAge(float age){
        this.age = age;
    }

    public String getStatusPro(){
        try {


            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("SELECT * FROM status_pro WHERE id='"+status_pro_id+"'");

            while (data.next()) {

                String labelPro = data.getString("label");

                return labelPro;
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void setStatusPro(String labelPro){
        this.labelPro= labelPro;
    }

    public String getStatusPerso(){
        try{
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            ResultSet data = statement.executeQuery("SELECT * FROM status_perso WHERE id='"+status_perso_id+"'");

            while (data.next()){
                String labelPerso = data.getString("label");

                return labelPerso;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void setStatusPerso(String labelPerso){
        this.labelPerso = labelPerso;
    }

    public float getNombre(String id){
        try{
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            ResultSet data = statement.executeQuery("SELECT COUNT(*) FROM customers_has_product WHERE customers_id="+this.getId()+" AND product_id="+id);

            while (data.next()){
                float compte = data.getInt(1);

                return compte;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static float getSolde1(int id){
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            ResultSet data = statement.executeQuery("SELECT * FROM account WHERE id IN (SELECT account_id FROM customers_has_account WHERE customers_id='"+id+"')");
            List<Float> result = new ArrayList<>();

            while (data.next()){
                float amount = data.getFloat("amount");
                result.add(amount);


            }

            float sum = 0;
            for(int i = 0; i<result.size();i++){
                sum += result.get(i);
            }

            return sum;



        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public float getSolde(){
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            ResultSet data = statement.executeQuery("SELECT * FROM account WHERE id IN (SELECT account_id FROM customers_has_account WHERE customers_id='"+this.getId()+"')");
            List<Float> result = new ArrayList<>();

            while (data.next()){
                float amount = data.getFloat("amount");
                result.add(amount);


            }

            float sum = 0;
            for(int i = 0; i<result.size();i++){
                sum += result.get(i);
            }

            return sum;



        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}

