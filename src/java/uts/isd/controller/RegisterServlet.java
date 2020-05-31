/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User;
import uts.isd.dao.DBManager;

/**
 *
 * @author Kevin
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //current session
        HttpSession session = request.getSession();
        //Validator class
        Validator validator = new Validator();
        //fields  
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobileNum = request.getParameter("mobileNum");
        String address = request.getParameter("address");
        //5- retrieve the manager instance from session
        DBManager manager = (DBManager)session.getAttribute("manager");
            
        User user = null;
        validator.clear(session);
        
   
       if (!validator.validateEmail(email)) {
            // set incorrect email error to the session 
            session.setAttribute("emailErr", "Error: Email format incorrect");
            // redirect user back to the login.jsp     
            request.getRequestDispatcher("register.jsp").include(request, response);
        } 
        else if (!validator.validatePassword(password)) {
            // set incorrect password error to the session 
            session.setAttribute("passErr", "Error: Must be at least 4 characters long");
            // redirect user back to the login.jsp 
            request.getRequestDispatcher("register.jsp").include(request, response);
        } 
     
        else {     
            try {
            user = manager.findUser(email,password);
            //If user exists
            if (user != null) {
            session.setAttribute("exceptionErr", "User already existed");
            request.getRequestDispatcher("register.jsp").include(request, response);
            }
            //if user does not exist
            else {
                // create new user
              try {
                manager.addUser(fName, lName, email, password, mobileNum, address);
            } catch (SQLException ex) {
                // exception message if adding customer fails
                session.setAttribute("exceptionErr", "Registration failed");
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
            // redirect new user to the welcome.jsp
            request.getRequestDispatcher("welcome.jsp").include(request, response);
   
            }
            } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            
       }
            
    }
}
