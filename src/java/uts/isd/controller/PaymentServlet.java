package uts.isd.controller;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.dao.DBPaymentManager;
import uts.isd.model.PaymentVO;

public class PaymentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public PaymentServlet() { super(); }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            DBPaymentManager paymentManager = (DBPaymentManager) session.getAttribute("paymentManager");

            String userId = request.getParameter("userId");
            String exceptionErr = "";
            PaymentVO paymentVO = new PaymentVO();

            if(!"".equals(userId.trim())){
                int intUserId = Integer.parseInt(userId);
                paymentVO = paymentManager.selectPayment(intUserId);
            }

            session.setAttribute("paymentVO", paymentVO);
            session.setAttribute("exceptionErr", exceptionErr);
            request.getRequestDispatcher("payment.jsp").include(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try{
            HttpSession session = request.getSession();
            DBPaymentManager paymentManager = (DBPaymentManager) session.getAttribute("paymentManager");
            Validator validator = new Validator();

            int userId = Integer.parseInt(request.getParameter("userId"));
            String paymentId = request.getParameter("paymentId");
            String orderID = request.getParameter("orderID");
            String amount = request.getParameter("amount");
            

            validator.clear(session);

            if (!validator.validateCardNumber(paymentId)) {
                session.setAttribute("paymentId", "Error: paymentId incorrect");
                request.getRequestDispatcher("cardRegistration.jsp").include(request, response);
            } else if (!validator.validateCardNumber(paymentId+"")) {
                session.setAttribute("orderID", "Error: orderID incorrect");
                request.getRequestDispatcher("cardRegistration.jsp").include(request, response);
            } else if (!validator.validateCardNumber(paymentId+"")) {
                session.setAttribute("amount", "Error: amount incorrect");
                request.getRequestDispatcher("cardRegistration.jsp").include(request, response);
            } else{
                int count = paymentManager.selectPaymentCount(userId);
                
                if(count < 1){
                    PaymentVO paymentVO = new PaymentVO(Integer.parseInt(orderID), userId, Integer.parseInt(amount));
                    paymentManager.insertPayment(paymentVO);
                    request.getRequestDispatcher("paymentSuccess.jsp").forward(request, response);
                }else {
                    session.setAttribute("exceptionErr", "payment Registration failed");
                    request.getRequestDispatcher("payment.jsp").include(request, response);
                }
            }
        }catch(Exception e){}
        
    }
}
