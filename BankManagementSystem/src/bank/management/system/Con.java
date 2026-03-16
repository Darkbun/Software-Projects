package bank.management.system;

import java.sql.*;

public class Con {

    Connection c;  //Create connection
    Statement s;  //Create statement

    public  Con(){
        try{
            c= DriverManager.getConnection("jdbc:mysql:///BankManagementSystem", "root", "PP@123");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }


    }
}
