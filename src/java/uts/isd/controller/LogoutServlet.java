package uts.isd.controller;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import javax.servlet.*;
import javax.servlet.http.*;
import uts.isd.dao.DBManager;
import uts.isd.model.User;
 

public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LogoutServlet() {
        super();
       
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        //fields
        int userId =Integer.parseInt(request.getParameter("userId"));
        User user = (User) session.getAttribute("user");
        
        try {
            // save logout time into the USERS table
            manager.addUserLog(userId,"Logout");
            // set user's active status as false
            user.setActive(false);
           
            if (session != null) {
             //remove session attribute
            session.removeAttribute("user");
            session.invalidate();
            //if it successes go to logout.jsp
            request.getRequestDispatcher("logout.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}