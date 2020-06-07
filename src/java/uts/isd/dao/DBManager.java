/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.dao;

/**
 *
 * @author yoonkoo
 */


import uts.isd.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

public class DBManager {
    
    private Statement st;
    private Connection conn;
    
    
     public DBManager(Connection conn) throws SQLException{
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
  public User findUser(String email, String password) throws SQLException{
        User user = null;
        String query = "SELECT * FROM USERS WHERE EMAIL= '"+email+"' AND PASSWORD= '"+password+"'";
        ResultSet rs = st.executeQuery(query);
    
        
        if(rs!=null){
          //HttpSession sesion = request.getSession(true);
            while(rs.next()){
            String userEmail = rs.getString("email"); //coloum 5
            String userPass = rs.getString("password"); //coloum 4
            
            if(userEmail.equals(email) && userPass.equals(password)){
                
                    int id = rs.getInt("id");
                    String fName= rs.getString("fName");
                    String lName= rs.getString("lName");
                    String mobileNum= rs.getString("mobileNum");
                    String address= rs.getString("address");
                    String usertype = rs.getString("usertype");
                    boolean active = rs.getBoolean("active");
                    
                    user = new User(id,fName,lName,userPass,userEmail,mobileNum,address,usertype,active);
                    return user;
            }
            //if email or password incorrect
            else 
            {
                return user;
            }
            
        }
        
    }
        return user;
  }
public User findEmail(String email) throws SQLException{
        User user = null;
        String query = "SELECT * FROM USERS WHERE EMAIL= '"+email+"'";
        ResultSet rs = st.executeQuery(query);
         if(rs!=null){
          //HttpSession sesion = request.getSession(true);
            while(rs.next()){
            String userEmail = rs.getString("email");
            String password = rs.getString("password");
            int id = rs.getInt("id");
            String fName= rs.getString("fName");
            String lName= rs.getString("lName");
            String mobileNum= rs.getString("mobileNum");
            String address= rs.getString("address");
            String usertype = rs.getString("usertype");
            boolean active = rs.getBoolean("active");
                    
            user = new User(id,fName,lName,password,userEmail,mobileNum,address,usertype,active);
            return user;
            }
        
        
    }return user;
 }
    
    public void addUser(String fName, String lName, String password, String email, String mobileNum, String address) throws SQLException{
       
      String usertype="Customer";
      boolean active = false;
  String query = "INSERT INTO USERS(fName,lName,password,email,mobileNum,address,usertype,active) VALUES (?,?,?,?,?,?,?,?)";
  PreparedStatement ps = conn.prepareStatement(query);
  ps.setString(1,fName);
  ps.setString(2,lName);
  ps.setString(3,password);
  ps.setString(4,email);
  ps.setString(5,mobileNum);
  ps.setString(6,address);
  ps.setString(7,usertype);
  ps.setBoolean(8,active);
 
  ps.executeUpdate();
       //ResultSet rs = st.executeQuery(query);
    }
    
     public ArrayList<User> fetchAll(){
      
      return null;
  }
    
    
    
    
     public User findId(int userId) throws SQLException{
        User user = null;
        String query = "SELECT * FROM USERS WHERE id= "+userId;
        ResultSet rs = st.executeQuery(query);
         if(rs!=null){
          //HttpSession sesion = request.getSession(true);
            while(rs.next()){
            String userEmail = rs.getString("email");
            String password = rs.getString("password");
            int id = rs.getInt("id");
            String fName= rs.getString("fName");
            String lName= rs.getString("lName");
            String mobileNum= rs.getString("mobileNum");
            String address= rs.getString("address");
            String usertype = rs.getString("usertype");
            boolean active = rs.getBoolean("active");
                    
            user = new User(id,fName,lName,password,userEmail,mobileNum,address,usertype,active);
            return user;
            }
        
        
    }return user;
 }
    public void updateUser(int id, String fName, String lName, String password, String email, String mobileNum, String address) throws SQLException{
        User user = null;
        boolean active = false;
        String query = "UPDATE USERS SET fName=?, lName=?, password=?, email=?,"
                + "mobileNum=?, address=? WHERE id=?";
         
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1,fName);
        ps.setString(2,lName);
        ps.setString(3,password);
        ps.setString(4,email);
        ps.setString(5,mobileNum);
        ps.setString(6,address);
        ps.setInt(7, id);
        
        ps.executeUpdate();
        
    }
    public void deleteUserById(int id) throws SQLException{
        String query = "DELETE FROM USERS WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,id);
        ps.executeQuery();
    }
    public void deleteUserByEmail(String email) throws SQLException{
        
        String query = "DELETE FROM USERS WHERE email=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1,email);
        ps.executeQuery();
    }
    public void addUserLog(int userId, String description) throws SQLException {

        String query = "INSERT INTO LOGS (userid, timestamp, description) VALUES (?,?,?)";
        Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, userId);
        ps.setTimestamp(2, timestamp);
        ps.setString(3, description);
        
        ps.executeUpdate();
    }
}