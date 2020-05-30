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
        <script type="text/javascript" src="js/script.js"></script>
        <title>Home Page</title>
        
    </head>
    <body onload="startTime()">
        <div><span class ="time" id="time"></span></div>
        <%
            User user = (User) session.getAttribute("user");
            String updated = (String)session.getAttribute("updated");
        %>
        <div class="top">
            <a class="button" href="MainServlet?email='<%= user.getEmail() %>'&password='<%=user.getPassword()%>'">Main</a>
            <a href="logout.jsp">Logout</a>
            
        </div>
        
        <h1> Edit User Information: <span class="message"><%=(updated != null? updated:"")%></sapn></h1>
        <form method="post" action="UpdatedServlet">
            <table>
                <tr><td>First Name: </td><td><input type="text" name="fName" value="$(user.fName)"></td></tr>
                <tr><td>Last Name: </td><td><input type="text" name="lName" value="$(user.lName)"></td></tr>
                <tr><td>Password: </td><td><input type="text" name="password" value="$(user.password)"></td></tr>
                <tr><td>Email: </td><td><input type="text" name="email" value="$(user.email)"></td></tr>
                <tr><td>Mobile Number: </td><td><input type="text" name="mobileNum" value="$(user.mobileNum)"></td></tr>
                <tr><td>Address: </td><td><input type="text" name="address" value="$(user.address)"></td></tr>
                <tr><td></td>
                    <td>
                        <input class="button" type="submit" value="Update">
                    </td>
                </tr>
            </table>
        </form>
        
    </body>

</html>
