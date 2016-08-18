<%-- 
    Document   : TableOfContents
    Created on : May 23, 2016, 7:27:00 PM
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
    <body>
        <br>
        <br>        
        <table>
    <!-- here should go some titles... -->
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Price</th>
    </tr>
    <c:forEach begin="0" end= "${ no }" step="1" varStatus="loopCounter" var="item" items="${ItemList}" >
    <tr>
        <td>
            <c:out value="${item.itemId}" />
        </td>
        <td>
            <c:out value="${item.itemName}" />
        </td>
        <td>
            <c:out value="${item.itemPrice}" />
        </td>

    </tr>
    </c:forEach>
</table>
        
       
    </body>
   
    <c:import url="/footer.jsp"/>
</html>

