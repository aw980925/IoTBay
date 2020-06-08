package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.dao.DBLogsManager;
import uts.isd.dao.DBPaymentManager;
import uts.isd.model.*;

public class PaymentHistoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public PaymentHistoryServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            
            HttpSession session = request.getSession();
            DBPaymentManager paymentManager = (DBPaymentManager) session.getAttribute("paymentManager");
            
            String userId = request.getParameter("userId");
            String exceptionErr = "";
            ArrayList<PaymentVO> resultList = new ArrayList<PaymentVO>();

            if(!"".equals(userId.trim())){
                int intUserId = Integer.parseInt(userId);
          
                resultList = paymentManager.selectPaymentList(intUserId);        
            }
            
            
         
            
            session.setAttribute("resultList", resultList);
            session.setAttribute("exceptionErr", exceptionErr);
            
            request.getRequestDispatcher("paymentHistory.jsp").include(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
    
}
