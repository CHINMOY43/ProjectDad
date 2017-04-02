
package JDBC;
import JDBC.DAOLayer;
import java.sql.*;
import javax.sql.*;


public class CheckCredential 
    {
    
     public static ResultSet CheckDetails(String Name,String Password, String Role)
        {
         int i=0;
         ResultSet rs=null;
         try{
                 Connection con=DAOLayer.getCon();
                    if(con!=null)
                    {   String query="select * from login";
                        Statement s=con.createStatement();
                        rs=s.executeQuery(query);
                        
                        if(rs!=null)
                        { 
                            return rs;                         
                            }
                        else
                        {
                          System.out.println("Something went wrong, Please try again!!");
                            }
                    }
                }
         
         catch(Exception e)
            {}
         return rs;
        }
    }
