package employe.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {


    Connection connection;
    Statement statement;


    public conn() {


//        database Connection from workbench
        try{
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","Maurya");
           statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
