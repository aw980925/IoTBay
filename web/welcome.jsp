<%-- 
    Document   : welcome
    Created on : 30/04/2020, 11:36:28 PM
    Author     : 13093950 Heeyoon Koo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css">
        <title>Welcome Page</title>
    </head>
    <body>
        <%
             String updated = (String)session.getAttribute("updated");
        %>
        <div class="header">
            <h1>IoT Bay</h1>
        </div>	
        
        <div class="top">
            <a href="index.jsp">Index</a>
            <a href="logout.jsp">Logout</a>
        </div>
            <h2> User Information<h2>
            <p><span><%=(updated != null? updated:"")%></span></p>
            
            <div class="center">
            <h2> Welcome, ${user.getfName()} </h2>  
            <p> Your information is ... </p>
          
            </div>
                
                    
                       <table>
                        <tr>
                            <td>User ID: </td>
                            <td>${user.getId()}</td>
                         </tr>
                        <tr>
                            <td>First Name: </td>
                            <td>${user.getfName()}</td>
                         </tr>
                         <tr>
                             <td>Last Name: </td>
                             <td>${user.getlName()}</td>
                         </tr>
                         <tr>
                             <td>Password: </td>
                             <td>${user.getPassword()}</td>
                         </tr>
                         <tr>
                             <td>Email: </td>
                             <td>${user.getEmail()}</td>
                         </tr>
                         <tr>
                             <td>Mobile number: </td>
                             <td>${user.getMobileNum()}</td>
                         </tr>
                         <tr>
                             <td>Address: </td>
                             <td>${user.getAddress()}</td>
                         </tr>
                         <tr>
                             <td>User type: </td>
                             <td>${user.getUsertype()}</td>
                         </tr>
                         
                         <tr>
                             <td><a href="edit.jsp?id=${user.getId()}">Edit my profile</a></td>
                             <td><a href="main.jsp?id=${user.getId()}">Go to main page</a></td>
                         </tr>
                         <tr>
                             <td><a href="userLogs.jsp?id=${user.getId()}">See my login history</a></td>
                             <td><a href="paymentInfo.jsp?id=${user.getId()}">Update & Edit Payment Information</a></td>
                         </tr>
                      
                       </table>
                    
          
        
        
        
    </body>
</html>
