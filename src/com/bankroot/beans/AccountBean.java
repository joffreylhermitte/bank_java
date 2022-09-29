package com.bankroot.beans;





import com.bankroot.services.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class AccountBean {
    private int id;
    private float amount;
    private Date date;
    private int type_id;
    private String labelType;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType(){
        try{
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            ResultSet data = statement.executeQuery("SELECT * FROM type WHERE id='"+type_id+"'");

            while (data.next()){
                String labelType = data.getString("label");
                return labelType;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }



    public void setType(String labelType){
        this.labelType = labelType;
    }
}

