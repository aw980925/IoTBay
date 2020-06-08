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
}