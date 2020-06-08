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
import uts.isd.dao.OrderLineDBManager;
import uts.isd.model.OrderLine;


public class AddOrderLineServlet extends HttpServlet {
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
      
        System.out.println("ㅇㅇㅇㅇ");
        HttpSession session = request.getSession();
        OrderLineDBManager orderLineManager = (OrderLineDBManager) session.getAttribute("orderLineManager");
        //create an instance of the Validator class
        Validator validator = new Validator();

        String productID = request.getParameter("productID");
        int productIDInt = Integer.getInteger(productID);
        String customerID = request.getParameter("customerID");
        int customerIDInt = Integer.parseInt(customerID);
        String orderQty = request.getParameter("orderQty");
        int orderQtyInt = Integer.parseInt(orderQty);
        String price = request.getParameter("productPrice");
        Double priceInt = Double.parseDouble(price);
        priceInt = priceInt * orderQtyInt;
        String AvailableQty = request.getParameter("quantity");
        int AvailableQtyInt = Integer.parseInt(AvailableQty);

        //retrieve the manager instance from session - ConnServlet            
        
               
        
        OrderLine orderLine = null;
        validator.clear(session);
        
        try {
            orderLine = orderLineManager.findOrderLine(customerIDInt);
        } catch (SQLException ex) {
            //Logger.getLogger(AddOrderLineServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if ( orderQtyInt > AvailableQtyInt) {

            session.setAttribute("exceptionQuantityErr", "Order Quantity is bigger than Available stock.");
            request.getRequestDispatcher("productList.jsp").include(request, response);
            System.out.println("stock error");
        }
        
        
        else {
            try {
                orderLineManager.addOrderLine(productIDInt, customerIDInt, orderQtyInt, priceInt );
                request.setAttribute("orderLine", orderLine);
                session.setAttribute("addConfirmation", "Item added to basket");
                request.getRequestDispatcher("productList.jsp").include(request, response);
            } catch (SQLException ex) {
                session.setAttribute("exceptionOrderLineErr", "Submission Failed");
                request.getRequestDispatcher("productList.jsp").include(request, response);
            }
        }
    }
}
    
