package com.sms.micro;

import java.sql.*;
import java.util.Scanner;

// backend code for data base operations
public interface management {

    default void db_insert(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                    "student_db","7412369");
            Scanner sc = new Scanner(System.in);
            System.out.print("id: ");int id = sc.nextInt();
            System.out.print("\nname: ");String name = sc.next();
            String q = "insert into t1 (id,name) values(?,?)";
            PreparedStatement pst =con.prepareStatement(q);
            pst.setInt(1,id);
            pst.setString(2,name);
            int row = pst.executeUpdate();
            if (row > 0){
                System.out.println("record inserted");
            }else {
                System.out.println("record not inserted!");
            }
        } catch (ClassNotFoundException e2){
            System.out.println(e2);
        }catch (SQLException e1){
            System.out.println("not connected");
        }
    }
    default void db_edit(){
        System.out.println("*************updating items*****************");
        System.out.print("\n\t\t\tselect category\n\t1.dairy\t2.fruits\t3.dessert\t4.vegetables\t5.grains\t6.exit");
        System.out.print("\nEnter table name:");
        Scanner sc=new Scanner(System.in);
        String tname = "test";
        System.out.print("\nEnter item id: ");
        int id = sc.nextInt();
        System.out.println("serching item......");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                    "student_db","7412369");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from " + tname + " where roll=" + id);
            System.out.println(String.format("%-10s","id")+String.format("%-30s","name")+String.format("%-10s","Rate")+String.format("%-10s","price")+String.format("%-10s","Quantity"));
            while (rs.next()){
                int id1 = rs.getInt("roll");
                String    name = rs.getString("NAME");
                System.out.println(String.format("%-10s",id1)+String.format("%-30s",name));
            }
            System.out.print("\n\tpress (1)update and (2)delete ");
            int choice = sc.nextInt();
            //to update record
            if(choice==1) {
                //getting new item data
                System.out.println("updating record in table " + tname);
                System.out.print("\n\tEnter new item name: ");
                String name = sc.next();
                PreparedStatement pst = con.prepareStatement("update "+tname+" set name=?" +
                        " where roll="+id);
                pst.setString(1,name);
                int rows = pst.executeUpdate();
                if (rows == 1) {
                    System.out.println("Record updated successfully");
                }else{
                    System.out.println("Record not updated");
                }
            }
            //TO delete record
            else if(choice==2){
                PreparedStatement pst = con.prepareStatement("delete from "+tname+" where id="+id);
                int rows = pst.executeUpdate();
                if(rows==1) {
                    System.out.println("record deleted successfully");
                }
            }
            else {
                System.out.println("wrong choice!!");
            }
        }catch (SQLException e){
            System.out.println("not connected");
        }catch (ClassNotFoundException e1){
            System.out.println(e1);
        }
    }
//    default String[][] db_fetch(){
//        String[][] data;
//        try{
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE"
//                    ,"student_db","7412369");
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select * from t1");
//            while (rs.next()){
//                int roll = rs.getInt("roll");
//                String name = rs.getString("name");
//                int enroll = rs.getInt("enroll");
//                String branch = rs.getString("name");
//                String year = rs.getString("name");
//                data = new String[][]{String.valueOf(roll), name, enroll, branch, year};
//            }
//        }catch (SQLException e){
//            System.out.println("not connected");
//        }catch (ClassNotFoundException e1){
//            System.out.println(e1);
//        }
//        return
//    }
}
