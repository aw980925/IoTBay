<%-- 
    Document   : addProduct
    Created on : 2020. 6. 8, 오후 3:26:57
    Author     : heeseong
--%>
<%@page import ="uts.isd.model.*" %>
<%@page import ="uts.isd.dao.*" %>
<%@page import ="uts.isd.controller.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Product</title>
        <link rel="stylesheet" href="stylesheet.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body onload="startTime()">
        <div><span class="time" id="time"></span></div>
        <div class="header">
            <h1>Add New Product</h1>
        </div>
        <form action="addProductServlet" method="post">
            <table>
                <tbody>
                    <tr>
                        <th>Category ID</th>
                        <td>
                            <select name="categoryID">
                                <option value="1">camera</option>
                                <option value="2">bulb</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Product Type</th>
                        <td><input type='text' name="productType" placeholder="productType"/></td>
                    </tr>
                    <tr>
                        <th>Product Name</th>
                        <td><input type='text' name="productName" placeholder="productName"/></td>
                    </tr>
                    <tr>
                        <th>Product Price</th>
                        <td><input type='text' name="productPrice" placeholder="productName"/></td>
                    </tr>
                    <tr>
                        <th>In stock</th>
                        <td><input type='text' name="status" placeholder="productName"/></td>
                    </tr>
                    <tr>
                        <th>Quantity</th>
                        <td><input type='text' name="quantity" placeholder="productName"/></td>
                    </tr>
                    <tr>
                        <th>Description</th>
                        <td>
                            <textarea name="description" rows="10" cols="30">12345asdeghh</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <a href="main-admin.jsp">Cancel</a>
                            <input type="submit" value="Save" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        
    </body>
</html>