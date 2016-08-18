<%-- 
    Document   : DeleteItems
    Created on : May 23, 2016, 7:20:43 PM
    Author     : Navneet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="main.css" type="text/css"/>
        <title>Your Cart</title>
    </head>
    <body>
        <form action="DeleteServlet" method="post">
            <input type="hidden" name="action" value="check">       
               
        <h3 style="background: goldenrod">Delete Items from Cart </h3>
        <table>
            <tr>
                
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Delete</th>
            </tr>
        
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:import url="/header.jsp"/>
        <hr>
        
            <br>
            <br>
            <c:forEach items="${sessionScope.cartlist}" var="book">
                <tr>
                    	
                    <td>
                        <c:out value="${book.title}"/>
                    </td>
                    <td>
                        <c:out value="${book.author}"/>
                    </td>
                    <td>
                        <c:out value="${book.price}"/>
                    </td>
                    <td>
                        <c:out value="${book.qty}"/>
                    </td>
                    <td>
    	  		<input type="checkbox" name="delItem" value="${book.title}">
    	  	</td>
                </tr>
            </c:forEach>
            </table>
            <hr>
           
            
             <br/>
            <input type="submit" value="Delete" id="Submit"></br>
             <input type=button onClick="parent.location='Logout.jsp'" value='Logout'></br>
             
            <c:import url="footer.jsp"/>
        </form>
            </body>
    </html>
