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
import uts.isd.model.Payment;
import uts.isd.dao.DBPaymentManager;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author parkjunhyun
 */
public class PaymentInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
   
    
    public PaymentInfoServlet(){
    super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //current session
        HttpSession session = request.getSession();
        DBPaymentManager paymentManager = (DBPaymentManager)session.getAttribute("paymentManager");
        //Validator class
        Validator validator = new Validator();
        //fields  
        //String paymenttype = request.getParameter("paymenttype");
        String cardNumber = request.getParameter("cardNumber");
        String expiresOn = request.getParameter("expiresOn");
        String cvvNumber = request.getParameter("cvvNumber");

        Payment payment = null;
        validator.clear(session);
        
   
      if (!validator.validateCardNumber(cardNumber)) {
            // set incorrect card number error to the session 
            session.setAttribute("cardNumberErr", "Error: Card number incorrect");
            // redirect user back to the paymentInfo.jsp     
            request.getRequestDispatcher("paymentInfo.jsp").include(request, response);
        } 
            else if (!validator.validateExpiresOn(expiresOn)) {
            // set incorrect expire date error to the session 
            session.setAttribute("expiresOnErr", "Requires only number for the expire date");
            // redirect user back to the paymentInfo.jsp 
            request.getRequestDispatcher("paymentInfo.jsp").include(request, response);
        } 
            else if (!validator.validateCvvNumber(cvvNumber)) {
            // set incorrect cvv number error to the session 
            session.setAttribute("cvvNumberErr", "Requires only number for the cvv number");
            // redirect user back to the paymentInfo.jsp 
            request.getRequestDispatcher("paymentInfo.jsp").include(request, response);
        } 
            
     
        else {
            
         //    try {
              //   payment = paymentManager.findCreditCard(cardNumber);
                
        //         if(payment == null){
                    
            //    paymentManager.addCard(cardNumber, expiresOn, cvvNumber);
        //        request.getRequestDispatcher("paymentInfoSuccess.jsp").forward(request, response);
                
          //       }
         //        else
          //       {
          //           session.setAttribute("exceptionErr", "Card already registered");
         //            request.getRequestDispatcher("paymentInfo.jsp").include(request, response);
            //     }
        //    } catch (SQLException ex) {
                // exception message if adding customer fails
         //       session.setAttribute("exceptionErr", "Card Registration failed");
         //       request.getRequestDispatcher("paymentInfo.jsp").include(request, response);
        //    }
             
             
           
       }
            
    }
}