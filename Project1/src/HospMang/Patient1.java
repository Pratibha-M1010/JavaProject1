package HospMang;

import java.sql.*;
import java.util.Scanner;

import static java.sql.DriverManager.getConnection;

public class Patient1 {
    private Connection connection;
   private Scanner sc;

    public Patient1(Connection connection, Scanner sc) {
        this.connection = connection;
        this.sc = sc;
    }
    public void addPatient()throws SQLException {

        String str="Insert into Patient1 values(?,?,?,?,?)" ;
        PreparedStatement preparedStatement=connection.prepareStatement(str);
        System.out.println("enter id " );
        int pid=sc.nextInt();
        System.out.println("name of the patient");
        String pname=sc.next();
        System.out.println(" Patient Age" );
        int age=sc.nextInt();
        System.out.println("gender");
        String geneder=sc.next();
        System.out.println("Disease " );
        String disease=sc.next();
        preparedStatement.setInt(1,pid);
        preparedStatement.setString(2,pname);
        preparedStatement.setInt(3,age);
        preparedStatement.setString(4,geneder);
        preparedStatement.setString(5,disease);
         int rows=preparedStatement.executeUpdate();
         if(rows>0)
         {
             System.out.println("Patient Added succefully");
         }
else{
    System.out.println("Not Added");
         }
    }



    public void viewPatient() throws SQLException {
        String query="select * from Patient1";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from Patient1");
        while(resultSet.next()){
            System.out.println(resultSet.getInt("pid"));
            System.out.println(resultSet.getString("pname"));
            System.out.println(resultSet.getInt("age"));
            System.out.println(resultSet.getString("geneder"));
            System.out.println(resultSet.getString("disease"));





//        String query="select * from Patient1";
//        PreparedStatement preparedStatement=connection.prepareStatement(query);
//       ResultSet resultSet=preparedStatement.executeQuery();
//       System.out.println("Patient Details ...");
//        System.out.print("|--------id------|-----name----|-----age----|----geneder-----| ------disease-----|");
//        while (resultSet.next()){
//
//            int id=resultSet.getInt(1);
//            String name=resultSet.getString(2);
//            int age=resultSet.getInt(3);
//            String gender=resultSet.getString(4);
//            String disease=resultSet.getString(5);
//System.out.print("|--------id------|-----name----|-----age----|----geneder-----| ------disease-----|");
//System.out.printf("|%10s|%10s|%10s|%10s|%10s|" ,id,name,age,gender,disease);


        }

        }


        public boolean varifyPid(int id) throws SQLException {
        String query="select * from Patient1 where id=? ";
PreparedStatement preparedStatement=connection.prepareStatement(query);
preparedStatement.setInt(1,id);
ResultSet resultSet=preparedStatement.executeQuery(); //---excute this query
           if(resultSet.next())
           {
           return true;
           }
        else {
               return false;
           }
        }
        }



