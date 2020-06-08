<%-- 
    Document   : productList
    Created on : 05/06/2020, 3:06:19 PM
    Author     : Hyungju
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="uts.isd.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="uts.isd.dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>User List</title>
    </head>
    <body>

        <%
            User user = (User) session.getAttribute("display");
        %>
        <table>
            <div class="header">
                <h1>List of Users</h1>
            </div>
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Password</th>
                    <th>Email</th>
                    <th>Mobile Number</th>
                    <th>Address</th>
                    <th>User Type</th>
                </tr>
            </thead>
            <tbody> 

                <c:forEach items="${display}" var="display">
                    <tr> 
                        <td>${display.id}</td>
                        <td>${display.fName}</td> 
                        <td>${display.lName}</td>
                        <td>${display.password}</td> 
                        <td>${display.email}</td>
                        <td>${display.mobileNum}</td>
                        <td>${display.address}</td>
                        <td>${display.usertype}</td>
                    </tr> 
                </c:forEach>

            </tbody>
        </table>
    </body>
</html>
