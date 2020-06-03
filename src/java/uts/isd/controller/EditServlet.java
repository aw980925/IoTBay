/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import uts.isd.dao.DBManager;
import uts.isd.model.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yoonkoo
 */

public class EditServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public EditServlet() throws ClassNotFoundException, SQLException {
    super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        //fields
        int id = Integer.parseInt(request.getParameter("id"));
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobileNum = request.getParameter("mobileNum");
        String address = request.getParameter("address");
        Validator validator = new Validator();
        
        User user = null;
        validator.clear(session);
        
        if (!validator.validateEmail(email)) {
            // set incorrect email error to the session 
            session.setAttribute("emailErr", "Error: Email format incorrect");
            // redirect user back to the login.jsp     
            request.getRequestDispatcher("edit.jsp").include(request, response);
        } 
        else if (!validator.validatePassword(password)) {
            // set incorrect password error to the session 
            session.setAttribute("passErr", "Requires at least 6 characters including upper or lower alpha and digit");
            // redirect user back to the login.jsp 
            request.getRequestDispatcher("edit.jsp").include(request, response);
        } 
     
        else {
            
             try {
                 user = manager.findId(id);
                
                 if(user != null){
                     
                manager.updateUser(id, fName, lName, email, password, mobileNum, address);
                user = manager.findId(id);
                session.setAttribute("user",user);
                session.setAttribute("updated","your info has been updated!");
                request.getRequestDispatcher("welcome.jsp").include(request, response);
                
                 }
                 else
                 {
                     session.setAttribute("exceptionErr", "User already existed");
                     request.getRequestDispatcher("register.jsp").include(request, response);
                 }
            } catch (SQLException ex) {
                // exception message if adding customer fails
                session.setAttribute("exceptionErr", "Registration failed");
                request.getRequestDispatcher("register.jsp").include(request, response);
            }
             
             
           
       }
    }
        
        
        
    
}
