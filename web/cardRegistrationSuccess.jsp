<%-- 
    Document   : paymentInfoSuccess
    Created on : 06/06/2020, 11:29:18 PM
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
        String cardNumber = request.getParameter("cardNumber");
        String expiresOn = request.getParameter("expiresOn");
        String cvvNumber = request.getParameter("cvvNumber");
      
    %>

    <body>
        <div class="header">
           <h1>IoT Bay</h1>
        </div>
        
         <div class="center">
            <h2> Registration Success</h2>  
        <table>
                    
                        <tr>
                            <td>Card Number : </td>
                            <td><%=cardNumber%></td>
                         </tr>
                         <tr>
                             <td>Expire Date : </td>
                             <td><%=expiresOn%></td>
                         </tr>
                     
                         <tr>
                             <td>CVV Number : </td>
                             <td><%=cvvNumber%></td>
                         </tr>
                         
                         <tr>
                             <td colspan="2">Go to welcome page: 
                             <a href="welcome.jsp">Click here</a></td>
                         </tr>
                           
                       </table>
         </div>
    </body>
</html>
