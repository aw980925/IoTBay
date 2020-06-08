/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.*;
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


public class ViewUsersServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        int userid = 0; // Just default value assigned 
            try {
                userid = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException e) {
                    // log the error or ignore it
                }
 
        String id = request.getParameter("id");
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String mobileNum = request.getParameter("mobileNum");  
        String address = request.getParameter("address");
        String usertype = request.getParameter("usertype");
                    
        try {
            HttpSession session = request.getSession();
        
           // Validator validator = new Validator();
        
            //9) retrieve the manager instance from session - ConnServlet            
             DBManager manager = (DBManager)session.getAttribute("manager");
        
            //validator.clear(session);
            
            
            ArrayList<User> user = manager.fetchAll();
            
            request.setAttribute("user",user);     
            
            request.getRequestDispatcher("userList.jsp").include(request, response);
            
            
       } catch (SQLException ex) {
           Logger.getLogger(ViewUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
        
      
   }
   
}