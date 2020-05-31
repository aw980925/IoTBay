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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager {
    
    private Statement st;
    private Connection conn;
    
    public DBManager(Connection conn) throws SQLException{
        st = conn.createStatement();
        this.conn = conn;
    }
    //Read - find a user by email and password
    public User findUser(String email, String password) throws SQLException{
        
        String query = "SELECT * IOTBAY.USERS WHERE EMAIL='"+email+"' AND PASSWORD= '"+password+"'";
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            
            String userEmail = rs.getString(5); //coloum 5
            String userPass = rs.getString(4); //coloum 4
            
            if(userEmail.equals(email) && userPass.equals(password)){
                
                    int id = rs.getInt(1);
                    String fname= rs.getString(2);
                    String lname= rs.getString(3);
                    String mobileNum= rs.getString(6);
                    String address= rs.getString(7);
                    String usertype = rs.getString(8);
                    boolean active = rs.getBoolean(9);
                    
                    return new User(id,fname,lname,userPass,userEmail,mobileNum,address,usertype,active);
            }
            
        }
        throw new SQLException("No such customer exists");
    }
    //Add a user-data into the database    
public void addUser(String fName, String lName, String password, String email, String mobileNum, String address) throws SQLException {                   //code for add-operation        
  String usertype="Customer";
  boolean active = false;
    st.executeUpdate("INSERT INTO IOTBAY.USERS VALUES ('"+fName+"', '"+lName+"', '"+password+"', '"+email+"', '"+mobileNum+"', '"+address+"', '"+usertype+"', '"+active+')');
   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     

}

//update a user details in the database    
public void updateUser(int id,String email,String fName, String lName, String password, String mobileNum, String address) throws SQLException {        
   //code for update-operation   
String query1 = "UPDATE IOTBAY.USERS"+"SET fName ='"+fName+"',lName='"+lName+"',PASSWORD='"+password+"',EMAIL ='"+email+"',MOBILENUM ='"+mobileNum+"',ADDRESS ='"+address+"'";
String query2=" WHERE id ='"+id+"')";
String query = query1+query2;
st.executeUpdate(query);
}       

//delete a user from the database    
public void deleteUser(String email) throws SQLException{        
   //code for delete-operation   
   //DELETE FROM table_name [WHERE Clause]
   
String query = "DELETE FROM IOTBAY.USERS WHERE EMAIL='"+email+"'";
   st.executeUpdate(query);
}
//Fetch All
// id, fname,lname,pwd,email,mobilenum,usertype
public ArrayList<User> fetchAll() throws SQLException{
    String fetch = "select * from IOTBAY.USERS";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<User> temp = new ArrayList();
    
    while(rs.next()){
        int id = rs.getInt(1);
        String fname= rs.getString(2);
        String lname= rs.getString(3);
        String password= rs.getString(4);
        String email= rs.getString(5);
       String mobileNum= rs.getString(6);
       String address= rs.getString(7);
       String usertype = rs.getString(8);
       boolean active = rs.getBoolean(9);
        
        temp.add(new User(id,fname,lname,password,email,mobileNum,address,usertype,active));
    }
    return temp;
}

public boolean checkUser(String email, String password) throws SQLException{
    String fetch = "select * from IOTBAY.USERS where email = '"+email+"'";
    ResultSet rs = st.executeQuery(fetch);
    
    while(rs.next()) {
        String userEmail = rs.getString(5);
        String userPass = rs.getString(4);
        if(userEmail.equals(email) && userPass.equals(password)) {
            return true;
        }
        
    }return false;
}

    
}
