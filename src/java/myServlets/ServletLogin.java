
package myServlets;

import JDBC.EnterUserDetail;
import JDBC.DAOLayer.*;
import static JDBC.DAOLayer.con;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class ServletLogin extends HttpServlet {

   
    public static void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {   
                         
             Connection con=null; 
             int flag=0,i=0,UserID=1;
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            
            out.println("<head>");
                out.println("<link rel=stylesheet type=text/css href=./newcss.css>");
                out.println("<title>ServletLogin</title>");   
            out.println("</head>");
            
            out.println("<body>");
            out.println("<div id=header>");
            out.println("<h1>User SignUp Status</h2>");
            out.println("</div>");            
            
            out.println("<div id=body>");
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectDad","root","password");
            //out.println(con);
            if(con!=null)
                {
                 flag=1;
                    }
       
            if(flag==1)
                {
                 out.println("<h2>Database Connection: SUCCESS</h2>");
                             String Name=request.getParameter("NewUser");
                             String Password=request.getParameter("NewUserPassword");
                             String Role=request.getParameter("Role");
                             String Gender=request.getParameter("Gender"); 
                             if(Password!=null)
                             {String query="insert into login values(UserID,'"+Name+"','"+Password+"','"+Role+"','"+Gender+"')";
                             Statement s=con.createStatement();
                             i=s.executeUpdate(query);}
                            
                             if(i==1)
                                {
                                 out.println("<h3>We welcome you to our family</h3>");
                                 out.println("<a href=http://localhost:8080/Project_Dad/LoginPage.html>Login to your account now</a>");
                                }
                             else
                                {
                                 out.println("<h2>Sorry, We could not get you there</h2>");
                                 out.println("<a href=http://localhost:8080/Project_Dad/WelcomePage.html>Try Signing up again</a>");
                                }
                 
                    }
            if(flag!=1)
                {out.println("<h2>Database Connection: FAIL</h2>");
                 out.println("<h3>Please contact your admin</h3>");
                        }
                
           
            out.println("</div>");
            
            out.println("<div id=footer>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
            }
            
        catch(Exception e)
                    {}
        
        }
        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

