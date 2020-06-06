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
import uts.isd.model.Product;
import uts.isd.dao.ProductDBManager;


public class ViewProductServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        int productID = 0; // Just default value assigned 
            try {
                productID = Integer.parseInt(request.getParameter("productID"));
                } catch (NumberFormatException e) {
                    // log the error or ignore it
                }
 
        int categoryID = Integer.parseInt(request.getParameter("categoryID"));
        String productName = request.getParameter("productName");
        Double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        int quantity = Integer.parseInt(request.getParameter("quantity"));  
                    
        try {
            HttpSession session = request.getSession();
        
            Validator validator = new Validator();
        
            //9) retrieve the manager instance from session - ConnServlet            
             ProductDBManager productManager = (ProductDBManager)session.getAttribute("DBManager");
        
            //validator.clear(session);
            
            
            ArrayList<Product> display = productManager.fetchProduct();
            
            request.setAttribute("display",display);     
            
            request.getRequestDispatcher("main.jsp").include(request, response);
            
            
       } catch (SQLException ex) {
           Logger.getLogger(ViewProductServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
        
      
   }
   
}