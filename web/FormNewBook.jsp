<%-- 
    Document   : FormNewBook
    Created on : May 23, 2016, 7:22:04 PM
    Author     : Navneet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add new book to stock</title>
 `        <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1">  
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
        <link rel="stylesheet" href="main.css" type="text/css"/>
        
    <body>
        <div class="container">  
        <h3>Add new book details here</h3>
        <form class="form-horizontal" role="form" style="width:500px" action="AddBookToStock" method="post">        
            <input type="hidden" name="action" value="addBook">
            
            <div class="form-group">
                <label class="control-label col-sm-2">Title</label>
                <div class="col-sm-10" >
                    <input class="form-control" type="text" name="title" required>
                </div>
            </div>
            
            <div class="form-group">
                <label class="control-label col-sm-2">Author</label>
                <div class="col-sm-10" >
                    <input class="form-control" type="text" name="author" required>
                </div>
            </div>
            
            <div class="form-group">
                <label class="control-label col-sm-2">Category</label>
                <div class="col-sm-10" >
                    <input class="form-control" type="text" name="category" required>
                </div>
            </div>
            
             <div class="form-group">
                <label class="control-label col-sm-2">Price</label>
                <div class="col-sm-10" >
                    <input class="form-control" type="number" name="price" required>
                </div>
            </div>
            
             <div class="form-group">
                <label class="control-label col-sm-2">Quantity</label>
                <div class="col-sm-10" >
                    <input class="form-control" type="number" name="qty" required>
                </div>
            </div>
                        
            <div class="form-group" class="col-sm-6">
                <input style="font-family: cursive;align-content: flex-end" type="submit" value="Add to stock now..." >
                </br><input type=button onClick="parent.location='StockDetails.jsp'" value='Admin Page'></br>
            </div>
        </form>
        </div>
    </body>
</html>

