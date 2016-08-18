<%-- 
    Document   : ShopBooks
    Created on : May 23, 2016, 7:25:36 PM
    Author     : Navneet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
        <link rel="stylesheet" href="main.css" type="text/css"/>
        <title>Shop Books</title>
    </head>
    
    
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
        <div class="container"> 
            <c:import url="/header.jsp"/>
        </div>
        <hr>
        
        <div class="container"> 
            <div class="form-group">
            <h3 style="background-color:goldenrod">Hi <span>${sessionScope.user.fname}</span>, search here...</h3>
            </div>
        </div>
            
        <div class="container"> 
            <div class="form-group">    
            <form class="form-horizontal" role="form" style="width:500px" action="SearchBookServlet" method="post">        
                <input type="hidden" name="action" value="search">
            
            <div class="form-group">
                <label class="control-label col-sm-2">Title</label>
                <div class="col-sm-10" >
                    <input class="form-control" type="text" name="title">
                </div>
            </div>
            
            <div class="form-group">
                <label class="control-label col-sm-2">Author</label>
                <div class="col-sm-10" >
                    <input class="form-control" type="text" name="author">
                </div>
            </div>
            
            <div class="form-group" class="col-sm-6">
                <input style="font-family: cursive;align-content: flex-end" type="submit" value="Search Now..." >
                <input type=button onClick="parent.location='Logout.jsp'" value='Logout'></br>
            </div>
            </form>
            </div>
        </div>
            
        <hr>
        <div class="container"> 
            <div class="form-group">
                <c:import url="/footer.jsp"/>
            </div>
        </div>
    </body>
</html>
