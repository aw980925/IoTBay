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
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String mobileNum = request.getParameter("mobileNum");
        String address = request.getParameter("address");
        
        User user = new User(fName,lName,password,email,mobileNum,address);
        DBManager manager = (DBManager) session.getAttribute("manager");
        try{
            if(user != null){
                session.setAttribute("user",user);
                manager.updateUser(email, fName, lName, password, mobileNum, address);
                session.setAttribute("updated","Update was successful");
                request.getRequestDispatcher("edit.jsp").include(request,response);
                
            } else {
                session.setAttribute("updated","Update was not successful");
                request.getRequestDispatcher("edit.jsp").include(request,response);
                
            }
        } catch(SQLException ex){
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE,null,ex);
            
        }
        response.sendRedirect("edit.jsp");
        
    }
    
}
