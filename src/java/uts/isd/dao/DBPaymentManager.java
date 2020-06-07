/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.dao;

/**
 *
 * @author parkjunhyun
 */


import uts.isd.model.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBPaymentManager {
    
    private Statement st;
    private Connection conn;
    
    
     public DBPaymentManager(Connection conn) throws SQLException{
        st = conn.createStatement();
        this.conn = conn;
    
    }
    /*public DBManager() throws ClassNotFoundException, SQLException {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
     conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IoTDB","IoTBay","admin");
     st = conn.createStatement();
    }
    */
    //Read - find a user by email and password

public Payment findCreditCard(String cardNumber) throws SQLException{
        Payment payment = null;
        String query = "SELECT * FROM USERS WHERE EMAIL= '"+cardNumber+"'";
        ResultSet rs = st.executeQuery(query);
         if(rs!=null){
          //HttpSession sesion = request.getSession(true);
            while(rs.next()){
            String userCardNumber = rs.getString("cardNumber");
            String cvvNumber = rs.getString("cvvNumber");
            int id = rs.getInt("id");
            String expiresOn= rs.getString("expiresOn");
            //String paymenttype= rs.getString("paymenttype");
            
                    
            payment = new Payment(id,userCardNumber,cvvNumber,expiresOn);
            return payment;
            }
        
        
    }return payment;
 }
    
    public void addCard(String cardNumber, String expiresOn, String cvvNumber) throws SQLException{
       
      String usertype="Customer";
      //boolean active = false;
  String query = "INSERT INTO USERS(paymenttype,cardNumber,expiresOn,cvvNumber) VALUES (?,?,?,?)";
  PreparedStatement ps = conn.prepareStatement(query);
  //ps.setString(1,paymenttype);
  ps.setString(2,cardNumber);
  ps.setString(3,expiresOn);
  ps.setString(4,cvvNumber);
 
 
  ps.executeUpdate();

  
         
      
  
       //ResultSet rs = st.executeQuery(query);

    }

    public void updateCard(int id, String cardNumber, String expiresOn, String cvvNumber) throws SQLException{
        Payment payment = null;
        //boolean active = false;
        String query = "UPDATE USERS SET fName=?, lName=?, password=?, email=?,"
                + "mobileNum=?, address=? WHERE id=?";
         
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1,cardNumber);
        ps.setString(2,expiresOn);
        ps.setString(3,cvvNumber);
        ps.setInt(4, id);
        
        ps.executeUpdate();
        
    }
    public void deletePaymentDetailById(int id) throws SQLException{
        String query = "DELETE FROM PAYMENT WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,id);
        ps.executeQuery();
    }
    public void deletePaymentDetailByCardNumber(String cardNumber) throws SQLException{
        
        String query = "DELETE FROM PAYMENT WHERE cardNumer=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1,cardNumber);
        ps.executeQuery();
        
        
        
    }
}