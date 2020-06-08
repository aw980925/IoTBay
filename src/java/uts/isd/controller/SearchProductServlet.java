/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

   package uts.isd.controller;

   import java.io.IOException;
   import java.sql.Connection;
   import java.sql.SQLException;
import java.util.ArrayList;
   import java.util.logging.Level;
   import java.util.logging.Logger;
   import javax.servlet.ServletException;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import javax.servlet.http.HttpSession;
   import uts.isd.dao.*;
   import uts.isd.model.*;
/**
 *
 * @author heeseong
 */
public class SearchProductServlet extends HttpServlet{
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
        //1- retrieve the current session
        HttpSession session = request.getSession();
        //2- create an instance of the Validator class    
        Validator validator = new Validator();
        //3- capture the posted productName      
        String name = request.getParameter("name");  
        //4- capture the posted productType    
        String type = request.getParameter("type");

        
        Product product = null; 
        validator.clear(session);
        
        try{
        //5- retrieve the manager instance from session      
        ProductDBManager productManager = (ProductDBManager)session.getAttribute("productManager");
        
        //6- find product by name and type
        Product searchedDisplay = productManager.findProduct(name,type);
            
        session.setAttribute("searchedDisplay",searchedDisplay);     

        request.getRequestDispatcher("productList.jsp").include(request, response);
        
        } catch (SQLException ex) {
           Logger.getLogger(SearchProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        if(product != null){
            
            session.setAttribute("product", product);
            request.getRequestDispatcher("productList.jsp").include(request,response);
            
        } else {
            session.setAttribute("exitProductErr", "Product doesn't exist in the database!");
            request.getRequestDispatcher("productList.jsp").include(request, response);
            
        }
    }
}
