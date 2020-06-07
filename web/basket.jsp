<%-- 
    Document   : basket
    Created on : 07/06/2020, 2:26:59 AM
    Author     : aaron
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="uts.isd.model.*"%>
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
        <title>Basket</title>
    </head>
    <body onload="startTime(); resetSearch();">
     <%
           int id = Integer.parseInt(request.getParameter("id"));
           OrderLine orderLine = (OrderLine)session.getAttribute("displayBasket");
      %>
        <div class="header">
           <h1>IoT Bay</h1>
        </div>
        <div class="top">
            <a href="welcome.jsp?id=${user.id}">See my profile & Payment Information</a>
            <a href="main.jsp?id=${user.id}">Main</a>
            <a href="/LogoutServlet?id=${user.id}">logout</a>
        </div>
  
      <p> Basket page </p>
        <form action="MainServlet?id=<%=id%>" method="post">
            <p>Your user id <%=id%></p>
        </form>
        <table>
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Order Quantity</th>
                    <th>Order Price</th>
                    <th>New Quantity</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody> 
            
            <c:forEach items="${displayBasket}" var="displayBasket">
            <tr> 
                <td>${displayBasket.productID}</td> 
                <td>${displayBasket.orderQty}</td> 
                <td>${displayBasket.orderPrice}</td>
                <td><input type="number" placeholder="Enter quantity" name="orderQuantity"></td>
                <td><a class=" button" href ="/UpdateOrderLine"> Update </a>
                <td><a class=" button" href ="/DeleteOrderLine"> Delete </a>    
            </tr> 
            </c:forEach>
           
            </tbody>
        </table>
    </body>
</html>
