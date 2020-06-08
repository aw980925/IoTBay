<%-- 
    Document   : index
    Created on : 2020. 6. 7, 오후 9:52:27
    Author     : heeseong
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="uts.isd.model.Product"%>
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
        <title>Admin Page</title>
        <link rel="stylesheet" href="stylesheet.css">
    </head>
    <body>

        <div class="header">
            <h1><a href="main-admin.jsp">IoT Bay</a></h1>
        </div>
        <div>
            <a href="main-admin.jsp">Main</a>
            <a href="addProduct.jsp">Add Products</a>
            <a href="LogoutServlet?userId=${user.id}">Logout</a>
            
        </div>
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
