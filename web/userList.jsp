<%-- 
    Document   : userList
    Created on : 08/06/2020, 2:33:14 AM
    Author     : User
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
        <sql:setDataSource
        var="IoTDB"
        driver="org.apache.derby.jdbc.ClientDriver"
        url="jdbc:derby://localhost:1527/IoTDB"
        user="IoTBay" password="admin"/>
        
        <sql:query var="listUsers"   dataSource="${myDS}">
            SELECT * FROM USERS;
        </sql:query>

        <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Password</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Address</th>
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.fName}" /></td> 
                    <td><c:out value="${user.lName}" /></td> 
                    <td><c:out value="${user.password}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.mobileNum}" /></td>
                    <td><c:out value="${user.address}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div> 

    </body>
</html>