package com.bankroot.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/bank","root","root");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
