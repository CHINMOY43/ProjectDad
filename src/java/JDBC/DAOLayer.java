/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
package JDBC;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.*;
import java.util.*;
import static JDBC.DAOLayer.con;

public class DAOLayer 

    {
    
     public static Connection con=null;
     public static int UserID=0;
     static {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectDad","root","password");
                        }
                catch(Exception e)
                   {
                    System.out.println("Exception is: "+e);
                        }
                 }
            
    public static Connection getCon()
            {
             return con;
                }
     
         
    

    public static int insert(String Name,String Password,String Role,String Gender)
        {
            int i=0;
            System.out.println("We are bluffing you");
             try{
                       String query="insert into login values(UserID,'"+Name+"','"+Password+"','"+Role+"','"+Gender+"')";
                       Statement s=con.createStatement();
                       i=s.executeUpdate(query);
                       
                       if(i==1)
                            {System.out.println("Successfully updated");
                                 }
                       else
                            {System.out.println("Sorry, we could not process your request");
                    
                                 }
                    }
             
             catch(Exception e)
                {
                    System.out.println("Exception: "+e);
                    }
             return i;
            }
       
        }