<%-- 
    Document   : orderHistory
    Created on : 08/06/2020, 6:23:38 PM
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
        <title>Order History</title>
    </head>
    <body onload="startTime(); resetSearch();">
     <%
           int id = Integer.parseInt(request.getParameter("id"));
      %>
        <div class="header">
           <h1>IoT Bay</h1>
        </div>
        <div class="top">
            <a href="welcome.jsp?id=${user.id}">See my profile & Payment Information</a>
            <a href="main.jsp?id=${user.id}">Main</a>
            <a href="LogoutServlet?userId=${user.id}">logout</a>
        </div>
  
      <p> Order History page </p>
        <form action="MainServlet?id=<%=id%>" method="post">
            <p>Your user id <%=id%></p>
        </form>
        
                <jsp:include page="/ViewOrderServlet?id=${user.id}" flush="true" />
    </body>
</html>
