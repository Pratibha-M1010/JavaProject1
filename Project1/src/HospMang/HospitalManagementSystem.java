package HospMang;

import javax.print.Doc;
import java.sql.*;
import java.util.Scanner;

public class HospitalManagementSystem {
public static void bookAppointment(Patient1 patient, Doctor doctor, Connection connection,Scanner scanner) throws SQLException {
System.out.println("enter  patient id");
int id=scanner.nextInt();
    System.out.println("enter Doctor id ");
int did=scanner.nextInt();
    System.out.println("enter appointment Id  ");
    int app_id=scanner.nextInt();
    System.out.println("enter appointment Date y-m-d ");
    String date=scanner.next();
    if(patient.varifyPid(id) && doctor.verifyDrid(did))
    {
    if(DoctorAvailability (did,date,connection))
        {
            String query="insert into Appointment(app_id,patient_id,Doctor_id,date)  values(?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,app_id);
            preparedStatement.setInt(2,id);
            preparedStatement.setInt(3,did);
            preparedStatement.setString(4,date);
            int i=preparedStatement.executeUpdate();
            if(i>0)
            {
                System.out.println(" Appointment Booked Sucessfully");
            }
            else
            {
                System.out.println("Not Booked");
            }
        }

    }
    else{
        System.out.println("Invalid Detailas..........");
    }
}

public static boolean DoctorAvailability(int drID,String date ,Connection connection) throws SQLException {

    String query="select Count(*) from appointment where drid =? and date=?  ";

PreparedStatement preparedStatement=connection.prepareStatement(query);
preparedStatement.setInt(1,drID);
preparedStatement.setString(2,date);
    ResultSet resultSet=preparedStatement.executeQuery(); //---excute this query


if(resultSet.next()) {
    int a = resultSet.getInt(1);
    if (a == 0) {
        return true;
    }
    else {
        return false;
    }
}
return false;
}

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"Hospital_Management","root","root");
        Scanner scanner = new Scanner(System.in);
        Patient1 p=new Patient1(connection,scanner);
        Doctor d=new Doctor(connection);
        while(true)
        {
            System.out.println("Enter your patients..." );
            System.out.println("1.Patient Add..." );
            System.out.println("2.view patients ...");
            System.out.println("3.view doctors..,");
            System.out.println("4.Book appointment");
            int a= scanner.nextInt();
            switch(a){
                case 1:
                    p.addPatient();
                    break;

                case 2:
                    p.viewPatient();
                    break;
                case 3:
                    d.viewDoctor();
                    break;
                    case 4:
                        HospitalManagementSystem.bookAppointment(p,d,connection,scanner);
                    break;

            }

        }
    }
}