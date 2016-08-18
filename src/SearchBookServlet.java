

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
 * @author Deepa
 */

@WebServlet(name = "SearchBookServlet", urlPatterns = {"/SearchBookServlet"})
public class SearchBookServlet extends HttpServlet {

    public static List<BookBean> bookList=new ArrayList<BookBean>();;
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
        
        String title;
        String author;
        int size=0;
        String url="/ShopBooks.jsp";
        String action = request.getParameter("action");
        if(action.equals("search")){
            title=request.getParameter("title");
            author=request.getParameter("author");
                           
            try {
                   Class.forName("com.mysql.jdbc.Driver");
                   con = DriverManager.getConnection(host, uName, pswd);
                   String query = "select * from books";
                   
                   stmt = con.createStatement();
                   ResultSet rs;
                   rs = stmt.executeQuery(query);
                    if(rs==null){
                       url="/index.jsp"; 
                    }
                   
                   while(rs.next()){                                          
                       b_title=rs.getString("title");
                       b_author=rs.getString("author");
                       if(author.equals(b_author)||title.equals(b_title))
                       {
                       b_title=rs.getString("title");
                       b_author=rs.getString("author");
                       b_category=rs.getString("category");
                       b_price=rs.getInt("price");
                        bookList.add(new BookBean(b_title,b_author,b_category,b_price));
                        url="/SearchResults.jsp";
                       }
                    
                   }
            size=bookList.size(); 
            request.setAttribute("author", author);
            }
            catch (SQLException|ClassNotFoundException ex) {
               
           }
        }
        request.setAttribute("list",bookList);
        request.setAttribute("results",size);
        
        
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
