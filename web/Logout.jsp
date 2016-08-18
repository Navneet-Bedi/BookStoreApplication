<%-- 
    Document   : Logout
    Created on : May 23, 2016, 7:23:54 PM
    Author     : Navneet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="LogoutServlet" method="get">
            <input type="hidden" name="action" value="logout">
        <p> Are you sure you want to Logout? </p>
        <input type="submit" value="Logout" id="Submit">
                <br/><br/><input type=button onClick="parent.location='Hello.jsp'" value='Goto HomePage'>
         </form>
                </body>
</html>

