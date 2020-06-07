<%-- 
    Document   : basket
    Created on : 07/06/2020, 2:26:59 AM
    Author     : aaron
--%>
<%@page import ="uts.isd.model.*" %>
<%@page import ="uts.isd.dao.*" %>
<%@page import ="uts.isd.controller.*" %>
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
      %>
        <div class="header">
           <h1>IoT Bay</h1>
        </div>
        <div class="top">
            <a href="welcome.jsp">See my profile & Payment Information</a>
            <a href="basket.jsp">Check basket</a>
            <a href="/LogoutServlet">logout</a>
        </div>
  
      <p> Basket page </p>
        <form action="MainServlet?id=<%=id%>" method="post">
            <p>Your user id <%=id%></p>
        </form>
        // List of added items.
        // Delete, update the quantity of the item
        // Total amount
        // Check payment
        // Check shipment
        // orderline items
        // orderpage , order history
        
        <a class="button" href="basket.jsp">Add items in the basket</a>
        
    </body>
</html>