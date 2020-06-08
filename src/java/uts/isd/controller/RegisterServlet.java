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

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
   
    
    public RegisterServlet(){
    super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //current session
        HttpSession session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("manager");
        //Validator class
        Validator validator = new Validator();
        //fields  
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobileNum = request.getParameter("mobileNum");
        String address = request.getParameter("address");   
        User user = null;
        // clear validator
        validator.clear(session);
        
   
      if (!validator.validateEmail(email)) {
            // set incorrect email error to the session 
            session.setAttribute("emailErr", "Error: Email format incorrect");
            // redirect user back to the login.jsp     
            request.getRequestDispatcher("register.jsp").include(request, response);
        } 
        else if (!validator.validatePassword(password)) {
            // set incorrect password error to the session 
            session.setAttribute("passErr", "Requires at least 6 characters including upper or lower alpha and digit");
            // redirect user back to the login.jsp 
            request.getRequestDispatcher("register.jsp").include(request, response);
        } 
     
        else {
            
             try {
                 //find user by email
                 user = manager.findEmail(email);
                // if user not found (same email does not exist in the database)
                 if(user == null){
                // add User     
                manager.addUser(fName, lName, password, email, mobileNum, address);
                request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
                
                 }
                 // if there is a same email exist in the database
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
