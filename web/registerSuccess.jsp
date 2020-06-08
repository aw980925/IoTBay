<%-- 
    Document   : registerSuccess
    Created on : 03/06/2020, 3:21:49 PM
    Author     : yoonkoo
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
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String email = request.getParameter("email");
        String mobileNum = request.getParameter("mobileNum");
        String address = request.getParameter("address");
        
    %>
    <body>
        <div class="header">
           <h1>IoT Bay</h1>
        </div>
        
         <div class="center">
            <h2>Registration Success</h2>  
        <table>
                    
                        <tr>
                            <td>First Name: </td>
                            <td><%=fName%></td>
                         </tr>
                         <tr>
                             <td>Last Name: </td>
                             <td><%=lName%></td>
                         </tr>
                     
                         <tr>
                             <td>Email: </td>
                             <td><%=email%></td>
                         </tr>
                         <tr>
                             <td>Mobile number: </td>
                             <td><%=mobileNum%></td>
                         </tr>
                         <tr>
                             <td>Address: </td>
                             <td><%=address%></td>
                         </tr>
                         <tr>
                             <td colspan="2">Go to login page: 
                             <a style="text-decoration:none" href="login.jsp">Click here</a></td>
                         </tr>
                           
                       </table>
         </div>
    </body>
</html>

