
package JDBC;


import java.sql.*;


public class EnterUserDetail 

{
    static int i=0;
    static int UserID=1;
    Connection con=null;
      public static int insert(String Name,String Password,String Role,String Gender)
        {
         
         try{
         Connection con=DAOLayer.getCon();
         if(con!=null)
                {
                          String query="insert into login values(UserID,'"+Name+"','"+Password+"','"+Role+"','"+Gender+"')";
                          Statement s=con.createStatement();
                          i=s.executeUpdate(query);
                          
                    }
                    
                }
         catch(Exception e)
                    {}
         return i;
        }
     
}
