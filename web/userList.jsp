<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@page import="uts.isd.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="uts.isd.dao.*"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Product List</title>
    </head>
    <body>
        <sql:setDataSource var = "snapshot" driver = "org.apache.derby.jdbc.ClientDriver"
                           url = "jdbc:derby://localhost:1527/IoTDB"
                           user = "IoTBay"  password = "admin"/>

        <sql:query dataSource = "${snapshot}" var = "result">
            SELECT * FROM USERS
        </sql:query>

        <h2> List of users in database </h2>
        <div class="top">
            <a href="welcome.jsp">Welcome</a>

        </div>
        <form class="header" action="" method="get">
            <input type="text" name="name" placeholder="Search by name..."/>


        </form>

        <table border = "1" width = "80%">
            <tr>
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Password</th>
                <th>Email</th>
                <th>Mobile Number</th>
                <th>Address</th>
                <th>User Type</th>
                <th></th>
                <th></th>
            </tr>         
            <%
                Statement stat = null;
                ResultSet res = null;

                String query = request.getParameter("name");
                String data;
                if (query != null) {
                    data = "select * from Iotbay where fName like '%" + query + "%' or mobileNum like '%" + query + "%'";
                } else {
                    data = "select * from iotbay order by id desc";
                }


            %>
            <c:forEach var = "row" items = "${result.rows}">
                <tr>
                    <td><c:out value = "${row.id}"/></td>
                    <td><c:out value = "${row.fName}"/></td>
                    <td><c:out value = "${row.lName}"/></td>
                    <td><c:out value = "${row.password}"/></td>
                    <td><c:out value = "${row.email}"/></td>
                    <td><c:out value = "${row.mobileNum}"/></td>
                    <td><c:out value = "${row.address}"/></td>
                    <td><c:out value = "${row.usertype}"/></td>
                    <td><a style="text-decoration:none" class=" btn2 " href="/UpdateUserServlet">Edit</a></td>
                    <td><a style="text-decoration:none" class=" btn4 " href="/DeleteUserServlet">Delete</a></td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>