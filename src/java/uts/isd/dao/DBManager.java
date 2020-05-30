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
    public DBManager(Connection conn) throws SQLException{
        st = conn.createStatement();
    }
    //Read - find a user by email and password
    public User findUser(String email, String password) throws SQLException{
        String query = "SELECT * IOTBAY.USERS WHERE EMAIL="+email+"AND PASSWORD= "+password;
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            String userEmail = rs.getString(4); //coloum 2
            String userPass = rs.getString(3); //coloum 3
            if(userEmail.equals(email) && userPass.equals(password)){
                String userName = rs.getString(1)+" "+rs.getString(2);
                String mobileNum= rs.getString(5);
                String address =rs.getString(6);
            }
        }
        return null;
    }
    //Add a user-data into the database    
public void addUser(String fName, String lName, String password, String email, String mobileNum, String address ) throws SQLException {                   //code for add-operation        
  st.executeUpdate("INSERT INTO IOTBay.USERS VALUES ('"+fName+"', '"+lName+"', '"+password+"', '"+email+"', '"+mobileNum+"', '"+address+"')");
   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     

}

//update a user details in the database    
public void updateUser( String email,String fName, String lName, String password, String mobileNum, String address) throws SQLException {        
   //code for update-operation   
String query1 = "UPDATE IOTBAY.USER"+"SET fName ='"+fName+"',lName='"+lName+"',PASSWORD='"+password+"',EMAIL ='"+email+"',MOBILENUM ='"+mobileNum+"',ADDRESS ='"+address+"'";
String query2=" WHERE EMAIL ='"+email+"')";
String query = query1+query2;
st.executeUpdate(query);
}       

//delete a user from the database    
public void deleteUser(String email) throws SQLException{        
   //code for delete-operation   
   //DELETE FROM table_name [WHERE Clause]
   
String query = "DELETE FROM IOTBAY.USER WHERE EMAIL='"+email+"'";
   st.executeUpdate(query);
}
//Fetch All
public ArrayList<User> fetchAll() throws SQLException{
    String fetch = "select * from USERS";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<User> temp = new ArrayList();
    
    while(rs.next()){
        String fname= rs.getString(1);
        String lname= rs.getString(2);
        String password= rs.getString(3);
        String email= rs.getString(4);
       String mobileNum= rs.getString(5);
       String address= rs.getString(6);
        
        temp.add(new User(fname,lname,password,email,mobileNum,address));
    }
    return temp;
}

public boolean checkUser(String email, String password) throws SQLException{
    String fetch = "select * from ISDUSER.USERS where email = '"+email+"'";
    ResultSet rs = st.executeQuery(fetch);
    
    while(rs.next()) {
        String userEmail = rs.getString(4);
        String userPass = rs.getString(3);
        if(userEmail.equals(email) && userPass.equals(password)) {
            return true;
        }
        
    }return false;
}

    
}
