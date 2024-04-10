package dbConnection;

import java.sql.*;
import java.util.Map;
import java.util.Properties;

import java.util.concurrent.Executor;
 //app- appid appdate drid paitid
  //dr- id name spec
// patient - id name age gender dis
// foreignKey
public class DBConn {
    public static void main(String [] args) throws SQLException
    {
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"dac22","root","root");
String query="select name from employee";
Statement st=conn.createStatement();
ResultSet rst=st.executeQuery(query);
while(rst.next()){
    String nm=rst.getString("name");
    System.out.println(nm);
}
st.close();
conn.close();


    }}
