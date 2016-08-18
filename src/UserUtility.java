/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sanaali
 */
public class UserUtility {
   
    static Statement stmt;
    static Connection con;
    static String host = "jdbc:mysql://localhost:3306/cs3520";
        static String uName = "root";    
        static String pswd="root";
   
    
     public static int validateUser(String e, String p)
    {
   
        int r=1;
         try {
        
        con = DriverManager.getConnection(host, uName, pswd);
        String query = "select * " +
                  "from " + "user";

   stmt = con.createStatement();
        ResultSet rs;
        
            rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            String email = rs.getString("email");
            String pwd = rs.getString("password");
            if(e.equals(email) && p.equals(pwd))
            {
                r=0;
            }
            else r=1;

            
    }
        } catch (SQLException ex) {
            Logger.getLogger(UserUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
     
    public static void getUsers()
    {
    
        try {
        String query = "select * " +
                  "from " + "user";

   stmt = con.createStatement();
        ResultSet rs;
        
            rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            String fName = rs.getString("firstName");
            
            System.out.println("Firstname is : " + fName);
            
    }
        } catch (SQLException ex) {
            Logger.getLogger(UserUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
