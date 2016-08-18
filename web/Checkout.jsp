<%-- 
    Document   : Checkout
    Created on : May 23, 2016, 7:19:25 PM
    Author     : Navneet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="main.css" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        
        <table>
            <tr>
                
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Quantity</th>
                
            </tr>
        
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:import url="/header.jsp"/>
        <hr>
        
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
                    
                </tr>
            </c:forEach>
        </table></br>
        <p>User Details</p></br>
        <span> First Name: ${sessionScope.user.fname}</span></br>
        <span> Last Name: ${sessionScope.user.lname}</span></br>
        <span> Email: ${sessionScope.user.email}</span></br>
        <span> Phone: ${sessionScope.user.ph}</span></br>
        </br>
        <span>User Address for Delivery : ${sessionScope.user.addr}</span>
        <br/><br/><input type=button onClick="parent.location='Thankyou.jsp'" value='Deliver'>
        <input type=button onClick="parent.location='Logout.jsp'" value='Logout'></br>
    </body>
</html>
