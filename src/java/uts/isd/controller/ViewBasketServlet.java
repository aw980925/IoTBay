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
import uts.isd.model.*;
import uts.isd.dao.*;


public class ViewBasketServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           int customerID = 0; // Just default value assigned 
            try {
                customerID = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException e) {
                    // log the error or ignore it
                }
 
        String productID = request.getParameter("productID");
        String productName = request.getParameter("productName");
        String productPrice = request.getParameter("productPrice");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        String quantity = request.getParameter("quantity");
        String orderQty = request.getParameter("orderQty");
        String ordarPrice= request.getParameter("orderPrice");
                    
        try {
            HttpSession session = request.getSession();
        
           // Validator validator = new Validator();
        
            //9) retrieve the manager instance from session - ConnServlet            
             OrderLineDBManager orderLineManager = (OrderLineDBManager)session.getAttribute("orderLineManager");
        
            //validator.clear(session);
            
            
            ArrayList<OrderLine> displayBasket = orderLineManager.fetchOrderLine(customerID);
            System.out.println("dsdf");
            
            request.setAttribute("displayBasket",displayBasket);     
            
            request.getRequestDispatcher("basketList.jsp").include(request, response);
            
            
       } catch (SQLException ex) {
           Logger.getLogger(ViewProductServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    

    
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
}
}