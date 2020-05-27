<%--
    Document   : login.jsp
    Created on : 28/04/2020, 9:07:01 PM
    Author     : 13093950 Heeyoon Koo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css">
        <title>Login Form</title>
    </head>
    <body>
        <div class="header">
            <h1>IoT Bay Sign In</h1>
        </div>
        <div class="top">
            <a href="index.html">Index</a>
            <a href="register.jsp">Register</a>

        </div>

        <h3> Sign In</h3>
        <form method="post" action="welcome.jsp">
        <table>

            <tr>
		<th>User ID/ Email </th>
		<td><input type="text" placeholder="Enter your email "name="email"></td>
	    </tr>

            <tr>
		<th>Password</th>
		<td><input type="password" placeholder="Enter passworde" name="password"></td>
            </tr>


            <td colspan="2">
                    <input class="button" type="submit" value="Login">
                </td>
            </tr>

        </table>
        </form>

    </body>
</html>
