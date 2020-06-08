<%--
    To do:
    login time ->history db
    logout time ->history db
    profile.jsp ->user info and login and out time
--%>
<%@page import="uts.isd.controller.ConnServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css">
        <script type ="text/javascript" src="js/script.js"></script>
        <title>Login Form</title>
    </head>
    <body onload="startTime()">
        <div><span class="time" id="time"></span></div>
        <% 
        String existErr = (String) session.getAttribute("existErr");
        String emailErr = (String) session.getAttribute("emailErr");
        String passErr = (String) session.getAttribute("passErr");
        %>
        <div class="header">
            <h1><a href="index.jsp">IoT Bay</a></h1>
        </div>
        <div class="top">
            <a href="index.jsp">Index</a>
            <a href="register.jsp">Register</a>

        </div>

        <h3> Sign In <span><%=(existErr != null? existErr: "")%></span></h3>
        
        <form action ="LoginServlet" method="post">
        <table>

            <tr>
		<th>User Email </th>
                <td><input type="text" placeholder="<%=(emailErr != null ? emailErr:"Enter email") %>" name="email" value="john.smith@uts.edu.au"></td>
	    </tr>

            <tr>
		<th>Password</th>
		<td><input type="password" placeholder="<%=(passErr != null ? passErr:"Enter password") %>" name="password" value="BA99342bob" ></td>
            </tr>
            <tr>
                <td colspan="2"><input id='btn2' type="submit" value="Sign In" >
                <a class='btn' style="text-decoration:none" href="index.jsp">Cancel</a></td>
                   
                
            </tr>

          
            
        </table>
        </form>
        
    </body>
</html>
