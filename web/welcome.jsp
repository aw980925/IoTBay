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
             String deleteErr = (String)session.getAttribute("deleteErr");
        %>
        <div class="header">
            <h1>IoT Bay</h1>
        </div>	
        
        <div class="top">
            <a href="LogoutServlet?userId=${user.id}">Logout</a>
            <a href="main.jsp?id=${user.id}">Main</a>
        </div>
            <h2> User Information</h2>
            <p sytle= "color:red;"><span><%=(updated != null? updated:"")%></span></p>
            <p sytle= "color:red;"><span><%=(deleteErr != null? deleteErr:"")%></span></p>
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
                             <td><a style="text-decoration:none" class="btn5" href="edit.jsp?id=${user.id}">Edit my profile</a></td>
                             <td><a style="text-decoration:none" class="btn5" href="UserRecordsServlet?userId=${user.id}">See my logs history</a></td>
                           
                         </tr>
                         <tr>
                             <td><a style="text-decoration:none" class="btn5" href="cardRegistration.jsp?userId=${user.id}">Update & Edit Payment Information</a></td>
                             <td><a style="text-decoration:none" class="btn5" href="basket.jsp?id=${user.id}">Go to Basket</a></td>
                         </tr>
                         <tr>
                             <td><a style="text-decoration:none" class="btn5" href="orderHistory.jsp?id=${user.id}">See my order history</a></td>
                             <td><a style="text-decoration:none" class="btn5" href="DeleteAccServlet?id=${user.id}">Delete my account</a></td>
                         </tr>
                         <tr>
                             <td><a style="text-decoration:none" class="btn5" href="addUser.jsp?userId=${user.id}">Add new User</a></td>
                             <td><a style="text-decoration:none" class="btn5" href="userList.jsp?id=${user.id}">See user list</a></td>
                         </tr>
                         
                         <tr>
                              <td><a class="button" href="PaymentServlet?userId=${user.id}">payment</a></td>
                             <td><a class="button" href="PaymentHistoryServlet?userId=${user.id}">paymentHistory</a></td>
                         </tr>
                       </table>
    </body>
</html>
