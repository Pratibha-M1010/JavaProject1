package HospMang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;

public class demo {
    public static void main(String [] args) throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"Hospital_Management","root","root");
        Scanner scanner = new Scanner(System.in);
        Patient1 p=new Patient1(connection,scanner);
        p.addPatient();
        p.viewPatient();

        Doctor dr=new Doctor(connection);
        dr.viewDoctor();

       // dr.verifyDrid();

}}
