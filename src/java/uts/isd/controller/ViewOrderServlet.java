/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.util.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.dao.*;


public class ViewOrderServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           int customerID = 0; // Just default value assigned 
            try {
                customerID = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException e) {
                    // log the error or ignore it
                }
 
        String orderID = request.getParameter("orderID");
        String orderTotal = request.getParameter("orderTotal");
        String orderDate = request.getParameter("orderDate");
        String orderStatus = request.getParameter("orderStatus");
        
                    
        try {
            HttpSession session = request.getSession();
        
           // Validator validator = new Validator();
        
            //9) retrieve the manager instance from session - ConnServlet            
             OrderDBManager orderManager = (OrderDBManager)session.getAttribute("orderManager");
        
            //validator.clear(session);
            
            
            ArrayList<Order> displayOrder = orderManager.fetchOrder(customerID);
            
            request.setAttribute("displayOrder",displayOrder);     
            
            request.getRequestDispatcher("orderList.jsp").include(request, response);
            
            
       } catch (SQLException ex) {
           Logger.getLogger(ViewOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

}