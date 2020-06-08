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
        <!--<link rel="stylesheet" href="stylesheet.css">-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script type="text/javascript" src="js/script.js"></script>
        <style>
            .heading{
                text-align: center;
                padding: 50px 0 20px 0;
                font-size: 45px;
            }
            .list{
                padding: 30px 0 !important;
            }
            table > td:last-child{
                text-align: center !important;
                font-size: 20px !important;
            }
        </style>
    </head>
    <body onload="startTime()">
        <div><span class="time" id="time"></span></div>
        <div class="header">
            <h1 class="heading">Add New Product</h1>
        </div>
        <form action="AddProductServlet" method="post">
            <table class="table">
                <tbody>
                    <tr>
                        <th>Category ID</th>
                        <td>
                            <select class="custom-select" name="categoryID">
                                <option value="1">camera</option>
                                <option value="2">bulb</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Product Type</th>
                        <td><input type='text' name="producttype" placeholder="productType" class="form-control"/></td>
                    </tr>
                    <tr>
                        <th>Product Name</th>
                        <td><input type='text' name="productname" placeholder="productname" class="form-control"/></td>
                    </tr>
                    <tr>
                        <th>Product Price</th>
                        <td><input type='text' name="price" placeholder="price" class="form-control"/></td>
                    </tr>
                    <tr>
                        <th>In stock</th>
                        <td><input type='text' name="status" placeholder="status" class="form-control"/></td>
                    </tr>
                    <tr>
                        <th>Quantity</th>
                        <td><input type='text' name="quantity" placeholder="quantity" class="form-control"/></td>
                    </tr>
                    <tr>
                        <th>Description</th>
                        <td>
                            <div class="form-group">
                              <textarea name="description" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align:center;">
                            <a href="main-admin.jsp" style="margin-right:20px;">Cancel</a>
                            <input type="submit" value="Save" class="btn btn-primary"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        
    </body>
</html>