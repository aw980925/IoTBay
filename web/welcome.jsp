<%-- 
    Document   : welcome
    Created on : 30/04/2020, 11:36:28 PM
    Author     : 13093950 Heeyoon Koo
--%>
<%@page import="javamodel.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css">
        <title>Welcome Page</title>
    </head>
    <body>
        <div class="header">
            <h1>IoT Bay</h1>
        </div>	
        
        <div class="top">
            <a href="index.html">Index</a>
            <a href="logout.jsp">Logout</a>
            <a href="main.jsp">Main</a>
        </div>
        <%
            String fName = request.getParameter("fName");
            String lName = request.getParameter("lName");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String mobileNum = request.getParameter("mobileNum");
            String address = request.getParameter("address"); 
           
        %>
            <div class="center">
            <h2> Welcome, <%= fName %> </h2>  
            <p> Your information is ... </p>
            </div>
                <table>
                    
                        <tr>
                            <th>First Name: </th>
                            <th>Last Name: </th>
                            <th>Password: </th>
                            <th>Email: </th>
                            <th>Mobile Number: </th>
                            <th>Address: </th>
                        </tr>
                    
                        <tr>
                            <td><%= fName %> </td>
                            <td><%= lName %> </td>
                            <td><%= password %></td>
                            <td><%= email %></td>
                            <td><%= mobileNum %></td>
                            <td><%= address %></td>
                        </tr>
                    
          
            </table>
        
        <%  
          User user = new User(fName,lName,password,email,mobileNum,address);
          session.setAttribute("user", user);
        %>
        
    </body>
</html>
