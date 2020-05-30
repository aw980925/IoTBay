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


public class LoginServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBManager manager = (DBManager) session.getAttribute("manager");
        User user = null;
        validator.clear(session);
        
        if(!validator.validateEmail(email)){
            session.setAttribute("emailErr","Error: Email format incorrect");
            request.getRequestDispatcher("login.jsp").include(request,response);
            
        } else if (!validator.validatePassword(password)){
            session.setAttribute("passErr","Error: Password format incorrect");
            request.getRequestDispatcher("login.jsp").include(request,response);
        } else { //email and password correct
            try {
                user = manager.findUser(email, password);
                if(user != null ){
                    session.setAttribute("user",user);
                    request.getRequestDispatcher("/main.jsp").include(request,response);
                } else {
                    session.setAttribute("existErr","Student does not exist in the Database!");
                    request.getRequestDispatcher("login.jsp").include(request,response);
                }
              
            } catch(SQLException | NullPointerException ex){
                System.out.println(ex.getMessage() == null? "User does not exist": "welcome");
            }
        }       
    }
    
}
