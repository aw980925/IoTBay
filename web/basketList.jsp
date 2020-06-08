<%-- 
    Document   : basketList
    Created on : 08/06/2020, 3:13:30 PM
    Author     : aaron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>



<table>
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Order Quantity</th>
                    <th>Order Price</th>
                    <th>New Quantity</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody> 
            
            <c:forEach items="${displayBasket}" var="displayBasket">
            <tr> 
                <td>${displayBasket.productID}</td> 
                <td>${displayBasket.orderQty}</td> 
                <td>${displayBasket.orderPrice}</td>
                <td><input type="number" placeholder="Enter quantity" name="orderQuantity"></td>
                <td><a class=" button" href ="/UpdateOrderLineServlet"> Update </a>
                <td><a class=" button" href ="/DeleteOrderLineServlet"> Delete </a>    
            </tr> 
            </c:forEach>
           
            </tbody>
        </table>