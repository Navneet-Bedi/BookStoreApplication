/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import static java.nio.file.Files.size;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sanaali
 */
@WebServlet(urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {

   
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyServlet at " + request.getContextPath() + "</h1>");
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
            doPost(request,response);
// processRequest(request, response);
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
        
        String url="/index.jsp";
        try {
            Statement stmt;
            Connection con;
            String host = "jdbc:mysql://localhost:3306/cs3520";
            String uName = "root";
            String pswd="root";
            int r=0;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(host, uName, pswd);
            
                String query = "select * " +
                    "from " + "user";
                stmt = con.createStatement();           
                ResultSet rs;
                rs = stmt.executeQuery(query);
                HttpSession session=request.getSession();
                url="/index.jsp";
                String action = request.getParameter("action");
                System.out.println("action is : " + action);
                if(action.equals("add"))
                {
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");

                    while (rs.next()) {
                String dbemail = rs.getString("email");
                String dbpwd = rs.getString("password");
                if(email.equals(dbemail) && password.equals(dbpwd))
                {
                    r=0;
                    String dbaddr = rs.getString("address");
                    String ph = rs.getString("phone");
                    String fname = rs.getString("firstName");
                    String lname = rs.getString("lastName");
                     User user= new User(email,password,dbaddr,fname,lname,ph);
                    session.setAttribute("user", user);
                    if(dbemail.equals("admin@abc.com") && dbpwd.equals("admin")){
                                    
                        url="/StockDetails.jsp";
                      }
                    else{
                    request.setAttribute("user",user);
                    url="/Hello.jsp";
                    }
                    
                    
                    
                }
                else r=1;
                   
                    
                    
                }
                
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       getServletContext().getRequestDispatcher(url).forward(request, response);
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
