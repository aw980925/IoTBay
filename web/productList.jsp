<%-- 
    Document   : productList
    Created on : 05/06/2020, 3:06:19 PM
    Author     : Hyungju
--%>

<%@page import="uts.isd.model.Product"%>
<%@page import="java.util.ArrayList"%>
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
        <%
           // Customer customer = (Customer)session.getAttribute("customer");
        %>
        <table>
            <thead>
                <tr>
                    <th>Category ID</th>
                    <th>Product ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Available Quantity</th>
                </tr>
            </thead>
            <tbody>
            <% ArrayList<Product> productList =  (ArrayList<Product>) session.getAttribute("Product");
                    for(Product p:productList){%> 
     
            <tr> 
                <td><%=p.getCategoryID()%></td> 
                <td><%=p.getProductID()%></td> 
                <td><%=p.getProductName()%></td> 
                <td><%=p.getProductPrice()%></td>
                <td><%=p.getDescription()%></td>
                <td><%=p.getStatus()%></td>
                <td><%=p.getQuantity()%></td>
            </tr> 
            <%}%> 
            
            </tbody>
        </table>
    </body>
</html>