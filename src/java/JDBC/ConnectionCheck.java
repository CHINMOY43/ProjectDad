/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */

import JDBC.DAOLayer;
import java.sql.*;

public class ConnectionCheck 

    {
     public static void main(String...s)
        {
         try{
            Connection con=DAOLayer.getCon();
                if(con!=null)
                    {System.out.println("You are connected to the database");
                    
                    }
                
                else
                    {System.out.println("Connection to database failed. Please proceed with correct credentials");}
            }
         catch(Exception e)
            {System.out.println("Exception is: "+e);}
         }
    }
    
