<%-- 
    Document   : payment
    Created on : 09/06/2020, 3:06:27 AM
    Author     : parkjunhyun
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
        <title>IoT Bay Payment Information Form</title>
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body onload="startTime()">
        <% 
        String userId = request.getParameter("userId");
        String exceptionErr = (String)session.getAttribute("exceptionErr");
        PaymentVO paymentVO = (PaymentVO)session.getAttribute("paymentVO");
        %>
        <div>
            <span class="time" id="time"></span>
        </div>
        <div class="header">
            <h1>Payment</h1>
        </div>	
        <div class="top">
            <a href="index.jsp">Index</a>   
        </div>
        
        <form method="post" action="PaymentServlet">
            <input type="hidden" id="paymentId" name="paymentId" value="<%=paymentVO.getPaymentID()%>" />
            <h3> Please fill out the form</h3>
            <p>User Id <%=userId%></p>
            <table>
                <tr>
                    <th>User Id</th>
                    <td><input type="text" value="<%=userId%>"name="userId" /></td>
                </tr>
                <tr>
                    <th>Order Id</th>
                    <td><input type="text" placeholder="" name="orderID" value="<%=paymentVO.getOrderID()%>"/></td>
                </tr>
                <tr>
                    <th>Amount</th>
                    <td><input type="text" placeholder="" name="amount" value="<%=paymentVO.getAmount()%>" /></td>
                </tr>
               
                <tr>
                    <td><input type="submit" value="Confirm" /></td>
                    <td><a href="welcome.jsp">Cancel</a></td>
                </tr>
            </table>
            <p><%=(exceptionErr != null ? exceptionErr : "")%></p>
        </form>
    </body>
</html>