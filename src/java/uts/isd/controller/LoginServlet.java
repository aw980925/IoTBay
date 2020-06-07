/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;
     
import uts.isd.dao.DBManager;
import uts.isd.model.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.dao.DBLogsManager;


public class LoginServlet extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
    
     public LoginServlet() {
        super();
    }
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    }   

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //retrieve the session
        HttpSession session = request.getSession();
        //an instance of the validator
        Validator validator = new Validator();
      
       
        //get email and password 
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        //db manager
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        User user = null;
  
        // incorrect email
        if(!validator.validateEmail(email)){
            session.setAttribute("emailErr","Error: Email format incorrect");
            request.getRequestDispatcher("login.jsp").include(request,response);
            
        } 
        // incorrect password
        else if (!validator.validatePassword(password)){
            
            session.setAttribute("passErr","Error: Password format incorrect");
            request.getRequestDispatcher("login.jsp").include(request,response);
        } 
        
        else { 
            try {
                user = manager.findUser(email, password);
                
                //if user found
                if(user != null ){
                    //HttpSession session = request.getSession(true);
                    session.setAttribute("user",user);
                   user.setActive(true); // user's active
                   int userId = user.getId();
                   String usertype = user.getUsertype();
                   manager.addUserLog(userId, "Login");
                   // response.sendRedirect("index.jsp");
                   if(usertype.equals("Staff")){
                    request.getRequestDispatcher("/admin/index.jsp").forward(request,response);
                   }
                   if(usertype.equals("Customer")){
                      request.getRequestDispatcher("welcome.jsp").forward(request,response);
                   }
                  
                } else {
                   session.setAttribute("existErr","User does not exist in the Database !");
                    request.getRequestDispatcher("login.jsp").include(request,response);
                }
              
            } catch(SQLException | NullPointerException ex){
                System.out.println(ex.getMessage() == null? "User does not exist": "welcome");
                
            }
        }       
    }
    
  
}
