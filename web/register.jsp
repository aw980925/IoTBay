<%-- 
    Document   : register
    Created on : 29/04/2020, 12:46:27 AM
    Author     : 13093950 Heeyoon Koo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css">
        <title>IoT Bay Registration Form</title>
    </head>
    <body>
        <div class="header">
            <h1>IoT Bay Sign Up</h1>
        </div>	
        <div class="top">
            <a href="index.html">Index</a>
            <a href="login.jsp">Login</a>
        </div>
        <form method="post" action="welcome.jsp">
        
        <h3> Registration Form</h3>
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
		<td><input type="password" placeholder="Enter your password" name="password"></td>
            </tr>
            <tr>
                <th>Email</td>
                <td><input type="text" placeholder="Enter your email" name="email"></td>
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
                <td colspan="2"> <input type="submit" value="sign up" ></td>
            </tr>
        </table>
        
        </form>
        	
    </body>
</html>
