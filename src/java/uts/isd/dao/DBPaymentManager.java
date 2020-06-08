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
import uts.isd.model.PaymentVO;
import java.util.ArrayList;
import uts.isd.model.Card;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uts.isd.model.User;

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

  public Card findCreditCard(String cardNumber) throws SQLException{
        Card card = null;
        String query = "SELECT * FROM CARD WHERE cardNumber= '"+cardNumber+"'";
        ResultSet rs = st.executeQuery(query);
    
        
        if(rs!=null){
          //HttpSession sesion = request.getSession(true);
            while(rs.next()){
            String userCardNumber = rs.getString("cardNumber"); //coloum 5
          
            if(userCardNumber.equals(cardNumber)){
                
                    
                    String expiresOn= rs.getString("expiresOn");
                    String cvvNumber= rs.getString("cvvNumber");
                    
                    
       
                    card = new Card(cardNumber, expiresOn, cvvNumber);
                    return card;
            }

            //if email or password incorrect
            else 
            {
                return card;
            }
            
        }
        
    }
        return card;
  }
    public void addCard(int userId,String cardNumber, String expiresOn, String cvvNumber) throws SQLException{
       
      String usertype="Customer";
      //boolean active = false;
  String query = "INSERT INTO CARD (userId,cardNumber,expiresOn,cvvNumber) VALUES (?,?,?,?)";
  PreparedStatement ps = conn.prepareStatement(query);
  ps.setInt(1,userId);
  ps.setString(2,cardNumber);
  ps.setString(3,expiresOn);
  ps.setString(4,cvvNumber);
 
 
  ps.executeUpdate();

  
         
      
  
       //ResultSet rs = st.executeQuery(query);

    }
// INSERT INTO CARD (userId,cardNumber,expiresOn,cvvNumber) VALUES
    public void updateCard(int userId, String cardNumber, String expiresOn, String cvvNumber) throws SQLException{
        Card card = null;
        //boolean active = false;
        String query = "UPDATE CARD SET cardNumber=?, expiresOn=?, cvvNumber=?,"
                + " WHERE userId=?";
         
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1,cardNumber);
        ps.setString(2,expiresOn);
        ps.setString(3,cvvNumber);
        ps.setInt(4, userId);
        
        ps.executeUpdate();
        
    }
    public void deleteCardByUserId(int userId) throws SQLException{
        String query = "DELETE FROM CARD WHERE userId=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,userId);
        ps.executeQuery();
    }
    public void deleteCardlByCardNumber(String cardNumber) throws SQLException{
        
        String query = "DELETE FROM CARD WHERE cardNumer=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1,cardNumber);
        ps.executeQuery();
        
        
        
    }
    
    public PaymentVO selectPayment(int userId) throws SQLException{
        PaymentVO paymentVO = new PaymentVO();
        String sql = "SELECT paymentID, orderID, userId, amount, paymentTime FROM payment WHERE userId = " + userId;
        ResultSet rs = st.executeQuery(sql);
        
        if(rs.next()){
            paymentVO = new PaymentVO(rs.getInt("paymentID"), rs.getInt("orderID"), rs.getInt("userId"), rs.getInt("amount"), rs.getTimestamp("paymentTime"));
        }
        
        return paymentVO;
    }
    
    public ArrayList<PaymentVO> selectPaymentList(int userId) throws SQLException{
        ArrayList<PaymentVO> resultList = new ArrayList<PaymentVO>();
        String sql = "";
        sql += "	SELECT	";
        sql += "	    A.paymentID	";
        sql += "	    , A.orderID	";
        sql += "	    , A.userId	";
        sql += "	    , A.amount	";
        sql += "	    , A.paymentTime	";
        sql += "	    , B.customerID	";
        sql += "	    , B.orderTotal	";
        sql += "	    , B.orderDate	";
        sql += "	    , B.orderStatus	";
        sql += "	FROM PAYMENT A	";
        sql += "	INNER JOIN ORDERS B	";
        sql += "	ON A.USERID = B.customerID	";
        sql += "	WHERE 1=1	";
        sql += "	AND A.USERID =  " + userId;
        
        ResultSet rs = st.executeQuery(sql);
        PaymentVO paymentVO = new PaymentVO();
        
        while(rs.next()){
            paymentVO = new PaymentVO(rs.getInt("paymentID"), rs.getInt("orderID"), rs.getInt("userId"), rs.getInt("amount"), rs.getTimestamp("paymentTime"), 
                    rs.getInt("customerID"), rs.getInt("orderTotal"), rs.getTimestamp("orderDate"), rs.getString("orderStatus"));
            resultList.add(paymentVO);
        }
        
        return resultList;
    }
    
    public int selectPaymentCount(int userId) throws SQLException{
        int count = 0;
        String sql = "SELECT count(*) FROM payment WHERE userId = " + userId;
        
        ResultSet rs = st.executeQuery(sql);
        
        if(rs.next()){
            count = rs.getInt(1);
        }
        
        return count;
    }
    
    public void insertPayment(PaymentVO paymentVO) throws SQLException{
        String sql = "INSERT INTO PAYMENT(orderID, userId, amount, paymentTIme) values(?, ?, ?, CURRENT_TIMESTAMP)";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1, paymentVO.getOrderID());
        ps.setInt(2, paymentVO.getUserId());
        ps.setInt(3, paymentVO.getAmount());
        
        ps.executeUpdate();
    }
    
}