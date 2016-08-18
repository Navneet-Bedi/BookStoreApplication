/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sanaali
 */
public class SignupServlet extends HttpServlet {

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
            out.println("<title>Servlet SignupServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupServlet at " + request.getContextPath() + "</h1>");
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
      
        String url="/index.jsp";
        try {
            //processRequest(request, response);
            
            Statement stmt;
            Connection con;
            String host = "jdbc:mysql://localhost:3306/cs3520";
            String uName = "root";
            String pswd="root";
            int r=0;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(host, uName, pswd);
            
                        
                HttpSession session=request.getSession();
                url="/index.jsp";
                String action = request.getParameter("action");
                System.out.println("action is : " + action);
                if(action == null);
                url="/index.jsp";
                if(action.equals("sign"))
                {
                    
                    String fname = request.getParameter("fname");
                    String lname = request.getParameter("lname");
                    String email = request.getParameter("email");
                    String pwd = request.getParameter("password");
                    String addr = request.getParameter("address");
                    String ph = request.getParameter("phone");
                   
                    //int r = UserUtility.validateUser(email, password);
                    //  UserUtility.getUsers();
                 //   String query = "INSERT INTO user " +
                  // "VALUES ('6',fname,lname,email,pwd, addr, ph,'user')";
                String role="user";
                    String sql="INSERT into user (firstName, lastName, email, password, address, phone, role) values (?,?,?,?,?,?,?)";
                PreparedStatement statement=con.prepareStatement(sql);
            //    statement.setInt(1,6);
                statement.setString(1,fname);
                statement.setString(2,lname);
                statement.setString(3,email);
                statement.setString(4,pwd);
                statement.setString(5,addr);
                statement.setString(6,ph);
                statement.setString(7,role);
                statement.executeUpdate();


                     User user= new User(fname, lname, email, pwd, addr, ph, "user");
                    session.setAttribute("user", user);
                    
                    request.setAttribute("user",user);
                    url="/Hello.jsp";
       
                }
                
        }
         catch (SQLException | ClassNotFoundException ex) {
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
