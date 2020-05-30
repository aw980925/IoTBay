<%-- 
    Document   : main
    Created on : 30/04/2020, 2:41:26 PM
    Author     : 13093950 Heeyoon Koo
--%>

<%@page import="javamodel.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css">
        <title>IoT Bay Main Page</title>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
         %>
         
        <div class="header">
        <h1>IoT Bay Main Page</h1>
        <p style="font-weight: bold; font-size: 20px;"> Hello ${user.fName} </p>
        <p> You are logged in as ${user.email} </p>
        </div>

        <div class="top">
        <a href="index.jsp">Index</a>
        <a href="logout.jsp">Logout</a>
        </div>
         
    </body>
</html>
