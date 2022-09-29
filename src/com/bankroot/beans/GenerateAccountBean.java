package com.bankroot.beans;

import com.bankroot.services.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class GenerateAccountBean {

    public static Float generateAmount(){
        Random random = new Random();

        float amount = random.nextFloat()*(3000-(-1000))-1000;

        DecimalFormat df = new DecimalFormat("#.##");



        String amount1 = df.format(amount);
        String newAmount = amount1.replace(",",".");

        float amount2 = Float.parseFloat(newAmount);

        return amount2;
    }

    public static java.sql.Date generateDate(){
        GregorianCalendar calendar = new GregorianCalendar();
        Random random = new Random();
        int year = GenerateCustomerBean.randomBetween(2018,2019);
        calendar.set(calendar.YEAR,year);

        //int day = randomBetween(1,28);
        List day = new ArrayList();
        day.add("01");
        day.add("02");
        day.add("03");
        day.add("04");
        day.add("05");
        day.add("06");
        day.add("07");
        day.add("08");
        day.add("09");
        day.add("10");
        day.add("11");
        day.add("12");
        day.add("13");
        day.add("14");
        day.add("15");
        day.add("16");
        day.add("17");
        day.add("18");
        day.add("19");
        day.add("20");
        day.add("21");
        day.add("22");
        day.add("23");
        day.add("24");
        day.add("25");
        day.add("26");
        day.add("27");
        day.add("28");

        int daySize = day.size()-1;
        Random random1 = new Random();
        int dayRandom = random1.nextInt(daySize-0+1);

        String dayBirth = (String) day.get(dayRandom);

        int dayBirth2 = Integer.parseInt(dayBirth);




        calendar.set(calendar.DAY_OF_MONTH,dayBirth2);

        int month = GenerateCustomerBean.randomBetween(1,12);
        calendar.set(calendar.MONTH,month);

        String  birthday = calendar.get(calendar.YEAR)+"-"+calendar.get(calendar.MONTH)+"-"+calendar.get(calendar.DAY_OF_MONTH);

        try{

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(birthday);
            DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String date2 = format1.format(date);

            Date parsed = format1.parse(date2);
            java.sql.Date sql = new java.sql.Date(parsed.getTime());

            return sql;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;



    }

    public static int generateType(){
        int typeId = GenerateCustomerBean.randomBetween(1,9);

        return typeId;
    }

    public static int generateCustomerId(){
        Connection connection= Database.getConnection();

        try{
            Statement statement = connection.createStatement();
            ResultSet data =statement.executeQuery("SELECT id FROM customers");
            List<Integer> id = new ArrayList<>();

            while (data.next()){
                id.add(data.getInt("id"));
            }

            int idSize = id.size()-1;

            Random random = new Random();

            int i = GenerateCustomerBean.randomBetween(0,idSize);

            int idCustomer = id.get(i);

            return idCustomer;



        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static int generateAccountId(){
        Connection connection= Database.getConnection();

        try{
            Statement statement = connection.createStatement();
            ResultSet data =statement.executeQuery("SELECT id FROM account");
            List<Integer> id = new ArrayList<>();

            while (data.next()){
                id.add(data.getInt("id"));
            }

            int idSize = id.size()-1;

            Random random = new Random();

            int i = GenerateCustomerBean.randomBetween(0,idSize);

            int idAccount = id.get(i);

            return idAccount;



        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
