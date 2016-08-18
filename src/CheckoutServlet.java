/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class CheckoutServlet extends HttpServlet {

    private Statement stmt;
    private Connection con;
    private String host = "jdbc:mysql://localhost:3306/cs3520";
    private String uName = "root";
    private String pswd="root";
    private String b_addr="";
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
            out.println("<title>Servlet CheckoutServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutServlet at " + request.getContextPath() + "</h1>");
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
        
        try {
            String url="/Hello.jsp";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(host, uName, pswd);
            
            String query = "select * " +
                    "from " + "user";
            
            stmt = con.createStatement();           
            ResultSet rs;
            HttpSession session= request.getSession();
            rs = stmt.executeQuery(query);
            User user=new User();
            user = (User)session.getAttribute("user");
            String email=user.getEmail();
            request.setAttribute("userEmail",email);
            request.setAttribute("userAddr",user.getAddr());
            url="/Checkout.jsp";
//            while (rs.next()) {
//                String dbemail = rs.getString("email");
//                if(email.equals(dbemail))
//                {
//                    b_addr=rs.getString("address");
//                    request.setAttribute("address", b_addr);
//                url="/Checkout.jsp";
//                }
//                else
//                {
//                     url="/Checkout.jsp";
//                }
//            }
            
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
