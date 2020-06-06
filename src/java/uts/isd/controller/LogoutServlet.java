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
        int userId =Integer.parseInt(request.getParameter("userId"));
        User user = (User) session.getAttribute("user");
        
        try {
            manager.addUserLog(userId,"Logout");
            user.setActive(false);
           session = request.getSession(false);
            if (session != null) {
            session.removeAttribute("user");
            request.getRequestDispatcher("logout.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}