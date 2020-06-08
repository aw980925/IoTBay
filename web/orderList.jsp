<%-- 
    Document   : orderList
    Created on : 09/06/2020, 4:13:03 AM
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
        <script type="text/javascript" src="js/script.js"></script>
        <title>Order History</title>
    </head>
    <body>
        
     <%
           int id = Integer.parseInt(request.getParameter("id"));
           Order order = (Order)session.getAttribute("displayOrder");
      %>
        <form method="get">
        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Client ID</th>
                    <th>Order Total</th>
                    <th>Order Date</th>
                    <th>Order Status</th>
                    <th>0</th>
                </tr>
            </thead>
            <tbody> 
            
            <c:forEach items="${displayOrder}" var="displayOrder">
            <tr> 
                <td>${displayOrder.orderID}</td> 
                <td>${displayOrder.customerID}</td> 
                <td>${displayOrder.orderTotal}</td>
                <td>${displayOrder.orderDate}</td>
                <td>${displayOrder.Status}</td>
                <td><a class=" button" href ="/UpdateOrderServlet"> Update </a></td>
                   
            </tr> 
            </c:forEach>
           
            </tbody>
        </table>
                
</form>
</html>


