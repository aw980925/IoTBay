/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

   package uts.isd.controller;

   import java.io.IOException;
   import java.sql.Connection;
   import java.sql.SQLException;
   import java.util.logging.Level;
   import java.util.logging.Logger;
   import javax.servlet.ServletException;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import javax.servlet.http.HttpSession;
   import uts.isd.dao.*;
   import uts.isd.model.*;

public class SearchUserServlet extends HttpServlet{
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
        //1- retrieve the current session
        HttpSession session = request.getSession();
        //2- create an instance of the Validator class    
        Validator validator = new Validator();
        //3- capture the posted email      
        String name = request.getParameter("fName");
        String number = request.getParameter("mobileNum");
        //4- capture the posted password    

        
        User user = null; 
        validator.clear(session);
        
        //5- retrieve the manager instance from session      
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        

        //6- find user by name and number
        
        if(user != null){
            
            session.setAttribute("user", user);
            request.getRequestDispatcher("/admin/index,jsp").include(request,response);
            
        } else {
            session.setAttribute("exitUserErr", "User doesn't exist in the database!");
            request.getRequestDispatcher("/admin/index.jsp").include(request, response);
            
        }
    }
}
