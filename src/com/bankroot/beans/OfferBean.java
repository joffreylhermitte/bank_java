package com.bankroot.beans;

import com.bankroot.services.Database;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OfferBean {

    public static List listOfCondition(int id){
        try{
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            ResultSet data = statement.executeQuery("SELECT * FROM product WHERE id='"+id+"'");

            while (data.next()){
                String  description = data.getString("description");
                JSONArray array = new JSONArray(description);
                List<ConditionBean> listeCondition = new ArrayList();

                for(int i=0; i<array.length(); i++){
                    JSONObject object = array.getJSONObject(i);
                    ConditionBean condition = new ConditionBean();

                    condition
                            .setName(object.getString("name"))
                            .setOperator(object.getString("operator"))
                            .setValue(object.getString("value"))
                            .setArgs(object.optString("args",null));


                    listeCondition.add(condition);
                }




                return listeCondition;
            }






        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static JSONArray arrayOfCondition(String id){
        try{
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            ResultSet data = statement.executeQuery("SELECT * FROM product WHERE id='"+id+"'");

            while (data.next()){
                String  description = data.getString("description");
                JSONArray array = new JSONArray(description);


                return array;
            }






        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static boolean getOffer(List<ConditionBean> conditions,CustomerBean customer){
        Boolean valid = true;
        for (ConditionBean condition: conditions) {
            try {


                String conditionName = condition.getName();
                String fieldName = ucfirst(conditionName);
                String targetMethod = "get" + fieldName;
                Float testedValue ;


                if ( condition.getArgs() != null )
                {
                    Class[] methodArgs= new Class[1];
                    methodArgs[0] = String.class;
                    Method classMethod = customer.getClass().getMethod(targetMethod, methodArgs);
                    testedValue =  (Float) classMethod.invoke(customer, condition.getArgs());
                }else {
                    Method classMethod = customer.getClass().getMethod(targetMethod);
                    testedValue = (Float)  classMethod.invoke(customer);
                }
                Float targetValue = Float.parseFloat(condition.getValue());
                String operator = (String) condition.getOperator();
                valid = valid && operateur(targetValue, operator, testedValue);



            } catch (Exception e) {
                valid = false;
                e.printStackTrace();

            }
        }


        return valid;
    }

    private static Boolean operateur(Float target, String operator, Float value){
        Boolean isvalid = false;
        switch (operator)
        {
            case ">":
                isvalid = value > target;
                break;
            case "<":
                isvalid = value < target;
                break;
            case "=":
                isvalid = value.equals(target);
                break;
            default:
                isvalid = false;
        }


        return isvalid;
    }

    public static String ucfirst(String chaine){
        return chaine.substring(0, 1).toUpperCase()+ chaine.substring(1).toLowerCase();
    }

    public static void updateOffer(String json, String id){
        Connection connection = Database.getConnection();
        try {
            Statement statement = connection.createStatement();

            ResultSet data = statement.executeQuery("SELECT * FROM product WHERE id='"+id+"'");

            while (data.next()){
                String condition =  data.getString("description");
                if (condition == null){
                    json = "["+json+"]";

                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET description = ? WHERE id = ?");
                    preparedStatement.setString(1, json);
                    preparedStatement.setString(2, id);


                    preparedStatement.executeUpdate();
                }else {
                    // Probleme ici le tableau se ferme pour rajouter le json , il faut rajoutez le tableau directement dans le tableau JSON ( comme dans la mise a jour de condition
                    // condition = "[" +condition + ","+json + "]";

                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET description = ? WHERE id = ?");
                    preparedStatement.setString(1, json);
                    preparedStatement.setString(2, id);
                    preparedStatement.executeUpdate();
                }
            }




        } catch (Exception e) {
            System.err.println(e);
        }
    }


}
