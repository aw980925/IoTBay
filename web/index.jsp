<%-- 
    Document   : index
    Created on : 27/05/2020, 1:37:37 PM
    Author     : yoonkoo
--%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.

author: 13093950 Heeyoon Koo
-->
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import ="uts.isd.model.*" %>
<%@page import ="uts.isd.dao.*" %>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="stylesheet.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title> Home Page</title>
    </head>
<body onload="startTime()">
    <div><span class="time" id="time"></span></div>

<div class="header">
    <h1>IoT Bay</h1>
</div>

<div class="top">
  <a href="login.jsp">Login</a>
  <a href="register.jsp">Register</a>
  <a href="/ViewProductServlet">test product list</a>
  
</div>

    <div class="center">
        <p> <b>welcome to IoT Bay index page</b> </p>
    </div>
    <jsp:include page="/ConnServlet" flush="true" />
</body>


</html>
