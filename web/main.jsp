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
            <!--<a href="index.jsp">Index</a>-->
            <a href="login.jsp">Login</a>
            <!--<a href="welcome.jsp">See my profile & Payment Information</a>-->
        </div>
  
         <div>
             <h2>Item list</h2>
         </div>
        <p> welcome to main page </p>
        <form action="MainServlet?id=<%=id%>" method="post">
            <p>Your user id <%=id%></p>
        </form>
        <a href="LogoutServlet">logout</a>
        
        <jsp:include page="productList.jsp" flush="true" />
    </body>
</html>
