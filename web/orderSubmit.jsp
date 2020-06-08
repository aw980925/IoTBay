<%-- 
    Document   : orderSubmit
    Created on : 08/06/2020, 6:16:39 PM
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
        <title>Order submitted</title>
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
            <a href="main.jsp?id=${user.id}">Product Main page</a>
            <a href="orderHistory.jsp?id=${user.id}">Order History</a>
            <a href="LogoutServlet?userId=${user.id}">logout</a>
        </div>
  
      <p> Order submitted page </p>
        <form action="MainServlet?id=<%=id%>" method="post">
            <p>Your user id <%=id%></p>
        </form>
        
                <a class="button" href ="orderHistory.jsp?id=${user.id}">See order history</a>
    </body>
</html>

