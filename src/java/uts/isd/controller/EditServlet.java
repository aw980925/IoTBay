/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import uts.isd.dao.DBManager;
import uts.isd.model.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yoonkoo
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password= request.getParameter("password");
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        User user = null;
        try {
            
                user = manager.findUser(email,password);
          
            if(user != null){
                   session.setAttribute("user",user);
                   request.getRequestDispatcher("edit.jsp").include(request, response);
            } else {
                session.setAttribute("existErr", "User does not exist in the Database!");
                request.getRequestDispatcher("edit.jsp").include(request,response);
            }
           
        } catch(SQLException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode()+ " and "+ex.getMessage());
        }
        request.getRequestDispatcher("edit.jsp").include(request,response);
    }
    
}
