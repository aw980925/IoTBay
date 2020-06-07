/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

/**
 *
 * @author yoonkoo
 */
  import java.io.IOException;
   import java.sql.Connection;
   import java.sql.SQLException;
   import java.util.logging.Level;
   import java.util.logging.Logger;
   import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import javax.servlet.http.HttpSession;
   import uts.isd.dao.*;

   public class ConnServlet extends HttpServlet {
 
       private DBConnector db;
       private DBManager manager;
       private Connection conn;
       private ProductDBManager productManager;
       private OrderLineDBManager orderLineManager;
       private DBLogsManager logsManager;

       @Override //Create and instance of DBConnector for the deployment session
       public void init() {
           try {
               db = new DBConnector(); //Create a database connection when the application starts
           } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
           }      
       }
      
       @Override //Add the DBConnector, DBManager, Connection instances to the session
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
           response.setContentType("text/html;charset=UTF-8");       
           HttpSession session = request.getSession();
           conn = db.openConnection(); //Create a DB connection      
           try {
               manager = new DBManager(conn); //Create a DB Manager
               logsManager = new DBLogsManager(conn); //Create logsManager
               productManager = new ProductDBManager(conn); // Create a Product DB manager
               
               orderLineManager = new OrderLineDBManager(conn);
               
               
           } catch (SQLException ex) {
               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
           //export the DB manager to the view-session (JSPs)
           session.setAttribute("manager", manager);
           session.setAttribute("logsManager",logsManager);
           session.setAttribute("productManager", productManager);
           session.setAttribute("orderLineManager", orderLineManager);
           
       }   
        
       @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)
        public void destroy() {
           try {
               db.closeConnection(); //close the DB connection once the session is terminated
           } catch (SQLException ex) {
               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   }