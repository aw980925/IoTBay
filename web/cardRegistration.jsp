<%-- 
    Document   : paymentInfo.java
    Created on : 06/06/2020, 5:52:31 PM
    Author     : parkjunhyun
--%>

<%-- 
  Registeration page for customer
  user(id,fname,lname,pasword,email,mobilenum,address,customer)
  userType must be set as customer as staff added by administrator (using sql)
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
        <div><span class="time" id="time"></span></div>
        
        <% 
        String userId = request.getParameter("userId");
        String cardNumberErr = (String) session.getAttribute("cardNumberErr");
        String expiresOnErr = (String) session.getAttribute("expiresOnErr");
        String cvvNumberErr = (String)session.getAttribute("cvvNumberErr");
        String exceptionErr = (String)session.getAttribute("exceptionErr");
        %>
        
        <div class="header">
            <h1>Payment Detail</h1>
        </div>	
        <div class="top">
            <a href="index.jsp">Index</a>   
        </div>
        <form method="post" action="CardServlet">
        
        <h3> Please fill out the form</h3>
        <p>User Id <%=userId%></p>
        <table>
            
            <th>User Id</th>
            <td><input type="text" value="<%=userId%>"name="userId"></td>
            <tr>
		<th>Card Number</th>
		<td><input type="text" placeholder="<%=(cardNumberErr != null ? cardNumberErr:"Enter Card Number") %>" name="cardNumber"></td>
            </tr>
        
            <tr>
		<th>Expire Date</th>
		<td><input type="text" placeholder="<%=(expiresOnErr != null ? expiresOnErr:"Enter Expire Date") %>" name="expiresOn"></td>
            </tr>
            
             <tr>
		<th>CVV Number</th>
		<td><input type="text" placeholder="<%=(cvvNumberErr != null ? cvvNumberErr:"Enter three CVV Number") %>" name="cvvNumber"></td>
            </tr>

            <tr>
                <td colspan="2"><input type="submit" value="Confirm" ></td>
                <td><a href="index.jsp">Cancel</a></td>
                
            </tr>
          
        </table>
               
                    <p><%=(exceptionErr != null ? exceptionErr : "")%></p>
                
        </form>
        	
    </body>
</html>