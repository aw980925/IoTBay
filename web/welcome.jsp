<%-- 
    Document   : welcome
    Created on : 30/04/2020, 11:36:28 PM
    Author     : 13093950 Heeyoon Koo
--%>
<%@page import ="uts.isd.model.*" %>
<%@page import ="uts.isd.dao.*" %>
<%@page import ="uts.isd.controller.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css">
        <script type ="text/javascript" src="js/script.js"></script>
        <title>Welcome Page</title>
    </head>
    <body>
        <div class="header">
            <h1>IoT Bay</h1>
        </div>	
        
        <div class="top">
            <a href="index.jsp">Index</a>
            <a href="logout.jsp">Logout</a>
            <a href="main.jsp">Main</a>
        </div>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            String fName = request.getParameter("fName");
            String lName = request.getParameter("lName");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String mobileNum = request.getParameter("mobileNum");
            String address = request.getParameter("address"); 
            String usertype = request.getParameter("usertype");
            boolean active = Boolean.parseBoolean(request.getParameter("active"));
           
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
                            <th>User Type: </th>
                        </tr>
                    
                        <tr>
                            <td><%= fName %> </td>
                            <td><%= lName %> </td>
                            <td><%= password %></td>
                            <td><%= email %></td>
                            <td><%= mobileNum %></td>
                            <td><%= address %></td>
                            <td><%= usertype %></td>
                        </tr>
                    
          
            </table>
        
        <%  
          User user = new User(id,fName,lName,password,email,mobileNum,address,usertype,active);
          session.setAttribute("user", user);
        %>
        
    </body>
</html>
