<%-- 
    Document   : paymentSuccess
    Created on : 09/06/2020, 3:13:11 AM
    Author     : parkjunhyun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css">
        <title>IOT Bay Register Success</title>
    </head>

    <%
        String orderID = request.getParameter("orderID");
        String amount = request.getParameter("amount");
        String paymentTIme = request.getParameter("paymentTIme");
    %>

    <body>
        <div class="header">
            <h1>IoT Bay</h1>
        </div>

        <div class="center">
            <h2> Registration Success</h2>  
            <table>

                <tr>
                    <td>orderID : </td>
                    <td><%=orderID%></td>
                </tr>
                <tr>
                    <td>amount : </td>
                    <td><%=amount%></td>
                </tr>

                <tr>
                    <td>paymentTIme : </td>
                    <td><%=paymentTIme%></td>
                </tr>
                <tr>
                    <td colspan="2">Go to welcome page: <a href="welcome.jsp">Click here</a></td>
                </tr>
            </table>
        </div>
    </body>
</html>
