<%-- 
    Document   : returnAfterDelete
    Created on : 09/06/2020, 2:46:26 AM
    Author     : User
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
           <p>User has been removed</p> 
        </div>	
        <div class="top">
            <a href="userList.jsp">Return</a>
        </div>
      
        <% session.invalidate(); %>
    </body>
</html>
