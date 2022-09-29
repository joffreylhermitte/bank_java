package com.bankroot.beans;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class GenerateCustomerBean {

    public static String getCustomers(){

        List name = new ArrayList();
        name.add("Patenaude");
        name.add("Bazinet");
        name.add("Méthot");
        name.add("Brousse");
        name.add("Artois");
        name.add("Rocher");
        name.add("Garnier");
        name.add("Masson");
        name.add("Martin");
        name.add("Benard");
        name.add("Petit");
        name.add("Durand");
        name.add("Dubois");
        name.add("Laurent");
        name.add("Lefebvre");
        name.add("Leroy");
        name.add("Bertrand");
        name.add("Morel");
        name.add("Girard");
        name.add("Lambert");





        int nameSize = name.size()-1;
        Random rand= new Random();



        int i = randomBetween(0,nameSize);

        String nameCustomer = (String) name.get(i);

        return nameCustomer;



    }

    public static String getFirstname(){
        List firstname = new ArrayList();
        firstname.add("Leala");
        firstname.add("Tanguy");
        firstname.add("Thierry");
        firstname.add("Gaspar");
        firstname.add("Jimmy");
        firstname.add("Alfredo");
        firstname.add("Hugo");
        firstname.add("Emma");
        firstname.add("Léa");
        firstname.add("Manon");
        firstname.add("Chloé");
        firstname.add("Clara");
        firstname.add("Lucas");
        firstname.add("Louis");
        firstname.add("Anaïs");
        firstname.add("Louise");
        firstname.add("Arthur");
        firstname.add("Clément");
        firstname.add("Camille");
        firstname.add("Béatrice");

        int firstnameSize = firstname.size()-1;
        Random random = new Random();

        int j = randomBetween(0,firstnameSize);
        String firstnameCustomer = (String)firstname.get(j);

        return firstnameCustomer;
    }

    public static java.sql.Date getBirthday(){
        GregorianCalendar calendar = new GregorianCalendar();
        Random random = new Random();
        int year = randomBetween(1950,2000);
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

        int month = randomBetween(1,12);
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

    public static int randomBetween(int start,int end){
        return start+(int)Math.round(Math.random()*(end-start));
    }

    public static String getPhone(){
        List<String> number = new ArrayList<>();

        for(int i =0;i<99;i++){
            String j = String.valueOf(i);
            number.add(j);
        }
        int numberSize = number.size()-1;
        Random random = new Random();
        int random1 = random.nextInt(numberSize-0+1);
        String one = number.get(random1);

        int oneInt = Integer.parseInt(one);
        if(oneInt<10){
            one="0"+number.get(random1);
        }

        Random random2 = new Random();
        int random3 = random2.nextInt(numberSize-0+1);
        String two = number.get(random3);
        int twoInt = Integer.parseInt(two);
        if(twoInt<10){
            two="0"+number.get(random3);
        }

        Random random4 = new Random();
        int random5 = random4.nextInt(numberSize-0+1);
        String three = number.get(random5);
        int threeInt = Integer.parseInt(three);
        if(threeInt<10){
            three="0"+number.get(random5);
        }

        Random random6 = new Random();
        int random7 = random6.nextInt(numberSize-0+1);
        String four = number.get(random7);
        int fourInt = Integer.parseInt(four);
        if(fourInt<10){
            four="0"+number.get(random7);
        }

        String numberPhone = "06."+one+"."+two+"."+three+"."+four;

        return numberPhone;
    }

    public static int getChildren(){
        int children = randomBetween(0,5);

        return children;
    }

    public static Boolean getContact(){
        Boolean contact = Math.random()<0.5;

        return contact;
    }

    public static int getPro(){
        int pro = randomBetween(1,6);

        return pro;
    }

    public static int getPerso(){
        int perso = randomBetween(1,3);

        return perso;
    }

}

