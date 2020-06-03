package uts.isd.controller;
 
import java.io.IOException;
 
import javax.servlet.*;
import javax.servlet.http.*;
 

public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LogoutServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
            session.setAttribute("logoutMsg","You have been successfully logged out");
            RequestDispatcher dispatcher = request.getRequestDispatcher("logout.jsp");
            dispatcher.forward(request, response);
        }
    }
}