/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;

/**
 *
 * @author Navneet
 */
@WebServlet(urlPatterns = {"/AddBookToStock"})
public class AddBookToStock extends HttpServlet {

    public List<BookBean> bookList=new ArrayList<BookBean>();;
    private Statement stmt;
    private Connection con;
    private String host = "jdbc:mysql://localhost:3306/cs3520";
    private String uName = "root";
    private String pswd="root";
    private String b_title="";
    private String b_author="";
    private String b_category="";
    private int b_id=0;
    private int b_price=0;
    private int b_qty=0;
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
       
        String url="/FormNewBook.jsp";
        String action = request.getParameter("action");
        if(action.equals("addBook")){ 
            try {
                   Class.forName("com.mysql.jdbc.Driver");
                   con = DriverManager.getConnection(host, uName, pswd);
                   String query;
                   
                   stmt = con.createStatement();
                   ResultSet rs;
                   int rowCnt=0;
                   b_title=request.getParameter("title");
                   b_author=request.getParameter("author");
                   b_category=request.getParameter("category");
                   b_price=Integer.parseInt(request.getParameter("price"));
                   b_qty=Integer.parseInt(request.getParameter("qty"));
                   
                   query = "select * from books";
                   rs = stmt.executeQuery(query);
                     while(rs.next()){  
                         rowCnt++;
                     }
                    
                    b_id=rowCnt+1;
                    query="insert into books (title, author, category, price, qty) values (?,?,?,?,?)";
                    PreparedStatement statement=con.prepareStatement(query);
                    statement.setString(1,b_title);
                    statement.setString(2,b_author);
                    statement.setString(3,b_category);
                    statement.setInt(4,b_price);
                    statement.setInt(5,b_qty);
                    statement.executeUpdate();
                    
                
                   query = "select * from books";
                   rs = stmt.executeQuery(query);
                   while(rs.next()){                                          
                       b_title=rs.getString("title");
                       b_author=rs.getString("author");
                       b_category=rs.getString("category");
                       b_price=rs.getInt("price");
                       b_qty=rs.getInt("qty");
                       bookList.add(new BookBean(b_title,b_author,b_category,b_price,b_qty));
                    url="/AdminSearchResults.jsp";
                   }
            int size=bookList.size(); 
            request.setAttribute("list",bookList);
            request.setAttribute("results",size);
            }
            catch (SQLException|ClassNotFoundException ex) {
               
           }
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
