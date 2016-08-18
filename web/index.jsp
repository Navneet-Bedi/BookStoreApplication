<%-- 
    Document   : index
    Created on : May 23, 2016, 7:23:22 PM
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
     <h1>Landing Page</h1>
    <body>
        <form action="MyServlet" method="post">
            <input type="hidden" name="action" value="add">
             Email:<br>
             <input type="text" name="email" required><br>
                Password:<br>
               <input type="password" name="password" required><br><br>
                <input type="submit" value="Submit" id="Submit">
                <br/><br/><input type=button onClick="parent.location='Signup.jsp'" value='SignUp'>
        </form>
    </body>
    <c:import url="/footer.jsp"/>
</html>

