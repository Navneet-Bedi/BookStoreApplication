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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Navneet
 */
public class AdminOperations extends HttpServlet {

    
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminOperations</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminOperations at " + request.getContextPath() + "</h1>");
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
        String title;
        String author;
        int size=0;
        String url="/StockDetails.jsp";
        String action = request.getParameter("action");
        String radioButton=request.getParameter("adminOp");
        if(action.equals("admnOp")){
          if(radioButton.equals("view")){                           
            try {
                   bookList.clear();
                    Class.forName("com.mysql.jdbc.Driver");
                   con = DriverManager.getConnection(host, uName, pswd);
                   String query = "select * from books";
                   
                   stmt = con.createStatement();
                   ResultSet rs;
                   rs = stmt.executeQuery(query);
                    if(rs==null){
                       url="/ShopBooks.jsp"; 
                    }
                   
                   while(rs.next()){                                          
                       b_title=rs.getString("title");
                       b_author=rs.getString("author");
                       b_category=rs.getString("category");
                       b_price=rs.getInt("price");
                       b_qty=rs.getInt("qty");
                       bookList.add(new BookBean(b_title,b_author,b_category,b_price));
                    url="/AdminSearchResults.jsp";
                   }
            size=bookList.size(); 
            request.setAttribute("list",bookList);
             request.setAttribute("results",size);
            }
            catch (SQLException|ClassNotFoundException ex) {
               
           }
        }
        if(radioButton.equals("remove"))
        {
           try {
                   bookList.clear();
                    Class.forName("com.mysql.jdbc.Driver");
                   con = DriverManager.getConnection(host, uName, pswd);
                   String query = "select * from books";
                   
                   stmt = con.createStatement();
                   ResultSet rs;
                   rs = stmt.executeQuery(query);
                    if(rs==null){
                       url="/ShopBooks.jsp"; 
                    }
                   
                   while(rs.next()){                                          
                       b_title=rs.getString("title");
                       b_author=rs.getString("author");
                       b_category=rs.getString("category");
                       b_price=rs.getInt("price");
                       b_qty=rs.getInt("qty");
                       bookList.add(new BookBean(b_title,b_author,b_category,b_price));
                    
                   }
            size=bookList.size(); 
            request.setAttribute("list",bookList);
             request.setAttribute("results",size);
            }
            catch (SQLException|ClassNotFoundException ex) {
               
           }
            url="/DeleteBook.jsp";
        }
        
        if(radioButton.equals("modify"))
        {
           try {
                   bookList.clear();
                    Class.forName("com.mysql.jdbc.Driver");
                   con = DriverManager.getConnection(host, uName, pswd);
                   String query = "select * from books";
                   
                   stmt = con.createStatement();
                   ResultSet rs;
                   rs = stmt.executeQuery(query);
                    while(rs.next()){                                          
                       b_title=rs.getString("title");
                       b_author=rs.getString("author");
                       b_category=rs.getString("category");
                       b_price=rs.getInt("price");
                       b_qty=rs.getInt("qty");
                       bookList.add(new BookBean(b_title,b_author,b_category,b_price));
                    
                   }
            size=bookList.size(); 
            request.setAttribute("list",bookList);
             request.setAttribute("results",size);
            }
            catch (SQLException|ClassNotFoundException ex) {
               
           }
            url="/ModifyBook.jsp";
        }
        if(radioButton.equals("add"))
       {
           url="/FormNewBook.jsp";
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
