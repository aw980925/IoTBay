<%@page import="uts.isd.model.PaymentVO"%>
<%@page import="uts.isd.model.UserRecords"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css">
        <title>IoT Bay Registration Form</title>
    </head>
    <%
        String userId = request.getParameter("userId");
        String LogsResult = request.getParameter("LogsResult");
    %>
    <body onload="startTime()">
        <div><span class="time" id="time"></span></div>
        <p>User ID: <%=userId%></p>
        <div class="header">
            <h1>IoTBay Logs History</h1>
        </div>	
        <div class="top">
            <a href="index.jsp">Index</a>
        </div>
        <h3>User Activity Logs</h3>
        <h4> <%=(LogsResult != null ? LogsResult : "")%> </h4>
        <table>
            <thead>
                <tr>
                    <th>Payment ID</th>
                    <th>ORDER ID</th>
                    <th>TOTAL PRICE</th>
                    <th>TIMESTAMP</th>
                </tr>
            </thead>
            <tbody>
                <% ArrayList<PaymentVO> resultList = (ArrayList<PaymentVO>) session.getAttribute("resultList");
                for (PaymentVO paymentVO : resultList) {%> 
                <tr> 
                    <td><%=paymentVO.getPaymentID()%></td> 
                    <td><%=paymentVO.getOrderID()%></td> 
                    <td><%=paymentVO.getOrderTotal()%></td> 
                    <td><%=paymentVO.getPaymentTime()%></td>
                </tr> 
                <%}%> 
                <tr>
                    <td colspan="4"><a href="welcome.jsp">Cancel</a></td>
                </tr>
            </tbody>
        </table>
</body>
</html>
