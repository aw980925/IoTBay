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
        <title>IoT Bay Registration Form</title>
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body onload="startTime()">
        <div><span class="time" id="time"></span></div>

        <%
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String exceptionErr = (String) session.getAttribute("exceptionErr");
        %>

        <div class="header">
            <h1>IoT Bay Sign Up</h1>
        </div>	
        <div class="top">
            <a href="index.jsp">Index</a>
            <a href="login.jsp">Login</a>
        </div>
        <form method="post" action="RegisterServlet">

            <h3> Registration Form </h3>
            <table>

                <tr>
                    <th>First Name</th>
                    <td><input type="text" placeholder="Enter your first name" name="fName"></td>
                </tr>

                <tr>
                    <th>Last Name</th>
                    <td><input type="text" placeholder="Enter your last name"name="lName"></td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td><input type="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" name="password"></td>
                </tr>
                <tr>
                    <th>Email</td>
                    <td><input type="text" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" name="email"></td>
                </tr>
                <tr>
                    <th>Mobile Number</th>
                    <td><input type="text" placeholder="Enter your mobile number"name="mobileNum"></td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td><input type="text" placeholder="Enter your address" name="address"></td>
                </tr>

                <tr>
                    <td colspan="2"> <input id="btn2" type="submit" value="Sign Up" >
                        <a class="btn" style="text-decoration:none" href="index.jsp">Cancel</a>
                    </td>
                </tr>

            </table>

            <p><%=(exceptionErr != null ? exceptionErr : "")%></p>

        </form>

    </body>
</html>
