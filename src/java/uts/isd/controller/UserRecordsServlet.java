package uts.isd.controller;

import java.io.IOException;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.dao.DBConnector;
import uts.isd.dao.DBLogsManager;
import uts.isd.model.*;
//import uts.isd.model.iotbay.dao.DBApplicationLogsManager;

public class UserRecordsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DBConnector connector;
    private Connection conn;
    private DBLogsManager logsManager;
    
    public UserRecordsServlet(){
  
    try {
            connector = new DBConnector();
            conn = connector.openConnection();
            logsManager = new DBLogsManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserRecordsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        //DBLogsManager logsManager = (DBLogsManager) session.getAttribute("logsManager");
        //User user = (User) session.getAttribute("user");*/
       
        ArrayList<UserRecords> logs = new ArrayList<UserRecords>();
        String id = request.getParameter("userId");
        if( id != null){
            int userId = Integer.parseInt(id);
   
        try {
                logs = logsManager.findUserLogs(userId);
                if(logs == null){
                    session.setAttribute("LogsResult","No logs exists");
                    request.getRequestDispatcher("userLogs.jsp").include(request, response);
                    
                }
                else{
                     // set the session
                     session.setAttribute("LogsResult","Saved Logs List");
                     session.setAttribute("logs", logs);
                     request.getRequestDispatcher("userLogs.jsp").include(request, response);
                }
            
           
       } catch (SQLException ex) {
           
            session.setAttribute("LogsResult", "No logs exists");
        }
       }
        
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       
       HttpSession session = request.getSession();
      // DBLogsManager logsManager = (DBLogsManager) session.getAttribute("logsManager");
           ArrayList<UserRecords> logs = new ArrayList<UserRecords>();
        // search logs by date
        int userId = Integer.parseInt(request.getParameter("userId"));
        String start = request.getParameter("startDate");
        String end = request.getParameter("endDate");
        
        java.sql.Timestamp startStamp = convertToTimeStamp(start);
        java.sql.Timestamp endStamp = convertToTimeStamp(end);
       
      //  User user = (User) session.getAttribute("user");
       
         if(startStamp != null && endStamp !=null){
       
            try {
                    logs = logsManager.findUserLogs(startStamp,endStamp,userId);             
                    session.setAttribute("LogsResult", "Searched Activity Logs");
                    session.setAttribute("logs", logs);
                    request.getRequestDispatcher("userLogs.jsp").include(request, response);
            } catch (SQLException ex) {
              
                session.setAttribute("SearchErr", "No logs for user exists");
                request.getRequestDispatcher("userLogs.jsp").include(request, response);
                
            }
            
                
         }
          
            // public UserRecords(int logId, int userId, Timestamp timestamp, String description
            
            
        
    }
  

 public java.sql.Timestamp convertToTimeStamp(String date) {
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            Date toDate = formatter.parse(date);

           java.sql.Timestamp timestamp = new java.sql.Timestamp(toDate.getTime());
            
            return timestamp;
        } catch (Exception ex) {
            return null;
        }
    }
}