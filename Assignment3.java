
package JDBC_Assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Assignment3 {
    

    public static Connection getConnection() throws Exception{
      
        try{
            String url = "jdbc:mysql://localhost:3306/sqlandjava";
            String username = "super";
            String password = "admin";
            
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database");
            return conn;
        }catch(Exception e){ System.out.println(e);}
        return null;
    }
    public static void main(String[]args)throws Exception {
        //Get Connection
        Connection conn = getConnection();
        
        //Create statement
        Statement statement = conn.createStatement();
        
        //Execute SQL Query
        
        ResultSet res = statement.executeQuery("select * from people join owners join cars \n" +
"    on owners.person_id = people.person_id && owners.car_id = cars.car_id;");
        
        //Process ResultSet
        while(res.next()){
            System.out.println(res.getString("firstname") + " " + 
                                res.getString("lastname") + " owns a " +
                                res.getString("color") + " " +
                                res.getString("brand"));
        }
    }
}
 