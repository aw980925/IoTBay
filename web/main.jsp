<%-- 
    Document   : main
    Created on : 30/04/2020, 2:41:26 PM
    Author     : 13093950 Heeyoon Koo
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
        <title>IoT Bay Main Page</title>
    </head>
    <body onload="startTime(); resetSearch();">
     <%
           int id = Integer.parseInt(request.getParameter("id"));
      %>
         <div class="header">
           <h1>IoT Bay</h1>
        </div>
        <div class="top">
            <a href="/LogoutServlet?id=${user.id}">logout</a>
            <a href="welcome.jsp?id=${user.id}">See my Information</a>
            <a href="basket.jsp?id=${user.id}">Check basket</a>
        </div>
  
      <p> welcome to main page </p>
        <form action="MainServlet?id=<%=id%>" method="post">
            <p>Your user id <%=id%></p>
        </form>
        <jsp:include page="/ViewProductServlet?id=${user.id}" flush="true" />
       
        
    </body>
</html>
