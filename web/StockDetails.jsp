<%-- 
    Document   : StockDetails
    Created on : May 23, 2016, 7:26:31 PM
    Author     : Navneet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Page</title>
    </head>
    <body>
        <h3>Administrator Book Operations:</h3>
        <form class="form-horizontal" role="form" style="width:500px" action="AdminOperations" method="post"> 
            <input type="hidden" name="action" value="admnOp">
            <input type="hidden" name="action" value="login">
            <input type="radio" name="adminOp" value="view">VIEW<br>
            <input type="radio" name="adminOp" value="add">ADD<br>
            <input type="radio" name="adminOp" value="remove">REMOVE<br>
            <input type="radio" name="adminOp" value="modify">MODIFY<br>
            <div class="form-group" class="col-sm-6">
                </br><input  type="submit" value="Ok" ></br>
                </br><input type=button onClick="parent.location='Logout.jsp'" value='Logout'></br>
            </div>
        </form>
            
    </body>
</html>
