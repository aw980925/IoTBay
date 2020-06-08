package uts.isd.controller;
import uts.isd.dao.DBManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class deleteUserServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;
    
     public deleteUserServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        //field
        int id = Integer.parseInt(request.getParameter("id"));
       
        
             try {
                 //execute delete
                  manager.deleteUserById(id);
                  request.getRequestDispatcher("returnAfterDelete.jsp").forward(request, response);
                 }
                
        
        catch (SQLException ex) {
                // exception message if deleting user fails
                session.setAttribute("deleteErr", "Cannot delete your account");
                request.getRequestDispatcher("welcome.jsp").include(request, response);
            }
    }
      
}
    
