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
        <script type ="text/javascript" src="js/script.js"></script>
        <title>IoT Bay Main Page</title>
    </head>
    <body onload="startTime(); resetSearch();">
        <div><span class="time" id="time"></sapn></div>
        <%
            User user = (User)session.getAttribute("user");
         %>
         
        <div class="header">
        <h1>IoT Bay Main Page</h1>
        <p style="font-weight: bold; font-size: 20px;"> Hello ${user.fName} </p>
        <p> You are logged in as ${user.email} </p>
        </div>

        <div class="top">
        <a class="button" href="EditServlet?email='<%=user.getEmail()%>'&password='<%=user.getPassword()%>'"
        <a class="button" href="LogoutController">Logout</a>
        </div>
        <p style="text-align:right;color:#c29100;"><i> You are logged in as ${user.email}</i></p>
        <br><br>
        
        <!-- Find subject, jsp:include page="subjects.jsp flush="true" /> wekk10 demo 6.56
        -->
           
         
    </body>
</html>
