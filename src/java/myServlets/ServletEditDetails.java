
package myServlets;

import JDBC.CheckCredential;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

 
public class ServletEditDetails extends HttpServlet {

    
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
            String UserID=null,Gender=null,Name1=null,Password1=null,Role1=null;
            
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=stylesheet type=text/css href=./newcss.css>");
            out.println("<title>Login</title>");            
            out.println("</head>");
            
            out.println("<body>");
                out.println("<div id=header>");
                out.println("<h1>Edit your Profile</h1>");
               // out.println("</div>");
                
                
                  try{  
                     Class.forName("com.mysql.jdbc.Driver");
                     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectDad","root","password");
                     //out.println(con);
                     //out.println("</div>");
                        if(con!=null)
                            {
                             flag=1;
                                }
                                          
                if(flag==1)
                    {
                     rs=CheckCredential.CheckDetails(Name, Password, Role);
                     out.println(rs);
                     
                     while(rs.next())
                            {
                                //String UserID=rs.getString(1);
                                 Name1=rs.getString(2);
                                 Password1=rs.getString(3);
                                 Role1=rs.getString(4);
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
                     
            
            RequestDispatcher dispatcher=request.getRequestDispatcher("EditDetails.jsp");
                          request.setAttribute("Name",Name1);
                          request.setAttribute("Password",Password1);
                          request.setAttribute("Role",Role1);
                          request.setAttribute("UserID",UserID);
                          dispatcher.forward(request,response); 
                     
             out.println("<div id=body>");       
             out.println("</div>");
             out.println("div id=footer");
             out.println("</div>");
            out.println("</body>");
            out.println("</html>");
                     }
        }}
        catch(Exception e)
            {}
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
