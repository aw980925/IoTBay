<%-- 
    Document   : logout
    Created on : 30/04/2020, 11:36:21 PM
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
        <title>IoTBay</title>
    </head>
    
        
  <body>
 
      <div class="header">
            <h1>IoT Bay</h1>
           <p>Your account has been successfully deleted! :)</p> 
        </div>	
        <div class="top">
            <a href="index.jsp">Index</a>
            <a href="register.jsp">Register</a>
        </div>
      
        <% session.invalidate(); %>
    </body>
</html>
