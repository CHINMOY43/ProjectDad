
package myServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import JDBC.CheckCredential;
import javax.servlet.RequestDispatcher;

public class ServletCheckCredential extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String Name=request.getParameter("CheckUsername");
            String Password=request.getParameter("CheckUserPassword");
            String Role=request.getParameter("CheckRole");
            ResultSet rs=null;
            Connection con=null;
            int i=0,flag=0;
            String UserID=null,Gender=null;
            
                       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=stylesheet type=text/css href=./newcss.css>");
            out.println("<title>Login</title>");            
            out.println("</head>");
            
            out.println("<body>");
                
                
                  try{  
                     Class.forName("com.mysql.jdbc.Driver");
                     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectDad","root","password");
                        if(con!=null)
                            {
                             flag=1;
                                }
                                          
                 
                  if(flag==1)
                    {
                     rs=CheckCredential.CheckDetails(Name, Password, Role);
                     
                     
                     while(rs.next())
                            {
                                //String UserID=rs.getString(1);
                                String Name1=rs.getString(2);
                                String Password1=rs.getString(3);
                                String Role1=rs.getString(4);
                                    if(Name.equals(Name1) && Password.equals(Password1) && Role.equals(Role1))
                                        {
                                            i=1;
                                            break;
                                            }
                                i=0;
                                }
                     if(i==1)
                     {
                        UserID=rs.getString(1);
                        Gender=rs.getString(5);
                     
                            out.println("<div id=header>");
                            out.println("<h1>Welcome "+Name+"</h1>");
                            out.println("</div>");
                            out.println("<div id=body>");
                            out.println("<h2>Your Profile...</h2>");
                            out.println("<h3>UserID :"+UserID+"</h3>");
                            out.println("<h3>Name :"+Name+"</h3>");
                            out.println("<h3>Password :"+Password+"</h3>");
                            out.println("<h3>Role :"+Role+"</h3>");
                            //out.println("<h3>Gender :"+Gender+"</h3>");
                           // out.println("<a href=http://localhost:8080/Project_Dad/ServletEditDetails>Edit Profile</a>");
                            out.println("</div>");
                            out.println("<div id=footer>");
                            out.println("<form action=LoginPage.html>");
                            out.println("<input type=submit value=SIGN-OUT>");
                            out.println("</form>");
                            out.println("</div>");
                            }
                     if(i==0)
                         {
                           out.println("<div id=header>");
                            out.println("<h1>Wrong credentials entered!!!</h1>");
                            out.println("<a href=http://localhost:8080/Project_Dad/LoginPage.html>Try Logging in again</a>");
                            out.println("</div>");
                            out.println("<div id=body>");
                            out.println("</div>");
                            out.println("<div id=footer>");
                            out.println("</div>");
                            
                            }
                        }
                        
                        }
                  catch(Exception e)
                        {}
                
                         
            out.println("</body>");
            
            out.println("</html>");
        }
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
