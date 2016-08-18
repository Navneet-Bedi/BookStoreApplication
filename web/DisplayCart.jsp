<%-- 
    Document   : DisplayCart
    Created on : May 23, 2016, 7:21:11 PM
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
        <form action="CheckoutServlet" method="post">
            <input type="hidden" name="action" value="check">       
               
        <h3 style="background: goldenrod">Book search results </h3>
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
        <span> You have ${sessionScope.cart.getTotalItems()} items in your Cart</span>
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
                    
                </tr>
            </c:forEach>
            </table>
            <hr>
           
            <span> Total Price: ${sessionScope.cart.totalPrice()}</span></br>
             <br/>
            <input type="submit" value="Checkout" id="Submit"></br>
             <input type=button onClick="parent.location='Logout.jsp'" value='Logout'></br>
             <input type=button onClick="parent.location='DeleteItems.jsp'" value='Delete Items'></br>
            <c:import url="footer.jsp"/>
        </form>
            </body>
    </html>
