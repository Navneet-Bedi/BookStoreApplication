<%-- 
    Document   : Hello
    Created on : May 23, 2016, 7:22:59 PM
    Author     : Navneet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="main.css" type="text/css"/>
        <title>JSP Page</title>
         <c:import url="/header.jsp"/>
    </head>
    <h1>Welcome! </h1>
    <body>
        <form action="TableServlet" method="post">
            <input type="hidden" name="action" value="join">
        <label>First Name: </label>
        <span>${sessionScope.user.email}</span> <br>
        <label>Last Name: </label>
        <span>${sessionScope.user.password}</span><br>
        <br>
            <input type=button onClick="parent.location='ShopBooks.jsp'" value='Search for Books'>
            <input type=button onClick="parent.location='Logout.jsp'" value='Logout'></br>
    <c:import url="/footer.jsp"/>
            </body>
    
</html>
