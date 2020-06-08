<%-- 
    Document   : edit
    Created on : 27/05/2020, 2:46:40 PM
    Author     : yoonkoo
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
       
        <title>Home Page</title>
        
    </head>
    <body onload="startTime()">
        <div><span class ="time" id="time"></span></div>
         <%
           int id = Integer.parseInt(request.getParameter("id"));
        String emailErr = (String) session.getAttribute("emailErr");
        String passErr = (String) session.getAttribute("passErr");
       
        %>
        <div class="top">
            <a class="button" href="MainServlet?id=<%=id%>"> Main</a>
            
            <a href="LogoutServlet?userId=<%=id%>">Logout</a>
            
        </div>
        
        <h1> Edit User Information: </sapn></h1>
  <form method="post" action="EditServlet?id=<%=id%>">
        
        <h3> Edit Profile</h3>
        <table>
            <tr>
                <th>User ID: </th>
                <td> <%=id%> </td>
            </tr>
            <tr>
		<th>First Name</th>
		<td><input type="text" placeholder="Enter your first name" name="fName"></td>
	    </tr>
            
            <tr>
                <th>Last Name</th>
		<td><input type="text" placeholder="Enter your last name"name="lName"></td>
            </tr>
            <tr>
		<th>Password</th>
		<td><input type="password" placeholder="<%=(passErr != null ? passErr:"Enter your password") %>" name="password"></td>
            </tr>
            <tr>
                <th>Email</td>
                <td><input type="text" placeholder="<%=(emailErr != null ? emailErr:"Enter your email") %>" name="email"></td>
            </tr>
            <tr>
		<th>Mobile Number</th>
		<td><input type="text" placeholder="Enter your mobile number"name="mobileNum"></td>
            </tr>
            <tr>
                <th>Address</th>
                <td><input type="text" placeholder="Enter your address" name="address"></td>
            </tr>
            
            <tr>
                <td colspan="2"> <input type="submit" value="Edit Profile" >
                    <a href="welcome.jsp">Cancel</a>
                </td>
            </tr>
    </body>
</html>

