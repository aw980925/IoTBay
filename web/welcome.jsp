<%-- 
    Document   : welcome
    Created on : 30/04/2020, 11:36:28 PM
    Author     : 13093950 Heeyoon Koo


w
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
            <a href="LogoutServlet?userId=${user.id}">Logout</a>
            <a href="main.jsp?id=${user.id}">Main</a>
        </div>
            <h2> User Information</h2>
            <p><span><%=(updated != null? updated:"")%></span></p>
            
            <div class="center">
            <h2> Welcome, ${user.fName} </h2>  
            <p> Your information is ... </p>
          
            </div>
                
                    
                       <table>
                        <tr>
                            <td>User ID: </td>
                            <td>${user.id}</td>
                         </tr>
                        <tr>
                            <td>First Name: </td>
                            <td>${user.fName}</td>
                         </tr>
                         <tr>
                             <td>Last Name: </td>
                             <td>${user.lName}</td>
                         </tr>
                         <tr>
                             <td>Password: </td>
                             <td>${user.password}</td>
                         </tr>
                         <tr>
                             <td>Email: </td>
                             <td>${user.email}</td>
                         </tr>
                         <tr>
                             <td>Mobile number: </td>
                             <td>${user.mobileNum}</td>
                         </tr>
                         <tr>
                             <td>Address: </td>
                             <td>${user.address}</td>
                         </tr>
                         <tr>
                             <td>User type: </td>
                             <td>${user.usertype}</td>
                         </tr>
                         
                         <tr>
                             <td><a class="button" href="edit.jsp?id=${user.id}">Edit my profile</a></td>
                             <td><a class="button" href="UserRecordsServlet?userId=${user.id}">See my logs history</a></td>
                           
                         </tr>
                         <tr>
                             <td><a class="button" href="userLogs.jsp?id=${user.getId()}">See my order history</a></td>
                             <td><a class="button" href="cardRegistration.jsp?userId=${user.id}">Update & Edit Payment Information</a></td>
                         </tr>

                       </table>
                    
          
        
        
        
    </body>
</html>
