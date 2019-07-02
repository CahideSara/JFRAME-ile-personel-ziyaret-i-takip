/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class DatabaseConnection {

    
    public static Connection connectDatabase(){
    	Connection  c=null;
       try{
    	   
        	   Class.forName("org.postgresql.Driver");
      c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/takip","postgres","sara1236");
 
     Statement st=c.createStatement();
     ResultSet rs=st.executeQuery("select*from personel");
     rs.next();
     System.out.println("per_no =  " +  rs.getInt("per_no"));
     System.out.println("sucsessfully");
      return c;
       
       } 
       catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
       }
       
     return c;
    }
    
        public static void main(String[] args){
        DatabaseConnection dc=new DatabaseConnection();
        
        dc.connectDatabase();
    }
    
}