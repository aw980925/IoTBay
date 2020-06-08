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
           <h1>IoT Bay</h1>
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
                <td><input type="text" placeholder="<%=(emailErr != null ? emailErr:"Enter email") %>" name="email"></td>
	    </tr>

            <tr>
		<th>Password</th>
		<td><input type="password" placeholder="<%=(passErr != null ? passErr:"Enter password") %>" name="password"></td>
            </tr>
            <tr>
                <td><a style="text-decoration:none" href="index.jsp">Cancel</a></td>
                   
                <td><input type="submit" value="Sign In" ></td>
            </tr>

          
            
        </table>
        </form>
        
    </body>
</html>
