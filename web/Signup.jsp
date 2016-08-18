<%-- 
    Document   : Signup
    Created on : May 23, 2016, 7:26:00 PM
    Author     : Navneet
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <c:import url="/header.jsp"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="main.css" type="text/css"/>
        <title>JSP Page</title>
    </head>
     <h1>Signup</h1>
    <body>
        <form action="SignupServlet" method="post">
            <input type="hidden" name="action" value="sign">
             First Name:<br>
             <input type="text" name="fname" required><br>
                Last Name:<br>
               <input type="text" name="lname" required><br><br>
               Email/Username:<br>
             <input type="text" name="email" required><br>
                Password:<br>
               <input type="password" name="password" required><br><br>
               Address:<br>
             <input type="text" name="address" required><br>
                Phone:<br>
               <input type="text" name="phone" required><br><br>
                <input type="submit" value="Signup!" id="Submit">
                
        </form>
        <input type=button onClick="parent.location='index.jsp'" value='Login'></br>
        <input type=button onClick="parent.location='Logout.jsp'" value='Logout'></br>
    </body>
    <c:import url="/footer.jsp"/>
</html>

