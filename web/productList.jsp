<%-- 
    Document   : productList
    Created on : 05/06/2020, 3:06:19 PM
    Author     : Hyungju
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="uts.isd.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="uts.isd.dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Product List</title>
    </head>
    <body>
        
        <%
           Product product = (Product)session.getAttribute("display");
        %>
       
        <table>
            <thead>
                <tr>
                    <th>Select</th>
                    <th>Category ID</th>
                    <th>Product ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Available Quantity</th>
                    <th>Type Quantity</th>
                </tr>
            </thead>
            <tbody> 
            
            <c:forEach items="${display}" var="display">
            <tr> 
                <td><input type="checkbox" name="select" value="s"></td>
                <td>${display.categoryID}</td>
                <td>${display.productID}</td> 
                <td>${display.productName}</td> 
                <td>${display.productPrice}</td>
                <td>${display.description}</td>
                <td>${display.status}</td>
                <td>${display.quantity}</td>
                <td><input type="number" placeholder="Enter quantity" name="qty"></td>
            </tr> 
            </c:forEach>
           
            </tbody>
        </table>
    </body>
</html>