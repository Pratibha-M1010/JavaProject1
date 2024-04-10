package HospMang;

import java.sql.*;

public class Doctor {
    Connection connection;

    public Doctor(Connection connection) {
        this.connection = connection;
    }

    public void viewDoctor() throws SQLException {
        String query="select * from Doctor";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
       ResultSet resultSet=preparedStatement.executeQuery();
       System.out.println("Doctor  Details ...");
        System.out.print("|--------drid------|-----drname----|-----department----|");
       while(resultSet.next())
       {
           int id=resultSet.getInt("drid");
            String name=resultSet.getString("drname");
            String



                    dept=resultSet.getString("department");

System.out.printf("|%-10s,%-10s,%-10s|\n",id,name,dept);

       }

    }
public boolean verifyDrid(int id) throws SQLException {
        String query ="select * from Doctor where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
    preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        if(resultSet.next())
        {
            return true;
        }
        else {
            return false;
        }

}

}
