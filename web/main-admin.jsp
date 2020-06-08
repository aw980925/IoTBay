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
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <style>
            .heading{
                text-align: center;
                padding: 50px 0 20px 0;
                font-size: 45px;
            }
            .list{
                padding: 30px 0 !important;
            }
        </style>
        
    </head>
    <body>
 
        <div class=“header">
 <ul class="nav nav-pills justify-content-end list">
            <li class="nav-item">
              <a class="nav-link active" href="main-admin.jsp">Main</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="addProduct.jsp">Add Products</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="LogoutServlet?userId=${user.id}">Logout</a>
            </li>
        </ul>
        <div class="table-responsive-sm">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Category ID</th>
                    <th scope="col">Product ID</th>
                    <th scope="col">Product Type</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Description</th>
                    <th scope="col">Status</th>
                    <th scope="col">Available Quantity</th>
                    <th scope="col">Type Quantity</th>
                    <th scope="col">Add to Basket</th>
                </tr>
            </thead>
        </table>
        </div>
        <jsp:include page="/ConnServlet" flush="true" />
    </body>