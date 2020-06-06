package uts.isd.dao;

import uts.isd.model.Payment;
import java.sql.*;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class PaymentDBManager {

private Statement pay;
   
public PaymentDBManager(Connection conn) throws SQLException {       
   pay = conn.createStatement();   
}

//Find user by email and password in the database   
public Payment findPayment(String paymentID, String password) throws SQLException {       
   //setup the select sql query string       
   //execute this query using the statement field       
   //add the results to a ResultSet       
   //search the ResultSet for a user using the parameters               
   return null;   
}

//Add a user-data into the database   
public void addPayment(String email, String name, String password, String gender, String favcol) throws SQLException {                   //code for add-operation       
  pay.executeUpdate("sql query");   

}

//update a user details in the database   
public void updatePayment( String email, String name, String password, String gender, String favcol) throws SQLException {       
   //code for update-operation   

}       

//delete a user from the database   
public void deletePayment(String email) throws SQLException{       
   //code for delete-operation   

}


}