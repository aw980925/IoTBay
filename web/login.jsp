<%--
    Document   : login.jsp
    Created on : 28/04/2020, 9:07:01 PM
    Author     : 13093950 Heeyoon Koo
--%>
<%@page import ="uts.isd.model.User" %>
<%@page import ="uts.isd.dao.*" %>
<%@page import ="uts.isd.controller.*" %>
<%@page import="java.util.HashMap" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css">
        <script type ="text/javascript" src="js/script.js"></script>
        <title>Login Form</title>
    </head>
    <body onload="startTime()">
        <div><span class="time" id="time"></span></div>
        <% 
        String existErr = (String) session.getAttribute("existErr");
        String emailErr = (String) session.getAttribute("emailErr");
        String passErr = (String) session.getAttribute("passErr");
        %>
        <div class="header">
           <h1>IoT Bay Sign In</h1>
        </div>
        <div class="top">
            <a href="index.jsp">Index</a>
            <a href="register.jsp">Register</a>

        </div>

        <h3> Sign In <span class="message"><%=(existErr != null? existErr: "")%></span></h3>
        
        <form action ="LoginServlet" method="post">
        <table>

            <tr>
		<th>User Email </th>
                <td><input type="text" placeholder="<%=(emailErr != null ? emailErr:"Enter email") %>" name="email" required></td>
	    </tr>

            <tr>
		<th>Password</th>
		<td><input type="password" placeholder="<%=(passErr != null ? passErr:"Enter password") %>" name="password" required></td>
            </tr>
            <tr>
                <td><a href="CancelServlet" class="button">Cancel</a></td>
                   
                <td><input type="submit"  value="Login" ></td>
            </tr>

          
            
        </table>
        </form>

    </body>
</html>
