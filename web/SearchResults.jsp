<%-- 
    Document   : SearchResults
    Created on : May 23, 2016, 7:25:06 PM
    Author     : Navneet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="main.css" type="text/css"/>
        <title>Your search results</title>
    </head>
    <body>
        <form action="MyCartServlet" method="post">        
                <input type="hidden" name="action" value="cart">
        <h3 style="background: goldenrod">Book search results </h3>
        <table>
            <tr>
                
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Select</th>
            </tr>
        
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:import url="/header.jsp"/>
        <hr>
        <span>Hi ${sessionScope.user.fname}, You have ${requestScope.results} results</span>
            <br>
            <br>
            <c:forEach items="${requestScope.list}" var="book">
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
    	  		<input type="checkbox" name="itemId" value="${book.title}">
    	  	</td>
                </tr>
            </c:forEach>
            </table>
            <hr>
            <br/>
            <input style="font-family: cursive;align-content: flex-end" type="submit" value="Add to Cart" ></br>
            <input type=button onClick="parent.location='Logout.jsp'" value='Logout'></br>
            <c:import url="footer.jsp"/>
        </form>
            </body>
    </html>
